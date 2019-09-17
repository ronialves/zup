package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;
import java.util.concurrent.TimeoutException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.service.DeallocateService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class DeallocateMetallicController {

	@Inject
	private OSSLogger logger;

	@Inject
	private DeallocateService deallocateService;

	public ResourceInventoryEntity deallocate(ResourceInventoryEntity entity, Operation operation) throws OSSBusinessException {
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

			String detail = getErrorDetail(e);
			throw new OSSBusinessException(description, Code.RIOSP_002.getValue(), detail);
		}

		logger.log(OSSLogger.INFO, "Finished executing deallocate");
		return entity;
	}

	private void validateResult(ManageResourceProvisioningActivityResponse response) throws OSSBusinessException {
		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw new OSSBusinessException(response.getResult().getDescription(),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}
	}

	private String getErrorDetail(Exception e) {
		String detail;
		if (e instanceof TimeoutException) {
			detail = Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue();
		} else {
			detail = e.getMessage();
		}
		return detail;
	}

	private ManageResourceProvisioningActivityRequest createRequest(ResourceInventoryEntity entity,
			Operation operation) {

		ManageResourceProvisioningActivityRequest manageResourceProvisioningActivityRequest = new ManageResourceProvisioningActivityRequest();

		manageResourceProvisioningActivityRequest.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());

		manageResourceProvisioningActivityRequest.setOperation(new BigInteger(operation.getValue()));

		return manageResourceProvisioningActivityRequest;
	}
}