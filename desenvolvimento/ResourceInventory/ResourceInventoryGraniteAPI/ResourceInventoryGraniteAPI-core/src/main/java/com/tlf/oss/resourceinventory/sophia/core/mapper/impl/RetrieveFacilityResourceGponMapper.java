package com.tlf.oss.resourceinventory.sophia.core.mapper.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mapstruct.factory.Mappers;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.exception.OSSException;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.schemas.AtomicNetworkAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;
import com.tlf.oss.resourceinventory.schemas.ModemResource;
import com.tlf.oss.resourceinventory.schemas.NetworkAddressAssociation;
import com.tlf.oss.resourceinventory.schemas.NetworkRoute;
import com.tlf.oss.resourceinventory.schemas.NetworkRouteAssociation;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.PhysicalResourceSpecAttributes;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.sophia.core.entity.RetrieveFacilityResourceGponEntity;
import com.tlf.oss.resourceinventory.sophia.core.mapper.InformationFacilityRetrieveResourceGponMapper;

public class RetrieveFacilityResourceGponMapper {

	public ResourceInventoryEntity parseGetPhysicalResourceFacility(RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		InformationFacilityRetrieveResourceGponMapper mapper = Mappers.getMapper(InformationFacilityRetrieveResourceGponMapper.class);

		try {
			List<PhysicalLink> physicalLinks = getPhysicalLinks(retrieveFacilityGponEntity, mapper);
			ResourceFacingService resourceFacingService = mapper.getInformationFacilityResourceFacingServiceMapperObject(retrieveFacilityGponEntity);
			PhysicalResource physicalResource = getIPAddress(retrieveFacilityGponEntity, mapper);
			List<CustomerFacingService> customerFacingServices =getCustomerFacingService(retrieveFacilityGponEntity, mapper);
			
			Cabinet cabinet = mapper.getInformationFacilityCabinetMapperObject(retrieveFacilityGponEntity);
			PhysicalResourceSpecAttributes physicalResourceSpecAttributes = mapper.getInformationFacilityPhysicalResourceSpecAttributesMapperObject(retrieveFacilityGponEntity);
			AtomicNetworkAddress atomicNetworkAddress = getAtomicNetworkAddress(retrieveFacilityGponEntity, mapper);
			List<PortAdapterCard> portAdapterCards = getPortAdapterCard(retrieveFacilityGponEntity, mapper);

			Shelf shelf =  getShelf(retrieveFacilityGponEntity,atomicNetworkAddress,physicalResourceSpecAttributes,portAdapterCards,mapper);

			cabinet.getHasShelves().add(shelf);

			entity = mapper.getInformationFacilityCabinetResourceMapperObject(cabinet, physicalResource, physicalLinks, resourceFacingService, customerFacingServices, entity);

			return entity;

		} catch (Exception e) {
			throw new OSSBusinessException(Code.RIGRANITE_008.getDescription(), Code.RIGRANITE_008.getValue(), e.getMessage());
		}
	}

	private List<CustomerFacingService> getCustomerFacingService(RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity,InformationFacilityRetrieveResourceGponMapper mapper) throws Exception{

		CustomerFacingService customerFacingService = new CustomerFacingService();
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		if ("S".equalsIgnoreCase(retrieveFacilityGponEntity.getFixed_ip_flag()))
			serviceSpecCharDescribes.setValue("FIXED");
		else
			serviceSpecCharDescribes.setValue("DYNAMIC");

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
		customerFacingService.getServiceDescribedBy().add(serviceDescribedBy);
		List<CustomerFacingService> customerFacingServices = new ArrayList<>();
		customerFacingServices.add(customerFacingService);
		return customerFacingServices;
	}

	private List<PortAdapterCard> getPortAdapterCard(RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity,InformationFacilityRetrieveResourceGponMapper mapper) throws Exception{

		PhysicalPort physicalPort =  mapper.getInformationFacilityPhysicalPortMapperObject(retrieveFacilityGponEntity);
		List<PhysicalPort> physicalPorts = new ArrayList<>();
		physicalPorts.add(physicalPort);

		PortAdapterCard portAdapterCard = mapper.getInformationFacilityPortAdapterCardMapperObject(retrieveFacilityGponEntity,physicalPorts);
		List<PortAdapterCard> portAdapterCards = new ArrayList<>();
		portAdapterCards.add(portAdapterCard);

		return portAdapterCards;
	}

	private AtomicNetworkAddress getAtomicNetworkAddress(RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity,InformationFacilityRetrieveResourceGponMapper mapper) throws Exception{

		return mapper.getInformationFacilityAtomicNetworkAddressMapperObject(retrieveFacilityGponEntity);
	}

	private List<PhysicalLink> getPhysicalLinks(RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity,InformationFacilityRetrieveResourceGponMapper mapper) throws Exception{

		ModemResource modemResource = mapper.getInformationFacilityModemResourcePhsicalLinksMapperObject(retrieveFacilityGponEntity);
		PhysicalLink physicalLink = mapper.getInformationFacilityPhsicalLinksMapperObject(retrieveFacilityGponEntity, modemResource);
		List<PhysicalLink> physicalLinks = new ArrayList<>();
		physicalLinks.add(physicalLink);
		return physicalLinks;
	}
	
	private PhysicalResource getIPAddress(RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity,InformationFacilityRetrieveResourceGponMapper mapper) throws Exception{
		PhysicalResource physicalResource = mapper.getInformationFacilityNetworkAggregatorMapperObject(retrieveFacilityGponEntity);
		IPAddress ipAddressNetworkAddressAssociation = mapper.getInformationFacilityIPAddressNetworkAddressAssociationMapperObject(retrieveFacilityGponEntity);
		physicalResource.setNetworkAddressAssociation(new NetworkAddressAssociation());
		IPAddress ipv6 = mapper.getInformationFacilityIPAddressIPV6MapperObject(retrieveFacilityGponEntity);
		IPAddress ipv4 = mapper.getInformationFacilityIPAddressIPV4MapperObject(retrieveFacilityGponEntity);
		physicalResource.getNetworkAddressAssociation().setIpAddressList(Arrays.asList(ipAddressNetworkAddressAssociation,ipv4,ipv6));
		return physicalResource;
	}

	private Shelf getShelf(RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity, AtomicNetworkAddress atomicNetworkAddress, PhysicalResourceSpecAttributes physicalResourceSpecAttributes,List<PortAdapterCard> portAdapterCards,InformationFacilityRetrieveResourceGponMapper mapper) throws Exception{

		NetworkRoute networkRouteNasPost  = mapper.getInformationFacilityNetworkRouteNasPortMapperObject(retrieveFacilityGponEntity);
		NetworkRouteAssociation networkRouteAssociationNasPort = new NetworkRouteAssociation();
		networkRouteAssociationNasPort.getNetworkRoute().add(networkRouteNasPost);

		NetworkRoute networkRouteVlanNetwork = mapper.getInformationFacilityNetworkRouteInternetMapperObject(retrieveFacilityGponEntity);
		NetworkRouteAssociation networkRouteAssociationNetWorkVlan = new NetworkRouteAssociation();
		networkRouteAssociationNetWorkVlan.getNetworkRoute().add(networkRouteVlanNetwork);

		NetworkRoute networkRouteVlanUser = mapper.getInformationFacilityNetworkRouteUserMapperObject(retrieveFacilityGponEntity);
		NetworkRouteAssociation networkRouteAssociationUserVlan = new NetworkRouteAssociation();
		networkRouteAssociationUserVlan.getNetworkRoute().add(networkRouteVlanUser);

		NetworkRoute networkRouteVlanVoip = mapper.getInformationFacilityNetworkRouteVoipVlanMapperObject(retrieveFacilityGponEntity);
		NetworkRouteAssociation networkRouteAssociationVlanVoip = new NetworkRouteAssociation();
		networkRouteAssociationVlanVoip.getNetworkRoute().add(networkRouteVlanVoip);

		LogicalResource logicalResourceNasPort = mapper.getInformationFacilityLogicalResourceMapperObject(networkRouteAssociationNasPort);
		LogicalResource logicalResourceNetWorkVlan = mapper.getInformationFacilityLogicalResourceMapperObject(networkRouteAssociationNetWorkVlan);
		LogicalResource logicalResourceUserVlan = mapper.getInformationFacilityLogicalResourceMapperObject(networkRouteAssociationUserVlan);
		LogicalResource logicalResourceVlanVoip = mapper.getInformationFacilityLogicalResourceMapperObject(networkRouteAssociationVlanVoip);

		LogicalResourceAssociation logicalResourceAssociationAggregator = new LogicalResourceAssociation();
		logicalResourceAssociationAggregator.getLogicalResource().add(logicalResourceNasPort);
		logicalResourceAssociationAggregator.getLogicalResource().add(logicalResourceNetWorkVlan);
		logicalResourceAssociationAggregator.getLogicalResource().add(logicalResourceUserVlan);
		logicalResourceAssociationAggregator.getLogicalResource().add(logicalResourceVlanVoip);

		return mapper.getInformationFacilityShelfResourceMapperObject(logicalResourceAssociationAggregator,atomicNetworkAddress,physicalResourceSpecAttributes,portAdapterCards);
	}

}
