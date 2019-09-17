package com.tlf.oss.resourceinventory.tbs.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.tbs.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateValidator extends ValidatorEntity implements ConstraintValidator<Allocate, ResourceInventoryEntity> {

	@Override
	public void initialize(Allocate constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			
			validateCustomerOrder(entity, EntityFields.PURCHASE_ORDER_NUMBER.getValue());
			validateInvolvesCustomer(entity, EntityFields.ID.getValue());
			validateCustomerFacingServices(entity);
			validatePhysicalResourceSummary(entity);
			validateResourceFacingService(entity, EntityFields.SERVICE_ID.getValue());
			validateCabinet(entity);
			validateSwitchesAssociated(entity, EntityFields.NAME.getValue());

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}
