package com.tlf.oss.resourceinventory.granite.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateValidator extends ValidatorEntity implements ConstraintValidator<Deallocate, ResourceInventoryEntity>{


	@Override
	public void initialize(Deallocate availabilityRetrieval) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			validatorAdress(entity,EntityFields.PLACEPHYSICALRESOURCEASSOC.getValue(),EntityFields.PHYSICALLINK.getValue(),EntityFields.ACCESSTECHNOLOGY.getValue());

			if (isGpon(entity)) {
				validatorResourceFacingService(entity,EntityFields.SERVICE_ID.getValue());
			}else{
				validatorServiceDescribedBy(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.NAME.getValue());
				validatorServiceSpecCharDescribes(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.VALUE.getValue());
				validatorCustomerOrder(entity,entity.getCustomerOrder().getCustomerOrderType());
			}

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}