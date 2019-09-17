package com.tlf.oss.resourceinventory.osp.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.osp.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateValidator extends ValidatorEntity
		implements ConstraintValidator<Deallocate, ResourceInventoryEntity> {

	@Override
	public void initialize(Deallocate deallocate) {
	}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();

		try {
			
			validatorAdress(entity, EntityFields.CNL.getValue(), EntityFields.AT.getValue(),EntityFields.PLACEPHYSICALRESOURCEASSOC.getValue(), EntityFields.PHYSICALLINK.getValue(), EntityFields.ACCESSTECHNOLOGY.getValue());
			
			if (isGpon(entity)) {
				validatorResourceFacingService(entity, EntityFields.SERVICE_ID.getValue());
				validatorCustomerOrder(entity, EntityFields.PURCHASEORDERNUMBER.getValue());
			} else {
				validatorCustomerOrder(entity, EntityFields.PURCHASEORDERNUMBER.getValue());
			}
			
		} catch (OSSBusinessException ex) {
			context.buildConstraintViolationWithTemplate(ex.getDetail()).addConstraintViolation();
			isValid = false;
		}
		return isValid;
	}

}
