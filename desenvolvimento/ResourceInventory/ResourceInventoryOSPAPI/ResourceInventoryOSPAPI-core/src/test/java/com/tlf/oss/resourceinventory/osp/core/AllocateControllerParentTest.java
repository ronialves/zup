package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertNotNull;
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
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;


@RunWith(MockitoJUnitRunner.class)
public class AllocateControllerParentTest {
	
	@Mock
	private AllocateGponController allocateGponController;

	@Mock
	protected OSSLogger logger;
	
	@InjectMocks
	AllocateController allocateController;
	
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
	
	public ResourceInventoryEntity buildEntityEx() {
		
			ResourceInventoryEntity buildEntity = new ResourceInventoryEntity();
			BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
			address.setCnl("11000");
			address.setNetworkOwner("VIVO1");
			address.setTelephonicArea("SA");
			
			PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
			PhysicalLink physicalLink = new PhysicalLink();
			physicalLink.setAccessTechnology("GPON");
			entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink();
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
	     	
	     	buildEntity.setCustomerOrder(customerOrder);
	     	buildEntity.setAddress(address);
	     	buildEntity.setResourceFacingService(resourceFacingService);
			return buildEntity;
	}
	
	@Test
	public void shouldSuccesDoExecutionGpon() throws OSSBusinessException {
		
		when(allocateGponController.allocate(anyObject())).thenReturn(entity);
		allocateController.doExecution(entity);
		assertNotNull(entity);
		
	}
	

	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void expectExceptionDoExecution() throws OSSBusinessException {
		ResourceInventoryEntity execptionEntity = buildEntityEx();
		execptionEntity.setCustomerOrder(null);
		
		when(allocateGponController.allocate(anyObject())).thenThrow(OSSBusinessException.class);
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		allocateController.doExecution(execptionEntity);
	}
	
}
