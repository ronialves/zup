package com.tlf.oss.resourceinventory.osp.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.osp.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ReleaseValidator extends ValidatorEntity implements ConstraintValidator<Release, ResourceInventoryEntity>{


	@Override
	public void initialize(Release release) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {

			validatorAdress(entity, EntityFields.CNL.getValue(),EntityFields.AT.getValue(),EntityFields.PLACEPHYSICALRESOURCEASSOC.getValue(),EntityFields.PHYSICALLINK.getValue(),EntityFields.ACCESSTECHNOLOGY.getValue());

			if (isGpon(entity)) {
				validatorResourceFacingService(entity,EntityFields.SERVICE_ID.getValue());
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