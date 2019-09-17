package com.tlf.oss.resourceinventory.osp.core;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.validation.Deallocate;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class DeallocateController extends ValidatorEntity {

	@Inject
	private DeallocateMetallicController deallocateMetallicController;

	@Inject
	private DeallocateGponController deallocateGponController;
	
	@Inject
	private OSSLogger logger;

	public ResourceInventoryEntity doExecution(@Deallocate ResourceInventoryEntity entity) throws OSSBusinessException {
		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "DeallocateGponController - GPON");
			deallocateGpon(entity);
		} else {
			logger.log(OSSLogger.INFO, "DeallocateMetallicController - METALLIC");
			deallocateMetallic(entity);
		}
		return entity;

	}

	private void deallocateGpon(ResourceInventoryEntity entity) throws OSSBusinessException {
		deallocateGponController.deallocate(entity, Operation.DEALLOCATE);
	}

	private void deallocateMetallic(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			deallocateMetallicController.deallocate(entity, Operation.DEALLOCATE);
		} catch (OSSBusinessException ossBusinessException) {
			if (!OSPCode.RESOURCE_FACILITY.getValue().equals(ossBusinessException.getDetail())) {
				throw ossBusinessException;
			}
		}
	}
}