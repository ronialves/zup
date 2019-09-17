package com.tlf.oss.resourceinventory.radius.core;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.verify;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

import java.util.List;

import static org.mockito.Matchers.anyObject;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.radius.repository.DeallocateRepository;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;

import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class DeallocateControllerTest {
	
	@InjectMocks
	private DeallocateController deallocateController;
	
	
	@Mock
	private DeallocateRepository deallocateRepository;
	
	
	@Mock
	private OSSLogger logger;
	
	
	private ResourceInventoryEntity response;
	
	
	private ResourceInventoryEntity request;
	
	
	private static final String IP_ADDRESS ="10.0.0.1";
	
	
	
	
	
	@Test
	public void testDoExecution()throws OSSBusinessException {
		
		 		
		when(deallocateRepository.getIpAddress(anyObject())).thenReturn(IP_ADDRESS);
		
	    response = deallocateController.deallocate(request);
			
		
		verify(deallocateRepository).deallocateIpAddress(anyObject());
		
	    verify(deallocateRepository).deallocateDesignador(anyObject());
		
	    assertEquals(request,response);
	  
		
	}
	

	@Test
	public void testDoExecutionExceptionTest()throws OSSBusinessException{
		OSSBusinessException exception = null;
		
		
		try{
			
			ResourceInventoryEntity resource = new ResourceInventoryEntity();
			response = deallocateController.deallocate(resource);
			
		}catch(Exception e){
			
			exception = new OSSBusinessException("RIRADIUS-001", "RIRADIUS_001", "ERRO: " + e.getMessage());
		}
		
		assertNotNull(exception);
	}

	@Before
	public void before(){
		
		request = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		
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



