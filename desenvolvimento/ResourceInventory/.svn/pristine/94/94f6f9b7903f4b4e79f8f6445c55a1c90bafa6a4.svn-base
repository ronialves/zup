package com.tlf.oss.resourceinventory.granite.api.v2_0;

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
import com.tlf.oss.resourceinventory.granite.core.FacilityResourceController;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Path("/facilityRetrieval")
public class FacilityRetrievalServiceV2 extends RestInterceptor {

	@Context
	private UriInfo context;

	@Inject
	private FacilityResourceController facilityResourceController;

	@Resource
	private ManagedExecutorService executorService;

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) {
		try {
			//validateRequest(entity);
			entity = facilityResourceController.facilityResource(entity);
			return Response.status(Status.OK).entity(entity).build();

		} catch (OSSBusinessException e) {
			logger.error("ERROR", e);
			
			//Validação exclusiva quando não encontra facilidades
			//Na camada de Orch retornamos entidade vazia
			if(Code.RIGRANITE_003.getValue().equalsIgnoreCase(e.getStatusCode())){
				return Response.status(Status.NO_CONTENT).entity(e).build();
			}
			return Response.status(Status.BAD_REQUEST).entity(e).build();

		} 
	}
}