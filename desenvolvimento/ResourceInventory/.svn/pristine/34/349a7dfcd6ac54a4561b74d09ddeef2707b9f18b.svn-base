package com.tlf.oss.resourceinventory.orchestration.api;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.orchestration.core.OrchestrationController;
import com.tlf.oss.resourceinventory.orchestration.core.interceptor.Audit;
import com.tlf.oss.resourceinventory.orchestration.core.interceptor.CustomerValidation;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Stateless
@Path("{version}/orchestration")
@CustomerValidation
@Audit
public class OrchestrationService extends RestInterceptor {
	
	@Inject
	private OrchestrationController controller;
	
	@POST
	@Path("{action}")
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response execute(@PathParam("version") String version, @PathParam("action") String action, ResourceInventoryEntity entity) throws Exception {
		ResourceInventoryEntity updatedEntity = controller.execute(version, action, entity);
		
		return Response.status(Status.OK).entity(updatedEntity).build();
	}
}
