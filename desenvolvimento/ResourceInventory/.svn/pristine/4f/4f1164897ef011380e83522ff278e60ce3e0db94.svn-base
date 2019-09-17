package com.tlf.oss.resourceinventory.granite.core;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.granite.core.entity.AllocateResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.UpdateResourcesServiceAmoEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.AllocateResourceGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.UpdateResourcesServiceAmoDao;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateResourceGponController {

	@Inject
	private AllocateResourceGponDao allocateResourceGponDao;
	
	@Inject
	private ResourceStatusGponDao resourceStatusGponDao;
	
	@Inject
	UpdateResourcesServiceAmoDao updateResourcesServiceAmoDao;
	
	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(), "", Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);

	@Transactional(rollbackOn = Exception.class)
	public ResourceInventoryEntity allocateResource(final ResourceInventoryEntity entity, Operation operation) throws OSSBusinessException {

		String returnCode;
		String returnDescription;
		
		if(Operation.OFFER_EDITION.equals(operation)){
			ResourceStatusGponEntity updateEntity = resourceStatusGponDao.updateStatus(getResourceStatusGponEntity(entity));
			returnCode = updateEntity.getReturnCode();
			returnDescription = updateEntity.getReturnMessage();
			this.falloutConfig.setOriginAPIDescription(String.format(Code.RIGRANITE_003.getDescription(), ResourceStatusGponEntity.PKG_PATH_PRC_ALTER_STATUS_GPON));
			if (Code.SUCCESS.getValue().equals(returnCode)) {
				UpdateResourcesServiceAmoEntity updateResourcesServiceAmoEntity = new UpdateResourcesServiceAmoEntity();
				updateResourcesServiceAmoEntity.setStatus(entity.getResourceFacingService().getStatus());
				updateResourcesServiceAmoEntity.setAccessDesignator(entity.getResourceFacingService().getServiceId());
				updateResourcesServiceAmoEntity = updateResourcesServiceAmoDao.updateResourcesServiceAmo(updateResourcesServiceAmoEntity);
				returnCode = updateResourcesServiceAmoEntity.getCode();
				returnDescription = updateResourcesServiceAmoEntity.getDescription();
				this.falloutConfig.setOriginAPIDescription(String.format(Code.RIGRANITE_003.getDescription(), UpdateResourcesServiceAmoEntity.UPDATE_RESOURCE_AMO_PROC));
			}
			
		}else{
			AllocateResourceGponEntity allocateResourceGponEntity = allocateResourceGponDao.allocateResource(getAllocateResourceGponEntity(entity)); //novo
			returnCode = allocateResourceGponEntity.getCode();
			returnDescription = allocateResourceGponEntity.getDescription();
			this.falloutConfig.setOriginAPIDescription(String.format(Code.RIGRANITE_003.getDescription(), AllocateResourceGponEntity.PKG_ALLOCATE_PRC_ALLOCATE_GPON));
		}
		
		if (!Code.SUCCESS.getValue().equals(returnCode)) {
			this.falloutConfig.setErrorCode(returnCode);
			this.falloutConfig.setErrorMessage(returnDescription);
			this.falloutConfig.setDetailMessage(returnCode.concat(";").concat(returnDescription));
			throw OSSExceptionFactory.getOSSBusinessException(this.falloutConfig);
		}

		return entity;
	}

	private AllocateResourceGponEntity getAllocateResourceGponEntity(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		AllocateResourceGponEntity allocateResourceGponEntity = new AllocateResourceGponEntity();

		allocateResourceGponEntity.setCustomerId(getResourceFacingServiceByValue(entity, "NRC"));
		allocateResourceGponEntity.setAccessDesignator(entity.getResourceFacingService().getServiceId());

		return allocateResourceGponEntity;
	}

	private String getResourceFacingServiceByValue(ResourceInventoryEntity entity, String value) {

		Optional<ServiceDescribedBy> serviceDescribedBy = entity.getResourceFacingService().getServiceDescribedBy()
				.stream()
				.filter(s -> value.equals(s.getName()))
				.findFirst();

		if (serviceDescribedBy.isPresent()) {
			Optional<String> serviceSpecCharDescribes = serviceDescribedBy.get().getServiceSpecCharDescribes()
					.stream()
					.filter(s -> !s.getValue().isEmpty())
					.map(ServiceSpecCharDescribes::getValue)
					.findFirst();

			if (serviceSpecCharDescribes.isPresent()) {
				return serviceSpecCharDescribes.get();
			}
		}

		return "";
	}
	
	private ResourceStatusGponEntity getResourceStatusGponEntity(final ResourceInventoryEntity entity) {
		entity.getResourceFacingService().setStatus(StatusPathType.IN_CONFIGURATION.getValue());
		final ResourceStatusGponEntity updateEntity = new ResourceStatusGponEntity();
		updateEntity.setTerminal(entity.getResourceFacingService().getServiceId());
		updateEntity.setStatus(entity.getResourceFacingService().getStatus());
		
		return updateEntity;
	}
}
