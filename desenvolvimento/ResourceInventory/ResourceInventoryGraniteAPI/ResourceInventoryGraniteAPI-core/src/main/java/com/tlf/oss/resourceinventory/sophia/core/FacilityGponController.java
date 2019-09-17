package com.tlf.oss.resourceinventory.sophia.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.IdentifyNetworkController;
import com.tlf.oss.resourceinventory.granite.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.sophia.core.dao.RetrieveFacilityResourceGponDao;
import com.tlf.oss.resourceinventory.sophia.core.entity.RetrieveFacilityResourceGponEntity;
import com.tlf.oss.resourceinventory.sophia.core.mapper.impl.RetrieveFacilityResourceGponMapper;
import com.tlf.oss.resourceinventory.sophia.core.validation.FacilityRetrieval;
import com.tlf.oss.resourceinventory.sophia.core.validation.ValidatorEntity;

@Logged
public class FacilityGponController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public RetrieveFacilityResourceGponDao retrieveFacilityGponDao;
	
	@Inject
	private RetrieveFacilityResourceGponMapper mapper;
	
	@Inject
	private IdentifyNetworkController identifyNetworkController;
	
	@Inject
	protected OSSLogger logger;

	public ResourceInventoryEntity facilityResource(@FacilityRetrieval ResourceInventoryEntity entity) throws OSSBusinessException {		
		entity = identifyNetwork(entity);
		
		return resourceFacilityGPON(entity);
	}
	
	private ResourceInventoryEntity resourceFacilityGPON(ResourceInventoryEntity entity) throws OSSBusinessException {
		return resourceFacility(entity);
	}
	
	public ResourceInventoryEntity resourceFacility(ResourceInventoryEntity entity) throws OSSBusinessException {
		RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity = retrieveFacilityGponDao.
				facilityRetrieval(getRetrieveFacilityResourceGponEntity(entity));
		return mapper.parseGetPhysicalResourceFacility(retrieveFacilityGponEntity, entity);
	}
	
	public RetrieveFacilityResourceGponEntity getRetrieveFacilityResourceGponEntity(ResourceInventoryEntity entity) throws OSSBusinessException {
		RetrieveFacilityResourceGponEntity retrieveFacilityGponEntity = new RetrieveFacilityResourceGponEntity();
		retrieveFacilityGponEntity.setTerminalNumber(getNetworkOwnerID(entity));
		return retrieveFacilityGponEntity;
	}
	
	protected String getNetworkOwnerID(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsTerminal = getResourceFacingService(entity, EntityFields.NETWORK_OWNER_ID.getValue());
		return rfsTerminal.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}
	
	private ResourceInventoryEntity identifyNetwork(ResourceInventoryEntity entity) {		
		return identifyNetworkController.identifyNetwork(entity); 
	}
}