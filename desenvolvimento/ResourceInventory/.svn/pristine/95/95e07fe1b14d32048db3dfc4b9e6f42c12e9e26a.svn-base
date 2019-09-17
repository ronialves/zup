package com.tlf.oss.resourceinventory.granite.core;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.validation.Install;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class InstallController extends ValidatorEntity {
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private InstallGponController installGponController;
	
	@Inject
	private InstallMetallicController installMetallicController;
	
	public ResourceInventoryEntity installResource(@Install ResourceInventoryEntity entity) throws OSSBusinessException{
		
		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "InstallController - GPON");
			entity = installGponController.doExecution(entity);
		} else {
			logger.log(OSSLogger.INFO, "InstallController - METALLIC");
			installMetallicController.doExecution(entity);
		}
		return entity;
	}
	
}
