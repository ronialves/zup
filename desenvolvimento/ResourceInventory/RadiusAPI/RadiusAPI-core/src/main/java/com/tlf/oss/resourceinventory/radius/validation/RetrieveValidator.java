package com.tlf.oss.resourceinventory.radius.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.radius.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveValidator extends ValidatorEntity implements ConstraintValidator<Retrieve, ResourceInventoryEntity> {

	@Override
	public void initialize(Retrieve constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			
			validateResourceFacingServiceId(entity, EntityFields.SERVICE_ID.getValue());
			validateResourceOrderItem(entity, EntityFields.NAME.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}
