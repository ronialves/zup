package com.tlf.oss.resourceinventory.granite.core.service;


import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrievePathDao;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class PathService extends ValidatorEntity {

	@Inject
	private OSSLogger logger;

	@Inject
	private RetrievePathDao retrievePathDao;
	
	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(Code.RIGRANITE_003.getValue(), String.format(Code.RIGRANITE_003.getDescription(), "Query RetrievePath"), Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	/**
	 * Consulta os paths configurados para o terminal e realiza o filtro pelo {@code StatusPathType} e cenario (OfferEdition, ChangePort e SaleOffer) 
	 * @param entity
	 * @param statusPathType
	 * @return RetrievePathEntity
	 * @throws OSSBusinessException
	 */
	public RetrievePathEntity getPath(ResourceInventoryEntity entity, StatusPathType statusPathType) throws OSSBusinessException {
		
		List<RetrievePathEntity> paths = getPaths(entity);
		RetrievePathEntity retrievePathEntity = null;
		if (null != paths && !paths.isEmpty()) {
			retrievePathEntity = paths.stream().findFirst().orElse(null);
			if(retrievePathEntity != null) {
				if (isChangePort(paths)) {
					logger.log(OSSLogger.INFO, "executing offer edition scenario and the terminal contains more than 1 path");
					logger.log(OSSLogger.INFO, "StatusPathType filter: " + statusPathType.getValue());
					
					this.falloutConfig.setErrorCode("1");
					this.falloutConfig.setErrorMessage(Message.ERRO_RESOURCE_RETRIEVE_PATH_BY_TERMINAL.getValue());
					this.falloutConfig.setDetailMessage("1".concat(";").concat(Message.ERRO_RESOURCE_RETRIEVE_PATH_BY_TERMINAL.getValue()));
					
					retrievePathEntity = paths.stream()
							.filter(p -> statusPathType.equals(p.getStatus()))
							.findFirst()
							.orElseThrow(() -> OSSExceptionFactory.getOSSBusinessException(this.falloutConfig));
					
					retrievePathEntity.setOperation(Operation.CHANGE_OFFER);
					
					return retrievePathEntity;
				}
				else {
					if(retrievePathEntity.getResourceStatus() != null && retrievePathEntity.getResourceStatus() != null && retrievePathEntity.getStatus().equals(retrievePathEntity.getResourceStatus())) {
						logger.log(OSSLogger.INFO, "there is only 1 path configured for terminal on the offer edition scenario");
						retrievePathEntity.setOperation(Operation.OFFER_EDITION);
		    		} else {
		    			retrievePathEntity.setOperation(Operation.SALE_OFFER);
		    		}
					return retrievePathEntity;
				}
			}
		}

		logger.log(OSSLogger.INFO, "sale offer scenario");
		if(paths != null){
			retrievePathEntity = paths.get(0);
			retrievePathEntity.setOperation(Operation.SALE_OFFER);
		}
		return retrievePathEntity;
	}
	
	/**
	 * Consulta os paths configurados para o terminal e realiza o filtro pelo {@code StatusPathType} e cenario (OfferEdition, ChangePort e SaleOffer) 
	 * @param entity
	 * @param statusPathType
	 * @return RetrievePathEntity
	 * @throws OSSBusinessException
	 */
	public RetrievePathEntity getPath(final ResourceInventoryEntity entity) throws OSSBusinessException {
		
		List<RetrievePathEntity> paths = getPaths(entity, isGpon(entity));
		RetrievePathEntity retrievePathEntity = null;
		
		if (null != paths && !paths.isEmpty()) {
			retrievePathEntity = paths.stream().findFirst().orElse(null);
			if(retrievePathEntity != null) {
				if (isChangePort(paths)) {
					retrievePathEntity.setOperation(Operation.CHANGE_OFFER);
					return retrievePathEntity;
				}
				else {
					if(retrievePathEntity.getResourceStatus() != null && retrievePathEntity.getResourceStatus() != null && retrievePathEntity.getStatus().equals(retrievePathEntity.getResourceStatus())) {
						logger.log(OSSLogger.INFO, "there is only 1 path configured for terminal on the offer edition scenario");
						retrievePathEntity.setOperation(Operation.OFFER_EDITION);
		    		} else {
		    			retrievePathEntity.setOperation(Operation.SALE_OFFER);
		    		}
					return retrievePathEntity;
				}
			}
		}

		logger.log(OSSLogger.INFO, "sale offer scenario");
		if(paths != null){
			retrievePathEntity = paths.get(0);
			retrievePathEntity.setOperation(Operation.SALE_OFFER);
		}
		return retrievePathEntity;    
	}
	
	public List<RetrievePathEntity> getPaths(ResourceInventoryEntity entity) throws OSSBusinessException {
		return getPaths(entity, false);
	}

	/**
	 * Metodo responsavel por obter todos os paths configurados para o terminal consultado
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	public List<RetrievePathEntity> getPaths(ResourceInventoryEntity entity, boolean isGpon) throws OSSBusinessException {

		RetrievePathEntity retrievePathEntity = new RetrievePathEntity();
		retrievePathEntity.setTerminal(getNetworkOwnerID(entity));

		logger.log(OSSLogger.INFO, "Buscando paths para o terminal ".concat(retrievePathEntity.getTerminal()));
		List<RetrievePathEntity> paths = retrievePathDao.getPaths(retrievePathEntity, isGpon);

		// Se o retorno do DAO de pesquisa dos paths configuradas para o terminal consultado for nulo ou vazio,
		// retorna excecao informando que nao ha terminal encontrado.
		if (paths == null || paths.isEmpty()) {
			logger.log(OSSLogger.INFO, "Terminal nao encontrado no inventario");
			
			this.falloutConfig.setErrorCode("1");
			this.falloutConfig.setErrorMessage(Message.ERRO_RESOURCE_RETRIEVE_PATH_BY_TERMINAL.getValue());
			this.falloutConfig.setDetailMessage("1".concat(";").concat(Message.ERRO_RESOURCE_RETRIEVE_PATH_BY_TERMINAL.getValue()));
			throw OSSExceptionFactory.getOSSBusinessException(this.falloutConfig);
			
		}

		return paths;
	}

	/**
	 * Metodo responsavel por obter o tipo do equipamento (Msan/Dslam) configurado para o terminal ativo consultado
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	public RetrievePathEntity getEquipTypeActive(ResourceInventoryEntity entity) throws OSSBusinessException {

		RetrievePathEntity retrievePathEntity = new RetrievePathEntity();
		retrievePathEntity.setTerminal(getNetworkOwnerID(entity));

		return retrievePathDao.getEquipTypeActive(retrievePathEntity);
	}

	/**
	 * Verifica se a edicao de oferta tem mudanca de paths
	 * @param retrievePathEntityList
	 * @return
	 */
	private boolean isChangePort(List<RetrievePathEntity> retrievePathEntityList) {
		return retrievePathEntityList != null && retrievePathEntityList.size() > 1;
	}

	public String getNetworkOwnerID(ResourceInventoryEntity entity) throws OSSBusinessException {
		if(isGpon(entity)) {
			Optional<String> serviceID = Optional.ofNullable(entity.getResourceFacingService().getServiceId());
			if(serviceID.filter(d -> d.isEmpty()).isPresent()){
				throw new OSSBusinessException("Erro ao validar o objeto PathService", "RIGRANITE-001", "O valor do campo serviceId eh nulo");
			}
			else {
				return serviceID.get();
			}
		}
		else {
			ResourceFacingService rfs = getResourceFacingService(entity, "NetworkOwnerID");
			return rfs.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
		}
	}
}