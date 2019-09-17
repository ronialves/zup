package com.tlf.oss.resourceinventory.tbs.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.enums.EntityFields;

/**
 * REC2164-44-RI | REC3164-223
 * 
 * @project IONIX-SIGITM
 * @author 80629552
 * @since 20190328
 */
public class CabinetRetrievalValidator extends ValidatorEntity implements ConstraintValidator<CabinetRetrieval, ResourceInventoryEntity>{

	@Override
	public void initialize(CabinetRetrieval constraintAnnotation) {}

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
