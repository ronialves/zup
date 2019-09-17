package com.tlf.oss.resourceinventory.tbs.repository.v2_0;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.tbs.entity.v2_0.RetrieveFacilityEntity;

/**
 * BEATRIXTWO-70 | DEMOSS-2285
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@SuppressWarnings("serial")
public class FacilityResourceRepository implements Serializable {

	@PersistenceContext(name="TbsDS")
	EntityManager factory;

	@Inject
	OSSLogger logger;

	public RetrieveFacilityEntity retrieveFacility(RetrieveFacilityEntity entity) throws OSSBusinessException {
		List<RetrieveFacilityEntity> resultList = null;
		RetrieveFacilityEntity result = new RetrieveFacilityEntity();
		try {
			TypedQuery<RetrieveFacilityEntity> query;
			query = factory.createNamedQuery("retrieveFacilityResource", RetrieveFacilityEntity.class);

			query.setParameter("P_DESIGNADOR", entity.getDesignator());
			query.setParameter("P_ACTIVITY_IND", entity.getActivity());

			logger.log(OSSLogger.INFO, query.getParameters().toString());

			resultList = query.getResultList();

			if (resultList != null && !resultList.isEmpty()) {
				logOut(resultList.get(0));
				result = resultList.get(0);
			}

		} catch (Exception e) {
			result.getResult().setCode("10");
			result.getResult().setDescription(e.getMessage());
		}

		return result;
	}

	private void logOut(RetrieveFacilityEntity result) {
		String log = new StringBuilder("Param OUT: ").append("P_DOCUMENT_NUMBER = ")
				.append("P_COD_RETORNO = ").append(result.getResultCode()).append("P_MSG_RETORNO = ")
				.append(result.getMessage()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}