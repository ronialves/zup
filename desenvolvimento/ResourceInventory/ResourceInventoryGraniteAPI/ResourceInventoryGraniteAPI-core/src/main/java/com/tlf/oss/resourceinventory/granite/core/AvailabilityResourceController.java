package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.validation.AvailabilityRetrieval;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@Named
public class AvailabilityResourceController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AvailabilityRetrieveGponController availabilityRetrieveGponController;

	@Inject
	private AvailabilityRetrieveMetallicController availabilityRetrieveMetallicController;

	@Inject
	protected OSSLogger logger;
	public ResourceInventoryEntity availabilityResource(@AvailabilityRetrieval ResourceInventoryEntity entity) throws OSSBusinessException {
		
		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "AvailabilityRetrieveOrch - GPON");
			availabilityRetrieveGponController.availabilityRetrieve(entity);
		}
		else {
			logger.log(OSSLogger.INFO, "AvailabilityRetrieveOrch - METALLIC");
			availabilityRetrieveMetallicController.availabilityRetrieve(entity);
		}
		return entity;
	}
}