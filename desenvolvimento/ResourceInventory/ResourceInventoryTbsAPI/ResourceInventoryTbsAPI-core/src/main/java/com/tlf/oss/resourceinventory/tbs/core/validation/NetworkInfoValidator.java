package com.tlf.oss.resourceinventory.tbs.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.enums.EntityFields;

public class NetworkInfoValidator extends ValidatorEntity implements ConstraintValidator<NetworkInfo, ResourceInventoryEntity> {

	@Override
	public void initialize(NetworkInfo constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			
			validateResourceFacingService(entity);
			validateResourceFacingServiceId(entity, EntityFields.SERVICE_ID.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}
}
