package com.tlf.oss.resourceinventory.nwi.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.nwi.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * REC2164-44-RI | REC3164-223
 * 
 * @project IONIX-SIGITM
 * @author 80629552
 * @since 20190328
 */
public class EquipmentRetrievalValidator extends ValidatorEntity implements ConstraintValidator<EquipmentRetrieval, ResourceInventoryEntity>{

	@Override
	public void initialize(EquipmentRetrieval constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			validateServiceDescribedBy(entity.getResourceFacingService(), EntityFields.CNL_ACRONYM.getValue());
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

	
	
}
