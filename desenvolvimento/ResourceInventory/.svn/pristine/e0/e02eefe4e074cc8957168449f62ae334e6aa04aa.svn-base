package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAcessInformationDslamDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAcessInformationMsanDao;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AccessRetrieveController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;
	
	@Inject
	public RetrieveAcessInformationDslamDao rdaoDslam;
	
	@Inject
	public RetrieveAcessInformationMsanDao rdaoMsan;

	public List<RetrieveAccessResourceInformationDslamEntity> getAcessInformationResourceDslam(ResourceInventoryEntity getAccessResourceInformationIn) {
		
		logger.log(OSSLogger.INFO, " ResourceAcessInformationBO:getAcessInformationResourceDslam");

		//Recupera porta disponivel DSLAM
		return rdaoDslam.getAcessInformationResourceDSLAM(getAccessResourceInformationIn);
	}

	public List<RetrieveAccessResourceInformationMsanEntity> getAcessInformationResourceMsan(ResourceInventoryEntity getAccessResourceInformationIn) {
			
		logger.log(OSSLogger.INFO, " ResourceAcessInformationBO:getAcessInformationResourceMsan");

		//Recupera porta disponivel MSAN
		return rdaoMsan.getAcessInformationResourceMSAN(getAccessResourceInformationIn);
	}

}
