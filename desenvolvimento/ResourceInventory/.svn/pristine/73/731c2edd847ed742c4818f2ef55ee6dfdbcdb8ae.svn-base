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
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.sagre.core.DetermineAvailabilityController;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Path("/determineAvailability")
@Stateless
@Transactional(value = TxType.NOT_SUPPORTED) 
public class DetermineAvailabilityService extends RestInterceptor {

	@Inject
	private DetermineAvailabilityController determineAvailabilityController;
	
	@Inject
	protected OSSLogger logger;

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			logger.log(OSSLogger.INFO, this.getClass().getName() + " -  executando metodo doExecution");
			ResourceInventoryEntity result = determineAvailabilityController.getDetermineAvailability(entity);
			logger.log(OSSLogger.INFO, this.getClass().getName() + " -  metodo doExecution executado com sucesso");
			return Response.status(Status.OK).entity(result).build();
		} catch (ConstraintViolationException | OSSBusinessException e) {
			logger.log(OSSLogger.ERROR, this.getClass().getName() + " -  " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, this.getClass().getName() + " -  " + e.getMessage());
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_999.getDescription(),
					ExceptionInfoEnum.RISAGRE_999.getCode(), e.getMessage());
		}
	}
}
