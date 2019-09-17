package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.validation.Release;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
@Logged
public class CancelReservedController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private CancelReservedMetallicController cancelReservedMetallicController;
	
	@Inject
	private CancelReservedGponController cancelReservedGponController;
	
	public ResourceInventoryEntity cancelResource (@Release ResourceInventoryEntity entity) throws OSSBusinessException{

		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "ReleaseController - GPON");
			entity = cancelReservedGponController.doExecution(entity);
		} else {
			logger.log(OSSLogger.INFO, "ReleaseController - METALLIC");
			entity = cancelReservedMetallicController.doExecution(entity);
		}

		return entity;
	}
	
}