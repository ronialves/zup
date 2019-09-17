package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class CancelResourceDao extends GenericDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;	
	public CancelResourceEntity cancelResource(CancelResourceEntity entity) throws OSSBusinessException {		
		CancelResourceEntity result = new CancelResourceEntity();
	
		try {
			
			Query query = getEntityManager().createNamedQuery(CancelResourceEntity.CANCEL_RESOURCE);
			query.setParameter(CancelResourceEntity.IN_P_CIRC_PATH_INST_ID, entity.getCircPathInstId());
		
			logIn(query);
			
			result = (CancelResourceEntity) query.getSingleResult();

			logOut(result);
			
		} catch (Exception e) {
			result.getResult().setCode("10");
			result.getResult().setDescription(e.getCause().getMessage());
			logger.log(OSSLogger.ERROR,"Error:" +e.getMessage());
			throw new OSSBusinessException(Message.ERRO_RESOURCE_RELEASEDAO.getValue(), Code.RIGRANITE_001.getValue(),
					e.getMessage());
		}
		
		return result;
	}
	private void logIn(Query query) {
		String log = getlogIn("PKG_RESERVE.PRC_CANCEL_RESERVE_RESOURCE", query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(CancelResourceEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}