package com.tlf.oss.resourceinventory.tbs.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.tbs.core.validation.Allocate;
import com.tlf.oss.resourceinventory.tbs.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.entity.AllocateEntity;
import com.tlf.oss.resourceinventory.tbs.enums.AccessEnum;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.enums.OrderEnum;
import com.tlf.oss.resourceinventory.tbs.enums.RequestTypeEnum;
import com.tlf.oss.resourceinventory.tbs.repository.AllocateRepository;

/**
 * BEATRIXTWO-26 | DEMOSS-2171
 * BEATFAS-102 | DEMOSS-3331
 * 
 * @project Beatrix Fase 2
 * @author jannayna.c.araujo
 * @author bruna.barbosa
 * @since 201709
 */
public class AllocateController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int SUCCESS = 0;
	
	@Inject 
	private AllocateRepository allocateRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RITBS_003.getCode(),
			String.format(ExceptionInfoEnum.RITBS_003.getDescription(), "TLF_SP_ALLOCATE"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	/**
	 * Retorna atraves do AllocateEntity (preenchido com ResourceInventoryEntity), o ResourceInventoryEntity enriquecido
	 * 
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getAllocate(@Allocate ResourceInventoryEntity entity)
			throws OSSBusinessException {
		AllocateEntity allocate = new AllocateEntity();
		
		allocate.setPurchaseOrderNumber(entity.getCustomerOrder().getPurchaseOrderNumber());
		allocate.setAccountNumber(entity.getCustomerOrder().getInvolvesCustomer().getId());
		allocate.setCustomerLocation(entity.getAddress().getId());
		
		
		allocate.setRequestType(RequestTypeEnum.BROADBAND.getValue());
		allocate.setActivityInd(OrderEnum.NEW.getValue());
		allocate.setNoteText(entity.getPhysicalResourceSummary());
		allocate.setDesignadorAcesso(entity.getResourceFacingService().getServiceId());
		allocate.setSwitchName(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getSwitchesAssociated().getName());
		allocate.setActivityIndAcesso(AccessEnum.NEW.getValue());
		
		for(CustomerFacingService customerFacingService: entity.getCustomerFacingService()){
			if(customerFacingService != null && customerFacingService.getServiceDescribedBy() != null){
				for(ServiceDescribedBy serviceDescribedBy: customerFacingService.getServiceDescribedBy()){
					if(serviceDescribedBy != null 
							&& serviceDescribedBy.getServiceSpecCharDescribes() != null 
							&& !serviceDescribedBy.getServiceSpecCharDescribes().isEmpty() 
							&& serviceDescribedBy.getServiceSpecCharDescribes().get(0).getValue() != null){
						if("RPON".equals(serviceDescribedBy.getName())){
							allocate.setRpon(serviceDescribedBy.getServiceSpecCharDescribes().get(0).getValue());
						} else if("Downstream".equals(serviceDescribedBy.getName())){
							allocate.setRateQuantityD(serviceDescribedBy.getServiceSpecCharDescribes().get(0).getValue());
						} else if("Upstream".equals(serviceDescribedBy.getName())){
							allocate.setRateQuantityU(serviceDescribedBy.getServiceSpecCharDescribes().get(0).getValue());
						}
						
					}
				}
			}			
		}
		
		return getResourceInventoryEntity(allocateRepository.getAllocate(allocate), entity);
	}

	/**
	 * Enriquece ResourceInventoryEntity atraves da execucao do AllocateDAO.getAllocate
	 * 
	 * @param allocate
	 * @param entity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(AllocateEntity allocate, ResourceInventoryEntity entity)
			throws OSSBusinessException {
		
		if(allocate.getDocumentNumber() != null){
			ResourceOrder resourceOrder = new ResourceOrder();
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setId(allocate.getDocumentNumber().toString());
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);	
			entity.setCabinet(null);
		}	
		
		Integer errorCode = allocate.getReturnCode();
		
		if (SUCCESS != errorCode) {
		    falloutConfig.setErrorCode(String.valueOf(errorCode));
		    falloutConfig.setErrorMessage(allocate.getMessage());
			falloutConfig.setDetailMessage(errorCode + "; " + allocate.getMessage());
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}

		return entity;
	}

}
