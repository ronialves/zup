package com.tlf.oss.resourceinventory.granite.core;

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
import com.tlf.oss.resourceinventory.granite.core.entity.DeallocateInternalResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.DeallocateInternalResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class ResourceStatusMetallicControllerTest {
	
	@Mock
	private OSSLogger logger;
	
	@Mock
	private ResourceStatusDao resourceStatusDao;
	
	@Mock
	public DeallocateInternalResourceDao cdao;
	
	@Mock
	private PathService pathService;
	
	@InjectMocks
	private InstallMetallicController resourceStatusMetallicController;
	
	private ResourceInventoryEntity entity;
	
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
		
		resourceFacingService.setServiceDescribedBy(new ArrayList<>());
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
		
		entity.setResourceFacingService(resourceFacingService);		
	}

	@Test
	public void testDoExecution() throws OSSBusinessException {
		ResourceStatusEntity serviceResponse = new ResourceStatusEntity();
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.ACTIVE);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		
		when(pathService.getPath(entity, StatusPathType.ACTIVE)).thenReturn(path);
		
		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(serviceResponse);		
		
		ResourceInventoryEntity resourceInventoryEntity = resourceStatusMetallicController.doExecution(entity);
		
		assertNotNull(resourceInventoryEntity);
		assertTrue("0".equals(serviceResponse.getResult().getCode()));	
	}
	
	@Test
	public void testSaleWithOnePath() throws OSSBusinessException {
		ResourceStatusEntity serviceResponse = new ResourceStatusEntity();
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.ACTIVE);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.OFFER_EDITION);
		
		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
		
		when(pathService.getPath(entity, StatusPathType.ACTIVE)).thenReturn(path);
		
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(serviceResponse);		
		
		ResourceInventoryEntity resourceInventoryEntity = resourceStatusMetallicController.doExecution(entity);
		
		assertNotNull(resourceInventoryEntity);
		assertNotNull(path);
		assertTrue("0".equals(serviceResponse.getResult().getCode()));	
	}
	
	@Test
	public void testSaleWithTwoPaths() throws OSSBusinessException {
		ResourceStatusEntity serviceResponse = new ResourceStatusEntity();
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		DeallocateInternalResourceEntity deallocateInternalResourceEntity = new DeallocateInternalResourceEntity();
		deallocateInternalResourceEntity.setCode("0");
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.ACTIVE);
		path.setStatus(StatusPathType.IN_CONFIGURATION);
		path.setOperation(Operation.CHANGE_OFFER);
		
		when(pathService.getPath(entity, StatusPathType.ACTIVE)).thenReturn(path);
		
		when(pathService.getPath(entity, StatusPathType.IN_CONFIGURATION)).thenReturn(path);
				
		when(cdao.getDeallocateInternalResource(anyObject())).thenReturn(deallocateInternalResourceEntity);
		
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(serviceResponse);
		
		ResourceInventoryEntity resourceInventoryEntity = resourceStatusMetallicController.doExecution(entity);
		
		assertNotNull(resourceInventoryEntity);
		assertNotNull(path);
		assertTrue("0".equals(serviceResponse.getResult().getCode()));	
	}
	
	@Test
	public void testDoExecutionOSSBusiness(){
		
		ResourceStatusEntity serviceResponse = new ResourceStatusEntity();
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		
		OSSBusinessException exception = null;
		
		try{
			entity.setResourceFacingService(null);
			resourceStatusMetallicController.doExecution(entity);
		}
		catch (Exception e){
			exception = new OSSBusinessException("ERRO AO ATUALIZAR ESTADO INTERNO "+ e.getMessage(), "0", "RI-GRANITE");
		}
		
		assertNotNull(exception);

	}
}