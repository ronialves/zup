package com.tlf.oss.resourceinventory.radius.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.radius.repository.AllocateRepository;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceCharacteristicSpecification;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AllocateControllerTest {
	
	@InjectMocks
	private AllocateController allocateController;
	
	@Mock
	private AllocateRepository allocateRepository;
	
	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity response;
	
	private ResourceInventoryEntity request;
	
	private static final String SHASTA_CITY = "CTA";
	private static final String IP_ADDRESS = "10.0.0.1";
	private static final String ID = "STATIC_IP_IPV4";
	
	@Test
	public void getAllocateTest() throws OSSBusinessException{

		when(allocateRepository.getShastaCity(anyObject())).thenReturn(SHASTA_CITY);
		when(allocateRepository.getIpAddress(anyObject(), anyObject())).thenReturn(IP_ADDRESS);
		when(allocateRepository.checkAllocateIpToDesignator(anyObject(), anyObject())).thenReturn(false);
		response = allocateController.getAllocate(request);
		verify(allocateRepository).allocateIp(anyObject());
		verify(allocateRepository).allocateIpToDesignator(anyObject(), anyObject());
		
		ResourceCharacteristicSpecification resourceCharacteristicSpecifications = response.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().get(0);
		
		assertEquals(IP_ADDRESS, resourceCharacteristicSpecifications.getValue());
		assertEquals(ID, resourceCharacteristicSpecifications.getId());

	}
	
	@Test
	public void getAllocateOSSBusinessExceptionTest() throws OSSBusinessException{

		
		OSSBusinessException exception = null;

		try {
			ResourceInventoryEntity resource = new ResourceInventoryEntity();
			response = allocateController.getAllocate(resource);			

		} catch (Exception e) {
			exception = new OSSBusinessException("RIRADIUS-001", "RIRADIUS_001", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);

	}
	
	@Before
	public void before(){
		
		request = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("41000");
		address.setNetworkOwner("VIVO2");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("8-G999999319-1");
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("CTA-8152YJMHT9-013");
		
		ResourceOrder resourceOrder = new ResourceOrder();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrderItem.setName("STATIC_IP");
		resourceOrder.setResourceOrderItem(resourceOrderItem);
		
		request.setResourceOrder(resourceOrder);
		request.setResourceFacingService(resourceFacingService);
		request.setCustomerOrder(customerOrder);
		request.setAddress(address);
		
	}
	
}
