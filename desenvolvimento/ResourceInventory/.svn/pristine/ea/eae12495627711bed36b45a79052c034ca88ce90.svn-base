package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.AvailabilityRetrieveActiveMsanDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAvailabilityActiveMsanDslamDao;

public class AvailabilityRetrieveActiveMsanDslamController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RetrieveAvailabilityActiveMsanDslamDao availabilityActiveMsanDslamDao;
	
	/**
	 * Metodo responsavel em fazer a consulta disponibilidade
	 * @throws OSSBusinessException 
	 * 
	 */
	public Collection<AvailabilityRetrieveActiveMsanDslamEntity> getAvailabilityActiveMsanDslam(String terminal) throws OSSBusinessException {
		
		Collection<AvailabilityRetrieveActiveMsanDslamEntity> availabilityResultCollection = availabilityActiveMsanDslamDao.getAvailabilityActiveMsanDslan(terminal);
		
		return availabilityResultCollection;
	}
}