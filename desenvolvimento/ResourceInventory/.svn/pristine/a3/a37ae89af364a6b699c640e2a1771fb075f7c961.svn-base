package com.tlf.oss.resourceinventory.tbs.core.v2_0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.entity.v2_0.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.tbs.enums.EntityFields;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.v2_0.FacilityResourceRepository;

/**
 * BEATRIXTWO-70 | DEMOSS-2285
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@SuppressWarnings("serial")
public class FacilityResourceController implements Serializable {

	@Inject
	FacilityResourceRepository facilityResourceRepository;

	@Inject
	OSSLogger logger;

	public static final int RESULTADO_ESPERADO = 0;
	public static final String VENDA = "N";
	public static final String P_DOWNSTREAM = "Downstream";
	public static final String P_UPSTREAM = "Upstream";
	public static final String P_HSI = "HSI";
	public static final String P_VOIP = "VOIP";
	public static final String P_VOD = "UNICAST";
	public static final String P_MCAST = "MULTICAST";

	/**
	 * Retorna atraves do {@link RetrieveFacilityEntity}, o
	 * {@link ResourceInventoryEntity} enriquecido
	 * 
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity retrieveFacility(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO,
				"[FacilityResourceController] Tranformando ResourceInventoryEntity em RetrieveFacilityEntity");

		RetrieveFacilityEntity retrieve = new RetrieveFacilityEntity();

		retrieve.setDesignator(entity.getResourceFacingService().getServiceId());
		retrieve.setActivity(VENDA);

		logger.log(OSSLogger.INFO,
				"[FacilityResourceController] Realizando chamada do facilityResourceDAO.retrieveFacility");

		return getResourceInventoryEntity(facilityResourceRepository.retrieveFacility(retrieve), entity);
	}

	/**
	 * Realiza enriquecimento do {@link ResourceInventoryEntity} atraves da execucao
	 * do facilityResourceDAO.retrieveFacility
	 * 
	 * @param retrieve
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(RetrieveFacilityEntity retrieve,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		if (RESULTADO_ESPERADO != retrieve.getResultCode()) {
			logger.log(OSSLogger.ERROR, ExceptionInfoEnum.RITBS_003.getCode().concat(" - ")
					.concat(retrieve.getMessage()).concat(" - ").concat(String.valueOf(retrieve.getResultCode())));
		} else {

			logger.log(OSSLogger.INFO,
					"[FacilityResourceController] Iniciando enriquecimento do ResourceInventoryEntity"
							.concat(" - RetrieveEntity: ").concat(retrieve.toString()));

			Cabinet cabinet = buildCabinet(retrieve, entity);

			PhysicalResource networkAggregator = new PhysicalResource();
			networkAggregator.setAccessTecnology(retrieve.getAccessTechnology());// P_TECNOLOGIA

			ResourceFacingService resourceFacingService = buildResourceFacingService(retrieve);

			entity.setCabinet(cabinet);
			entity.setNetworkAggregator(networkAggregator);
			entity.setResourceFacingService(resourceFacingService);

			logger.log(OSSLogger.INFO,
					"[FacilityResourceController] Enriquecimento do ResourceInventoryEntity concluido");

		}

		return entity;
	}

	/**
	 * Realiza enriquecimento do objeto {@link Cabinet}
	 * @param retrieval
	 * @return Cabinet
	 */
	private Cabinet buildCabinet(RetrieveFacilityEntity retrieval, ResourceInventoryEntity entity){
		Cabinet cabinet = null;
		
		if(entity.getCabinet() == null){
			cabinet = new Cabinet();
		} else {
			cabinet = entity.getCabinet();
		}

		cabinet.setType(retrieval.getAccessTechnology());
		cabinet.setName(retrieval.getCabinet());
		cabinet.setSwitchesAssociated(buildCabinetSwitchesAssociated(retrieval.getSwitchAtendimento()));
		cabinet.setBRASAssociated(buildCabinetSwitchesAssociated(retrieval.getShasta()));				
		cabinet.setHasShelves(buildCabinetHasShelves(retrieval));
		
		logger.log(OSSLogger.INFO, "[FacilityResourceController] Enriquecimento do resourceInventoryEntity.cabinet");
		
		return cabinet;
	}

	/**
	 * Retorna o objeto SwitchesAssociated para o Cabinet
	 * 
	 * @param retrieval
	 * @param name
	 * @return SwitchesAssociated
	 */
	private SwitchesAssociated buildCabinetSwitchesAssociated(String name) {
		SwitchesAssociated switches = new SwitchesAssociated();
		switches.setName(name);
		return switches;
	}

	/**
	 * Retorna o objeto HasShelves para o Cabinet
	 * 
	 * @param retrieval
	 * @return List
	 */
	private List<Shelf> buildCabinetHasShelves(RetrieveFacilityEntity retrieval) {
		List<Shelf> hasShelves = new ArrayList<Shelf>();
		Shelf shelf = new Shelf();
		shelf.setModel(retrieval.getShelfModel());
		shelf.setVendor(retrieval.getVendorName());
		shelf.setName(retrieval.getDslamName());
		IPAddress ipAddress = new IPAddress();
		ipAddress.setNetworkNumber(retrieval.getIpAddress());
		shelf.setIpAddress(ipAddress);
		shelf.setHasCards(buildCabinetHasCards(retrieval));
		hasShelves.add(shelf);
		return hasShelves;
	}

	/**
	 * Retorna o objeto HasCards para o Cabinet
	 * 
	 * @param retrieval
	 * @return List
	 */
	private List<PortAdapterCard> buildCabinetHasCards(RetrieveFacilityEntity retrieval) {
		List<PortAdapterCard> hasCards = new ArrayList<PortAdapterCard>();
		PortAdapterCard card = new PortAdapterCard();
		card.setSlot(retrieval.getSlot());
		card.setVendor(retrieval.getVendorName());
		card.setModel(retrieval.getBoardModel());
		card.setContainsPorts(buildCabinetConstainsPorts(retrieval));
		hasCards.add(card);
		return hasCards;
	}

	/**
	 * Retorna o objeto ConstainsPorts para o Cabinet
	 * 
	 * @param retrieval
	 * @return List
	 */
	private List<PhysicalPort> buildCabinetConstainsPorts(RetrieveFacilityEntity retrieval) {
		List<PhysicalPort> containsPorts = new ArrayList<PhysicalPort>();
		PhysicalPort port = new PhysicalPort();
		port.setId(formataString(retrieval.getPort()));
		port.setLogicalResourceAssociation(buildCabinetLogicalResourceAssociation(retrieval));
		containsPorts.add(port);
		return containsPorts;
	}

	/**
	 * Retorna o objeto LogicalResourceAssociation para o Cabinet
	 * 
	 * @param retrieval
	 * @return List
	 */
	private LogicalResourceAssociation buildCabinetLogicalResourceAssociation(RetrieveFacilityEntity retrieval) {
		LogicalResourceAssociation logicalResourceAssociation = new LogicalResourceAssociation();
		
		if (retrieval.getPortLogic() != null && !retrieval.getPortLogic().isEmpty()) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(formataString(retrieval.getPortLogic()));
			logicalResource.setTypeOfResource(EntityFields.VIRTUAL_PORT.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		if (retrieval.getCvlan() != null && !retrieval.getCvlan().isEmpty()) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(retrieval.getCvlan());
			logicalResource.setName(EntityFields.CUSTOMER.getValue());
			logicalResource.setTypeOfResource(EntityFields.VLAN.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		if (retrieval.getSvlan() != null && !retrieval.getSvlan().isEmpty()) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(retrieval.getSvlan());
			logicalResource.setName(EntityFields.HSI.getValue());
			logicalResource.setTypeOfResource(EntityFields.VLAN.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		if (retrieval.getVlanVoip() != null) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(String.valueOf(retrieval.getVlanVoip()));
			logicalResource.setName(EntityFields.VOIP.getValue());
			logicalResource.setTypeOfResource(EntityFields.VLAN.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		if (retrieval.getVlanVod() != null) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(String.valueOf(retrieval.getVlanVod()));
			logicalResource.setName(EntityFields.UNICAST.getValue());
			logicalResource.setTypeOfResource(EntityFields.VLAN.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		if (retrieval.getVlanMulticast() != null) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(String.valueOf(retrieval.getVlanMulticast()));
			logicalResource.setName(EntityFields.MULTICAST.getValue());
			logicalResource.setTypeOfResource(EntityFields.VLAN.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		if (EntityFields.IPV4.equals(getIPType(retrieval.getIpAddress()))) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(retrieval.getIpAddress());
			logicalResource.setName(EntityFields.IPV4.getValue());
			logicalResource.setTypeOfResource(EntityFields.STATIC_IP.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		if (EntityFields.IPV6.equals(getIPType(retrieval.getIpAddress()))) {
			LogicalResource logicalResource = new LogicalResource();
			logicalResource.setValue(retrieval.getIpAddress());
			logicalResource.setName(EntityFields.IPV6.getValue());
			logicalResource.setTypeOfResource(EntityFields.STATIC_IP.getValue());
			logicalResourceAssociation.getLogicalResource().add(logicalResource);
		}

		return logicalResourceAssociation;
	}

	/**
	 * Necessario para caso venha um valor com caracter inexperado não estourar e
	 * lancar excecao
	 * 
	 * @param value
	 * @return O valor formatado
	 */
	private String formataString(String value) {
		int valueInt;

		try {
			valueInt = Integer.parseInt(value);

		} catch (Exception e) {

			return value;
		}

		return String.valueOf(valueInt);
	}

	/**
	 * Realiza enriquecimento do {@link ResourceFacingService}
	 * 
	 * @param retrieve
	 * @return ResourceFacingService
	 */
	private ResourceFacingService buildResourceFacingService(RetrieveFacilityEntity retrieve) {
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		List<ServiceDescribedBy> streamList = new ArrayList<ServiceDescribedBy>();
		ServiceDescribedBy downstream = new ServiceDescribedBy();
		ServiceDescribedBy upstream = new ServiceDescribedBy();
		ServiceSpecCharDescribes downstreamSpec = new ServiceSpecCharDescribes();
		ServiceSpecCharDescribes upstreamSpec = new ServiceSpecCharDescribes();

		downstreamSpec.setValue(retrieve.getDownstream());// P_DOWNSTREAM
		downstream.setName(P_DOWNSTREAM);
		downstream.getServiceSpecCharDescribes().add(downstreamSpec);

		upstreamSpec.setValue(retrieve.getUpstream());// P_UPSTREAM
		upstream.setName(P_UPSTREAM);
		upstream.getServiceSpecCharDescribes().add(upstreamSpec);

		streamList.add(downstream);
		streamList.add(upstream);

		resourceFacingService.setServiceDescribedBy(streamList);
		resourceFacingService.setServiceId(retrieve.getDesignadorAcesso());

		logger.log(OSSLogger.INFO,
				"[FacilityResourceController] Enriquecimento do resourceInventoryEntity.resourceFacingService");

		return resourceFacingService;
	}

	public String getIPType(String ip) {
		if (ip.contains(".")) {
			return EntityFields.IPV4.getValue();
		} else if (ip.contains(":")) {
			return EntityFields.IPV6.getValue();
		}
		return "";
	}

}
