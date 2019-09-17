package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class ChangeSpeedDao extends GenericDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected OSSLogger logger;

	public ChangeSpeedEntity changeSpeed(Long circPathInstId, String speed, String unitSpeed) throws OSSBusinessException {

		ChangeSpeedEntity result = new ChangeSpeedEntity();

		try {
			TypedQuery<ChangeSpeedEntity> query = getEntityManager().createNamedQuery(ChangeSpeedEntity.NAMED_PROC_QUERY, ChangeSpeedEntity.class);
			query.setParameter(ChangeSpeedEntity.P_CIRC_PATH_INST_ID, circPathInstId);
			query.setParameter(ChangeSpeedEntity.P_SPEED, speed);
			query.setParameter(ChangeSpeedEntity.P_UNIT_SPEED, unitSpeed);

			logIn(ChangeSpeedEntity.PRC_NAME, query);

			result = query.getSingleResult();
			
			logOut(result);

		} catch (Exception e) {
			result.setCode("10");
			result.setDescription(e.getCause().getMessage());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(result.getDescription(), Code.RIGRANITE_001.getValue(),
					"" + result.getCode());
			
		}
			
		return result;
	}

	private void logIn(String logIn, Query query) {
		String log = getlogIn(logIn, query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(ChangeSpeedEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription()).toString();

		logger.log(OSSLogger.INFO, log);
	}	
}
