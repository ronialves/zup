package com.tlf.oss.resourceinventory.sophia.core.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.sophia.core.entity.RetrieveFacilityResourceGponEntity;

@Mapper
public interface InformationFacilityRetrieveResourceGponMapper {

	@Mappings({
		@Mapping(target="cabinet", source="cabinet"),
		@Mapping(target="networkAggregator", source="physicalResource"),
		@Mapping(target="physicalLinks", source="physicalLinks"),
		@Mapping(target="resourceFacingService", source="resourceFacingService"),
		@Mapping(target="customerFacingService", source="customerFacingServices"),		
		@Mapping(target="address", source="entity.address")})
	public ResourceInventoryEntity getInformationFacilityCabinetResourceMapperObject(Cabinet cabinet, PhysicalResource physicalResource,List<PhysicalLink> physicalLinks,ResourceFacingService resourceFacingService,List<CustomerFacingService> customerFacingServices,ResourceInventoryEntity entity) throws Exception;

	@Mappings({
		@Mapping(target="networkAddressAssociation.atomicNetworkAddress", source="networkAddressAssociationAtomic"),
		@Mapping(target="logicalResourceAssociation", source="logicalResourceAssociation"),
		@Mapping(target="physicalResourceSpecAttributes", source="physicalResourceSpecAttributes"),
		@Mapping(target="hasCards", source="portAdapterCards")})
	public Shelf getInformationFacilityShelfResourceMapperObject(LogicalResourceAssociation logicalResourceAssociation, AtomicNetworkAddress networkAddressAssociationAtomic, PhysicalResourceSpecAttributes physicalResourceSpecAttributes,List<PortAdapterCard> portAdapterCards )throws Exception;

	@Mappings({
		@Mapping(target="serviceId", source="retrieveFacilityEntity.terminalNumber")})
	public ResourceFacingService getInformationFacilityResourceFacingServiceMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="physicalResource.name", source="retrieveFacilityEntity.aggregatorEquipmentName")})
	public PhysicalResource getInformationFacilityNetworkAggregatorMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
	@Mapping(target="primaryCable", source="retrieveFacilityEntity.primaryCable"),
	@Mapping(target="primaryFiber", source="retrieveFacilityEntity.primaryFiber")})
	public Cabinet getInformationFacilityCabinetMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="hostname", source="retrieveFacilityEntity.accessEquipmentName")})
	public AtomicNetworkAddress getInformationFacilityAtomicNetworkAddressMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="networkNumber", source="retrieveFacilityEntity.nasip")})
	public IPAddress getInformationFacilityIPAddressNetworkAddressAssociationMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
	@Mapping(target="type", constant="IPV4"),
	@Mapping(target="networkNumber", source="retrieveFacilityEntity.fixed_ip_address_v4")})
	public IPAddress getInformationFacilityIPAddressIPV4MapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;
	
	@Mappings({
	@Mapping(target="type", constant="IPV6"),
	@Mapping(target="networkNumber", source="retrieveFacilityEntity.fixed_ip_address_v6")})
	public IPAddress getInformationFacilityIPAddressIPV6MapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="id", source="retrieveFacilityEntity.ont_id"),
		@Mapping(target="modemCharacteristicSpecification.type", constant="USER"),
		@Mapping(target="modemCharacteristicSpecification.value", source="retrieveFacilityEntity.bhsHguConfiguration"),
		@Mapping(target="password", source="retrieveFacilityEntity.gpon_password")
	})
	public ModemResource getInformationFacilityModemResourcePhsicalLinksMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="modemResource", source="modemResource"),
		@Mapping(target="accessTechnology", source="retrieveFacilityEntity.tecnology")
	})
	public PhysicalLink getInformationFacilityPhsicalLinksMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity, ModemResource modemResource) throws Exception;

	default public NetworkAddressAssociation getInformationFacilityNetworkAddressAssociationResourceMapperObject(IPAddress ... ipAddress) throws Exception{
		NetworkAddressAssociation networkAddressAssociation = new  NetworkAddressAssociation();
		for (IPAddress ipAddr : ipAddress) {
			networkAddressAssociation.addIpAddress(ipAddr);
		}
		return networkAddressAssociation;
	};

	@Mappings({
		@Mapping(target="atomicNetworkAddress", source="atomicNetworkAddress")})
	public NetworkAddressAssociation getInformationFacilityNetworkAddressAssociationResourceAtomicMapperObject(AtomicNetworkAddress atomicNetworkAddress) throws Exception;

	@Mappings({
		@Mapping(target="vlanId", source="retrieveFacilityEntity.network_vlan"),
		@Mapping(target="type", constant="NETWORK"),
		@Mapping(target="serviceDescription", source="retrieveFacilityEntity.service_description")})
	public NetworkRoute getInformationFacilityNetworkRouteInternetMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;


	@Mappings({
		@Mapping(target="vlanId", source="retrieveFacilityEntity.user_vlan"),
		@Mapping(target="type", constant="USER"),
		@Mapping(target="serviceDescription", source="retrieveFacilityEntity.service_description")})
	public NetworkRoute getInformationFacilityNetworkRouteUserMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;
	
	@Mappings({
		@Mapping(target="vlanId", source="retrieveFacilityEntity.vlan_voip"),
		@Mapping(target="type", constant="VOIP"),
		@Mapping(target="serviceDescription", source="retrieveFacilityEntity.service_description")})
	public NetworkRoute getInformationFacilityNetworkRouteVoipVlanMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="nasPost", source="retrieveFacilityEntity.nasport")})
	public NetworkRoute getInformationFacilityNetworkRouteNasPortMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;
	@Mappings({
		@Mapping(target="networkRouteAssociation", source="networkRouteAssociation")})
	public LogicalResource getInformationFacilityLogicalResourceMapperObject(NetworkRouteAssociation networkRouteAssociation) throws Exception;

	@Mappings({
		@Mapping(target="networkRouteAssociation", source="networkRouteAssociation")})
	public LogicalResource getInformationFacilityLogicalResourceNaspostMapperObject(NetworkRouteAssociation networkRouteAssociation) throws Exception;

	@Mappings({
		@Mapping(target="id", source="retrieveFacilityEntity.accessEquipmentPort"),
		@Mapping(target="fiberId", source="retrieveFacilityEntity.logical_port")})
	public PhysicalPort getInformationFacilityPhysicalPortMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="id", source="retrieveFacilityEntity.accessEquipmentSlot"),
		@Mapping(target="containsPorts", source="physicalPorts")})
	public PortAdapterCard getInformationFacilityPortAdapterCardMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity,List<PhysicalPort> physicalPorts) throws Exception;

	@Mappings({
		@Mapping(target="vendor", source="retrieveFacilityEntity.aggregatorEquipVendor"),
		@Mapping(target="model", source="retrieveFacilityEntity.nisIpType")})
	public PhysicalResourceSpecAttributes getInformationFacilityPhysicalResourceSpecAttributesMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception;
}
