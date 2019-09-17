package com.tlf.oss.resourceinventory.tbs.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.tbs.core.validation.Deallocate;
import com.tlf.oss.resourceinventory.tbs.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.entity.DeallocateEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.DeallocateRepository;

/**
 * BEATRIXTWO-934 | DEMOSS-2998
 * BEATFAS-102 | DEMOSS-3331
 * 
 * @project Beatrix Fase 2
 * @author jose.fabio.d.souza
 * @author bruna.barbosa
 * @since 201803
 */

public class DeallocateController extends ValidatorEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final int SUCCESS = 0;
	
	@Inject 
	private DeallocateRepository deallocateRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RITBS_003.getCode(),
			String.format(ExceptionInfoEnum.RITBS_003.getDescription(), "TLF_SP_DEALLOCATE"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	/**
	 * Realiza a liberacao do recurso alocado atraves de chamada ao DAO.
	 * 
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity deallocate(@Deallocate ResourceInventoryEntity entity) throws OSSBusinessException{
		
		DeallocateEntity deallocate = new DeallocateEntity();				
		deallocate.setPurchaseOrderNumber(entity.getCustomerOrder().getPurchaseOrderNumber());
		deallocate.setDesignadorAcesso(entity.getResourceFacingService().getServiceId());
		deallocate.setReturnMsg(null);
		deallocate.setReturnCode(null);
		
		deallocate = deallocateRepository.deallocate(deallocate);
		
		Integer errorCode = deallocate.getReturnCode();
		
		if (SUCCESS != errorCode) {
		    falloutConfig.setErrorCode(String.valueOf(errorCode));
		    falloutConfig.setErrorMessage(deallocate.getReturnMsg());
			falloutConfig.setDetailMessage(errorCode + "; " + deallocate.getReturnMsg());
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}
		
		return entity;
	}

}
