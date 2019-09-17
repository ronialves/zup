package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class RetrieveMsanPotsDao extends GenericDao implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private static final String ERRO_AO_EXECUTAR_RETRIEVE_MSAN_POTS_ENTITY = "Erro ao consultar o objeto RetrieveMsanPotsEntity";
	private static final String NO_RETRIEVE_MSAN_POTS_ENTITY = "Não encontrou recurso msan RetrieveMsanPotsEntity";

	@Inject
	protected OSSLogger logger;

	public RetrieveMsanPotsEntity getMsanPots(String terminal) throws OSSBusinessException {
		
		RetrieveMsanPotsEntity result = new RetrieveMsanPotsEntity();
		
		try {
			
			TypedQuery<RetrieveMsanPotsEntity> query = getEntityManager().createNamedQuery(RetrieveMsanPotsEntity.QUERY_RESOURCE_MSAN_POTS,RetrieveMsanPotsEntity.class);
			query.setParameter(1, terminal);
		
			logIn(RetrieveMsanPotsEntity.QUERY_RESOURCE_MSAN_POTS, null, terminal);
			
			result = (RetrieveMsanPotsEntity) query.getSingleResult();

			logOut(result);
			
		} catch (NoResultException e) {
			logger.log(OSSLogger.INFO, NO_RETRIEVE_MSAN_POTS_ENTITY + ": " + e.getMessage());
		}catch (Exception e) {
			logger.log(OSSLogger.ERROR, ERRO_AO_EXECUTAR_RETRIEVE_MSAN_POTS_ENTITY + ":" + e.getMessage());
			throw new OSSBusinessException(ERRO_AO_EXECUTAR_RETRIEVE_MSAN_POTS_ENTITY, Code.RIGRANITE_001.getValue(), " - " + e.getMessage());
		}
		return result;
	}
	
	private void logIn(String namedQuery, Query query, String... value) {
		String log = getlogIn(namedQuery, query, value);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(RetrieveMsanPotsEntity result) {
		String log = new StringBuilder("Param OUT: ").append("id_conexoes_pots_msan = ").append(result.getId()).append("Lic = ")
				.append(result.getLic()).append("Terminal = ").append(result.getTerminal()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}