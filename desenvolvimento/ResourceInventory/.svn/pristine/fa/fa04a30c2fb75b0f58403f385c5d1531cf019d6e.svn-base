package com.tlf.oss.resourceinventory.scqla.api.v1_0;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;
import com.tlf.oss.resourceinventory.scqla.core.RetrievalController;
import com.tlf.oss.resourceinventory.scqla.core.enums.Code;

/**
 * 
 * @author lgomesf
 *
 */

@Stateless
@Path("availabilityRetrieval")
public class AvailabilityRetrievalService extends RestInterceptor {
	
	@Inject
	private RetrievalController controller;
	
	/**
	 * Metodo que ira fazer o retrieval do recurso externo
	 * @param entity
	 * @return
	 * @throws OSSBusinessException 
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
					
		try {
			ResourceInventoryEntity updatedEntity = controller.retrieval(entity);
			return Response.status(Status.OK).entity(updatedEntity).build();
	
		} catch (OSSBusinessException e) {
			logger.error("ERROR", e);			
			//Validação exclusiva quando não encontra facilidades
			//Na camada de Orch retornamos entidade vazia
			if(Code.RI_SCQLA_003.getValue().equalsIgnoreCase(e.getStatusCode())){
				return Response.status(Status.NO_CONTENT).entity(e).build();
			}
			return Response.status(Status.BAD_REQUEST).entity(e).build();
	
		} 
	}
	

	/**
	 * Método chamado pelo orquestrador, caso tenha que fazer o rollback do retrieval
	 * @param entity
	 * @return
	 */
	@DELETE
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response undoExecution(ResourceInventoryEntity entity) {
			//Nao existe acao a ser executada
			return Response.status(Status.OK).entity(entity).build();
	}

}
