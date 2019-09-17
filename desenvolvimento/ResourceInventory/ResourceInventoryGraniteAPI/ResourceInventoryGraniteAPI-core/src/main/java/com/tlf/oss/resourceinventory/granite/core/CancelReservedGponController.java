package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelChangeSpeedGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ServiceCodeEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelChangeSpeedGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelResourceGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveServiceCodeDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class CancelReservedGponController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	CancelResourceGponDao cancelResourceGponDao;
	
	@Inject
	CancelChangeSpeedGponDao cancelChangeSpeedGponDao;
	
	@Inject
	private RetrieveServiceCodeDao retrieveServiceCodeDao;
	
	private OSSFalloutConfiguration falloutConfig;
	
	@Inject
	private PathService pathService;

	public ResourceInventoryEntity doExecution(final ResourceInventoryEntity entity) throws OSSBusinessException {
		final RetrievePathEntity path = pathService.getPath(entity);
		final String code;
		final String description;
		
		if(path != null) {
			if(StatusPathType.RESERVED.equals(path.getResourceStatus()) && StatusPathType.RESERVED.equals(path.getResourceStatus())) {
    			CancelChangeSpeedGponEntity cancelResourceGponEntity = getCancelChangeSpeedGponEntity(entity);
    			code = cancelResourceGponEntity.getCode();
    			description = cancelResourceGponEntity.getDescription();
    			this.falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(), String.format(Code.RIGRANITE_003.getDescription(), CancelChangeSpeedGponEntity.NAMED_PROC_QUERY), Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
    		} else {
    			CancelResourceGponEntity cancelResourceGponEntity = cancelResource(entity);
				code = cancelResourceGponEntity.getCode();
				description = cancelResourceGponEntity.getDescription();
				this.falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(), String.format(Code.RIGRANITE_003.getDescription(), CancelResourceGponEntity.PKG_RESERVE_PRC_CANCEL_RESERVE_GPON), Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
    		}
			
			if (!Code.SUCCESS.getValue().equals(code)) {
				this.falloutConfig.setErrorCode(code);
				this.falloutConfig.setErrorMessage(description);
				this.falloutConfig.setDetailMessage(code.concat(";").concat(description));
				throw OSSExceptionFactory.getOSSBusinessException(this.falloutConfig);
			}
		}

		return entity;
	}

	@Transactional(rollbackOn=Exception.class)
	public CancelResourceGponEntity cancelResource(final ResourceInventoryEntity entity) throws OSSBusinessException {

		final CancelResourceGponEntity cancelResourceGponEntity = new CancelResourceGponEntity();
		cancelResourceGponEntity.setTerminal(entity.getResourceFacingService().getServiceId());
		return cancelResourceGponDao.cancelResource(cancelResourceGponEntity);
	}
	
	@Transactional(rollbackOn=Exception.class)
	public CancelChangeSpeedGponEntity getCancelChangeSpeedGponEntity(final ResourceInventoryEntity entity) throws OSSBusinessException {

		final CancelChangeSpeedGponEntity cancelResourceGponEntity = new CancelChangeSpeedGponEntity();
		final ServiceCodeEntity serviceCodeEntity = retrieveServiceCodeDao.retrieveServiceCode(entity);
		cancelResourceGponEntity.setServiceCode(serviceCodeEntity.getServiceCode());
		cancelResourceGponEntity.setServiceId( entity.getResourceFacingService() != null ? entity.getResourceFacingService().getServiceId() : null );
		return cancelChangeSpeedGponDao.cancelResource(cancelResourceGponEntity);
	}
}
