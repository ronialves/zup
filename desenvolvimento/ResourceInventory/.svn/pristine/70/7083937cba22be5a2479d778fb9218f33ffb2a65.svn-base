package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.validation.Allocate;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateResourceController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;

	@Inject
	private AllocateResourceMetallicController allocateResourceMetallicController;
	
	@Inject
	private AllocateResourceGponController allocateResourceGponController;

	@Inject
	private PathService pathService;

	@Transactional(rollbackOn=Exception.class)
	public ResourceInventoryEntity allocateResource(@Allocate ResourceInventoryEntity entity) throws OSSBusinessException {

		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "AllocateController - GPON");
			final RetrievePathEntity path = pathService.getPath(entity);
			if(path != null) {
				allocateResourceGponController.allocateResource(entity, path.isOfferEdition() ? Operation.OFFER_EDITION : Operation.SALE_OFFER);
			}

		} else {
			logger.log(OSSLogger.INFO, "AllocateController - METALLIC");
			allocateResourceMetallicController.allocateResource(entity);
		}
		return entity;
	}
	
}
