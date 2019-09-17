package com.tlf.oss.resourceinventory.osp.api.v1_0;

import javax.ejb.Stateless;
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
import com.tlf.oss.resourceinventory.osp.core.AvailabilityController;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Stateless
@Path("availabilityRetrieval")
public class AvailabilityRetrieval extends RestInterceptor {

	@Inject
	private AvailabilityController avalabilityController;
	
	/**
	 * Método que ira fazer fazer a consulta cobertura
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 * @throws FacilitiesException 
	*/
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Executing Query Coverage");

		try {
			ResourceInventoryEntity responseAvailabilityRetrieval = avalabilityController.availability(entity);
			return Response.status(Status.OK).entity(responseAvailabilityRetrieval).build();
		} catch (OSSBusinessException e) {
			logger.error("ERROR"  , e);
			if(Code.RIOSP_002.getValue().equalsIgnoreCase(e.getStatusCode()) || Code.RIOSP_003.getValue().equalsIgnoreCase(e.getStatusCode())){
				return Response.status(Status.NO_CONTENT).entity(new OSSException("", "")).build();
			}
			return Response.status(Status.BAD_REQUEST).entity(new OSSException(e.getDescription(), e.getDetail())).build();
		} catch (Exception e) {
			logger.error("ERROR" , e);
			return Response.status(Status.NO_CONTENT).entity(new OSSException("", "")).build();
		}
	}
}