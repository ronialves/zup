package com.tlf.oss.resourceinventory.tbs.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.tbs.core.validation.Install;
import com.tlf.oss.resourceinventory.tbs.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.entity.InstallEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.InstallRepository;

/**
 * BEATRIXTWO-29 | DEMOSS-2218
 * BEATFAS-102 | DEMOSS-3331
 * 
 * @author rodrigo.de.freitas
 * @author bruna.barbosa
 * @project Beatrix Fase 2
 * @since 201710
 *
 */
public class InstallController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int SUCCESS = 0;
	
	@Inject
	InstallRepository installRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RITBS_003.getCode(),
			String.format(ExceptionInfoEnum.RITBS_003.getDescription(), "TLF_SP_INSTALL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	/**
	 * Retorna atraves do InstallEntity (preenchido com ResourceInventoryEntity), o ResourceInventoryEntity enriquecido
	 * 
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getInstall(@Install ResourceInventoryEntity entity) throws OSSBusinessException{
		InstallEntity install = new InstallEntity();		
		install.setPurchaseOrderNumber(entity.getCustomerOrder().getPurchaseOrderNumber());
		install.setDesignadorAcesso(entity.getResourceFacingService().getServiceId());
		install.setMessage(null);
		install.setReturnCode(null);
		
		return getResourceInventoryEntity(installRepository.getInstall(install), entity);
	}
	
	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do installDAO.getInstall()
	 * 
	 * @param install
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(InstallEntity install, ResourceInventoryEntity entity)
			throws OSSBusinessException {			
		
		Integer errorCode = install.getReturnCode();
		
		if (SUCCESS != errorCode) {
		    falloutConfig.setErrorCode(String.valueOf(errorCode));
		    falloutConfig.setErrorMessage(install.getMessage());
			falloutConfig.setDetailMessage(errorCode + "; " +  install.getMessage());
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}

		return entity;
	}
	
}
