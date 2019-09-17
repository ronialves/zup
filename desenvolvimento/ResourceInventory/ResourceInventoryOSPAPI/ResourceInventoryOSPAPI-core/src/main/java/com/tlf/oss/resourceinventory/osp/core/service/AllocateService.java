package com.tlf.oss.resourceinventory.osp.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.AllocateInstallResource_Service;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.utils.HeaderHandlerResolver;

@Logged
public class AllocateService {

	@Inject
	private OSSLogger logger;
	
	public AllocateInstallResourceResponse allocateResource(AllocateInstallResourceRequest request, WsContext context) throws FacilitiesException{
		logger.log(OSSLogger.INFO, "Started call web service (allocateResource)");
		AllocateInstallResource_Service service = new AllocateInstallResource_Service();
		
		service.setHandlerResolver(new HeaderHandlerResolver());
		
		logger.log(OSSLogger.INFO, "Called service (allocateResource) - request " + XMLUtil.getXMLValue(request));
		AllocateInstallResourceResponse response = service.getAllocateInstallResourcePort().allocateResource(request, context);
		
		logger.log(OSSLogger.INFO, "Called service (allocateResource) - response " + XMLUtil.getXMLValue(response));
		logger.log(OSSLogger.INFO, "Finished call web service (allocateResource)");
		return response;
	}
}