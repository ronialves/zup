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
import com.tlf.oss.resourceinventory.cpe.core.AllocateStbController;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Path("/allocate/stb")
@Stateless
public class AllocateStbService extends RestInterceptor{

	@Inject
	private AllocateStbController allocateStbController;
	
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		allocateStbController.allocate(entity);
		
		return Response.status(Status.OK).entity(entity).build();
	}

}