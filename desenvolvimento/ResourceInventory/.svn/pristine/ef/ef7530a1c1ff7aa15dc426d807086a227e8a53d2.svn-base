package com.tlf.oss.resourceinventory.scqla.core.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.scqla.core.enums.Code;
import com.tlf.oss.resourceinventory.scqla.core.enums.Message;

public abstract class ValidatorEntity {

	/**
	 * Metodo Generico responsavel por validar a lista de customerFacingService
	 * para reserva, a unica informação necessaria no customerFacing e as
	 * informação de banda (velocidade) = BROADBAND
	 * @param entity (payload de entrada), CustomerFacingService (BROADBAND),valueList (parametros que deseja recuperar da lista) 
	 * @return
	 * @throws OSSBusinessException
	 */
	protected CustomerFacingService getCustomerFacingService(ResourceInventoryEntity entity, String customerFacingCategory, String... valueList) throws OSSBusinessException {

		CustomerFacingService customerFacingService = new CustomerFacingService();

		Optional<List<CustomerFacingService>> customerFacingServiceList = Optional.ofNullable(entity.getCustomerFacingService());

		//Chega uma lista BROADBAND/TELEPHONE, atualmente pegamos apenas a valocidade do BROADBAND
		for (CustomerFacingService customer : customerFacingServiceList.get()) {

			if(customer.getCategory().equalsIgnoreCase(customerFacingCategory)){
				customerFacingService.setCategory(customer.getCategory());
				customerFacingService.setServiceId(customer.getServiceId());

				//É passado um ou uma lista de parametros, para recuperar o valor
				for (String valueServiceDescribe : valueList) {

					customerFacingService.getServiceDescribedBy().add(getServiceDescribedBy(customer.getServiceDescribedBy(),valueServiceDescribe));
				}
			}
		}

		if(null==customerFacingService.getCategory()
				||null==customerFacingService.getServiceId() || customerFacingService.getServiceId().isEmpty())
			throw new OSSBusinessException(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(), Code.RI_SCQLA_002.getValue(), "O valor do campo customerfacingService {"+customerFacingCategory+"} eh nulo");

		return customerFacingService;
	}

	/**
	 * Metodo reponsavel por valdiar as informacoes do resourceFacingService
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected ResourceFacingService getResourceFacingService(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {

		ResourceFacingService ResourceFacingService = new ResourceFacingService();

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity.getResourceFacingService().getServiceDescribedBy());

		for (String valueServiceDescribe : valueList) {

			ResourceFacingService.getServiceDescribedBy().add(getServiceDescribedBy(serviceDescribe.get(), valueServiceDescribe));
		}

		return ResourceFacingService;
	}

	/**
	 * Metodo reponsavel por valdiar as informacoes do serviceDescribedByList
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected ServiceDescribedBy getServiceDescribedBy(List<ServiceDescribedBy> serviceDescribedByList, String value) throws OSSBusinessException {

		ServiceDescribedBy serviceDescribedByTerminal = new ServiceDescribedBy();

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(serviceDescribedByList);

		if(Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", "RISCQLA-001", "O tamanho da lista serviceDescribedBy eh 0");

		for (ServiceDescribedBy serviceDescribedBy : serviceDescribe.get()) {

			Optional<ServiceDescribedBy> name = Optional.ofNullable(serviceDescribedBy);

			if(name.map(ServiceDescribedBy::getName).filter(d -> d.equalsIgnoreCase(value)).isPresent()){

				for (ServiceSpecCharDescribes serviceSpecCharDescribe : serviceDescribedBy.getServiceSpecCharDescribes()) {

					Optional<ServiceSpecCharDescribes> resourceServiceSpecCharDescribe = Optional.ofNullable(serviceSpecCharDescribe);

					if(!resourceServiceSpecCharDescribe.map(ServiceSpecCharDescribes::getValue).filter(d -> !d.isEmpty()).isPresent())
						throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", "RISCQLA-001", "O valor do campo serviceDescribedBy.serviceSpecCharDescribes.value eh nulo");

					serviceDescribedBy.getServiceSpecCharDescribes().clear();
					serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribe);

					serviceDescribedByTerminal = serviceDescribedBy;
					break;
				}

			}
		}

		if(null==serviceDescribedByTerminal.getName()){
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", "RISCQLA-001", "O valor do campo serviceDescribedBy.name {"+value+"} eh nulo");
		}

		return serviceDescribedByTerminal;
	}

	/**
	 * Metodo reponsavel por validar as informaçoes de address do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorAdress(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {

		Optional<BrazilianUrbanPropertyAddress> address = Optional.ofNullable(entity.getAddress());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<BrazilianUrbanPropertyAddress>> constraintViolations = null;

		if (!address.isPresent())
			throw new OSSBusinessException(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(), Code.RI_SCQLA_001.getValue(),
					"O valor do campo address eh nulo");

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(address.get(),param);

			if (constraintViolations.size()>0)
				throw new OSSBusinessException(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(), Code.RI_SCQLA_001.getValue(),
						"O valor do campo {"+param+"} eh nulo");
		}

	}

	/**
	 * Metodo responsavel por validar as informações de customerFacingService
	 * informação de banda (velocidade) = BROADBAND
	 * @param entity (payload de entrada), CustomerFacingService (BROADBAND),valueList (parametros que deseja recuperar da lista) 
	 * @return
	 * @throws OSSBusinessException
	 */
	protected boolean validatorCustomerFacingService(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<CustomerFacingService>> constraintViolations = null;

		Optional<List<CustomerFacingService>> customerFacingServiceList = Optional.ofNullable(entity.getCustomerFacingService());

		if (!customerFacingServiceList.isPresent()) {
			return false;
		}

		//Chega uma lista BROADBAND/TELEPHONE, atualmente pegamos apenas a valocidade do BROADBAND
		for (CustomerFacingService customer : customerFacingServiceList.get()) {

			//É passado um ou uma lista de parametros, para recuperar o valor
			for (String param : valueList) {

				constraintViolations = validator.validateProperty(customer,param);

				if (constraintViolations.size()>0)
					return false;

			}
		}
		return true;
	}

	/**
	 * Metodo reponsavel por validar as informaçoes ResourceFacingService do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected boolean validatorResourceFacingService(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceFacingService>> constraintViolations = null;

		Optional<ResourceFacingService> facingService = Optional.ofNullable(entity.getResourceFacingService());

		if (!facingService.isPresent()) {
			return false;
		}

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(facingService.get(),param);

			if (constraintViolations.size()>0)
				return false;
		}
		
		return true;

	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceDescriBy do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected boolean validatorServiceDescribedBy(List<ServiceDescribedBy> entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ServiceDescribedBy>> constraintViolations = null;

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity);

		if(Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			return false;

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				constraintViolations = validator.validateProperty(valueServiceDescribe,param);

				if (constraintViolations.size()>0)
					return false;
			}
		}
		return true;
	}


	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceSpecCharDescribes do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected boolean validatorServiceSpecCharDescribes(List<ServiceDescribedBy> entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ServiceSpecCharDescribes>> constraintViolations = null;

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity);

		if(Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			return false;

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				if(Optional.ofNullable(valueServiceDescribe.getServiceSpecCharDescribes()).map(List::size).orElse(0) == 0)
					return false;

				for (ServiceSpecCharDescribes valueServiceDescribeChar : valueServiceDescribe.getServiceSpecCharDescribes()) {

					constraintViolations = validator.validateProperty(valueServiceDescribeChar,param);

					if (constraintViolations.size()>0)
						return false;
				}

			}
		}
		return true;
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceDescribedBy do CustomerFacingService payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected boolean validatorCustomerFacingServiceDescribedBy(List<CustomerFacingService> entity, String... valueList) throws OSSBusinessException {

		for (CustomerFacingService customer : entity) {

			Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(customer.getServiceDescribedBy());

			return validatorServiceDescribedBy(serviceDescribe.get(), valueList);

		}
		return false;
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceSpecCharDescribes do CustomerFacingService do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected boolean validatorCustomerFacingServiceSpecCharDescribes(List<CustomerFacingService> entity, String... valueList) throws OSSBusinessException {
		for (CustomerFacingService customer : entity) {

			Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(customer.getServiceDescribedBy());

			return validatorServiceSpecCharDescribes(serviceDescribe.get(), valueList);
		}
		return false;
	}


}
