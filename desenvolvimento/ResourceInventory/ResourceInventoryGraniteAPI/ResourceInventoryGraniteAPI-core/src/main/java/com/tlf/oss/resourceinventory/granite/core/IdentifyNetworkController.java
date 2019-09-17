package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.repository.IdentifyNetworkDao;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
public class IdentifyNetworkController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;
	
	@Inject
	private IdentifyNetworkDao identifyNetworkDao;

	public ResourceInventoryEntity identifyNetwork(ResourceInventoryEntity entity) {		
		return identifyNetworkDao.identifyNetwork(entity);
	}
}