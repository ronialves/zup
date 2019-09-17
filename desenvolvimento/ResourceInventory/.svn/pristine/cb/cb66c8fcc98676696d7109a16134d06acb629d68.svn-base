package com.tlf.oss.resourceinventory.osp.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.TrackManageServiceProvisioning_Service;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.utils.HeaderHandlerResolver;

@Logged
public class InstallService {
	
	@Inject
	private OSSLogger logger;
	
	public TrackManageServiceProvisioningResponse manageServiceProvisioningActivity(
			TrackManageServiceProvisioningRequest request, WsContext wsContext) throws FacilitiesException {
		
		logger.log(OSSLogger.INFO, "Started call web service (manageServiceProvisioningActivity)");
		
		TrackManageServiceProvisioning_Service service = new TrackManageServiceProvisioning_Service();
		
		service.setHandlerResolver(new HeaderHandlerResolver());
		
		logger.log(OSSLogger.INFO,
				"Called service (manageServiceProvisioningActivity) - request " + XMLUtil.getXMLValue(request));
		
		TrackManageServiceProvisioningResponse response = service.getTrackManageServiceProvisioningPort()														         
			     .manageServiceProvisioningActivity(request, wsContext);
		
		logger.log(OSSLogger.INFO,
				"Called service (manageServiceProvisioningActivity) - response " + XMLUtil.getXMLValue(response));
		
		logger.log(OSSLogger.INFO, "Finished call web service (manageServiceProvisioningActivity)");
		
		return response;
	}
}