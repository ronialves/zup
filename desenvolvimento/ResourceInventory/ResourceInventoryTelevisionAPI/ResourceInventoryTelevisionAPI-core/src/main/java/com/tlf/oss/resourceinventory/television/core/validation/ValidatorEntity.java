/**
 * 
 */
package com.tlf.oss.resourceinventory.television.core.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.television.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.schemas.Satellite;
import com.tlf.oss.resourceinventory.schemas.Technology;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * @author melissa.d.goncalves
 *
 */
public class ValidatorEntity {
	
	/**
	 * Validate technology
	 * @param entity
	 * @param params
	 * @throws OSSBusinessException
	 */
	public void validateTechnology(Technology tecnology, String ... params) throws OSSBusinessException {
					
		Optional<Technology> technology = Optional.ofNullable(tecnology);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Technology>> constraintViolations = null;

		for (String param : params) {

			constraintViolations = validator.validateProperty(technology.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RITELEVISION_001.getDescription(), ExceptionInfoEnum.RITELEVISION_001.getCode(),
						String.format(ExceptionInfoEnum.RITELEVISION_001.getMessage(), param));
			
		}
		
	}
	
	/**
	 * Validate satellite
	 * @param entity
	 * @param params
	 * @throws OSSBusinessException
	 */
	
	public void validateSatellite(ResourceInventoryEntity entity, String... params) throws OSSBusinessException {

		Optional<Satellite> satellite = Optional.ofNullable(entity.getSatellite());
		
		if (!satellite.isPresent()) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITELEVISION_001.getDescription(), ExceptionInfoEnum.RITELEVISION_001.getCode(),
					String.format(ExceptionInfoEnum.RITELEVISION_001.getMessage(), "SATELLITE"));
		} else {
			Optional<List<Technology>> technologyList = Optional.ofNullable(entity.getSatellite().getTechnology());
			if (!technologyList.isPresent()) {
				throw new OSSBusinessException(ExceptionInfoEnum.RITELEVISION_001.getDescription(), ExceptionInfoEnum.RITELEVISION_001.getCode(),
						String.format(ExceptionInfoEnum.RITELEVISION_001.getMessage(), "TECHNOLOGY"));
			}
			
			for (Technology technology : entity.getSatellite().getTechnology()) {
				if (technology != null)
					validateTechnology(technology, params);
			}
		}		
	}

}
