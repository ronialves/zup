package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.service.DeallocateService;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateGponController {

	@Inject
	private OSSLogger logger;

	@Inject
	private DeallocateService deallocateService;

	public ResourceInventoryEntity deallocate(ResourceInventoryEntity entity, Operation operation)
			throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Started executing deallocate");

		WsContext wsContext = new WsContext();
		wsContext.setRegionCode(entity.getAddress().getCnl());
		wsContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		ManageResourceProvisioningActivityRequest request = createRequest(entity, operation);

		try {
			ManageResourceProvisioningActivityResponse response = deallocateService
					.manageResourceProvisioningActivity(request, wsContext);

			validateResult(response);

		} catch (Exception e) {
		    String description = "Erro ao desalocar o recurso externo";
		    logger.error(description, e);
		    throw OssBusinessExceptionFactory.getOSSBusinessException(e, OSPWSName.TrackManageResourceProvisioning);
		}

		logger.log(OSSLogger.INFO, "Finished executing deallocate");
		return entity;
	}

	private void validateResult(ManageResourceProvisioningActivityResponse response) throws OSSBusinessException {

		if (response.getResult() != null && response.getResult().getCode() != 0) {
		    throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(String.valueOf(response.getResult().getErrorCode()), response.getResult().getDescription(), OSPWSName.TrackManageResourceProvisioning);
		}
	}

	private ManageResourceProvisioningActivityRequest createRequest(ResourceInventoryEntity entity,
			Operation operation) {

		ManageResourceProvisioningActivityRequest manageResourceProvisioningActivityRequest = new ManageResourceProvisioningActivityRequest();

		manageResourceProvisioningActivityRequest.setCircuitId(entity.getResourceFacingService().getServiceId());
		manageResourceProvisioningActivityRequest.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());
		manageResourceProvisioningActivityRequest.setOperation(new BigInteger(operation.getValue()));

		return manageResourceProvisioningActivityRequest;
	}
}
