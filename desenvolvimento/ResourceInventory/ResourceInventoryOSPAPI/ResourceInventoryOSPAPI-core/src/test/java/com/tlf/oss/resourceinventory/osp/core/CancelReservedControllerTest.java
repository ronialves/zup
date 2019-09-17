package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
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
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.osp.core.service.CancelReservedService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;



@RunWith(MockitoJUnitRunner.class)
public class CancelReservedControllerTest {

	@InjectMocks
	private CancelReservedMetallicController cancelReservedController;

	@Mock
	private CancelReservedService cancelReservedService;

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
		serviceSpecCharDescribes.setId("D0000463122");
		serviceSpecCharDescribes.setValue("LIRA");
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
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(cancelReservedService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		cancelReservedController.cancelReserved(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowAnTimeoutException()	throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(cancelReservedService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenThrow(TimeoutException.class);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		cancelReservedController.cancelReserved(entity);
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(cancelReservedService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = cancelReservedController.cancelReserved(entity);
		
		assertEquals(inventoryEntity.getAddress().getCnl(), "11000");
		
	}
	

}
