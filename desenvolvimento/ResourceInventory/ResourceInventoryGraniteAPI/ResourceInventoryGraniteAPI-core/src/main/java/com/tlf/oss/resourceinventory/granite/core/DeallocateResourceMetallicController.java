package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.DeallocateInternalResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.DeallocateResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.repository.ChangeSpeedDao;
import com.tlf.oss.resourceinventory.granite.core.repository.DeallocateInternalResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateResourceMetallicController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	@Inject
	public DeallocateInternalResourceDao cdao;

	@Inject
	public ChangeSpeedDao changeSpeedDao;

	@Inject
	public ResourceStatusDao resourceStatusDao;

	@Inject
	public PathService pathService;

	@Inject
	private RetrieveMsanPotsDao retrieveMsanPotsDao;

	@Inject
	private DeallocateResourceMapper mapper;

	public ResourceInventoryEntity doExecution (ResourceInventoryEntity entity) throws OSSBusinessException{

		DeallocateInternalResourceEntity deallocateEntity = deallocateResource(entity);

		entity = mapper.parseGetDeallocateResource(deallocateEntity, entity);

		return entity;
	}

	@Transactional(rollbackOn=Exception.class)
	public DeallocateInternalResourceEntity deallocateResource(ResourceInventoryEntity entity) throws OSSBusinessException {
		//Retrieve pots msan
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = retrievePotsMsan(entity);
	
		DeallocateInternalResourceEntity deallocateInternalResourceEntity = null;
	
		try{

			RetrievePathEntity path = pathService.getPath(entity, StatusPathType.IN_CONFIGURATION);
			logger.log(OSSLogger.INFO, "Path retrieved: " + path);

			if (path.isChangePort() || path.isSaleOffer()) {

				// Cancelamento da OS / Unistall
				deallocateInternalResourceEntity = getDeallocateInternalResource(entity, path);

				// Atualiza os valores da entidade unica necessarios para o bloqueio no terus		
				updatePotsMsan(entity, deallocateInternalResourceEntity, retrieveMsanPotsEntity);					

				return deallocateInternalResourceEntity;
			}

			deallocateInternalResourceEntity = changeSpeedyAndUpdateStatus(entity,path, retrieveMsanPotsEntity);

		}catch (OSSBusinessException e) {
			//Cenario que nao encontra path, tratado para continuar o fluxo sem exceção
			logger.log(OSSLogger.INFO, e.getDescription());
			deallocateInternalResourceEntity = new DeallocateInternalResourceEntity();
			
		}
		return  deallocateInternalResourceEntity ;
	}

	private RetrieveMsanPotsEntity retrievePotsMsan(ResourceInventoryEntity entity){

		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		try {
			//Recupera recurso MSAN da pots para enviar ao terus
			retrieveMsanPotsEntity =  retrieveMsanPotsDao.getMsanPots(pathService.getNetworkOwnerID(entity));

		} catch (OSSBusinessException ossBusinessException) {
			logger.log(OSSLogger.ERROR, "Erro ao obter dados para bloqueio no Terus");
			logger.log(OSSLogger.ERROR, ossBusinessException.getMessage());
		}

		return retrieveMsanPotsEntity;
	}

	public DeallocateInternalResourceEntity getDeallocateInternalResource(ResourceInventoryEntity entity, RetrievePathEntity path) throws OSSBusinessException {
		return cdao.getDeallocateInternalResource(getDeallocateResourceEntity(entity, path));
	}

	private void updatePotsMsan(final ResourceInventoryEntity entity, final DeallocateInternalResourceEntity deallocateInternalResourceEntity,
			RetrieveMsanPotsEntity retrieveMsanPotsEntity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Iniciando o processo de busca e atualização na tabela conexoes_pots_msan");

		final Cabinet cabinet = entity.getCabinet() != null ? entity.getCabinet() : new Cabinet();
		cabinet.setLic(retrieveMsanPotsEntity.getLic());
		cabinet.setIdMsan(retrieveMsanPotsEntity.getIdMsan());

		deallocateInternalResourceEntity.setCabinet(cabinet);
		deallocateInternalResourceEntity.setOperationService(getOperationService(retrieveMsanPotsEntity));
	}

	private DeallocateInternalResourceEntity changeSpeedyAndUpdateStatus(ResourceInventoryEntity entity,RetrievePathEntity path, RetrieveMsanPotsEntity retrieveMsanPotsEntity) throws OSSBusinessException {
		String newSpeed = getDownloadSpeed(entity);

		logger.log(OSSLogger.INFO, "Path retrieved: " + path);

		DeallocateInternalResourceEntity deallocateInternalResourceEntity = new DeallocateInternalResourceEntity();

		ChangeSpeedEntity changeSpeedEntity = changeSpeedDao.changeSpeed(path.getCircPathInstId(), newSpeed, "KB");

		ResourceStatusEntity resourceStatusEntity = new ResourceStatusEntity(path.getCircPathInstId(), StatusPathType.ACTIVE.getValue());

		if (changeSpeedEntity != null && Code.SUCCESS.getValue().equals(changeSpeedEntity.getCode())) {
			deallocateInternalResourceEntity.setCode(changeSpeedEntity.getCode());
			deallocateInternalResourceEntity.setDescription(changeSpeedEntity.getDescription());
			if (retrieveMsanPotsEntity.getId() != null){
				deallocateInternalResourceEntity.setIdConexoesPotsMsan(retrieveMsanPotsEntity.getId().toString());
			}else{
				deallocateInternalResourceEntity.setIdConexoesPotsMsan("");
			}
			deallocateInternalResourceEntity.setCabinet(new Cabinet());
			deallocateInternalResourceEntity.setOperationService(getOperationService(retrieveMsanPotsEntity));
			updateStatus(resourceStatusEntity);
		}else{
			throw new OSSBusinessException(changeSpeedEntity.getDescription(), Code.RIGRANITE_001.getValue(), ""+changeSpeedEntity.getCode());
		}

		return deallocateInternalResourceEntity;
	}

	private DeallocateInternalResourceEntity getDeallocateResourceEntity(ResourceInventoryEntity entity, RetrievePathEntity resourceStatusEntity) throws OSSBusinessException {
		DeallocateInternalResourceEntity deallocateEntity = new DeallocateInternalResourceEntity();
		//É verificado a operação para popular o status
		//O mesmo controller e utilizado em duas operações (Unistall e Deallocate)
		deallocateEntity.setStatus(StatusPathType.CONFIGURED.getValue());
		deallocateEntity.setCircPathInstId(resourceStatusEntity.getCircPathInstId());
		return deallocateEntity;
	}

	private String getDownloadSpeed(ResourceInventoryEntity entity) throws OSSBusinessException {
		CustomerFacingService customerFacingService = getCustomerFacingService(entity, "BROADBAND", "Downstream");
		return customerFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
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

}
