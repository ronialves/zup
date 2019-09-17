package com.tlf.oss.resourceinventory.osp.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.AllocateInstallResource_Service;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.ReportResourceProvisioning_Service;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.utils.HeaderHandlerResolver;



@Logged
public class ReservationService {
	
	@Inject
	private OSSLogger logger;
	
	public ReportResourceProvisioningResponse distributeResourceProvisioningReports(
			ReportResourceProvisioningRequest request, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext wsContext) 
					throws com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException {
		
		logger.log(OSSLogger.INFO, "Started call web service (distributeResourceProvisioningReports)");
		
		ReportResourceProvisioning_Service service = new ReportResourceProvisioning_Service();
		
		service.setHandlerResolver(new HeaderHandlerResolver());
		
		logger.log(OSSLogger.INFO, "Called service (distributeResourceProvisioningReports) - request " + XMLUtil.getXMLValue(request));		
		ReportResourceProvisioningResponse response = service.getReportResourceProvisioningPort().distributeResourceProvisioningReports(request, wsContext);
		
		logger.log(OSSLogger.INFO, "Called service (distributeResourceProvisioningReports) - response " + XMLUtil.getXMLValue(response));
		
		logger.log(OSSLogger.INFO, "Finished call web service (distributeResourceProvisioningReports)");
		
		return response;
	}

	public ReserveResourceResponse reserveResource(ReserveResourceRequest request, WsContext wsContext) throws FacilitiesException {
		
		logger.log(OSSLogger.INFO, "Started call web service (reserveResource)");
		
		AllocateInstallResource_Service service = new AllocateInstallResource_Service();
		
		service.setHandlerResolver(new HeaderHandlerResolver());
				
		logger.log(OSSLogger.INFO, "Called service (reserveResource) - request " + XMLUtil.getXMLValue(request));	
		
		ReserveResourceResponse response = service.getAllocateInstallResourcePort().reserveResource(request, wsContext);
				
		logger.log(OSSLogger.INFO, "Called service (reserveResource) - response " + XMLUtil.getXMLValue(response));
		
		logger.log(OSSLogger.INFO, "Finished call web service (reserveResource)");
		
		return response;
	}	
}