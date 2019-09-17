package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceserviceinfotypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.supplementaryinformationmanageprovtypes.SupplementaryInformationIn;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.service.CancelReservedService;
import com.tlf.oss.resourceinventory.osp.core.validation.Release;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class CancelReservedController extends ValidatorEntity {

	private static final String CANCELAMENTO = "2";

	@Inject
	protected OSSLogger logger;

	@Inject
	protected CancelReservedService cancelReservedService;

	@Inject
	private CancelReservedGponController cancelReservedGponController;

	public ResourceInventoryEntity doExecution(@Release ResourceInventoryEntity entity) throws OSSBusinessException {

		validateRequest(entity);

		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "CancelReserveOrch - GPON");
			cancelGPON(entity);
		} else {
			logger.log(OSSLogger.INFO, "CancelReserveOrch - METALLIC");
			try {
				cancelReserved(entity);
			} catch (OSSBusinessException ossBusinessException) {
				if (OSPCode.RESOURCE_FACILITY.getValue().equals(ossBusinessException.getDetail())
						|| OSPCode.RESOURCE_NOT_EXISTS.getValue().equals(ossBusinessException.getDetail())) {
					logger.log(OSSLogger.ERROR, "CancelReservedService - WebMethod doExecution =["
							+ ossBusinessException.getMessage() + "]");
				} else {
					throw ossBusinessException;
				}
			}
		}
		return entity;
	}

	private ManageResourceProvisioningActivityRequest createRequest(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		ManageResourceProvisioningActivityRequest mrpar = new ManageResourceProvisioningActivityRequest();

		SupplementaryInformationIn si = new SupplementaryInformationIn();
		ResourceService rs = new ResourceService();

		rs.setRegionCode(Integer.valueOf(entity.getAddress().getCnl()));
		rs.setSiteCode(entity.getAddress().getTelephonicArea());
		mrpar.setReserveOrder(getNRC(entity));

		si.setResourceService(rs);
		mrpar.setSupplementaryInformation(si);
		mrpar.setOperation(new BigInteger(CANCELAMENTO));

		return mrpar;
	}

	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc = getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	public ResourceInventoryEntity cancelReserved(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {

			WsContext context = new WsContext();
			context.setRegionCode(entity.getAddress().getCnl());
			context.setCentralOffice(entity.getAddress().getTelephonicArea());

			ManageResourceProvisioningActivityResponse response = null;

			response = cancelReservedService.manageResourceProvisioningActivity(createRequest(entity), context);
			validateResponse(response);
			
			return entity;
			
		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {

			if (e instanceof TimeoutException) {
				throw new OSSBusinessException("Erro ao cancelar reserva", Code.RIOSP_002.getValue(),
						Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
			}
			throw new OSSBusinessException("Erro ao cancelar reserva", Code.RIOSP_002.getValue(), e.getMessage());
		}
	}

	private void validateResponse(ManageResourceProvisioningActivityResponse response) throws OSSBusinessException {
		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw new OSSBusinessException(String.valueOf(response.getResult().getDescription()),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}
	}

	private void cancelGPON(ResourceInventoryEntity entity) throws OSSBusinessException {
		cancelReservedGponController.cancelReserved(entity);
	}

	private void validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {

		Optional<BrazilianUrbanPropertyAddress> brazilianUrbanPropertyAddress = Optional
				.ofNullable(entity.getAddress());
		Optional<ResourceFacingService> resourceFacingService = Optional.ofNullable(entity.getResourceFacingService());

		if (brazilianUrbanPropertyAddress.isPresent()) {
			if (!brazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getCnl).filter(d -> !d.isEmpty())
					.isPresent()) {
				throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity",
						Code.RIOSP_001.getValue(), "O valor do campo cnl é nulo");
			}
			if (!brazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getTelephonicArea)
					.filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity",
						Code.RIOSP_001.getValue(), "O valor do campo telephonicArea é nulo");
			}
		} else {
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity",
					Code.RIOSP_001.getValue(), "O valor do campo brazilianUrbanPropertyAddress é nulo");
		}

		if (!resourceFacingService.isPresent())
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity",
					Code.RIOSP_001.getValue(), "O valor do campo resourceFacingService eh nulo");
	}
}