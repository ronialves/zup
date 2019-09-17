package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuitlottypes.CircuitLotAllocate;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuitresourcetypes.CircuitAllocate;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceResponse.Informations;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.osp.core.service.AllocateService;
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
public class AllocateControllerTest {

	@InjectMocks
	private AllocateMetallicController allocateController;

	@Mock
	private AllocateService allocateService;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {
		entity = new ResourceInventoryEntity();
	}
	
	@Test
	public void shouldExecuteGponWithSuccess() throws OSSBusinessException, FacilitiesException {
		createRequestEntityGpon();
		AllocateInstallResourceResponse allocateResourceResponse = createResponseMockEntityGpon();
		when(allocateService.allocateResource(anyObject(), anyObject()))
				.thenReturn(allocateResourceResponse);

		doNothing().when(logger).error(anyString(), anyObject());

		ResourceInventoryEntity entityResponse = allocateController.allocate(entity);

		assertEquals("11425", entityResponse.getAddress().getCnl());
	}

	private void createRequestEntityGpon() {
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11425");
		address.setTelephonicArea("SA");
		address.setStreetCode("10219");
		address.setStreetNrFirst("11");

		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc =
				new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);

		// NetworkOwnerID
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("CB-SPA-071");
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);

		// NRC
		ServiceSpecCharDescribes serviceSpecCharDescribesNrc = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesNrc.setValue("P526282");
		ServiceDescribedBy serviceDescribedByNrc = new ServiceDescribedBy();
		serviceDescribedByNrc.setName("NRC");
		serviceDescribedByNrc.getServiceSpecCharDescribes().add(serviceSpecCharDescribesNrc);

		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("CB-SPA-071");
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedByNrc);

		Circuit circuit = new Circuit();
		circuit.setId("123");

		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("123455");

		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setCustomerOrder(customerOrder);
		entity.setResourceFacingService(resourceFacingService);
	}

	private AllocateInstallResourceResponse createResponseMockEntityGpon() {
		AllocateInstallResourceResponse allocateResourceResponse =
				new AllocateInstallResourceResponse();

		AllocateInstallResourceResponse.Informations informations = new Informations();
		allocateResourceResponse.getInformations().add(informations);

		LogicalCable logicalCable = new LogicalCable();
		logicalCable.setCode("30000");
		logicalCable.setLogicalUnit(400);
		InicialResource inicialResource = new InicialResource();
		inicialResource.setInitialLogicalCable(logicalCable);
		CircuitLotAllocate.Resources resources = new CircuitLotAllocate.Resources();
		resources.getRelatedInicialResources().add(inicialResource);
		CircuitLotAllocate circuitLotAllocate = new CircuitLotAllocate();
		circuitLotAllocate.setResources(resources);

		CircuitAllocate circuitAllocate = new CircuitAllocate();
		circuitAllocate.getCircuit().add(circuitLotAllocate);

		allocateResourceResponse.getInformations().get(0).setRelatedCircuits(circuitAllocate);

		return allocateResourceResponse;
	}
}
