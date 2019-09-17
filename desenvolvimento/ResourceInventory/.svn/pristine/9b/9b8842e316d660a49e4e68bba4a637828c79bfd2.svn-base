package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
import org.mockito.runners.MockitoJUnitRunner;
import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.DeallocateInternalResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusMsanPotsType;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.ChangeSpeedDao;
import com.tlf.oss.resourceinventory.granite.core.repository.DeallocateInternalResourceDao;
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
public class DeallocateTest {

	private static final String SPEED = "1024";

	@Mock
	private OSSLogger logger;
	
	@InjectMocks
	private DeallocateResourceMetallicController service;
	
	@Mock
	public DeallocateInternalResourceDao cdao;
	
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
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerId");
		
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110002154963870");
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
		
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
		
		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("BROADBAND");
		
		ServiceSpecCharDescribes customerServiceSpecCharDescribes = new ServiceSpecCharDescribes();
		customerServiceSpecCharDescribes.setValue(SPEED);

		List<ServiceSpecCharDescribes> customerServiceSpecCharDescribesList = new ArrayList<>();
		customerServiceSpecCharDescribesList.add(customerServiceSpecCharDescribes);

		ServiceDescribedBy customerServiceDescribedBy = new ServiceDescribedBy();
		customerServiceDescribedBy.setName("Downstream");
		customerServiceDescribedBy.setServiceSpecCharDescribes(customerServiceSpecCharDescribesList);

		List<ServiceDescribedBy> customerServiceDescribedByList = new ArrayList<>();
		customerServiceDescribedByList.add(customerServiceDescribedBy);
		
		customerFacingService.setServiceDescribedBy(customerServiceDescribedByList);
		
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);
	}

	@Test
	public void deallocateSaleOffer() throws OSSBusinessException {
		
		DeallocateInternalResourceEntity serviceResponse = new DeallocateInternalResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.SALE_OFFER);
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setId(729387L);
		retrieveMsanPotsEntity.setLic("A-000045-00");
		retrieveMsanPotsEntity.setIdMsan("CAS.CB.MSO02");
		retrieveMsanPotsEntity.setStatus(StatusMsanPotsType.FREE.getValue());

		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		
		when(cdao.getDeallocateInternalResource(anyObject())).thenReturn(serviceResponse);
		
		when(retrieveMsanPotsDao.getMsanPots(anyString())).thenReturn(retrieveMsanPotsEntity);
		
		DeallocateInternalResourceEntity deallocateInternalResourceEntity = service.deallocateResource(entity);
		
		assertNotNull(deallocateInternalResourceEntity);
		assertTrue("0".equals(serviceResponse.getResult().getCode()));
	}
	
	@Test
	public void deallocateChangePort() throws OSSBusinessException {
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		
		DeallocateInternalResourceEntity serviceResponse = new DeallocateInternalResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.CHANGE_OFFER);

		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		when(cdao.getDeallocateInternalResource(anyObject())).thenReturn(serviceResponse);
		
		DeallocateInternalResourceEntity deallocateInternalResourceEntity = service.deallocateResource(entity);
		
		assertNotNull(deallocateInternalResourceEntity);
		assertTrue("0".equals(serviceResponse.getResult().getCode()));
	}
	
	@Test
	public void deallocateOfferEdition() throws OSSBusinessException {
		
		DeallocateInternalResourceEntity serviceResponse = new DeallocateInternalResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.OFFER_EDITION);
		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		
		ChangeSpeedEntity changeSpeedEntity = new ChangeSpeedEntity();
		changeSpeedEntity.setCode("0");
		when(changeSpeedDao.changeSpeed(path.getCircPathInstId(), SPEED, "KB")).thenReturn(changeSpeedEntity);
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		when(retrieveMsanPotsDao.getMsanPots(anyString())).thenReturn(retrieveMsanPotsEntity);
		
		ResultTo resultTo = new ResultTo();
		resultTo.setCode("0");
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(resultTo);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);
		
		DeallocateInternalResourceEntity deallocateInternalResourceEntity = service.deallocateResource(entity);
		
		assertNotNull(deallocateInternalResourceEntity);
		assertTrue("0".equals(serviceResponse.getResult().getCode()));
	}
	
	@Test
	public void changeSpeedThrowsError() throws OSSBusinessException {
		
		DeallocateInternalResourceEntity serviceResponse = new DeallocateInternalResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.OFFER_EDITION);
		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		
		ChangeSpeedEntity changeSpeedEntity = new ChangeSpeedEntity();
		changeSpeedEntity.setCode("10");
		changeSpeedEntity.setDescription("Error change Speed");
		when(changeSpeedDao.changeSpeed(path.getCircPathInstId(), SPEED, "KB")).thenReturn(changeSpeedEntity);
		
		try {
			service.deallocateResource(entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
			assertTrue(Code.RIGRANITE_001.getValue().equals(e.getStatusCode()));
			assertTrue("Error change Speed".equals(e.getDescription()));
		}
	}
	
	@Test
	public void updateStatusThrowsError() throws OSSBusinessException {
		
		DeallocateInternalResourceEntity serviceResponse = new DeallocateInternalResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.OFFER_EDITION);
		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		
		ChangeSpeedEntity changeSpeedEntity = new ChangeSpeedEntity();
		changeSpeedEntity.setCode("0");
		when(changeSpeedDao.changeSpeed(path.getCircPathInstId(), SPEED, "KB")).thenReturn(changeSpeedEntity);
		
		ResultTo resultTo = new ResultTo();
		resultTo.setCode("10");
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(resultTo);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		when(retrieveMsanPotsDao.getMsanPots(anyString())).thenReturn(retrieveMsanPotsEntity);
		
		try {
			service.deallocateResource(entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
			assertTrue("10".equals(e.getStatusCode()));
			assertTrue("Erro ao atualizar o status do path".equals(e.getDescription()));
		}
	}
	
	@Test
	public void testDoExecutionOSSBusinessException() {
		
		OSSBusinessException exception=null; 
		
		try{
			entity.setResourceFacingService(null);
			service.deallocateResource(entity);
			
		}catch (Exception e) {
			exception = new OSSBusinessException("ERRO AO CANCELAR RESERVA: "+ e.getMessage(), "0", "RI-GRANITE");
		}
		assertNotNull(exception);
		
	}
	
	@Test
	public void deallocateSaleOfferWithUpdatePots() throws OSSBusinessException {
		
		DeallocateInternalResourceEntity serviceResponse = new DeallocateInternalResourceEntity();	
		serviceResponse.setCode("0");
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.SALE_OFFER);
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setId(729387L);
		retrieveMsanPotsEntity.setLic("A-000045-00");
		retrieveMsanPotsEntity.setIdMsan("CAS.CB.MSO02");
		retrieveMsanPotsEntity.setStatus(StatusMsanPotsType.FREE.getValue());

		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		
		when(cdao.getDeallocateInternalResource(anyObject())).thenReturn(serviceResponse);
		
		when(retrieveMsanPotsDao.getMsanPots(anyString())).thenReturn(retrieveMsanPotsEntity);
		
		DeallocateInternalResourceEntity deallocateInternalResourceEntity = service.deallocateResource(entity);
		
		assertNotNull(deallocateInternalResourceEntity);
		assertTrue("0".equals(serviceResponse.getResult().getCode()));
	}

}