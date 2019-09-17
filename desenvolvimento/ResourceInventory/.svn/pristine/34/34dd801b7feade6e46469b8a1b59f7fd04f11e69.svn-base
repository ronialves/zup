package com.tlf.oss.resourceinventory.terus.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.terus.core.enums.EntityFields;

public class DeallocateValidator extends ValidatorEntity implements ConstraintValidator<Deallocate, ResourceInventoryEntity>{

	@Override
	public void initialize(Deallocate reserve) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {

			validatorCabinet(entity, EntityFields.IDMSAN.getValue(),EntityFields.LIC.getValue());
			validatorServiceDescribedBy(entity.getOperationService().getServiceDescribedBy(), EntityFields.NAME.getValue());
			validatorServiceSpecCharDescribes(entity.getOperationService().getServiceDescribedBy(),EntityFields.VALUE.getValue());
			
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}