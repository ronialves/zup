package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit.Resources;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuitrelatedresourcetypes.CircuitResourceReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.service.ReservationService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class ReservationGponControllerTest {

	@InjectMocks
	private ReservationGponController reservationGponController;

	@Mock
	private ReservationService reservationService; 

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {

		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");

		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);

		Circuit circuit = new Circuit();
		circuit.setId("VM170625211140319412");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

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

		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setResourceFacingService(resourceFacingService);
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnException() throws FacilitiesException, OSSBusinessException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		result.setErrorCode(999);
		entity.getResourceFacingService().setServiceId("CB-SPA-070");

		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(result);

		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);

		Mockito.doNothing().when(logger).error(anyString(), anyObject());

		reservationGponController.reservation(entity);
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

		reservationGponController.reservation(entity);
	}

	@Test
	public void shouldExecuteGponWithSuccess() throws FacilitiesException, OSSBusinessException {

		entity.getAddress().setStreetCode("14397");
		entity.getAddress().setStreetNrFirst("5236");
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("GPON");
		entity.getResourceFacingService().setServiceId("CB-SPA-070");

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);

		ReserveResourceResponse response = populateResponseGpon();

		response.setResult(result);

		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);

		Mockito.doNothing().when(logger).error(anyString(), anyObject());

		ResourceInventoryEntity inventoryEntity = reservationGponController.reservation(entity);

		assertNotNull(inventoryEntity);
		assertEquals(inventoryEntity.getCabinet().getPrimaryCable(), "2");
		assertEquals(inventoryEntity.getCabinet().getPrimaryFiber(), "20");

	}

	@Test
	public void shouldExecuteGponWithFacilitySuccess() throws FacilitiesException, OSSBusinessException, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException {

		entity.getAddress().setStreetCode("14397");
		entity.getAddress().setStreetNrFirst("5236");
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("GPON");
		entity.getResourceFacingService().setServiceId("CB-SPA-070");

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setErrorCode(532);

		ReserveResourceResponse response = populateResponseGpon();
		response.setResult(result);
		
		ReportResourceProvisioningResponse responseFacility = populateFacilityResponseGpon();
		responseFacility.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		responseFacility.getResult().setCode(0);

		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		when(reservationService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(responseFacility);

		Mockito.doNothing().when(logger).error(anyString(), anyObject());

		ResourceInventoryEntity inventoryEntity = reservationGponController.reservation(entity);

		assertNotNull(inventoryEntity);
		assertEquals(inventoryEntity.getCabinet().getPrimaryCable(), "2");
		assertEquals(inventoryEntity.getCabinet().getPrimaryFiber(), "20");

	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorGponCodeAndThrowAnException() throws FacilitiesException, OSSBusinessException {
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("GPON");
		entity.getResourceFacingService().setServiceId("");
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		result.setErrorCode(0);
		
		ReserveResourceResponse response = new ReserveResourceResponse();
		response.setResult(result);

		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);

		Mockito.doNothing().when(logger).error(anyString(), anyObject());

		reservationGponController.reservation(entity);
	}


	private ReserveResourceResponse populateResponseGpon(){
		ReserveResourceResponse response = new ReserveResourceResponse();
		Informations informations = new Informations();
		CircuitResource circuitResource = new CircuitResource();
		com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit circuit = new com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes.Circuit();
		Resources resources = new Resources();
		InicialResource inicialResource = new InicialResource();
		LogicalCable logicalCable = new LogicalCable();

		logicalCable.setCode("2");
		logicalCable.setLogicalUnit(20);

		inicialResource.setInitialLogicalCable(logicalCable);
		resources.getRelatedInicialResources().add(inicialResource);
		circuit.setResources(resources);
		circuitResource.getCircuit().add(circuit);
		informations.setRelatedCircuits(circuitResource);
		response.getInformations().add(informations);
		
		return response;

	}

	private ReportResourceProvisioningResponse populateFacilityResponseGpon(){
		ReportResourceProvisioningResponse response = new ReportResourceProvisioningResponse();
		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations informations = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse.Informations();
		CircuitResourceReport circuitResource = new CircuitResourceReport();
		CircuitReport circuit = new CircuitReport();
		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport.Resources resources = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport.Resources();
		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource inicialResource = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.InicialResource();
		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.logicalcabletypes.LogicalCable logicalCable = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.logicalcabletypes.LogicalCable();

		logicalCable.setCode("2");
		logicalCable.setLogicalUnit(20);

		inicialResource.setInitialLogicalCable(logicalCable);
		resources.getRelatedInicialResources().add(inicialResource);
		circuit.setResources(resources);
		circuitResource.getCircuit().add(circuit);
		informations.setRelatedCircuits(circuitResource);
		response.getInformations().add(informations);
		
		return response;

	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowExceptionWhenADDRESS_BLOCKED() throws OSSBusinessException, FacilitiesException, com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(606);

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();		
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);	
		
		ReserveResourceResponse response = populateResponseGpon();
		response.setResult(result);
		
		ReportResourceProvisioningResponse responseFacility = populateFacilityResponseGpon();
		responseFacility.setResult(new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode());
		responseFacility.getResult().setCode(0);
		
		response.setResult(result);		 
		entity.setCabinet(null);
		
		when(reservationService.reserveResource(anyObject(), anyObject())).thenReturn(response);
		when(reservationService.distributeResourceProvisioningReports(anyObject(), anyObject())).thenReturn(responseFacility);

		doNothing().when(logger).error(anyString(), anyObject());

		assertNotNull(reservationGponController.reservation(entity));
	}
}
