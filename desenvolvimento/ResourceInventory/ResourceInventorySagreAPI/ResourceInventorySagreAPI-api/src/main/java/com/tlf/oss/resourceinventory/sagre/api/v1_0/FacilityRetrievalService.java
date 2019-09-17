package com.tlf.oss.resourceinventory.sagre.api.v1_0;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.sagre.core.FacilityResourceController;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

/**
 * BEATRIXTWO-441 | DEMOSS-2279
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@Path("/facilityRetrieval")
@Stateless
@Transactional(value = TxType.NOT_SUPPORTED) 
public class FacilityRetrievalService extends RestInterceptor {

	@Inject
	FacilityResourceController controller;

	/**
	 * Realiza a busca de facilidades ja reservadas no SAGRE
	 * 
	 * @param entity
	 * @return {@link Response}
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			controller.retrieveFacility(entity);
			return Response.status(Status.OK).entity(entity).build();
		} catch (ConstraintViolationException | OSSBusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_999.getDescription(),
					ExceptionInfoEnum.RISAGRE_999.getCode(), e.getMessage());
		}

	}

}
