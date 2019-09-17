package com.tlf.oss.resourceinventory.granite.core;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.AvailabilityRetrieveActiveMsanDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.TypeAvailability;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AvailabilityRetrieveMetallicController {

	@Inject
	private AvailabilityRetrieveMsanController availabilityRetrieveMsanController;

	@Inject
	private AvailabilityRetrieveDslamController availabilityRetrieveDslamController;
	
	@Inject
	private AvailabilityRetrieveActiveMsanDslamController availabilityRetrieveActiveMsanDslamController;

	@Inject
	private LoadConfigMemoryController resourceLoadConfigMemoryBO;

	@Inject
	private RetrieveResourceMapper retrieveResourceMapper;
	
	@Inject
	private PathService pathService;

	@Inject
	private OSSLogger logger;

	public ResourceInventoryEntity availabilityRetrieve(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		if(null != entity.getResourceFacingService()) {
			
			String terminal = pathService.getNetworkOwnerID(entity);
			
			Collection<AvailabilityRetrieveActiveMsanDslamEntity> retrieveAvailabilityActiveMsanDslam;
			retrieveAvailabilityActiveMsanDslam = availabilityRetrieveActiveMsanDslamController.getAvailabilityActiveMsanDslam(terminal);
			
			entity = retrieveResourceMapper.parseGetResourceRetrieveActiveMsanDslam(retrieveAvailabilityActiveMsanDslam, entity);
		
		} else {
			
			if(isMsan(entity.getCabinet())){
				logger.log(OSSLogger.INFO, "Tipo de equipamento MSAN" );
	
				// valida porta disponivel MSAN
				List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMsan = availabilityRetrieveMsanController.getAvailabilityMsan(
						entity.getAddress(), entity.getCabinet(), resourceLoadConfigMemoryBO.getMapResult(),
						TypeAvailability.VDSL.getTypes());
	
				entity = retrieveResourceMapper.parseGetPhysicalResourceAvailabilityMsan(retrieveAvailabilityMsan, entity);
			}else{
				logger.log(OSSLogger.INFO, "Tipo de equipamento DSLAM" );
				// valida porta disponivel DSLAM
				Collection<RetrieveAvailabilityDslamEntity> retrieveAvailabilityDslam;
				retrieveAvailabilityDslam = availabilityRetrieveDslamController.getAvailabilityDSLAM(resourceLoadConfigMemoryBO.getMapResult(), entity);
	
				entity = retrieveResourceMapper.parseGetPhysicalResourceAvailabilityDslam(retrieveAvailabilityDslam, entity);
			}
		}
		return entity;
	}

	private boolean isMsan(Cabinet cabinet){
			if(TypeAvailability.MSAN.getTypes().equalsIgnoreCase(cabinet.getHasShelves().get(0).getTypeOfResource())){
				return true;
			}
		return false;
	}
}