package com.tlf.oss.resourceinventory.granite.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityGponEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.ModemResource;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;

@Mapper
public interface InformationFacilityRetrieveGponResourceMapper {

	
	// Mapeamento do Shelf (Nome do equipamento de acesso (OLT) e Fabricante do equipamento de acesso (OLT))
	@Mappings({
		@Mapping(target="name", source="retrieveFacilityEntity.accessEquipmentName"),
		@Mapping(target="vendor", source="retrieveFacilityEntity.access_equipment_vendor"),
		@Mapping(target="model", source="retrieveFacilityEntity.access_equipment_model"),
		@Mapping(target="rack", source="retrieveFacilityEntity.equipament_rack"),
		@Mapping(target="subRack", source="retrieveFacilityEntity.equipament_subrack"),
		@Mapping(target="id", source="retrieveFacilityEntity.equipamentShelf")})
	public Shelf getInformationFacilityShelfResourceMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity)throws Exception;
	
	// Mapeamento campo ServiceID (Designador de acesso)
		@Mappings({
		@Mapping(target="serviceId", source="retrieveFacilityEntity.terminalNumber")})
	public ResourceFacingService getInformationFacilityResourceFacingServiceMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	// Mapeamento Cabinet (Cabo e Fibra)
	@Mappings({
		@Mapping(target="primaryCable", source="retrieveFacilityEntity.primaryCable"),
		@Mapping(target="primaryFiber", source="retrieveFacilityEntity.primaryFiber")})
	public Cabinet getInformationFacilityCabinetMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	// Mapeamento do PhysicalLink (Tecnologia de acesso) e ModemResource
	@Mappings({
		@Mapping(target="modemResource", source="modemResource"),
		@Mapping(target="accessTechnology", source="retrieveFacilityEntity.tecnology")})
	public PhysicalLink getInformationFacilityPhsicalLinksMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity, ModemResource modemResource) throws Exception;
	
	// Mapeamento do PortAdapterCard (Slot do equipamento de acesso (OLT))
	@Mappings({
		@Mapping(target="slot", source="retrieveFacilityEntity.accessEquipmentSlot")})
	public PortAdapterCard getInformationFacilityPortAdapterCardMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;
	
	// Mapeamento do PhysicalPort (Porta do equipamento de acesso (OLT))
	@Mappings({
		@Mapping(target="id", source="retrieveFacilityEntity.accessEquipmentPort")})
	public PhysicalPort getInformationFacilityPhysicalPortMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;
	
	// Mapeamento do LogicalResource para Virtual Port (Porta lógica do equipamento de acesso (OLT) - GPON)
	@Mappings({
		@Mapping(target="typeOfResource", constant="VIRTUAL_PORT"),
		@Mapping(target="value", source="retrieveFacilityEntity.logical_port")})
	public LogicalResource getInformationFacilityLogicalResourceVirtualPortMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;	
	
	// Mapeamento do LogicalResource para NasPort Port (Utilizado para a configuração do PSA)
		@Mappings({
			@Mapping(target="typeOfResource", constant="NAS"),
			@Mapping(target="name", constant="PORT"),
			@Mapping(target="value", source="retrieveFacilityEntity.nasport")})
		public LogicalResource getInformationFacilityLogicalResourceNasPortMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	// Mapeamento do LogicalResource para NasIP (Utilizado para a configuração do PSA)
		@Mappings({
			@Mapping(target="typeOfResource", constant="NAS"),
			@Mapping(target="name", constant="IP"),
			@Mapping(target="value", source="retrieveFacilityEntity.nasip")})
		public LogicalResource getInformationFacilityLogicalResourceNasIpMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	// Mapeamento do LogicalResource para Network Vlan (Vlan de rede)
		@Mappings({
			@Mapping(target="typeOfResource", constant="VLAN"),
			@Mapping(target="name", constant="HSI"),
			@Mapping(target="value", source="retrieveFacilityEntity.network_vlan")})
		public LogicalResource getInformationFacilityLogicalResourceNetworkVlanMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;
		
	// Mapeamento do LogicalResource para User Vlan (Vlan do usuário)
		@Mappings({
			@Mapping(target="typeOfResource", constant="VLAN"),
			@Mapping(target="name", constant="CUSTOMER"),
			@Mapping(target="value", source="retrieveFacilityEntity.user_vlan")})
		public LogicalResource getInformationFacilityLogicalResourceUserVlanMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	// Mapeamento do LogicalResource para Voip Vlan (Vlan do usuário)
		@Mappings({
			@Mapping(target="typeOfResource", constant="VLAN"),
			@Mapping(target="name", constant="VOIP"),
			@Mapping(target="value", source="retrieveFacilityEntity.vlan_voip")})
		public LogicalResource getInformationFacilityLogicalResourceVoipVlanMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	//Mapeamento do IPV4
		@Mappings({
			@Mapping(target="typeOfResource", constant="STATIC_IP"),
			@Mapping(target="name", constant="IPV4"),
			@Mapping(target="value", source="retrieveFacilityEntity.fixed_ip_address_v4")})
		public LogicalResource getInformationFacilityLogicalResourceIPV4MapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;
		
	//Mapeamento do IPV6
		@Mappings({
			@Mapping(target="typeOfResource", constant="STATIC_IP"),
			@Mapping(target="name", constant="IPV6"),
			@Mapping(target="value", source="retrieveFacilityEntity.fixed_ip_address_v6")})
		public LogicalResource getInformationFacilityLogicalResourceIPV6MapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;
		
	// Mapeamento Service Description 
		@Mappings({
			@Mapping(target="typeOfResource", constant="CUSTOMER_ID"),
			@Mapping(target="value", source="retrieveFacilityEntity.service_description")})
		public LogicalResource getInformationFacilityLogicalResourceServiceDescriptionMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;
		
	// Mapeamento GPON Password
		@Mappings({
			@Mapping(target="typeOfResource", constant="GPON_PASSWORD"),
			@Mapping(target="value", source="retrieveFacilityEntity.gpon_password")})
		public LogicalResource getInformationFacilityLogicalResourceGponPasswordMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	// Mapeamento do ModemResource
		@Mappings({
			@Mapping(target="id", source="retrieveFacilityEntity.ont_id"),
			@Mapping(target="model", source="retrieveFacilityEntity.ont_model"),
			@Mapping(target="vendor", source="retrieveFacilityEntity.ont_version"),
			@Mapping(target="modemCharacteristicSpecification.type", constant="BHS/HGU"),
			@Mapping(target="modemCharacteristicSpecification.value", source="retrieveFacilityEntity.bhsHguConfiguration"),
			
		})
		public ModemResource getInformationFacilityLogicalResourceModemResourceMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

	// Mapeamento do IPAddress networkNumber
		@Mappings({
			@Mapping(target="networkNumber", source="retrieveFacilityEntity.equipament_ipaddress")})
		public IPAddress getInformationFacilityLogicalResourceIPAddressMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;

		// Mapeamento SwitchesAssociated
		@Mappings({
			@Mapping(target="name", source="retrieveFacilityEntity.aggregatorEquipmentName"),
			@Mapping(target="model", source="retrieveFacilityEntity.aggregatorEquipmentModel"),
			@Mapping(target="vendor", source="retrieveFacilityEntity.aggregatorEquipmentVendor")})
		public SwitchesAssociated getInformationFacilitySwitchesAssociatedMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception;
}

