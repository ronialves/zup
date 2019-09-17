package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import java.math.BigInteger;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuitrelatedresourcetypes.CircuitResourceReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport.Resources;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcetypes.Resource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.osp.core.service.FacilityResourceService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;



@RunWith(MockitoJUnitRunner.class)
public class FacilityResourceControllerTest {

	@InjectMocks
	private FacilityResourceMetallicController facilityResourceController;
	
	@Mock
	private FacilityResourceService facilityResourceService;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;
	
	@Before
	public void before() {
		
		entity = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		
		Circuit circuit = new Circuit();
		circuit.setId("VM170625211140319412");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("D0000463122");
		
		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setCustomerOrder(customerOrder);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnException() throws FacilitiesException, OSSBusinessException {
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		response.setResult(result);
		
		when(facilityResourceService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(response);
		
		facilityResourceController.resourceFacility(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnTimeoutException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		response.setResult(result);
		
		when(facilityResourceService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenThrow(TimeoutException.class);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		facilityResourceController.resourceFacility(entity);
		
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		response.setResult(result);
		
		when(facilityResourceService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = facilityResourceController.resourceFacility(entity);
		
		assertEquals("11000", inventoryEntity.getAddress().getCnl());
		
	}

	
	@Test
	public void shouldExecuteWithSuccessGetInicialResources() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		response.setResult(result);
				
		Address address = new Address();
		address.setStreetCode("4251");
		address.setStreetName("JOAO RIBEIRO BARROS");
		address.setStreetNumber("2047");
		address.setStreetType("R.");
		
		Resource resource = new Resource();
		resource.setCode("RAM");
			
		Resources resources = new Resources();
		Informations informations = new Informations();
		CircuitReport circuitReport = new CircuitReport(); 
		CircuitResourceReport circuitResourceReport = new CircuitResourceReport();
		InicialResource inicialResource = new InicialResource();
		LogicalCable logicalCable = new LogicalCable();
		logicalCable.setCode("SRAL");
		logicalCable.setLateral("03");
		logicalCable.setLogicalUnit(178);
		
		inicialResource.setInitialLogicalCable(logicalCable);
			
		resource.setResourceCharacterist(address);
		inicialResource.setInitialResource(resource);
		resources.getRelatedInicialResources().add(inicialResource);
		circuitReport.setResources(resources);
		circuitResourceReport.getCircuit().add(circuitReport);
		informations.setRelatedCircuits(circuitResourceReport);
		response.getInformations().add(informations);
		
		when(facilityResourceService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = facilityResourceController.resourceFacility(entity);
		
		assertEquals("11000", inventoryEntity.getAddress().getCnl());
        assertEquals("SRAL", inventoryEntity.getCabinet().getFeederCable());
        assertEquals("03", inventoryEntity.getCabinet().getFeederSideCable());
        assertEquals("178",inventoryEntity.getCabinet().getFeederPair().toString());
		
	}
	
	
	@Test
	public void shouldExecuteWithSuccessGetIntermediaryResources() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		response.setResult(result);
				
		Address address = new Address();
		address.setStreetCode("4812");
		address.setStreetName("MARIA A B P GOLSMAN");
		address.setStreetNumber("2044");
		address.setStreetType("R.");
		
		Resource resource = new Resource();
		resource.setCode("RAM");
		
		Resources resources = new Resources();
		Informations informations = new Informations();
		CircuitReport circuitReport = new CircuitReport(); 
		CircuitResourceReport circuitResourceReport = new CircuitResourceReport();
		IntermediaryResource intermediaryResource = new IntermediaryResource();
		
		
		resource.setResourceCharacterist(address);
		intermediaryResource.setIntermediaryResource(resource);
		resources.getRelatedIntermediaryResources().add(intermediaryResource);
		circuitReport.setResources(resources);
		circuitResourceReport.getCircuit().add(circuitReport);
		informations.setRelatedCircuits(circuitResourceReport);
		response.getInformations().add(informations);
		
		when(facilityResourceService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = facilityResourceController.resourceFacility(entity);
		
		assertEquals("11000", inventoryEntity.getAddress().getCnl());
		assertNotNull(inventoryEntity.getCabinet().getName());
		assertNotNull(inventoryEntity.getCabinet().getBrazilianUrbanPropertyAddress());
		
	}
	
	@Test
	public void shouldExecuteWithSuccessGetTerminalResources() throws FacilitiesException, OSSBusinessException {
		
		BigInteger bi1 = new BigInteger("1");
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		response.setResult(result);
		
		Address address = new Address();
		address.setStreetCode("4251");
		address.setStreetName("JOAO RIBEIRO BARROS");
		address.setStreetNumber("2047");
		address.setStreetType("R.");
		
		Resource resource = new Resource();
		resource.setCode("RAM");
	
		Resources resources = new Resources();
		Informations informations = new Informations();
		CircuitReport circuitReport = new CircuitReport(); 
		CircuitResourceReport circuitResourceReport = new CircuitResourceReport();
		TerminalResource terminalResource = new TerminalResource();
		LogicalCable logicalCable = new LogicalCable();
		logicalCable.setCode("SRAL");
		logicalCable.setLateral("03");
		logicalCable.setLogicalUnit(178);
		
		terminalResource.setTerminalLogicalCable(logicalCable);
		
		resource.setResourceCharacterist(address);
		terminalResource.setTerminalResource(resource);
		terminalResource.getTerminalResource().setType(bi1);
		resources.getRelatedTerminalResources().add(terminalResource);
		circuitReport.setResources(resources);
		circuitResourceReport.getCircuit().add(circuitReport);
		informations.setRelatedCircuits(circuitResourceReport);
		response.getInformations().add(informations);		
		
		
		when(facilityResourceService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = facilityResourceController.resourceFacility(entity);
		
		assertNotNull(inventoryEntity);
		assertEquals("SRAL", inventoryEntity.getCabinet().getDistributionCable());
		assertEquals("03", inventoryEntity.getCabinet().getDistributionSideCable());
		assertEquals("178", inventoryEntity.getCabinet().getDistributionPair().toString());
						
	}
	
}
