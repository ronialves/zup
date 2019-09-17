package com.tlf.oss.resourceinventory.osp.core;

import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.validation.Install;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class InstallController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	private InstallMetallicController installMetallicController;

	@Inject
	InstallGponController installGponController;

	public ResourceInventoryEntity doExecution(@Install ResourceInventoryEntity entity) throws OSSBusinessException {

		validateRequest(entity);

		// Verifica a tecnologia recebida na interface de entrada (accessTechnology) é Gpon ou Metálico
		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "InstallGponController - GPON");
			installGpon(entity);
		} else {
			logger.log(OSSLogger.INFO, "InstallMetallicController - METALLIC");
			installMetallic(entity);
		}
		return entity;
	}

	private void validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<ResourceFacingService> facingService = Optional.ofNullable(entity.getResourceFacingService());

		if (!facingService.isPresent())
			throw new OSSBusinessException("Erro ao validar o objeto CancelResourceEntity", "RIGRANITE-001",
					"O valor do campo facingService eh nulo");
	}

	private void installGpon(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			installGponController.resourceInstall(entity);
		} catch (OSSBusinessException ossBusinessException) {
			if (ossBusinessException.getDetail() == null || !ossBusinessException.getDetail().contains(OSPCode.RESOURCE_FACILITY.getValue())) {
				throw ossBusinessException;
			}
		}
	}

	private void installMetallic(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			installMetallicController.resourceInstall(entity);
		} catch (OSSBusinessException ossBusinessException) {
			if (!OSPCode.RESOURCE_FACILITY.getValue().equals(ossBusinessException.getDetail())) {
				throw ossBusinessException;
			}
		}
	}
}
