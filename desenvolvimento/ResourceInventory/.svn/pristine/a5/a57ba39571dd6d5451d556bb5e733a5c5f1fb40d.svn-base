package com.tlf.oss.resourceinventory.granite.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceEntity;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Mapper
public interface ReserveResourceInformationMapper {
	
	@Mappings({
	@Mapping(target="typeOfResource", source="reserveResourceEntity.resourceType"),
	@Mapping(target="typeOfResourceId", source="reserveResourceEntity.listCode")
	 })
	public PhysicalLink getReserveResourcePhysicalLinkMapperObject(ReserveResourceEntity reserveResourceEntity)throws OSSBusinessException;

	@Mappings({
	@Mapping(target="cabinet", source="reserveResourceEntity.cabinet"),
	@Mapping(target="operationService", source="reserveResourceEntity.operationService")
	 })
	public ResourceInventoryEntity getReserveResourceCabinetMapperObject(ReserveResourceEntity reserveResourceEntity)throws OSSBusinessException;
	
}
