package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class ResourceStatusDao extends GenericDao implements Serializable {
	
	private static final long serialVersionUID = 5755647139112652854L;
	
	@Inject
	protected OSSLogger logger;	
	
	public ResourceStatusEntity updateStatus(ResourceStatusEntity resourceStatusEntity) throws OSSBusinessException {
		ResourceStatusEntity result = new ResourceStatusEntity();
		
		try {
			Query query = getEntityManager().createNamedQuery(ResourceStatusEntity.CONFIRM_INTERNAL);
			query.setParameter(ResourceStatusEntity.IN_P_CIRC_PATH_INST_ID, resourceStatusEntity.getCircPathInstId());	
			query.setParameter(ResourceStatusEntity.IN_P_STATUS, resourceStatusEntity.getStatus());
			
			logIn(query);
			
			result = (ResourceStatusEntity) query.getSingleResult();
			
			result.getResult().setCode(result.getReturnCode());
			result.getResult().setDescription(result.getReturnMessage());

			logOut(result);

		} catch (Exception e) {
			result.getResult().setCode("10");
			result.getResult().setDescription(e.getMessage());
			logger.log(OSSLogger.ERROR, "Error: " + e.getMessage());
			throw new OSSBusinessException(Message.ERRO_RESOURCE_UPDATE_STATUSDAO.getValue(),
					result.getResult().getCode(),
					result.getResult().getDescription());
		}
		
		return result;
	}
	private void logIn(Query query) {
		String log = getlogIn("PKG_PATH.PRC_ALTER_STATUS", query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(ResourceStatusEntity result) {
		String log = new StringBuilder("Param OUT: ")
				.append("p_ret_code = ").append(result.getResult().getCode())
				.append("p_ret_msg = ").append(result.getResult().getDescription())
				.toString();
		logger.log(OSSLogger.INFO, log);
	}
}