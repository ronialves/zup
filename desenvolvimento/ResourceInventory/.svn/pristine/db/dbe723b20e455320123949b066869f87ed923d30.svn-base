package com.tlf.oss.resourceinventory.radius.validation;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.radius.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;

import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ValidatorEntity {

	
	public void validateResourceFacingService(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		Optional<ResourceFacingService> resourceFacingService = Optional.ofNullable(entity.getResourceFacingService());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceFacingService>> constraintViolations = null;
		
		if (!resourceFacingService.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(), ExceptionInfoEnum.RIRADIUS_001.getCode(),
					String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(), "RESOURCE_FACING_SERVICE"));

		for (String param : params) {
			
			constraintViolations = validator.validateProperty(resourceFacingService.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(), ExceptionInfoEnum.RIRADIUS_001.getCode(),
						String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(), param));
		}
	}

	public void validateResourceOrder(ResourceInventoryEntity entity) throws OSSBusinessException {

		Optional<ResourceOrder> resourceOrder = Optional.ofNullable(entity.getResourceOrder());
		if (!resourceOrder.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(), ExceptionInfoEnum.RIRADIUS_001.getCode(),
					String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(), "RESOURCE_ORDER"));
	}

	public void validateResourceOrderItem(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		validateResourceOrder(entity);
		Optional<ResourceOrderItem> resourceOrderItem = Optional
				.ofNullable(entity.getResourceOrder().getResourceOrderItem());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceOrderItem>> constraintViolations = null;
		
		if (!resourceOrderItem.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(), ExceptionInfoEnum.RIRADIUS_001.getCode(),
					String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(), "RESOURCE_ORDER_ITEM"));
		
		for (String param : params) {
			
			constraintViolations = validator.validateProperty(resourceOrderItem.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(), ExceptionInfoEnum.RIRADIUS_001.getCode(),
						String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(), param));
			
		}
	}
	
	public void validateResourceFacingServiceId(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		validateResourceFacingService(entity);
		Optional<String> serviceId = Optional.ofNullable(entity.getResourceFacingService().getServiceId());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<String>> constraintViolations = null;
		
		if (!serviceId.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(), ExceptionInfoEnum.RIRADIUS_001.getCode(),
					String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(), "SERVICE_ID"));
		
		for (String param : params) {
			
			constraintViolations = validator.validateProperty(serviceId.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RIRADIUS_001.getDescription(), ExceptionInfoEnum.RIRADIUS_001.getCode(),
						String.format(ExceptionInfoEnum.RIRADIUS_001.getMessage(), param));
			
		}
	}

}
