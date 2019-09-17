package com.tlf.oss.resourceinventory.granite.core.mapper.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.exception.OSSException;
import com.tlf.oss.resourceinventory.granite.core.entity.AvailabilityRetrieveActiveMsanDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.mapper.AcessResourceInformationMapper;
import com.tlf.oss.resourceinventory.granite.core.mapper.AvailabilityRetrieveResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.mapper.InformationFacilityRetrieveResourceMapper;
import com.tlf.oss.resourceinventory.schemas.AtomicNetworkAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.GeneralDistributor;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;
import com.tlf.oss.resourceinventory.schemas.NetworkAddressAssociation;
import com.tlf.oss.resourceinventory.schemas.NetworkRoute;
import com.tlf.oss.resourceinventory.schemas.NetworkRouteAssociation;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.PhysicalResourceSpecAttributes;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveResourceMapper {

	public ResourceInventoryEntity parseGetPhysicalResourceAvailabilityMsan(List<RetrieveAvailabilityMsanEntity> response,ResourceInventoryEntity entity) throws OSSBusinessException{

		AvailabilityRetrieveResourceMapper mapper = Mappers.getMapper(AvailabilityRetrieveResourceMapper.class);

		try {
			//2º Mapeia para modelo canonico, atualiza e devolve para camada acima
			List<PortAdapterCard> portAdpter = mapper.getAvailabilityResourceSummaryResourceMsanMapperObject(response);

			entity.getCabinet().getHasShelves().get(0).getHasCards().addAll(portAdpter);
		} catch (Exception e) {
			throw new OSSBusinessException("Erro ao retornar o objeto ReserveAvailabilityResourceServiceMsan", Code.RIGRANITE_001.getValue(), e.getMessage());
		}

		return entity;
	}
	
	/**
	 * Metodo responsavel por mapear as informacoes de response para DSLAN
	 * @throws OSSBusinessException 
	 */
	public ResourceInventoryEntity parseGetPhysicalResourceAvailabilityDslam(
			Collection<RetrieveAvailabilityDslamEntity> availabilityResultCollection, ResourceInventoryEntity entity)
			throws OSSBusinessException {
		
		if (availabilityResultCollection != null && !availabilityResultCollection.isEmpty()) {
			try {
				
				Collection<RetrieveAvailabilityDslamEntity> orderedList = sortResult(availabilityResultCollection);
			
				orderedList.forEach(p -> {
					PortAdapterCard port = new PortAdapterCard();
					//Novo objeto criado apenas para funcionar 
					//o retorno correto do entity
					//EX:<hasShelves><hasCards><technology>VDSL</technology><technology>ADSL</technology></hasCards>
					port.setTechnology(p.getTechnology());
					port.setFreePorts(String.valueOf(p.getQuantityPort()));
					port.setMaxBroadbandSpeed(String.valueOf(p.getSpeed()));

					entity.getCabinet().getHasShelves().get(0).getHasCards().add(port);
				});
			
			
			} catch (Exception e) {
				throw new OSSBusinessException("Erro ao retornar o objeto ReserveAvailabilityResourceServiceDslam", Code.RIGRANITE_001.getValue(), e.getMessage());
			}
		}
		return entity;
	}
	
	public ResourceInventoryEntity parseGetResourceRetrieveActiveMsanDslam(
			Collection<AvailabilityRetrieveActiveMsanDslamEntity> availabilityResultCollection, ResourceInventoryEntity entity)
			throws OSSBusinessException {
		
		if (availabilityResultCollection != null && !availabilityResultCollection.isEmpty()) {
			try {
				
				Collection<AvailabilityRetrieveActiveMsanDslamEntity> orderedList = sortResultActiveMsanDslam(availabilityResultCollection);
			
				orderedList.forEach(p -> {
					PortAdapterCard port = new PortAdapterCard();
					port.setTechnology(p.getTypeEquipment());
					port.setFreePorts(String.valueOf(p.getQuantityPort()));
					port.setMaxBroadbandSpeed(String.valueOf(p.getSpeed()));

					entity.getCabinet().getHasShelves().get(0).getHasCards().add(port);
				});
			
			
			} catch (Exception e) {
				throw new OSSBusinessException("Erro no mapper de retorno parseGetResourceRetrieveActiveMsanDslam", Code.RIGRANITE_001.getValue(), e.getMessage());
			}
		}
		return entity;
	}
	

	/*
	 * orderna de acordo com a regra de velocidade onde a maior velocidade inicia a lista
	 */
	private Collection<RetrieveAvailabilityDslamEntity> sortResult(Collection<RetrieveAvailabilityDslamEntity> availabilityResultCollection) {
		return availabilityResultCollection
				.stream()
				.sorted((p1, p2) -> p2.getSpeed().compareTo(p1.getSpeed()))
				.collect(Collectors.toList());
	}
	
	private Collection<AvailabilityRetrieveActiveMsanDslamEntity> sortResultActiveMsanDslam(Collection<AvailabilityRetrieveActiveMsanDslamEntity> availabilityResultCollection) {
		return availabilityResultCollection
				.stream()
				.sorted((p1, p2) -> p2.getSpeed().compareTo(p1.getSpeed()))
				.collect(Collectors.toList());
	}
	

	public ResourceInventoryEntity parseGetPhysicalResourceFacility(RetrieveFacilityEntity getInternalResourceFacilityIn, ResourceInventoryEntity entity) throws OSSBusinessException {
		InformationFacilityRetrieveResourceMapper mapper = Mappers.getMapper(InformationFacilityRetrieveResourceMapper.class);
		try {			
			IPAddress ipAddressNetworkAddressAssociation = mapper.getInformationFacilityIPAddressNetworkAddressAssociationMapperObject(getInternalResourceFacilityIn);
			IPAddress ipAddressShelft = mapper.getInformationFacilityIPAddressShelftMapperObject(getInternalResourceFacilityIn);

			NetworkAddressAssociation networkAddressAssociationMasc =  mapper.getInformationFacilityNetworkAddressAssociationResourceMapperObject(ipAddressNetworkAddressAssociation);
			
			AtomicNetworkAddress atomicNetworkAddress = mapper.getInformationFacilityAtomicNetworkAddressMapperObject(getInternalResourceFacilityIn);

			NetworkAddressAssociation networkAddressAssociationShelf = mapper.getInformationFacilityNetworkAddressAssociationResourceShelfMapperObject(ipAddressShelft,atomicNetworkAddress);

			NetworkRoute networkRouteInternet  = mapper.getInformationFacilityNetworkRouteInternetMapperObject(getInternalResourceFacilityIn);
			
			NetworkRouteAssociation networkRouteAssociationInternet = new NetworkRouteAssociation();
			networkRouteAssociationInternet.getNetworkRoute().add(networkRouteInternet);
			
			NetworkRoute networkRouteVoip  = mapper.getInformationFacilityNetworkRouteVoipMapperObject(getInternalResourceFacilityIn);
			
			NetworkRouteAssociation networkRouteAssociationVoip = new NetworkRouteAssociation();
			networkRouteAssociationVoip.getNetworkRoute().add(networkRouteVoip);

			NetworkRoute networkRouteAggregator  = mapper.getInformationFacilityNetworkRouteAggregatorMapperObject(getInternalResourceFacilityIn);
			

			NetworkRouteAssociation networkRouteAssociationAggregator = new NetworkRouteAssociation();
			networkRouteAssociationAggregator.getNetworkRoute().add(networkRouteAggregator);
			
			NetworkRoute networkRouteNasPost  = mapper.getInformationFacilityNetworkRouteAggregatorNasPostMapperObject(getInternalResourceFacilityIn);
			
			NetworkRouteAssociation networkRouteAssociationNasPost = new NetworkRouteAssociation();
			networkRouteAssociationNasPost.getNetworkRoute().add(networkRouteNasPost);
			
			LogicalResource logicalResourceInternet = mapper.getInformationFacilityLogicalResourceMapperObject(networkRouteAssociationInternet);
			LogicalResource logicalResourceVoip = mapper.getInformationFacilityLogicalResourceMapperObject(networkRouteAssociationVoip);
			LogicalResource logicalResourceAggregator = mapper.getInformationFacilityLogicalResourceMapperObject(networkRouteAssociationAggregator);
			
			LogicalResource logicalResourceNaspost = mapper.getInformationFacilityLogicalResourceNaspostMapperObject(networkRouteAssociationNasPost);
			
			LogicalResourceAssociation logicalResourceAssociationShelf = new LogicalResourceAssociation();
			logicalResourceAssociationShelf.getLogicalResource().add(logicalResourceInternet);
			logicalResourceAssociationShelf.getLogicalResource().add(logicalResourceVoip);
			
			LogicalResourceAssociation logicalResourceAssociationAggregator = new LogicalResourceAssociation();
			
			logicalResourceAssociationAggregator.getLogicalResource().add(logicalResourceAggregator);
			
			PhysicalPort PhysicalPort = mapper.getInformationFacilityPhysicalPortMapperObject(getInternalResourceFacilityIn, logicalResourceAssociationAggregator);
			
			PortAdapterCard portAdapterCard = mapper.getInformationFacilityPortAdapterCardMapperObject(getInternalResourceFacilityIn);
			portAdapterCard.getContainsPorts().add(PhysicalPort);
			
			Shelf shelf = mapper.getInformationFacilityShelfResourceMapperObject(getInternalResourceFacilityIn, networkAddressAssociationShelf, logicalResourceAssociationShelf);
			
			Cabinet cabinet = mapper.getInformationFacilityCabinetMapperObject(getInternalResourceFacilityIn);
			cabinet.getHasShelves().add(shelf);
			
			PhysicalResourceSpecAttributes physicalResourceSpecAttributes = mapper.getInformationFacilityPhysicalResourceSpecAttributesMapperObject(getInternalResourceFacilityIn);
			
			LogicalResourceAssociation logicalResourceAssociationNasPost = new LogicalResourceAssociation();
			logicalResourceAssociationNasPost.getLogicalResource().add(logicalResourceNaspost);

			PhysicalResource physicalResource = mapper.getInformationFacilityPhysicalResourceMapperObject(physicalResourceSpecAttributes, logicalResourceAssociationNasPost,networkAddressAssociationMasc);

			Optional<Shelf> optionalShelft = Optional.ofNullable(shelf);
			Optional<PortAdapterCard> optionalPortAdapterCard =Optional.ofNullable(portAdapterCard);
			
			List<GeneralDistributor> listGeneralDistributor = new ArrayList<>();
			//Novos campos adicionados para consulta facilidade
			GeneralDistributor generalDistributorOne = mapper.getInformationFacilityGeneralDistribuitorOneMapperObject(getInternalResourceFacilityIn);
			listGeneralDistributor.add(generalDistributorOne);
			GeneralDistributor generalDistributorTwo = mapper.getInformationFacilityGeneralDistribuitorTwoMapperObject(getInternalResourceFacilityIn);
			listGeneralDistributor.add(generalDistributorTwo);

			//HasCards
			optionalShelft.get().getHasCards().add(optionalPortAdapterCard.get());

			entity = mapper.getInformationFacilityCabinetResourceMapperObject(cabinet, physicalResource,listGeneralDistributor,entity);
		} catch (Exception e) {
			throw new OSSException("Erro no mapper de retorno parseGetPhysicalResourceFacility", e.getMessage());
		}

		return entity;
	}

	public ResourceInventoryEntity parseGetAccessResourceInformationMsan(List<RetrieveAccessResourceInformationMsanEntity> getAccessResourceInformationMsanEntity,ResourceInventoryEntity entity) throws OSSBusinessException {

		AcessResourceInformationMapper mapper = Mappers.getMapper(AcessResourceInformationMapper.class);
		ResourceInventoryEntity getAccessResourceInformationOut = new ResourceInventoryEntity();
		//2º Mapeia para modelo canonico, e devolve para camada acima
		try {
			getAccessResourceInformationOut = mapper.getAcessResourceInformationMapperObject(entity);

			List<PhysicalLink> physicalLink = mapper.getAcessResourceInformationListMsanMapperObject(getAccessResourceInformationMsanEntity);

			for (PhysicalLink physicalLink2 : physicalLink) {
				
				getAccessResourceInformationOut.getPhysicalLinks().add(physicalLink2);
			}

		} catch (Exception e) {
			throw new OSSBusinessException("Erro ao retornar o objeto AcessResourceServiceMsan", Code.RIGRANITE_001.getValue(), e.getMessage());
		}

		return getAccessResourceInformationOut;
	}
	
	public ResourceInventoryEntity parseGetAccessResourceInformationDslam(List<RetrieveAccessResourceInformationDslamEntity> getAccessResourceInformationDslamEntity, ResourceInventoryEntity entity) throws OSSBusinessException {
		AcessResourceInformationMapper mapper = Mappers.getMapper(AcessResourceInformationMapper.class);
		ResourceInventoryEntity getAccessResourceInformationOut = new ResourceInventoryEntity();

		//2º Mapeia para modelo canonico, e devolve para camada acima
		try {
			getAccessResourceInformationOut = mapper.getAcessResourceInformationMapperObject(entity);
			List<PhysicalLink> physicalLink = mapper.getAcessResourceInformationListDslamMapperObject(getAccessResourceInformationDslamEntity);

			for (PhysicalLink physicalLink2 : physicalLink) {

				getAccessResourceInformationOut.getPhysicalLinks().add(physicalLink2);
			}

		} catch (Exception e) {
			throw new OSSBusinessException("Erro ao retornar o objeto AcessResourceServiceDslam", Code.RIGRANITE_001.getValue(), e.getMessage());
		}

		return getAccessResourceInformationOut;
	}

}
