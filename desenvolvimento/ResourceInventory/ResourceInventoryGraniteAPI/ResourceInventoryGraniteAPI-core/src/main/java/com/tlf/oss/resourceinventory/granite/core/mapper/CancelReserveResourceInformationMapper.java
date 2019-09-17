package com.tlf.oss.resourceinventory.granite.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Mapper
public interface CancelReserveResourceInformationMapper {
	
	
	@Mappings({
	@Mapping(target="resourceFacingService", source="reserveResourceEntity.resourceFacingService"),
	@Mapping(target="customerFacingService", source="reserveResourceEntity.customerFacingService")
	  })
	public ResourceInventoryEntity getCancelReserveResourceMapperObject(ResourceInventoryEntity reserveResourceEntity)throws OSSBusinessException;
	
	
	@Mappings({
	@Mapping(target="cabinet", source="cancelResourceEntity.cabinet"),
	@Mapping(target="operationService", source="cancelResourceEntity.operationService")
	 })
	public ResourceInventoryEntity getCancelReserveResourceCabinetMapperObject(CancelResourceEntity cancelResourceEntity)throws OSSBusinessException;

	
	@Mappings({
	@Mapping(target="description", source="cancelResourceEntity.description"),
	@Mapping(target="statusCode", defaultValue="RIGRANITE-001", source="cancelResourceEntity.code"),
	@Mapping(target="detail", source="cancelResourceEntity.description")
	 })
	public OSSBusinessException getErrorCancelReserveResourceMapperObject(CancelResourceEntity cancelResourceEntity)throws OSSBusinessException;
}


