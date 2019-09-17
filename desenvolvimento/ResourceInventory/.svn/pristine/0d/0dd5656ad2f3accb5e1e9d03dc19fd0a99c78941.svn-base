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
import com.tlf.oss.resourceinventory.sagre.entity.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.factory.GenericRepository;

/**
 * BEATRIXTWO-441 | DEMOSS-2279
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@SuppressWarnings("serial")
public class FacilityResourceRepository extends GenericRepository implements Serializable {

	@Inject
	OSSLogger logger;
	
	private static final String GVT_SP_SOA_FAC_CTRL = "SAGREMAN.GVT_SP_SOA_FAC_CTRL";

	/**
	 * Realiza chamada da procedure SAGREMAN.GVT_SP_SOA_FAC_CTRL
	 * 
	 * @param entity
	 * @return RetrieveFacilityEntity
	 * @throws OSSBusinessException
	 */
	public RetrieveFacilityEntity retrieveFacility(RetrieveFacilityEntity entity) throws OSSBusinessException {
		RetrieveFacilityEntity result = new RetrieveFacilityEntity();
		getFactory().getEntityManagerFactory().getCache().evict(RetrieveFacilityEntity.class);
		try {
			TypedQuery<RetrieveFacilityEntity> query;

			query = getFactory().createNamedQuery("facilityRetrievalResource", RetrieveFacilityEntity.class);

			query.setParameter("p_in_cnl", entity.getCnl());
			query.setParameter("p_in_tec_acesso", entity.getAccessTechnology());
			query.setParameter("p_in_tec_voz", entity.getVoiceTechnology());
			query.setParameter("p_in_id_acesso", entity.getAccessId());
			query.setParameter("p_in_tipo", entity.getType());
			query.setParameter("p_out_armario", entity.getCabinet());
			query.setParameter("p_out_caixa", entity.getTerminalBox());
			query.setParameter("p_out_equip_gen_1", entity.getEquipGen1());
			query.setParameter("p_out_equip_gen_2", entity.getEquipGen2());
			query.setParameter("p_out_equip_gen_3", entity.getEquipGen3());
			query.setParameter("p_out_nota", entity.getNote());
			query.setParameter("p_out_cod", entity.getResultCode());
			query.setParameter("p_out_msg", entity.getMessage());

			logIn(query);
			
			result = query.getSingleResult();

			logOut(result);

		} catch (NonUniqueResultException | QueryTimeoutException | NoResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
					ExceptionInfoEnum.RISAGRE_002.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(), GVT_SP_SOA_FAC_CTRL, e.getMessage()));
		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
					ExceptionInfoEnum.RISAGRE_002.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(), GVT_SP_SOA_FAC_CTRL, e.getMessage()));
		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_999.getDescription(),
					ExceptionInfoEnum.RISAGRE_999.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_999.getMessage(), GVT_SP_SOA_FAC_CTRL, e.getMessage()));
		}

		return result;
	}
	
	/**
	 * Gera log com o conteudo da query a ser executada
	 * @param query
	 */
	private void logIn(Query query) {
		String log = getlogIn(GVT_SP_SOA_FAC_CTRL, query);
		logger.log(OSSLogger.INFO, log);
	}

	/**
	 * Gera log com o resultado da query executada
	 * 
	 * @param result
	 */
	private void logOut(RetrieveFacilityEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_out_nota = ").append(result.getNote()).append("p_out_cod = ")
				.append(result.getResultCode()).append("p_out_msg = ").append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}