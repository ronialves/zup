package com.tlf.oss.resourceinventory.tbs.core.validation;



import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.enums.EntityFields;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;

public class ReserveValidator extends ValidatorEntity implements ConstraintValidator<Reserve, ResourceInventoryEntity> {
	
	@Override
	public void initialize(Reserve constraintAnnotation) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			validateAdress(entity, EntityFields.STREET_CODE.getValue(), EntityFields.STREET_NR_FIRST.getValue(), EntityFields.CNL.getValue());
			validatePhysicalLink(entity, EntityFields.VOICE_PROTOCOL.getValue(), EntityFields.ACCESS_TECHNOLOGY.getValue());
			validateCabinet(entity);
			validateCabinetName(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet());
			validateSwitchesAssociated(entity, EntityFields.NAME.getValue());
			validateCustomerFacingServices(entity);
			validateServiceSpecCharDescribes(getRateCode(entity.getCustomerFacingService()));
			validateServiceId(getDesignadorBandaLarga(entity.getCustomerFacingService()));

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}
	
	private void validateServiceId(CustomerFacingService cust) throws OSSBusinessException{
			
			if (cust.getServiceId() == null || cust.getServiceDescribedBy().isEmpty()) {
				
				throw new OSSBusinessException(ExceptionInfoEnum.RITBS_001.getDescription(),
						ExceptionInfoEnum.RITBS_001.getCode(),
						String.format(ExceptionInfoEnum.RITBS_001.getMessage(), "serviceId"));
			}
			
		}
		
	
	private void validateCabinetName(Cabinet cabinet) throws OSSBusinessException{
		
		if (cabinet.getName() == null || cabinet.getName().isEmpty()) {
			
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_001.getDescription(),
					ExceptionInfoEnum.RITBS_001.getCode(),
					String.format(ExceptionInfoEnum.RITBS_001.getMessage(), "cabinet.name"));
		}
		
	}
	
	private ServiceDescribedBy getRateCode(List<CustomerFacingService> customerFacingServiceList) {

		for (CustomerFacingService cfs : customerFacingServiceList) {

			if ("BROADBAND".equalsIgnoreCase(cfs.getCategory())) {

				if(cfs.getServiceDescribedBy() != null){
					
					for (ServiceDescribedBy serviceDescribedBy : cfs.getServiceDescribedBy()) {
						
						if ("TECHNOLOGY".equalsIgnoreCase(serviceDescribedBy.getName())) {
								
							return serviceDescribedBy;
						}
					}
				}
			}
		}
		
		return new ServiceDescribedBy();
	}
	
	private CustomerFacingService getDesignadorBandaLarga(List<CustomerFacingService> customerFacingServiceList) {
		
		for (CustomerFacingService cfs : customerFacingServiceList) {
			
			if ("BROADBAND".equalsIgnoreCase(cfs.getCategory())) {
				
				return cfs;
			}
		}
		
		return new CustomerFacingService();
	}				
	
}
