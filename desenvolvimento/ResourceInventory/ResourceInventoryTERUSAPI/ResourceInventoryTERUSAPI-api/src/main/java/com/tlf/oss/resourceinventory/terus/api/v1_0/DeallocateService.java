package com.tlf.oss.resourceinventory.terus.api.v1_0;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.exception.OSSException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;
import com.tlf.oss.resourceinventory.terus.core.DeallocateController;

@Path("/deallocate")
public class DeallocateService extends RestInterceptor {

	@Inject
	private DeallocateController controller;


	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) {
		logger.log(OSSLogger.INFO, "Executing Deallocate");

		try{
			controller.unLock(entity);

		}catch (OSSBusinessException e) {
			logger.log(OSSLogger.ERROR, "Deallocate - WebMethod doExecution =[" + e.getMessage() + "]");
		} catch (OSSException e) {
			logger.log(OSSLogger.ERROR, "Deallocate - WebMethod doExecution =[" + e.getMessage() + "]");
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Deallocate - WebMethod doExecution =[" + e.getMessage() + "]");
		}

		return Response.status(Status.OK).entity(entity).build();
	}

}
