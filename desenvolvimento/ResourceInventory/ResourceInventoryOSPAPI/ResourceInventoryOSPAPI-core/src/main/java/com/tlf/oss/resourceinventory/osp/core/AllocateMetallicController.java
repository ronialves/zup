package com.tlf.oss.resourceinventory.osp.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuitlottypes.CircuitLotAllocate;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.intermediaryresourcetypes.IntermediaryResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceserviceinfotypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationallocatetypes.SupplementaryInformationIn;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.service.AllocateService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class AllocateMetallicController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	protected AllocateService allocateService;

	public ResourceInventoryEntity allocate(ResourceInventoryEntity entity) throws OSSBusinessException {

		WsContext headerContext = new WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		AllocateInstallResourceRequest request = createRequest(entity);

		try {
			AllocateInstallResourceResponse allocateInstallResourceResponse = allocateService.allocateResource(request,
					headerContext);

			updateEntity(allocateInstallResourceResponse, entity);

		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {
			if (e instanceof TimeoutException) {
				throw new OSSBusinessException(Message.ERRO_ALOCAR_RECURSO_EXTERNO.getValue(),
						Code.RIOSP_002.getValue(), Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
			}

			throw new OSSBusinessException(Message.ERRO_ALOCAR_RECURSO_EXTERNO.getValue(), Code.RIOSP_002.getValue(),
					e.getMessage());
		}
		return entity;
	}

	private AllocateInstallResourceRequest createRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		AllocateInstallResourceRequest allocateInstallResourceRequest = new AllocateInstallResourceRequest();
		// NRC
		allocateInstallResourceRequest.setReserveOrder(getNRC(entity));
		allocateInstallResourceRequest.setSupplementaryInformation(new SupplementaryInformationIn());
		allocateInstallResourceRequest.getSupplementaryInformation().setResourceService(new ResourceService());
		// Terminal
		allocateInstallResourceRequest.getSupplementaryInformation().getResourceService()
				.setIdentifier(getNetworkOwnerID(entity));
		allocateInstallResourceRequest.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());

		if ("METALICO"
				.equals(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology())) {
			allocateInstallResourceRequest.setCircuitType("1");
		}
		return allocateInstallResourceRequest;
	}

	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc = getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	private void updateEntity(AllocateInstallResourceResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw new OSSBusinessException(String.valueOf(response.getResult().getDescription()),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}

		PhysicalLink physicalLink = (entity.getAddress() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null)
						? entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() : new PhysicalLink();

		Cabinet cabinet = entity.getCabinet() != null ? entity.getCabinet() : new Cabinet();

		TerminalBox terminalBox = (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null)
				? entity.getCabinet().getTerminalBox() : new TerminalBox();

		response.getInformations().forEach(info -> {

			physicalLink.setAccessTechnology(info.getCircuitType());

			List<CircuitLotAllocate> circuits = new ArrayList<>();
			if (info.getRelatedCircuits().getCircuit() != null && !info.getRelatedCircuits().getCircuit().isEmpty()) {
				circuits = info.getRelatedCircuits().getCircuit();
			}

			if (circuits != null && !circuits.isEmpty()) {
				circuits.forEach(circuit -> {

					getRelatedInicialResources(cabinet, terminalBox, circuit);

					getRelatedIntermediaryResources(cabinet, circuit);

					getRelatedTerminalResources(cabinet, terminalBox, circuit);
				});
			}
		});

		entity.setCabinet(cabinet);
		entity.getCabinet().setTerminalBox(terminalBox);
	}

	private void getRelatedInicialResources(Cabinet cabinet, TerminalBox terminalBox, CircuitLotAllocate circuit) {
		List<InicialResource> inicialResources = new ArrayList<>();

		if (circuit.getResources() != null && (circuit.getResources().getRelatedInicialResources() != null
				&& !circuit.getResources().getRelatedInicialResources().isEmpty())) {
			inicialResources = circuit.getResources().getRelatedInicialResources();
		}

		if (inicialResources != null && !inicialResources.isEmpty()) {
			inicialResources.forEach(inicialResource -> {
				terminalBox.setCableNumber(inicialResource.getInitialLogicalCable().getCode() != null
						? inicialResource.getInitialLogicalCable().getCode() : null);
				terminalBox.setSideCableNumber(inicialResource.getInitialLogicalCable().getLateral() != null
						? inicialResource.getInitialLogicalCable().getLateral() : null);
				cabinet.setTerminalBox(terminalBox);
			});
		}
	}

	private void getRelatedIntermediaryResources(Cabinet cabinet, CircuitLotAllocate circuit) {
		List<IntermediaryResource> intermediaryResources = new ArrayList<>();
		if (circuit.getResources() != null && (circuit.getResources().getRelatedIntermediaryResources() != null
				&& !circuit.getResources().getRelatedIntermediaryResources().isEmpty())) {
			intermediaryResources = circuit.getResources().getRelatedIntermediaryResources();
		}

		if (intermediaryResources != null && !intermediaryResources.isEmpty()) {
			intermediaryResources.forEach(intermediaryResource -> cabinet
					.setName(intermediaryResource.getIntermediaryResource().getCode() != null
							? intermediaryResource.getIntermediaryResource().getCode() : null));
		}
	}

	private void getRelatedTerminalResources(Cabinet cabinet, TerminalBox terminalBox, CircuitLotAllocate circuit) {
		List<TerminalResource> terminalResources = new ArrayList<>();
		if (circuit.getResources() != null && (circuit.getResources().getRelatedTerminalResources() != null
				&& !circuit.getResources().getRelatedTerminalResources().isEmpty())) {
			terminalResources = circuit.getResources().getRelatedTerminalResources();
		}

		if (terminalResources != null && !terminalResources.isEmpty()) {
			terminalResources.forEach(terminalResource -> {
				terminalBox.setId(terminalResource.getTerminalResource().getCode() != null
						? terminalResource.getTerminalResource().getCode() : null);
				cabinet.setTerminalBox(terminalBox);
			});
		}
	}
}