package com.tlf.oss.resourceinventory.cpe.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class InstallValidator extends ValidatorEntity implements ConstraintValidator<Install, ResourceInventoryEntity>{

	@Override
	public void initialize(Install constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();

		try {
			validateAccessDesignator(entity);

			String rfs = EntityExtractor.extractResourceOrderItemName(entity);
			TipoRfs tipoRfs = TipoRfs.fromRoiName(rfs);

			switch(tipoRfs) {
    			case ACCESS:
    				return isValidAccess(entity);
    			case VOIP:
    				return isValidVoip(entity);
    			case STB:
    				return isValidStb(entity);
				default:
					break;
			}
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			return false;
		}

		return false;
	}

	public boolean isValidAccess(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateBroadbandDesignator(entity);
		return true;
	}

	public boolean isValidVoip(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateVoipDesignator(entity);
		return true;
	}

	public boolean isValidStb(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateStbDesignator(entity);
		return true;
	}
}
