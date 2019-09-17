package com.tlf.oss.resourceinventory.osp.core;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.validation.Allocate;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class AllocateController extends ValidatorEntity {

	@Inject
	private AllocateMetallicController allocateMetallicController;

	@Inject
	private AllocateGponController allocateGponController;

	@Inject
	protected OSSLogger logger;

	public ResourceInventoryEntity doExecution(@Allocate ResourceInventoryEntity entity) throws OSSBusinessException {

		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "AllocateController - GPON");
			allocateGPON(entity);
		} else {
			logger.log(OSSLogger.INFO, "AllocateController - METALLIC");
			allocateMetallic(entity);
		}

		return entity;
	}

	private void allocateGPON(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			allocateGponController.allocate(entity);
		} catch (OSSBusinessException ossBusinessException) {
			if (ossBusinessException.getDetail() == null || !ossBusinessException.getDetail().contains(OSPCode.RESOURCE_FACILITY.getValue())) {
				throw ossBusinessException;
			}
		}
	}

	private void allocateMetallic(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			allocateMetallicController.allocate(entity);
		} catch (OSSBusinessException ossBusinessException) {
			if (!OSPCode.RESOURCE_FACILITY.getValue().equals(ossBusinessException.getDetail())) {
				throw ossBusinessException;
			}
		}
	}
}