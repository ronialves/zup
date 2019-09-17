package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.UpdateMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class UpdateMsanPotsDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	public void updateMsanPots(RetrieveMsanPotsEntity entity) throws OSSBusinessException {

		try {

			Query query = getEntityManager().createNamedQuery(UpdateMsanPotsEntity.QUERY_UPDATE_MSAN_POTS);

			query.setParameter(1, entity.getId());
			query.executeUpdate();
			
			logIn(entity.getId().toString());

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR,Message.ERRO_RESOURCE_UPDATE_MSAN_POTS_ENTITYDAO.getValue() + ":" + e.getMessage());
			throw new OSSBusinessException(Message.ERRO_RESOURCE_UPDATE_MSAN_POTS_ENTITYDAO.getValue(), Code.RIGRANITE_001.getValue(),
					e.getMessage());
		}
	}

	private void logIn(String IdConexoesPotsMan) {
		logger.log(OSSLogger.INFO, "Param IN: " + IdConexoesPotsMan);
	}

	public void updateMsanPots(UpdateMsanPotsEntity entity) throws OSSBusinessException {

		try {

			Query query = getEntityManager().createNamedQuery(UpdateMsanPotsEntity.QUERY_UPDATE_STATUS_MSAN_POTS);
			query.setParameter(1, entity.getStatusPots());
			query.setParameter(2, entity.getId());

			logIn(entity.getId().toString());

			query.executeUpdate();

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, Message.ERRO_RESOURCE_UPDATE_MSAN_POTS_ENTITYDAO.getValue() + ":" + e.getMessage());
			throw new OSSBusinessException(Message.ERRO_RESOURCE_UPDATE_MSAN_POTS_ENTITYDAO.getValue(), Code.RIGRANITE_001.getValue(),
					e.getMessage());
		}
	}
}