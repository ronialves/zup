package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.validation.Deallocate;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateResourceController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;

	@Inject
	private DeallocateResourceMetallicController deallocateResourceMetallicController;
	
	@Inject
	private DeallocateGponController deallocateResourceGponController;

	@Transactional(rollbackOn=Exception.class)
	public ResourceInventoryEntity deallocateResource(@Deallocate ResourceInventoryEntity entity) throws OSSBusinessException {

		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "DeallocateController - GPON");
			deallocateResourceGponController.doExecution(entity, getOperationType(entity));
		} else {
			logger.log(OSSLogger.INFO, "DeallocateController - METALLIC");
			deallocateResourceMetallicController.doExecution(entity);
		}
		return entity;
	}
	
	private Operation getOperationType(final ResourceInventoryEntity entity) {
		
		if(entity.getCustomerFacingService() == null || entity.getCustomerFacingService().isEmpty()) {
			return Operation.SALE_OFFER;
		}
		else {
			for(CustomerFacingService rfs : entity.getCustomerFacingService()) {
				if(rfs.getCategory() != null && !rfs.getCategory().isEmpty()) {
					return Operation.OFFER_EDITION;
				}
			}
		}

		return Operation.SALE_OFFER;
	}
}
