package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;

public class ResourceStatusGponDao extends GenericDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected OSSLogger logger;

	public ResourceStatusGponEntity updateStatus(ResourceStatusGponEntity resourceStatusGponEntity) throws OSSBusinessException {
		ResourceStatusGponEntity result = new ResourceStatusGponEntity();
		
		try {
			Query query = getEntityManager().createNamedQuery(ResourceStatusGponEntity.ALTER_STATUS);	
			query.setParameter(ResourceStatusGponEntity.IN_P_TERMINAL, resourceStatusGponEntity.getTerminal());
			query.setParameter(ResourceStatusGponEntity.IN_P_STATUS, resourceStatusGponEntity.getStatus());
			
			logIn(query);
			
			result = (ResourceStatusGponEntity) query.getSingleResult();
			ResultTo resultTo = new ResultTo();
			resultTo.setCode(result.getReturnCode());
			resultTo.setDescription(result.getReturnMessage());
			result.setResult(resultTo);

			logOut(result);

		} catch (PersistenceException e) {
			ResultTo resultTo = new ResultTo();
			resultTo.setCode(Code.RIGRANITE_002.getValue());
			resultTo.setDescription(Code.RIGRANITE_002.getDescription());
			result.setResult(resultTo);
			result.setReturnCode(resultTo.getCode());
			result.setReturnMessage(resultTo.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro ao chamar a procedure ".concat(ReserveResourceGponEntity.PROC_NAME).concat(" no Granite"), e.getMessage()));
		} catch (Exception e) {
			ResultTo resultTo = new ResultTo();
			resultTo.setCode(Code.RIGRANITE_999.getValue());
			resultTo.setDescription(Code.RIGRANITE_999.getDescription());
			result.setResult(resultTo);
			result.setReturnCode(resultTo.getCode());
			result.setReturnMessage(resultTo.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(), Code.RIGRANITE_999.getMessage());
		}
		
		return result;
	}
	private void logIn(Query query) {
		String log = getlogIn("PRC_ALTER_STATUS", query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(ResourceStatusGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getResult().getCode()).append("p_ret_msg = ")
				.append(result.getResult().getDescription()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}