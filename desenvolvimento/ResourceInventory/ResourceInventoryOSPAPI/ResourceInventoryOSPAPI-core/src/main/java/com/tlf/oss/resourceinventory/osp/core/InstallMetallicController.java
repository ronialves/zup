package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;
import java.util.concurrent.TimeoutException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.servicetypes.ServiceServiceType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.enums.TypeProductVoice;
import com.tlf.oss.resourceinventory.osp.core.service.InstallService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class InstallMetallicController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	private InstallService installService;

	private TrackManageServiceProvisioningRequest createRequest(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		TrackManageServiceProvisioningRequest manageServiceProvisioningRequest = new TrackManageServiceProvisioningRequest();

		manageServiceProvisioningRequest.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());

		if (entity.getResourceFacingService() != null) {

			ServiceServiceType service = new ServiceServiceType();
			service.setIdentifier(getNetworkOwnerID(entity));
			service.setServiceType(TypeProductVoice.LIRA.getTypes());

			manageServiceProvisioningRequest.setService(service);

		}

		manageServiceProvisioningRequest.setOperation(new BigInteger(Operation.INSTALL.getValue()));
		return manageServiceProvisioningRequest;
	}

	private void validateResult(TrackManageServiceProvisioningResponse response) throws OSSBusinessException {

		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw new OSSBusinessException(response.getResult().getDescription(),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}
	}

	public ResourceInventoryEntity resourceInstall(ResourceInventoryEntity entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "InstallController.resourceInstall - Start");

		WsContext headerContext = new WsContext();

		headerContext.setRegionCode(entity.getAddress().getCnl() != null ? entity.getAddress().getCnl() : null);
		headerContext.setCentralOffice(
				entity.getAddress().getTelephonicArea() != null ? entity.getAddress().getTelephonicArea() : null);

		try {

			TrackManageServiceProvisioningRequest request = createRequest(entity);
			TrackManageServiceProvisioningResponse response = installService.manageServiceProvisioningActivity(request,
					headerContext);
			validateResult(response);

		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, Message.ERRO_RESOURCE_INSTALL.getValue() + " =[" + e.getMessage() + "]");
			if (e instanceof TimeoutException) {
				throw new OSSBusinessException(Message.ERRO_RESOURCE_INSTALL.getValue(), Code.RIOSP_002.getValue(),
						Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
			}
			throw new OSSBusinessException(Message.ERRO_RESOURCE_INSTALL.getValue(), Code.RIOSP_002.getValue(),
					e.getMessage());
		}
		logger.log(OSSLogger.INFO, "InstallController.resourceInstall - End");
		return entity;
	}
}