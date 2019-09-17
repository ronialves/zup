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
public class CancelReservedService {

	@Inject
	private OSSLogger logger;
	
	public ManageResourceProvisioningActivityResponse manageResourceProvisioningActivity(ManageResourceProvisioningActivityRequest request, WsContext context) throws FacilitiesException{
		logger.log(OSSLogger.INFO, "Started call web service (manageResourceProvisioningActivity)");
		TrackManageResourceProvisioning_Service service = new TrackManageResourceProvisioning_Service();
		service.setHandlerResolver(new HeaderHandlerResolver());
		
		logger.log(OSSLogger.INFO, "Called service (manageResourceProvisioningActivity) - request " + XMLUtil.getXMLValue(request));
		ManageResourceProvisioningActivityResponse response = service.getTrackManageResourceProvisioningPort().manageResourceProvisioningActivity(request, context);
		
		logger.log(OSSLogger.INFO, "Called service (manageResourceProvisioningActivity) - response " + XMLUtil.getXMLValue(response));
		
		logger.log(OSSLogger.INFO, "Finished call web service (manageResourceProvisioningActivity)");
		
		return response; 
	}	
}