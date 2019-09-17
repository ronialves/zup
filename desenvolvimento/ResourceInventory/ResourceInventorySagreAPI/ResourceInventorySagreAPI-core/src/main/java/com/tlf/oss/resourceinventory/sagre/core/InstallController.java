package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.Install;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.InstallResourceEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.InstallRepository;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * BEATRIXTWO-154 | DEMOSS-2219
 * @project Beatrix Fase 2
 * @author renan.n.oliveira
 * @since 201710
 */

public class InstallController extends ValidatorEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject InstallRepository installRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(),
			String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_OC_CTRL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	private static final int RESULTADO_ESPERADO = 0;

	public static final String P_OUT_MSG = null;
	public static final Integer P_OUT_COD = null;
	
	public ResourceInventoryEntity install(@Install ResourceInventoryEntity entity) throws OSSBusinessException {
		
		InstallResourceEntity InstallResource = new InstallResourceEntity();
		InstallResource.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		InstallResource.setAccessTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		InstallResource.setVoiceTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		InstallResource.setAccessId(entity.getResourceFacingService().getServiceId());
				
		InstallResource.setResultCode(P_OUT_COD);
		InstallResource.setMessage(P_OUT_MSG);
		
		return getResourceInventoryEntity(installRepository.install(InstallResource), entity);
	}

	
	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do InstallDAO.allocate
	 * 
	 * @param install
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(InstallResourceEntity install,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		if (RESULTADO_ESPERADO != install.getResultCode()) {

			String errorCode = String.valueOf(install.getResultCode());
			String errorMessage = install.getMessage();
			String detailMessage = errorCode + "; " + errorMessage;

		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}
		return entity;
	}

}
