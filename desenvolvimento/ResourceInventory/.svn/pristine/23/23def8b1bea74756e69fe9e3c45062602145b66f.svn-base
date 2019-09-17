package com.tlf.oss.resourceinventory.granite.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveExpiredResourcesEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveExpiredResourcesDao;
import com.tlf.oss.resourceinventory.schemas.ExpiredResource;
import com.tlf.oss.resourceinventory.schemas.RetrieveExpiredResources;
/**
 * 
 * @author luiz
 *
 */
public class RetrieveExpiredResourcesController {
	
	@Inject
	private OSSLogger logger;
	@Inject
	private RetrieveExpiredResourcesDao retrieveExpiredResourcesDao;

	public RetrieveExpiredResources getExpired() throws OSSBusinessException{
		List<RetrieveExpiredResourcesEntity> resultList = retrieveExpiredResourcesDao.getExpired();
		logger.log(OSSLogger.INFO, "RetrieveExpiredResoucesDao.getExpired() has returned "+resultList.size()+" expired entries");
		return convertToSchemaModel(resultList);
	}
	
	private RetrieveExpiredResources convertToSchemaModel(List<RetrieveExpiredResourcesEntity> expiredResourcesList) {
		RetrieveExpiredResources retrieveExpiredResourcesSchema = new RetrieveExpiredResources();
		retrieveExpiredResourcesSchema.setExpiredResourceList(new ArrayList<ExpiredResource>());
		for (RetrieveExpiredResourcesEntity expiredResource : expiredResourcesList) {
			ExpiredResource expiredResourceSchema = new ExpiredResource();
			expiredResourceSchema.setTelephonicArea(expiredResource.getAt());
			expiredResourceSchema.setCnl(expiredResource.getCnl());
			expiredResourceSchema.setExpiredHours(String.valueOf(expiredResource.getHoursReserved()));
			expiredResourceSchema.setStatus(expiredResource.getStatus());
			expiredResourceSchema.setTechnology(expiredResource.getTechnology());
			expiredResourceSchema.setServiceId(expiredResource.getTerminal());
			retrieveExpiredResourcesSchema.getExpiredResourceList().add(expiredResourceSchema);
		}
		
		return retrieveExpiredResourcesSchema;
	}
}
