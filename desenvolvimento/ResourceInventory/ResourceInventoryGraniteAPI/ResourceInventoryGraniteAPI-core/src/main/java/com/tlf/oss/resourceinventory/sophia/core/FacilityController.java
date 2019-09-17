package com.tlf.oss.resourceinventory.sophia.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.sophia.core.validation.FacilityRetrieval;
import com.tlf.oss.resourceinventory.sophia.core.FacilityGponController;

@Logged
public class FacilityController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	@Inject
	private FacilityGponController facilityGponController;

	@Inject
	private FacilityeMetallicController facilityeMetallicController;

	@Transactional(rollbackOn = Exception.class)
	public ResourceInventoryEntity facilityResource(@FacilityRetrieval ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (isGpon(entity)) {

			logger.log(OSSLogger.INFO, "FacilityController - GPON");
			entity = facilityGponController.facilityResource(entity);

		} else {

			logger.log(OSSLogger.INFO, "FacilityController - METALLIC");
			entity = facilityeMetallicController.facilityResource(entity);

		}

		return entity;
	}
}