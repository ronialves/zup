package com.tlf.oss.resourceinventory.radius.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.radius.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.radius.repository.AllocateRepository;
import com.tlf.oss.resourceinventory.radius.validation.Allocate;
import com.tlf.oss.resourceinventory.radius.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceCharacteristicSpecification;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;


/**
 * REC3635-1110 | REC3635-2042
 * 
 * @project Fusion
 * @author 80629552
 * @since 20190325
 */
public class AllocateController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 4501865998279734435L;
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private AllocateRepository allocateRepository;

	
	public ResourceInventoryEntity getAllocate(@Allocate ResourceInventoryEntity entity) throws OSSBusinessException {
			
		String designadorAcesso = entity.getResourceFacingService().getServiceId();
		
		logger.log(OSSLogger.INFO, "Alocando IP ao Designador: '" +designadorAcesso +"'");
		
		String shastaCity = allocateRepository.getShastaCity(designadorAcesso);
		String ipAddress = allocateRepository.getIpAddress(designadorAcesso, shastaCity);
		
		if (ipAddress != null) {
			allocateRepository.allocateIp(ipAddress);
			
			if (allocateRepository.checkAllocateIpToDesignator(designadorAcesso, ipAddress)) {
				allocateRepository.allocateUpdateIpToDesignator(ipAddress, designadorAcesso);			
			}else{
				allocateRepository.allocateIpToDesignator(ipAddress, designadorAcesso);			
			}
			
		}else{
			logger.log(OSSLogger.ERROR, "IP_ADDRESS nulo na tabela TNETPRO_POOL");
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_004.getDescription(),
					ExceptionInfoEnum.RIRADIUS_004.getCode(), String.format(ExceptionInfoEnum.RIRADIUS_002.getMessage(),
							"Erro: IP_ADDRESS nulo na tabela TNETPRO_POOL"));	
		}
		
		return getResourceInventoryEntity(ipAddress);

	}
	
	private ResourceInventoryEntity getResourceInventoryEntity(String ipAddress) {
		ResourceCharacteristicSpecification rcs = new ResourceCharacteristicSpecification();
		rcs.setId("STATIC_IP_IPV4");
		rcs.setValue(ipAddress);

		Shelf shelf = new Shelf();
		shelf.getResourceCharacteristicSpecifications().add(rcs);
		Cabinet cabinet = new Cabinet();
		List<Shelf> hasShelves =  new ArrayList<Shelf>();
		hasShelves.add(shelf);
		cabinet.setHasShelves(hasShelves);
		
		ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();
		resourceInventoryEntity.setCabinet(cabinet);
		
		return resourceInventoryEntity;
		
	}	
}