package com.tlf.oss.resourceinventory.granite.core.mapper.impl;

import org.mapstruct.factory.Mappers;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.mapper.CancelReserveResourceInformationMapper;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class CancelReserveResourceMapper {
	
	public ResourceInventoryEntity parseGetPhysicalCancelReserveResource(CancelResourceEntity response, ResourceInventoryEntity entity) throws OSSBusinessException{
		CancelReserveResourceInformationMapper mapper = Mappers.getMapper(CancelReserveResourceInformationMapper.class);
		
		entity = mapper.getCancelReserveResourceMapperObject(entity);
		
		ResourceInventoryEntity resourceInventoryEntity = mapper.getCancelReserveResourceCabinetMapperObject(response);
		
		entity.setCabinet(resourceInventoryEntity.getCabinet());
		entity.setOperationService(resourceInventoryEntity.getOperationService());
	
		return entity;
	}

}
