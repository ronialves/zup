package com.tlf.oss.resourceinventory.tbs.api.faultmanagement.v1_0;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;
import com.tlf.oss.resourceinventory.tbs.core.CabinetRetrievalController;

/**
 * Camada REST do fluxo de consultas do CabinetRetrieval
 * 
 * REC2164-44-RI | REC3164-223
 * 
 * @project IONIX-SIGITM
 * @author 80629552
 * @since 20190328
 */
@Path("/cabinetRetrieval")
public class CabinetRetrievalService extends RestInterceptor{

	@Inject
	protected OSSLogger logger;
	
	@Inject
	private CabinetRetrievalController controller;
	
	/**
	 * Executa o retrieval para Busca de Equipamentos. 
	 * 
	 * @param entity
	 * @return {@link Response}
	 * @throws OSSBusinessException
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "CabinetRetrievalService - Iniciando fluxo de Consulta a equipamentos de Rede.");
		entity = controller.retrieval(entity);
		return Response.status(Status.OK).entity(entity).build();
	}
}
