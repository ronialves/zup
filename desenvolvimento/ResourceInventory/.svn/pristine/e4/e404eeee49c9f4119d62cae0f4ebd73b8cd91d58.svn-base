/**
 * 
 */
package com.tlf.oss.resourceinventory.television.core;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.ResourceCharacteristicSpecification;
import com.tlf.oss.resourceinventory.schemas.Satellite;
import com.tlf.oss.resourceinventory.schemas.Technology;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.television.core.validation.DetermineAvailability;
import com.tlf.oss.resourceinventory.television.entity.CidadeUf;
import com.tlf.oss.resourceinventory.television.entity.Cobertura;
import com.tlf.oss.resourceinventory.television.repository.DetermineAvailabilityRepository;
import com.tlf.oss.resourceinventory.television.enums.ExceptionInfoEnum;

/**
 * Controller
 * 
 * @author melissa.d.goncalves
 *
 */
public class DetermineAvailabilityController {

	public static final String GPON = "GPON";
	public static final String SIP = "SIP";
	public static final String DTH = "DTH";
	public static final String IPTV = "IPTV";
	public static final String TV_PLATFORM = "TV_PLATFORM"; 

	@Inject
	private DetermineAvailabilityRepository determineAvailabilityRepository;

	@Inject
	OSSLogger logger;

	public ResourceInventoryEntity getDetermineAvailability(@DetermineAvailability ResourceInventoryEntity entity){

		try {
			if (entity != null && entity.getAddress() != null) {
	
				Map<CidadeUf, List<Cobertura>> cobertura = determineAvailabilityRepository.getCobertura();
	
				CidadeUf cidadeUf = new CidadeUf(entity.getAddress().getCity(), entity.getAddress().getStateOrProvince());
				List<Cobertura> coberturaLista = cobertura.get(cidadeUf);
				
				entity.setSatellite(new Satellite());
	
				for (Cobertura selectedCobertura : coberturaLista) {
					
					if (DTH.equalsIgnoreCase(selectedCobertura.getTechnology())) {
						
						entity.getSatellite().getTechnology()
								.add(new Technology(selectedCobertura.getSatellite(), selectedCobertura.getCas()));
					}
				}
				if(entity.getCabinet() != null) {
					coverageIPTV(entity, coberturaLista);
				}
			}
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, ExceptionInfoEnum.RITELEVISION_004.getDescription().concat(" - ").concat("DetermineAvailabilityController - method getDetermineAvailability"));
		}
		
		return entity;
	}
	
	private void coverageIPTV(ResourceInventoryEntity entity, List<Cobertura> coberturaLista) {
		
		Optional<Cobertura> cobIptv = coberturaLista.stream().filter((p) -> IPTV.equalsIgnoreCase(p.getTechnology())
				&& entity.getAddress().getNetworkOwner().equals(p.getNetworkOwner())).findFirst();
		
		ResourceCharacteristicSpecification resourceCharacteristicSpecification =
				new ResourceCharacteristicSpecification();
		
		resourceCharacteristicSpecification.setId(IPTV);
		resourceCharacteristicSpecification.setValue(Boolean.toString(cobIptv.isPresent()));
		
		entity.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(resourceCharacteristicSpecification);

		if(cobIptv.get().getTvPlatform() != null){
			ResourceCharacteristicSpecification resourceCharacteristicSpecificationTVPlatform =
					new ResourceCharacteristicSpecification();
			resourceCharacteristicSpecificationTVPlatform.setId(TV_PLATFORM);
			resourceCharacteristicSpecificationTVPlatform.setValue(cobIptv.get().getTvPlatform());
			entity.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(resourceCharacteristicSpecificationTVPlatform);
		}
		
	}
	
}
