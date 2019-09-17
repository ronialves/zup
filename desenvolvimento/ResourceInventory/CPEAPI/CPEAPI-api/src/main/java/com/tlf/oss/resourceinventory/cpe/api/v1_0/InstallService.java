package com.tlf.oss.resourceinventory.cpe.api.v1_0;

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
import com.tlf.oss.resourceinventory.cpe.core.InstallController;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;


@Stateless
@Path("/install")
public class InstallService extends RestInterceptor{
	
	@Inject
	InstallController installController;
	
	
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		installController.install(entity);
		return Response.status(Status.OK).entity(entity).build();
	}
	
}
