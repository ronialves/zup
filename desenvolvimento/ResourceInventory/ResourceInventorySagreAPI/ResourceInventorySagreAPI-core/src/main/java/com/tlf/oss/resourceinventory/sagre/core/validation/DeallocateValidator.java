package com.tlf.oss.resourceinventory.sagre.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.sagre.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateValidator extends ValidatorEntity implements ConstraintValidator<Deallocate, ResourceInventoryEntity> {

	@Override
	public void initialize(Deallocate constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			
			validateAddress(entity, EntityFields.CNL.getValue());
			validatePhysicalLink(entity, EntityFields.VOICE_PROTOCOL.getValue());
			validateResourceFacingService(entity, EntityFields.SERVICE_ID.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}
