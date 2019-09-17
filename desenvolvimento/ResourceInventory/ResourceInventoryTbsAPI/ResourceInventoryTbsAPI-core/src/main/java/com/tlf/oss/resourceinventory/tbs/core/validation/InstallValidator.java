package com.tlf.oss.resourceinventory.tbs.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.tbs.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class InstallValidator extends ValidatorEntity implements ConstraintValidator<Install, ResourceInventoryEntity> {
	
	@Override
	public void initialize(Install constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			
			validateResourceFacingService(entity, EntityFields.SERVICE_ID.getValue());
			validateCustomerOrder(entity, EntityFields.PURCHASE_ORDER_NUMBER.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}
