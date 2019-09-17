package com.tlf.oss.resourceinventory.osp.core;

import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.enums.TerminalBoxTypeStrategy;
import com.tlf.oss.resourceinventory.osp.core.service.FacilityResourceService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class FacilityResourceGponController extends ValidatorEntity{

	@Inject
	protected OSSLogger logger;

	@Inject
	protected FacilityResourceService facilityResourceService;

	public ResourceInventoryEntity resourceFacility(ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			WsContext headerContext = new WsContext();
			headerContext.setRegionCode(entity.getAddress().getCnl());
			headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());
			
			ReportResourceProvisioningRequest request = createRequest(entity);			
			ReportResourceProvisioningResponse response = facilityResourceService.distributeResourceProvisioningReports(request, headerContext); 
			updateEntity(response, entity);
			return entity;
		} catch (Exception e) {
			String description = "Erro no resource facility";
			logger.error(description, e);
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, OSPWSName.ReportResourceProvisioning);
		}
	}

	private ReportResourceProvisioningRequest createRequest(ResourceInventoryEntity entity) {

		
		ReportResourceProvisioningRequest reportResourceProvisioningRequest = new ReportResourceProvisioningRequest();

		if(entity.getResourceFacingService() != null ){
			reportResourceProvisioningRequest.setCircuitId(entity.getResourceFacingService().getServiceId());
			reportResourceProvisioningRequest.setCircuitType(CircuitTypeEnum.parse(CircuitTypeEnum.GPON.getValue()));
		}

		return reportResourceProvisioningRequest;
	}

	private void updateEntity(ReportResourceProvisioningResponse response, ResourceInventoryEntity entity)throws OSSBusinessException {

		if (response.getResult() != null && response.getResult().getCode() != 0) {
			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(String.valueOf(response.getResult().getErrorCode()), response.getResult().getDescription(), OSPWSName.ReportResourceProvisioning);
		}

		Circuit circuitRet = new Circuit();
		
		if (entity.getCircuit() != null) {
			circuitRet = entity.getCircuit();
		}

		Cabinet cabinet = new Cabinet();
		if (entity.getCabinet() != null) {
			cabinet = entity.getCabinet();
		}
		cabinet.setPrimaryCable(null);
		cabinet.setPrimaryFiber(null);
		
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

				getResourceOrder(info, entity);
				getRelatedCircuits(circuitRet, cabinet, terminalBox, bupAddress, info);				
			}
		}
		
		entity.setCircuit(circuitRet);
		entity.setCabinet(cabinet);
		
	}

	// Valida
	private void getResourceOrder(Informations info, ResourceInventoryEntity entity) {
			
		if(entity.getCustomerOrder() == null){

			CustomerOrder customerOrder = new CustomerOrder();
			entity.setCustomerOrder(customerOrder);
			
			entity.getCustomerOrder().setPurchaseOrderNumber(info.getResourceOrder());
		}

		if(info.getReserveOrder() != null ){

			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NRC");
			entity.getResourceFacingService().getServiceDescribedBy().add(serviceDescribedBy);
			
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			entity.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().add(serviceSpecCharDescribes);				
			entity.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).setValue(info.getReserveOrder());
			
		}
	}

	private void getRelatedCircuits(Circuit circuitRet, Cabinet cabinet, TerminalBox terminalBox,
			BrazilianUrbanPropertyAddress bupAddress, Informations info) {
		if (info.getRelatedCircuits() != null 
				&& (info.getRelatedCircuits().getCircuit() != null && !info.getRelatedCircuits().getCircuit().isEmpty())) {

			for (int countCircuit = 0; countCircuit < info.getRelatedCircuits().getCircuit().size(); countCircuit++) {
				CircuitReport circuit = info.getRelatedCircuits().getCircuit().get(countCircuit);
				circuitRet.setId(circuit.getCircuitIdentifier());								
				
				//getRelatedIniciallResources(cabinet, circuit);

				getRelatedTerminalResources(cabinet, terminalBox, bupAddress, circuit);
			}							
		}
	}

	private void getRelatedTerminalResources(Cabinet cabinet, TerminalBox terminalBox, BrazilianUrbanPropertyAddress bupAddress,
			CircuitReport circuit) {
		if (circuit.getResources() != null
				&& (circuit.getResources().getRelatedTerminalResources() != null && !circuit.getResources().getRelatedTerminalResources().isEmpty())) {
			List<TerminalResource> terminalResources = circuit.getResources().getRelatedTerminalResources();

			if (terminalResources != null && !terminalResources.isEmpty()) {
				for (int countTerminalResource = 0; countTerminalResource < terminalResources.size(); countTerminalResource++) {
					TerminalResource terminalResource = terminalResources.get(countTerminalResource);
					
					if (terminalResource != null && terminalResource.getTerminalResource() != null) {

						terminalBox.setId(terminalResource.getTerminalResource().getCode() != null ? terminalResource.getTerminalResource().getCode() : null);
						
						if (terminalResource.getTerminalResource().getType() != null) {
							TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy
									.getType(terminalResource.getTerminalResource().getType().intValue());
							terminalBox.setType(terminalBoxTypeStrategy.getDescriptionType());
						}
						
						if (terminalResource.getTerminalResource().getResourceCharacterist() != null) {
							bupAddress.setAddressType(terminalResource.getTerminalResource().getResourceCharacterist().getStreetType());
							bupAddress.setStreetName(terminalResource.getTerminalResource().getResourceCharacterist().getStreetName());
							bupAddress.setStreetNrFirst(terminalResource.getTerminalResource().getResourceCharacterist().getStreetNumber());
						}
																	
						if (terminalResource.getTerminalLogicalCable() != null) {
							terminalBox.setCableNumber(terminalResource.getTerminalLogicalCable().getCode());
							terminalBox.setSideCableNumber(terminalResource.getTerminalLogicalCable().getLateral());										
						}
					}
					
					terminalBox.setAddress(bupAddress);									
					cabinet.setTerminalBox(terminalBox);
				}										
			}
		}
	}
	
}

