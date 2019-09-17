package com.tlf.oss.resourceinventory.granite.core.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.mapper.InformationFacilityRetrieveGponResourceMapper;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;
import com.tlf.oss.resourceinventory.schemas.ModemResource;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveGponResourceMapper {

	public ResourceInventoryEntity parseGetPhysicalResourceFacility(RetrieveFacilityGponEntity retrieveFacilityGponEntity,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		InformationFacilityRetrieveGponResourceMapper mapper = Mappers.getMapper(InformationFacilityRetrieveGponResourceMapper.class);

		try {
			
			// Mapeamento do IPAddress campo networkNumber
			IPAddress address = mapper.getInformationFacilityLogicalResourceIPAddressMapperObject(retrieveFacilityGponEntity);
			
			// Mapeamento campo ServiceID
			ResourceFacingService resourceFacingService = mapper.getInformationFacilityResourceFacingServiceMapperObject(retrieveFacilityGponEntity);
			entity.setResourceFacingService(resourceFacingService);

			// Mapeamento Cabinet
			Cabinet cabinet = mapper.getInformationFacilityCabinetMapperObject(retrieveFacilityGponEntity);
			cabinet.getHasShelves().add(new Shelf());

			// Mapeamento do SwitchesAssociated (BRASAssociated)
			SwitchesAssociated switchesAssociated = mapper.getInformationFacilitySwitchesAssociatedMapperObject(retrieveFacilityGponEntity);
			cabinet.setBRASAssociated(switchesAssociated);

			// Mapeamento Shelf
			Shelf shelf = mapper.getInformationFacilityShelfResourceMapperObject(retrieveFacilityGponEntity);
			cabinet.getHasShelves().set(0, shelf);
			cabinet.getHasShelves().get(0).setIpAddress(address);

			// Mapeamento do ModemResource para PhysicalLink
			ModemResource modemResource = mapper.getInformationFacilityLogicalResourceModemResourceMapperObject(retrieveFacilityGponEntity);

			// Mapeamento physicalLink
			PhysicalLink physicalLink = mapper.getInformationFacilityPhsicalLinksMapperObject(retrieveFacilityGponEntity, modemResource);
			List<PhysicalLink> physicalLinks = new ArrayList<>();
			physicalLinks.add(physicalLink);
			entity.setPhysicalLinks(physicalLinks);

			// Mapeamento PortAdapterCard
			PortAdapterCard portAdapterCard = mapper.getInformationFacilityPortAdapterCardMapperObject(retrieveFacilityGponEntity);
			List<PortAdapterCard> portAdapterCards = new ArrayList<>();
			portAdapterCards.add(portAdapterCard);
			cabinet.getHasShelves().get(0).setHasCards(portAdapterCards);

			// Mapeamento physicalPort 
			PhysicalPort physicalPort = mapper.getInformationFacilityPhysicalPortMapperObject(retrieveFacilityGponEntity);
			List<PhysicalPort> physicalPorts = new ArrayList<>();
			physicalPorts.add(physicalPort);
			cabinet.getHasShelves().get(0).getHasCards().get(0).setContainsPorts(physicalPorts);

			// Mapeamento physicalPort 
			cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).setLogicalResourceAssociation(new LogicalResourceAssociation());

			// Regra para VIRTUAL_PORT
			if(retrieveFacilityGponEntity.getLogical_port() != null ){
				LogicalResource logicalResourceVirtual = mapper.getInformationFacilityLogicalResourceVirtualPortMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceVirtual);
			}

			// Regra para NASPORT
			if (retrieveFacilityGponEntity.getNasport() != null){
				LogicalResource logicalResourceNas = mapper.getInformationFacilityLogicalResourceNasPortMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceNas);
			}

			// Regra para NASIP
			if(retrieveFacilityGponEntity.getNasip() != null){
				LogicalResource logicalResourceNasip = mapper.getInformationFacilityLogicalResourceNasIpMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceNasip);
			}

			// Regra para Network Vlan
			if(retrieveFacilityGponEntity.getNetwork_vlan() != null){
				LogicalResource logicalResourceNetwork = mapper.getInformationFacilityLogicalResourceNetworkVlanMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceNetwork);
			}

			// Regra para User Vlan
			if(retrieveFacilityGponEntity.getUser_vlan() != null){
				LogicalResource logicalResourceUser = mapper.getInformationFacilityLogicalResourceUserVlanMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceUser);
			}

			// Regra para Voip Vlan
			if(retrieveFacilityGponEntity.getVlan_voip() != null){
				LogicalResource logicalResourceVlan = mapper.getInformationFacilityLogicalResourceVoipVlanMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceVlan);
			}
			
			// Regra para IPV4
			if(retrieveFacilityGponEntity.getFixed_ip_address_v4() != null){
				LogicalResource logicalResourceIP4 = mapper.getInformationFacilityLogicalResourceIPV4MapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceIP4);
			}
			
			// Regra para IPV6
			if(retrieveFacilityGponEntity.getFixed_ip_address_v6() != null){
				LogicalResource logicalResourceIP6 = mapper.getInformationFacilityLogicalResourceIPV6MapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceIP6);
			}
			
			// Regra para Service Description
			if(retrieveFacilityGponEntity.getService_description() != null){
				LogicalResource logicalResourceDescription = mapper.getInformationFacilityLogicalResourceServiceDescriptionMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceDescription);
			}
			
			// Regra para gpon_password
			if(retrieveFacilityGponEntity.getGpon_password() != null){
				LogicalResource logicalResourceGpon = mapper.getInformationFacilityLogicalResourceGponPasswordMapperObject(retrieveFacilityGponEntity);
				cabinet.getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().add(logicalResourceGpon);
			}

			entity.setCabinet(cabinet);

			return entity;

		} catch (Exception e) {
			throw new OSSBusinessException(Code.RIGRANITE_008.getDescription(), Code.RIGRANITE_008.getValue(), e.getMessage());
		}
	}
}
