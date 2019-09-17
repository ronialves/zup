package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
import com.tlf.oss.resourceinventory.granite.core.entity.CancelResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ChangeSpeedDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.repository.UpdateMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class CancelReserveMetallicControllerTest {


	@Mock
	private OSSLogger logger;
	
	@InjectMocks
	private CancelReservedMetallicController cancelReservedMetallicController;
	
	@Mock
	private CancelResourceDao dao;
	
	@Mock
	private PathService pathService;
	
	@Mock
	public ChangeSpeedDao changeSpeedDao;
	
	@Mock
	private ResourceStatusDao resourceStatusDao;
	
	@Mock
	private RetrieveMsanPotsDao retrieveMsanPotsDao;
	
	@Mock
	private UpdateMsanPotsDao updateMsanPotsDao;

	private ResourceInventoryEntity entity;
	
	@Before
	public void before() {
		
		entity = new ResourceInventoryEntity();
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		
		ServiceSpecCharDescribes serviceSpecCharDescribesTerminal = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesTerminal.setValue("110001234567890");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribesTerminal);
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		
		resourceFacingService.setServiceDescribedBy(new ArrayList<>());
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
		
		List<CustomerFacingService> customerFacingServices = new ArrayList<CustomerFacingService>();

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setServiceId("45678-64");
		customerFacingService.setCategory("BROADBAND");
		
		ServiceDescribedBy serviceDescribedByDownstream = new ServiceDescribedBy();
		serviceDescribedByDownstream.setServiceType("BRU");
		serviceDescribedByDownstream.setName("Downstream");
		
		ServiceSpecCharDescribes serviceSpecCharDescDescribesSpeedChange = new ServiceSpecCharDescribes();
		serviceSpecCharDescDescribesSpeedChange.setValue("4096");
		serviceDescribedByDownstream.getServiceSpecCharDescribes().add(serviceSpecCharDescDescribesSpeedChange);
		
		customerFacingService.getServiceDescribedBy().add(serviceDescribedByDownstream);
		customerFacingServices.add(customerFacingService);
		
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(customerFacingServices);
	}

	@Test
	public void testDoExecutionWithTwoPath() throws OSSBusinessException {
		
		CancelResourceEntity serviceResponse = new CancelResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode(Message.SUCCESS.getValue());
		serviceResponse.setResult(result);
		serviceResponse.setDescription("Teste");
		
		RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setCircPathInstId(1L);
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setId(1L);
		retrieveMsanPotsEntity.setIdMsan("2");
		retrieveMsanPotsEntity.setLic("4545-0");
		
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(retrievePathEntityResponse);
		when(dao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		
		CancelResourceEntity cr = cancelReservedMetallicController.cancelResource(entity);
		
		assertNotNull(cr);
		assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
		
	}
	
	@Test
	public void testDoExecutionWithOnePath() throws OSSBusinessException {
		
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
		statusEntity.getResult().setCode("0");
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setId(1L);
		retrieveMsanPotsEntity.setIdMsan("2");
		retrieveMsanPotsEntity.setLic("4545-0");
		
		when(changeSpeedDao.changeSpeed(anyObject(), anyObject(), anyObject())).thenReturn(changeSpeedEntity);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(statusEntity);
		
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(retrievePathEntityResponse);
		when(dao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		CancelResourceEntity cr = cancelReservedMetallicController.cancelResource(entity);
		
		assertNotNull(cr);
		assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
	}
	
	@Test
	public void testDoExecutionWithOnePathChangeSpeedError() throws OSSBusinessException {
		
		CancelResourceEntity serviceResponse = new CancelResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode(Message.SUCCESS.getValue());
		serviceResponse.setResult(result);
		serviceResponse.setDescription("Teste");
		
		RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.IN_CONFIGURATION);
		retrievePathEntityResponse.setCircPathInstId(1L);
		
		ChangeSpeedEntity changeSpeedEntity = new ChangeSpeedEntity();
		changeSpeedEntity.setCode("10");
		
		ResourceStatusEntity statusEntity = new ResourceStatusEntity();
		statusEntity.getResult().setCode("0");
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setId(1L);
		retrieveMsanPotsEntity.setIdMsan("2");
		retrieveMsanPotsEntity.setLic("4545-0");
		
		when(changeSpeedDao.changeSpeed(anyObject(), anyObject(), anyObject())).thenReturn(changeSpeedEntity);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(statusEntity);
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		
		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(retrievePathEntityResponse);
		when(dao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		try {
			cancelReservedMetallicController.cancelResource(entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
			assertEquals(e.getStatusCode(), "RIGRANITE-001");
		}
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
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setId(1L);
		retrieveMsanPotsEntity.setIdMsan("2");
		retrieveMsanPotsEntity.setLic("4545-0");
		
		when(changeSpeedDao.changeSpeed(anyObject(), anyObject(), anyObject())).thenReturn(changeSpeedEntity);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(statusEntity);
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		
		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(retrievePathEntityResponse);
		when(dao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		try {
			cancelReservedMetallicController.cancelResource(entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
			assertEquals(e.getStatusCode(), "RIGRANITE-001");
		}
	}
	
	@Test
	public void testDoExecutionOSSBusinessException() {
		
		OSSBusinessException exception=null; 
		
		try{
			entity.setResourceFacingService(null);
			cancelReservedMetallicController.cancelResource(entity);
			
		}catch (Exception e) {
			exception = new OSSBusinessException("ERRO AO CANCELAR RESERVA: "+ e.getMessage(), "0", "RI-GRANITE");
		}
		assertNotNull(exception);
		
	}
	
	@Test
	public void testDoExecutionWithOnePathWithUpdatePots() throws OSSBusinessException {
		
		CancelResourceEntity serviceResponse = new CancelResourceEntity();		
		serviceResponse.setCode("0");
		ResultTo result = new ResultTo();
		result.setCode(Message.SUCCESS.getValue());
		serviceResponse.setResult(result);
		serviceResponse.setDescription("Teste");
		
		RetrievePathEntity retrievePathEntityResponse = new RetrievePathEntity();
		retrievePathEntityResponse.setStatus(StatusPathType.RESERVED);
		retrievePathEntityResponse.setCircPathInstId(1L);
		
		ChangeSpeedEntity changeSpeedEntity = new ChangeSpeedEntity();
		changeSpeedEntity.setCode("0");
		
		ResourceStatusEntity statusEntity = new ResourceStatusEntity();
		statusEntity.getResult().setCode("0");
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setId(1L);
		retrieveMsanPotsEntity.setIdMsan("2");
		retrieveMsanPotsEntity.setLic("4545-0");
		
		when(changeSpeedDao.changeSpeed(anyObject(), anyObject(), anyObject())).thenReturn(changeSpeedEntity);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(statusEntity);
		
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(retrievePathEntityResponse);
		when(dao.cancelResource(anyObject())).thenReturn(serviceResponse);
		
		CancelResourceEntity cr = cancelReservedMetallicController.cancelResource(entity);
		
		assertNotNull(cr);
		assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
	}

}