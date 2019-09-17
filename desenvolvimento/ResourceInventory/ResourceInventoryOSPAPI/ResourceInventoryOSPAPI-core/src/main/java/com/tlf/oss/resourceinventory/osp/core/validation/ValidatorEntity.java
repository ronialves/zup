package com.tlf.oss.resourceinventory.osp.core.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public abstract class ValidatorEntity {

	/**
	 * Metodo reponsavel por validar as informaÃ§oes do resourceFacingService
	 * 
	 * 
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected ResourceFacingService getResourceFacingService(ResourceInventoryEntity entity, String... valueList)
			throws OSSBusinessException {

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional
				.ofNullable(entity.getResourceFacingService().getServiceDescribedBy());

		if (Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", Code.RIOSP_001.getValue(),
					"O tamanho da lista resourceFacingService.serviceDescribedBy eh 0");

		for (String valueServiceDescribe : valueList) {

			resourceFacingService.getServiceDescribedBy()
					.add(getServiceDescribedBy(serviceDescribe.get(), valueServiceDescribe));
		}

		return resourceFacingService;
	}

	/**
	 * Metodo reponsavel por valdiar as informaÃ§oes do ServiceDescribedBy
	 * 
	 * 
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected ServiceDescribedBy getServiceDescribedBy(List<ServiceDescribedBy> serviceDescribedByList, String value)
			throws OSSBusinessException {

		ServiceDescribedBy serviceDescribedByTerminal = new ServiceDescribedBy();

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(serviceDescribedByList);

		if (Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", Code.RIOSP_001.getValue(),
					"O tamanho da lista serviceDescribedBy eh 0");

		for (ServiceDescribedBy serviceDescribedBy : serviceDescribe.get()) {

			Optional<ServiceDescribedBy> name = Optional.ofNullable(serviceDescribedBy);

			if (name.map(ServiceDescribedBy::getName).filter(d -> d.equalsIgnoreCase(value)).isPresent()) {

				for (ServiceSpecCharDescribes serviceSpecCharDescribe : serviceDescribedBy
						.getServiceSpecCharDescribes()) {

					Optional<ServiceSpecCharDescribes> resourceServiceSpecCharDescribe = Optional
							.ofNullable(serviceSpecCharDescribe);

					if (!resourceServiceSpecCharDescribe.map(ServiceSpecCharDescribes::getValue)
							.filter(d -> !d.isEmpty()).isPresent())
						throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", Code.RIOSP_001.getValue(),
								String.format(Code.RIOSP_001.getMessage(), "serviceDescribedBy.serviceSpecCharDescribes.value"));

					serviceDescribedBy.getServiceSpecCharDescribes().clear();
					serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribe);

					serviceDescribedByTerminal = serviceDescribedBy;
					break;
				}

			}
		}

		if (null == serviceDescribedByTerminal.getName()) {
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", Code.RIOSP_001.getValue(),
					String.format(Code.RIOSP_001.getMessage(), value));
		}

		return serviceDescribedByTerminal;
	}

	protected String getTechnology(ResourceInventoryEntity entity) {

		Optional<PhysicalLink> physicalLink = Optional
				.ofNullable(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink());

		return physicalLink.get().getAccessTechnology();
	}

	protected String getNetworkOwnerID(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc = getResourceFacingService(entity, Operation.NETWORK_OWNER_ID.getValue());
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	protected boolean isGpon(ResourceInventoryEntity entity) {

		if (CircuitTypeEnum.GPON.getValue().equalsIgnoreCase(getTechnology(entity))) {
			return true;
		}
		return false;
	}

	protected boolean isMetallic(ResourceInventoryEntity entity) {

		if (CircuitTypeEnum.METALICO.getValue().equalsIgnoreCase(getTechnology(entity))) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo reponsavel por validar as informaÃ§oes de address do payload de entrada
	 * 
	 * 
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException
	 */
	protected void validatorAdress(ResourceInventoryEntity entity, String... valueList) throws OSSBusinessException {

		Optional<BrazilianUrbanPropertyAddress> address = Optional.ofNullable(entity.getAddress());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<BrazilianUrbanPropertyAddress>> constraintViolations = null;

		if (!address.isPresent())
			throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
					String.format(Code.RIOSP_001.getMessage(), "address"));

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(address.get(), param);

			if (constraintViolations.size() > 0)
				throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
						String.format(Code.RIOSP_001.getMessage(), param));
		}

	}

	/**
	 * Metodo responsavel por validar as informações de customerFacingService
	 * informação de banda (velocidade) = BROADBAND
	 * @param entity (payload de entrada), CustomerFacingService (BROADBAND),valueList (parametros que deseja recuperar da lista) 
	 * @return
	 * @throws OSSBusinessException
	 */
	protected void validatorCustomerFacingService(ResourceInventoryEntity entity, String... valueList)
			throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<CustomerFacingService>> constraintViolations = null;

		Optional<List<CustomerFacingService>> customerFacingServiceList = Optional
				.ofNullable(entity.getCustomerFacingService());

		if (!customerFacingServiceList.isPresent()) {
			throw new OSSBusinessException(Message.ERRO_AO_VALIDAR_O_ENTITY.getValue(), Code.RIOSP_001.getValue(),
					Message.ERRO_RESOURCE_NOT_CUSTOMERFACINGSERVICE.getValue());
		}

		// Chega uma lista BROADBAND/TELEPHONE, atualmente pegamos apenas a valocidade
		// do BROADBAND
		for (CustomerFacingService customer : customerFacingServiceList.get()) {

			//É passado um ou uma lista de parametros, para recuperar o valor
			for (String param : valueList) {

				constraintViolations = validator.validateProperty(customer, param);

				if (constraintViolations.size() > 0)
					throw new OSSBusinessException(Code.RIOSP_001.getDescription(),
							Code.RIOSP_001.getValue(), String.format(Code.RIOSP_001.getMessage(), param));

			}
		}
	}

	/**
	 * Metodo reponsavel por validar as informaçoes ResourceFacingService do payload
	 * de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException
	 */
	protected void validatorResourceFacingService(ResourceInventoryEntity entity, String... valueList)
			throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceFacingService>> constraintViolations = null;

		Optional<ResourceFacingService> facingService = Optional.ofNullable(entity.getResourceFacingService());

		if (!facingService.isPresent()) {
			throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
					String.format(Code.RIOSP_001.getMessage(), "facingService"));
		}

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(facingService.get(), param);

			if (constraintViolations.size()>0)
				throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(), String.format(Code.RIOSP_001.getMessage(), param ));
		}

	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceDescriBy do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException
	 */
	protected void validatorServiceDescribedBy(List<ServiceDescribedBy> entity, String... valueList)
			throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ServiceDescribedBy>> constraintViolations = null;

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity);

		if (Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException(Code.RIOSP_001.getDescription(),
					Code.RIOSP_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				constraintViolations = validator.validateProperty(valueServiceDescribe, param);

				if (constraintViolations.size() > 0)
					throw new OSSBusinessException(Code.RIOSP_001.getDescription(),
							Code.RIOSP_001.getValue(), String.format(Code.RIOSP_001.getMessage(), param));
			}
		}
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do ServiceSpecCharDescribes do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException
	 */
	protected void validatorServiceSpecCharDescribes(List<ServiceDescribedBy> entity, String... valueList)
			throws OSSBusinessException {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ServiceSpecCharDescribes>> constraintViolations = null;

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(entity);

		if (Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0)
			throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
					Message.ERRO_RESOURCE_NOT_SERVICEDESCRIBEDBY.getValue());

		for (String param : valueList) {

			for (ServiceDescribedBy valueServiceDescribe : serviceDescribe.get()) {

				if (Optional.ofNullable(valueServiceDescribe.getServiceSpecCharDescribes()).map(List::size)
						.orElse(0) == 0)
					throw new OSSBusinessException(Code.RIOSP_001.getDescription(),
							Code.RIOSP_001.getValue(), Message.ERRO_RESOURCE_NOT_SERVICESPECCHARDESCRIBES.getValue()
									+ " para o name {" + param + "}");

				for (ServiceSpecCharDescribes valueServiceDescribeChar : valueServiceDescribe
						.getServiceSpecCharDescribes()) {

					constraintViolations = validator.validateProperty(valueServiceDescribeChar, param);

					if (constraintViolations.size() > 0)
						throw new OSSBusinessException(Code.RIOSP_001.getDescription(),
								Code.RIOSP_001.getValue(), String.format(Code.RIOSP_001.getMessage(), param));
				}

			}
		}
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do CusotmerOrder do payload de entrada
	 * @param entity
	 * @return OSSBusinessException
	 * @throws OSSBusinessException
	 */
	protected void validatorCustomerOrder(ResourceInventoryEntity entity, String... valueList)
			throws OSSBusinessException {

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<CustomerOrder>> constraintViolations = null;

		Optional<CustomerOrder> customerOrder = Optional.ofNullable(entity.getCustomerOrder());

		if (!customerOrder.isPresent()) {
			throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
					String.format(Code.RIOSP_001.getMessage(), "CustomerOrder"));
		}

		for (String param : valueList) {

			constraintViolations = validator.validateProperty(customerOrder.get(), param);

			if (constraintViolations.size() > 0) {
				throw new OSSBusinessException(Code.RIOSP_001.getDescription(), Code.RIOSP_001.getValue(),
						String.format(Code.RIOSP_001.getMessage(), "CustomerOrder"));
			}
		}

	}

	/**
	 * Metodo reponsavel por validar as informaÃ§oes do cabinet do payload de entrada
	 * 
	 * 
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected Cabinet getCabinet(ResourceInventoryEntity entity) {
		if (entity.getCabinet() != null) {
			return entity.getCabinet();
		}
		return new Cabinet();
	}

	/**
	 * Metodo reponsavel por validar as informaçoes do terminal box do payload de entrada
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected TerminalBox getTerminalBox(ResourceInventoryEntity entity) {
		if (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null) {
			return entity.getCabinet().getTerminalBox();
		}
		return new TerminalBox();
	}
}