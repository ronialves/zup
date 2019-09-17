package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.AllocateResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.AllocateResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateResourceMetallicController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	@Inject
	private AllocateResourceDao allocateResourceDao;
	
	@Inject
	private ResourceStatusDao resourceStatusDao;

	@Inject
	private PathService pathService;

	/**
	 * Metodo responsavel por confirmar a reserva de Recurso
	 * @throws OSSBusinessException 
	 */
	@Transactional(rollbackOn=Exception.class)
	public void allocateResource(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		validateRequest(entity);
		
		ResourceStatusEntity resourceStatusEntity = this.chooseScenarioAndUpdatePath(entity);
		
		AllocateResourceEntity allocateResourceEntity = getAllocateResourceEntity(entity, resourceStatusEntity);
		
		AllocateResourceEntity allocateResource = allocateResourceDao.allocateResource(allocateResourceEntity);
		
		if (allocateResource.getCode() != 0) {
			throw new OSSBusinessException("Erro ao retornar o objeto ResourceInventoryConfirmReserved", Code.RIGRANITE_001.getValue(), allocateResource.getCode() + " - " + allocateResource.getDescription());
		}
	}
	
	private AllocateResourceEntity getAllocateResourceEntity(ResourceInventoryEntity entity, ResourceStatusEntity resourceStatusEntity) throws OSSBusinessException {
		AllocateResourceEntity allocateEntity = new AllocateResourceEntity();
		allocateEntity.setCnl(entity.getAddress().getCnl());
		allocateEntity.setSiglaAt(entity.getAddress().getTelephonicArea());
		allocateEntity.setRack("");
		allocateEntity.setCircPathInstId(resourceStatusEntity.getCircPathInstId());
		allocateEntity.setSpeed(getDownloadSpeed(entity));
		allocateEntity.setUnit("KB");
		allocateEntity.setProtocol(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		allocateEntity.setCustomer(getNRC(entity));
		allocateEntity.setProduct(getProduct(entity));
		return allocateEntity;
	}

	private String getProduct(ResourceInventoryEntity entity) throws OSSBusinessException {
		CustomerFacingService customerFacingService = getCustomerFacingService(entity, "BROADBAND");
		return customerFacingService.getCategory();
	}

	private String getDownloadSpeed(ResourceInventoryEntity entity) throws OSSBusinessException {
		CustomerFacingService customerFacingService = getCustomerFacingService(entity, "BROADBAND", "Downstream");
		return customerFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc=  getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}
	
	/**
	 * Metodo responsavel por fazer a busca dos paths, identificar o cenario e atualizar o estado do path
	 * @param entity
	 * @return ResourceStatusEntity
	 * @throws OSSBusinessException7
	 */
	private ResourceStatusEntity chooseScenarioAndUpdatePath(ResourceInventoryEntity entity) throws OSSBusinessException {
    	logger.log(OSSLogger.INFO, "initialized method chooseScenarioAndUpdatePath");
    	
    	RetrievePathEntity path = pathService.getPath(entity, StatusPathType.RESERVED);
    	logger.log(OSSLogger.INFO, "Path retrieved: " + path);
    	
    	ResourceStatusEntity resourceStatusEntity = new ResourceStatusEntity(path.getCircPathInstId(), StatusPathType.IN_CONFIGURATION.getValue());

    	if (StatusPathType.RESERVED.equals(path.getStatus())) {
    		updateStatus(resourceStatusEntity);
    	}
    	
    	logger.log(OSSLogger.INFO, "finalized method chooseScenarioAndUpdatePath");
    	return resourceStatusEntity;
    }

	private void updateStatus(ResourceStatusEntity resourceStatusEntity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "executing updateStatus: " + resourceStatusEntity);
		
		ResourceStatusEntity updateResourceStatusEntity = resourceStatusDao.updateStatus(resourceStatusEntity);
    	
    	if (!"0".equals(updateResourceStatusEntity.getResult().getCode())) {
    		// Erro mapeado durante a execucao da atualizacao do estado do path
			throw new OSSBusinessException("Erro ao atualizar o status do path",
					updateResourceStatusEntity.getResult().getCode(), updateResourceStatusEntity.getResult().getDescription());  
    	}
	}
	
	//Validação especifica do metalico
	private void validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<List<CustomerFacingService>> customerFacing = Optional.ofNullable(entity.getCustomerFacingService());
		
		if(!customerFacing.isPresent())
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(), "O valor do campo customerFacingService eh nulo");		
	}

}
