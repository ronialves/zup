package com.tlf.oss.resourceinventory.granite.core;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.UninstallResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.UninstallResourceGponDao;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UninstallGponController {

	@Inject
	private OSSLogger logger;

	@Inject
	private UninstallResourceGponDao unistallGponDao;

	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(),
			String.format(Code.RIGRANITE_003.getDescription(), "PKG_ALLOCATE.PRC_CANCEL_ALLOCATE_GPON"), Constants.FALLOUT_EXCEPTIONS_FILENAME,
			Constants.FALLOUT_DESCRIPTION_FILENAME);

	public ResourceInventoryEntity doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {

		final String code;
		final String description;

		UninstallResourceGponEntity unistallEntity = unistallResource(entity);
		code = unistallEntity.getCode();
		description = unistallEntity.getDescription();

		if (Message.SUCCESS.getValue().equalsIgnoreCase(unistallEntity.getCode())) {
			logger.log(OSSLogger.INFO, "Executed unistall");
			return entity;
		} else {
			this.falloutConfig.setErrorCode(code);
			this.falloutConfig.setErrorMessage(description);
			this.falloutConfig.setDetailMessage(code.concat(";").concat(description != null ? description : ""));
			throw OSSExceptionFactory.getOSSBusinessException(this.falloutConfig);
		}
	}

	@Transactional(rollbackOn = Exception.class)
	public UninstallResourceGponEntity unistallResource(ResourceInventoryEntity entity) throws OSSBusinessException {

		UninstallResourceGponEntity unistallResourceGpon = new UninstallResourceGponEntity();

		if (entity.getResourceFacingService() != null && entity.getResourceFacingService().getServiceId() != null) {
			unistallResourceGpon.setTerminal(entity.getResourceFacingService().getServiceId());
		} else {
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", "RIGRANITE-001",
					"O valor do campo ServiceID eh nulo");
		}
		unistallResourceGpon = unistallGponDao.getUninstallInternalResource(unistallResourceGpon);

		return unistallResourceGpon;
	}
}
