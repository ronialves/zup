package com.tlf.oss.resourceinventory.tbs.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.tbs.entity.UninstallEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.factory.GenericRepository;

/**
 * BEATRIXTWO-966 | DEMOSS-3082
 * 
 * @author jose.fabio.d.souza
 * @project Beatrix Fase 2
 * @since 201804
 *
 */
public class UninstallRepository extends GenericRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;
	
	/**
	 * Realiza chamada da procedure
	 * 
	 * @param entity
	 * @return UninstallEntity
	 */
	public UninstallEntity getUninstall(UninstallEntity entity) throws OSSBusinessException {
		UninstallEntity result = new UninstallEntity();
		
		try{
			TypedQuery<UninstallEntity> query;

			query = getFactory().createNamedQuery("uninstall", UninstallEntity.class);

			query.setParameter("p_pon", entity.getPurchaseOrderNumber());
			query.setParameter("p_rpon", entity.getRpon());
			query.setParameter("p_designador_acesso", entity.getDesignadorAcesso());
			query.setParameter("p_activity_ind", entity.getActivityInd());
			query.setParameter("p_document_number", entity.getDocumentNumber());
			query.setParameter("p_cod_retorno", entity.getReturnCode());
			query.setParameter("p_msg_retorno", entity.getMessage());
			
			logIn(query);
			
			result = query.getSingleResult();

			logOut(result);
			
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_UNINSTALL no TBS", e.getMessage()));

		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_UNINSTALL no TBS", e.getMessage()));

		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_999.getDescription(),
					ExceptionInfoEnum.RITBS_999.getCode(), e.getMessage());

		}
		
		return result;
	}	
	
	/**
	 * Gera log com a entrada da query
	 * @param result
	 */
	private void logIn(Query query) {
		String log = getlogIn("ASAP.TLF_SP_UNINSTALL", query);
		logger.log(OSSLogger.INFO, log);
	}

	/**
	 * Gera log com o resultado da query executada
	 * @param result
	 */
	private void logOut(UninstallEntity result) {
		String log = new StringBuilder("Param OUT: ").append("P_PON = ").append(result.getPurchaseOrderNumber()).append("P_RPON = ")
				.append(result.getRpon()).append("P_DESIGNADOR_ACESSO = ").append(result.getDesignadorAcesso()).append("P_ACTIVITY_IND = ")
				.append(result.getActivityInd()).append("P_DOCUMENT_NUMBER = ").append(result.getDocumentNumber()).append("P_COD_RETORNO = ")
				.append(result.getReturnCode()).append("P_MSG_RETORNO = ").append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}