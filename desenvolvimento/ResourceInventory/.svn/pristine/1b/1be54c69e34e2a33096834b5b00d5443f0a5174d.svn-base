package com.tlf.oss.resourceinventory.sagre.repository;

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
import com.tlf.oss.resourceinventory.sagre.entity.ReleaseResourceEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.factory.GenericRepository;

/**
 * BEATRIXTWO-935 | DEMOSS-2995
 * @project Beatrix Fase 2
 * @author renan.n.oliveira
 * @since 201803
 */
public class ReleaseRepository extends GenericRepository implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	OSSLogger logger;
	
	private static final String GVT_SP_SOA_LIBERA_FAC_CTRL = "SAGREMAN.GVT_SP_SOA_LIBERA_FAC_CTRL";

	/**
	 * Realiza chamada da procedure
	 * 
	 * @param entity
	 * @return ReleaseResourceEntity
	 * @throws OSSBusinessException
	 */
	public ReleaseResourceEntity release(ReleaseResourceEntity entity) throws OSSBusinessException {
		ReleaseResourceEntity result = new ReleaseResourceEntity();
		try {
			TypedQuery<ReleaseResourceEntity> query;

			query = getFactory().createNamedQuery("ReleaseResource", ReleaseResourceEntity.class);

			query.setParameter("p_in_cnl", entity.getCnl());
			query.setParameter("p_in_tec_acesso", entity.getAccessTechnology());
			query.setParameter("p_in_tec_voz", entity.getVoiceTechnology());
			query.setParameter("p_in_id_acesso", entity.getAccessId());
			query.setParameter("p_in_tipo", entity.getType());
			query.setParameter("p_out_cod", entity.getResultCode());
			query.setParameter("p_out_msg", entity.getMessage());
			
			logIn(query);
			
			result = query.getSingleResult();

			logOut(result);

		} catch (NonUniqueResultException | QueryTimeoutException | NoResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
					ExceptionInfoEnum.RISAGRE_002.getCode(), String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(),
							GVT_SP_SOA_LIBERA_FAC_CTRL, e.getMessage()));
		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
					ExceptionInfoEnum.RISAGRE_002.getCode(), String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(),
							GVT_SP_SOA_LIBERA_FAC_CTRL, e.getMessage()));
		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_999.getDescription(),
					ExceptionInfoEnum.RISAGRE_999.getCode(), String.format(ExceptionInfoEnum.RISAGRE_999.getMessage(),
							GVT_SP_SOA_LIBERA_FAC_CTRL, e.getMessage()));
		}

		return result;
	}
	
	/**
	 * Gera log com o conteudo da query a ser executada
	 * @param query
	 */
	private void logIn(Query query) {
		String log = getlogIn(GVT_SP_SOA_LIBERA_FAC_CTRL, query);
		logger.log(OSSLogger.INFO, log);
	}

	/**
	 * Gera log com o resultado da query executada
	 * @param result
	 */
	private void logOut(ReleaseResourceEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_out_cod = ").append(result.getResultCode()).append("p_out_msg = ")
				.append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}