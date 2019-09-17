package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuitrelatedresourcetypes.CircuitResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuitrelatedresourcetypes.CircuitResourceReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport.Resources;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcetypes.Resource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalResource;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitStatus;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.service.FacilityResourceService;
import com.tlf.oss.resourceinventory.osp.core.service.ReservationService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;



@RunWith(MockitoJUnitRunner.class)
public class ReservationControllerTest {
	
	@InjectMocks
	private ReservationController reservationController;
	
	@Mock
	private ReservationService reservationService; 

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;

	@Mock
	FacilityResourceService facilityResourceService;
	
	@Mock
	private ReservationGponController reservationGponController;
	
	@Before
	public void before() {
		
		entity = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setStreetNrFirst("207");
		address.setStreetCode("38032");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("SA");
		
		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");
		
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		Circuit circuit = new Circuit();
		circuit.setId("VM170625211140319412");
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("110004563029799");

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("D0000463122");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NRC");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		
		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		CustomerOrder customerOrder = new CustomerOrder();
     	customerOrder.setPurchaseOrderNumber("TESTE");
     	
		entity.setCustomerOrder(customerOrder);
		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setResourceFacingService(resourceFacingService);
	}

	private ReportResourceProvisioningResponse createResponseMockEntityGpon() {
		ReportResourceProvisioningResponse reportResourceProvisioningResponse =
				new ReportResourceProvisioningResponse();

		ReportResourceProvisioningResponse.Informations informations = new Informations();
		CircuitResourceReport circuitResourceReport = new CircuitResourceReport();
		informations.setRelatedCircuits(circuitResourceReport);
		reportResourceProvisioningResponse.getInformations().add(informations);
		
		CircuitReport circuit = new CircuitReport();

		LogicalCable logicalCable = new LogicalCable();
		logicalCable.setCode("30000");
		logicalCable.setLogicalUnit(400);
		InicialResource inicialResource = new InicialResource();
		inicialResource.setInitialLogicalCable(logicalCable);
		
		CircuitReport.Resources resources = new Resources();
		circuit.setResources(resources);

		CircuitResourceReport circuitAllocate = new CircuitResourceReport();
		circuitAllocate.getCircuit().add(circuit);

		reportResourceProvisioningResponse.getInformations().get(0).setRelatedCircuits(circuitAllocate);

		return reportResourceProvisioningResponse;
	}

	@Test
	public void shouldExecuteWithSuccesDoExecutionsMetalic() throws FacilitiesException, OSSBusinessException {
		before();
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(result);
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = reservationController.reservation(entity);
		
		assertEquals(inventoryEntity.getAddress().getCnl(), "11000");
		
	}
	
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExceptionDoExecutionsMetalicEmptyInfo() throws FacilitiesException, OSSBusinessException {
		before();
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.getInformations().add(new ReserveResourceResponse.Informations());
		response.setResult(result);
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = reservationController.doExecution(entity);
		
	}
	
	@Test
	public void shouldExecuteWithSucessDoExecutionsMetalicNotEmptyInfo() throws FacilitiesException, OSSBusinessException {
		before();
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReserveResourceResponse.Informations info = new ReserveResourceResponse.Informations();
		info.setCircuitType("1");
		info.setRelatedCircuits(new CircuitResource());
		com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit circuitReport = new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit();
		com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit.Resources resources = new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit.Resources();
		resources.getRelatedInicialResources().add(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.inicialresourcetypes.InicialResource());
		resources.getRelatedInicialResources().get(0).setInitialLogicalCable(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.logicalcabletypes.LogicalCable());
		resources.getRelatedInicialResources().get(0).setInitialResource(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourcetypes.Resource());
		resources.getRelatedIntermediaryResources().add(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.intermediaryresourcetypes.IntermediaryResource());
		resources.getRelatedIntermediaryResources().get(0).setIntermediaryResource(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourcetypes.Resource());
		resources.getRelatedIntermediaryResources().get(0).setIntermediaryLogicalCable(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.logicalcabletypes.LogicalCable());
		
		resources.getRelatedTerminalResources().add(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.terminalresourcetypes.TerminalResource());
		resources.getRelatedTerminalResources().get(0).setTerminalLogicalCable(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.logicalcabletypes.LogicalCable());
		resources.getRelatedTerminalResources().get(0).setTerminalResource(new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourcetypes.Resource());
		
		circuitReport.setResources(resources);
		
		
		info.getRelatedCircuits().getCircuit().add(circuitReport);
		

		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.getInformations().add(info);
		response.setResult(result);
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = reservationController.doExecution(entity);
		
		assertEquals(inventoryEntity, entity);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionGpon() throws OSSBusinessException {
		before();
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("GPON");
		
		ReportResourceProvisioningResponse response = createResponseMockEntityGpon();
		response.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		response.getResult().setCode(999);
		response.getInformations().get(0).getRelatedCircuits().getCircuit().get(0).setCircuitStatus(BigInteger.valueOf(Long.parseLong(CircuitStatus.RESERVADO.getValue())));
		when(facilityResourceService.gponDistributeResourceProvisioningReports(anyObject())).thenReturn(response);
		
		final OSSBusinessException exception = new OSSBusinessException();
		exception.setDetail("519; Tipo de Circuito Invalido");
		
		when(reservationGponController.reservation(anyObject())).thenThrow(exception);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionMetalicNoAddress() throws OSSBusinessException, FacilitiesException {
		before();
		entity.setAddress(null);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionMetalicNoCnl() throws OSSBusinessException, FacilitiesException {
		before();
		entity.getAddress().setCnl(null);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionMetalicNoTelephonicArea() throws OSSBusinessException, FacilitiesException {
		before();
		entity.getAddress().setTelephonicArea(null);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionMetalicNotStreetCode() throws OSSBusinessException, FacilitiesException {
		before();
		entity.getAddress().setStreetCode(null);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionMetalicNotStreetNrFirst() throws OSSBusinessException, FacilitiesException {
		before();
		entity.getAddress().setStreetNrFirst(null);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionMetalicNotPlacePhysicalResourceAssoc() throws OSSBusinessException, FacilitiesException {
		before();
		entity.getAddress().setPlacePhysicalResourceAssoc(null);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithExeptionDoExecutionMetalicNotResourceFacingService() throws OSSBusinessException, FacilitiesException {
		before();
		entity.setResourceFacingService(null);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.doExecution(entity);
		
	}
	
	@Test
	public void shouldReturnAnErrorCode532AndSucessDoExecutionMetallic() throws FacilitiesException, OSSBusinessException, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException {
		before();
		
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("METALICO");
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(new ResultTypeWithErrorCode());
		response.getResult().setCode(532);
		response.getResult().setErrorCode(532);
		
		ReportResourceProvisioningResponse responseProvision = new ReportResourceProvisioningResponse();
		responseProvision.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		responseProvision.getResult().setCode(0);
		
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		when(reservationService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(responseProvision);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.reservation(entity);
		
		assertNotNull(entity);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCode532AndExceptionCodeDoExecutionMetallic() throws FacilitiesException, OSSBusinessException, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException {
		before();
		
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("METALICO");
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(new ResultTypeWithErrorCode());
		response.getResult().setCode(532);
		response.getResult().setErrorCode(532);
		
		ReportResourceProvisioningResponse responseProvision = new ReportResourceProvisioningResponse();
		responseProvision.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		responseProvision.getResult().setCode(999);
		
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		when(reservationService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(responseProvision);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.reservation(entity);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCode532AndExceptionTimeOutDoExecutionMetallic() throws FacilitiesException, OSSBusinessException, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException {
		before();
		
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("METALICO");
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(new ResultTypeWithErrorCode());
		response.getResult().setCode(532);
		response.getResult().setErrorCode(532);
		
		ReportResourceProvisioningResponse responseProvision = new ReportResourceProvisioningResponse();
		responseProvision.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		responseProvision.getResult().setCode(0);
		
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		when(reservationService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenThrow(TimeoutException.class);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.reservation(entity);
	}
	
	@Test
	public void shouldReturnAnErrorCode532AndSuccessUpdateEntityMetallic() throws FacilitiesException, OSSBusinessException, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException {
		before();
		
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("METALICO");
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(new ResultTypeWithErrorCode());
		response.getResult().setCode(532);
		response.getResult().setErrorCode(532);
		
		Informations info = new Informations();
		info.setCircuitType("1");
		info.setRelatedCircuits(new CircuitResourceReport());
		CircuitReport circuitReport = new CircuitReport();
		Resources resources = new Resources();
		resources.getRelatedInicialResources().add(new InicialResource());
		resources.getRelatedInicialResources().get(0).setInitialLogicalCable(new LogicalCable());
		resources.getRelatedInicialResources().get(0).setInitialResource(new Resource());
		resources.getRelatedIntermediaryResources().add(new IntermediaryResource());
		resources.getRelatedIntermediaryResources().get(0).setIntermediaryResource(new Resource());
		resources.getRelatedIntermediaryResources().get(0).setIntermediaryLogicalCable(new LogicalCable());
		
		resources.getRelatedTerminalResources().add(new TerminalResource());
		resources.getRelatedTerminalResources().get(0).setTerminalLogicalCable(new LogicalCable());
		resources.getRelatedTerminalResources().get(0).setTerminalResource(new Resource());
		
		circuitReport.setResources(resources);
		
		
		info.getRelatedCircuits().getCircuit().add(circuitReport);
		
		
		ReportResourceProvisioningResponse responseProvision = new ReportResourceProvisioningResponse();
		responseProvision.getInformations().clear();
		responseProvision.getInformations().add(info);
		responseProvision.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		responseProvision.getResult().setCode(0);
		
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		when(reservationService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(responseProvision);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.reservation(entity);
		assertNotNull(entity);
	}
	
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCode532AndAnyExceptionUpdateEntityMetallic() throws OSSBusinessException, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException, FacilitiesException {
		before();
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("METALICO");

		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(new ResultTypeWithErrorCode());
		response.getResult().setCode(532);
		response.getResult().setErrorCode(532);
		
		ReportResourceProvisioningResponse responseProvision = new ReportResourceProvisioningResponse();
		responseProvision.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		responseProvision.getResult().setCode(0);
		responseProvision.getInformations().clear();
		responseProvision.getInformations().add(null);
		
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		when(reservationService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(responseProvision);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		reservationController.reservation(entity);
	}
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		result.setErrorCode(999);
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(result);
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.reservation(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnTimeoutException()	throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(result);
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenThrow(TimeoutException.class);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		reservationController.reservation(entity);
	}

	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(result);
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = reservationController.reservation(entity);
		
		assertEquals(inventoryEntity.getAddress().getCnl(), "11000");
		
	}
}
