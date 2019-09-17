package com.tlf.oss.resourceinventory.terus.api.v1_0;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.exception.OSSException;
import com.tlf.oss.common.interceptor.RestInterceptor;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;
import com.tlf.oss.resourceinventory.terus.core.DeallocateController;

@Path("/uninstall")
public class UninstallService extends RestInterceptor {
	
	@Inject
	private DeallocateController controller;
	
	private static final String UPDATEPOTS = "UPDATEPOTS";
	
	private boolean validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<Cabinet> cabinet = Optional.ofNullable(entity.getCabinet());
		
		if(!cabinet.isPresent()){
			logger.log(OSSLogger.ERROR, "Erro ao validar o objeto ResourceInventoryEntity" + ":" + "TERUS-001" + ":" + "O valor do campo cabinet eh nulo");
		    return false;
	    }
		
		if(!cabinet.map(Cabinet::getIdMsan).filter(d -> !d.isEmpty()).isPresent()){
		    logger.log(OSSLogger.ERROR, "Erro ao validar o objeto ResourceInventoryEntity" + ":" + "TERUS-001" + ":" + "O valor do campo Cabinet::getIdMsan eh nulo");
		    return false;
	    }
		if(!cabinet.map(Cabinet::getLic).filter(d -> !d.isEmpty()).isPresent()){
			logger.log(OSSLogger.ERROR, "Erro ao validar o objeto ResourceInventoryEntity" + ":" + "TERUS-001" + ":" + "O valor do campo Cabinet::getLic eh nulo");
			return false;
        }
		
		return validateServiceDescribedBy(entity.getOperationService().getServiceDescribedBy(), UPDATEPOTS);
	}
	
	@POST
    @Consumes(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
    @Produces(RIConstants.MEDIA_TYPE_APPLICATION_JSON_UTF8)
    public Response doExecution(ResourceInventoryEntity entity) {
		logger.log(OSSLogger.INFO, "Executing cancel reserve");
 
		try{
			if (validateRequest(entity)){
				String serviceDescribedName  = entity.getOperationService().getServiceDescribedBy().get(0).getName();
				String serviceSpecCharDescribe  = entity.getOperationService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
				
				if (UPDATEPOTS.equals(serviceDescribedName) && Boolean.parseBoolean(serviceSpecCharDescribe)){
					controller.unLock(entity);
				}else{
					logger.log(OSSLogger.ERROR, "Terus API - WebMethod lock =[" + "TERUS-API não invocada devida a regra de negócio!" + "]");
				}	
			}
			
		}catch (OSSBusinessException e) {
			logger.log(OSSLogger.ERROR, "CancelReserved - WebMethod doExecution =[" + e.getMessage() + "]");
		} catch (OSSException e) {
			logger.log(OSSLogger.ERROR, "CancelReserved - WebMethod doExecution =[" + e.getMessage() + "]");
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "CancelReserved - WebMethod doExecution =[" + e.getMessage() + "]");
		}
		
		return Response.status(Status.OK).entity(entity).build();
    }
	
	/**
	 * Metodo reponsavel por valdiar as informaç~çoes do resourceFacingService
	 * para reserva, a unica informação necessaria no resourceFacingService e a
	 * informação do terminal de 15 (ServiceID)
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	protected boolean validateServiceDescribedBy(List<ServiceDescribedBy> serviceDescribedByList, String value) throws OSSBusinessException {

		Optional<List<ServiceDescribedBy>> serviceDescribe = Optional.ofNullable(serviceDescribedByList);

		if(Optional.ofNullable(serviceDescribe.get()).map(List::size).orElse(0) == 0){
			logger.log(OSSLogger.ERROR, "Erro ao validar o objeto ResourceInventoryEntity" + ":" + "TERUS-001" + ":" + "O tamanho da lista serviceDescribedBy eh 0");
		    return false;
		}
			
		for (ServiceDescribedBy serviceDescribedBy : serviceDescribe.get()) {

			Optional<ServiceDescribedBy> name = Optional.ofNullable(serviceDescribedBy);

			if(name.map(ServiceDescribedBy::getName).filter(d -> d.equalsIgnoreCase(value)).isPresent()){

				for (ServiceSpecCharDescribes serviceSpecCharDescribe : serviceDescribedBy.getServiceSpecCharDescribes()) {

					Optional<ServiceSpecCharDescribes> resourceServiceSpecCharDescribe = Optional.ofNullable(serviceSpecCharDescribe);

					if(!resourceServiceSpecCharDescribe.map(ServiceSpecCharDescribes::getValue).filter(d -> !d.isEmpty()).isPresent()){
						logger.log(OSSLogger.ERROR, "Erro ao validar o objeto ResourceInventoryEntity" + ":" + "TERUS-001" + ":" + "O valor do campo serviceDescribedBy.serviceSpecCharDescribes.value eh nulo");
					    return false;
					}
						
					serviceDescribedBy.getServiceSpecCharDescribes().clear();
					serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribe);
					break;
				}

			}
		}
		
		return true;
	}

}
