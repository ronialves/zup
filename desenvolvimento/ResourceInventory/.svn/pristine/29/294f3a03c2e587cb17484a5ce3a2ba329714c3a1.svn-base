package com.tlf.oss.resourceinventory.scqla.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.scqla.core.enums.EntityFields;

public class RetrievalValidator extends ValidatorEntity implements ConstraintValidator<Retrieval, ResourceInventoryEntity>{

	@Override
	public void initialize(Retrieval facilityRetrieval) {}

	@Override
	public boolean isValid(ResourceInventoryEntity entity, ConstraintValidatorContext context) {
		boolean isValid = true;
		context.disableDefaultConstraintViolation();
		try {
			//Valida cenario de cliente Ativo
			//Caso seja informado getResourceFacingService busca por telefone o cliente ativo
			if(null != entity.getResourceFacingService() && null !=entity.getCustomerFacingService()){
				
				if(!validatorCustomerFacingService(entity, EntityFields.CATEGORY.getValue(),EntityFields.SERVICE_ID.getValue())
						|| !validatorServiceDescribedBy(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.NAME.getValue())
						|| !validatorServiceSpecCharDescribes(entity.getResourceFacingService().getServiceDescribedBy(), EntityFields.VALUE.getValue())){
					//Caso alguma informação esteja faltando do telefone, 
					//valida o endereço, para buscar pelo mesmo
					validatorAdress(entity,EntityFields.CNL.getValue(),EntityFields.AT.getValue(),EntityFields.STREETCODE.getValue(),EntityFields.STREETNRFIRST.getValue());
				}
			}else{
				validatorAdress(entity,EntityFields.CNL.getValue(),EntityFields.AT.getValue(),EntityFields.STREETCODE.getValue(),EntityFields.STREETNRFIRST.getValue());
			}

		} catch (OSSBusinessException e) {
			context.buildConstraintViolationWithTemplate(e.getDetail()).addConstraintViolation();
			isValid = false;

		}

		return isValid;
	}

}