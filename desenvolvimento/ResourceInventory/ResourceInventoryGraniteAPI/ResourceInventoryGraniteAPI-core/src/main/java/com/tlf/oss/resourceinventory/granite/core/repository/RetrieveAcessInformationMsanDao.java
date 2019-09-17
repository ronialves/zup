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
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveAcessInformationMsanDao extends GenericDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public  List<RetrieveAccessResourceInformationMsanEntity> getAcessInformationResourceMSAN(ResourceInventoryEntity getAccessResourceInformationIn) {
		
		RetrieveAccessResourceInformationMsanEntity retrieveAccessResourceInformationMsanEntity = new RetrieveAccessResourceInformationMsanEntity();
		List<RetrieveAccessResourceInformationMsanEntity> result;
		
		try {
			TypedQuery<RetrieveAccessResourceInformationMsanEntity> q = getEntityManager()
					.createNamedQuery("QueryAcessInformationResourceMSAN", RetrieveAccessResourceInformationMsanEntity.class)
					.setParameter(1,getAccessResourceInformationIn.getAddress().getCnl())
					.setParameter(2,getAccessResourceInformationIn.getAddress().getTelephonicArea())
					.setParameter(3,getAccessResourceInformationIn.getCabinet().getName());

			logIn(q);
			
			result = q.getResultList();

			if (!result.isEmpty()) {
				result.stream().forEach(p -> {
					p.setAccessTecnology("METALICA");
					p.getResult().setCode("0");
				});
			} else {
				retrieveAccessResourceInformationMsanEntity.getResult().setCode("10");
				retrieveAccessResourceInformationMsanEntity.getResult().setDescription("not found getAcess msan");
				result.add(retrieveAccessResourceInformationMsanEntity);
				logger.log(OSSLogger.WARNING, "Não foi encontrado nenhum MSAN para os dados informados");
			}
			
			logOut(result);
			
		} catch (Exception e) {
			retrieveAccessResourceInformationMsanEntity.getResult().setCode("10");
			retrieveAccessResourceInformationMsanEntity.getResult().setDescription(e.getMessage());
			
			result = new ArrayList<>();
			result.add(retrieveAccessResourceInformationMsanEntity);
			logger.log(OSSLogger.ERROR, " RetrieveAcessInformationMsanDao - method getAcessInformationResourceMSAN =[" + e.getMessage() + "]");
		}
		return result;
	}
	
	private void logIn(Query query) {
		String log = getlogIn("QueryAcessInformationResourceMSAN", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(List<RetrieveAccessResourceInformationMsanEntity> result) {
		String log = new StringBuilder("Param OUT: ").append("p_size = ").append(result.size()).append("p_access = ").append(result.get(0)
				.getAccessTecnology()).append("p_ret_msg = ").append(result.get(0).getResult().getDescription()).append("p_ret_code = ")
				.append(result.get(0).getResult().getCode()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}