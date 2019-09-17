package com.tlf.oss.resourceinventory.granite.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ServiceCodeEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.BandwidthName;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.IpType;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.granite.core.utils.RIEntityGraniteUtils;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveServiceCodeDao extends GenericDao {
	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;

	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(),
			String.format(Code.RIGRANITE_003.getDescription(), "Query RetrieveServiceCode"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);

	private static final String ACCESS_TYPE = "accessType";
	private static final String SERVICE_TYPE = "serviceType";
	private static final String BW_NAME = "bwName";
	private static final String SERVICE_CLASS = "serviceClass";

	public ServiceCodeEntity retrieveServiceCode(ResourceInventoryEntity entity) throws OSSBusinessException {

		ServiceCodeEntity serviceCode = mapParameters(entity);

		try {
			TypedQuery<ServiceCodeEntity> query = getEntityManager()
					.createNamedQuery(ServiceCodeEntity.RETRIEVE_SERVICE_CODE_QUERY, ServiceCodeEntity.class);

			query.setParameter(ACCESS_TYPE, "FIBER");
			query.setParameter(SERVICE_TYPE, serviceCode.getServiceType());
			query.setParameter(BW_NAME, serviceCode.getBwName());
			query.setParameter(SERVICE_CLASS, serviceCode.getServiceClass());

			logger.log(OSSLogger.INFO, getlogIn(ServiceCodeEntity.RETRIEVE_SERVICE_CODE_QUERY, query));

			List<ServiceCodeEntity> result = query.getResultList();

			if (null != result && !result.isEmpty()) {
				serviceCode = result.get(0);
				logOut(serviceCode);
			} else {
				logger.log(OSSLogger.INFO, "Código de Serviço não encontrado");

				List<String> list = new ArrayList<>();

				list.add(serviceCode.getServiceType());
				list.add(serviceCode.getBwName());

				if (list.contains("SPEEDY")) {

					list.add(" | IP: ".concat(IpType.retrieveIpTypeByServiceClass(serviceCode.getServiceClass()).get().getType()));

					String falloutMessage = String.format(Message.ERRO_RETRIEVE_SERVICE_CODE.getValue(), list.get(0), list.get(1));

					this.falloutConfig.setErrorCode("-1");
					this.falloutConfig.setErrorMessage(falloutMessage);
					this.falloutConfig.setDetailMessage("-1".concat(";").concat(falloutMessage));

					throw OSSExceptionFactory.getOSSBusinessException(this.falloutConfig);
				}
			}
		} catch (PersistenceException e) {
			logger.error("Error:" + e.getMessage(), e);

			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(),
					String.format(Code.RIGRANITE_002.getMessage(), "Erro ao executar a Query RetrieveServiceCode ",
							e.getMessage()));
		} catch (Exception e) {
			logger.error("Error:" + e.getMessage(), e);

			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(),
					Code.RIGRANITE_999.getMessage());
		}

		return serviceCode;
	}

	private String defineServiceType(Optional<CustomerFacingService> iptv, Optional<CustomerFacingService> voip) {

		StringJoiner serviceType = new StringJoiner("/");
		serviceType.add("SPEEDY");

		if (iptv.isPresent()) {
			serviceType.add("IPTV");
		}

		if (voip.isPresent()) {
			serviceType.add("VOIP");
		}

		return serviceType.toString();
	}

	private IpType defineServiceClass(ResourceInventoryEntity entity) {

		String ipTypeEntity = RIEntityGraniteUtils.retrieveIpType(entity);
		Optional<IpType> ipType = IpType.retrieveIpTypeByType(ipTypeEntity);

		return ipType.isPresent() ? ipType.get() : IpType.DYNAMIC;
	}

	private ServiceCodeEntity mapParameters(ResourceInventoryEntity entity) {

		ServiceCodeEntity serviceCode = new ServiceCodeEntity();

		Optional<CustomerFacingService> broadband = RIEntityGraniteUtils.retrieveBroadband(entity);
		Optional<CustomerFacingService> iptv = RIEntityGraniteUtils.retrieveIptv(entity);
		Optional<CustomerFacingService> voip = RIEntityGraniteUtils.retrieveVoIp(entity);

		serviceCode.setServiceType(defineServiceType(iptv, voip));

		String velocityDown = broadband.isPresent() ? RIEntityGraniteUtils.retrieveVelocityDown(entity) : BandwidthName._4M.getVelocity();
		serviceCode.setBwName(BandwidthName.retrieveBandwidthNameByVelocity(velocityDown).get().getName());

		serviceCode.setServiceClass(defineServiceClass(entity).getServiceClass());

		return serviceCode;
	}

	private void logOut(ServiceCodeEntity serviceCode) {
		StringBuilder log = new StringBuilder("Param OUT: ")
								.append(serviceCode);

		logger.log(OSSLogger.INFO, log.toString());
	}
}
