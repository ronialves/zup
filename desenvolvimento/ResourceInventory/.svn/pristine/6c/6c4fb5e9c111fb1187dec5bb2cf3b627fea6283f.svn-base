package com.tlf.oss.resourceinventory.osp.core;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.validation.Unistall;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class UninstallController extends ValidatorEntity {

	@Inject
	private UninstallMetallicController requestUninstallController;

	@Inject
	private DeallocateMetallicController deallocateController;

	@Inject
	private DeallocateGponController deallocateGponController;

	@Inject
	private FacilityResourceController facilityResource;

	@Inject
	private RequestUninstallGponController requestUninstallGponController;

	public ResourceInventoryEntity doExecution(@Unistall ResourceInventoryEntity entity) throws OSSBusinessException {

		resourceFacilityController(entity);
		
		if(isGpon(entity)){
			resourceUninstallGpon(entity);	
			deallocateGpon(entity);
		}
		else {
			Uninstall(entity);
			deallocate(entity);
		}

		return entity;
	}

	private void deallocateGpon(ResourceInventoryEntity entity) throws OSSBusinessException {
		deallocateGponController.deallocate(entity, Operation.UNINSTALL);
	}

	private void resourceUninstallGpon(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			requestUninstallGponController.resourceUninstall(entity);
		} catch (OSSBusinessException ossBusinessException) {
			if(ossBusinessException.getDetail() == null || !ossBusinessException.getDetail().contains(OSPCode.RESOURCE_UNINSTALL.getValue())) {
		        throw ossBusinessException;
			}
		}
	}

	private void resourceFacilityController(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			facilityResource.doExecution(entity);
		} catch (Exception e) {
			if(isGpon(entity)) {
				throw OssBusinessExceptionFactory.getOSSBusinessException(e, OSPWSName.ReportResourceProvisioning);
			} else {
				throw e;
			}
		}
	}

	private void Uninstall(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			requestUninstallController.Uninstall(entity);
		} catch (OSSBusinessException ossBusinessException) {
			if (!OSPCode.RESOURCE_UNINSTALL.getValue().equals(ossBusinessException.getDetail())) {
				throw ossBusinessException;
			}
		}
	}

	private void deallocate(ResourceInventoryEntity entity) throws OSSBusinessException {
		deallocateController.deallocate(entity, Operation.UNINSTALL);
	}
}