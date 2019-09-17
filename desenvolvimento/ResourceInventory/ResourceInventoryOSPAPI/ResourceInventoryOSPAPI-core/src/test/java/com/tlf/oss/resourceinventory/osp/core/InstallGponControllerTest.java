package com.tlf.oss.resourceinventory.osp.core;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

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
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.service.InstallService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class InstallGponControllerTest {

	@InjectMocks
	private InstallGponController installGponController;
	
	@Mock
	private InstallService installService; 

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
		
		TrackManageServiceProvisioningResponse response = new TrackManageServiceProvisioningResponse();
		response.setResult(result);
		
		when(installService.manageServiceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		installGponController.resourceInstall(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnTimeoutException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		TrackManageServiceProvisioningResponse response = new TrackManageServiceProvisioningResponse();
		response.setResult(result);
		
		when(installService.manageServiceProvisioningActivity(anyObject(), anyObject())).thenThrow(TimeoutException.class);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		installGponController.resourceInstall(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAntException() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		TrackManageServiceProvisioningResponse response = new TrackManageServiceProvisioningResponse();
		response.setResult(result);
		
		when(installService.manageServiceProvisioningActivity(anyObject(), anyObject())).thenThrow(Exception.class);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		installGponController.resourceInstall(entity);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnValidadeResult() throws FacilitiesException, OSSBusinessException {
		entity.getAddress().setCnl(null);
		entity.getAddress().setTelephonicArea(null);
				
		TrackManageServiceProvisioningResponse response = new TrackManageServiceProvisioningResponse();
		response.setResult(null);
		
		createRequest(entity, response);
		
		when(installService.manageServiceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = installGponController.resourceInstall(entity);
		
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		TrackManageServiceProvisioningResponse response = new TrackManageServiceProvisioningResponse();
		response.setResult(result);
		
		createRequest(entity, response);
		
		when(installService.manageServiceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = installGponController.resourceInstall(entity);
		
	}
	
	private void createRequest(ResourceInventoryEntity entity,TrackManageServiceProvisioningResponse response ){
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		entity.setResourceFacingService(resourceFacingService);
	
	}
}
