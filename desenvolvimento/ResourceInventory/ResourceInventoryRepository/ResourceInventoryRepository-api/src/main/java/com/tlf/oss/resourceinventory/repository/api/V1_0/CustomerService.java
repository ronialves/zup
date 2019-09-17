package com.tlf.oss.resourceinventory.repository.api.V1_0;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.repository.core.CustomerController;
import com.tlf.oss.resourceinventory.schemas.api.CustomerEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;


@Stateless
@Path("customer")
public class CustomerService extends RestInterceptor {

	@Inject
	private CustomerController customerServiceController;

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response create(CustomerEntity entity) throws OSSBusinessException {
		customerServiceController.create(entity);
		return Response.status(Status.CREATED).entity(entity).build();
	}
	
	@GET
	@Path("{accessDesignator}")
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response retrieve(@PathParam ("accessDesignator") String accessDesignator) throws OSSBusinessException {
		CustomerEntity entity = customerServiceController.retrieve(accessDesignator);
		
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@PUT
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response update(CustomerEntity entity) throws OSSBusinessException {
		customerServiceController.update(entity);
		return Response.status(Status.OK).build();	
	}

	@DELETE
	@Path("{accessDesignator}")
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response delete(@PathParam ("accessDesignator") String accessDesignator) throws OSSBusinessException {
		customerServiceController.delete(accessDesignator);
		return Response.status(Status.NO_CONTENT).build();
	}

}
