package com.tlf.oss.resourceinventory.osp.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.AllocateInstallResource_Service;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.utils.HeaderHandlerResolver;


@Logged
public class UninstallService {
	
	@Inject
	private OSSLogger logger;
	
	public ReleaseResourceResponse releaseResource(
			ReleaseResourceRequest request, WsContext wsContext) throws FacilitiesException {
		
		logger.log(OSSLogger.INFO, "Started call web service (releaseResource)");
		
		AllocateInstallResource_Service service = new AllocateInstallResource_Service();		
		service.setHandlerResolver(new HeaderHandlerResolver());
		
		logger.log(OSSLogger.INFO, "Called service (releaseResource) - request " + XMLUtil.getXMLValue(request));
		
		ReleaseResourceResponse response = service.getAllocateInstallResourcePort().releaseResource(request, wsContext); 
				
		logger.log(OSSLogger.INFO, "Called service (releaseResource) - response " + XMLUtil.getXMLValue(response));		
		logger.log(OSSLogger.INFO, "Finished call web service (releaseResource)");
		
		return response;
	}	
}