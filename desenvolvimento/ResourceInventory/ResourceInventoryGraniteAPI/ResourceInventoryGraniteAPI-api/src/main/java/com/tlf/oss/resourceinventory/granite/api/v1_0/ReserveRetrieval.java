package com.tlf.oss.resourceinventory.granite.api.v1_0;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.RetrieveExpiredResourcesController;
import com.tlf.oss.resourceinventory.schemas.RetrieveExpiredResources;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

/**
 * 
 * @author luiz
 *
 */
@Path("/retrieve/reserve")
public class ReserveRetrieval extends RestInterceptor {
	
	@Inject
	private RetrieveExpiredResourcesController controller;
	
	
	@GET
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution() {
		logger.log(OSSLogger.INFO, "Executing reserveRetrieval");
		try{
			RetrieveExpiredResources entity = controller.getExpired();
			
			logger.log(OSSLogger.INFO, "Executed reserveRetrieval");
			
			return entity.getExpiredResourceList().isEmpty() ?
						Response.status(Status.NO_CONTENT).build() :
						Response.status(Status.OK).entity(entity).build()
				;
		} catch (OSSBusinessException e){
			logger.log(OSSLogger.ERROR, "RetrieveExpiredResources - WebMethod doExecution =[" + e.getMessage() + "]");
			return Response.status(Status.BAD_REQUEST).entity(e).build();
		}
	}
	
}
