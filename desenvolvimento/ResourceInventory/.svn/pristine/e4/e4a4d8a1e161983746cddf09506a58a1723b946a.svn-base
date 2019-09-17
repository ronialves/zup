package com.tlf.oss.resourceinventory.repository.api.V1_0;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.repository.core.OrchestrationAuditServiceController;
import com.tlf.oss.resourceinventory.schemas.api.OrchestrationAuditEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;


@Stateless
@Path("orchestrationAudit")
public class OrchestrationAuditService extends RestInterceptor {

	@Inject
	private OrchestrationAuditServiceController controller;

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response create(OrchestrationAuditEntity entity) throws OSSBusinessException {
		controller.create(entity);
		return Response.status(Status.CREATED).entity(entity).build();
	}
}
