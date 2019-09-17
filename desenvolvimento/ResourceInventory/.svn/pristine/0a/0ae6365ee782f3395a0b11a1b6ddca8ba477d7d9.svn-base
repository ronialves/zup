package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.UninstallResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class UninstallResourceGponDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;

	public UninstallResourceGponEntity getUninstallInternalResource(UninstallResourceGponEntity entity)
			throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Param IN: TERMINAL:" + entity.getTerminal());

		try {
			TypedQuery<UninstallResourceGponEntity> query;
			query = getEntityManager().createNamedQuery("uninstallResourceGponEntity",
					UninstallResourceGponEntity.class);

			query.setParameter("p_terminal", entity.getTerminal());

			logIn(query);

			entity = query.getSingleResult();

			entity.getResult().setCode("0");

			logOut(entity);

		} catch (PersistenceException e) {
			entity.setCode(Code.RIGRANITE_002.getValue());
			entity.setDescription(Code.RIGRANITE_002.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(),
					String.format(
							Code.RIGRANITE_002.getMessage(), "Erro ao chamar a procedure "
									.concat(ReserveResourceGponEntity.PROC_NAME).concat(" no Granite"),
							e.getMessage()));
		} catch (Exception e) {
			entity.setCode(Code.RIGRANITE_999.getValue());
			entity.setDescription(e.getMessage());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(),
					e.getMessage());
		}

		return entity;
	}

	private void logIn(Query query) {
		String log = getlogIn("PKG_ALLOCATE.PRC_CANCEL_ALLOCATE_GPON", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(UninstallResourceGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("p_ret_code = ").append(result.getCode())
				.append("p_ret_msg = ").append(result.getDescription()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}