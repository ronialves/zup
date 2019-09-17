package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.DeallocateInternalResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMaxSpeedResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class DeallocateInternalResourceDao extends GenericDao
		implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	protected OSSLogger logger;	
	
	public DeallocateInternalResourceEntity getDeallocateInternalResource(DeallocateInternalResourceEntity entity) {
		DeallocateInternalResourceEntity result = new DeallocateInternalResourceEntity();

		logger.log(OSSLogger.INFO, "Param IN: TERMINAL:" + entity.getCircPathInstId()+" /n STATUS:"+ entity.getStatus());
		
		try {
			TypedQuery<DeallocateInternalResourceEntity> query;
			query = getEntityManager().createNamedQuery("deallocateInternalResource", DeallocateInternalResourceEntity.class);

			query.setParameter("p_circ_path_inst_id", entity.getCircPathInstId());
			query.setParameter("p_status", entity.getStatus());
			
			logIn(query);
			
			result = query.getSingleResult();
			
			logOut(result);

		} catch (Exception e) {
			result.getResult().setCode("10");
			result.getResult().setDescription(e.getMessage());
		}

		return result;
	}
	private void logIn(Query query) {
		String log = getlogIn("PKG_ALLOCATE.PRC_DEALLOCATE_PATH", query);
		logger.log(OSSLogger.INFO, log);
	}
	
	private void logOut(DeallocateInternalResourceEntity result) {
		String log = new StringBuilder("Param OUT: ")
				.append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription())
				.toString();
		logger.log(OSSLogger.INFO, log);
	}
	
	public RetrieveMaxSpeedResourceEntity speedMax(String terminal) {

		RetrieveMaxSpeedResourceEntity result = new RetrieveMaxSpeedResourceEntity();
		BigDecimal speedMax = null;
		try {
			Query query = getEntityManager().createNamedQuery("QueryMaxSpeedResourceCurrent");
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
}
