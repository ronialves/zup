package com.tlf.oss.resourceinventory.granite.api.v1_0;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.granite.core.AccessRetrieveController;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAccessResourceInformationMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveResourceMapper;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Path("/accessRetrieval")
public class AccessRetrievalService extends RestInterceptor{
	
	@Inject
	private RetrieveResourceMapper availabilityMapper;

	@Inject
	private AccessRetrieveController resourceAcessInformationBO;

	private void validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<BrazilianUrbanPropertyAddress> address = Optional.ofNullable(entity.getAddress());

		if(!address.isPresent())
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", "RIGRANITE-001", "O valor do campo address.telephonicArea eh nulo");
		
		if(!address.map(BrazilianUrbanPropertyAddress::getCnl).filter(d -> !d.isEmpty()).isPresent())
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", "RIGRANITE-001", "O valor do campo address.cnl eh nulo");
		
		if(!address.map(BrazilianUrbanPropertyAddress::getTelephonicArea).filter(d -> !d.isEmpty()).isPresent())
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", "RIGRANITE-001", "O valor do campo address.telephonicArea eh nulo");
	}

	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {		
		validateRequest(entity);
		
		//Busca Msan
		List<RetrieveAccessResourceInformationMsanEntity> retrieveAcessResourceInformationMsan = resourceAcessInformationBO.getAcessInformationResourceMsan(entity);
		Optional<ResourceInventoryEntity> accessResourceInformatiomOut = Optional.ofNullable(availabilityMapper.parseGetAccessResourceInformationMsan(retrieveAcessResourceInformationMsan,entity));

		if (accessResourceInformatiomOut.isPresent() && null == accessResourceInformatiomOut.get().getPhysicalLinks().get(0).getAccessTechnology()) {
			//busca DSLAM caso nao encontre MSAN
			List<RetrieveAccessResourceInformationDslamEntity> retrieveAcessResourceInformationDslam = resourceAcessInformationBO.getAcessInformationResourceDslam(entity);
			accessResourceInformatiomOut = Optional.ofNullable(availabilityMapper.parseGetAccessResourceInformationDslam(retrieveAcessResourceInformationDslam,entity));
		}
		ResponseBuilder response = Response.status(Status.OK).entity(accessResourceInformatiomOut.get());
		return response.build();
	}
}