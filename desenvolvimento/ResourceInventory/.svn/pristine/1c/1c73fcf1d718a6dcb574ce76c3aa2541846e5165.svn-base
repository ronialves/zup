package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class CancelResourceGponDao extends GenericDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;	
	
	public CancelResourceGponEntity cancelResource(CancelResourceGponEntity entity) throws OSSBusinessException  {

		CancelResourceGponEntity result = new CancelResourceGponEntity();

		try {
			Query query = getEntityManager().createNamedQuery(CancelResourceGponEntity.CANCEL_RESOURCE_GPON);
			query.setParameter(CancelResourceGponEntity.IN_P_TERMINAL, entity.getTerminal());

			logIn(query);

			result = (CancelResourceGponEntity) query.getSingleResult();

			logOut(result);

		} catch (PersistenceException e) {
			result.setCode(Code.RIGRANITE_002.getValue());
			result.setDescription(Code.RIGRANITE_002.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro ao chamar a procedure ".concat(ReserveResourceGponEntity.PROC_NAME).concat(" no Granite"), e.getMessage()));
		} catch (Exception e) {
			result.setCode(Code.RIGRANITE_999.getValue());
			result.setDescription(Code.RIGRANITE_999.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(), Code.RIGRANITE_999.getMessage());
		}
		return result;
	}

	private void logIn(Query query) {
		String log = getlogIn("PKG_RESERVE.PRC_CANCEL_RESERVE_GPON", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(CancelResourceGponEntity result) {
		String log = new StringBuilder("Param OUT: ")
				.append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription())
				.toString();
		logger.log(OSSLogger.INFO, log);
	}
}
