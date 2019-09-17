package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityGponEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

@Logged
public class RetrieveAvailabilityGponDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;

	public RetrieveAvailabilityGponEntity availabilityRetrieve(RetrieveAvailabilityGponEntity gponEntity) {

		RetrieveAvailabilityGponEntity result = new RetrieveAvailabilityGponEntity();

		try {
			TypedQuery<RetrieveAvailabilityGponEntity> query;
			query = getEntityManager().createNamedQuery(RetrieveAvailabilityGponEntity.RETRIEVE_AVAILABILITY_GPON,
					RetrieveAvailabilityGponEntity.class);

			query.setParameter("p_cnl", gponEntity.getCnl());
			query.setParameter("p_at", gponEntity.getAt());
			if(gponEntity.getTerminal() == null){
				query.setParameter("p_access_designator", "");
				query.setParameter("p_primary_cable", gponEntity.getPrimaryCable());	
				query.setParameter("p_primary_fiber", gponEntity.getPrimaryFiber());
			}
			else{
				query.setParameter("p_access_designator", gponEntity.getTerminal());
				query.setParameter("p_primary_cable", "");	
				query.setParameter("p_primary_fiber", "");
			}
			
			logIn(query);

			result = query.getSingleResult();

			logOut(result);
		} catch (Exception e) {
			result.setCode("10");
			result.setDescription(e.getMessage());
		}

		return result;
	}

	private void logIn(Query query) {
		String log = getlogIn("RetrieveAvailabilityGponEntity.RETRIEVE_AVAILABILITY_GPON", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(RetrieveAvailabilityGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode()).append("p_ret_msg = ")
				.append(result.getDescription()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}