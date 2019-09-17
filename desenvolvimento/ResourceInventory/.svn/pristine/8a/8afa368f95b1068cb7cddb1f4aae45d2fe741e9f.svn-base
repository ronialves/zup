/**
 * 
 */
package com.tlf.oss.resourceinventory.television.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.television.core.validation.DetermineAvailability;
import com.tlf.oss.resourceinventory.television.enums.EntityFields;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * @author melissa.d.goncalves
 *
 */
public class DetermineAvailabilityValidator extends ValidatorEntity
		implements ConstraintValidator<DetermineAvailability, ResourceInventoryEntity> {

	@Override
	public void initialize(DetermineAvailability constraintAnnotation) {
	}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {

		boolean isValid = true;
		context.disableDefaultConstraintViolation();

		try {
			if (entity.getSatellite() != null) {
				validateSatellite(entity, EntityFields.CONDITIONAL_ACCESS_SYSTEM.getValue(),
						EntityFields.NAME.getValue());
			}
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

}
