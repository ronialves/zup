package com.tlf.oss.resourceinventory.sagre.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.sagre.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DetermineAvailabilityValidator extends ValidatorEntity implements ConstraintValidator<DetermineAvailability, ResourceInventoryEntity> {
	
	@Override
	public void initialize(DetermineAvailability constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			
			validateAddress(entity, EntityFields.CNL.getValue(), EntityFields.STREET_CODE.getValue(), 
					EntityFields.STREET_NR_FIRST.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}
	
}
