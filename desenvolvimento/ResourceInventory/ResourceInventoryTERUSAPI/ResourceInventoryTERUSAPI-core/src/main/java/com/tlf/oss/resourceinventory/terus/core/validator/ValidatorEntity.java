package com.tlf.oss.resourceinventory.terus.core.validator;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.terus.core.enums.Code;
import com.tlf.oss.resourceinventory.terus.core.enums.Message;

public abstract class ValidatorEntity {

	/**
	 * Metodo reponsavel por validar as informaçoes de cabinet do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorCabinet(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {

		Optional<Cabinet> cabinet = Optional.ofNullable(entity.getCabinet());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Cabinet>> constraintViolations = null;

		if (!cabinet.isPresent())
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RITERUS_001.getValue(),
					"O valor do campo cabinet eh nulo");

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(cabinet.get(),param);

			if (constraintViolations.size()>0)
				throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RITERUS_001.getValue(),
						"O valor do campo {"+param+"} eh nulo");
		}

	}


	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceDescriBy do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorServiceDescribedBy(List<ServiceDescribedBy> entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ServiceDescribedBy>> constraintViolations = null;

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity);

		if(Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RITERUS_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				constraintViolations = validator.validateProperty(valueServiceDescribe,param);

				if (constraintViolations.size()>0)
					throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RITERUS_001.getValue(),
							"O valor do campo {"+param+"} eh nulo");
			}
		}
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceSpecCharDescribes do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorServiceSpecCharDescribes(List<ServiceDescribedBy> entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ServiceSpecCharDescribes>> constraintViolations = null;

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity);

		if(Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RITERUS_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				if(Optional.ofNullable(valueServiceDescribe.getServiceSpecCharDescribes()).map(List::size).orElse(0) == 0)
					throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RITERUS_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICESPECCHARDESCRIBES.getValue() +" para o name {"+param+"}");

				for (ServiceSpecCharDescribes valueServiceDescribeChar : valueServiceDescribe.getServiceSpecCharDescribes()) {

					constraintViolations = validator.validateProperty(valueServiceDescribeChar,param);

					if (constraintViolations.size()>0)
						throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RITERUS_001.getValue(),
								"O valor do campo {"+param+"} eh nulo");
				}

			}
		}
	}

}
