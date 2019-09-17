package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveGponResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveFacilityGponDao;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class FacilityResourceGponController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	public RetrieveFacilityGponDao retrieveFacilityGponDao;

	@Inject
	private RetrieveGponResourceMapper mapper;
	
	@Inject
	private IdentifyNetworkController identifyNetworkController;
	
	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(),
			String.format(Code.RIGRANITE_003.getDescription(), "Query GponFacility"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	public ResourceInventoryEntity resourceFacility(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		entity = identifyNetwork(entity);
		
		RetrieveFacilityGponEntity retrieveFacilityGponEntity = retrieveFacilityGponDao.
				facilityRetrieval(getRetrieveFacilityResourceGponEntity(entity));
				
		if(null != retrieveFacilityGponEntity) {
			return mapper.parseGetPhysicalResourceFacility(retrieveFacilityGponEntity, entity);
		} else {
			this.falloutConfig.setErrorCode("1");
			this.falloutConfig.setErrorMessage(Message.ERRO_RESOURCE_RETRIEVE_GPON_FACILITY.getValue());
			this.falloutConfig.setDetailMessage("1".concat(";").concat(Message.ERRO_RESOURCE_RETRIEVE_GPON_FACILITY.getValue()));
			
			throw OSSExceptionFactory.getOSSBusinessException(this.falloutConfig);
		}				
	}
	
	public RetrieveFacilityGponEntity getRetrieveFacilityResourceGponEntity(ResourceInventoryEntity entity) throws OSSBusinessException {
		RetrieveFacilityGponEntity retrieveFacilityGponEntity = new RetrieveFacilityGponEntity();
			retrieveFacilityGponEntity.setTerminalNumber(entity.getResourceFacingService().getServiceId());
		return retrieveFacilityGponEntity;
	}
	
	public ResourceInventoryEntity identifyNetwork(ResourceInventoryEntity entity) {		
		return identifyNetworkController.identifyNetwork(entity); 
	}
}