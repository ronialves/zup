package com.tlf.oss.resourceinventory.osp.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.TrackManageResourceProvisioning_Service;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.utils.HeaderHandlerResolver;

@Logged
public class DeallocateService {
	
	@Inject
	private OSSLogger logger;

	public ManageResourceProvisioningActivityResponse manageResourceProvisioningActivity(
			ManageResourceProvisioningActivityRequest request, WsContext wsContext) throws FacilitiesException {
		
		logger.log(OSSLogger.INFO, "Started call web service (ManageResourceProvisioningActivity)");
		
		TrackManageResourceProvisioning_Service trackManageResourceProvisioningService = new TrackManageResourceProvisioning_Service();
		trackManageResourceProvisioningService.setHandlerResolver(new HeaderHandlerResolver());

		logger.log(OSSLogger.INFO,
				"Called service (ManageResourceProvisioningActivity) - request " + XMLUtil.getXMLValue(request));

		ManageResourceProvisioningActivityResponse response = trackManageResourceProvisioningService.getTrackManageResourceProvisioningPort()
				.manageResourceProvisioningActivity(request, wsContext);
		
		logger.log(OSSLogger.INFO,
				"Called service (ManageResourceProvisioningActivity) - response " + XMLUtil.getXMLValue(response));
		
		logger.log(OSSLogger.INFO, "Finished call web service (ManageResourceProvisioningActivity)");
		
		return response;
	}	
}