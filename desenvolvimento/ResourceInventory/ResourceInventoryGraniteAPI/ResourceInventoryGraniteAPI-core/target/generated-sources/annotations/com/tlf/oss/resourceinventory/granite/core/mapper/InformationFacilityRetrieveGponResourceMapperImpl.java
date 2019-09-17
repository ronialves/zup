package com.tlf.oss.resourceinventory.granite.core.mapper;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityGponEntity;

import com.tlf.oss.resourceinventory.schemas.Cabinet;

import com.tlf.oss.resourceinventory.schemas.IPAddress;

import com.tlf.oss.resourceinventory.schemas.LogicalResource;

import com.tlf.oss.resourceinventory.schemas.ModemCharacteristicSpecification;

import com.tlf.oss.resourceinventory.schemas.ModemResource;

import com.tlf.oss.resourceinventory.schemas.PhysicalLink;

import com.tlf.oss.resourceinventory.schemas.PhysicalPort;

import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;

import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;

import com.tlf.oss.resourceinventory.schemas.Shelf;

import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-08-22T10:32:04-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

public class InformationFacilityRetrieveGponResourceMapperImpl implements InformationFacilityRetrieveGponResourceMapper {

    @Override

    public Shelf getInformationFacilityShelfResourceMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        Shelf shelf = new Shelf();

        shelf.setRack( retrieveFacilityEntity.getEquipament_rack() );

        shelf.setVendor( retrieveFacilityEntity.getAccess_equipment_vendor() );

        shelf.setName( retrieveFacilityEntity.getAccessEquipmentName() );

        shelf.setSubRack( retrieveFacilityEntity.getEquipament_subrack() );

        shelf.setModel( retrieveFacilityEntity.getAccess_equipment_model() );

        shelf.setId( retrieveFacilityEntity.getEquipamentShelf() );

        return shelf;
    }

    @Override

    public ResourceFacingService getInformationFacilityResourceFacingServiceMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        ResourceFacingService resourceFacingService = new ResourceFacingService();

        resourceFacingService.setServiceId( retrieveFacilityEntity.getTerminalNumber() );

        return resourceFacingService;
    }

    @Override

    public Cabinet getInformationFacilityCabinetMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        Cabinet cabinet = new Cabinet();

        cabinet.setPrimaryCable( retrieveFacilityEntity.getPrimaryCable() );

        cabinet.setPrimaryFiber( retrieveFacilityEntity.getPrimaryFiber() );

        if ( retrieveFacilityEntity.getId() != null ) {

            cabinet.setId( String.valueOf( retrieveFacilityEntity.getId() ) );
        }

        return cabinet;
    }

    @Override

    public PhysicalLink getInformationFacilityPhsicalLinksMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity, ModemResource modemResource) throws Exception {

        if ( retrieveFacilityEntity == null && modemResource == null ) {

            return null;
        }

        PhysicalLink physicalLink = new PhysicalLink();

        if ( retrieveFacilityEntity != null ) {

            physicalLink.setAccessTechnology( retrieveFacilityEntity.getTecnology() );
        }

        if ( modemResource != null ) {

            physicalLink.setModemResource( modemResource );
        }

        return physicalLink;
    }

    @Override

    public PortAdapterCard getInformationFacilityPortAdapterCardMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        PortAdapterCard portAdapterCard = new PortAdapterCard();

        portAdapterCard.setSlot( retrieveFacilityEntity.getAccessEquipmentSlot() );

        if ( retrieveFacilityEntity.getId() != null ) {

            portAdapterCard.setId( String.valueOf( retrieveFacilityEntity.getId() ) );
        }

        return portAdapterCard;
    }

    @Override

    public PhysicalPort getInformationFacilityPhysicalPortMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        PhysicalPort physicalPort = new PhysicalPort();

        physicalPort.setId( retrieveFacilityEntity.getAccessEquipmentPort() );

        return physicalPort;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceVirtualPortMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getLogical_port() );

        logicalResource.setTypeOfResource( "VIRTUAL_PORT" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceNasPortMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getNasport() );

        logicalResource.setName( "PORT" );

        logicalResource.setTypeOfResource( "NAS" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceNasIpMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getNasip() );

        logicalResource.setName( "IP" );

        logicalResource.setTypeOfResource( "NAS" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceNetworkVlanMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getNetwork_vlan() );

        logicalResource.setName( "HSI" );

        logicalResource.setTypeOfResource( "VLAN" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceUserVlanMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getUser_vlan() );

        logicalResource.setName( "CUSTOMER" );

        logicalResource.setTypeOfResource( "VLAN" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceVoipVlanMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getVlan_voip() );

        logicalResource.setName( "VOIP" );

        logicalResource.setTypeOfResource( "VLAN" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceIPV4MapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getFixed_ip_address_v4() );

        logicalResource.setName( "IPV4" );

        logicalResource.setTypeOfResource( "STATIC_IP" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceIPV6MapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getFixed_ip_address_v6() );

        logicalResource.setName( "IPV6" );

        logicalResource.setTypeOfResource( "STATIC_IP" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceServiceDescriptionMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getService_description() );

        logicalResource.setTypeOfResource( "CUSTOMER_ID" );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceGponPasswordMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setValue( retrieveFacilityEntity.getGpon_password() );

        logicalResource.setTypeOfResource( "GPON_PASSWORD" );

        return logicalResource;
    }

    @Override

    public ModemResource getInformationFacilityLogicalResourceModemResourceMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        ModemResource modemResource = new ModemResource();

        ModemCharacteristicSpecification modemCharacteristicSpecification = new ModemCharacteristicSpecification();

        modemResource.setModemCharacteristicSpecification( modemCharacteristicSpecification );

        modemResource.setModel( retrieveFacilityEntity.getOnt_model() );

        modemCharacteristicSpecification.setValue( retrieveFacilityEntity.getBhsHguConfiguration() );

        modemResource.setId( retrieveFacilityEntity.getOnt_id() );

        modemResource.setVendor( retrieveFacilityEntity.getOnt_version() );

        modemCharacteristicSpecification.setType( "BHS/HGU" );

        return modemResource;
    }

    @Override

    public IPAddress getInformationFacilityLogicalResourceIPAddressMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        IPAddress iPAddress = new IPAddress();

        iPAddress.setNetworkNumber( retrieveFacilityEntity.getEquipament_ipaddress() );

        return iPAddress;
    }

    @Override

    public SwitchesAssociated getInformationFacilitySwitchesAssociatedMapperObject(RetrieveFacilityGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        SwitchesAssociated switchesAssociated = new SwitchesAssociated();

        switchesAssociated.setName( retrieveFacilityEntity.getAggregatorEquipmentName() );

        switchesAssociated.setModel( retrieveFacilityEntity.getAggregatorEquipmentModel() );

        switchesAssociated.setVendor( retrieveFacilityEntity.getAggregatorEquipmentVendor() );

        return switchesAssociated;
    }
}

