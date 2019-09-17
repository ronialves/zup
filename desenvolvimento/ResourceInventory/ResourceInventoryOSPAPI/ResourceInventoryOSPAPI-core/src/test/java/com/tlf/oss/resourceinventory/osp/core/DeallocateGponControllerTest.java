package com.tlf.oss.resourceinventory.osp.core;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
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
import com.tlf.oss.resourceinventory.osp.core.enums.Operation;
import com.tlf.oss.resourceinventory.osp.core.service.DeallocateService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode;

@RunWith(MockitoJUnitRunner.class)
public class DeallocateGponControllerTest {
	
	@Mock
	private OSSLogger logger;
	
	@Mock
	private DeallocateService deallocateService;
	
	
	@InjectMocks
	DeallocateGponController deallocateGponController; 
	
	private ResourceInventoryEntity entity;
	
	@Before
	public void buildEntity() {
		entity = new ResourceInventoryEntity();
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setNetworkOwner("VIVO1");
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
	
     	CustomerOrder customerOrder = new CustomerOrder();
     	customerOrder.setPurchaseOrderNumber("TESTE");
     	
		entity.setCustomerOrder(customerOrder);
		entity.setAddress(address);
		entity.setResourceFacingService(resourceFacingService);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void errorCodeThrowException() throws FacilitiesException, OSSBusinessException {
		Operation operation = Operation.DEALLOCATE;
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(deallocateService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		deallocateGponController.deallocate(entity, operation);
		
	}
	
	@Test
	public void expectedSucess() throws OSSBusinessException, FacilitiesException {
		Operation operation = Operation.DEALLOCATE;
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		ManageResourceProvisioningActivityResponse response = new ManageResourceProvisioningActivityResponse();
		response.setResult(result);
		
		when(deallocateService.manageResourceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		deallocateGponController.deallocate(entity, operation);
		
		assertNotNull(entity);
		
	}
	
}
