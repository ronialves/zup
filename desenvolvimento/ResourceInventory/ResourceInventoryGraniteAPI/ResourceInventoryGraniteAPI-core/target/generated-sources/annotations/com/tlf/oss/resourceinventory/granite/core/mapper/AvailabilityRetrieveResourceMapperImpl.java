package com.tlf.oss.resourceinventory.granite.core.mapper;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;

import com.tlf.oss.resourceinventory.schemas.Cabinet;

import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;

import com.tlf.oss.resourceinventory.schemas.Equipment;

import com.tlf.oss.resourceinventory.schemas.GeneralDistributor;

import com.tlf.oss.resourceinventory.schemas.PhysicalLink;

import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;

import com.tlf.oss.resourceinventory.schemas.ResourceCharacteristicSpecification;

import com.tlf.oss.resourceinventory.schemas.Shelf;

import com.tlf.oss.resourceinventory.schemas.Splitter;

import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-08-22T10:32:04-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

public class AvailabilityRetrieveResourceMapperImpl implements AvailabilityRetrieveResourceMapper {

    @Override

    public ResourceInventoryEntity getAvailabilityResourceMapperObject(Cabinet cabinet) throws Exception {

        if ( cabinet == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();

        resourceInventoryEntity.setCabinet( getAvailabilityCabinetResourceDslamMapperObject( cabinet ) );

        return resourceInventoryEntity;
    }

    @Override

    public ResourceInventoryEntity getAvailabilityCabinetResourceMsanMapperObject(Cabinet cabinet) throws Exception {

        if ( cabinet == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();

        resourceInventoryEntity.setCabinet( getAvailabilityCabinetResourceDslamMapperObject( cabinet ) );

        return resourceInventoryEntity;
    }

    @Override

    public Cabinet getAvailabilityCabinetResourceDslamMapperObject(Cabinet retrieveShelfAvailabilityEntity) throws Exception {

        if ( retrieveShelfAvailabilityEntity == null ) {

            return null;
        }

        Cabinet cabinet__ = new Cabinet();

        List<Shelf> list = retrieveShelfAvailabilityEntity.getHasShelves();

        if ( list != null ) {

            cabinet__.setHasShelves(       new ArrayList<Shelf>( list )

            );
        }

        cabinet__.setId( retrieveShelfAvailabilityEntity.getId() );

        cabinet__.setPrimaryCable( retrieveShelfAvailabilityEntity.getPrimaryCable() );

        cabinet__.setPrimaryFiber( retrieveShelfAvailabilityEntity.getPrimaryFiber() );

        cabinet__.setFeederCable( retrieveShelfAvailabilityEntity.getFeederCable() );

        cabinet__.setFeederSideCable( retrieveShelfAvailabilityEntity.getFeederSideCable() );

        cabinet__.setFeederPair( retrieveShelfAvailabilityEntity.getFeederPair() );

        cabinet__.setDistributionCable( retrieveShelfAvailabilityEntity.getDistributionCable() );

        cabinet__.setDistributionSideCable( retrieveShelfAvailabilityEntity.getDistributionSideCable() );

        cabinet__.setDistributionPair( retrieveShelfAvailabilityEntity.getDistributionPair() );

        cabinet__.setName( retrieveShelfAvailabilityEntity.getName() );

        cabinet__.setCustomName( retrieveShelfAvailabilityEntity.getCustomName() );

        cabinet__.setDistance( retrieveShelfAvailabilityEntity.getDistance() );

        cabinet__.setTerminalBox( retrieveShelfAvailabilityEntity.getTerminalBox() );

        cabinet__.setSwitchesAssociated( retrieveShelfAvailabilityEntity.getSwitchesAssociated() );

        cabinet__.setTypeOfTopology( retrieveShelfAvailabilityEntity.getTypeOfTopology() );

        cabinet__.setIdConexoesPotsMsan( retrieveShelfAvailabilityEntity.getIdConexoesPotsMsan() );

        cabinet__.setIdMsan( retrieveShelfAvailabilityEntity.getIdMsan() );

        cabinet__.setLic( retrieveShelfAvailabilityEntity.getLic() );

        cabinet__.setStatus( retrieveShelfAvailabilityEntity.getStatus() );

        cabinet__.setType( retrieveShelfAvailabilityEntity.getType() );

        cabinet__.setBrazilianUrbanPropertyAddress( retrieveShelfAvailabilityEntity.getBrazilianUrbanPropertyAddress() );

        cabinet__.setTypeOfResource( retrieveShelfAvailabilityEntity.getTypeOfResource() );

        cabinet__.setBRASAssociated( retrieveShelfAvailabilityEntity.getBRASAssociated() );

        cabinet__.setAgregatorAssociated( retrieveShelfAvailabilityEntity.getAgregatorAssociated() );

        if ( cabinet__.getSplitter() != null ) {

            List<Splitter> list_ = retrieveShelfAvailabilityEntity.getSplitter();

            if ( list_ != null ) {

                cabinet__.getSplitter().addAll( list_ );
            }
        }

        return cabinet__;
    }

    @Override

    public Shelf getAvailabilityShelfResourceMapperObject(Shelf retrieveShelfAvailabilityEntity) throws Exception {

        if ( retrieveShelfAvailabilityEntity == null ) {

            return null;
        }

        Shelf shelf = new Shelf();

        List<PortAdapterCard> list = retrieveShelfAvailabilityEntity.getHasCards();

        if ( list != null ) {

            shelf.setHasCards(       new ArrayList<PortAdapterCard>( list )

            );
        }

        shelf.setProfile( retrieveShelfAvailabilityEntity.getProfile() );

        shelf.setTypeOfResource( retrieveShelfAvailabilityEntity.getTypeOfResource() );

        shelf.setName( retrieveShelfAvailabilityEntity.getName() );

        shelf.setDslam( retrieveShelfAvailabilityEntity.getDslam() );

        shelf.setNetworkAddressAssociation( retrieveShelfAvailabilityEntity.getNetworkAddressAssociation() );

        shelf.setRack( retrieveShelfAvailabilityEntity.getRack() );

        shelf.setSubRack( retrieveShelfAvailabilityEntity.getSubRack() );

        shelf.setIpController( retrieveShelfAvailabilityEntity.getIpController() );

        shelf.setLogicalResourceAssociation( retrieveShelfAvailabilityEntity.getLogicalResourceAssociation() );

        shelf.setId( retrieveShelfAvailabilityEntity.getId() );

        shelf.setSlotId( retrieveShelfAvailabilityEntity.getSlotId() );

        shelf.setStatus( retrieveShelfAvailabilityEntity.getStatus() );

        List<ResourceCharacteristicSpecification> list_ = retrieveShelfAvailabilityEntity.getResourceCharacteristicSpecifications();

        if ( list_ != null ) {

            shelf.setResourceCharacteristicSpecifications(       new ArrayList<ResourceCharacteristicSpecification>( list_ )

            );
        }

        shelf.setPhysicalResourceSpecAttributes( retrieveShelfAvailabilityEntity.getPhysicalResourceSpecAttributes() );

        shelf.setVendor( retrieveShelfAvailabilityEntity.getVendor() );

        shelf.setModel( retrieveShelfAvailabilityEntity.getModel() );

        shelf.setIpAddress( retrieveShelfAvailabilityEntity.getIpAddress() );

        return shelf;
    }

    @Override

    public List<PortAdapterCard> getAvailabilityResourceSummaryResourceMapperObject(List<RetrieveAvailabilityDslamEntity> retrieveAvailabilityEntity) throws Exception {

        if ( retrieveAvailabilityEntity == null ) {

            return null;
        }

        List<PortAdapterCard> list = new ArrayList<PortAdapterCard>();

        for ( RetrieveAvailabilityDslamEntity retrieveAvailabilityDslamEntity : retrieveAvailabilityEntity ) {

            list.add( getAvailabilityPortAdapterCardResourceDslamMapperObject( retrieveAvailabilityDslamEntity ) );
        }

        return list;
    }

    @Override

    public List<PortAdapterCard> getAvailabilityResourceSummaryResourceMsanMapperObject(List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityEntity) throws Exception {

        if ( retrieveAvailabilityEntity == null ) {

            return null;
        }

        List<PortAdapterCard> list = new ArrayList<PortAdapterCard>();

        for ( RetrieveAvailabilityMsanEntity retrieveAvailabilityMsanEntity : retrieveAvailabilityEntity ) {

            list.add( getAvailabilityPortAdapterCardResourceMsanMapperObject( retrieveAvailabilityMsanEntity ) );
        }

        return list;
    }

    @Override

    public PortAdapterCard getAvailabilityPortAdapterCardResourceDslamMapperObject(RetrieveAvailabilityDslamEntity retrieveAvailabilityEntity) throws Exception {

        if ( retrieveAvailabilityEntity == null ) {

            return null;
        }

        PortAdapterCard portAdapterCard_ = new PortAdapterCard();

        if ( retrieveAvailabilityEntity.getSpeed() != null ) {

            portAdapterCard_.setMaxBroadbandSpeed( String.valueOf( retrieveAvailabilityEntity.getSpeed() ) );
        }

        if ( retrieveAvailabilityEntity.getQuantityPort() != null ) {

            portAdapterCard_.setFreePorts( String.valueOf( retrieveAvailabilityEntity.getQuantityPort() ) );
        }

        portAdapterCard_.setTechnology( retrieveAvailabilityEntity.getTechnology() );

        return portAdapterCard_;
    }

    @Override

    public PortAdapterCard getAvailabilityPortAdapterCardResourceMsanMapperObject(RetrieveAvailabilityMsanEntity retrieveAvailabilityMsanEntity) throws Exception {

        if ( retrieveAvailabilityMsanEntity == null ) {

            return null;
        }

        PortAdapterCard portAdapterCard_ = new PortAdapterCard();

        if ( retrieveAvailabilityMsanEntity.getSpeed() != null ) {

            portAdapterCard_.setMaxBroadbandSpeed( String.valueOf( retrieveAvailabilityMsanEntity.getSpeed() ) );
        }

        if ( retrieveAvailabilityMsanEntity.getQuantityPort() != null ) {

            portAdapterCard_.setFreePorts( String.valueOf( retrieveAvailabilityMsanEntity.getQuantityPort() ) );
        }

        portAdapterCard_.setTechnology( retrieveAvailabilityMsanEntity.getTechnology() );

        if ( retrieveAvailabilityMsanEntity.getId() != null ) {

            portAdapterCard_.setId( String.valueOf( retrieveAvailabilityMsanEntity.getId() ) );
        }

        return portAdapterCard_;
    }

    @Override

    public ResourceInventoryEntity getAvailabilityMapperObject(ResourceInventoryEntity resourceInventoryEntity) throws Exception {

        if ( resourceInventoryEntity == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity_ = new ResourceInventoryEntity();

        resourceInventoryEntity_.setAddress( resourceInventoryEntity.getAddress() );

        List<GeneralDistributor> list = resourceInventoryEntity.getGeneralDistributors();

        if ( list != null ) {

            resourceInventoryEntity_.setGeneralDistributors(       new ArrayList<GeneralDistributor>( list )

            );
        }

        resourceInventoryEntity_.setCustomerOrder( resourceInventoryEntity.getCustomerOrder() );

        resourceInventoryEntity_.setCabinet( getAvailabilityCabinetResourceDslamMapperObject( resourceInventoryEntity.getCabinet() ) );

        resourceInventoryEntity_.setSatellite( resourceInventoryEntity.getSatellite() );

        List<PhysicalLink> list_ = resourceInventoryEntity.getPhysicalLinks();

        if ( list_ != null ) {

            resourceInventoryEntity_.setPhysicalLinks(       new ArrayList<PhysicalLink>( list_ )

            );
        }

        resourceInventoryEntity_.setResourceFacingService( resourceInventoryEntity.getResourceFacingService() );

        resourceInventoryEntity_.setCircuit( resourceInventoryEntity.getCircuit() );

        resourceInventoryEntity_.setNetworkAggregator( resourceInventoryEntity.getNetworkAggregator() );

        List<CustomerFacingService> list__ = resourceInventoryEntity.getCustomerFacingService();

        if ( list__ != null ) {

            resourceInventoryEntity_.setCustomerFacingService(       new ArrayList<CustomerFacingService>( list__ )

            );
        }

        resourceInventoryEntity_.setPhysicalResourceSummary( resourceInventoryEntity.getPhysicalResourceSummary() );

        resourceInventoryEntity_.setResourceOrder( resourceInventoryEntity.getResourceOrder() );

        resourceInventoryEntity_.setOperationService( resourceInventoryEntity.getOperationService() );

        resourceInventoryEntity_.setResource( resourceInventoryEntity.getResource() );

        resourceInventoryEntity_.setResourceInventoryWarn( resourceInventoryEntity.getResourceInventoryWarn() );

        List<Equipment> list___ = resourceInventoryEntity.getEquipment();

        if ( list___ != null ) {

            resourceInventoryEntity_.setEquipment(       new ArrayList<Equipment>( list___ )

            );
        }

        resourceInventoryEntity_.setGatherResourceInformation( resourceInventoryEntity.getGatherResourceInformation() );

        resourceInventoryEntity_.setCodeReturn( resourceInventoryEntity.getCodeReturn() );

        resourceInventoryEntity_.setMessageReturn( resourceInventoryEntity.getMessageReturn() );

        return resourceInventoryEntity_;
    }
}

