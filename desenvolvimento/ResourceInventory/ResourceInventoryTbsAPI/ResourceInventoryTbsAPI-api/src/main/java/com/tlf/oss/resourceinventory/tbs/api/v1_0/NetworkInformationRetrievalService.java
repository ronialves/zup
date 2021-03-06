package com.tlf.oss.resourceinventory.tbs.api.v1_0;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;
import com.tlf.oss.resourceinventory.tbs.core.NetworkInfoController;
/**
 * Classe de busca de informacao de rede para atender o projeto Obsolecencia.
 * Essa classe deverah ser fundida com o FalcilityRetrival, porem deverah ter alteracao no Savvion
 * para ver esse novo fluxo.
 * 
 */
@Path("/networkInformationRetrieval")
public class NetworkInformationRetrievalService extends RestInterceptor {

	@Inject
	private NetworkInfoController retrieveController;

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		entity = retrieveController.getRetrieve(entity);

		return Response.status(Status.OK).entity(entity).build();
	}	

}
