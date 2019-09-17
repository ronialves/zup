package com.tlf.oss.resourceinventory.granite.core.mapper;

import com.tlf.oss.common.exception.OSSBusinessException;

import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceEntity;

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

    date = "2019-08-22T10:32:04-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

public class CancelReserveResourceInformationMapperImpl implements CancelReserveResourceInformationMapper {

    @Override

    public ResourceInventoryEntity getCancelReserveResourceMapperObject(ResourceInventoryEntity reserveResourceEntity) throws OSSBusinessException {

        if ( reserveResourceEntity == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();

        resourceInventoryEntity.setResourceFacingService( reserveResourceEntity.getResourceFacingService() );

        List<CustomerFacingService> list = reserveResourceEntity.getCustomerFacingService();

        if ( list != null ) {

            resourceInventoryEntity.setCustomerFacingService(       new ArrayList<CustomerFacingService>( list )

            );
        }

        List<GeneralDistributor> list_ = reserveResourceEntity.getGeneralDistributors();

        if ( list_ != null ) {

            resourceInventoryEntity.setGeneralDistributors(       new ArrayList<GeneralDistributor>( list_ )

            );
        }

        resourceInventoryEntity.setCustomerOrder( reserveResourceEntity.getCustomerOrder() );

        resourceInventoryEntity.setAddress( reserveResourceEntity.getAddress() );

        resourceInventoryEntity.setCabinet( reserveResourceEntity.getCabinet() );

        resourceInventoryEntity.setSatellite( reserveResourceEntity.getSatellite() );

        List<PhysicalLink> list__ = reserveResourceEntity.getPhysicalLinks();

        if ( list__ != null ) {

            resourceInventoryEntity.setPhysicalLinks(       new ArrayList<PhysicalLink>( list__ )

            );
        }

        resourceInventoryEntity.setCircuit( reserveResourceEntity.getCircuit() );

        resourceInventoryEntity.setNetworkAggregator( reserveResourceEntity.getNetworkAggregator() );

        resourceInventoryEntity.setPhysicalResourceSummary( reserveResourceEntity.getPhysicalResourceSummary() );

        resourceInventoryEntity.setResourceOrder( reserveResourceEntity.getResourceOrder() );

        resourceInventoryEntity.setOperationService( reserveResourceEntity.getOperationService() );

        resourceInventoryEntity.setResource( reserveResourceEntity.getResource() );

        resourceInventoryEntity.setResourceInventoryWarn( reserveResourceEntity.getResourceInventoryWarn() );

        List<Equipment> list___ = reserveResourceEntity.getEquipment();

        if ( list___ != null ) {

            resourceInventoryEntity.setEquipment(       new ArrayList<Equipment>( list___ )

            );
        }

        resourceInventoryEntity.setGatherResourceInformation( reserveResourceEntity.getGatherResourceInformation() );

        resourceInventoryEntity.setCodeReturn( reserveResourceEntity.getCodeReturn() );

        resourceInventoryEntity.setMessageReturn( reserveResourceEntity.getMessageReturn() );

        return resourceInventoryEntity;
    }

    @Override

    public ResourceInventoryEntity getCancelReserveResourceCabinetMapperObject(CancelResourceEntity cancelResourceEntity) throws OSSBusinessException {

        if ( cancelResourceEntity == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();

        resourceInventoryEntity.setCabinet( cancelResourceEntity.getCabinet() );

        resourceInventoryEntity.setOperationService( cancelResourceEntity.getOperationService() );

        return resourceInventoryEntity;
    }

    @Override

    public OSSBusinessException getErrorCancelReserveResourceMapperObject(CancelResourceEntity cancelResourceEntity) throws OSSBusinessException {

        if ( cancelResourceEntity == null ) {

            return null;
        }

        OSSBusinessException oSSBusinessException = new OSSBusinessException();

        oSSBusinessException.setDescription( cancelResourceEntity.getDescription() );

        oSSBusinessException.setDetail( cancelResourceEntity.getDescription() );

        if ( cancelResourceEntity.getCode() != null ) {

            oSSBusinessException.setStatusCode( cancelResourceEntity.getCode() );
        }

        else {

            oSSBusinessException.setStatusCode( "RIGRANITE-001" );
        }

        return oSSBusinessException;
    }
}

