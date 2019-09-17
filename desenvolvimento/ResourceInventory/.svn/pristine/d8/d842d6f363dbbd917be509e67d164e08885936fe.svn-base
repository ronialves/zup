package com.tlf.oss.resourceinventory.osp.api.v1_0;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
import com.tlf.oss.resourceinventory.osp.core.UninstallController;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Stateless
@Path("uninstall")
public class Uninstall extends RestInterceptor {
	
	@Inject
	private UninstallController uninstallController;
	
	/**
	 * Método que irá fazer fazer à baixa(exclusão)
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws Exception {
		
		try {
			logger.log(OSSLogger.INFO, "Executing uninstall");
			ResourceInventoryEntity uninstallEntity = uninstallController.doExecution(entity);			
			return Response.status(Status.OK).entity(uninstallEntity).build();

		} catch (ConstraintViolationException | OSSBusinessException e) {
			logger.log(OSSLogger.ERROR, Message.ERRO_RESOURCE_UNINSTALL.getValue()+" =[" + e.getMessage() + "]");
			throw e;
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, Message.ERRO_RESOURCE_UNINSTALL.getValue()+" =[" + e.getMessage() + "]");
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, "uninstallResource");
		}
	}
}