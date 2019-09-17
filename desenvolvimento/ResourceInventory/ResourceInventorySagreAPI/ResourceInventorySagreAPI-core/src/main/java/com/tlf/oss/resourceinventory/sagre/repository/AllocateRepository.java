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
import com.tlf.oss.resourceinventory.sagre.entity.AllocateExternalResourceEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.factory.GenericRepository;

/**
 * BEATRIXTWO-25 | DEMOSS-2164
 * 
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201709
 *
 */
public class AllocateRepository extends GenericRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	OSSLogger logger;
	
	private static final String GVT_SP_SOA_DS_CTRL = "SAGREMAN.GVT_SP_SOA_DS_CTRL";

	/**
	 * Realiza chamada da procedure
	 * 
	 * @param entity
	 * @return AllocateExternalResourceEntity
	 * @throws OSSBusinessException
	 */
	public AllocateExternalResourceEntity allocate(AllocateExternalResourceEntity entity) throws OSSBusinessException {
		AllocateExternalResourceEntity result = new AllocateExternalResourceEntity();
		try {
			TypedQuery<AllocateExternalResourceEntity> query;

			query = getFactory().createNamedQuery("allocateExternalResource", AllocateExternalResourceEntity.class);

			query.setParameter("p_in_cnl", entity.getCnl());
			query.setParameter("p_in_tec_acesso_origem", entity.getAccessTechnology());
			query.setParameter("p_in_tec_voz_origem", entity.getVoiceTechnology());
			query.setParameter("p_in_id_acesso_origem", entity.getAccessId());
			query.setParameter("p_in_tec_acesso_destino", entity.getTargetAccessTechnology());
			query.setParameter("p_in_tec_voz_destino", entity.getTargetVoiceTechnology());
			query.setParameter("p_in_id_acesso_destino", entity.getTargetAccessId());
			query.setParameter("p_in_sos", entity.getSos());
			query.setParameter("p_in_ident_equip1", entity.getIdentEquip1());
			query.setParameter("p_in_ident_equip2", entity.getIdentEquip2());
			query.setParameter("p_in_ident_equip3", entity.getIdentEquip3());
			query.setParameter("p_in_street_code", entity.getStreetCode());
			query.setParameter("p_in_lote", entity.getLote());
			query.setParameter("p_in_pon", entity.getPon());
			query.setParameter("p_in_rpon", entity.getRpon());
			query.setParameter("p_in_origem", entity.getOriginSystem());
			query.setParameter("p_out_nota", entity.getNote());
			query.setParameter("p_out_cod", entity.getResultCode());
			query.setParameter("p_out_msg", entity.getMessage());
			query.setParameter("p_in_tipo_documento", entity.getDocumentType());
			query.setParameter("p_in_classe_servico", entity.getServiceClass());
			query.setParameter("p_in_tipo_ordem", entity.getOrderType());

			logIn(query);
			
			result = query.getSingleResult();

			logOut(result);

		} catch (NonUniqueResultException | QueryTimeoutException | NoResultException e) {
		    throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
		            ExceptionInfoEnum.RISAGRE_002.getCode(), String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(),
		                    GVT_SP_SOA_DS_CTRL, e.getMessage()));
		} catch (PersistenceException e) {
		    throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
		            ExceptionInfoEnum.RISAGRE_002.getCode(), String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(),
		                    GVT_SP_SOA_DS_CTRL, e.getMessage()));
		} catch (Exception e) {
		    throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_999.getDescription(),
		            ExceptionInfoEnum.RISAGRE_999.getCode(), String.format(ExceptionInfoEnum.RISAGRE_999.getMessage(),
		                    GVT_SP_SOA_DS_CTRL, e.getMessage()));
		}

		return result;
	}
	
	/**
	 * Gera log com o conteudo da query a ser executada
	 * @param query
	 */
	private void logIn(Query query) {
		String log = getlogIn(GVT_SP_SOA_DS_CTRL, query);
		logger.log(OSSLogger.INFO, log);
	}

	/**
	 * Gera log com o resultado da query executada
	 * @param result
	 */
	private void logOut(AllocateExternalResourceEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_out_nota = ").append(result.getNote()).append("p_out_cod = ")
				.append(result.getResultCode()).append("p_out_msg = ").append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}