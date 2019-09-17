package com.tlf.oss.resourceinventory.osp.core;

import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.servicetypes.Service;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.TerminalBoxTypeStrategy;
import com.tlf.oss.resourceinventory.osp.core.mapper.OspRequestMapper;
import com.tlf.oss.resourceinventory.osp.core.service.FacilityResourceService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class FacilityResourceMetallicController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	protected FacilityResourceService facilityResourceService;

	private ReportResourceProvisioningRequest createRequest(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		ReportResourceProvisioningRequest reportResourceProvisioningRequest = new ReportResourceProvisioningRequest();

		if ((entity.getCustomerOrder().getPurchaseOrderNumber() != null
				&& !entity.getCustomerOrder().getPurchaseOrderNumber().equalsIgnoreCase(""))
				&& (entity.getResourceFacingService() != null && !getNetworkOwnerID(entity).equalsIgnoreCase(""))) {

			Service service = new Service();
			service.setIdentifier(getNetworkOwnerID(entity));
			reportResourceProvisioningRequest.setService(service);

		} else {

			reportResourceProvisioningRequest.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());
			if (entity.getResourceFacingService() != null) {
				Service service = new Service();
				service.setIdentifier(getNetworkOwnerID(entity));
				reportResourceProvisioningRequest.setService(service);
			}

		}

		reportResourceProvisioningRequest.setAddress(OspRequestMapper.parseReserveFacilityAddress(entity.getAddress()));

		if (entity.getAddress().getPlacePhysicalResourceAssoc() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null && "METALICO".equals(
						entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology())) {
			reportResourceProvisioningRequest.setCircuitType("1");
		}

		return reportResourceProvisioningRequest;
	}

	private ReportResourceProvisioningRequest createRequestNRC(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		ReportResourceProvisioningRequest reportResourceProvisioningRequest = new ReportResourceProvisioningRequest();

		if ((entity.getCustomerOrder().getPurchaseOrderNumber() != null
				&& !entity.getCustomerOrder().getPurchaseOrderNumber().equalsIgnoreCase(""))
				&& (entity.getResourceFacingService() != null && !getNRC(entity).equalsIgnoreCase(""))) {

			reportResourceProvisioningRequest.setReserveOrder(getNRC(entity));

		} else {

			reportResourceProvisioningRequest.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());
			if (entity.getResourceFacingService() != null) {
				reportResourceProvisioningRequest.setResourceOrder(getNRC(entity));
			}

		}
		
		reportResourceProvisioningRequest.setAddress(OspRequestMapper.parseReserveFacilityAddress(entity.getAddress()));

		if (entity.getAddress().getPlacePhysicalResourceAssoc() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null && "METALICO".equals(
						entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology())) {
			reportResourceProvisioningRequest.setCircuitType("1");
		}

		return reportResourceProvisioningRequest;
	}

	private void updateEntity(ReportResourceProvisioningResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw new OSSBusinessException(response.getResult().getDescription(),
					String.valueOf(response.getResult().getCode()),
					String.valueOf(response.getResult().getErrorCode()));
		}

		PhysicalLink physicalLink = new PhysicalLink();
		Circuit circuitRet = new Circuit();

		if (entity.getCircuit() != null) {
			circuitRet = entity.getCircuit();
		}

		Cabinet cabinet = new Cabinet();
		if (entity.getCabinet() != null) {
			cabinet = entity.getCabinet();
		}

		TerminalBox terminalBox = new TerminalBox();
		if (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null) {
			terminalBox = entity.getCabinet().getTerminalBox();
		}

		BrazilianUrbanPropertyAddress bupAddress = new BrazilianUrbanPropertyAddress();
		if (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null
				&& entity.getCabinet().getTerminalBox().getAddress() != null) {
			bupAddress = entity.getCabinet().getTerminalBox().getAddress();
		}

		if (response.getInformations() != null && !response.getInformations().isEmpty()) {

			for (int countInformation = 0; countInformation < response.getInformations().size(); countInformation++) {
				Informations info = response.getInformations().get(countInformation);

				physicalLink.setAccessTechnology(info.getCircuitType());

				getRelatedCircuits(circuitRet, cabinet, terminalBox, bupAddress, info);
			}
		}

		entity.setCircuit(circuitRet);
		entity.getPhysicalLinks().add(physicalLink);
		entity.setCabinet(cabinet);
	}

	private void getRelatedCircuits(Circuit circuitRet, Cabinet cabinet, TerminalBox terminalBox,
			BrazilianUrbanPropertyAddress bupAddress, Informations info) {
		if (info.getRelatedCircuits() != null && (info.getRelatedCircuits().getCircuit() != null
				&& !info.getRelatedCircuits().getCircuit().isEmpty())) {

			for (int countCircuit = 0; countCircuit < info.getRelatedCircuits().getCircuit().size(); countCircuit++) {
				CircuitReport circuit = info.getRelatedCircuits().getCircuit().get(countCircuit);
				circuitRet.setId(circuit.getCircuitIdentifier());

				getRelatedInicialResources(cabinet, terminalBox, circuit);

				getRelatedIntermediaryResources(cabinet, circuit);

				getRelatedTerminalResources(cabinet, terminalBox, bupAddress, circuit);
			}
		}
	}

	private void getRelatedInicialResources(Cabinet cabinet, TerminalBox terminalBox, CircuitReport circuit) {
		if (circuit.getResources() != null && (circuit.getResources().getRelatedInicialResources() != null
				&& !circuit.getResources().getRelatedInicialResources().isEmpty())) {

			for (int countInicialResources = 0; countInicialResources < circuit.getResources()
					.getRelatedInicialResources().size(); countInicialResources++) {
				InicialResource inicialResource = circuit.getResources().getRelatedInicialResources()
						.get(countInicialResources);

				cabinet.setFeederCable(inicialResource.getInitialLogicalCable().getCode() != null
						? inicialResource.getInitialLogicalCable().getCode() : null);
				cabinet.setFeederSideCable(inicialResource.getInitialLogicalCable().getLateral() != null
						? inicialResource.getInitialLogicalCable().getLateral() : null);
				cabinet.setFeederPair(inicialResource.getInitialLogicalCable().getLogicalUnit() != 0
						? inicialResource.getInitialLogicalCable().getLogicalUnit().toString() : "0");

				cabinet.setTerminalBox(terminalBox);
			}
		}
	}

	private void getRelatedIntermediaryResources(Cabinet cabinet, CircuitReport circuit) {
		if (circuit.getResources() != null && (circuit.getResources().getRelatedIntermediaryResources() != null
				&& !circuit.getResources().getRelatedIntermediaryResources().isEmpty())) {
			List<IntermediaryResource> intermediaryResources = circuit.getResources().getRelatedIntermediaryResources();

			if (intermediaryResources != null && !intermediaryResources.isEmpty()) {
				for (int countIntermediaryResource = 0; countIntermediaryResource < intermediaryResources
						.size(); countIntermediaryResource++) {
					IntermediaryResource intermediaryResource = intermediaryResources.get(countIntermediaryResource);
					cabinet.setName(intermediaryResource.getIntermediaryResource().getCode() != null
							? intermediaryResource.getIntermediaryResource().getCode() : null);
					final BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
					address.setStreetType(
							intermediaryResource.getIntermediaryResource().getResourceCharacterist().getStreetType());
					address.setStreetName(
							intermediaryResource.getIntermediaryResource().getResourceCharacterist().getStreetName());
					address.setStreetCode(
							intermediaryResource.getIntermediaryResource().getResourceCharacterist().getStreetCode());
					address.setStreetNrFirst(
							intermediaryResource.getIntermediaryResource().getResourceCharacterist().getStreetNumber());
					cabinet.setBrazilianUrbanPropertyAddress(address);
				}
			}
		}
	}

	private void getRelatedTerminalResources(Cabinet cabinet, TerminalBox terminalBox,
			BrazilianUrbanPropertyAddress bupAddress, CircuitReport circuit) {
		if (circuit.getResources() != null && (circuit.getResources().getRelatedTerminalResources() != null
				&& !circuit.getResources().getRelatedTerminalResources().isEmpty())) {
			List<TerminalResource> terminalResources = circuit.getResources().getRelatedTerminalResources();

			if (terminalResources != null && !terminalResources.isEmpty()) {
				for (int countTerminalResource = 0; countTerminalResource < terminalResources
						.size(); countTerminalResource++) {
					TerminalResource terminalResource = terminalResources.get(countTerminalResource);

					if (terminalResource != null && terminalResource.getTerminalResource() != null) {

						terminalBox.setId(terminalResource.getTerminalResource().getCode() != null
								? terminalResource.getTerminalResource().getCode() : null);

						if (terminalResource.getTerminalResource().getType() != null) {
							TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy
									.getType(terminalResource.getTerminalResource().getType().intValue());
							terminalBox.setType(terminalBoxTypeStrategy.getDescriptionType());
						}

						if (terminalResource.getTerminalResource().getResourceCharacterist() != null) {
							bupAddress.setStreetType(
									terminalResource.getTerminalResource().getResourceCharacterist().getStreetType());
							bupAddress.setStreetName(
									terminalResource.getTerminalResource().getResourceCharacterist().getStreetName());
							bupAddress.setStreetNrFirst(
									terminalResource.getTerminalResource().getResourceCharacterist().getStreetNumber());
							bupAddress.setStreetCode(
									terminalResource.getTerminalResource().getResourceCharacterist().getStreetCode());
						}

						if (terminalResource.getTerminalLogicalCable() != null) {
							cabinet.setDistributionCable(terminalResource.getTerminalLogicalCable().getCode());
							cabinet.setDistributionSideCable(terminalResource.getTerminalLogicalCable().getLateral());
							cabinet.setDistributionPair(
									terminalResource.getTerminalLogicalCable().getLogicalUnit().toString());
						}
					}

					terminalBox.setAddress(bupAddress);
					cabinet.setTerminalBox(terminalBox);
				}
			}
		}
	}

	public ResourceInventoryEntity resourceFacility(ResourceInventoryEntity entity) throws OSSBusinessException {

		WsContext headerContext = new WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());
		
		try {

			ReportResourceProvisioningRequest request = createRequest(entity);
			ReportResourceProvisioningResponse response = facilityResourceService
					.distributeResourceProvisioningReports(request, headerContext);

			updateEntity(response, entity);
		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {
			String description = "Erro no resource facility";
			logger.error(description, e);

			String detail = getErrorDetail(e);
			throw new OSSBusinessException(description, Code.RIOSP_002.getValue(), detail);
		}
		return entity;
	}

	public ResourceInventoryEntity resourceFacilityNRC(ResourceInventoryEntity entity) throws OSSBusinessException {

		WsContext headerContext = new WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());
		
		try {

			ReportResourceProvisioningRequest request = createRequestNRC(entity);
			ReportResourceProvisioningResponse response = facilityResourceService.distributeResourceProvisioningReports(request, headerContext);

			updateEntity(response, entity);
		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
		} catch (Exception e) {
			String description = "Erro no resource facility";
			logger.error(description, e);

			String detail = getErrorDetail(e);
			throw new OSSBusinessException(description, Code.RIOSP_002.getValue(), detail);
		}
		return entity;
	}

	private String getErrorDetail(Exception e) {
		String detail;
		if (e instanceof TimeoutException) {
			detail = Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue();
		} else {
			detail = e.getMessage();
		}
		return detail;
	}
	
	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc = getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}
}