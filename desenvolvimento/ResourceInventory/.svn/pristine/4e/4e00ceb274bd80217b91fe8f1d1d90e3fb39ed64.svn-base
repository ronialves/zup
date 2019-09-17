package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.validation.FacilityRetrieval;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@Named
@RequestScoped
public class FacilityResourceController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacilityResourceMetallicController facilityResourceController;
	@Inject
	private FacilityResourceGponController facilityResourceGponController;

	@Inject
	protected OSSLogger logger;

	public ResourceInventoryEntity facilityResource(@FacilityRetrieval ResourceInventoryEntity entity) throws OSSBusinessException {
		
		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "FacilityOrch - GPON");
			return resourceFacilityGPON(entity);
		}
		else{           
			logger.log(OSSLogger.INFO, "FacilityOrch - METALLIC");
			return resourceFacilityMetallic(entity);
		}
	}
	private ResourceInventoryEntity resourceFacilityGPON(ResourceInventoryEntity entity) throws OSSBusinessException {
		return facilityResourceGponController.resourceFacility(entity);
	}
	private ResourceInventoryEntity resourceFacilityMetallic(ResourceInventoryEntity entity) throws OSSBusinessException {
		return facilityResourceController.resourceFacility(entity);
	}
	
}