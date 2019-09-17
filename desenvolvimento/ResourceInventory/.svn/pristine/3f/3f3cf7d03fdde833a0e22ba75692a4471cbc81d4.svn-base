package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class ChangeSpeedGponDao extends GenericDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected OSSLogger logger;
	
	public ChangeSpeedGponEntity reserveOfferEdition (final ChangeSpeedGponEntity entity) throws OSSBusinessException {

		ChangeSpeedGponEntity result = new ChangeSpeedGponEntity();

		try {
			final TypedQuery<ChangeSpeedGponEntity> query = getEntityManager().createNamedQuery(ChangeSpeedGponEntity.NAMED_PROC_QUERY, ChangeSpeedGponEntity.class);
			query.setParameter(ChangeSpeedGponEntity.SERVICE_ID, entity.getServiceId());
			query.setParameter(ChangeSpeedGponEntity.SERVICE_CODE, entity.getServiceCode());

			logIn(ChangeSpeedGponEntity.PRC_NAME, query);

			result = query.getSingleResult();
			
			logOut(result);
			
		} 
		catch (PersistenceException e) {
			result.setCode(Code.RIGRANITE_002.getValue());
			result.setDescription(Code.RIGRANITE_002.getDescription());
			logger.log(OSSLogger.ERROR,"ERRO: " + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), 
							String.format(Code.RIGRANITE_002.getMessage(), "Erro ao chamar a procedure ".concat(ChangeSpeedGponEntity.PRC_NAME).concat(" no granite"),e.getMessage()));
		}
		
		catch (Exception e) {
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
	
	private void logOut(final ChangeSpeedGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}