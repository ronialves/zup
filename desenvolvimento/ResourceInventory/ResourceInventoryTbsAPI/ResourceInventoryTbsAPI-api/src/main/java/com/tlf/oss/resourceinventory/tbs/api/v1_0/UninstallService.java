package com.tlf.oss.resourceinventory.tbs.api.v1_0;

import javax.ws.rs.Consumes;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;
import com.tlf.oss.resourceinventory.tbs.core.UninstallController;

@Path("/uninstall")
public class UninstallService extends RestInterceptor {

	@Inject
	UninstallController uninstallController;

	/**
	 * Realiza a chamada do uninstallController.getUninstall, responsavel por executar a procedure e enriquecimento do ResourceInventoryEntity
	 * 
	 * @param entity
	 * @return Response
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		uninstallController.getUninstall(entity);

		return Response.ok().entity(entity).build();
			
	}	

}
