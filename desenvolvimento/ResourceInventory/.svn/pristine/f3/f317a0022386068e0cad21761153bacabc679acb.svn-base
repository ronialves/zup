package com.tlf.oss.resourceinventory.sophia.core.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public abstract class ValidatorEntity {

	/**
	 * Metodo reponsavel por validar as informaçoes do resourceFacingService
	 * informação do (ServiceID), networkOwnerID
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected ResourceFacingService getResourceFacingService(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity.getResourceFacingService().getServiceDescribedBy());

		for (String valueServiceDescribe : valueList) {

			resourceFacingService.getServiceDescribedBy().add(validateServiceDescribedBy(serviceDescribe.get(), valueServiceDescribe));
		}

		return resourceFacingService;
	}

	/**
	 * Metodo reponsavel por recuperar as informaçoes do ServiceDescribedBy
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected ServiceDescribedBy validateServiceDescribedBy(List<ServiceDescribedBy> serviceDescribedByList, String value) throws OSSBusinessException {

		ServiceDescribedBy serviceDescribedByTerminal = new ServiceDescribedBy();

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(serviceDescribedByList);

		if(Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", "RIGRANITE-001", "O tamanho da lista serviceDescribedBy eh 0");

		for (ServiceDescribedBy serviceDescribedBy : serviceDescribe.get()) {

			Optional<ServiceDescribedBy> name = Optional.ofNullable(serviceDescribedBy);

			if(name.map(ServiceDescribedBy::getName).filter(d -> d.equalsIgnoreCase(value)).isPresent()){

				for (ServiceSpecCharDescribes serviceSpecCharDescribe : serviceDescribedBy.getServiceSpecCharDescribes()) {
					
					Optional<ServiceSpecCharDescribes> resourceServiceSpecCharDescribe = Optional.ofNullable(serviceSpecCharDescribe);
					if(!resourceServiceSpecCharDescribe.map(ServiceSpecCharDescribes::getValue).filter(d -> !d.isEmpty()).isPresent())
						throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", "RIGRANITE-001", "O valor do campo serviceDescribedBy.serviceSpecCharDescribes.value eh nulo");

					serviceDescribedBy.getServiceSpecCharDescribes().clear();
					serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribe);

					serviceDescribedByTerminal = serviceDescribedBy;
					break;
				}

			}
		}

		return serviceDescribedByTerminal;
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
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				constraintViolations = validator.validateProperty(valueServiceDescribe,param);

				if (constraintViolations.size()>0)
					throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(),
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
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				if(Optional.ofNullable(valueServiceDescribe.getServiceSpecCharDescribes()).map(List::size).orElse(0) == 0)
					throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICESPECCHARDESCRIBES.getValue() +" para o name {"+param+"}");

				for (ServiceSpecCharDescribes valueServiceDescribeChar : valueServiceDescribe.getServiceSpecCharDescribes()) {

					constraintViolations = validator.validateProperty(valueServiceDescribeChar,param);

					if (constraintViolations.size()>0)
						throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(),
								"O valor do campo {"+param+"} eh nulo");
				}

			}
		}
	}
}
