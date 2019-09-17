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
import com.tlf.oss.resourceinventory.granite.core.entity.AllocateResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.AllocateResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
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
public class AllocateResourceMetallicControllerTest {

	@InjectMocks
	private AllocateResourceMetallicController allocateController;

	@Mock
	private AllocateResourceDao allocateResourceDao;
	
	@Mock
	private OSSLogger logger;

	@Mock
	private PathService pathService;

	@Mock
	private ResourceStatusDao resourceStatusDao;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {
		
		entity = new ResourceInventoryEntity();
		
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
		
		ServiceSpecCharDescribes serviceSpecCharDescribesNrc = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesNrc.setValue("C066532635");
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesNrcList = new ArrayList<>();
		serviceSpecCharDescribesNrcList.add(serviceSpecCharDescribesNrc);

		ServiceDescribedBy serviceDescribedByNrc = new ServiceDescribedBy();
		serviceDescribedByNrc.setName("NRC");
		serviceDescribedByNrc.setServiceSpecCharDescribes(serviceSpecCharDescribesNrcList);
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		serviceDescribedByList.add(serviceDescribedByNrc);	
		
		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);
		
		entity.setAddress(address);
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);
	}

	@Test
	public void testAllocateResourceSucess() throws OSSBusinessException {
		AllocateResourceEntity serviceResponse = new AllocateResourceEntity();

		serviceResponse.setCnl(entity.getAddress().getCnl());
		serviceResponse.setCode(0);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.RESERVED);

		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(path);
		
		ResultTo resultTo = new ResultTo();
		resultTo.setCode("0");
		
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(resultTo);
		
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);

		when(allocateResourceDao.allocateResource(anyObject())).thenReturn(serviceResponse);
		
		allocateController.allocateResource(entity);
	}

	@Test(expected= OSSBusinessException.class)
	public void testAllocateResourceOSSException() throws OSSBusinessException {
		AllocateResourceEntity serviceResponse = new AllocateResourceEntity();

		serviceResponse.setCnl(entity.getAddress().getCnl());
		serviceResponse.setCode(10);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.RESERVED);

		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(path);
		
		ResultTo resultTo = new ResultTo();
		resultTo.setCode("0");
		
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(resultTo);
		
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);

		when(allocateResourceDao.allocateResource(anyObject())).thenReturn(serviceResponse);
		
		allocateController.allocateResource(entity);
	}

	
	@Test
	public void updateStatusError() throws OSSBusinessException {
		AllocateResourceEntity serviceResponse = new AllocateResourceEntity();
		serviceResponse.setCode(0);
		serviceResponse.setCnl(entity.getAddress().getCnl());

		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.RESERVED);
		
		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(path);
		
		ResultTo resultTo = new ResultTo();
		resultTo.setCode("10");
		
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(resultTo);
		
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);

		when(allocateResourceDao.allocateResource(anyObject())).thenReturn(serviceResponse);
		
		try {
			allocateController.allocateResource(entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
			assertEquals(e.getStatusCode(), "10");
			assertEquals(e.getDescription(), "Erro ao atualizar o status do path");
		}
	}
	
/*	@Test(expected=OSSBusinessException.class)
	public void testAllocateResourceOSSBusinessException() throws OSSBusinessException {
		ResourceFacingService resourceFacingService = new ResourceFacingService();	
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);
		entity.setResourceFacingService(resourceFacingService);
		
		AllocateResourceEntity serviceResponse = new AllocateResourceEntity();
		
		serviceResponse.setCode(0);
		serviceResponse.setCnl(entity.getAddress().getCnl());
		
		ResultTo result = new ResultTo();
		result.setCode("0");
		
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(result);

		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.RESERVED);
		
		when(pathService.getPath(entity, StatusPathType.RESERVED)).thenReturn(path);
			
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);
		
		when(allocateResourceDao.allocateResource(anyObject())).thenReturn(serviceResponse);
		
		allocateController.allocateResource(entity);

	}*/



}
