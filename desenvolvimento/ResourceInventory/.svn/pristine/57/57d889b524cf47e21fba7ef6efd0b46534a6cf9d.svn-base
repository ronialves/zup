package com.tlf.oss.resourceinventory.granite.core.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.schemas.AtomicNetworkAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.GeneralDistributor;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;
import com.tlf.oss.resourceinventory.schemas.NetworkAddressAssociation;
import com.tlf.oss.resourceinventory.schemas.NetworkRoute;
import com.tlf.oss.resourceinventory.schemas.NetworkRouteAssociation;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.PhysicalResourceSpecAttributes;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Mapper
public interface InformationFacilityRetrieveResourceMapper {

	@Mappings({
		@Mapping(target="cabinet", source="cabinet"),
		@Mapping(target="networkAggregator", source="physicalResource"),
		@Mapping(target="generalDistributors", source="listGeneralDistributor"),
		@Mapping(target="address", source="entity.address")})
	public ResourceInventoryEntity getInformationFacilityCabinetResourceMapperObject(Cabinet cabinet, PhysicalResource physicalResource,List<GeneralDistributor> listGeneralDistributor,ResourceInventoryEntity entity) throws Exception;

	@Mappings({
		@Mapping(target="subRack", source="retrieveFacilityEntity.subrack"),
		@Mapping(target="networkAddressAssociation", source="networkAddressAssociationShelf"),
		@Mapping(target="logicalResourceAssociation", source="logicalResourceAssociation"),
		@Mapping(target="typeOfResource", source="retrieveFacilityEntity.type"),
		@Mapping(target="name", source="retrieveFacilityEntity.sigresName"),
		@Mapping(target="profile", source="retrieveFacilityEntity.profile_activation"),
		@Mapping(target="id", source="retrieveFacilityEntity.id_shelf")})
	public Shelf getInformationFacilityShelfResourceMapperObject(RetrieveFacilityEntity retrieveFacilityEntity, NetworkAddressAssociation networkAddressAssociationShelf, LogicalResourceAssociation logicalResourceAssociation)throws Exception;

	default public NetworkAddressAssociation getInformationFacilityNetworkAddressAssociationResourceMapperObject(IPAddress idAddress) throws Exception{
		NetworkAddressAssociation networkAddressAssociation = new NetworkAddressAssociation();
		List<IPAddress> ipAddressList = new ArrayList<>();
		ipAddressList.add(idAddress);
		networkAddressAssociation.setIpAddressList(ipAddressList);
		return networkAddressAssociation;
	};

	default public NetworkAddressAssociation getInformationFacilityNetworkAddressAssociationResourceShelfMapperObject(IPAddress idAddress,AtomicNetworkAddress atomicNetworkAddress) throws Exception {
		NetworkAddressAssociation networkAddressAssociation = new NetworkAddressAssociation();
		List<IPAddress> ipAddressList = new ArrayList<>();
		ipAddressList.add(idAddress);
		networkAddressAssociation.setIpAddressList(ipAddressList);
		networkAddressAssociation.setAtomicNetworkAddress(atomicNetworkAddress);
		return networkAddressAssociation;
	};

	@Mapping(target="networkNumber", source="retrieveFacilityEntity.ip_equipamento")
	public IPAddress getInformationFacilityIPAddressShelftMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;
	
	@Mappings({
		@Mapping(target="networkNumber", source="retrieveFacilityEntity.nasip"),
		@Mapping(target="modemLanMasc", source="retrieveFacilityEntity.mascmodemlan"),
		@Mapping(target="modemWanMasc", source="retrieveFacilityEntity.mascipmodemwan")
	})
	public IPAddress getInformationFacilityIPAddressNetworkAddressAssociationMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mapping(target="hostname", source="retrieveFacilityEntity.hostname")
	public AtomicNetworkAddress getInformationFacilityAtomicNetworkAddressMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mapping(target="typeOfTopology", source="retrieveFacilityEntity.networkType")
	public Cabinet getInformationFacilityCabinetMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="vendor", source="retrieveFacilityEntity.manufacturer"),
		@Mapping(target="model", source="retrieveFacilityEntity.model")})
	public PhysicalResourceSpecAttributes getInformationFacilityPhysicalResourceSpecAttributesMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="physicalResourceSpecAttributes", source="physicalResourceSpecAttributes"),
		@Mapping(target="logicalResourceAssociation", source="logicalResourceAssociation"),
		@Mapping(target="networkAddressAssociation", source="networkAddressAssociationMasc")})
	public PhysicalResource getInformationFacilityPhysicalResourceMapperObject(PhysicalResourceSpecAttributes physicalResourceSpecAttributes, LogicalResourceAssociation logicalResourceAssociation,NetworkAddressAssociation networkAddressAssociationMasc) throws Exception;

	@Mapping(target="networkRouteAssociation", source="networkRouteAssociation")
	public LogicalResource getInformationFacilityLogicalResourceMapperObject(NetworkRouteAssociation networkRouteAssociation) throws Exception;

	@Mapping(target="networkRouteAssociation", source="networkRouteAssociation")
	public LogicalResource getInformationFacilityLogicalResourceNaspostMapperObject(NetworkRouteAssociation networkRouteAssociation) throws Exception;

	@Mappings({
		@Mapping(target="vlanId", source="retrieveFacilityEntity.vlanNetwork"),
		@Mapping(target="virtualPort", source="retrieveFacilityEntity.virtualPort"),
		@Mapping(target="virtualChannel", source="retrieveFacilityEntity.virtualChannel"),
		@Mapping(target="type", constant="INTERNET")})
	public NetworkRoute getInformationFacilityNetworkRouteInternetMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="vlanId", source="retrieveFacilityEntity.vlanVoip"),
		@Mapping(target="virtualPort", source="retrieveFacilityEntity.virtualPort"),
		@Mapping(target="virtualChannel", source="retrieveFacilityEntity.virtualChannel"),
		@Mapping(target="type", constant="VOIP")})
	public NetworkRoute getInformationFacilityNetworkRouteVoipMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
	@Mapping(target="vlanId", source="retrieveFacilityEntity.vlanCustomer"),
	@Mapping(target="virtualPort", constant=""),
	@Mapping(target="virtualChannel", constant=""),
	@Mapping(target="type", constant="")})
	public NetworkRoute getInformationFacilityNetworkRouteAggregatorMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
	@Mapping(target="nasPost", source="retrieveFacilityEntity.nasport"),
	@Mapping(target="virtualPort", constant=""),
	@Mapping(target="virtualChannel", constant=""),
	@Mapping(target="type", constant="")})
	public NetworkRoute getInformationFacilityNetworkRouteAggregatorNasPostMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="id", source="retrieveFacilityEntity.slot"),
		@Mapping(target="subSlotId", source="retrieveFacilityEntity.subslot")})
	public PortAdapterCard getInformationFacilityPortAdapterCardMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="id", source="retrieveFacilityEntity.port"),
		@Mapping(target="logicalResourceAssociation", source="logicalResourceAssociation")})
	public PhysicalPort getInformationFacilityPhysicalPortMapperObject(RetrieveFacilityEntity retrieveFacilityEntity,LogicalResourceAssociation logicalResourceAssociation) throws Exception;

	@Mappings({
		@Mapping(target="pointNumber", constant="1"),
		@Mapping(target="horizontalPosition", source="retrieveFacilityEntity.horizontalOne"),
		@Mapping(target="verticalPosition", source="retrieveFacilityEntity.verticalOne"),
		@Mapping(target="pinPosition", source="retrieveFacilityEntity.pinOne")})
	public GeneralDistributor getInformationFacilityGeneralDistribuitorOneMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;

	@Mappings({
		@Mapping(target="pointNumber", constant="2"),
		@Mapping(target="horizontalPosition", source="retrieveFacilityEntity.horizontalTwo"),
		@Mapping(target="verticalPosition", source="retrieveFacilityEntity.verticalTwo"),
		@Mapping(target="pinPosition", source="retrieveFacilityEntity.pinTwo")})
	public GeneralDistributor getInformationFacilityGeneralDistribuitorTwoMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception;
}
