package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.osp.core.service.UninstallService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class UninstallControllerTest {
	
	@InjectMocks
	private UninstallMetallicController uninstallController;
	
	@Mock
	private UninstallService uninstallService; 

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;
	
	@Before
	public void before() {
		
		entity = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11425");
		address.setTelephonicArea("OS");
		address.setStreetCode("400530");
		
		Circuit circuit = new Circuit();
		circuit.setId("VM170625211140319412");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("D00004631433");
			 
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");
		
		List<PhysicalLink> physicalLinks = new ArrayList<>();
		physicalLinks.add(physicalLink);
		
		ResourceFacingService facingService = new ResourceFacingService();
		facingService.setServiceId("D00004631433");
		
		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setCustomerOrder(customerOrder);
		entity.setResourceFacingService(facingService);
		entity.setPhysicalLinks(physicalLinks);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ReleaseResourceResponse response = new ReleaseResourceResponse();
		response.setResult(result);
		
		when(uninstallService.releaseResource(anyObject(), anyObject())).thenReturn(response);
		
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		uninstallController.Uninstall(entity);
	}
		
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnTimeoutException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ReleaseResourceResponse response = new ReleaseResourceResponse();
		response.setResult(result);
		
		when(uninstallService.releaseResource(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		uninstallController.Uninstall(entity);
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ReleaseResourceResponse response = new ReleaseResourceResponse();
		response.setResult(result);
		
		when(uninstallService.releaseResource(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = uninstallController.Uninstall(entity);
		
		assertEquals(inventoryEntity.getAddress().getCnl(), "11425");
		
	}
}