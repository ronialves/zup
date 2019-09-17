package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMaxSpeedResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
@Logged
public class ReserveResourceDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;

	public ReserveResourceEntity reserveResource(ReserveResourceEntity entity) throws OSSBusinessException {
		ReserveResourceEntity result = new ReserveResourceEntity();
		//GenericDao GenericDao = new GenericDao();

		try {
			Query query = getEntityManager().createNamedQuery("reserveResource");
			query.setParameter("p_cnl", entity.getCnl());
			query.setParameter("p_at", entity.getTelephonicArea());
			query.setParameter("p_cabinete", entity.getLocker());
			query.setParameter("p_terminal", entity.getTerminal());
			query.setParameter("p_speed", entity.getSpeed());
			query.setParameter("p_unit_speed", ""); // se nao passar nada ele pega
													// a velocidade atual se
													// passar KB ele mutiplica
													// por 1024
			query.setParameter("p_voice_protocol", entity.getProtocol());
			query.setParameter("p_access_type", null);
			query.setParameter("p_service_type", null);
			query.setParameter("p_readonly", "FALSE");
			
			logIn("PKG_RESERVE.PRC_RESERVE_RESOURCE", query);

			result = (ReserveResourceEntity) query.getSingleResult();

			logOut(result);

		} catch (NoResultException e) {
			result.setCode("0");
		} catch (Exception e) {
			result.setCode("10");
			result.setDescription(e.getCause().getMessage());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(result.getDescription(), "RIGRANITE-001", ""+result.getCode());
		}
		return result;
	}

	private void logOut(ReserveResourceEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription()).append("p_tipo_recurso = ")
				.append(result.getResourceType()).append("p_port_id = ")
				.append(result.getListCode()).toString();

		logger.log(OSSLogger.INFO, log);
	}
	
	// recover speed max
	public RetrieveMaxSpeedResourceEntity speedMax(String terminal) {

		RetrieveMaxSpeedResourceEntity result = new RetrieveMaxSpeedResourceEntity();
		BigDecimal speedMax = null;
		try {
			Query query = getEntityManager()
					.createNamedQuery("QueryMaxSpeedResourceCurrent");
			query.setParameter(1, terminal);
			
			speedMax = (BigDecimal)query.getSingleResult();
			result.setSpeed(speedMax.toString());
			result.setCode(0);

		} catch (Exception e) {
			result.setCode(10);
			result.setDescription(e.getMessage());
		}
		return result;
	}

	private void logIn(String logIn, Query query) {
		String log = getlogIn(logIn, query);
		logger.log(OSSLogger.INFO, log);
	}
}
