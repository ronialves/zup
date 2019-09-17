package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class ReserveResourceGponDao extends GenericDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected OSSLogger logger;
	
	public ReserveResourceGponEntity reserveResourceGpon(ReserveResourceGponEntity entity) throws OSSBusinessException {
		ReserveResourceGponEntity result = new ReserveResourceGponEntity();
		
		try{
			Query query = getEntityManager().createNamedQuery(ReserveResourceGponEntity.QUERY_NAME);
			query.setParameter("p_cnl", entity.getCnl());
			query.setParameter("p_at", entity.getSiglaAt());
			query.setParameter("p_primary_cable",entity.getPrimaryCable());
			query.setParameter("p_primary_fiber", entity.getPrimaryFiber());
			query.setParameter("p_access_designator", entity.getAccessDesignator());
			query.setParameter("p_service_code", entity.getServiceCode());
			
			logIn(ReserveResourceGponEntity.PROC_NAME, query);
			
			result = (ReserveResourceGponEntity) query.getSingleResult();

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
	
	private void logIn(String logIn, Query query) {
		String log = getlogIn(logIn, query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(ReserveResourceGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}