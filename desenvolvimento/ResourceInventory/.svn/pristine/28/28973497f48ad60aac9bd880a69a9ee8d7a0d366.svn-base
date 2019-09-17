package com.tlf.oss.resourceinventory.osp.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.osp.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AvailabilityRetrievalValidator extends ValidatorEntity implements ConstraintValidator<AvailabilityRetrieval, ResourceInventoryEntity> {

	@Override
	public void initialize(AvailabilityRetrieval availabilityRetrieval) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {

			validatorAdress(entity, EntityFields.CNL.getValue(),EntityFields.AT.getValue(),EntityFields.STREETCODE.getValue(),EntityFields.STREETNRFIRST.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}
