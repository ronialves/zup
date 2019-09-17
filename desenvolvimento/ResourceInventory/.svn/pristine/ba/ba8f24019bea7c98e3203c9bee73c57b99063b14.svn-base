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
import com.tlf.oss.resourceinventory.sagre.entity.ReserveEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.factory.GenericRepository;;

/**
 * BEATRIXTWO-22 | DEMOSS-2155
 * 
 * @project Beatrix Fase 2
 * @author renan.n.Oliveira
 * @since 201709
 */

public class ReserveRepository extends GenericRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;
	
	private static final String GVT_SP_SOA_CRIA_RS_CTRL = "SAGREMAN.GVT_SP_SOA_CRIA_RS_CTRL";

	public ReserveEntity getReserve(ReserveEntity entity)
			throws OSSBusinessException {
		ReserveEntity result = new ReserveEntity();
		
		try {
			TypedQuery<ReserveEntity> query;
			query = getFactory().createNamedQuery("reserve", ReserveEntity.class);

			query.setParameter("p_in_cnl", entity.getCnl());
			query.setParameter("p_in_tec_acesso", entity.getTecAcesso());
			query.setParameter("p_in_tec_voz", entity.getTecVoz());
			query.setParameter("p_in_id_acesso", entity.getIdAcesso());
			query.setParameter("p_in_sos", entity.getInSos());
			query.setParameter("p_in_street_code", entity.getStreetCode());
			query.setParameter("p_in_lote", entity.getInLote());
			query.setParameter("p_in_ident_equip1", entity.getIdentEquip1());
			query.setParameter("p_in_ident_equip2", entity.getIdentEquip2());
			query.setParameter("p_in_ident_equip3", entity.getIdentEquip3());
			query.setParameter("p_in_tipo_reserva", entity.getTipoReserva());
			query.setParameter("p_in_origem", entity.getInOrigem());
			query.setParameter("p_out_aux1", entity.getAux1());
			query.setParameter("p_out_cod", entity.getCod());
			query.setParameter("p_out_msg", entity.getMsg());
			query.setParameter("p_in_tipo_documento", entity.getTipoDocumento());
			query.setParameter("p_in_classe_servico", entity.getClasseServico());

			logIn(query);

			result = query.getSingleResult();

			logOut(result);
			
		} catch (NonUniqueResultException | QueryTimeoutException | NoResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
					ExceptionInfoEnum.RISAGRE_002.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(), GVT_SP_SOA_CRIA_RS_CTRL, e.getMessage()));
		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_002.getDescription(),
					ExceptionInfoEnum.RISAGRE_002.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_002.getMessage(), GVT_SP_SOA_CRIA_RS_CTRL, e.getMessage()));
		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_999.getDescription(),
					ExceptionInfoEnum.RISAGRE_999.getCode(),
					String.format(ExceptionInfoEnum.RISAGRE_999.getMessage(), GVT_SP_SOA_CRIA_RS_CTRL, e.getMessage()));
		}

		return result;
	}
	
	private void logIn(Query query) {
		String log = getlogIn(GVT_SP_SOA_CRIA_RS_CTRL, query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(ReserveEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_out_cod = ").append(result.getCod()).append("p_out_msg = ")
				.append(result.getMsg()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}