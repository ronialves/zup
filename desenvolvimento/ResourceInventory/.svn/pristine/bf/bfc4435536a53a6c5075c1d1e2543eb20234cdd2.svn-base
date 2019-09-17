package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import com.tlf.oss.resourceinventory.granite.core.entity.CancelChangeSpeedGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ServiceCodeEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelChangeSpeedGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelResourceGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ChangeSpeedDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveServiceCodeDao;
import com.tlf.oss.resourceinventory.granite.core.repository.UpdateMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class CancelReserveTest {

	@Mock
	private OSSLogger logger;
	
	@InjectMocks
	private CancelReservedController service;
	
	@Mock
	private CancelResourceDao dao;
	
	@Mock
	private CancelReservedGponController serviceGpon;
	
	@Mock
	private CancelReservedMetallicController serviceMetallic;
	
	@Mock
	public ChangeSpeedDao changeSpeedDao;
	
	@Mock
	private ResourceStatusDao resourceStatusDao;
	
	@Mock
	private RetrieveMsanPotsDao retrieveMsanPotsDao;
	
	@Mock
	private UpdateMsanPotsDao updateMsanPotsDao;
	
	@InjectMocks
	private CancelReservedGponController cancelReservedGponController;
	
	@Mock
	private CancelResourceGponDao cancelResourceGponDao;
	
	@Mock
	private CancelChangeSpeedGponDao cancelChangeSpeedGponDao;
	
	@Mock
	private PathService pathService;
	
	@Mock
	private RetrieveServiceCodeDao retrieveServiceCodeDao;

	private ResourceInventoryEntity entity;

	private ResourceInventoryEntity gponEntity;
	
	private static final String SUCCESS = "0";
	
	@Before
	public void before() {
		this.entity = this.getEntity();
		this.gponEntity = this.getGponEntity();
	}
	
	private ResourceInventoryEntity getEntity(){
		final ResourceInventoryEntity entity = new ResourceInventoryEntity();
		
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
		
		return entity;
	}
	
	private ResourceInventoryEntity getGponEntity(){
		final ResourceInventoryEntity entity = new ResourceInventoryEntity();
		
		final BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11425");
		address.setTelephonicArea("OS");
		
		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		Cabinet cabinet = new Cabinet();
		cabinet.setPrimaryFiber("1");
		cabinet.setPrimaryCable("01");
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("123456789123456");

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("C000059999");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NRC");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		
		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);
		
		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("BROADBAND");
		
		ServiceSpecCharDescribes customerServiceSpecCharDescribes = new ServiceSpecCharDescribes();
		customerServiceSpecCharDescribes.setValue("16384");
		
		ServiceSpecCharDescribes customerServiceSpecCharDescribes1 = new ServiceSpecCharDescribes();
		customerServiceSpecCharDescribes1.setValue("FIXED");
		
		List<ServiceSpecCharDescribes> customerServiceSpecCharDescribesList = new ArrayList<>();
		customerServiceSpecCharDescribesList.add(customerServiceSpecCharDescribes);
		
		List<ServiceSpecCharDescribes> customerServiceSpecCharDescribesList1 = new ArrayList<>();
		customerServiceSpecCharDescribesList1.add(customerServiceSpecCharDescribes1);

		ServiceDescribedBy customerServiceDescribedBy = new ServiceDescribedBy();
		customerServiceDescribedBy.setName("Downstream");
		customerServiceDescribedBy.setServiceSpecCharDescribes(customerServiceSpecCharDescribesList);
		
		ServiceDescribedBy customerServiceDescribedBy1 = new ServiceDescribedBy();
		customerServiceDescribedBy1.setName("IP");
		customerServiceDescribedBy1.setServiceSpecCharDescribes(customerServiceSpecCharDescribesList1);
		
		List<ServiceDescribedBy> customerServiceDescribedByList = new ArrayList<>();
		customerServiceDescribedByList.add(customerServiceDescribedBy);
		customerServiceDescribedByList.add(customerServiceDescribedBy1);
		
		customerFacingService.setServiceDescribedBy(customerServiceDescribedByList);
		
		entity.setAddress(address);
		entity.setCabinet(cabinet);
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);
		
		return entity;
	}

	@Test
	public void cancelResourceGponSucessTest() throws OSSBusinessException {
		
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("GPON");
		
		when(serviceGpon.doExecution(anyObject())).thenReturn(entity);
		
		service.cancelResource(entity);
		
		assertEquals(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology(),"GPON");
	}

	@Test
	public void cancelResourceMetallicSucessTest() throws OSSBusinessException {
		
		when(serviceMetallic.doExecution(anyObject())).thenReturn(entity);
		
		service.cancelResource(entity);
		
		assertEquals(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology(),"METALICO");
	}
	
	@Test
	public void testDoExecutionWithOnePathUpdateStatusError() throws OSSBusinessException {
		
		CancelResourceEntity serviceResponse = new CancelResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode(Message.SUCCESS.getValue());
		serviceResponse.setResult(result);
		serviceResponse.setDescription("Teste");
		
		RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.IN_CONFIGURATION);
		retrievePathEntityResponse.setCircPathInstId(1L);
		
		ChangeSpeedEntity changeSpeedEntity = new ChangeSpeedEntity();
		changeSpeedEntity.setCode("0");
		
		ResourceStatusEntity statusEntity = new ResourceStatusEntity();
		statusEntity.getResult().setCode("10");
		
		when(changeSpeedDao.changeSpeed(anyObject(), anyObject(), anyObject())).thenReturn(changeSpeedEntity);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(statusEntity);
		when(pathService.getPath(anyObject())).thenReturn(retrievePathEntityResponse);
		when(dao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		try {
			service.cancelResource(entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
			assertEquals(e.getStatusCode(), "RIGRANITE-001");
		}
	}
	
	@Test(expected=Exception.class)
	public void testDoExecutionOSSBusinessException() throws OSSBusinessException {
		entity.setAddress(null);
		service.cancelResource(entity);
	}
		
	@Test
	public void testCancelChangeSpeedResourceSucess() throws OSSBusinessException {

		entity.setResourceFacingService(new ResourceFacingService());
		entity.getResourceFacingService().setServiceId("111222458721540");
		final CancelResourceGponEntity serviceResponse = new CancelResourceGponEntity();	
		serviceResponse.setTerminal(entity.getResourceFacingService().getServiceId());
		serviceResponse.setCode(SUCCESS);
		
		final RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setCircPathInstId(1L);
		when(pathService.getPath(anyObject())).thenReturn(retrievePathEntityResponse);
		when(cancelResourceGponDao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		final ResourceInventoryEntity reserveResourceGponEntity = cancelReservedGponController.doExecution(entity);

		assertNotNull(reserveResourceGponEntity);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void testCancelChangeSpeedResourceOSSException() throws OSSBusinessException {

		entity.setResourceFacingService(new ResourceFacingService());
		entity.getResourceFacingService().setServiceId("111");
		
		final CancelResourceGponEntity serviceResponse = new CancelResourceGponEntity();	
		serviceResponse.setTerminal(entity.getResourceFacingService().getServiceId());
		serviceResponse.setCode("10");
		serviceResponse.setDescription(Code.RIGRANITE_002.getDescription());
		
		final RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setCircPathInstId(1L);
		when(pathService.getPath(anyObject())).thenReturn(retrievePathEntityResponse);
		when(cancelResourceGponDao.cancelResource(anyObject())).thenReturn(serviceResponse);

		cancelReservedGponController.doExecution(entity);
	}
	
	@Test
	public void testCancelChangeSpeedGponResourceSucess() throws OSSBusinessException {

		final ServiceCodeEntity serviceCodeEntity = new ServiceCodeEntity();
		serviceCodeEntity.setServiceCode("IPSF02");
		when(retrieveServiceCodeDao.retrieveServiceCode(anyObject())).thenReturn(serviceCodeEntity);

		final CancelChangeSpeedGponEntity serviceResponse = new CancelChangeSpeedGponEntity();	
		serviceResponse.setServiceId("123456789123456");
		serviceResponse.setServiceCode(serviceCodeEntity.getServiceCode());
		serviceResponse.setCode(SUCCESS);
		
		when(cancelChangeSpeedGponDao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		final CancelResourceGponEntity serviceResponse2 = new CancelResourceGponEntity();	
		entity.setResourceFacingService(new ResourceFacingService());
		entity.getResourceFacingService().setServiceId("111");
		serviceResponse2.setTerminal(entity.getResourceFacingService().getServiceId());
		serviceResponse2.setCode("10");
		when(cancelResourceGponDao.cancelResource(anyObject())).thenReturn(serviceResponse2);
		
		final RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setResourceStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setCircPathInstId(1L);
		when(pathService.getPath(anyObject())).thenReturn(retrievePathEntityResponse);
		
		final ResourceInventoryEntity reserveResourceGponEntity = cancelReservedGponController.doExecution(gponEntity);

		assertNotNull(reserveResourceGponEntity);
	}
	
	@Test(expected=OSSBusinessException.class)
	public void testCancelChangeSpeedGponResourceOSSException() throws OSSBusinessException {

		final ServiceCodeEntity serviceCodeEntity = new ServiceCodeEntity();
		serviceCodeEntity.setServiceCode("IPSF02");
		when(retrieveServiceCodeDao.retrieveServiceCode(anyObject())).thenReturn(serviceCodeEntity);

		final CancelChangeSpeedGponEntity serviceResponse = new CancelChangeSpeedGponEntity();
		serviceResponse.setServiceId("");
		serviceResponse.setServiceCode(serviceCodeEntity.getServiceCode());
		serviceResponse.setCode("10");
		serviceResponse.setDescription(Code.RIGRANITE_002.getDescription());
		
		final RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setResourceStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setCircPathInstId(1L);
		when(pathService.getPath(anyObject())).thenReturn(retrievePathEntityResponse);
		
		when(cancelChangeSpeedGponDao.cancelResource(anyObject())).thenReturn(serviceResponse);

		cancelReservedGponController.doExecution(gponEntity);
	}

}