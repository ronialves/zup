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
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusGponEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusGponDao;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class ResourceStatusGponControllerTest {

	@Mock
	private OSSLogger logger;
	
	@Mock
	private ResourceStatusGponDao resourceStatusDao;
	
	@InjectMocks
	private InstallGponController controller;
	
	private ResourceInventoryEntity entity;
	

	@Before
	public void before(){
		entity = new ResourceInventoryEntity();
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("C000048789");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NRC");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		
		resourceFacingService.setServiceDescribedBy(new ArrayList<>());
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
		
		entity.setResourceFacingService(resourceFacingService);		
	}

	@Test
	public void testDoExecutionOSSBusiness(){
		
		OSSBusinessException exception = null;
		
		try{
			entity.setResourceFacingService(null);
			controller.doExecution(entity);
		}
		catch (Exception e){
			exception = new OSSBusinessException("ERRO AO ATUALIZAR ESTADO INTERNO "+ e.getMessage(), "0", "RI-GRANITE");
		}
		
		assertNotNull(exception);

	}
	
	@Test
	public void testDoExecution() throws OSSBusinessException {
		ResourceStatusGponEntity serviceResponse = new ResourceStatusGponEntity();
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);

		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(serviceResponse);
		
		ResourceStatusGponEntity resourceStatusEntity = controller.updateStatus(entity);
		ResourceInventoryEntity t = controller.doExecution(entity);
		
		assertNotNull(t);
		assertTrue("0".equals(resourceStatusEntity.getResult().getCode()));	
	}
	
	@Test(expected=OSSBusinessException.class)
	public void testResultNotSuccess() throws OSSBusinessException {
		ResourceStatusGponEntity serviceResponse = new ResourceStatusGponEntity();
		ResultTo result = new ResultTo();
		result.setCode("1");
		result.setDescription("Erro");
		serviceResponse.setResult(result);

		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(serviceResponse);
		
		ResourceStatusGponEntity resourceStatusEntity = controller.updateStatus(entity);
		ResourceInventoryEntity t = controller.doExecution(entity);
		
		assertNotNull(t);
		assertTrue("1".equals(resourceStatusEntity.getResult().getCode()));	
	}
}
