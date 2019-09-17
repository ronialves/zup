package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.service.DeallocateService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * 
 * @author paulo nicezio
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DeallocateControllerTest {

	@InjectMocks
	private DeallocateMetallicController deallocateController;
	
	@Mock
	private DeallocateService deallocateService;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;
	
	@Before
	public void before() {
		entity = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11425");
		address.setTelephonicArea("SA");
		
		Circuit circuit = new Circuit();
		circuit.setId("123");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("123455");

		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setCustomerOrder(customerOrder);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(deallocateService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		doNothing().when(logger).error(anyString(), anyObject());
		
		deallocateController.deallocate(entity, Operation.DEALLOCATE);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnTimeoutException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(deallocateService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenThrow(TimeoutException.class);
		
		doNothing().when(logger).error(anyString(), anyObject());
		
		deallocateController.deallocate(entity, Operation.DEALLOCATE);
	}
	
	@Test
	public void responseContainsReturnNullAndExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		
		when(deallocateService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity deallocate = deallocateController.deallocate(entity, Operation.DEALLOCATE);
		
		assertEquals(deallocate.getAddress().getCnl(), "11425");
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(deallocateService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity deallocate = deallocateController.deallocate(entity, Operation.DEALLOCATE);
		
		assertEquals(deallocate.getAddress().getCnl(), "11425");
	}
	
}
