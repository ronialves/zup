package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveAcessInformationDslamDao extends GenericDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public  List<RetrieveAccessResourceInformationDslamEntity> getAcessInformationResourceDSLAM(ResourceInventoryEntity getAccessResourceInformationIn) {

		logger.log(OSSLogger.INFO, "Param IN: CNL:" +getAccessResourceInformationIn.getAddress().getCnl()+" /n AT:"+getAccessResourceInformationIn.getAddress().getTelephonicArea());

		RetrieveAccessResourceInformationDslamEntity retrieveAccessResourceInformationDslamEntity = new RetrieveAccessResourceInformationDslamEntity();
		List<RetrieveAccessResourceInformationDslamEntity> result;	
		
		try {
			TypedQuery<RetrieveAccessResourceInformationDslamEntity> q = getEntityManager()
					.createNamedQuery("QueryAcessInformationResourceDSLAM", RetrieveAccessResourceInformationDslamEntity.class)
					.setParameter(1,getAccessResourceInformationIn.getAddress().getCnl())
					.setParameter(2,getAccessResourceInformationIn.getAddress().getTelephonicArea());

			logIn(q);

			result =  q.getResultList();

			if (!result.isEmpty()) { 
				result.stream().forEach(p -> {
					p.setAccessTecnology("METALICA");
					p.getResult().setCode("0");
				});
			} else {
				retrieveAccessResourceInformationDslamEntity.getResult().setCode("10");
				retrieveAccessResourceInformationDslamEntity.getResult().setDescription("not found getAcess dslam");
				result.add(retrieveAccessResourceInformationDslamEntity);
				logger.log(OSSLogger.INFO, "Não foi encontrado nenhum DSLAM para os dados informados");
			}
			
			logOut(result);
			
		} catch(Exception e) {
			retrieveAccessResourceInformationDslamEntity.getResult().setCode("10");
			retrieveAccessResourceInformationDslamEntity.getResult().setDescription(e.getMessage());
			
			result = new ArrayList<>();
			result.add(retrieveAccessResourceInformationDslamEntity);
			logger.log(OSSLogger.ERROR, " RetrieveAcessInformationDslamDao - method getAcessInformationResourceDSLAM =[" + e.getMessage() + "]");
		}
		return result;
	}
	
	private void logIn(Query query) {
		String log = getlogIn("QueryAcessInformationResourceDSLAM", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(List<RetrieveAccessResourceInformationDslamEntity> result) {
		String log = new StringBuilder("Param OUT: ")
				.append("p_size = ").append(result.size())
				.append("p_access = ").append(result.get(0).getAccessTecnology())
				.append("p_ret_msg = ").append(result.get(0).getResult().getDescription())
				.append("p_ret_code = ").append(result.get(0).getResult().getCode())
				.toString();
		logger.log(OSSLogger.INFO, log);
	}
}
