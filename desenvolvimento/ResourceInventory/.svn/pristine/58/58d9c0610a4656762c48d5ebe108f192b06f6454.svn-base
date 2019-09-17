package com.tlf.oss.resourceinventory.granite.core;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.DeallocateInternalResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.DeallocateInternalResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class InstallMetallicController extends ValidatorEntity {
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private ResourceStatusDao resourceStatusDao;
	
	@Inject
	public DeallocateInternalResourceDao cdao;
	
	@Inject
	private PathService pathService;
	
	public ResourceInventoryEntity doExecution(ResourceInventoryEntity entity) throws OSSBusinessException{
		
		ResourceStatusEntity statusEntity = updateStatus(entity);
		
		return getResourceInventoryEntity(statusEntity, entity);
	}
	
	
	@Transactional(rollbackOn=Exception.class)
	public ResourceStatusEntity updateStatus(ResourceInventoryEntity entity) throws OSSBusinessException {		
		
		//busca por um path Ativo.
		RetrievePathEntity path = this.chooseScenarioAndRetrievePath(entity, StatusPathType.ACTIVE);
		
		//valida se o cenário do inventário é de path único com status ativo e retorna ok.
		if (path != null && !path.isChangePort() &&  StatusPathType.ACTIVE.equals(path.getStatus())) {
		
			return  getResourceStatusEntity(path, StatusPathType.ACTIVE.getValue());
		}
		
		//valida se o path ativo foi encontrado no cenário de troca de porta.
		if (path != null && path.isChangePort()) {
			//deleta o path ativo.
			deallocatePathActive(path);		
			//recupera o path em configuração.
			path = this.chooseScenarioAndRetrievePath(entity, StatusPathType.IN_CONFIGURATION);
		}
		
		if ( path != null) {
			// ativa um path "EM CONFIGURACAO" - cenário de Venda e Edição de Oferta
			return resourceStatusDao.updateStatus(getResourceStatusEntity(path, StatusPathType.ACTIVE.getValue()));
		}else {
			// se não encontrar nenhum path ativo ou em configuração para o terminal
			throw new OSSBusinessException("Path não encontrado para o terminal "+getNetworkOwnerID(entity), Code.RIGRANITE_001.getValue(),"Nenhum Path Encontrado no status 'ATIVO' ou 'EM CONFIGURACAO");
			
		}				
	}
	
	private ResourceStatusEntity getResourceStatusEntity(RetrievePathEntity path, String statusPathType) {
		ResourceStatusEntity updateEntity = new ResourceStatusEntity();
		updateEntity.setStatus(statusPathType);
		updateEntity.setCircPathInstId(path.getCircPathInstId());
		return updateEntity;
	}
	
	/**
	 * Metodo responsavel por fazer a busca dos paths e identificar o cenario
	 * @param entity
	 * @return RetrievePathEntity
	 * @throws OSSBusinessException
	 */
	private RetrievePathEntity chooseScenarioAndRetrievePath(ResourceInventoryEntity entity, StatusPathType statusPathType ) throws OSSBusinessException {
    	logger.log(OSSLogger.INFO, "initialized method chooseScenarioAndRetrievePath");
    	
    	RetrievePathEntity path = pathService.getPath(entity, statusPathType);
    	logger.log(OSSLogger.INFO, "Path retrieved: " + path);
    	
    	return path;
    }
	
	public void deallocatePathActive(RetrievePathEntity pathActive) throws OSSBusinessException {
		
		DeallocateInternalResourceEntity deallocateEntity = new DeallocateInternalResourceEntity();
		deallocateEntity.setStatus(pathActive.getStatus().toString());
		deallocateEntity.setCircPathInstId(pathActive.getCircPathInstId());
		
		DeallocateInternalResourceEntity deallocate = cdao.getDeallocateInternalResource(deallocateEntity);

		if (!"0".equals(deallocate.getCode())) {
			// gerar exceção em caso de erro ao excluir PATH ativo para cenário
			// de MV com Troca de Porta
			throw new OSSBusinessException("Erro excluir PATH ativo para cenário de MV com Troca de Porta",
					Code.RIGRANITE_001.getValue(), deallocate.getResult().getCode().toString()
							+ " - " + deallocate.getResult().getDescription());
		}

	}
	
	private ResourceInventoryEntity getResourceInventoryEntity(ResourceStatusEntity entityStatus, ResourceInventoryEntity entity) throws OSSBusinessException {
		if (Message.SUCCESS.getValue().equalsIgnoreCase(entityStatus.getResult().getCode()))
			return entity;
		else{
			throw new OSSBusinessException("Erro ao modificar Status da Instalacao para: ATIVO", Code.RIGRANITE_001.getValue(), entityStatus.getResult().getCode().toString() + " - "
					+ entityStatus.getResult().getDescription());
		}
	}	
}