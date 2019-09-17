package com.tlf.oss.resourceinventory.granite.core.repository;

import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
@Singleton
public class RetrieveConfigUDADao extends GenericDao{

	private static final long serialVersionUID = 1L;
	@Inject
	private OSSLogger logger;
	public List<RetrieveUdaEntity>  getRetrieveUDAConfig() {

		List<RetrieveUdaEntity> populateValue = null;
		try{
			TypedQuery<RetrieveUdaEntity> q = getEntityManager().createNamedQuery("QueryUDAConfig",RetrieveUdaEntity.class);

			logIn(q);
			
			populateValue =  q.getResultList();

			logOut(populateValue);
			
		}catch(Exception e){
			logger.log(OSSLogger.ERROR,"erro no cast do ResultList:" + e.getMessage());
			populateValue = null;
		}
		return populateValue;
	}
	private void logIn(Query query) {
		String log = getlogIn("QueryUDAConfig", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(List<RetrieveUdaEntity> result) {
		String log = new StringBuilder("Param OUT: ").append("p_size = ").append(result.size()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}