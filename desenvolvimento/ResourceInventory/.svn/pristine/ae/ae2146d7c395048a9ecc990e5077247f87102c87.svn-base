package com.tlf.oss.resourceinventory.granite.core.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusMsanPotsType;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.OperationService;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public abstract class ValidatorEntity {

	/**
	 * Metodo Generico responsavel por recuperar lista de customerFacingService
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

					customerFacingService.getServiceDescribedBy().add(validateServiceDescribedBy(customer.getServiceDescribedBy(),valueServiceDescribe));
				}
			}
		}

		if(null==customerFacingService.getCategory())
			throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(), String.format(Code.RIGRANITE_001.getMessage(), customerFacingCategory));

		return customerFacingService;
	}

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
						throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", Code.RIGRANITE_001.getValue(), String.format(Code.RIGRANITE_001.getMessage(), "serviceDescribedBy.serviceSpecCharDescribes.value"));

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
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(),
					"O valor do campo address eh nulo");

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(address.get(),param);

			if (constraintViolations.size()>0)
				throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(),
						String.format(Code.RIGRANITE_001.getMessage(), param));
		}

	}

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
			throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(),
					String.format(Code.RIGRANITE_001.getMessage(), "cabinet"));

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(cabinet.get(),param);

			if (constraintViolations.size()>0)
				throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(),
						String.format(Code.RIGRANITE_001.getMessage(), param));
		}

	}

	/**
	 * Metodo responsavel por validar as informações de customerFacingService
	 * informação de banda (velocidade) = BROADBAND
	 * @param entity (payload de entrada), CustomerFacingService (BROADBAND),valueList (parametros que deseja recuperar da lista) 
	 * @return
	 * @throws OSSBusinessException
	 */
	protected void validatorCustomerFacingService(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<CustomerFacingService>> constraintViolations = null;

		Optional<List<CustomerFacingService>> customerFacingServiceList = Optional.ofNullable(entity.getCustomerFacingService());

		if (!customerFacingServiceList.isPresent()) {
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_CUSTOMERFACINGSERVICE.getValue());
		}

		//Chega uma lista BROADBAND/TELEPHONE, atualmente pegamos apenas a valocidade do BROADBAND
		for (CustomerFacingService customer : customerFacingServiceList.get()) {

			//É passado um ou uma lista de parametros, para recuperar o valor
			for (String param : valueList) {

				constraintViolations = validator.validateProperty(customer,param);

				if (constraintViolations.size()>0)
					throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(),
							"O valor do campo {"+param+"} eh nulo");

			}
		}
	}

	/**
	 * Metodo reponsavel por validar as informaçoes ResourceFacingService do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorResourceFacingService(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceFacingService>> constraintViolations = null;

		Optional<ResourceFacingService> facingService = Optional.ofNullable(entity.getResourceFacingService());

		if (!facingService.isPresent()) {
			throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(), String.format(Code.RIGRANITE_001.getMessage(), "facingService"));
		}

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(facingService.get(),param);

			if (constraintViolations.size() > 0)
				throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(), String.format(Code.RIGRANITE_001.getMessage(), param));
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
			throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				constraintViolations = validator.validateProperty(valueServiceDescribe,param);

				if (constraintViolations.size()>0)
					throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(), String.format(Code.RIGRANITE_001.getMessage(), param));
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
			throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				if(Optional.ofNullable(valueServiceDescribe.getServiceSpecCharDescribes()).map(List::size).orElse(0) == 0)
					throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICESPECCHARDESCRIBES.getValue() +" para o name {"+param+"}");

				for (ServiceSpecCharDescribes valueServiceDescribeChar : valueServiceDescribe.getServiceSpecCharDescribes()) {

					constraintViolations = validator.validateProperty(valueServiceDescribeChar,param);

					if (constraintViolations.size()>0)
						throw new OSSBusinessException(Code.RIGRANITE_001.getDescription(), Code.RIGRANITE_001.getValue(),
			                    String.format(Code.RIGRANITE_001.getMessage(), param));
				}

			}
		}
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceDescribedBy do CustomerFacingService payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorCustomerFacingServiceDescribedBy(List<CustomerFacingService> entity, String... valueList) throws OSSBusinessException {


		for (CustomerFacingService customer : entity) {

			if(EntityFields.BROADBAND.getValue().equalsIgnoreCase(customer.getCategory())){	

				Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(customer.getServiceDescribedBy());

				validatorServiceDescribedBy(serviceDescribe.get(), valueList);
			}
		}
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceSpecCharDescribes do CustomerFacingService do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorCustomerFacingServiceSpecCharDescribes(List<CustomerFacingService> entity, String... valueList) throws OSSBusinessException {
		for (CustomerFacingService customer : entity) {

			if(EntityFields.BROADBAND.getValue().equalsIgnoreCase(customer.getCategory())){	
			
				Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(customer.getServiceDescribedBy());

				validatorServiceSpecCharDescribes(serviceDescribe.get(), valueList);
			}
		}
	}


	/**
	 * Metodo reponsavel por validar as informaçoes do CusotmerOrder do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException 
	 */
	protected void validatorCustomerOrder(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {

		Optional<CustomerOrder> customerOrder = Optional.ofNullable(entity.getCustomerOrder());
		if (!customerOrder.isPresent()) {
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(), "customerOrder é obrigatório."); 
		}

		for (String param : valueList) {
			if (!Operation.SALE_OFFER.getValue().equalsIgnoreCase(param) && !Operation.OFFER_EDITION.getValue().equalsIgnoreCase(param)
					&& !Operation.CHANGE_OFFER.getValue().equalsIgnoreCase(param) && !Operation.CHANGE_ADDRESS.getValue().equalsIgnoreCase(param)){
				throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(), "CustomerOrderType enviada é inválida."); 
			}
		}
	}
	/**
	 * Metodo reponsavel por validar e retornar informações para enviar ao Terus
	 * cenarios: reserva, release, deallocate e unistall
	 * Caso seja MSAN envia TRUE, caso contrario envia False
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */

	protected OperationService getOperationService(RetrieveMsanPotsEntity retrieveMsanPotsEntity) throws OSSBusinessException{

		OperationService operationService = new OperationService();

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName(StatusMsanPotsType.UPDATEPOTS.getValue());

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue(null !=retrieveMsanPotsEntity.getIdMsan() ? StatusMsanPotsType.SEND_TERUS.getValue():StatusMsanPotsType.NOT_TERUS.getValue());

		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
		operationService.getServiceDescribedBy().add(serviceDescribedBy);

		return operationService;
	}

	protected String getTechnology(ResourceInventoryEntity entity){
	
		Optional<PhysicalLink> physicalLink = Optional.ofNullable(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink());

		return physicalLink.get().getAccessTechnology();
	}

	protected String getNetworkOwnerID(ResourceInventoryEntity entity) throws OSSBusinessException {
		if(isGpon(entity)) {
			Optional<String> serviceID = Optional.ofNullable(entity.getResourceFacingService().getServiceId());
			if(serviceID.filter(d -> d.isEmpty()).isPresent()){
				throw new OSSBusinessException("Erro ao validar o objeto PathService", "RIGRANITE-001", "O valor do campo serviceId eh nulo");
			}
			else {
				return serviceID.get();
			}
		}
		else {
			ResourceFacingService rfsNrc = getResourceFacingService(entity, EntityFields.NETWORK_OWNER_ID.getValue());
			return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
		}
	}

	protected boolean isGpon(ResourceInventoryEntity entity) {

		if (CircuitTypeEnum.GPON.getValue().equalsIgnoreCase(getTechnology(entity))) {
			return true;
		}
		return false;
	}
}
