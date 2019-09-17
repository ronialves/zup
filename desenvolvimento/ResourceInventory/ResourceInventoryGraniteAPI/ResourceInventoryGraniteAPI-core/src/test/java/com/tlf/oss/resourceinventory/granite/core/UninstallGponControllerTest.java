package com.tlf.oss.resourceinventory.granite.core;

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
import com.tlf.oss.resourceinventory.granite.core.entity.UninstallResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.UninstallResourceGponDao;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class UninstallGponControllerTest{

	@InjectMocks
	private UninstallGponController uninstallGponController;

	@Mock
	private UninstallResourceGponDao unistallGponDao;
	
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
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc );
		
		Circuit circuit = new Circuit();
		circuit.setId("VM170625211140319412");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("C100096665-01");
		
		ResourceFacingService facingService = new ResourceFacingService();
		facingService.setServiceId("110006569069288");
		
		entity.setAddress(address);
		entity.setCircuit(circuit);	
		entity.setCustomerOrder(customerOrder);
		entity.setResourceFacingService(facingService);
	}
	
	@Test
	public void testDoExecution() throws OSSBusinessException {
		UninstallResourceGponEntity serviceResponse = new UninstallResourceGponEntity();
		serviceResponse.setCode("0");

		when(unistallGponDao.getUninstallInternalResource(anyObject())).thenReturn(serviceResponse);
		
		UninstallResourceGponEntity resourceStatusEntity = uninstallGponController.unistallResource(entity);
		ResourceInventoryEntity t = uninstallGponController.doExecution(entity);
		
		assertNotNull(t);
		assertTrue("0".equals(resourceStatusEntity.getCode()));	
	}
	
	@Test(expected=OSSBusinessException.class)
	public void testDoExecutionException() throws OSSBusinessException {
		UninstallResourceGponEntity serviceResponse = new UninstallResourceGponEntity();
		serviceResponse.setCode("999");

		when(unistallGponDao.getUninstallInternalResource(anyObject())).thenReturn(serviceResponse);
		
		ResourceInventoryEntity t = uninstallGponController.doExecution(entity);
		
		assertNotNull(t);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void testUnistallResourceException() throws OSSBusinessException {
		UninstallResourceGponEntity serviceResponse = new UninstallResourceGponEntity();
		serviceResponse.setCode("10");
		ResourceFacingService rfs = new ResourceFacingService();
		entity.setResourceFacingService(rfs);

		when(unistallGponDao.getUninstallInternalResource(anyObject())).thenReturn(serviceResponse);
		
		UninstallResourceGponEntity t = uninstallGponController.unistallResource(entity);
		
		assertNotNull(t);
	}
}
