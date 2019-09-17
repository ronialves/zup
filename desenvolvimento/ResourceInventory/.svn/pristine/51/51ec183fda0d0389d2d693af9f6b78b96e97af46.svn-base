package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.servicetypes.ServiceServiceType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.enums.TypeProductVoice;
import com.tlf.oss.resourceinventory.osp.core.service.InstallService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class InstallGponController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;
			
	@Inject
	private InstallService installService;

	public ResourceInventoryEntity resourceInstall(ResourceInventoryEntity entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "InstallController.resourceInstall - Start");
		 
		WsContext headerContext = new WsContext();
		
		headerContext.setRegionCode(entity.getAddress().getCnl() != null ? entity.getAddress().getCnl() : null);
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea() != null ? entity.getAddress().getTelephonicArea() : null);
				
		try {
					
			TrackManageServiceProvisioningRequest request = createRequest(entity);
			TrackManageServiceProvisioningResponse response = installService.manageServiceProvisioningActivity(request, headerContext);						
			validateResult(response);
			logger.log(OSSLogger.INFO, "InstallController.resourceInstall - End");
			return entity;			
		} catch (Exception e) {			
			logger.log(OSSLogger.ERROR, Message.ERRO_RESOURCE_INSTALL.getValue()+" =[" + e.getMessage() + "]");
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, OSPWSName.TrackManageServiceProvisioning);
		}
		
	}

	private TrackManageServiceProvisioningRequest createRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		TrackManageServiceProvisioningRequest manageServiceProvisioningRequest = new TrackManageServiceProvisioningRequest();	
		
		if(entity.getResourceFacingService() != null ){

			manageServiceProvisioningRequest.setCircuitId(entity.getResourceFacingService().getServiceId());
			manageServiceProvisioningRequest.setOperation(new BigInteger(Operation.INSTALL.getValue()));
			
			ServiceServiceType service = new ServiceServiceType();
			service.setServiceType(TypeProductVoice.LIRA.getTypes());			
			
			manageServiceProvisioningRequest.setService(service);
									
		}	
		
		return manageServiceProvisioningRequest;
		
	}

	private void validateResult(TrackManageServiceProvisioningResponse response) throws OSSBusinessException {

		final String code = String.valueOf(response.getResult().getErrorCode());
		final String description= String.valueOf(response.getResult().getDescription());	
		final OSPWSName serviceOperation = OSPWSName.TrackManageServiceProvisioning;

		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(code, description, serviceOperation);
			
		}
		
	}
	
	
}
