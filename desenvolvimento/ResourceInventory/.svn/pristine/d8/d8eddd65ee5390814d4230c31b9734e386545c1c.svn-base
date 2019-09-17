package com.tlf.oss.resourceinventory.granite.core;

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
import com.tlf.oss.resourceinventory.granite.core.entity.DeallocateInternalResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ServiceCodeEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.UpdateResourcesServiceAmoEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.repository.CancelChangeSpeedGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.DeallocateInternalResourceGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveServiceCodeDao;
import com.tlf.oss.resourceinventory.granite.core.repository.UpdateResourcesServiceAmoDao;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class DeallocateGponControllerTest {
	@Mock
	private OSSLogger logger;
	
	@Mock
	private DeallocateInternalResourceGponDao deallocateGponDao;
	
	@Mock
	private CancelChangeSpeedGponDao cancelChangeSpeedGponDao;
	
	@Mock 
	private UpdateResourcesServiceAmoDao updateResourcesServiceAmoDao;
	
	@Mock
	private ResourceStatusGponDao resourceStatusGponDao;
	
	@Mock
	private RetrieveServiceCodeDao retrieveServiceCodeDao;
	
	@InjectMocks
	private DeallocateGponController deallocateGponController;
	
	private ResourceInventoryEntity entity;
	
	@Before
	public void before() {

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
	
		ArrayList<CustomerFacingService> customerFacingService = new ArrayList<CustomerFacingService>();
		CustomerFacingService cfs = new CustomerFacingService();
		CustomerFacingService cfs2 = new CustomerFacingService();
		cfs.setCategory("VOIP");
		customerFacingService.add(cfs);
		
		
		
		cfs2.setCategory("BROADBAND");
		cfs2.setServiceDescribedBy(new ArrayList<ServiceDescribedBy>());
		
		
		ServiceDescribedBy sdb = new ServiceDescribedBy();
		sdb.setName("downstream");
		sdb.setServiceSpecCharDescribes(new ArrayList<ServiceSpecCharDescribes>());
		ServiceSpecCharDescribes spcd = new ServiceSpecCharDescribes();
		spcd.setValue("25600");
		sdb.getServiceSpecCharDescribes().add(spcd);
		
		ServiceDescribedBy sdb2 = new ServiceDescribedBy();	
		sdb2.setName("IP");
		sdb2.setServiceSpecCharDescribes(new ArrayList<ServiceSpecCharDescribes>());
		ServiceSpecCharDescribes spcd2 = new ServiceSpecCharDescribes();
		spcd2.setValue("DYNAMIC");
		
		sdb2.getServiceSpecCharDescribes().add(spcd2);

		cfs2.getServiceDescribedBy().add(sdb);
		cfs2.getServiceDescribedBy().add(sdb2);
		
		customerFacingService.add(cfs2);
		
     	CustomerOrder customerOrder = new CustomerOrder();
     	customerOrder.setPurchaseOrderNumber("TESTE");
     	
     	entity.setCustomerFacingService(customerFacingService);
		entity.setCustomerOrder(customerOrder);
		entity.setAddress(address);
		entity.setResourceFacingService(resourceFacingService);
		
	}
	
	@Test
	public void doExecutionSucessOfferEdition() throws OSSBusinessException {

		final UpdateResourcesServiceAmoEntity updateResourcesServiceAmoEntity = new UpdateResourcesServiceAmoEntity();
		final ResourceStatusGponEntity entityGponStatus = new ResourceStatusGponEntity();

		updateResourcesServiceAmoEntity.setAccessDesignator(entity.getResourceFacingService().getServiceId());
		updateResourcesServiceAmoEntity.setStatus(entity.getResourceFacingService().getStatus());
		updateResourcesServiceAmoEntity.setCode("0");

		final ServiceCodeEntity serviceCodeEntity = new ServiceCodeEntity();
		serviceCodeEntity.setServiceCode("IPSF02");
		when(retrieveServiceCodeDao.retrieveServiceCode(anyObject())).thenReturn(serviceCodeEntity);

		updateResourcesServiceAmoEntity.setServiceCode(serviceCodeEntity.getServiceCode());

		when(updateResourcesServiceAmoDao.updateResourcesServiceAmo(anyObject())).thenReturn(updateResourcesServiceAmoEntity);

		ResultTo result = new ResultTo();
		result.setCode("0");
		entityGponStatus.setResult(result);

		when(resourceStatusGponDao.updateStatus(anyObject())).thenReturn(entityGponStatus);

		deallocateGponController.doExecution(entity, Operation.OFFER_EDITION);

		assertNotNull(entity);
	}
	
	
	@Test(expected=OSSBusinessException.class)
	public void failExecutionOfferEditionGetCode() throws OSSBusinessException {
		UpdateResourcesServiceAmoEntity updateResourcesServiceAmoEntity = new UpdateResourcesServiceAmoEntity();
		
		updateResourcesServiceAmoEntity.setCode("10");
		
		final ServiceCodeEntity serviceCodeEntity = new ServiceCodeEntity();
		serviceCodeEntity.setServiceCode("IPSF02");
		when(retrieveServiceCodeDao.retrieveServiceCode(anyObject())).thenReturn(serviceCodeEntity);
		
		when(updateResourcesServiceAmoDao.updateResourcesServiceAmo(anyObject())).thenReturn(updateResourcesServiceAmoEntity);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		deallocateGponController.doExecution(entity, Operation.OFFER_EDITION);
	}
	
	@Test(expected=NullPointerException.class)
	public void failExecutionOfferEditionNullResourceFacingService() throws OSSBusinessException {
		UpdateResourcesServiceAmoEntity updateResourcesServiceAmoEntity = new UpdateResourcesServiceAmoEntity();
		
		ResourceInventoryEntity nullRecourceFacingServiceEntity = entity;
		
		nullRecourceFacingServiceEntity.setResourceFacingService(null);
		
		when(updateResourcesServiceAmoDao.updateResourcesServiceAmo(anyObject())).thenReturn(updateResourcesServiceAmoEntity);
		
		Mockito.doNothing().when(logger).error(anyString(), anyObject());
		
		deallocateGponController.doExecution(nullRecourceFacingServiceEntity, Operation.OFFER_EDITION);
	}

	
	@Test
	public void doExecutionSucessNonOfferEdition() throws OSSBusinessException {
		
		DeallocateInternalResourceGponEntity deallocateInternalResourceGponEntity = new DeallocateInternalResourceGponEntity();
		
		deallocateInternalResourceGponEntity.setCode("0");
		
		when(deallocateGponDao.getDeallocateInternalResource(anyObject())).thenReturn(deallocateInternalResourceGponEntity);
		
		deallocateGponController.doExecution(entity, Operation.CHANGE_OFFER);
		
		assertNotNull(entity);
		
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void failExecutionNonOfferEditionGetCode() throws OSSBusinessException {
		
		DeallocateInternalResourceGponEntity deallocateInternalResourceGponEntity = new DeallocateInternalResourceGponEntity();
		
		deallocateInternalResourceGponEntity.setCode("10");
		
		when(deallocateGponDao.getDeallocateInternalResource(anyObject())).thenReturn(deallocateInternalResourceGponEntity);
		
		deallocateGponController.doExecution(entity, Operation.SALE_OFFER);
		
	}
	
	@Test(expected=OSSBusinessException.class)
	public void failExecutionNonOfferEditionNullResourceFacingService() throws OSSBusinessException {
		
		DeallocateInternalResourceGponEntity deallocateInternalResourceGponEntity = new DeallocateInternalResourceGponEntity();

		ResourceInventoryEntity nullRecourceFacingServiceEntity = entity;
		
		nullRecourceFacingServiceEntity.setResourceFacingService(null);
		
		when(deallocateGponDao.getDeallocateInternalResource(anyObject())).thenReturn(deallocateInternalResourceGponEntity);
		
		deallocateGponController.doExecution(nullRecourceFacingServiceEntity, Operation.SALE_OFFER);
		
	}
	
}
