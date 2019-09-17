package com.tlf.oss.resourceinventory.osp.core;

import java.util.concurrent.TimeoutException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.service.UninstallService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class UninstallMetallicController {

	@Inject
	protected OSSLogger logger;

	@Inject
	private UninstallService uninstallService;

	public ResourceInventoryEntity Uninstall(ResourceInventoryEntity entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "UninstallController.resourceUninstall - Start");
		WsContext headerContext = new WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl() != null ? entity.getAddress().getCnl() : null);
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea() != null ? entity.getAddress().getTelephonicArea() : null);

		try {
			ReleaseResourceRequest request = createRequest(entity);
			logger.log(OSSLogger.INFO, "Calling service releaseResource");
			ReleaseResourceResponse response = uninstallService.releaseResource(request, headerContext);
			validateResult(response);
			logger.log(OSSLogger.INFO, "Called service releaseResource");

		} catch (OSSBusinessException e) {
			if (OSPCode.RESOURCE_UNINSTALL.getValue().equals(e.getDetail())) {
				entity.getCustomerOrder().setPurchaseOrderNumber(entity.getCustomerOrder().getPurchaseOrderNumber() + "D");
				Uninstall(entity);
			} else {
				throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
			}
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, Message.ERRO_RESOURCE_UNINSTALL.getValue() + " =[" + e.getMessage() + "]");
			if (e instanceof TimeoutException) {
				throw new OSSBusinessException(Message.ERRO_RESOURCE_UNINSTALL.getValue(), Code.RIOSP_002.getValue(),
						Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
			}
			throw new OSSBusinessException(Message.ERRO_RESOURCE_UNINSTALL.getValue(), Code.RIOSP_002.getValue(),
					e.getMessage());
		}
		logger.log(OSSLogger.INFO, "UninstallController.resourceUninstall - End");
		return entity;
	}

	private ReleaseResourceRequest createRequest(ResourceInventoryEntity entity) {
		ReleaseResourceRequest request = new ReleaseResourceRequest();
		request.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());
		request.setCircuitId(entity.getCircuit().getId());
		return request;
	}

	private void validateResult(ReleaseResourceResponse response) throws OSSBusinessException {
		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw new OSSBusinessException(response.getResult().getDescription(),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}
	}
}
