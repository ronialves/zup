package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.Release;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.ReleaseResourceEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.enums.Status;
import com.tlf.oss.resourceinventory.sagre.repository.ReleaseRepository;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * BEATRIXTWO-935 | DEMOSS-2995
 * @project Beatrix Fase 2
 * @author renan.n.oliveira
 * @since 201803
 */

public class ReleaseController extends ValidatorEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject ReleaseRepository releaseRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(),
			String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_LIBERA_FAC_CTRL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	private static final int RESULTADO_ESPERADO = 0;

	public static final String P_OUT_MSG = null;
	public static final Integer P_OUT_COD = null;
	
	public ResourceInventoryEntity release(@Release ResourceInventoryEntity entity) throws OSSBusinessException {
		
		ReleaseResourceEntity releaseResource = new ReleaseResourceEntity();
		releaseResource.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		releaseResource.setAccessTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		releaseResource.setVoiceTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		releaseResource.setAccessId(entity.getResourceFacingService().getServiceId());
		releaseResource.setType(Status.RESERVA.getName());
				
		releaseResource.setResultCode(P_OUT_COD);
		releaseResource.setMessage(P_OUT_MSG);
		
		return getResourceInventoryEntity(releaseRepository.release(releaseResource), entity);
	}

	
	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do ReleaseRepository.allocate
	 * 
	 * @param release
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(ReleaseResourceEntity release,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		if (RESULTADO_ESPERADO != release.getResultCode()) {
			String errorCode = String.valueOf(release.getResultCode());
			String errorMessage = release.getMessage();
			String detailMessage = errorCode + "; " + errorMessage;

		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}
		return entity;
	}

}
