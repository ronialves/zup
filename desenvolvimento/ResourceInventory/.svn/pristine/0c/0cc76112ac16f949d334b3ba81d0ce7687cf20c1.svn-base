package com.tlf.oss.resourceinventory.granite.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Mapper
public interface AvailabilityRetrieveResourceMapper {
	
	@Mapping(target="cabinet", source="cabinet")
	public ResourceInventoryEntity getAvailabilityResourceMapperObject(Cabinet cabinet)throws Exception;

	@Mapping(target="cabinet", source="cabinet")
	public ResourceInventoryEntity getAvailabilityCabinetResourceMsanMapperObject(Cabinet cabinet)throws Exception;

	@Mapping(target="hasShelves", source="retrieveShelfAvailabilityEntity.hasShelves")
	public Cabinet getAvailabilityCabinetResourceDslamMapperObject(Cabinet retrieveShelfAvailabilityEntity)throws Exception;
	
	@Mapping(target="hasCards", source="retrieveShelfAvailabilityEntity.hasCards")
	public Shelf getAvailabilityShelfResourceMapperObject(Shelf retrieveShelfAvailabilityEntity)throws Exception;

	@IterableMapping(elementTargetType=PortAdapterCard.class)
	public List<PortAdapterCard> getAvailabilityResourceSummaryResourceMapperObject(List<RetrieveAvailabilityDslamEntity> retrieveAvailabilityEntity)throws Exception;

	@IterableMapping(elementTargetType=PortAdapterCard.class)
	public List<PortAdapterCard> getAvailabilityResourceSummaryResourceMsanMapperObject(List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityEntity)throws Exception;

	@Mappings({
	@Mapping(target="freePorts", source="retrieveAvailabilityEntity.quantityPort"),
	@Mapping(target="maxBroadbandSpeed", source="retrieveAvailabilityEntity.speed"),
	@Mapping(target="technology", source="retrieveAvailabilityEntity.technology")
	 })
	public PortAdapterCard getAvailabilityPortAdapterCardResourceDslamMapperObject(RetrieveAvailabilityDslamEntity retrieveAvailabilityEntity)throws Exception;

	@Mappings({
	@Mapping(target="freePorts", source="retrieveAvailabilityMsanEntity.quantityPort"),
	@Mapping(target="maxBroadbandSpeed", source="retrieveAvailabilityMsanEntity.speed"),
	@Mapping(target="technology", source="retrieveAvailabilityMsanEntity.technology")
	})
	public PortAdapterCard getAvailabilityPortAdapterCardResourceMsanMapperObject(RetrieveAvailabilityMsanEntity retrieveAvailabilityMsanEntity)throws Exception;

	@Mappings({
	@Mapping(target="address", source="resourceInventoryEntity.address")
	 })
	public  ResourceInventoryEntity getAvailabilityMapperObject(ResourceInventoryEntity resourceInventoryEntity)throws Exception;
}
