package com.tlf.oss.resourceinventory.osp.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.AllocateInstallResource_Service;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.utils.HeaderHandlerResolver;

@Logged
public class AvailabilityService {
	
	@Inject
	private OSSLogger logger;

	public DetermineResourceAvailabilityResponse determineResourceAvailability(DetermineResourceAvailabilityRequest request, WsContext wsContext) throws FacilitiesException {
		
		logger.log(OSSLogger.INFO, "Started call web service (determineResourceAvailability)");

		AllocateInstallResource_Service service = new AllocateInstallResource_Service();
		service.setHandlerResolver(new HeaderHandlerResolver());

		logger.log(OSSLogger.INFO, "Called service (determineResourceAvailability) - request " + XMLUtil.getXMLValue(request));

		DetermineResourceAvailabilityResponse response = service.getAllocateInstallResourcePort().determineResourceAvailability(request, wsContext);
		
		logger.log(OSSLogger.INFO, "Called service (DetermineResourceAvailability) - response " + XMLUtil.getXMLValue(response));
		logger.log(OSSLogger.INFO, "Finished call web service (DetermineResourceAvailability)");
		
		return response;
	}	
}