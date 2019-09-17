package com.tlf.oss.resourceinventory.cpe.api.v1_0;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.resourceinventory.cpe.core.AllocateController;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Path("/allocate")
@Stateless
public class AllocateService extends RestInterceptor{

	@Inject
	private AllocateController allocateController;
	
	@POST
	@Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response doExecution(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		defaultVoiceEquipmentTypeHGU(entity); 
		
		allocateController.allocate(entity);
		
		return Response.status(Status.OK).entity(entity).build();
	}

	/**
	 * Paliativo para AMDOCS
	 * @param entity
	 */
	private void defaultVoiceEquipmentTypeHGU(ResourceInventoryEntity entity) {
		Optional<List<ServiceDescribedBy>> sdbList = EntityExtractor
				.extractSdbFromCfs(entity.getCustomerFacingService().get(0));

		Optional<ServiceDescribedBy> result = sdbList.get()
													 .stream()
													 .filter(sdb -> null != sdb.getName() && sdb.getName().equalsIgnoreCase(TipoRfs.VOIP.getEquipmentType()))
													 .findFirst();

		if (!result.isPresent()) {
			
			ServiceDescribedBy arg0 = new ServiceDescribedBy();
			arg0.setName(TipoRfs.VOIP.getEquipmentType());
			
			ServiceSpecCharDescribes spec = new ServiceSpecCharDescribes();
			spec.setValue(CpeConstants.HGU);
			
			arg0.getServiceSpecCharDescribes().add(spec);
			sdbList.get().add(arg0);
		}
	}

}
