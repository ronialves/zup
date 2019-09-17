package com.tlf.oss.resourceinventory.granite.core.mapper.impl;

import java.util.ArrayList;

import org.mapstruct.factory.Mappers;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.mapper.ReserveResourceInformationMapper;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ReserveResourceMapper{
	
	public ResourceInventoryEntity parseGetPhysicalReserveResource(ReserveResourceEntity response, ResourceInventoryEntity entity) throws OSSBusinessException{

		ReserveResourceInformationMapper mapper = Mappers.getMapper(ReserveResourceInformationMapper.class);
		
		PhysicalLink physical = mapper.getReserveResourcePhysicalLinkMapperObject(response);
		ResourceInventoryEntity resourceInventoryEntity = mapper.getReserveResourceCabinetMapperObject(response);
		
		entity.setPhysicalLinks(new ArrayList<>());
		entity.getPhysicalLinks().add(physical);
		if (resourceInventoryEntity.getCabinet() != null) {
			entity.setCabinet(resourceInventoryEntity.getCabinet());
		}
		entity.setOperationService(resourceInventoryEntity.getOperationService());
		
		if (!Code.SUCCESS.getValue().equalsIgnoreCase(response.getCode())) {
			throw new OSSBusinessException(response.getDescription(), "RIGRANITE-001", ""+response.getCode());
		}
		return entity;
	}

}
