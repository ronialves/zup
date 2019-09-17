package com.tlf.oss.resourceinventory.tbs.api.v2_0;

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
import com.tlf.oss.resourceinventory.tbs.core.v2_0.FacilityResourceController;

/**
 * BEATRIXTWO-507 | DEMOSS-2562
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201712
 */
@Path("/facilityRetrieval")
public class FacilityRetrievalV2Service extends RestInterceptor {

	@Inject
	private FacilityResourceController retrieveController;

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		retrieveController.retrieveFacility(entity);

		return Response.status(Status.OK).entity(entity).build();
		
	}

}
