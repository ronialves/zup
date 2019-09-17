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
import com.tlf.oss.resourceinventory.tbs.entity.ReserveEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.factory.GenericRepository;


public class ReserveRepository extends GenericRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;
	private static final String GVT_SP_FTNET_RESERVA_S8 = "ASAP.GVT_SP_FTNET_RESERVA_S8";

	public ReserveEntity getReserve(ReserveEntity entity)
			throws OSSBusinessException {
		ReserveEntity result = new ReserveEntity();
		
		try {
			TypedQuery<ReserveEntity> query;
			query = getFactory().createNamedQuery("reserve", ReserveEntity.class);

			query.setParameter("p_ard_otico", entity.getArdOtico());
			query.setParameter("p_ard_metalico", entity.getArdMetalico());
			query.setParameter("p_telefone", entity.getTelephone());
			query.setParameter("p_switch", entity.getSwitchName());
			query.setParameter("p_tecnologia_voz", entity.getTecVoz());
			query.setParameter("p_rate_code", entity.getRateCode());
			query.setParameter("p_designador", entity.getDesignador());
			query.setParameter("p_status", entity.getStatus());
			query.setParameter("p_msg", entity.getMessage());
			logIn(query);

			result = query.getSingleResult();

			logOut(result);
			
		} catch (NonUniqueResultException | QueryTimeoutException | NoResultException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(),
					String.format(ExceptionInfoEnum.RITBS_002.getMessage(), GVT_SP_FTNET_RESERVA_S8, e.getMessage()));
		} catch (PersistenceException e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_002.getDescription(),
					ExceptionInfoEnum.RITBS_002.getCode(),
					String.format(ExceptionInfoEnum.RITBS_002.getMessage(), GVT_SP_FTNET_RESERVA_S8, e.getMessage()));
		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RITBS_999.getDescription(),
					ExceptionInfoEnum.RITBS_999.getCode(),
					String.format(ExceptionInfoEnum.RITBS_999.getMessage(), GVT_SP_FTNET_RESERVA_S8, e.getMessage()));
		}

		return result;
	}
	
	private void logIn(Query query) {
		String log = getlogIn(GVT_SP_FTNET_RESERVA_S8, query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(ReserveEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_status = ").append(result.getStatus()).append("p_msg = ")
				.append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}