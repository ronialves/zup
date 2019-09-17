package com.tlf.oss.resourceinventory.osp.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.intermediaryresourcetypes.IntermediaryResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.enums.TypeProductVoice;
import com.tlf.oss.resourceinventory.osp.core.mapper.OspRequestMapper;
import com.tlf.oss.resourceinventory.osp.core.service.ReservationService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class ReservationGponController extends ValidatorEntity{

	@Inject
	protected OSSLogger logger;

	@Inject
	protected ReservationService reservationService;
	
	private ReserveResourceRequest createReserveRequest(ResourceInventoryEntity entity) throws OSSBusinessException{

		ReserveResourceRequest reserveResourceRequest = new ReserveResourceRequest();
		reserveResourceRequest.setAddress(OspRequestMapper.parseAddress(entity.getAddress()));
		reserveResourceRequest.setReserveOrder(getNRC(entity));
		reserveResourceRequest.setServiceType(TypeProductVoice.LIRA.getTypes());
		reserveResourceRequest.setCircuitType(CircuitTypeEnum.parse(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology()));
		reserveResourceRequest.setCircuitId(getServiceID(entity));

		return reserveResourceRequest;
	}
	
	private ReportResourceProvisioningRequest createResourceProvisioningReserveRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		ReportResourceProvisioningRequest reportResourceProvisioningRequest = new ReportResourceProvisioningRequest();

		reportResourceProvisioningRequest.setAddress(OspRequestMapper.parseResourceProvisioningReserveAddress(entity.getAddress()));
		reportResourceProvisioningRequest.setReserveOrder(getNRC(entity));
		reportResourceProvisioningRequest.setCircuitType(CircuitTypeEnum.parse(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology()));

		return reportResourceProvisioningRequest;
	}
	
	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc= getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	private String getServiceID(ResourceInventoryEntity entity) throws OSSBusinessException{
		//Metodo executado apenas para cenario Gpon
		Optional<String> serviceID = Optional.ofNullable(entity.getResourceFacingService().getServiceId());
		if(serviceID.filter(d -> d.isEmpty()).isPresent()){
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", Code.RIOSP_001.getValue(), "O valor do campo serviceId eh nulo");
		}

		return serviceID.get();
	}

	

	private void updateEntity(ReserveResourceResponse response, ResourceInventoryEntity entity) throws OSSBusinessException {

		if (response.getInformations() == null) {
			return;
		}

		Cabinet c = entity.getCabinet()==null?new Cabinet():entity.getCabinet();

		TerminalBox terminalBox = (entity.getCabinet()!=null && entity.getCabinet().getTerminalBox()!=null) ? entity.getCabinet().getTerminalBox() : new TerminalBox();

		List<Informations> informations = new ArrayList<>();

		if (response.getInformations() != null && !response.getInformations().isEmpty()) {
			informations = response.getInformations();
		}

		if (informations != null && !informations.isEmpty()) {
			informations.forEach(info -> {

				List<Circuit> circuits = new ArrayList<>();
				if (info.getRelatedCircuits().getCircuit() != null && !info.getRelatedCircuits().getCircuit().isEmpty()) {
					circuits = info.getRelatedCircuits().getCircuit();
				}

				if (circuits != null && !circuits.isEmpty()) {
					circuits.forEach(circuit -> {
						List<InicialResource> inicialResources = new ArrayList<>();

						if (circuit.getResources().getRelatedInicialResources() != null && !circuit.getResources().getRelatedInicialResources().isEmpty()) {
							inicialResources = circuit.getResources().getRelatedInicialResources();
						}
						
						if (inicialResources != null && !inicialResources.isEmpty()) {
							inicialResources.forEach(inicialResource -> {
									c.setPrimaryCable(inicialResource.getInitialLogicalCable().getCode() != null ? inicialResource.getInitialLogicalCable().getCode() : null);
									c.setPrimaryFiber(String.valueOf(inicialResource.getInitialLogicalCable().getLogicalUnit()) != null ? String.valueOf(inicialResource.getInitialLogicalCable().getLogicalUnit()) : null);
							});
						}

						List<IntermediaryResource> intermediaryResources = new ArrayList<>();
						if (circuit.getResources().getRelatedIntermediaryResources() != null && !circuit.getResources().getRelatedIntermediaryResources().isEmpty()) {
							intermediaryResources = circuit.getResources().getRelatedIntermediaryResources();
						}

						if (intermediaryResources != null && !intermediaryResources.isEmpty()) {
							intermediaryResources.forEach(intermediaryResource -> {
								c.setName(intermediaryResource.getIntermediaryResource().getCode() != null
										? intermediaryResource.getIntermediaryResource().getCode() : null);
							});
						}

						List<TerminalResource> terminalResources = new ArrayList<>();
						if (circuit.getResources().getRelatedTerminalResources() != null && !circuit.getResources().getRelatedTerminalResources().isEmpty()) {
							terminalResources = circuit.getResources().getRelatedTerminalResources();
						}

						if (terminalResources != null && !terminalResources.isEmpty()) {
							terminalResources.forEach(terminalResource -> {
								terminalBox.setId(terminalResource.getTerminalResource().getCode() != null
										? terminalResource.getTerminalResource().getCode() : null);
								c.setTerminalBox(terminalBox);
							});
						}
					});
				}
			});
		}
		entity.setCabinet(c);
		entity.getCabinet().setTerminalBox(terminalBox);
	}

	private void updateEntity(ReportResourceProvisioningResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (response.getInformations() == null) {
			return;
		}

		Cabinet c = entity.getCabinet()==null?new Cabinet():entity.getCabinet();

		PhysicalLink p = (entity.getAddress()!=null 
				&& entity.getAddress().getPlacePhysicalResourceAssoc()!=null 
				&& entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink()!=null) ? entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() : new PhysicalLink();

				TerminalBox terminalBox = (entity.getCabinet()!=null && entity.getCabinet().getTerminalBox()!=null) ? entity.getCabinet().getTerminalBox() : new TerminalBox();

				List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations> informations = new ArrayList<>();

				if (response.getInformations() != null && !response.getInformations().isEmpty()) {
					informations = response.getInformations();
				}

				if (informations != null && !informations.isEmpty()) {
					informations.forEach(info -> {

						if ("2".equals(info.getCircuitType())) {
							p.setAccessTechnology("GPON");
						}

						List<CircuitReport> circuits = new ArrayList<>();
						if (info.getRelatedCircuits().getCircuit() != null && !info.getRelatedCircuits().getCircuit().isEmpty()) {
							circuits = info.getRelatedCircuits().getCircuit();
						}

						if (circuits != null && !circuits.isEmpty()) {
							circuits.forEach(circuit -> {
								List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource> inicialResources = new ArrayList<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource>();
								if (circuit.getResources().getRelatedInicialResources() != null && !circuit.getResources().getRelatedInicialResources().isEmpty()) {
									inicialResources = circuit.getResources().getRelatedInicialResources();
								}

								//valida retorno GPON
								getInitialLogicalCableFacility(entity, inicialResources, terminalBox, c);

								List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryResource> intermediaryResources = new ArrayList<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryResource>();
								if (circuit.getResources().getRelatedIntermediaryResources() != null && !circuit.getResources().getRelatedIntermediaryResources().isEmpty()) {
									intermediaryResources = circuit.getResources().getRelatedIntermediaryResources();
								}

								if (intermediaryResources != null && !intermediaryResources.isEmpty()) {
									intermediaryResources.forEach(intermediaryResource -> {
										c.setName(intermediaryResource.getIntermediaryResource().getCode() != null
												? intermediaryResource.getIntermediaryResource().getCode() : null);
									});
								}

								List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource> terminalResources = new ArrayList<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource>();
								if (circuit.getResources().getRelatedTerminalResources() != null && !circuit.getResources().getRelatedTerminalResources().isEmpty()) {
									terminalResources = circuit.getResources().getRelatedTerminalResources();
								}

								if (terminalResources != null && !terminalResources.isEmpty()) {
									terminalResources.forEach(terminalResource -> {
										terminalBox.setId(terminalResource.getTerminalResource().getCode() != null
												? terminalResource.getTerminalResource().getCode() : null);
										c.setTerminalBox(terminalBox);
									});
								}
							});
						}
					});
				}
				entity.setCabinet(c);
				entity.getPhysicalLinks().add(p);
				entity.getCabinet().setTerminalBox(terminalBox);
	}
	
	/**
	 * Metodo responsavel por mapear retorno
	 * Response: GPON = setPrimaryCable e setPrimaryFiber
	 * Para consulta facilidade é usado outro WSDL, por isso é validado o mesmo objeto importado de pacotes diferentes 
	 * @param entity
	 * @param inicialResources
	 * @param terminalBox
	 * @param cabinet
	 */
	private void getInitialLogicalCableFacility(ResourceInventoryEntity entity, List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource> inicialResourcesFacility,TerminalBox terminalBox,Cabinet cabinet){

		if (inicialResourcesFacility !=null && !inicialResourcesFacility.isEmpty()) {
			inicialResourcesFacility.forEach(inicialResource -> {
				//Valida a tecnologia GPON
					cabinet.setPrimaryCable(inicialResource.getInitialLogicalCable().getCode() != null ? inicialResource.getInitialLogicalCable().getCode() : null);
					cabinet.setPrimaryFiber(String.valueOf(inicialResource.getInitialLogicalCable().getLogicalUnit()) != null ? String.valueOf(inicialResource.getInitialLogicalCable().getLogicalUnit()) : null);
			});
		}

	}

	public ResourceInventoryEntity reservation(ResourceInventoryEntity entity) throws OSSBusinessException {

		WsContext headerContext = new WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		ReserveResourceResponse response = null;
		final OSPWSName operationName = OSPWSName.AllocateInstallResource;
		try {

			ReserveResourceRequest request = createReserveRequest(entity);					
			response = reservationService.reserveResource(request, headerContext); 

			if (response.getResult() != null
                    && response.getResult().getCode() != 0
                    && response.getResult().getErrorCode() != null
                    && response.getResult().getErrorCode() != 532) {
 
                logger.log(OSSLogger.ERROR, "OSP Code: " + response.getResult().getCode());
                logger.log(OSSLogger.ERROR, "OSP Description: " + response.getResult().getDescription());
                logger.log(OSSLogger.ERROR, "OSP ErrorCode: " + response.getResult().getErrorCode());
				
                throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(String.valueOf(response.getResult().getErrorCode()), response.getResult().getDescription(), operationName);
            }

			if (response.getResult() != null 
					&& response.getResult().getErrorCode() != null 
					&& response.getResult().getErrorCode() == 532) {
				entity = distributeResourceProvisioningReports(entity);
			} else {
				updateEntity(response, entity);
			}

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, operationName);
		}

		return entity;
	}

	private ResourceInventoryEntity distributeResourceProvisioningReports(ResourceInventoryEntity entity) throws OSSBusinessException{

		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext headerContext = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());
		
		final OSPWSName operationName = OSPWSName.ReportResourceProvisioning;

		try {

			ReportResourceProvisioningRequest request = createResourceProvisioningReserveRequest(entity);		
			ReportResourceProvisioningResponse response = reservationService.distributeResourceProvisioningReports(request, headerContext);  

			if (response.getResult() != null && response.getResult().getCode() == 0) {
				updateEntity(response, entity);
			} else {
				throw OssBusinessExceptionFactory.getFalloutOSSBusinessException("532", "Ordem de Reserva já existente.", operationName);
			}
		} catch (Exception e) {
			logger.error("Erro ao reservar o recurso", e);
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, operationName);
		}

		return entity;
	}

}