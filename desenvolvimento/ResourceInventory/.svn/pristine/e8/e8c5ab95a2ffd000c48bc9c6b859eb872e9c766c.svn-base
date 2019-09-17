package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveExpiredResourcesEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
/**
 * 
 * @author luiz
 *
 */
public class RetrieveExpiredResourcesDao extends GenericDao implements Serializable{

	@Inject
	private OSSLogger logger;
	
	private static final long serialVersionUID = 1L;
	
	private static final String PIPE = "|";
	
	@SuppressWarnings("unchecked")
	public List<RetrieveExpiredResourcesEntity> getExpired() throws OSSBusinessException{
		List<RetrieveExpiredResourcesEntity> resultList;
		try{
			Query query = getEntityManager().createNamedQuery("QueryExpiredResources");
			logger.log(OSSLogger.INFO, "Retrieving list of expired resources");
			resultList = query.getResultList();
			logOut(resultList);
			
		}catch (NoResultException e) {
			resultList = new ArrayList<>();
		} catch (Exception e) {
			throw new OSSBusinessException("Erro ao consultar o objeto RetrieveExpiredResourcesEntity", Code.RIGRANITE_001.getValue(), e.getMessage());
		}
		return resultList;
	
	}
	
	private void logOut(List<RetrieveExpiredResourcesEntity> resultList) {
		StringBuilder sb = new StringBuilder("Param OUT:").append("   TERMINAL    |    CNL    |  AT  | TECHNOLOGY | STATUS");
		for (RetrieveExpiredResourcesEntity entity : resultList) {
			sb.append(entity.getTerminal() + PIPE)
			.append(blankFill(entity.getCnl(), 11) + PIPE)
			.append(blankFill(entity.getAt(), 6) + PIPE)
			.append(blankFill(entity.getTechnology(), 12) + PIPE)
			.append(entity.getStatus());
		}
		String log = sb.toString();
		logger.log(OSSLogger.INFO, log);
	}
	
	private String blankFill(String string, int size){
		if (string.length()>size){
			return string.substring(0, size);
		}
		StringBuilder sb = new StringBuilder(string);
		for (int toPrepend=size-string.length(); toPrepend>0; toPrepend--) {
		    sb.append(' ');
		}
		return sb.toString();
	}
}