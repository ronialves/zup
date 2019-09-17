package com.tlf.oss.resourceinventory.osp.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

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
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPCode;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.enums.TypeProductVoice;
import com.tlf.oss.resourceinventory.osp.core.mapper.OspRequestMapper;
import com.tlf.oss.resourceinventory.osp.core.service.FacilityResourceService;
import com.tlf.oss.resourceinventory.osp.core.service.ReservationService;
import com.tlf.oss.resourceinventory.osp.core.validation.Reserve;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class ReservationController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	protected ReservationService reservationService;

	@Inject
	private ReservationGponController reservationGponController;

	@Inject
	private FacilityResourceService facilityResource;
	
	private final static String VALIDATION_MESSAGE = "Erro ao validar o objeto ResourceInventoryEntity";
	
	public ResourceInventoryEntity doExecution(@Reserve(message=ReservationController.VALIDATION_MESSAGE) ResourceInventoryEntity entity) throws OSSBusinessException {

		validateRequest(entity);

		if (isGpon(entity)) {
			logger.log(OSSLogger.INFO, "ReservationOrch - GPON");
			resourceFacilityGPON(entity);
		} else {			
			logger.log(OSSLogger.INFO, "ReservationOrch - METALLIC");
			reservation(entity);
		}
		
		return entity;
	}

	private ReserveResourceRequest createReserveRequest(ResourceInventoryEntity entity) throws OSSBusinessException {

		ReserveResourceRequest reserveResourceRequest = new ReserveResourceRequest();
		reserveResourceRequest.setAddress(OspRequestMapper.parseReserveAddress(entity.getAddress()));
		reserveResourceRequest.setReserveOrder(getNRC(entity));
		reserveResourceRequest.setServiceType(TypeProductVoice.LIRA.getTypes());
		reserveResourceRequest.setCircuitType(CircuitTypeEnum
				.parse(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology()));

		return reserveResourceRequest;
	}

	private ReportResourceProvisioningRequest createResourceProvisioningReserveRequest(ResourceInventoryEntity entity)
			throws OSSBusinessException {
		ReportResourceProvisioningRequest reportResourceProvisioningRequest = new ReportResourceProvisioningRequest();

		reportResourceProvisioningRequest
		.setAddress(OspRequestMapper.parseResourceProvisioningReserveAddress(entity.getAddress()));
		reportResourceProvisioningRequest.setReserveOrder(getNRC(entity));
		reportResourceProvisioningRequest.setCircuitType(CircuitTypeEnum
				.parse(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology()));

		return reportResourceProvisioningRequest;
	}

	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc = getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	private void updateEntity(ReserveResourceResponse response, ResourceInventoryEntity entity) throws OSSBusinessException {

		if (response.getInformations() == null) {
			return;
		}

		Cabinet cabinet = entity.getCabinet() == null ? new Cabinet() : entity.getCabinet();

		TerminalBox terminalBox = (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null)
				? entity.getCabinet().getTerminalBox() : new TerminalBox();

				List<Informations> informations = new ArrayList<>();

				if (response.getInformations() != null && !response.getInformations().isEmpty()) {
					informations = response.getInformations();
				}

				if (informations != null && !informations.isEmpty()) {
					informations.forEach(info -> {

						List<Circuit> circuits = new ArrayList<>();
						if (info.getRelatedCircuits().getCircuit() != null
								&& !info.getRelatedCircuits().getCircuit().isEmpty()) {
							circuits = info.getRelatedCircuits().getCircuit();
						}

						if (circuits != null && !circuits.isEmpty()) {
							circuits.forEach(circuit -> {
								List<InicialResource> inicialResources = new ArrayList<>();

								if (circuit.getResources().getRelatedInicialResources() != null
										&& !circuit.getResources().getRelatedInicialResources().isEmpty()) {
									inicialResources = circuit.getResources().getRelatedInicialResources();
								}

								if (inicialResources != null && !inicialResources.isEmpty()) {
									inicialResources.forEach(inicialResource -> {
										terminalBox.setCableNumber(inicialResource.getInitialLogicalCable().getCode() != null
												? inicialResource.getInitialLogicalCable().getCode() : null);
										terminalBox.setSideCableNumber(
												inicialResource.getInitialLogicalCable().getLateral() != null
												? inicialResource.getInitialLogicalCable().getLateral() : null);
										cabinet.setTerminalBox(terminalBox);
									});
								}

								List<TerminalResource> terminalResources = new ArrayList<>();
								if (circuit.getResources().getRelatedTerminalResources() != null
										&& !circuit.getResources().getRelatedTerminalResources().isEmpty()) {
									terminalResources = circuit.getResources().getRelatedTerminalResources();
								}

								if (terminalResources != null && !terminalResources.isEmpty()) {
									terminalResources.forEach(terminalResource -> {
										terminalBox.setId(terminalResource.getTerminalResource().getCode() != null
												? terminalResource.getTerminalResource().getCode() : null);
										cabinet.setTerminalBox(terminalBox);

										cabinet.setName(terminalResource.getTerminalLogicalCable().getCode());
									});
								}
							});
						}
					});
				}
				entity.setCabinet(cabinet);
				entity.getCabinet().setTerminalBox(terminalBox);
	}

	private void updateEntity(ReportResourceProvisioningResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (response.getInformations() == null) {
			return;
		}

		Cabinet c = entity.getCabinet() == null ? new Cabinet() : entity.getCabinet();

		PhysicalLink p = (entity.getAddress() != null && entity.getAddress().getPlacePhysicalResourceAssoc() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null)
				? entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() : new PhysicalLink();

				TerminalBox terminalBox = (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null)
						? entity.getCabinet().getTerminalBox() : new TerminalBox();

						List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations> informations = new ArrayList<>();

						if (response.getInformations() != null && !response.getInformations().isEmpty()) {
							informations = response.getInformations();
						}

						if (informations != null && !informations.isEmpty()) {
							informations.forEach(info -> {

								if ("1".equals(info.getCircuitType())) {
									p.setAccessTechnology("METALICO");
								}

								List<CircuitReport> circuits = new ArrayList<>();
								if (info.getRelatedCircuits().getCircuit() != null
										&& !info.getRelatedCircuits().getCircuit().isEmpty()) {
									circuits = info.getRelatedCircuits().getCircuit();
								}

								if (circuits != null && !circuits.isEmpty()) {
									circuits.forEach(circuit -> {
										List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource> inicialResources = new ArrayList<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource>();
										if (circuit.getResources().getRelatedInicialResources() != null
												&& !circuit.getResources().getRelatedInicialResources().isEmpty()) {
											inicialResources = circuit.getResources().getRelatedInicialResources();
										}

										if (inicialResources != null && !inicialResources.isEmpty()) {
											inicialResources.forEach(inicialResource -> {
												terminalBox.setCableNumber(inicialResource.getInitialLogicalCable().getCode() != null
														? inicialResource.getInitialLogicalCable().getCode() : null);
												terminalBox.setSideCableNumber(
														inicialResource.getInitialLogicalCable().getLateral() != null
														? inicialResource.getInitialLogicalCable().getLateral() : null);
												c.setTerminalBox(terminalBox);
											});
										}

										List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryResource> intermediaryResources = new ArrayList<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryResource>();
										if (circuit.getResources().getRelatedIntermediaryResources() != null
												&& !circuit.getResources().getRelatedIntermediaryResources().isEmpty()) {
											intermediaryResources = circuit.getResources().getRelatedIntermediaryResources();
										}

										if (intermediaryResources != null && !intermediaryResources.isEmpty()) {
											intermediaryResources.forEach(intermediaryResource -> {
												c.setName(intermediaryResource.getIntermediaryResource().getCode() != null
														? intermediaryResource.getIntermediaryResource().getCode() : null);
											});
										}

										List<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource> terminalResources = new ArrayList<com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource>();
										if (circuit.getResources().getRelatedTerminalResources() != null
												&& !circuit.getResources().getRelatedTerminalResources().isEmpty()) {
											terminalResources = circuit.getResources().getRelatedTerminalResources();
										}

										if (terminalResources != null && !terminalResources.isEmpty()) {
											terminalResources.forEach(terminalResource -> {
												terminalBox.setId(terminalResource.getTerminalResource().getCode() != null
														? terminalResource.getTerminalResource().getCode() : null);
												c.setTerminalBox(terminalBox);
												
												c.setName(terminalResource.getTerminalLogicalCable().getCode());
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

	public ResourceInventoryEntity reservation(ResourceInventoryEntity entity) throws OSSBusinessException {

		WsContext headerContext = new WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		try {
			ReserveResourceResponse response = null;
			ReserveResourceRequest request = createReserveRequest(entity);

			response = reservationService.reserveResource(request, headerContext);
			validateCircuitActive(response, entity);


		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {
			logger.error(Message.ERRO_CONSULTAR_RECURSO.getValue(), e);
			if (e instanceof TimeoutException) {
				throw new OSSBusinessException(Message.ERRO_CONSULTAR_RECURSO.getValue(), Code.RIOSP_002.getValue(),
						Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
			}
			throw new OSSBusinessException(Message.ERRO_CONSULTAR_RECURSO.getValue(), Code.RIOSP_002.getValue(),
					e.getMessage());
		}
		return entity;
	}

	private ResourceInventoryEntity distributeResourceProvisioningReports(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext headerContext = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		try {
			ReportResourceProvisioningRequest request = createResourceProvisioningReserveRequest(entity);
			ReportResourceProvisioningResponse response = reservationService.distributeResourceProvisioningReports(request, headerContext);

			if (response.getResult() != null && response.getResult().getCode() == 0) {
				updateEntity(response, entity);
			} else {
				throw new OSSBusinessException("Ordem de Reserva ja existente.", String.valueOf("2"),
						String.valueOf("532"));

			}
		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {
			logger.error("Erro ao reservar o recurso", e);
			if (e instanceof TimeoutException) {
				throw new OSSBusinessException(Message.ERRO_RESERVAR_RECURSO.getValue(), Code.RIOSP_002.getValue(),
						Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
			}
			throw new OSSBusinessException(Message.ERRO_RESERVAR_RECURSO.getValue(), Code.RIOSP_002.getValue(),
					e.getMessage());
		}
		return entity;
	}

	private void validateCircuitActive(ReserveResourceResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (response.getResult() != null && response.getResult().getCode() != 0
				&& response.getResult().getErrorCode() != null && response.getResult().getErrorCode() != 532) {
			throw new OSSBusinessException(response.getResult().getDescription(),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}

		if (response.getResult() != null && response.getResult().getErrorCode() != null
				&& response.getResult().getErrorCode() == 532) {
			distributeResourceProvisioningReports(entity);
		} else {
			updateEntity(response, entity);
		}
	}

	private void resourceFacilityGPON(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		ReportResourceProvisioningResponse provisioningResponse;
		try {
			provisioningResponse = facilityResource.gponDistributeResourceProvisioningReports(entity);
			logger.log(OSSLogger.INFO, "Resultado da Consulta de Facilidades: " + provisioningResponse.getResult().getCode());
		} catch (Exception exception) {
			throw OssBusinessExceptionFactory.getOSSBusinessException(exception, OSPWSName.ReportResourceProvisioning);
		}
			
		if (provisioningResponse != null 
				&& provisioningResponse.getResult() != null
				&& 0 == provisioningResponse.getResult().getCode()) {
			updateEntity(provisioningResponse, entity);
		} else {
			reservationGponController.reservation(entity);
		} 
	}

	private void validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {

		Optional<BrazilianUrbanPropertyAddress> optionalBrazilianUrbanPropertyAddress = Optional
				.ofNullable(entity.getAddress());

		Optional<ResourceFacingService> resourceFacingService = Optional.ofNullable(entity.getResourceFacingService());

		if (optionalBrazilianUrbanPropertyAddress.isPresent()) {

			if (!optionalBrazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getCnl)
					.filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", Code.RIOSP_001.getValue(),
						"O valor do campo cnl é nulo");
			}
			if (!optionalBrazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getTelephonicArea)
					.filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", Code.RIOSP_001.getValue(),
						"O valor do campo telephonicArea é nulo");
			}
			if (!optionalBrazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getStreetCode)
					.filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", Code.RIOSP_001.getValue(),
						"O valor do campo streetCode é nulo");
			}
			if (!optionalBrazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getStreetNrFirst)
					.filter(d -> !d.isEmpty()).isPresent()) {
				throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", Code.RIOSP_001.getValue(),
						"O valor do campo streetNrFirst é nulo");
			}
			if (!optionalBrazilianUrbanPropertyAddress.map(BrazilianUrbanPropertyAddress::getPlacePhysicalResourceAssoc)
					.filter(d -> !d.getPhysicalLink().getAccessTechnology().isEmpty()).isPresent()) {
				throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", Code.RIOSP_001.getValue(),
						"O valor do campo address.placePhysicalResourceAssoc.physicalLink.accessTechnology é nulo");
			}
		} else {
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", Code.RIOSP_001.getValue(),
					"O valor do campo brazilianUrbanPropertyAddress é nulo");
		}

		if(!resourceFacingService.isPresent())
			throw new OSSBusinessException("Erro ao validar o objeto ResourceInventoryEntity", Code.RIOSP_001.getValue(), "O valor do campo resourceFacingService eh nulo");
	}
}