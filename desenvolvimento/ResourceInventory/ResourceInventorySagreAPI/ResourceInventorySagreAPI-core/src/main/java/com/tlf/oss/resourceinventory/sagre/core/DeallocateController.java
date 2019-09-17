package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.Deallocate;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.DeallocateResourceEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.enums.Status;
import com.tlf.oss.resourceinventory.sagre.repository.DeallocateRepository;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * BEATRIXTWO-935 | DEMOSS-2995
 * @project Beatrix Fase 2
 * @author renan.n.oliveira
 * @since 201803
 */

public class DeallocateController extends ValidatorEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject 
	private DeallocateRepository deallocateRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(),
			String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_LIBERA_FAC_CTRL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	public static final int RESULTADO_ESPERADO = 0;

	public static final String P_OUT_MSG = null;
	public static final Integer P_OUT_COD = null;
	
	public ResourceInventoryEntity deallocate(@Deallocate ResourceInventoryEntity entity) throws OSSBusinessException {
		
		DeallocateResourceEntity deallocateResource = new DeallocateResourceEntity();
		deallocateResource.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		deallocateResource.setAccessTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		deallocateResource.setVoiceTechnology(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		deallocateResource.setAccessId(entity.getResourceFacingService().getServiceId());
		deallocateResource.setType(Status.DESIGNACAO.getName());
				
		deallocateResource.setResultCode(P_OUT_COD);
		deallocateResource.setMessage(P_OUT_MSG);
		
		return getResourceInventoryEntity(deallocateRepository.deallocate(deallocateResource), entity);
	}

	
	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do DeallocateDAO.allocate
	 * 
	 * @param deallocate
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(DeallocateResourceEntity deallocate,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		if (RESULTADO_ESPERADO != deallocate.getResultCode()) {
		    String errorCode = String.valueOf(deallocate.getResultCode());
		    String errorMessage = deallocate.getMessage();
		    String detailMessage = errorCode + "; " + errorMessage;
		 
		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
		    throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}

		return entity;

	}

}
