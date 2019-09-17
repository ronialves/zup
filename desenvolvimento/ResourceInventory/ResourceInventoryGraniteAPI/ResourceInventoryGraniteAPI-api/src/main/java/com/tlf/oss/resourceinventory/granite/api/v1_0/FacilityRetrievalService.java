package com.tlf.oss.resourceinventory.granite.api.v1_0;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;
import com.tlf.oss.resourceinventory.sophia.core.FacilityController;

@Path("/facilityRetrieval")
public class FacilityRetrievalService extends RestInterceptor {

	@Context
	private UriInfo context;
	
	@Inject 
	private FacilityController facilityController; 

	@Resource
	private ManagedExecutorService executorService;
	/**
	 * Não alterar essa classe, usada somente para retornar as informações que serao enviadas ao PSSBA
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {

		entity = facilityController.facilityResource(entity);
		return Response.status(Status.OK).entity(entity).build();

	}
}