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
import com.tlf.oss.resourceinventory.tbs.core.EquipmentRetrievalController;

/**
 * Camada REST do fluxo de consultas aos equipamentos de rede.
 * <br>
 * Esse fluxo é utilizado pela frente de Incidentes, via SIGITIM.
 */
@Path("/equipmentRetrieval")
public class EquipmentRetrievalService extends RestInterceptor {

	@Inject
	protected OSSLogger logger;
	
	@Inject
	private EquipmentRetrievalController controller;
	
	/**
	 * Operação responsável pelo retorno das informações dos Equipamentos de Rede:
	 * <br>
	 * Consulta 1: RetrieveEquipmentByLocation;
	 * <br>
	 * Consulta 2: RetrieveEquipmentDetail;
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "EquipmentRetrievalService - Iniciando fluxo de Consulta a equipamentos de Rede.");
		entity = controller.retrieval(entity);
		return Response.status(Status.OK).entity(entity).build();
	}
}
