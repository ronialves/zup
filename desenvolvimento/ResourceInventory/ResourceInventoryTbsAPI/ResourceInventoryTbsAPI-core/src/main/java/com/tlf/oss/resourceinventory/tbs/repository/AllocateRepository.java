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
import com.tlf.oss.resourceinventory.tbs.entity.AllocateEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.factory.GenericRepository;


/**
 * BEATRIXTWO-26 | DEMOSS-2171
 * 
 * @project Beatrix Fase 2
 * @author jannayna.c.araujo
 * @since 201709
 */
public class AllocateRepository extends GenericRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;
	
	/**
	 * Realiza chamada da procedure
	 * 
	 * @param entity
	 * @return AllocateEntity
	 * @throws OSSBusinessException
	 */
	public AllocateEntity getAllocate(AllocateEntity entity) throws OSSBusinessException {
		AllocateEntity result = new AllocateEntity();

		try {
			TypedQuery<AllocateEntity> query;
			query = getFactory().createNamedQuery("allocate", AllocateEntity.class);

			query.setParameter("P_PON", entity.getPurchaseOrderNumber());
			query.setParameter("P_RPON", entity.getRpon());
			query.setParameter("P_ACCOUNT_NBR", entity.getAccountNumber());
			query.setParameter("P_CUSTOMER_LOCATION", entity.getCustomerLocation());
			query.setParameter("P_REQUEST_TYPE", entity.getRequestType());
			query.setParameter("P_ACTIVITY_IND", entity.getActivityInd());
			query.setParameter("P_NOTE_TEXT", entity.getNoteText());
			query.setParameter("P_DESIGNADOR_ACESSO", entity.getDesignadorAcesso());
			query.setParameter("P_SWITCH", entity.getSwitchName());
			query.setParameter("P_BIT_RATE_QUANTITY_U", entity.getRateQuantityU());
			query.setParameter("P_BIT_RATE_QUANTITY_D", entity.getRateQuantityD());
			query.setParameter("P_ACTIVITY_IND_ACESSO", entity.getActivityIndAcesso());
			query.setParameter("P_DOCUMENT_NUMBER", entity.getDocumentNumber());
			query.setParameter("P_COD_RETORNO", entity.getReturnCode());
			query.setParameter("P_MSG_RETORNO", entity.getMessage());

			logIn(query);

			result = query.getSingleResult();

			logOut(result);
		} catch (QueryTimeoutException | NoResultException | NonUniqueResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_ALLOCATE no TBS", e.getMessage()));

		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(), String.format(ExceptionInfoEnum.RITBS_002.getMessage(),
							"Erro ao chamar a procedure TLF_SP_ALLOCATE no TBS", e.getMessage()));

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
		String log = getlogIn("ASAP.TLF_SP_ALLOCATE", query);
		logger.log(OSSLogger.INFO, log);
	}

	/**
	 * Gera log com o resultado da query executada
	 * @param result
	 */
	private void logOut(AllocateEntity result) {
		String log = new StringBuilder("Param OUT: ").append("P_DOCUMENT_NUMBER = ").append(result.getDocumentNumber())
				.append("P_COD_RETORNO = ").append(result.getReturnCode()).append("P_MSG_RETORNO = ")
				.append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}