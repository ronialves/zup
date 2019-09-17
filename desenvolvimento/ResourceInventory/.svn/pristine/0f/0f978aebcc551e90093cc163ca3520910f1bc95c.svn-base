package com.tlf.oss.resourceinventory.osp.api.v1_0;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.exception.OSSException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.osp.core.AllocateController;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Stateless
@Path("allocate")
public class Allocate extends RestInterceptor {

	@Inject
	private AllocateController allocateController;

	/**
	 * Método que irá fazer a alocação do recurso externo
	 * @param entity
	 * @return
	 * @throws OSSBusinessException 
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
	
		try {
			logger.log(OSSLogger.INFO, "Executing allocate resource external");
			ResourceInventoryEntity updatedEntity = allocateController.doExecution(entity);
			
			return Response.status(Status.OK).entity(updatedEntity).build();
		} catch (ConstraintViolationException | OSSBusinessException e) {
			logger.log(OSSLogger.ERROR, "AllocateResourceService - WebMethod doExecution =[" + e.getMessage() + "]");
			throw e;
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "AllocateResourceService - WebMethod doExecution =[" + e.getMessage() + "]");
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, "AllocateResourceService");
		}
	}

	/**
	 * Método chamado pelo orquestrador, caso tenha que fazer o rollback da
	 * alocação
	 * 
	 * @param entity
	 * @return
	 */
	@DELETE
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response undoExecution(ResourceInventoryEntity entity) {
		
		try {
			logger.log(OSSLogger.INFO, "Executing rollback allocation");
			return Response.status(Status.OK).entity(entity).build();
		} catch (OSSException e) {
			logger.log(OSSLogger.ERROR, "AllocateResourceService - WebMethod undoExecution =[" + e.getMessage() + "]");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e).build();
		} catch (Exception e) {
			if(e instanceof OSSBusinessException) {
				logger.log(OSSLogger.ERROR, "AllocateResourceService - WebMethod undoExecution =[" + e.getMessage() + "]");
				return Response.status(Status.BAD_REQUEST).entity(e).build();
			}
			logger.log(OSSLogger.ERROR, "AllocateResourceService - WebMethod undoExecution =[" + e.getMessage() + "]");
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new OSSException("Erro na execução AllocateResourceService - WebMethod undoExecution ", e.getMessage())).build();
		}
	}
}
