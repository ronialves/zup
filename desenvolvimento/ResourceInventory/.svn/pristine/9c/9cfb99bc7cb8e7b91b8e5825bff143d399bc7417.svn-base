package com.tlf.oss.resourceinventory.granite.core;

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
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.ReserveResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.repository.ChangeSpeedDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ReserveResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.repository.UpdateMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.granite.core.to.RetrieveAvailabilityTO;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;


@RunWith(MockitoJUnitRunner.class)
public class ReservationResourceControllerTest {
	
	@InjectMocks
	private ReservationResourceController  reserveResourceController;
	
	@Mock
	private RetrieveMsanPotsDao retrieveMsanPotsDao;
	
	@Mock
	private ReserveResourceMapper mapper;
	
	@Mock
	private ReservationResourceMetallicController reserveResourceMetallicController;
	
	@Mock
	private UpdateMsanPotsDao updateMsanPotsDao;
	
	@Mock
	public ReserveResourceDao rdao;
	
	@Mock
	private PathService pathService;
	
	@Mock
	public ChangeSpeedDao changeSpeedDao;
	
	@Mock
	private ResourceStatusDao resourceStatusDao;
	
	@Mock
	private OSSLogger logger;
	
	@Mock
	private ReserveResourceDao reserveResourceDao;
	
	private ResourceInventoryEntity entity;
	
	@Before
	public void before() {
		
		entity = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		
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
		entity.setCabinet(cabinet);
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);
	}

	@Test
	public void testReserveResourceMSANSucess() throws OSSBusinessException {
		
		CustomerOrder customer = new CustomerOrder();
		customer.setCustomerOrderType("Venda de Oferta");
		entity.setCustomerOrder(customer);
		
		RetrieveAvailabilityTO retrieveAvailabilityTO = new RetrieveAvailabilityTO();
		retrieveAvailabilityTO.setEquipmentType("MSAN");
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setIdConexoesPotsMsan(121212L);
		retrieveMsanPotsEntity.setId(1L);
		retrieveMsanPotsEntity.setIdMsan("2");
		retrieveMsanPotsEntity.setLic("4545-0");
		
		ReserveResourceEntity reserveResourceEntity = new ReserveResourceEntity();
		reserveResourceEntity.setCode("0");
		ResultTo result = new ResultTo();
		result.setCode("0");
		reserveResourceEntity.setResult(result);
		
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		when(rdao.reserveResource(anyObject())).thenReturn(reserveResourceEntity);
		when(reserveResourceMetallicController.validateReserve(anyObject())).thenReturn(reserveResourceEntity);
		when(mapper.parseGetPhysicalReserveResource(anyObject(),anyObject())).thenReturn(entity);
		
		entity = reserveResourceController.reserveResource(entity);
		
		assertNotNull(entity);
	}
	
	@Test
	public void testReserveAlreadyExistsSucess() throws OSSBusinessException {
		
		CustomerOrder customer = new CustomerOrder();
		customer.setCustomerOrderType("Venda de Oferta");
		entity.setCustomerOrder(customer);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1542L);
		path.setStatus(StatusPathType.RESERVED);
		
		List<RetrievePathEntity>listPath = new ArrayList<>();
		listPath.add(path);
		
		RetrieveAvailabilityTO retrieveAvailabilityTO = new RetrieveAvailabilityTO();
		retrieveAvailabilityTO.setEquipmentType("MSAN");
		
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = new RetrieveMsanPotsEntity();
		retrieveMsanPotsEntity.setIdConexoesPotsMsan(121212L);
		retrieveMsanPotsEntity.setId(1L);
		retrieveMsanPotsEntity.setIdMsan("2");
		retrieveMsanPotsEntity.setLic("4545-0");
		
		ReserveResourceEntity reserveResourceEntity = new ReserveResourceEntity();
		reserveResourceEntity.setCode("0");
		ResultTo result = new ResultTo();
		result.setCode("0");
		reserveResourceEntity.setResult(result);
		
		when(retrieveMsanPotsDao.getMsanPots(anyObject())).thenReturn(retrieveMsanPotsEntity);
		when(rdao.reserveResource(anyObject())).thenReturn(reserveResourceEntity);
		when(reserveResourceMetallicController.validateReserve(anyObject())).thenReturn(reserveResourceEntity);
		when(mapper.parseGetPhysicalReserveResource(anyObject(),anyObject())).thenReturn(entity);
		when(pathService.getPaths(anyObject())).thenReturn(listPath);
		
		entity = reserveResourceController.reserveResource(entity);
		
		assertNotNull(entity);
	}
	
}
