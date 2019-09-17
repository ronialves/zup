package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.AvailabilityRetrieveActiveMsanDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class RetrieveAvailabilityActiveMsanDslamDao extends GenericDao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	public  Collection<AvailabilityRetrieveActiveMsanDslamEntity> getAvailabilityActiveMsanDslan(String terminal) throws OSSBusinessException {

		Collection<AvailabilityRetrieveActiveMsanDslamEntity> result = null;	
		try{
			TypedQuery <AvailabilityRetrieveActiveMsanDslamEntity> query;
			query= getEntityManager().createNamedQuery("QueryFindByActiveMsanDslam", AvailabilityRetrieveActiveMsanDslamEntity.class)
					.setParameter(1, terminal)
					.setParameter(2, terminal)
					.setParameter(3, terminal);
			
			result =  query.getResultList();

		}catch(Exception e){
			logger.log(OSSLogger.ERROR,"erro no cast do ResultList:" + e.getMessage());
			throw new OSSBusinessException("Erro ao executar o retrieve Availability Dslam", Code.RIGRANITE_001.getValue(), e.getMessage());
		}
		return result;
	}
}