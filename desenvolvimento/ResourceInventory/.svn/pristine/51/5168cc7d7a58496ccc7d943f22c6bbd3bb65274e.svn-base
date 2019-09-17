package com.tlf.oss.resourceinventory.tbs.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class GatherResourceValidator extends ValidatorEntity implements ConstraintValidator<GatherResource, ResourceInventoryEntity> {

    @Override
    public void initialize(GatherResource constraintAnnotation) {}

    @Override
    public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
        boolean isValid = true;
        context.disableDefaultConstraintViolation();
        try {

            validateGatherResource(entity);

        } catch (OSSBusinessException e) {
            context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}
