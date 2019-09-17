package com.tlf.oss.resourceinventory.radius.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.radius.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.radius.repository.DeallocateRepository;
import com.tlf.oss.resourceinventory.radius.validation.Deallocate;
import com.tlf.oss.resourceinventory.radius.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * REC3635-1294 | REC3635-2045
 * 
 * @project Fusion
 * @author 80645973
 * @since 20190326
 */
public class DeallocateController  extends ValidatorEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Inject
    private OSSLogger logger;
    
    @Inject
    private DeallocateRepository deallocateRepository;
    
    
    public ResourceInventoryEntity deallocate(@Deallocate ResourceInventoryEntity entity) throws OSSBusinessException{
    	
    	String designadorAcesso = entity.getResourceFacingService().getServiceId();
    	
    	logger.log(OSSLogger.INFO, "Desalocadndo Ip ao Designador: '"+ designadorAcesso+ "'");
    	
    	String ipAddress = deallocateRepository.getIpAddress(designadorAcesso);
    	
    	if(ipAddress != null){
    	
    	deallocateRepository.deallocateIpAddress(ipAddress);
    	
    	deallocateRepository.deallocateDesignador(designadorAcesso);
    	
    	}else{
    		logger.log(OSSLogger.ERROR,"IP_ADDRESS nulo na tabela TNETPRO_POOL");
    		throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_004.getDescription(),
    				ExceptionInfoEnum.RIRADIUS_004.getCode(),String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
    					"Erro: IP_ADRESS nulo na tabela TNETPRO_POOL"));
    		
    	}
       	
    	return entity;
    }
}
