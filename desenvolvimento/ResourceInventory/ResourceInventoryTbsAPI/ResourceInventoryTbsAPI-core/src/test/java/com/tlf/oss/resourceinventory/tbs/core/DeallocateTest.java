package com.tlf.oss.resourceinventory.tbs.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.entity.DeallocateEntity;
import com.tlf.oss.resourceinventory.tbs.repository.DeallocateRepository;

/**
 * BEATRIXTWO-934 | DEMOSS-2998
 * 
 * @project Beatrix Fase 2
 * @author jose.fabio.d.souza
 * @since 201803
 */
@RunWith(MockitoJUnitRunner.class)
public class DeallocateTest {

	@InjectMocks
	private DeallocateController deallocateController;

	@Mock
	private DeallocateRepository deallocateRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity resourceInventoryEntity;
	private DeallocateEntity deallocateResponse;

	@Before
	public void before() {

		resourceInventoryEntity = buildResourceInventoryEntity();
		deallocateResponse = buildDeallocateEntity(resourceInventoryEntity);
	}

	@Test
	public void testDoExecution() throws OSSBusinessException {
		when(deallocateRepository.deallocate((anyObject()))).thenReturn(deallocateResponse);
		ResourceInventoryEntity out = deallocateController.deallocate(resourceInventoryEntity);

		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(String.valueOf(deallocateResponse.getReturnCode())));
	}

	@Test
	public void testDoExecutionOSSBusinessException() {
		OSSBusinessException exception = null;

		try {
			deallocateController.deallocate(resourceInventoryEntity);

		} catch (Exception e) {
			exception = new OSSBusinessException("Code: 0", "RI-TBS", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);
	}

	
	private ResourceInventoryEntity buildResourceInventoryEntity(){
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("BRU-02282072-069");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("8-A4336E869B-1");
		
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerOrder(customerOrder);
		
		return entity;
	}
	
	
	private DeallocateEntity buildDeallocateEntity(ResourceInventoryEntity entity){
		deallocateResponse = new DeallocateEntity();

		deallocateResponse.setPurchaseOrderNumber(entity.getCustomerOrder().getPurchaseOrderNumber());
		deallocateResponse.setDesignadorAcesso(entity.getResourceFacingService().getServiceId());
		deallocateResponse.setReturnCode(0);
		deallocateResponse.setReturnMsg(null);
		
		return deallocateResponse;
	}
}
