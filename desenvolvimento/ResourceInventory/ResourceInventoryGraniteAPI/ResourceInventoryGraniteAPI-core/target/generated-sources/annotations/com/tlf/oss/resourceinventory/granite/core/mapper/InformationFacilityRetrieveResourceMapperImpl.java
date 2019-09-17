package com.tlf.oss.resourceinventory.granite.core.mapper;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityEntity;

import com.tlf.oss.resourceinventory.schemas.AtomicNetworkAddress;

import com.tlf.oss.resourceinventory.schemas.Cabinet;

import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;

import com.tlf.oss.resourceinventory.schemas.Equipment;

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

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-08-22T10:32:04-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

public class InformationFacilityRetrieveResourceMapperImpl implements InformationFacilityRetrieveResourceMapper {

    @Override

    public ResourceInventoryEntity getInformationFacilityCabinetResourceMapperObject(Cabinet cabinet, PhysicalResource physicalResource, List<GeneralDistributor> listGeneralDistributor, ResourceInventoryEntity entity) throws Exception {

        if ( cabinet == null && physicalResource == null && listGeneralDistributor == null && entity == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();

        if ( cabinet != null ) {

            resourceInventoryEntity.setCabinet( cabinet );
        }

        if ( physicalResource != null ) {

            resourceInventoryEntity.setNetworkAggregator( physicalResource );
        }

        if ( listGeneralDistributor != null ) {

            List<GeneralDistributor> list = listGeneralDistributor;

            if ( list != null ) {

                resourceInventoryEntity.setGeneralDistributors(       new ArrayList<GeneralDistributor>( list )

                );
            }
        }

        if ( entity != null ) {

            resourceInventoryEntity.setAddress( entity.getAddress() );

            resourceInventoryEntity.setCustomerOrder( entity.getCustomerOrder() );

            resourceInventoryEntity.setSatellite( entity.getSatellite() );

            List<PhysicalLink> list_ = entity.getPhysicalLinks();

            if ( list_ != null ) {

                resourceInventoryEntity.setPhysicalLinks(       new ArrayList<PhysicalLink>( list_ )

                );
            }

            resourceInventoryEntity.setResourceFacingService( entity.getResourceFacingService() );

            resourceInventoryEntity.setCircuit( entity.getCircuit() );

            List<CustomerFacingService> list__ = entity.getCustomerFacingService();

            if ( list__ != null ) {

                resourceInventoryEntity.setCustomerFacingService(       new ArrayList<CustomerFacingService>( list__ )

                );
            }

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

    public Shelf getInformationFacilityShelfResourceMapperObject(RetrieveFacilityEntity retrieveFacilityEntity, NetworkAddressAssociation networkAddressAssociationShelf, LogicalResourceAssociation logicalResourceAssociation) throws Exception {

        if ( retrieveFacilityEntity == null && networkAddressAssociationShelf == null && logicalResourceAssociation == null ) {

            return null;
        }

        Shelf shelf = new Shelf();

        if ( retrieveFacilityEntity != null ) {

            shelf.setProfile( retrieveFacilityEntity.getProfile_activation() );

            shelf.setSubRack( retrieveFacilityEntity.getSubrack() );

            shelf.setName( retrieveFacilityEntity.getSigresName() );

            shelf.setTypeOfResource( retrieveFacilityEntity.getType() );

            shelf.setId( retrieveFacilityEntity.getId_shelf() );

            shelf.setRack( retrieveFacilityEntity.getRack() );

            shelf.setStatus( retrieveFacilityEntity.getStatus() );

            shelf.setModel( retrieveFacilityEntity.getModel() );
        }

        if ( networkAddressAssociationShelf != null ) {

            shelf.setNetworkAddressAssociation( networkAddressAssociationShelf );
        }

        if ( logicalResourceAssociation != null ) {

            shelf.setLogicalResourceAssociation( logicalResourceAssociation );
        }

        return shelf;
    }

    @Override

    public IPAddress getInformationFacilityIPAddressShelftMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        IPAddress iPAddress = new IPAddress();

        iPAddress.setNetworkNumber( retrieveFacilityEntity.getIp_equipamento() );

        iPAddress.setType( retrieveFacilityEntity.getType() );

        return iPAddress;
    }

    @Override

    public IPAddress getInformationFacilityIPAddressNetworkAddressAssociationMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        IPAddress iPAddress = new IPAddress();

        iPAddress.setModemLanMasc( retrieveFacilityEntity.getMascmodemlan() );

        iPAddress.setNetworkNumber( retrieveFacilityEntity.getNasip() );

        iPAddress.setModemWanMasc( retrieveFacilityEntity.getMascipmodemwan() );

        iPAddress.setType( retrieveFacilityEntity.getType() );

        return iPAddress;
    }

    @Override

    public AtomicNetworkAddress getInformationFacilityAtomicNetworkAddressMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        AtomicNetworkAddress atomicNetworkAddress = new AtomicNetworkAddress();

        atomicNetworkAddress.setHostname( retrieveFacilityEntity.getHostname() );

        return atomicNetworkAddress;
    }

    @Override

    public Cabinet getInformationFacilityCabinetMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        Cabinet cabinet = new Cabinet();

        cabinet.setTypeOfTopology( retrieveFacilityEntity.getNetworkType() );

        if ( retrieveFacilityEntity.getId() != null ) {

            cabinet.setId( String.valueOf( retrieveFacilityEntity.getId() ) );
        }

        cabinet.setLic( retrieveFacilityEntity.getLic() );

        cabinet.setStatus( retrieveFacilityEntity.getStatus() );

        cabinet.setType( retrieveFacilityEntity.getType() );

        return cabinet;
    }

    @Override

    public PhysicalResourceSpecAttributes getInformationFacilityPhysicalResourceSpecAttributesMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        PhysicalResourceSpecAttributes physicalResourceSpecAttributes = new PhysicalResourceSpecAttributes();

        physicalResourceSpecAttributes.setVendor( retrieveFacilityEntity.getManufacturer() );

        physicalResourceSpecAttributes.setModel( retrieveFacilityEntity.getModel() );

        return physicalResourceSpecAttributes;
    }

    @Override

    public PhysicalResource getInformationFacilityPhysicalResourceMapperObject(PhysicalResourceSpecAttributes physicalResourceSpecAttributes, LogicalResourceAssociation logicalResourceAssociation, NetworkAddressAssociation networkAddressAssociationMasc) throws Exception {

        if ( physicalResourceSpecAttributes == null && logicalResourceAssociation == null && networkAddressAssociationMasc == null ) {

            return null;
        }

        PhysicalResource physicalResource = new PhysicalResource();

        if ( physicalResourceSpecAttributes != null ) {

            physicalResource.setPhysicalResourceSpecAttributes( physicalResourceSpecAttributes );
        }

        if ( logicalResourceAssociation != null ) {

            physicalResource.setLogicalResourceAssociation( logicalResourceAssociation );
        }

        if ( networkAddressAssociationMasc != null ) {

            physicalResource.setNetworkAddressAssociation( networkAddressAssociationMasc );
        }

        return physicalResource;
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

    public NetworkRoute getInformationFacilityNetworkRouteInternetMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setVlanId( retrieveFacilityEntity.getVlanNetwork() );

        networkRoute.setVirtualPort( retrieveFacilityEntity.getVirtualPort() );

        networkRoute.setVirtualChannel( retrieveFacilityEntity.getVirtualChannel() );

        networkRoute.setType( "INTERNET" );

        return networkRoute;
    }

    @Override

    public NetworkRoute getInformationFacilityNetworkRouteVoipMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setVlanId( retrieveFacilityEntity.getVlanVoip() );

        networkRoute.setVirtualPort( retrieveFacilityEntity.getVirtualPort() );

        networkRoute.setVirtualChannel( retrieveFacilityEntity.getVirtualChannel() );

        networkRoute.setType( "VOIP" );

        return networkRoute;
    }

    @Override

    public NetworkRoute getInformationFacilityNetworkRouteAggregatorMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setVlanId( retrieveFacilityEntity.getVlanCustomer() );

        networkRoute.setType( "" );

        networkRoute.setVirtualPort( "" );

        networkRoute.setVirtualChannel( "" );

        return networkRoute;
    }

    @Override

    public NetworkRoute getInformationFacilityNetworkRouteAggregatorNasPostMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        NetworkRoute networkRoute = new NetworkRoute();

        networkRoute.setNasPost( retrieveFacilityEntity.getNasport() );

        networkRoute.setType( "" );

        networkRoute.setVirtualPort( "" );

        networkRoute.setVirtualChannel( "" );

        return networkRoute;
    }

    @Override

    public PortAdapterCard getInformationFacilityPortAdapterCardMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        PortAdapterCard portAdapterCard = new PortAdapterCard();

        portAdapterCard.setId( retrieveFacilityEntity.getSlot() );

        portAdapterCard.setSubSlotId( retrieveFacilityEntity.getSubslot() );

        portAdapterCard.setModel( retrieveFacilityEntity.getModel() );

        portAdapterCard.setSlot( retrieveFacilityEntity.getSlot() );

        return portAdapterCard;
    }

    @Override

    public PhysicalPort getInformationFacilityPhysicalPortMapperObject(RetrieveFacilityEntity retrieveFacilityEntity, LogicalResourceAssociation logicalResourceAssociation) throws Exception {

        if ( retrieveFacilityEntity == null && logicalResourceAssociation == null ) {

            return null;
        }

        PhysicalPort physicalPort = new PhysicalPort();

        if ( retrieveFacilityEntity != null ) {

            physicalPort.setId( retrieveFacilityEntity.getPort() );
        }

        if ( logicalResourceAssociation != null ) {

            physicalPort.setLogicalResourceAssociation( logicalResourceAssociation );
        }

        return physicalPort;
    }

    @Override

    public GeneralDistributor getInformationFacilityGeneralDistribuitorOneMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        GeneralDistributor generalDistributor = new GeneralDistributor();

        generalDistributor.setVerticalPosition( retrieveFacilityEntity.getVerticalOne() );

        generalDistributor.setHorizontalPosition( retrieveFacilityEntity.getHorizontalOne() );

        generalDistributor.setPinPosition( retrieveFacilityEntity.getPinOne() );

        generalDistributor.setPointNumber( "1" );

        return generalDistributor;
    }

    @Override

    public GeneralDistributor getInformationFacilityGeneralDistribuitorTwoMapperObject(RetrieveFacilityEntity retrieveFacilityEntity) throws Exception {

        if ( retrieveFacilityEntity == null ) {

            return null;
        }

        GeneralDistributor generalDistributor = new GeneralDistributor();

        generalDistributor.setVerticalPosition( retrieveFacilityEntity.getVerticalTwo() );

        generalDistributor.setHorizontalPosition( retrieveFacilityEntity.getHorizontalTwo() );

        generalDistributor.setPinPosition( retrieveFacilityEntity.getPinTwo() );

        generalDistributor.setPointNumber( "2" );

        return generalDistributor;
    }
}

