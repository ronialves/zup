package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.UpdateResourcesServiceAmoEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;

public class UpdateResourcesServiceAmoDao extends GenericDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	protected OSSLogger logger;
	
	public UpdateResourcesServiceAmoEntity updateResourcesServiceAmo(final UpdateResourcesServiceAmoEntity entity) throws OSSBusinessException {

		UpdateResourcesServiceAmoEntity result = new UpdateResourcesServiceAmoEntity();

		try {
			final TypedQuery<UpdateResourcesServiceAmoEntity> query;
			query = getEntityManager().createNamedQuery(UpdateResourcesServiceAmoEntity.UPDATE_RESOURCE_AMO,
					UpdateResourcesServiceAmoEntity.class);

			query.setParameter(UpdateResourcesServiceAmoEntity.SERVICE_ID, entity.getAccessDesignator());
			query.setParameter(UpdateResourcesServiceAmoEntity.SERVICE_CODE, entity.getServiceCode());
			query.setParameter(UpdateResourcesServiceAmoEntity.STATUS, entity.getStatus());

			logIn(query);

			result = query.getSingleResult();

			logOut(result);
			
		} catch (PersistenceException e) {
			result.setCode(Code.RIGRANITE_002.getValue());
			result.setDescription(Code.RIGRANITE_002.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro ao chamar a procedure ".concat(ReserveResourceGponEntity.PROC_NAME).concat(" no Granite"), e.getMessage()));
		} catch (Exception e) {
			result.setCode(Code.RIGRANITE_999.getValue());
			result.setDescription(Code.RIGRANITE_999.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(), Code.RIGRANITE_999.getMessage());
		}

		return result;
	}

	private void logIn(Query query) {
		String log = getlogIn(UpdateResourcesServiceAmoEntity.UPDATE_RESOURCE_AMO_PROC, query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(final UpdateResourcesServiceAmoEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode()).append("p_ret_msg = ")
				.append(result.getDescription()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}