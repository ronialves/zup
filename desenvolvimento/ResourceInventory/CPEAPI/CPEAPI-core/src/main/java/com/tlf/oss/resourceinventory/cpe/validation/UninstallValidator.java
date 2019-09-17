package com.tlf.oss.resourceinventory.cpe.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UninstallValidator extends ValidatorEntity implements ConstraintValidator<Uninstall, ResourceInventoryEntity>{

	@Override
	public void initialize(Uninstall constraintAnnotation) {}

	@Override
	public boolean isValid(final ResourceInventoryEntity entity, final ConstraintValidatorContext context) {

		context.disableDefaultConstraintViolation();

		try {
			validateAccessDesignator(entity);

			final String rfs = EntityExtractor.extractResourceOrderItemName(entity);
			final TipoRfs tipoRfs = TipoRfs.fromRoiName(rfs);

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

		return true;
	}
	
	public boolean isValidAccess(final ResourceInventoryEntity entity) throws OSSBusinessException {
		validateBroadbandDesignator(entity);
		return true;
	}

	public boolean isValidVoip(final ResourceInventoryEntity entity) throws OSSBusinessException {
		validateVoipDesignator(entity);
		return true;
	}

	public boolean isValidStb(final ResourceInventoryEntity entity) throws OSSBusinessException {
		validateStbDesignator(entity);
		return true;
	}

}
