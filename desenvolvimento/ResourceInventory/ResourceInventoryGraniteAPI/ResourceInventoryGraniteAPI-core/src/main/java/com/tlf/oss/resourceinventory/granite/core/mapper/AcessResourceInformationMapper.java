package com.tlf.oss.resourceinventory.granite.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationMsanEntity;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Mapper/*(componentModel="cdi")*/
public interface AcessResourceInformationMapper {
	
	@IterableMapping(elementTargetType=PhysicalLink.class)
	public List<PhysicalLink> getAcessResourceInformationListMsanMapperObject(List<RetrieveAccessResourceInformationMsanEntity> retrieveAccessResourceInformationListMsanEntity)throws Exception;

	@Mappings({
	@Mapping(target="voiceProtocol", source="retrieveAccessResourceInformationMsanEntity.voiceProtocol"),
	@Mapping(target="accessTechnology", source="retrieveAccessResourceInformationMsanEntity.accessTecnology"),
	@Mapping(target="typeOfResource", source="retrieveAccessResourceInformationMsanEntity.typeOfResource")
	 })
	public PhysicalLink getAcessResourceInformationMsanMapperObject(RetrieveAccessResourceInformationMsanEntity retrieveAccessResourceInformationMsanEntity)throws Exception;

	@IterableMapping(elementTargetType=PhysicalLink.class)
	public List<PhysicalLink> getAcessResourceInformationListDslamMapperObject(List<RetrieveAccessResourceInformationDslamEntity> retrieveAccessResourceInformationDslamEntity)throws Exception;

	@Mappings({
	@Mapping(target="voiceProtocol", source="retrieveAccessResourceInformationDslamEntity.voiceProtocol"),
	@Mapping(target="accessTechnology", source="retrieveAccessResourceInformationDslamEntity.accessTecnology"),
	@Mapping(target="typeOfResource", source="retrieveAccessResourceInformationDslamEntity.typeOfResource")
	 })
	public PhysicalLink getAcessResourceInformationDslamMapperObject(RetrieveAccessResourceInformationDslamEntity retrieveAccessResourceInformationDslamEntity)throws Exception;

	@Mappings({
	@Mapping(target="address", source="resourceInventoryEntity.address")
	 })
	public ResourceInventoryEntity getAcessResourceInformationMapperObject(ResourceInventoryEntity resourceInventoryEntity)throws Exception;
}
