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
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.osp.core.service.CancelReservedService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class CancelReservedGponControllerTest {

	@InjectMocks
	CancelReservedGponController cancelReservedGponController;
	
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
		physicalLink.setAccessTechnology("GPON");
		
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("110004569069799");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		ServiceSpecCharDescribes e = new ServiceSpecCharDescribes();
		e.setValue("C000048799");
		serviceSpecCharDescribesList.add(e);
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NRC");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);
		entity.setAddress(address);
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
		
		cancelReservedGponController.cancelReserved(entity);
	}

	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(cancelReservedService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = cancelReservedGponController.cancelReserved(entity);
		
		assertEquals(inventoryEntity.getAddress().getCnl(), "11000");
		
	}
}
