package com.tlf.oss.resourceinventory.osp.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.osp.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ReserveValidator extends ValidatorEntity implements ConstraintValidator<Reserve, ResourceInventoryEntity>{


	@Override
	public void initialize(Reserve reserve) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {

			validatorAdress(entity, EntityFields.CNL.getValue(), EntityFields.AT.getValue(), EntityFields.STREETCODE.getValue(), EntityFields.STREETNRFIRST.getValue(), EntityFields.PLACEPHYSICALRESOURCEASSOC.getValue(), EntityFields.PHYSICALLINK.getValue(), EntityFields.ACCESSTECHNOLOGY.getValue());

			if (isGpon(entity)) {
				validatorResourceFacingService(entity,EntityFields.SERVICE_ID.getValue());
				validatorServiceDescribedBy(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.NAME.getValue());
				validatorServiceSpecCharDescribes(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.VALUE.getValue());
			}else{
				validatorServiceDescribedBy(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.NAME.getValue());
				validatorServiceSpecCharDescribes(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.VALUE.getValue());
			}

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}