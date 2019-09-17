package com.tlf.oss.resourceinventory.granite.core.mapper;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationDslamEntity;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationMsanEntity;

import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;

import com.tlf.oss.resourceinventory.schemas.Equipment;

import com.tlf.oss.resourceinventory.schemas.GeneralDistributor;

import com.tlf.oss.resourceinventory.schemas.PhysicalLink;

import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-08-22T10:32:05-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

public class AcessResourceInformationMapperImpl implements AcessResourceInformationMapper {

    @Override

    public List<PhysicalLink> getAcessResourceInformationListMsanMapperObject(List<RetrieveAccessResourceInformationMsanEntity> retrieveAccessResourceInformationListMsanEntity) throws Exception {

        if ( retrieveAccessResourceInformationListMsanEntity == null ) {

            return null;
        }

        List<PhysicalLink> list = new ArrayList<PhysicalLink>();

        for ( RetrieveAccessResourceInformationMsanEntity retrieveAccessResourceInformationMsanEntity : retrieveAccessResourceInformationListMsanEntity ) {

            list.add( getAcessResourceInformationMsanMapperObject( retrieveAccessResourceInformationMsanEntity ) );
        }

        return list;
    }

    @Override

    public PhysicalLink getAcessResourceInformationMsanMapperObject(RetrieveAccessResourceInformationMsanEntity retrieveAccessResourceInformationMsanEntity) throws Exception {

        if ( retrieveAccessResourceInformationMsanEntity == null ) {

            return null;
        }

        PhysicalLink physicalLink_ = new PhysicalLink();

        physicalLink_.setAccessTechnology( retrieveAccessResourceInformationMsanEntity.getAccessTecnology() );

        physicalLink_.setTypeOfResource( retrieveAccessResourceInformationMsanEntity.getTypeOfResource() );

        physicalLink_.setVoiceProtocol( retrieveAccessResourceInformationMsanEntity.getVoiceProtocol() );

        return physicalLink_;
    }

    @Override

    public List<PhysicalLink> getAcessResourceInformationListDslamMapperObject(List<RetrieveAccessResourceInformationDslamEntity> retrieveAccessResourceInformationDslamEntity) throws Exception {

        if ( retrieveAccessResourceInformationDslamEntity == null ) {

            return null;
        }

        List<PhysicalLink> list = new ArrayList<PhysicalLink>();

        for ( RetrieveAccessResourceInformationDslamEntity retrieveAccessResourceInformationDslamEntity_ : retrieveAccessResourceInformationDslamEntity ) {

            list.add( getAcessResourceInformationDslamMapperObject( retrieveAccessResourceInformationDslamEntity_ ) );
        }

        return list;
    }

    @Override

    public PhysicalLink getAcessResourceInformationDslamMapperObject(RetrieveAccessResourceInformationDslamEntity retrieveAccessResourceInformationDslamEntity) throws Exception {

        if ( retrieveAccessResourceInformationDslamEntity == null ) {

            return null;
        }

        PhysicalLink physicalLink_ = new PhysicalLink();

        physicalLink_.setAccessTechnology( retrieveAccessResourceInformationDslamEntity.getAccessTecnology() );

        physicalLink_.setTypeOfResource( retrieveAccessResourceInformationDslamEntity.getTypeOfResource() );

        physicalLink_.setVoiceProtocol( retrieveAccessResourceInformationDslamEntity.getVoiceProtocol() );

        return physicalLink_;
    }

    @Override

    public ResourceInventoryEntity getAcessResourceInformationMapperObject(ResourceInventoryEntity resourceInventoryEntity) throws Exception {

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

        resourceInventoryEntity_.setCabinet( resourceInventoryEntity.getCabinet() );

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

