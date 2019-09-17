package com.tlf.oss.resourceinventory.granite.core.mapper;

import com.tlf.oss.common.exception.OSSBusinessException;

import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceEntity;

import com.tlf.oss.resourceinventory.schemas.PhysicalLink;

import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-08-22T10:32:05-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

public class ReserveResourceInformationMapperImpl implements ReserveResourceInformationMapper {

    @Override

    public PhysicalLink getReserveResourcePhysicalLinkMapperObject(ReserveResourceEntity reserveResourceEntity) throws OSSBusinessException {

        if ( reserveResourceEntity == null ) {

            return null;
        }

        PhysicalLink physicalLink = new PhysicalLink();

        physicalLink.setTypeOfResource( reserveResourceEntity.getResourceType() );

        physicalLink.setTypeOfResourceId( reserveResourceEntity.getListCode() );

        return physicalLink;
    }

    @Override

    public ResourceInventoryEntity getReserveResourceCabinetMapperObject(ReserveResourceEntity reserveResourceEntity) throws OSSBusinessException {

        if ( reserveResourceEntity == null ) {

            return null;
        }

        ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();

        resourceInventoryEntity.setCabinet( reserveResourceEntity.getCabinet() );

        resourceInventoryEntity.setOperationService( reserveResourceEntity.getOperationService() );

        return resourceInventoryEntity;
    }
}

