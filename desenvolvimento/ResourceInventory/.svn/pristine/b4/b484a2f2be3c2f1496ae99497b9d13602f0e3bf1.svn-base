package com.tlf.oss.resourceinventory.granite.core.mapper.impl;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.DeallocateInternalResourceEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateResourceMapper{
	
	public ResourceInventoryEntity parseGetDeallocateResource(DeallocateInternalResourceEntity response, ResourceInventoryEntity entity) throws OSSBusinessException{

		entity.setCabinet(response.getCabinet());
		entity.setOperationService(response.getOperationService());
		
		return entity;
	}

}
