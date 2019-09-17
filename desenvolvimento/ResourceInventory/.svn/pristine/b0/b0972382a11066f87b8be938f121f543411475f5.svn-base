package com.tlf.oss.resourceinventory.tbs.core.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;

public class DetermineAvailabilityValidator extends ValidatorEntity implements ConstraintValidator<DetermineAvailability, ResourceInventoryEntity> {

	@Override
	public void initialize(DetermineAvailability constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		
		try {
			if (!checkCoverageWarn(entity)) {
				validateCabinetName(entity);			
				validateSwitchedAssociated(entity);	
			}
			
		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

	/**
	 * Metodo para validar se o SwitchedAssociated name esta nulo ou vazio 
	 * @param entity
	 * @throws OSSBusinessException
	 */
	private void validateSwitchedAssociated(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		if(entity.getCabinet() == null || entity.getCabinet().getSwitchesAssociated() == null
				|| entity.getCabinet().getSwitchesAssociated().getName() == null
				|| entity.getCabinet().getSwitchesAssociated().getName().isEmpty()) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_001.getDescription(), ExceptionInfoEnum.RITBS_001.getCode(),
					String.format(ExceptionInfoEnum.RITBS_001.getMessage(), "SWITCHES_ASSOCIATED"));
		}
	}
	
	private void validateCabinetName(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		if(entity.getCabinet() == null || entity.getCabinet().getName() == null
				|| entity.getCabinet().getName().isEmpty()) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_001.getDescription(), ExceptionInfoEnum.RITBS_001.getCode(),
					String.format(ExceptionInfoEnum.RITBS_001.getMessage(), "CABINET_NAME"));
		}
	}
	
	public static boolean checkCoverageWarn (ResourceInventoryEntity entity) {
		if(entity.getResourceInventoryWarn() != null) {
			return 	"RI-0100".equals(entity.getResourceInventoryWarn().getCode());
		}
		return false;
	}
	
}
