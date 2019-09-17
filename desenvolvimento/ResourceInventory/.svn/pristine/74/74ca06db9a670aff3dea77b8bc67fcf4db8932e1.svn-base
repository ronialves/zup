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
import com.tlf.oss.resourceinventory.sagre.core.ReserveController;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Stateless
@Path("/reserve")
@Transactional(value = TxType.NOT_SUPPORTED) 
public class ReserveService extends RestInterceptor {
	
	@Inject
	private ReserveController reserveController;
	
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			reserveController.getReserve(entity);
			return Response.status(Status.OK).entity(entity).build();
		} catch (ConstraintViolationException | OSSBusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new OSSBusinessException(ExceptionInfoEnum.RISAGRE_999.getDescription(),
					ExceptionInfoEnum.RISAGRE_999.getCode(), e.getMessage());
		}
	}
}
