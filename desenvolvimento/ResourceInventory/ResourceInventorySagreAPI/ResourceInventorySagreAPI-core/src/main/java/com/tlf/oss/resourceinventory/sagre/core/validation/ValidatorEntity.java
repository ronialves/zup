package com.tlf.oss.resourceinventory.sagre.core.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.InvolvesCustomer;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ValidatorEntity {

	public void validateAddress(ResourceInventoryEntity entity, String... params) throws OSSBusinessException {

		Optional<BrazilianUrbanPropertyAddress> address = Optional.ofNullable(entity.getAddress());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<BrazilianUrbanPropertyAddress>> constraintViolations = null;
		
		if (!address.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "ADDRESS"));

		for (String param : params) {
			
			constraintViolations = validator.validateProperty(address.get(),param);

			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
		}
	}

	public void validatePhysicalLink(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		validateAddress(entity);

		Optional<PlacePhysicalResourceAssoc> placePhysicalResourceAssoc = Optional
				.ofNullable(entity.getAddress().getPlacePhysicalResourceAssoc());
		
		Optional<PhysicalLink> physicalLink = Optional
				.ofNullable(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink());
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<PhysicalLink>> constraintViolations = null;
		
		if (!placePhysicalResourceAssoc.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "PLACE_PHYSICAL_RESOURCE_ASSOC"));		
		
		if (!physicalLink.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "PHYSICAL_LINK"));
			
		for (String param : params) {
			
			constraintViolations = validator.validateProperty(physicalLink.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
		}
	}

	public void validateResourceFacingService(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		Optional<ResourceFacingService> resourceFacingService = Optional.ofNullable(entity.getResourceFacingService());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceFacingService>> constraintViolations = null;
		
		if (!resourceFacingService.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "RESOURCE_FACING_SERVICE"));

		for (String param : params) {
			
			constraintViolations = validator.validateProperty(resourceFacingService.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
		}
	}

	public void validateCabinet(ResourceInventoryEntity entity, String... params) throws OSSBusinessException {

		validatePhysicalLink(entity);

		Optional<Cabinet> cabinet = Optional
				.ofNullable(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Cabinet>> constraintViolations = null;
		
		if (!cabinet.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "CABINET"));

		for (String param : params) {

			constraintViolations = validator.validateProperty(cabinet.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
			
		}
	}

	public void validateSwitchesAssociated(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		validateCabinet(entity);

		Optional<SwitchesAssociated> switchesAssociated = Optional
				.ofNullable(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getSwitchesAssociated());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<SwitchesAssociated>> constraintViolations = null;
		
		if (!switchesAssociated.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "SWITCHES_ASSOCIATED"));

		for (String param : params) {
			
			constraintViolations = validator.validateProperty(switchesAssociated.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
		}
	}

	public void validateTerminalBox(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		validateCabinet(entity);

		Optional<TerminalBox> terminalBox = Optional
				.ofNullable(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getTerminalBox());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<TerminalBox>> constraintViolations = null;
		
		if (!terminalBox.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "TERMINAL_BOX"));
			
		for (String param : params) {
			
			constraintViolations = validator.validateProperty(terminalBox.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
			
		}
	}

	public void validateCustomerOrder(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		Optional<CustomerOrder> customerOrder = Optional.ofNullable(entity.getCustomerOrder());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<CustomerOrder>> constraintViolations = null;
		
		if (!customerOrder.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "CUSTOMER_ORDER"));
			
		for (String param : params) {
			
			constraintViolations = validator.validateProperty(customerOrder.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
			
		}
	}

	public void validateInvolvesCustomer(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		validateCustomerOrder(entity);
		Optional<InvolvesCustomer> involvesCustomer = Optional
				.ofNullable(entity.getCustomerOrder().getInvolvesCustomer());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<InvolvesCustomer>> constraintViolations = null;

		if (!involvesCustomer.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "INVOLVES_CUSTOMER"));
			
		for (String param : params) {
			
			constraintViolations = validator.validateProperty(involvesCustomer.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
		}
	}

	public void validateCustomerFacingServices(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<List<CustomerFacingService>> customerFacingServicesList = Optional
				.ofNullable(entity.getCustomerFacingService());
		if (!customerFacingServicesList.isPresent()) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "CUSTOMER_FACING_SERVICE"));
		}
		for (CustomerFacingService customerFacingServices : entity.getCustomerFacingService()) {
			if (customerFacingServices.getServiceDescribedBy() != null
					&& !customerFacingServices.getServiceDescribedBy().isEmpty())
				validateServiceDescribedBy(customerFacingServices);
		}
	}

	public void validatePhysicalResourceSummary(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<String> physicalResourceSummary = Optional.ofNullable(entity.getPhysicalResourceSummary());
		if (!physicalResourceSummary.isPresent()) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "PHYSICAL_RESOURCE_SUMMARY"));
		}
	}

	public void validateServiceDescribedBy(CustomerFacingService customerFacingServices)
			throws OSSBusinessException {
		Optional<List<ServiceDescribedBy>> serviceDescribedByList = Optional
				.ofNullable(customerFacingServices.getServiceDescribedBy());
		if (!serviceDescribedByList.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "SERVICE_DESCRIBED_BY"));
			
		for (ServiceDescribedBy sdb : customerFacingServices.getServiceDescribedBy()) {
			Optional<ServiceDescribedBy> serviceDescribedBy = Optional.ofNullable(sdb);
			if (!serviceDescribedBy.map(ServiceDescribedBy::getName).filter(d -> !d.isEmpty()).isPresent())
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "NAME"));
			validateServiceSpecCharDescribes(sdb);
		}
	}

	public void validateServiceSpecCharDescribes(ServiceDescribedBy serviceDescribedBy)
			throws OSSBusinessException {
		Optional<List<ServiceSpecCharDescribes>> serviceSpecCharDescribesList = Optional
				.ofNullable(serviceDescribedBy.getServiceSpecCharDescribes());
		if (!serviceSpecCharDescribesList.isPresent()) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "SERVICE_SPEC_CHAR_DESCRIBES"));
		}

		for (ServiceSpecCharDescribes scd : serviceDescribedBy.getServiceSpecCharDescribes()) {
			Optional<ServiceSpecCharDescribes> serviceSpecCharDescribes = Optional.ofNullable(scd);
			if (!serviceSpecCharDescribes.map(ServiceSpecCharDescribes::getValue).filter(d -> !d.isEmpty()).isPresent())
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "VALUE"));
		}
	}

	public void validateResourceOrder(ResourceInventoryEntity entity) throws OSSBusinessException {

		Optional<ResourceOrder> resourceOrder = Optional.ofNullable(entity.getResourceOrder());
		if (!resourceOrder.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "RESOURCE_ORDER"));
	}

	public void validateResourceOrderItem(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		validateResourceOrder(entity);
		Optional<ResourceOrderItem> resourceOrderItem = Optional
				.ofNullable(entity.getResourceOrder().getResourceOrderItem());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceOrderItem>> constraintViolations = null;
		
		if (!resourceOrderItem.isPresent())
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), "RESOURCE_ORDER_ITEM"));
		
		for (String param : params) {
			
			constraintViolations = validator.validateProperty(resourceOrderItem.get(),param);
			
			if (constraintViolations.size()>0)
				throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_001.getDescription(), ExceptionInfoEnum.RISAGRE_001.getCode(),
						String.format(ExceptionInfoEnum.RISAGRE_001.getMessage(), param));
			
		}
	}

}
