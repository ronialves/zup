package com.tlf.oss.resourceinventory.granite.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.CustomerOrderType;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrievePathDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class PathServiceTest {
	
	private RetrievePathEntity pathEntityReserved;
	
	private RetrievePathEntity pathEntityActive;
	
	private RetrievePathEntity pathEntityInConfiguration;
	
	private ResourceInventoryEntity entity;
	
	@Mock
	private RetrievePathDao retrivePathDao;
	
	@Mock
	private OSSLogger logger;
	
	@InjectMocks
	private PathService pathService;
	
	@Before
	public void before(){
		entity = new ResourceInventoryEntity();
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
		
		entity.setResourceFacingService(resourceFacingService);
		
		CustomerOrder customerOrder = new CustomerOrder();
		
		CustomerOrderType customerOrderType = CustomerOrderType.OFFER_EDITION;
		
		customerOrder.setCustomerOrderType(customerOrderType.getValue());
		
		entity.setCustomerOrder(customerOrder);
		
		pathEntityReserved = new RetrievePathEntity();
		pathEntityReserved.setCircPathInstId((long)1);
		pathEntityReserved.setStatus(StatusPathType.RESERVED);
		
		pathEntityActive = new RetrievePathEntity();
		pathEntityActive.setCircPathInstId((long) 2);
		pathEntityActive.setStatus(StatusPathType.ACTIVE);
		
		pathEntityInConfiguration = new RetrievePathEntity();
		pathEntityInConfiguration.setCircPathInstId((long) 3);
		pathEntityInConfiguration.setStatus(StatusPathType.IN_CONFIGURATION);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		
		Cabinet cabinet = new Cabinet();
		cabinet.setName("");
		
		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");
		physicalLink.setVoiceProtocol("SIP");
		
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		physicalResourceAssoc.setCabinet(cabinet);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		entity.setAddress(address);
	}

	@Test
	public void testPathServiceTwoPaths() throws OSSBusinessException {
		List <RetrievePathEntity> retrievePathEntityList = new ArrayList<RetrievePathEntity>();
		
		retrievePathEntityList.add(pathEntityReserved);
		retrievePathEntityList.add(pathEntityActive);
		
		when(retrivePathDao.getPaths(anyObject(), anyBoolean())).thenReturn(retrievePathEntityList);
		
		RetrievePathEntity path = pathService.getPath(entity, StatusPathType.RESERVED);
		
		assertEquals(StatusPathType.RESERVED, path.getStatus());				
	}
	
	@Test
	public void testPathServiceOnePath() throws OSSBusinessException {
		List <RetrievePathEntity> retrievePathEntityList = new ArrayList<RetrievePathEntity>();
		
		retrievePathEntityList.add(pathEntityInConfiguration);
		
		when(retrivePathDao.getPaths(anyObject(), anyBoolean())).thenReturn(retrievePathEntityList);
		
		RetrievePathEntity path = pathService.getPath(entity, StatusPathType.IN_CONFIGURATION);
		
		assertEquals(StatusPathType.IN_CONFIGURATION, path.getStatus());
	}
	
//	@Test(expected= OSSBusinessException.class)
//	public void testPathServiceRetrievePathListIsEmpty() throws OSSBusinessException {
//		List <RetrievePathEntity> retrievePathEntityList = new ArrayList<RetrievePathEntity>();
//		
//		when(retrivePathDao.getPaths(anyObject())).thenReturn(retrievePathEntityList);
//		
//		pathService.getPath(entity, StatusPathType.RESERVED);
//	}
	
//	@Test(expected= OSSBusinessException.class)
//	public void testPathSetviceRetrievePathListIsNull() throws OSSBusinessException {
//		List <RetrievePathEntity> retrievePathEntityList = null;
//		
//		when(retrivePathDao.getPaths(anyObject())).thenReturn(retrievePathEntityList);
//		
//		pathService.getPath(entity, StatusPathType.RESERVED);		
//	}
	
	@Test(expected=OSSBusinessException.class)
	public void testPathServiceNoReservedPath() throws OSSBusinessException {
		List <RetrievePathEntity> retrievePathEntityList = new ArrayList<RetrievePathEntity>();
		
		retrievePathEntityList.add(pathEntityActive);
		retrievePathEntityList.add(pathEntityActive);
		
		when(retrivePathDao.getPaths(anyObject(), anyBoolean())).thenReturn(retrievePathEntityList);
		
		pathService.getPath(entity, StatusPathType.RESERVED);
	}
	
	@Test
	public void testPathServiceNoOfferEdition() throws OSSBusinessException{
		List <RetrievePathEntity> retrievePathEntityList = new ArrayList<RetrievePathEntity>();
		
		retrievePathEntityList.add(pathEntityInConfiguration);
		entity.getCustomerOrder().setCustomerOrderType("Teste");
		
		when(retrivePathDao.getPaths(anyObject(), anyBoolean())).thenReturn(retrievePathEntityList);
		
		RetrievePathEntity retrievePathEntity = pathService.getPath(entity, StatusPathType.IN_CONFIGURATION);
		
		assertEquals(StatusPathType.IN_CONFIGURATION, retrievePathEntity.getStatus());

	}
	
	@Test
	public void testPathServiceNoCustomerOrder() throws OSSBusinessException{
		List <RetrievePathEntity> retrievePathEntityList = new ArrayList<RetrievePathEntity>();
		
		retrievePathEntityList.add(pathEntityInConfiguration);
		entity.setCustomerOrder(null);
		
		when(retrivePathDao.getPaths(anyObject(), anyBoolean())).thenReturn(retrievePathEntityList);
		
		RetrievePathEntity retrievePathEntity = pathService.getPath(entity, StatusPathType.IN_CONFIGURATION);
		
		assertEquals(StatusPathType.IN_CONFIGURATION, retrievePathEntity.getStatus());

	}

}
