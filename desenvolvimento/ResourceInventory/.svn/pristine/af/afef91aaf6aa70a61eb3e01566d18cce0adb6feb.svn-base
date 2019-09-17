package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class RetrievePathDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	protected OSSLogger logger;

	public List<RetrievePathEntity> getPaths(RetrievePathEntity entity, boolean isGpon) throws OSSBusinessException {
		List<RetrievePathEntity> paths;
		try {
			String query = isGpon ? RetrievePathEntity.QUERY_RESOURCE_PATHS_GPON : RetrievePathEntity.QUERY_RESOURCE_PATHS;

			TypedQuery<RetrievePathEntity> q = getEntityManager()
					.createNamedQuery(query, RetrievePathEntity.class)
					.setParameter(1, entity.getTerminal());
			
			logIn(query, null, entity.getTerminal());
			
			paths = q.getResultList();
			
			logOut(paths);
		
		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			logger.log(OSSLogger.ERROR, "Error:" + Message.ERRO_RESOURCE_RETRIEVE_PATH_ENTITYDAO.getValue());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro ao executar a Query RetrievePath ", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			logger.log(OSSLogger.ERROR, "Error:" + Message.ERRO_RESOURCE_RETRIEVE_PATH_ENTITYDAO.getValue());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(), Code.RIGRANITE_999.getMessage());
		}
		return paths;
	}

	public RetrievePathEntity getEquipTypeActive(RetrievePathEntity entity) throws OSSBusinessException {
		RetrievePathEntity path = new RetrievePathEntity();
		try {
			Query q = getEntityManager()
					.createNamedQuery(RetrievePathEntity.QUERY_EQUIP_TYPE)
					.setParameter(1, entity.getTerminal());
			
			logIn(RetrievePathEntity.QUERY_EQUIP_TYPE, null,entity.getTerminal());
			
			// Se o retorno do path para o terminal consultado for nulo ou vazio,
			// retorna excecao informando que nao ha equipamento encontrado para o terminal ativo .
			String equipType = (String) q.getSingleResult();
			
			path.setType(equipType);
			
			logOut(path);
		} catch (PersistenceException e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro ao executar a Query RetrievePath ", e.getMessage()));
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(), Code.RIGRANITE_999.getMessage());
		}
		return path;
	}

	private void logIn(String namedQuery, Query query, String... param) {
		String log = getlogIn(namedQuery, query, param);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(List<RetrievePathEntity> paths) {
		String log = new StringBuilder("Param OUT: ").append("size = ").append(paths.size()).toString();
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(RetrievePathEntity path) {
		String log = new StringBuilder("Param OUT: ").append("Type = ").append(path.getType()).toString();
		logger.log(OSSLogger.INFO, log);
	}	
}