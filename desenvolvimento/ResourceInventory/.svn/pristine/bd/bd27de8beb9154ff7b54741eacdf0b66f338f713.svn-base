package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelChangeSpeedGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class CancelChangeSpeedGponDao extends GenericDao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected OSSLogger logger;
	
	public CancelChangeSpeedGponEntity cancelResource (final CancelChangeSpeedGponEntity entity) throws OSSBusinessException {

		CancelChangeSpeedGponEntity result = new CancelChangeSpeedGponEntity();

		try {
			final TypedQuery<CancelChangeSpeedGponEntity> query = getEntityManager().createNamedQuery(CancelChangeSpeedGponEntity.NAMED_PROC_QUERY, CancelChangeSpeedGponEntity.class);
			query.setParameter(CancelChangeSpeedGponEntity.SERVICE_ID, entity.getServiceId());
			query.setParameter(CancelChangeSpeedGponEntity.SERVICE_CODE, entity.getServiceCode());

			logIn(CancelChangeSpeedGponEntity.PRC_NAME, query);

			result = query.getSingleResult();
			
			logOut(result);

		} catch (PersistenceException e) {
			result.setCode(Code.RIGRANITE_002.getValue());
			result.setDescription(Code.RIGRANITE_002.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro ao chamar a procedure ".concat(ReserveResourceGponEntity.PROC_NAME).concat(" no Granite"), e.getMessage()));
		} catch (Exception e) {
			result.setCode(Code.RIGRANITE_999.getValue());
			result.setDescription(e.getMessage());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(), e.getMessage());
		}
		return result;
	}
	
	private void logIn(final String logIn, final Query query) {
		final String log = getlogIn(logIn, query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(final CancelChangeSpeedGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription()).toString();

		logger.log(OSSLogger.INFO, log);
	}
}
