package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.Uninstall;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.UninstallResourceEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.enums.Status;
import com.tlf.oss.resourceinventory.sagre.repository.UninstallRepository;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * BEATRIXTWO-968 | DEMOSS-2985
 * @project Beatrix Fase 2
 * @author jose.fabio.d.souza
 * @since 201803
 */

public class UninstallController extends ValidatorEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject 
	private UninstallRepository uninstallRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(),
			String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_LIBERA_FAC_CTRL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	private static final int RESULTADO_ESPERADO = 0;

	public static final String P_OUT_MSG = null;
	public static final Integer P_OUT_COD = null;
	
	public ResourceInventoryEntity uninstall(@Uninstall ResourceInventoryEntity entity) throws OSSBusinessException {
		
		UninstallResourceEntity uninstallResource = new UninstallResourceEntity();
		uninstallResource.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		uninstallResource.setAccessTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		uninstallResource.setVoiceTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		uninstallResource.setAccessId(entity.getResourceFacingService().getServiceId());
		uninstallResource.setType(Status.OCUPACAO.getName());
				
		uninstallResource.setResultCode(P_OUT_COD);
		uninstallResource.setMessage(P_OUT_MSG);
		
		return getResourceInventoryEntity(uninstallRepository.uninstall(uninstallResource), entity);
	}

	
	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do UninstallRepository.allocate
	 * 
	 * @param uninstall
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(UninstallResourceEntity uninstall,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		if (RESULTADO_ESPERADO != uninstall.getResultCode()) {
			String errorCode = String.valueOf(uninstall.getResultCode());
			String errorMessage = uninstall.getMessage();
			String detailMessage = errorCode + "; " + errorMessage;

		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}
		
		return entity;
		
	}

}
