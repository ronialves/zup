package com.tlf.oss.resourceinventory.osp.core;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources.Resource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes.Tag;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.mapper.OspRequestMapper;
import com.tlf.oss.resourceinventory.osp.core.service.AvailabilityService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class AvailabilityMetallicController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	protected AvailabilityService availabilityService;

	private WsContext wsContext = new WsContext();
	public ResourceInventoryEntity availability(ResourceInventoryEntity entity) throws OSSBusinessException, FacilitiesException {
		
		DetermineResourceAvailabilityRequest request = createAvailabilityRequest(entity);

		DetermineResourceAvailabilityResponse response = availabilityService.determineResourceAvailability(request, wsContext);

		validateResult(response);

		return createResponse(response, entity);

	}

	private DetermineResourceAvailabilityRequest createAvailabilityRequest(ResourceInventoryEntity entity) throws OSSBusinessException {

		DetermineResourceAvailabilityRequest determineResourceAvailability = new DetermineResourceAvailabilityRequest();

		determineResourceAvailability.setAddress(OspRequestMapper.parseAddress(entity.getAddress()));

		wsContext.setRegionCode(entity.getAddress().getCnl()); 
		wsContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		return determineResourceAvailability;
	}

	private void validateResult(DetermineResourceAvailabilityResponse response) throws OSSBusinessException{
		if( response.getResult() != null && response.getResult().getCode() != 0){ 
			throw new OSSBusinessException(response.getResult().getDescription(),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));	

		}
	}

	private ResourceInventoryEntity createResponse(DetermineResourceAvailabilityResponse response, ResourceInventoryEntity entity) throws OSSBusinessException{	
		if(null !=  entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink()
				&& CircuitTypeEnum.GPON.getValue().equalsIgnoreCase(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology()) ){						
			//valida NetType e popula cabo e fibra
			validateNetType(response, entity);

		}
		return entity;
	}
	
	private void updateEntity(Resource resource, ResourceInventoryEntity entity){
		if(null == entity.getCabinet()){
			entity.setCabinet(new Cabinet());
			entity.getCabinet().setPrimaryCable(getValueTag(resource, "ALIM_CABLE_NUM"));
			entity.getCabinet().setPrimaryFiber(getValueTag(resource, "ALIM_FIBER_NUM"));
		}
	}

	private void validateNetType(DetermineResourceAvailabilityResponse response,ResourceInventoryEntity entity){
		for (Resource resource : response.getQualifiedResources().getResource()) {
			if(resource.getNetType() != null ){
				if(resource.getNetType().intValue() == 2){
					updateEntity(resource, entity);
				}
			}			
		}
	}

	private String getValueTag(Resource resource,String label){
		for (Tag tag : resource.getAttributes().getTag()) {
			if(label.equalsIgnoreCase(tag.getLabel())){
				return tag.getValue();
			}
		}
		return null;
	}
}
