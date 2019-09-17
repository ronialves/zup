package com.tlf.oss.resourceinventory.cpe.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UpdateValidator extends ValidatorEntity implements ConstraintValidator<Update, ResourceInventoryEntity>{

	@Override
	public void initialize(Update constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		try {
			validateAccessDesignator(entity);

			String rfs = EntityExtractor.extractResourceOrderItemName(entity);
			TipoRfs tipoRfs = TipoRfs.fromRoiName(rfs);
			
			switch (tipoRfs) {
			case ACCESS_PORT:
				return isValidAccessPort(entity);
			case ACCESS:
				isValidAccess(entity);
				break;
			case VOIP:
				isValidVoip(entity);
				break;
			case STB:
				isValidStb(entity);
				break;
			}

			validateMacaddress(entity);
			validateSerialNumber(entity);
			validateEquipmentModel(entity);

			return true;
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			return false;
		}
	}

	public boolean isValidAccessPort(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateBroadbandDesignator(entity);
		validateGponSerialNumber(entity);
		return true;
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
