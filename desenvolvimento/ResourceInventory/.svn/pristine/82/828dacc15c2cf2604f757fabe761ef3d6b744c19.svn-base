package com.tlf.oss.resourceinventory.granite.core;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.validation.Uninstall;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UninstallController extends ValidatorEntity {
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private DeallocateResourceMetallicController unistallResourceController;
	@Inject
	private UninstallGponController uninstallGponController;
	
	public ResourceInventoryEntity uninstallResource(@Uninstall ResourceInventoryEntity entity) throws OSSBusinessException{
		
		if(isGpon(entity)){
			logger.log(OSSLogger.INFO, "UninstallController - GPON");
			entity = uninstallGponController.doExecution(entity);
		}else{
			logger.log(OSSLogger.INFO, "UninstallController - METALICO");
			entity = unistallResourceController.doExecution(entity);		
		}
		return entity;
	}
	
}
