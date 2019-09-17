package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertEquals;
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
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningResponse;
import com.tlf.oss.resourceinventory.osp.core.service.InstallService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class InstallControllerTest {
	
	@InjectMocks
	private InstallController installController;
	
	@Mock
	private InstallService installService; 
	
	@Mock
	private InstallMetallicController installMetallicController;
	
	@Mock
	InstallGponController installGponController;

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
		
		Cabinet cabinet = new Cabinet();
		cabinet.setName("RAE");
		
		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");
		physicalLink.setVoiceProtocol("SIP");
		
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		physicalResourceAssoc.setCabinet(cabinet);
		
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("BROADBAND");
		
		ServiceSpecCharDescribes customerServiceSpecCharDescribes = new ServiceSpecCharDescribes();
		customerServiceSpecCharDescribes.setValue("1024");

		List<ServiceSpecCharDescribes> customerServiceSpecCharDescribesList = new ArrayList<>();
		customerServiceSpecCharDescribesList.add(customerServiceSpecCharDescribes);

		ServiceDescribedBy customerServiceDescribedBy = new ServiceDescribedBy();
		customerServiceDescribedBy.setName("Downstream");
		customerServiceDescribedBy.setServiceSpecCharDescribes(customerServiceSpecCharDescribesList);

		List<ServiceDescribedBy> customerServiceDescribedByList = new ArrayList<>();
		customerServiceDescribedByList.add(customerServiceDescribedBy);
		
		customerFacingService.setServiceDescribedBy(customerServiceDescribedByList);
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110001234567890");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		
		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);
		
		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setCabinet(cabinet);
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);
		entity.setCustomerOrder(customerOrder);
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
	
	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithErrorFacingServiceNull() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);
		
		ResourceInventoryEntity resourceInventoryEntity = entity;
		resourceInventoryEntity.setResourceFacingService(null);
		
		TrackManageServiceProvisioningResponse response = new TrackManageServiceProvisioningResponse();
		response.setResult(result);
		
		when(installMetallicController.resourceInstall(resourceInventoryEntity)).thenReturn(new ResourceInventoryEntity());
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		installController.doExecution(resourceInventoryEntity);
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws FacilitiesException, OSSBusinessException {
		
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		TrackManageServiceProvisioningResponse response = new TrackManageServiceProvisioningResponse();
		response.setResult(result);
		
		when(installMetallicController.resourceInstall(entity)).thenReturn(new ResourceInventoryEntity());
		when(installService.manageServiceProvisioningActivity(anyObject(), anyObject())).thenReturn(response);
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		ResourceInventoryEntity inventoryEntity = installController.doExecution(entity);;
		
		assertEquals(inventoryEntity.getAddress().getCnl(), "11000");
		
	}
	
	@Test
	public void shouldExecuteWithSuccessGpon() throws FacilitiesException, OSSBusinessException {
		
		ResourceInventoryEntity entityGpon = buildEntityEx();
		when(installGponController.resourceInstall(anyObject())).thenReturn(entityGpon);
		installController.doExecution(entityGpon);;
		assertNotNull(entityGpon);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void expectExceptionDoExecution() throws OSSBusinessException {
		ResourceInventoryEntity entityGpon = buildEntityEx();
		entityGpon.setCustomerOrder(null);
		
		when(installGponController.resourceInstall(anyObject())).thenThrow(OSSBusinessException.class);
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		installController.doExecution(entityGpon);;
	}

}