package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcetypes.Resource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.osp.core.service.FacilityResourceService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class FacilityResourceGponControllerTest {

	@InjectMocks
	private FacilityResourceGponController facilityResourceGponController;

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
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());		
		facilityResourceGponController.resourceFacility(entity);
		
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
		
		facilityResourceGponController.resourceFacility(entity);
		
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		updateEntity(entity, response);
		response.setResult(result);
		
		when(facilityResourceService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = facilityResourceGponController.resourceFacility(entity);
		
		assertEquals(inventoryEntity.getAddress().getCnl(), "11000");
		
	}
	
	private void updateEntity(ResourceInventoryEntity entity, ReportResourceProvisioningResponse response){
		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		Informations info = new Informations();
		info.setReserveOrder("P526281");
		info.setCircuitType("GPON");
		
		CircuitResourceReport circuitResourceReport = new CircuitResourceReport();
		CircuitReport circuitReport = new CircuitReport();
		Resources resources = new Resources();
		TerminalBox terminalBox = new TerminalBox();

		LogicalCable logicalCable = new LogicalCable();
		logicalCable.setCode("11000");
		logicalCable.setLateral("01");
		
		//getRelatedIniciallResources
		InicialResource inicialResource = new InicialResource();
		inicialResource.setInitialLogicalCable(logicalCable);
		inicialResource.getInitialLogicalCable().setLogicalUnit(0);
		inicialResource.getInitialLogicalCable().setCode("01-F#");
		resources.getRelatedInicialResources().add(inicialResource);
		
		//Andress
		Address address = new Address();
		address.setStreetCode("144037");
		address.setStreetName("JOAQUIM GUARANI");
		address.setStreetNumber("31");
		
		//getRelatedTerminalResources
		TerminalResource terminalResource = new TerminalResource();
		Resource resource = new Resource();
		resource.setCode("AS");
		resource.setType(BigInteger.valueOf(10));
		
		resource.setResourceCharacterist(address);;
		terminalResource.setTerminalResource(resource);
		terminalResource.setTerminalLogicalCable(logicalCable );
		resources.getRelatedTerminalResources().add(terminalResource);
		circuitReport.setResources(resources );
		circuitResourceReport.getCircuit().add(circuitReport);
		info.setRelatedCircuits(circuitResourceReport);
		
		terminalBox.setId(terminalResource.getTerminalResource().getCode());
		terminalBox.setAddress(entity.getAddress());
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		List<ServiceDescribedBy> serviceL = new ArrayList<>();
		serviceL.add(serviceDescribedBy);
		
		resourceFacingService.setServiceDescribedBy(serviceL);
		entity.setResourceFacingService(resourceFacingService);
		response.getInformations().add(info);

		entity.setCustomerOrder(null);
		
		entity.getCabinet().setTerminalBox(terminalBox);
	}
	
}
