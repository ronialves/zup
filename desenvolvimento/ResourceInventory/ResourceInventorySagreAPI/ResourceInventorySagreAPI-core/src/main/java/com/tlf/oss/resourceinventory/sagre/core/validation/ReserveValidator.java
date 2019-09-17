package com.tlf.oss.resourceinventory.sagre.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.sagre.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ReserveValidator extends ValidatorEntity implements ConstraintValidator<Reserve, ResourceInventoryEntity> {
	
	@Override
	public void initialize(Reserve constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			
			validateAddress(entity, EntityFields.STREET_CODE.getValue(), EntityFields.STREET_NR_FIRST.getValue(),
					EntityFields.CNL.getValue());
			validatePhysicalLink(entity, EntityFields.VOICE_PROTOCOL.getValue(), EntityFields.ACCESS_TECHNOLOGY.getValue());
			validateResourceFacingService(entity, EntityFields.SERVICE_ID.getValue());
			validateCabinet(entity, EntityFields.ID.getValue());
			validateTerminalBox(entity, EntityFields.NAME.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}
