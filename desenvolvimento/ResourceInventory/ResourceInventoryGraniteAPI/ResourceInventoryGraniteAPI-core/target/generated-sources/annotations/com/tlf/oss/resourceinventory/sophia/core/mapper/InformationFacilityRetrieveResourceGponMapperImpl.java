package com.tlf.oss.resourceinventory.sophia.core.mapper;

import com.tlf.oss.resourceinventory.schemas.AtomicNetworkAddress;

import com.tlf.oss.resourceinventory.schemas.Cabinet;

import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;

import com.tlf.oss.resourceinventory.schemas.Equipment;

import com.tlf.oss.resourceinventory.schemas.GeneralDistributor;

import com.tlf.oss.resourceinventory.schemas.IPAddress;

import com.tlf.oss.resourceinventory.schemas.LogicalResource;

import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;

import com.tlf.oss.resourceinventory.schemas.ModemCharacteristicSpecification;

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

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-08-22T10:32:04-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

public class InformationFacilityRetrieveResourceGponMapperImpl implements InformationFacilityRetrieveResourceGponMapper {

    @Override

    public ResourceInventoryEntity getInformationFacilityCabinetResourceMapperObject(Cabinet cabinet, PhysicalResource physicalResource, List<PhysicalLink> physicalLinks, ResourceFacingService resourceFacingService, List<CustomerFacingService> customerFacingServices, ResourceInventoryEntity entity) throws Exception {

        if ( cabinet == null && physicalResource == null && physicalLinks == null && resourceFacingService == null && customerFacingServices == null && entity == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();

        if ( cabinet != null ) {

            resourceInventoryEntity.setCabinet( cabinet );
        }

        if ( physicalResource != null ) {

            resourceInventoryEntity.setNetworkAggregator( physicalResource );
        }

        if ( physicalLinks != null ) {

            List<PhysicalLink> list = physicalLinks;

            if ( list != null ) {

                resourceInventoryEntity.setPhysicalLinks(       new ArrayList<PhysicalLink>( list )

                );
            }
        }

        if ( resourceFacingService != null ) {

            resourceInventoryEntity.setResourceFacingService( resourceFacingService );
        }

        if ( customerFacingServices != null ) {

            List<CustomerFacingService> list_ = customerFacingServices;

            if ( list_ != null ) {

                resourceInventoryEntity.setCustomerFacingService(       new ArrayList<CustomerFacingService>( list_ )

                );
            }
        }

        if ( entity != null ) {

            resourceInventoryEntity.setAddress( entity.getAddress() );

            List<GeneralDistributor> list__ = entity.getGeneralDistributors();

            if ( list__ != null ) {

                resourceInventoryEntity.setGeneralDistributors(       new ArrayList<GeneralDistributor>( list__ )

                );
            }

            resourceInventoryEntity.setCustomerOrder( entity.getCustomerOrder() );

            resourceInventoryEntity.setSatellite( entity.getSatellite() );

            resourceInventoryEntity.setCircuit( entity.getCircuit() );

            resourceInventoryEntity.setPhysicalResourceSummary( entity.getPhysicalResourceSummary() );

            resourceInventoryEntity.setResourceOrder( entity.getResourceOrder() );

            resourceInventoryEntity.setOperationService( entity.getOperationService() );

            resourceInventoryEntity.setResource( entity.getResource() );

            resourceInventoryEntity.setResourceInventoryWarn( entity.getResourceInventoryWarn() );

            List<Equipment> list___ = entity.getEquipment();

            if ( list___ != null ) {

                resourceInventoryEntity.setEquipment(       new ArrayList<Equipment>( list___ )

                );
            }

            resourceInventoryEntity.setGatherResourceInformation( entity.getGatherResourceInformation() );

            resourceInventoryEntity.setCodeReturn( entity.getCodeReturn() );

            resourceInventoryEntity.setMessageReturn( entity.getMessageReturn() );
        }

        return resourceInventoryEntity;
    }

    @Override

    public Shelf getInformationFacilityShelfResourceMapperObject(LogicalResourceAssociation logicalResourceAssociation, AtomicNetworkAddress networkAddressAssociationAtomic, PhysicalResourceSpecAttributes physicalResourceSpecAttributes, List<PortAdapterCard> portAdapterCards) throws Exception {

        if ( logicalResourceAssociation == null && networkAddressAssociationAtomic == null && physicalResourceSpecAttributes == null && portAdapterCards == null ) {

            return null;
        }

        Shelf shelf = new Shelf();

        NetworkAddressAssociation networkAddressAssociation = new NetworkAddressAssociation();

        shelf.setNetworkAddressAssociation( networkAddressAssociation );

        if ( logicalResourceAssociation != null ) {

            shelf.setLogicalResourceAssociation( logicalResourceAssociation );
        }

        if ( networkAddressAssociationAtomic != null ) {

            networkAddressAssociation.setAtomicNetworkAddress( networkAddressAssociationAtomic );
        }

        if ( physicalResourceSpecAttributes != null ) {

            shelf.setPhysicalResourceSpecAttributes( physicalResourceSpecAttributes );

            shelf.setVendor( physicalResourceSpecAttributes.getVendor() );

            shelf.setModel( physicalResourceSpecAttributes.getModel() );
        }

        if ( portAdapterCards != null ) {

            List<PortAdapterCard> list = portAdapterCards;

            if ( list != null ) {

                shelf.setHasCards(       new ArrayList<PortAdapterCard>( list )

                );
            }
        }

        return shelf;
    }

    @Override

    public ResourceFacingService getInformationFacilityResourceFacingServiceMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        ResourceFacingService resourceFacingService = new ResourceFacingService();

        resourceFacingService.setServiceId( retrieveFacilityEntity.getTerminalNumber() );

        return resourceFacingService;
    }

    @Override

    public PhysicalResource getInformationFacilityNetworkAggregatorMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        PhysicalResource physicalResource = new PhysicalResource();

        physicalResource.setName( retrieveFacilityEntity.getAggregatorEquipmentName() );

        return physicalResource;
    }

    @Override

    public Cabinet getInformationFacilityCabinetMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

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

    public AtomicNetworkAddress getInformationFacilityAtomicNetworkAddressMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        AtomicNetworkAddress atomicNetworkAddress = new AtomicNetworkAddress();

        atomicNetworkAddress.setHostname( retrieveFacilityEntity.getAccessEquipmentName() );

        return atomicNetworkAddress;
    }

    @Override

    public IPAddress getInformationFacilityIPAddressNetworkAddressAssociationMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        IPAddress iPAddress = new IPAddress();

        iPAddress.setNetworkNumber( retrieveFacilityEntity.getNasip() );

        return iPAddress;
    }

    @Override

    public IPAddress getInformationFacilityIPAddressIPV4MapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        IPAddress iPAddress = new IPAddress();

        iPAddress.setNetworkNumber( retrieveFacilityEntity.getFixed_ip_address_v4() );

        iPAddress.setType( "IPV4" );

        return iPAddress;
    }

    @Override

    public IPAddress getInformationFacilityIPAddressIPV6MapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        IPAddress iPAddress = new IPAddress();

        iPAddress.setNetworkNumber( retrieveFacilityEntity.getFixed_ip_address_v6() );

        iPAddress.setType( "IPV6" );

        return iPAddress;
    }

    @Override

    public ModemResource getInformationFacilityModemResourcePhsicalLinksMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        ModemResource modemResource = new ModemResource();

        ModemCharacteristicSpecification modemCharacteristicSpecification = new ModemCharacteristicSpecification();

        modemResource.setModemCharacteristicSpecification( modemCharacteristicSpecification );

        modemResource.setPassword( retrieveFacilityEntity.getGpon_password() );

        modemCharacteristicSpecification.setValue( retrieveFacilityEntity.getBhsHguConfiguration() );

        modemResource.setId( retrieveFacilityEntity.getOnt_id() );

        modemCharacteristicSpecification.setType( "USER" );

        return modemResource;
    }

    @Override

    public PhysicalLink getInformationFacilityPhsicalLinksMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity, ModemResource modemResource) throws Exception {

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

    public NetworkAddressAssociation getInformationFacilityNetworkAddressAssociationResourceAtomicMapperObject(AtomicNetworkAddress atomicNetworkAddress) throws Exception {

        if ( atomicNetworkAddress == null ) {

            return null;
        }

        NetworkAddressAssociation networkAddressAssociation = new NetworkAddressAssociation();

        networkAddressAssociation.setAtomicNetworkAddress( atomicNetworkAddress );

        return networkAddressAssociation;
    }

    @Override

    public NetworkRoute getInformationFacilityNetworkRouteInternetMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setServiceDescription( retrieveFacilityEntity.getService_description() );

        networkRoute.setVlanId( retrieveFacilityEntity.getNetwork_vlan() );

        networkRoute.setType( "NETWORK" );

        return networkRoute;
    }

    @Override

    public NetworkRoute getInformationFacilityNetworkRouteUserMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setServiceDescription( retrieveFacilityEntity.getService_description() );

        networkRoute.setVlanId( retrieveFacilityEntity.getUser_vlan() );

        networkRoute.setType( "USER" );

        return networkRoute;
    }

    @Override

    public NetworkRoute getInformationFacilityNetworkRouteVoipVlanMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setServiceDescription( retrieveFacilityEntity.getService_description() );

        networkRoute.setVlanId( retrieveFacilityEntity.getVlan_voip() );

        networkRoute.setType( "VOIP" );

        return networkRoute;
    }

    @Override

    public NetworkRoute getInformationFacilityNetworkRouteNasPortMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setNasPost( retrieveFacilityEntity.getNasport() );

        return networkRoute;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceMapperObject(NetworkRouteAssociation networkRouteAssociation) throws Exception {

        if ( networkRouteAssociation == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setNetworkRouteAssociation( networkRouteAssociation );

        return logicalResource;
    }

    @Override

    public LogicalResource getInformationFacilityLogicalResourceNaspostMapperObject(NetworkRouteAssociation networkRouteAssociation) throws Exception {

        if ( networkRouteAssociation == null ) {

            return null;
        }

        LogicalResource logicalResource = new LogicalResource();

        logicalResource.setNetworkRouteAssociation( networkRouteAssociation );

        return logicalResource;
    }

    @Override

    public PhysicalPort getInformationFacilityPhysicalPortMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        PhysicalPort physicalPort = new PhysicalPort();

        physicalPort.setFiberId( retrieveFacilityEntity.getLogical_port() );

        physicalPort.setId( retrieveFacilityEntity.getAccessEquipmentPort() );

        return physicalPort;
    }

    @Override

    public PortAdapterCard getInformationFacilityPortAdapterCardMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity, List<PhysicalPort> physicalPorts) throws Exception {

        if ( retrieveFacilityEntity == null && physicalPorts == null ) {

            return null;
        }

        PortAdapterCard portAdapterCard = new PortAdapterCard();

        if ( retrieveFacilityEntity != null ) {

            portAdapterCard.setId( retrieveFacilityEntity.getAccessEquipmentSlot() );
        }

        if ( physicalPorts != null ) {

            List<PhysicalPort> list = physicalPorts;

            if ( list != null ) {

                portAdapterCard.setContainsPorts(       new ArrayList<PhysicalPort>( list )

                );
            }
        }

        return portAdapterCard;
    }

    @Override

    public PhysicalResourceSpecAttributes getInformationFacilityPhysicalResourceSpecAttributesMapperObject(RetrieveFacilityResourceGponEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        PhysicalResourceSpecAttributes physicalResourceSpecAttributes = new PhysicalResourceSpecAttributes();

        physicalResourceSpecAttributes.setVendor( retrieveFacilityEntity.getAggregatorEquipVendor() );

        physicalResourceSpecAttributes.setModel( retrieveFacilityEntity.getNisIpType() );

        return physicalResourceSpecAttributes;
    }
}

