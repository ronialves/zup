package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.CancelReserveResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ChangeSpeedDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
@Logged
public class CancelReservedMetallicController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CancelResourceDao crdao;
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	private ResourceStatusDao resourceStatusDao;
	
	@Inject
	private ChangeSpeedDao changeSpeedDao;
	
	@Inject
	private RetrieveMsanPotsDao retrieveMsanPotsDao;
	
	@Inject
	private PathService pathService;
	
	@Inject
	private CancelReserveResourceMapper mapper;
	
	public ResourceInventoryEntity doExecution (ResourceInventoryEntity entity) throws OSSBusinessException{

		CancelResourceEntity cancelEntity = cancelResource(entity);	

		entity = mapper.parseGetPhysicalCancelReserveResource(cancelEntity, entity);

		return entity;
	}

	/**
	 * Metodo responsavel por fazer a busca dos paths, identificar o cenario e cancelar o estado do path
	 * @param entity
	 * @return ResourceStatusEntity
	 * @throws OSSBusinessException
	 */
	@Transactional(rollbackOn=Exception.class)
	public CancelResourceEntity cancelResource(ResourceInventoryEntity entity) throws OSSBusinessException{
		logger.log(OSSLogger.INFO, "initialized method cancelResource");

		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();

		//Recupera recurso MSAN da pots para enviar ao terus
		retrieveMsanPotsEntity =  retrieveMsanPotsDao.getMsanPots(pathService.getNetworkOwnerID(entity));

		RetrievePathEntity path = pathService.getPath(entity, StatusPathType.RESERVED);
		logger.log(OSSLogger.INFO, "Path retrieved: " + path);

		if (path.getStatus().equals(StatusPathType.RESERVED)) {

			// Cancela a reserva
			CancelResourceEntity cancelResourceEntity = crdao.cancelResource(getCancelInternalResourceEntity(path, retrieveMsanPotsEntity));

			// Atualiza os valores da entidade unica necessarios para o bloqueio no terus		
			updatePotsMsan(entity, cancelResourceEntity, retrieveMsanPotsEntity);

			return cancelResourceEntity;
		}
		return changeSpeedAndUpdateStatus(entity, path, retrieveMsanPotsEntity);
	}

	private CancelResourceEntity changeSpeedAndUpdateStatus(ResourceInventoryEntity entity, RetrievePathEntity path, RetrieveMsanPotsEntity retrieveMsanPotsEntity) throws OSSBusinessException {

		CancelResourceEntity cancelResourceEntity = new CancelResourceEntity();

		ChangeSpeedEntity changeSpeedEntity = changeSpeedDao.changeSpeed(path.getCircPathInstId(), getDownloadSpeed(entity), "KB");
		if (!"0".equals(changeSpeedEntity.getCode())) {
			throw new OSSBusinessException(changeSpeedEntity.getDescription(), Code.RIGRANITE_001.getValue(), 
					changeSpeedEntity.getCode());
		}

		entity.getResourceFacingService().setStatus(StatusPathType.ACTIVE.getValue());
		ResourceStatusEntity resourceStatusEntity = resourceStatusDao.updateStatus(getResourceStatusEntity(entity, path));

		if (!"0".equals(resourceStatusEntity.getResult().getCode())) {
			throw new OSSBusinessException(resourceStatusEntity.getResult().getCode() , Code.RIGRANITE_001.getValue(), 
					resourceStatusEntity.getResult().getDescription());
		}

		cancelResourceEntity.setCode(resourceStatusEntity.getReturnCode());
		cancelResourceEntity.setDescription(resourceStatusEntity.getReturnMessage());
		cancelResourceEntity.setResult(resourceStatusEntity.getResult());

		if (retrieveMsanPotsEntity.getId() != null){
			cancelResourceEntity.setIdConexoesPotsMsan(retrieveMsanPotsEntity.getId().toString());
		}else{
			cancelResourceEntity.setIdConexoesPotsMsan("");
		}

		cancelResourceEntity.setCabinet(new Cabinet());
		cancelResourceEntity.setOperationService(getOperationService(retrieveMsanPotsEntity));
		return cancelResourceEntity;
	}

	/**
	 * Metodo responsavel por construir o objeto {@link ResourceStatusEntity} com o ID da porta para atualizacao
	 * @param entity
	 * @param path
	 * @return
	 * @throws OSSBusinessException
	 */
	private ResourceStatusEntity getResourceStatusEntity(ResourceInventoryEntity entity, RetrievePathEntity path) throws OSSBusinessException {
		ResourceStatusEntity updateEntity = new ResourceStatusEntity();
		updateEntity.setStatus(entity.getResourceFacingService().getStatus());
		updateEntity.setCircPathInstId(path.getCircPathInstId());
		return updateEntity;
	}

	private void updatePotsMsan(final ResourceInventoryEntity entity, final CancelResourceEntity cancelResourceEntity,
			RetrieveMsanPotsEntity retrieveMsanPotsFreeEntity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Iniciando o processo de busca e atualização na tabela conexoes_pots_msan");

			final Cabinet cabinet = entity.getCabinet() != null ? entity.getCabinet() : new Cabinet();
			cabinet.setLic(retrieveMsanPotsFreeEntity.getLic());
			cabinet.setIdMsan(retrieveMsanPotsFreeEntity.getIdMsan());

			cancelResourceEntity.setCabinet(cabinet);
			cancelResourceEntity.setOperationService(getOperationService(retrieveMsanPotsFreeEntity));
	}
	

	/**
	 * Metodo responsavel por obter a velocidade informada no request
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	private String getDownloadSpeed(ResourceInventoryEntity entity) throws OSSBusinessException {
		CustomerFacingService customerFacingService = getCustomerFacingService(entity, "BROADBAND", "Downstream");
		return customerFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	private CancelResourceEntity getCancelInternalResourceEntity(RetrievePathEntity path, RetrieveMsanPotsEntity retrieveMsanPotsEntity) throws OSSBusinessException {
		CancelResourceEntity cancelEntity = new CancelResourceEntity();
		cancelEntity.setCircPathInstId(String.valueOf(path.getCircPathInstId()));
		if(null != retrieveMsanPotsEntity.getId()){
			cancelEntity.setIdConexoesPotsMsan(retrieveMsanPotsEntity.getId().toString());
		}
		return cancelEntity;
	}

}