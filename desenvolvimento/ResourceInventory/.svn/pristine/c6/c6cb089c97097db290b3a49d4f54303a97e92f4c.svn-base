package com.tlf.oss.resourceinventory.granite.core;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusGponDao;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class InstallGponController extends ValidatorEntity{

	@Inject
	private ResourceStatusGponDao resourceStatusGponDao;
	
	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(), String.format(Code.RIGRANITE_003.getDescription(), ResourceStatusGponEntity.PKG_PATH_PRC_ALTER_STATUS_GPON), Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	public ResourceInventoryEntity doExecution(ResourceInventoryEntity entity) throws OSSBusinessException{
		
	ResourceStatusGponEntity statusEntity = updateStatus(entity);
		
		return getResourceInventoryEntity(statusEntity, entity);
	}
	
	@Transactional(rollbackOn=Exception.class)
	public ResourceStatusGponEntity updateStatus(ResourceInventoryEntity entity) throws OSSBusinessException {
				
		ResourceStatusGponEntity resourceStatusGponEntity = this.getResourceStatusGponEntity(entity);
		return resourceStatusGponDao.updateStatus(resourceStatusGponEntity);		
	}
	
	private ResourceStatusGponEntity getResourceStatusGponEntity(ResourceInventoryEntity entity) {
		ResourceStatusGponEntity updateEntity = new ResourceStatusGponEntity();
		updateEntity.setTerminal(entity.getResourceFacingService().getServiceId());
		updateEntity.setStatus(StatusPathType.ACTIVE.getValue());
		return updateEntity;
	}
	
	private ResourceInventoryEntity getResourceInventoryEntity(ResourceStatusGponEntity entityStatus, ResourceInventoryEntity entity) throws OSSBusinessException {
		if (Message.SUCCESS.getValue().equalsIgnoreCase(entityStatus.getResult().getCode()))
			return entity;
		else{
			this.falloutConfig.setErrorCode(entityStatus.getResult().getCode());
			this.falloutConfig.setErrorMessage(entityStatus.getResult().getDescription());
			this.falloutConfig.setDetailMessage(entityStatus.getResult().getCode().concat(";").concat(entityStatus.getResult().getDescription()));
			throw OSSExceptionFactory.getOSSBusinessException(this.falloutConfig);
		}
	}

}
