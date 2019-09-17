package com.tlf.oss.resourceinventory.cpe.validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ValidatorEntity {

	public void validateServiceSpecCharDescribes(ServiceDescribedBy serviceDescribedBy) throws OSSBusinessException {
		Optional<List<ServiceSpecCharDescribes>> serviceSpecCharDescribesList = Optional
				.ofNullable(serviceDescribedBy.getServiceSpecCharDescribes());

		if (!serviceSpecCharDescribesList.isPresent()) {
			throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(), 
										   FalloutCode.RICPE_001.getValue(),
										   String.format(FalloutCode.RICPE_001.getMessage(), "SERVICE_SPEC_CHAR_DESCRIBES"));
		}

		for (ServiceSpecCharDescribes scd : serviceDescribedBy.getServiceSpecCharDescribes()) {
			Optional<ServiceSpecCharDescribes> serviceSpecCharDescribes = Optional.ofNullable(scd);

			if (!serviceSpecCharDescribes.map(ServiceSpecCharDescribes::getValue).filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
											   FalloutCode.RICPE_001.getValue(),
											   String.format(FalloutCode.RICPE_001.getMessage(), "VALUE"));
			}
		}
	}

	public void validateServiceDescribedBy(CustomerFacingService customerFacingServices) throws OSSBusinessException {
		Optional<List<ServiceDescribedBy>> serviceDescribedByList = Optional
				.ofNullable(customerFacingServices.getServiceDescribedBy());

		if (!serviceDescribedByList.isPresent()) {
			throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
										   FalloutCode.RICPE_001.getValue(),
										   String.format(FalloutCode.RICPE_001.getMessage(), "SERVICE_DESCRIBED_BY"));
		}
		for (ServiceDescribedBy sdb : customerFacingServices.getServiceDescribedBy()) {
			Optional<ServiceDescribedBy> serviceDescribedBy = Optional.ofNullable(sdb);

			if (!serviceDescribedBy.map(ServiceDescribedBy::getName).filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
											   FalloutCode.RICPE_001.getValue(),
											   String.format(FalloutCode.RICPE_001.getMessage(), "NAME"));
			}

			validateServiceSpecCharDescribes(sdb);
		}
	}

	public void validateCustomerFacingServices(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {
		Optional<List<CustomerFacingService>> customerFacingServicesList = Optional
				.ofNullable(entity.getCustomerFacingService());

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<CustomerFacingService>> constraintViolations = null;

		if (!customerFacingServicesList.isPresent()) {
			throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
										   FalloutCode.RICPE_001.getValue(),
										   String.format(FalloutCode.RICPE_001.getMessage(), "CUSTOMER_FACING_SERVICE"));
		}

		for (CustomerFacingService customerFacingServices : entity.getCustomerFacingService()) {
			if (customerFacingServices.getServiceDescribedBy() != null
					&& !customerFacingServices.getServiceDescribedBy().isEmpty()) {

				validateServiceDescribedBy(customerFacingServices);

				for (String param : params) {
					constraintViolations = validator.validateProperty(customerFacingServices, param);

					if (constraintViolations.size() > 0)
						throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
													   FalloutCode.RICPE_001.getValue(),
													   String.format(FalloutCode.RICPE_001.getMessage(), param));
				}
			}
		}
	}

	public void validateResourceFacingService(ResourceInventoryEntity entity, String... params)
			throws OSSBusinessException {

		Optional<ResourceFacingService> resourceFacingService = Optional.ofNullable(entity.getResourceFacingService());
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<ResourceFacingService>> constraintViolations = null;

		if (!resourceFacingService.isPresent())
			throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
										   FalloutCode.RICPE_001.getValue(),
										   String.format(FalloutCode.RICPE_001.getMessage(), "RESOURCE_FACING_SERVICE"));

		for (String param : params) {
			constraintViolations = validator.validateProperty(resourceFacingService.get(), param);

			if (constraintViolations.size() > 0) {
				throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
											   FalloutCode.RICPE_001.getValue(),
											   String.format(FalloutCode.RICPE_001.getMessage(), param));
			}
		}
	}

	public void validateAccessDesignator(ResourceInventoryEntity entity) throws OSSBusinessException {

		String serviceId = EntityExtractor.extractServiceIdFromRfs(entity);

		if (null == serviceId || serviceId.isEmpty()) {
			throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
										   FalloutCode.RICPE_001.getValue(),
										   String.format(FalloutCode.RICPE_001.getMessage(), "Designador de Acesso", "(resourceFacingServices/serviceId)"));
		}
	}

	public void validateBroadbandDesignator(ResourceInventoryEntity entity) throws OSSBusinessException {

		String serviceId = EntityExtractor.extractServiceIdFromCfs(entity);

		if (null == serviceId || serviceId.isEmpty()) {
			throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
										   FalloutCode.RICPE_001.getValue(),
										   String.format(FalloutCode.RICPE_001.getMessage(), "Designador de Banda", "(customerFacingService/serviceId)"));
		}
	}

	public void validateVoipDesignator(ResourceInventoryEntity entity) throws OSSBusinessException {

		Optional<ResourceFacingService> rfs = EntityExtractor.extractTelephoneRfs(entity);
		OSSBusinessException exception = new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
                                            					  FalloutCode.RICPE_001.getValue(),
                                            					  String.format(FalloutCode.RICPE_001.getMessage(), "Designador de Linha Telefônica",
                                            	   														  			"(customerFacingService/resourceFacingService[category=TELEPHONE]/serviceId)"));

		if (rfs.isPresent()) {
			String serviceId = rfs.get().getServiceId();

    		if (null == serviceId || serviceId.isEmpty()) {
    			throw exception;
    		}
		} else {
			throw exception;
		}
	}

	public void validateStbDesignator(ResourceInventoryEntity entity) throws OSSBusinessException {

		String serviceId = EntityExtractor.extractServiceIdFromCfs(entity);

		if (null == serviceId || serviceId.isEmpty()) {
			throw new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
										   FalloutCode.RICPE_001.getValue(),
										   String.format(FalloutCode.RICPE_001.getMessage(), "Designador de TV", "(customerFacingService/serviceId)"));
		}
	}

	public String validateEquipmentType(ResourceInventoryEntity entity, TipoRfs rfs) throws OSSBusinessException {

		Optional<List<ServiceDescribedBy>> sdbList = EntityExtractor
				.extractSdbFromCfs(entity.getCustomerFacingService().get(0));

		Optional<ServiceDescribedBy> result = sdbList.get()
													 .stream()
													 .filter(sdb -> null != sdb.getName() && sdb.getName().equalsIgnoreCase(rfs.getEquipmentType()))
													 .findFirst();

		OSSBusinessException exception = new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
                                            					  FalloutCode.RICPE_001.getValue(),
                                            					  String.format(FalloutCode.RICPE_001.getMessage(), "Tipo do Equipamento",
                                            	   														  			"(customerFacingService/serviceDescribedBy[name=".concat(rfs.getEquipmentType()).concat("])")));

		if (result.isPresent()) {
			String value = result.get().getServiceSpecCharDescribes().get(0).getValue();

			if (null != value && !value.isEmpty()) {
				return value;
			} else {
				throw exception;
			}
		} else {
			throw exception;
		}
	}

	public void validateAccessEquipmentType(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateEquipmentType(entity, TipoRfs.ACCESS);
	}

	public void validateVoipEquipmentType(ResourceInventoryEntity entity) throws OSSBusinessException {
		String type = validateEquipmentType(entity, TipoRfs.VOIP);
		
		if (type.equalsIgnoreCase(CpeConstants.ATA)) {
			validateVoiceTotalPorts(entity);
		}
	}

	public void validateStbEquipmentType(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateEquipmentType(entity, TipoRfs.STB);
	}

	public void validateTelephoneNumber(ResourceInventoryEntity entity, RoiAction roiAction) throws OSSBusinessException {

		Optional<ResourceFacingService> rfsTelephone = EntityExtractor
				.extractTelephoneRfs(entity, roiAction);
		
		OSSBusinessException exception;
		if(null == roiAction) {
			exception = new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
						  FalloutCode.RICPE_001.getValue(),
						  String.format(FalloutCode.RICPE_001.getMessage(), "Número de Telefone",
		   														  		"(customerFacingService/" + "resourceFacingService[category=TELEPHONE]/" +
		   														  		"serviceDescribedBy[name=TELEPHONE_NUMBER]/" +
		   														  		"serviceSpecCharDescribes/value)"));
		} else {
			
			String actionType = "";
			if(RoiAction.CEASE.equals(roiAction)) {
				actionType = "antigo";
				
			} else if(RoiAction.PROVIDE.equals(roiAction)) {
				actionType = "novo";
			}
			
			exception = new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
					  FalloutCode.RICPE_001.getValue(),
					  String.format(FalloutCode.RICPE_001.getMessage(), "Número de Telefone "+ actionType,
	 														  		"(customerFacingService/" + "resourceFacingService[category=TELEPHONE]/" +
	 														  		"serviceDescribedBy[name=TELEPHONE_NUMBER && action="+ roiAction.getAction() +"]/" +
	 														  		"serviceSpecCharDescribes/value)"));
		}
		
		if (rfsTelephone.isPresent()) {
			String telephoneNumber = EntityExtractor.extractTelephoneNumber(rfsTelephone.get());

			if (null == telephoneNumber || telephoneNumber.isEmpty()) {
				throw exception;
			}
		} else {
			throw exception;
		}
	}

	private void validateSdbFromCfs(ResourceInventoryEntity entity, String sdbName, String field) throws OSSBusinessException {
		
		Optional<List<ServiceDescribedBy>> sdbList = EntityExtractor
				.extractSdbFromCfs(entity.getCustomerFacingService().get(0));

		Optional<ServiceDescribedBy> result = sdbList.get()
													 .stream()
													 .filter(sdb -> sdbName.equalsIgnoreCase(sdb.getName()))
													 .findFirst();
		
		OSSBusinessException exception = new OSSBusinessException(FalloutCode.RICPE_001.getDescription(),
																	FalloutCode.RICPE_001.getValue(),
																	String.format(FalloutCode.RICPE_001.getMessage(), field,
																			"(customerFacingService/serviceDescribedBy[name=" + sdbName + "]/serviceSpecCharDescribes/value)"));
		
		if (result.isPresent()) {
			String value = result.get().getServiceSpecCharDescribes().get(0).getValue();
			if (null == value || value.isEmpty()) {
				throw exception;
			}
		} else {
			throw exception;
		}
	}

	public void validateVoiceTotalPorts(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateSdbFromCfs(entity, CpeConstants.VOICE_TOTAL_PORTS, "Número de Portas de Voz");
	}
	
	public void validateMacaddress(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateSdbFromCfs(entity, CpeConstants.MACADDRESS, "Macaddress");
	}
	
	public void validateSerialNumber(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateSdbFromCfs(entity, CpeConstants.SERIAL_NUMBER, "Número Serial");
	}
	
	public void validateGponSerialNumber(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateSdbFromCfs(entity, CpeConstants.GPON_SERIAL_NUMBER, "Número de Serial GPON");
	}

	public void validateEquipmentModel(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateSdbFromCfs(entity, CpeConstants.EQUIPMENT_MODEL, "Modelo do Equipamento");
	}
	
	public void validateEquipmentVendor(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateSdbFromCfs(entity, CpeConstants.EQUIPMENT_VENDOR, "Fabricante do Equipamento");
	}
	
	public void validateTelephoneNumberProvide(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateTelephoneNumber(entity, RoiAction.PROVIDE);
	}
	
	public void validateTelephoneNumberCease(ResourceInventoryEntity entity) throws OSSBusinessException {
		validateTelephoneNumber(entity, RoiAction.CEASE);
	}
}
