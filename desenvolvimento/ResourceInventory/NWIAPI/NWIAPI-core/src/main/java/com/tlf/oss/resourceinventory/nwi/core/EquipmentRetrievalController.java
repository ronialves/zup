package com.tlf.oss.resourceinventory.nwi.core;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.nwi.core.utils.Constants;
import com.tlf.oss.resourceinventory.nwi.core.validation.EquipmentRetrieval;
import com.tlf.oss.resourceinventory.nwi.repository.EquipmentRetrievalRepository;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class EquipmentRetrievalController {

	@Inject
	private OSSLogger logger;

	@Inject
	private EquipmentRetrievalRepository equipmentRetrievalRepository;

	/**
	 * Consulta os Equipamentos no SIGITM
	 * 
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity retrieval(@EquipmentRetrieval ResourceInventoryEntity entity)
			throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Iniciando fluxo do retrieval.");
		String flow = identifyFlow(entity);		
		String origin = identifyOrigin(entity);
		
		if(Constants.CABINET.equals(flow) || (Constants.EQUIPMENT.equals(flow) && Constants.NWI.equals(origin))) {
			equipmentRetrievalRepository.getEquipment(entity, flow);
		} 
		
		return entity;
	}
	
	/**
	 * Verifica o fluxo de Consultas aos Equipamentos.
	 * @param entity
	 * @return {@link String}
	 */
	private String identifyFlow(ResourceInventoryEntity entity) {
		
		logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Identificando tipo de consulta.");
		
		List<ServiceDescribedBy> serviceDescribedBys = entity.getResourceFacingService().getServiceDescribedBy();
		for (ServiceDescribedBy serviceDescribedBy : serviceDescribedBys) {
			if (serviceDescribedBy.getName().equals(Constants.EQUIPMENT)) {
				Optional<ServiceSpecCharDescribes> serviceSpecCharDescribe = serviceDescribedBy.getServiceSpecCharDescribes().stream().filter(s -> s.getValueType().equals(Constants.HOSTNAME)).findFirst();
				if (serviceSpecCharDescribe.get().getValue() != null) {
					return Constants.EQUIPMENT;
				}
			}
		}
	
		return Constants.CABINET;
	}		
	
	/**
	 * Verifica a origem.
	 * @param entity
	 * @return {@link String}
	 */
	private String identifyOrigin(ResourceInventoryEntity entity) {

		logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Identificando a origem do equipamento.");

		String origin = null;
		List<ServiceDescribedBy> serviceDescribedBys = entity.getResourceFacingService().getServiceDescribedBy();
		for (ServiceDescribedBy serviceDescribedBy : serviceDescribedBys) {
			if (serviceDescribedBy.getName().equals(Constants.EQUIPMENT)) {
				Optional<ServiceSpecCharDescribes> serviceSpecCharDescribe = serviceDescribedBy.getServiceSpecCharDescribes().stream().filter(s -> s.getValueType().equals(Constants.ORIGIN)).findFirst();
				if (serviceSpecCharDescribe.isPresent() && serviceSpecCharDescribe.get().getValue() != null) {
					origin = serviceSpecCharDescribe.get().getValue();
				}
			}
		}
		
		logger.log(OSSLogger.DEBUG, "Equipamento com a origem: " + origin);


		return origin;
	}		

}
