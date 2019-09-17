package com.tlf.oss.resourceinventory.cpe.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateValidator extends ValidatorEntity implements ConstraintValidator<Allocate, ResourceInventoryEntity> {

	@Override
	public void initialize(Allocate constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();

		String action = EntityExtractor.extractResourceOrderItemAction(entity);
		try {
			validateAccessDesignator(entity);

			String rfs = EntityExtractor.extractResourceOrderItemName(entity);
			TipoRfs tipoRfs = TipoRfs.fromRoiName(rfs);
			
			switch(tipoRfs) {
    			case ACCESS:
    				return isValidAccess(entity, action);
    			case VOIP:
    				return isValidVoip(entity, action);
    			case STB:
    				return isValidStb(entity, action);
				default:
					break;
			}
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			return false;
		}

		return false;
	}
	
	public boolean isValidAccess(ResourceInventoryEntity entity, String action) throws OSSBusinessException {
		validateBroadbandDesignator(entity);
		validateAccessEquipmentType(entity);
		
		if (isCease(action)) {
			validateSerialNumber(entity);
		}
		
		return true;
	}
	
	public boolean isValidVoip(ResourceInventoryEntity entity, String action) throws OSSBusinessException {
		validateVoipDesignator(entity);
		
		if(isProvide(action)) {
			validateTelephoneNumber(entity, null);
		} else if (isModify(action)) {
			validateTelephoneNumberProvide(entity);
			validateTelephoneNumberCease(entity);
		} else if (isCease(action)) {
			validateSerialNumber(entity);
		}
		
		validateVoipEquipmentType(entity);
		
		return true;
	}
	
	public boolean isValidStb(ResourceInventoryEntity entity, String action) throws OSSBusinessException {
		validateStbDesignator(entity);
		validateStbEquipmentType(entity);
		if(isCease(action)) {
			validateSerialNumber(entity);
		}
		return true;
	}
	
	public boolean isProvide(String action) {
		return null == action 
				|| action.isEmpty() 
				|| RoiAction.PROVIDE.getAction().equalsIgnoreCase(action) 
				|| RoiAction.ADD.getAction().equalsIgnoreCase(action);
	}
	
	public boolean isCease(String action) {
		return null != action 
				&& (RoiAction.CEASE.getAction().equalsIgnoreCase(action) 
				|| RoiAction.DELETE.getAction().equalsIgnoreCase(action));
	}
	
	public boolean isModify	(String action) {
		return null != action 
				&& RoiAction.MODIFY.getAction().equalsIgnoreCase(action);
	}
}
