package com.tlf.oss.resourceinventory.osp.core;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.service.UninstallService;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class RequestUninstallGponController {

	@Inject
	protected OSSLogger logger;
	
	@Inject
	private UninstallService uninstallService;
	
	public ResourceInventoryEntity resourceUninstall(ResourceInventoryEntity entity) throws OSSBusinessException{
		logger.log(OSSLogger.INFO, "UninstallGponController.resourceUninstall - Start");
		
		WsContext headerContext = new WsContext();
		
		headerContext.setRegionCode(entity.getAddress().getCnl() != null ? entity.getAddress().getCnl() : null);
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea() != null ? entity.getAddress().getTelephonicArea() : null);
		
		try {
			ReleaseResourceRequest request = createRequest(entity);
			
			logger.log(OSSLogger.INFO, "Calling service releaseResource");
			ReleaseResourceResponse response = uninstallService.releaseResource(request, headerContext);						
			validateResult(response);
			logger.log(OSSLogger.INFO, "Called service releaseResource");
			
		} catch (Exception e) {			
			logger.log(OSSLogger.ERROR, Message.ERRO_RESOURCE_UNINSTALL.getValue()+" =[" + e.getMessage() + "]");
		    throw OssBusinessExceptionFactory.getOSSBusinessException(e, OSPWSName.AllocateInstallResource);
		}
		logger.log(OSSLogger.INFO, "UninstallGponController.resourceUninstall - End");
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
			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(String.valueOf(response.getResult().getErrorCode()), response.getResult().getDescription(), OSPWSName.AllocateInstallResource);
		}		
	}
}
