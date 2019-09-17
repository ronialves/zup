package com.tlf.oss.resourceinventory.tbs.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.core.validation.Uninstall;
import com.tlf.oss.resourceinventory.tbs.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.tbs.entity.UninstallEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.enums.OrderEnum;
import com.tlf.oss.resourceinventory.tbs.repository.UninstallRepository;

/**
 * BEATRIXTWO-966 | DEMOSS-3082
 * BEATFAS-102 | DEMOSS-3331
 * 
 * @author jose.fabio.d.souza
 * @author bruna.barbosa
 * @project Beatrix Fase 2
 * @since 201804
 *
 */
public class UninstallController extends ValidatorEntity  implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String RPON = "RPON";
	private static final int SUCCESS = 0;
	
	@Inject
	UninstallRepository uninstallRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RITBS_003.getCode(),
			String.format(ExceptionInfoEnum.RITBS_003.getDescription(), "TLF_SP_UNINSTALL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	/**
	 * Retorna atraves do UninstallEntity (preenchido com ResourceInventoryEntity), o ResourceInventoryEntity enriquecido
	 * 
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getUninstall(@Uninstall ResourceInventoryEntity entity) throws OSSBusinessException{
		UninstallEntity uninstall = new UninstallEntity();		
		uninstall.setPurchaseOrderNumber(entity.getCustomerOrder().getPurchaseOrderNumber());
		uninstall.setRpon(getValueServiceDescribedBy(entity, RPON));
		uninstall.setDesignadorAcesso(entity.getResourceFacingService().getServiceId());
		uninstall.setActivityInd(OrderEnum.DISCONECT.getValue());
		uninstall.setDocumentNumber(null);
		uninstall.setMessage(null);
		uninstall.setReturnCode(null);
		
		return getResourceInventoryEntity(uninstallRepository.getUninstall(uninstall), entity);
	}
	
	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do uninstallDAO.getUninstall()
	 * 
	 * @param uninstall
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(UninstallEntity uninstall, ResourceInventoryEntity entity)
			throws OSSBusinessException {
		
		Integer errorCode = uninstall.getReturnCode();
		
		if (SUCCESS != errorCode) {
		    falloutConfig.setErrorCode(String.valueOf(errorCode));
		    falloutConfig.setErrorMessage(uninstall.getMessage());
			falloutConfig.setDetailMessage(errorCode + "; " +  uninstall.getMessage());
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}

		return entity;
	}
	
	private static String getValueServiceDescribedBy(ResourceInventoryEntity entity, String parameterName) {
		if (entity.getCustomerFacingService() != null && !entity.getCustomerFacingService().isEmpty()) {
			for (CustomerFacingService customer : entity.getCustomerFacingService()) {
				if (customer.getServiceDescribedBy() != null && !customer.getServiceDescribedBy().isEmpty()) {
					for (ServiceDescribedBy service : customer.getServiceDescribedBy()) {
						if (parameterName.equalsIgnoreCase(service.getName()) && service.getServiceSpecCharDescribes() != null) {
							for (ServiceSpecCharDescribes serviceSpec : service.getServiceSpecCharDescribes()) {
								return serviceSpec.getValue();
							}
						}
					}
				}
			}
		}
		return null;
	}
	
}
