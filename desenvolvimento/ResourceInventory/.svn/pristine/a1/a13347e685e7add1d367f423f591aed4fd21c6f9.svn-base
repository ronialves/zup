package com.tlf.oss.resourceinventory.sagre.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.sagre.entity.AllocateExternalResourceEntity;
import com.tlf.oss.resourceinventory.sagre.repository.AllocateRepository;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AllocateExternalResourceTest {

	@InjectMocks
	private AllocateController allocateController;

	@Mock
	private AllocateRepository allocateRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity resourceInventoryEntity;
	private AllocateExternalResourceEntity allocateResponse;

	@Before
	public void before() {

		resourceInventoryEntity = buildResourceInventory();

		allocateResponse = buildAllocateExternalResource(resourceInventoryEntity);

	}

	@Test
	public void testDoExecution() throws OSSBusinessException {
		when(allocateRepository.allocate((anyObject()))).thenReturn(allocateResponse);
		ResourceInventoryEntity out = allocateController.allocate(resourceInventoryEntity);

		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(allocateResponse.getResultCode().toString()));
	}

	@Test
	public void testDoExecutionOSSBusinessException() {

		OSSBusinessException exception = null;

		try {
			resourceInventoryEntity.setCustomerOrder(null);
			allocateController.allocate(resourceInventoryEntity);

		} catch (Exception e) {
			exception = new OSSBusinessException("Code: 0", "RI-SAGRE", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);

	}

	private ResourceInventoryEntity buildResourceInventory(){
		
		resourceInventoryEntity = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setStreetCode("12212");
		address.setStreetNrFirst("11");
		address.setCnl("11074");
		address.setNetworkOwner("VIVO2");
		address.setTelephonicArea("PR");

		TerminalBox terminalBox = new TerminalBox();
		terminalBox.setName("G124388");
		
		Cabinet cabinet = new Cabinet();
		cabinet.setName("PRTCA_01D23");
		cabinet.setTerminalBox(terminalBox);
		
		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		physicalLink.setVoiceProtocol("SIP");
		
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		physicalResourceAssoc.setCabinet(cabinet);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		//PON
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("8-A4336E869B-1");

		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("BRU-02282072-069");
		
		//RPON
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("C18271821");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("RPON");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		List<ServiceDescribedBy> serviceDescribedBies = new ArrayList<>();
		serviceDescribedBies.add(serviceDescribedBy);
		
		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setServiceDescribedBy(serviceDescribedBies);
		
		List<CustomerFacingService> customerFacingServices = new ArrayList<>();
		customerFacingServices.add(customerFacingService);

		resourceInventoryEntity.setAddress(address);
		resourceInventoryEntity.setCustomerOrder(customerOrder);
		resourceInventoryEntity.setResourceFacingService(resourceFacingService);
		resourceInventoryEntity.setCustomerFacingService(customerFacingServices);
		
		return resourceInventoryEntity;
	}
	
	private AllocateExternalResourceEntity buildAllocateExternalResource(ResourceInventoryEntity entity){
		allocateResponse = new AllocateExternalResourceEntity();
		
		allocateResponse.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		allocateResponse.setAccessTechnology(null);
		allocateResponse.setVoiceTechnology(null);
		allocateResponse.setAccessId(null);
		allocateResponse.setTargetAccessTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		allocateResponse.setTargetVoiceTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		allocateResponse.setTargetAccessId(entity.getResourceFacingService().getServiceId());
		allocateResponse.setSos(null);
		allocateResponse.setIdentEquip1(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getName());
		allocateResponse.setIdentEquip2(
				entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getTerminalBox().getName());
		allocateResponse.setIdentEquip3(null);
		allocateResponse.setStreetCode(entity.getAddress().getStreetCode());
		allocateResponse.setLote(entity.getAddress().getStreetNrFirst());
		allocateResponse.setPon(entity.getCustomerOrder().getPurchaseOrderNumber());

		if (entity.getCustomerFacingService() != null && !entity.getCustomerFacingService().isEmpty()) {
			for (CustomerFacingService customer : entity.getCustomerFacingService()) {
				if (customer.getServiceDescribedBy() != null && !customer.getServiceDescribedBy().isEmpty()) {
					for (ServiceDescribedBy service : customer.getServiceDescribedBy()) {
						if ("RPON".equalsIgnoreCase(service.getName()) && service.getServiceSpecCharDescribes() != null) {
							for (ServiceSpecCharDescribes serviceSpec : service.getServiceSpecCharDescribes()) {
								allocateResponse.setRpon(serviceSpec.getValue());
							}
						}
					}
				}
			}
		}
		
		allocateResponse.setOriginSystem("RI");
		allocateResponse.setNote("");
		allocateResponse.setResultCode(0);
		allocateResponse.setMessage(null);
		allocateResponse.setDocumentType("DEFAULT");
		allocateResponse.setServiceClass("DEFAULT");
		allocateResponse.setOrderType("DEFAULT");

		
		return allocateResponse;
	}
}
