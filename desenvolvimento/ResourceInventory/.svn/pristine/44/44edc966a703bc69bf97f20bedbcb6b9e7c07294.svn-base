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
import com.tlf.oss.resourceinventory.tbs.entity.DeallocateEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.factory.GenericRepository;

/**
 * BEATRIXTWO-934 | DEMOSS-2998
 * 
 * @project Beatrix Fase 2
 * @author jose.fabio.d.souza
 * @since 201803
 */

public class DeallocateRepository extends GenericRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;
	
	/**
	 * Realiza chamada da procedure
	 * 
	 * @param entity
	 * @return DeallocateEntity
	 * @throws OSSBusinessException
	 */
	public DeallocateEntity deallocate(DeallocateEntity entity) throws OSSBusinessException {
		DeallocateEntity result = new DeallocateEntity();

		try {
			TypedQuery<DeallocateEntity> query;
			query = getFactory().createNamedQuery("deallocate", DeallocateEntity.class);

			query.setParameter("P_PON", entity.getPurchaseOrderNumber());
			query.setParameter("P_DESIGNADOR_ACESSO", entity.getDesignadorAcesso());
			query.setParameter("P_COD_RETORNO", entity.getReturnCode());
			query.setParameter("P_MSG_RETORNO", entity.getReturnMsg());

			logIn(query);

			result = query.getSingleResult();

			logOut(result);
		} catch(QueryTimeoutException | NoResultException | NonUniqueResultException e) {
		    throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(), ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(), "Erro ao chamar a procedure TLF_SP_DEALLOCATE no TBS", e.getMessage()));
	         
		} catch(PersistenceException e) {
		    throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(), ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(), "Erro ao chamar a procedure TLF_SP_DEALLOCATE no TBS", e.getMessage()));
		 
		} catch(Exception e){       
		    throw new OSSBusinessException(ExceptionInfoEnum.RITBS_999.getDescription(), ExceptionInfoEnum.RITBS_999.getCode(), e.getMessage());
		 
		}

		return result;
	}
	
	/**
	 * Gera log com a entrada da query
	 * @param result
	 */
	private void logIn(Query query) {
		String log = getlogIn("ASAP.TLF_SP_DEALLOCATE", query);
		logger.log(OSSLogger.INFO, log);
	}

	/**
	 * Gera log com o resultado da query executada
	 * @param result
	 */
	private void logOut(DeallocateEntity result) {
		String log = new StringBuilder("Param OUT: ").append("P_PON = ").append(result.getPurchaseOrderNumber()).append("P_DESIGNADOR_ACESSO = ")
				.append(result.getDesignadorAcesso()).append("P_COD_RETORNO = ").append(result.getReturnCode()).append("P_MSG_RETORNO = ")
				.append(result.getReturnMsg()).toString();
		logger.log(OSSLogger.INFO, log);
	}	
}