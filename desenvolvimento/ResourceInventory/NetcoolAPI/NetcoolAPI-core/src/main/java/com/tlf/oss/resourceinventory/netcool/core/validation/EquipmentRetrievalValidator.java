package com.tlf.oss.resourceinventory.netcool.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.netcool.core.validation.EquipmentRetrieval;
import com.tlf.oss.resourceinventory.netcool.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.netcool.enums.EntityFields;

public class EquipmentRetrievalValidator extends ValidatorEntity implements ConstraintValidator<EquipmentRetrieval, ResourceInventoryEntity>{


	@Override
	public void initialize(EquipmentRetrieval constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			validateServiceDescribedBy(entity.getResourceFacingService(), EntityFields.STATE_OR_PROVINCE.getValue(), EntityFields.CITY.getValue());
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}
	
}
