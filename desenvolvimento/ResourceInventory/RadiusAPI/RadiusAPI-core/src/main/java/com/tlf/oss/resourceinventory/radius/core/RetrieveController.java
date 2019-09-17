package com.tlf.oss.resourceinventory.radius.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.radius.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.radius.repository.RetrieveRepository;
import com.tlf.oss.resourceinventory.radius.validation.Retrieve;
import com.tlf.oss.resourceinventory.radius.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.ResourceCharacteristicSpecification;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;



public class RetrieveController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 4501865998279734435L;
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private RetrieveRepository retrieveRepository;

	
	public ResourceInventoryEntity retrieve(@Retrieve ResourceInventoryEntity entity) throws OSSBusinessException {
			
		String designador = entity.getResourceFacingService().getServiceId();
		
		logger.log(OSSLogger.INFO, "Buscando IP alocado para o Designador: '" + designador + "'");
		String ipAddress = retrieveRepository.getIpAddress(designador);

		if (ipAddress == null) {
			logger.log(OSSLogger.INFO, "IP_ADDRESS não encontrado.");
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
