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
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMaxSpeedResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.CustomerOrderType;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.enums.TypeAvailability;
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
public class ReserveTest {

	private static final String SPEEDY_MAX = "2048";
	private static final String SUCCESS = "0";

	@Mock
	private OSSLogger logger;
	
	@InjectMocks
	private ReservationResourceController service;
	
	@Mock
	private ReservationResourceMetallicController reserveResourceMetalicController;
	
	@Mock
	private ReserveResourceDao reserveResourceDao;
	
	@Mock
	public ChangeSpeedDao changeSpeedDao;
	
	@Mock
	private PathService pathService;

	@Mock
	private ResourceStatusDao resourceStatusDao;
	
	@Mock
	private RetrieveMsanPotsDao retrieveMsanPotsDao;
	
	@Mock
	private UpdateMsanPotsDao updateMsanPotsDao;
	
	@Mock
	private AvailabilityRetrieveMsanController serviceMsan;
	
	@Mock
	private ReserveResourceMapper mapper;

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
	public void testReserveResourceWithChangeAddress() throws OSSBusinessException {
		
		ReserveResourceEntity serviceResponse = getReserveResourceEntity();
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerOrderType(Operation.CHANGE_ADDRESS.getValue());
		entity.setCustomerOrder(customerOrder );
		
		
		ResourceInventoryEntity resourceInventoryEntity = new ResourceInventoryEntity();
		
		when(mapper.parseGetPhysicalReserveResource(serviceResponse, entity)).thenReturn(resourceInventoryEntity);
		when(reserveResourceMetalicController.validateReserve(entity)).thenReturn(serviceResponse);
		when(serviceMsan.getCheckMsan(anyObject(), anyObject(), anyObject())).thenReturn(getRetrieveAvailabilityMsan());
		
		ResourceInventoryEntity resourceInventory= service.reserveResource(entity);
		assertNotNull(resourceInventory);
	}

	@Test
	public void testDoExecutionChangeOfferSucess() throws OSSBusinessException {
		
		ReserveResourceEntity serviceResponse = getReserveResourceEntity();
		serviceResponse.setTelephonicArea(entity.getAddress().getTelephonicArea());
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerOrderType(Operation.CHANGE_OFFER.getValue());
		entity.setCustomerOrder(customerOrder);
		
		when(reserveResourceDao.reserveResource(anyObject())).thenReturn(serviceResponse);
		when(mapper.parseGetPhysicalReserveResource(serviceResponse, entity)).thenReturn(new ResourceInventoryEntity());
		when(reserveResourceMetalicController.validateReserve(entity)).thenReturn(serviceResponse);
		when(reserveResourceMetalicController.reserveOfferEdition(entity)).thenReturn(serviceResponse);
		
		
		ResourceInventoryEntity resourceInventory = service.reserveResource(entity);
		assertNotNull(resourceInventory);
	}
	
	@Test
	public void testDoExecutionSaleOfferSucess() throws OSSBusinessException {
		
		ReserveResourceEntity serviceResponse = getReserveResourceEntity();
		serviceResponse.setTelephonicArea(entity.getAddress().getTelephonicArea());
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerOrderType(Operation.SALE_OFFER.getValue());
		entity.setCustomerOrder(customerOrder);
		
		when(reserveResourceDao.reserveResource(anyObject())).thenReturn(serviceResponse);
		when(mapper.parseGetPhysicalReserveResource(serviceResponse, entity)).thenReturn(new ResourceInventoryEntity());
		when(reserveResourceMetalicController.validateReserve(entity)).thenReturn(serviceResponse);
		
		ResourceInventoryEntity resourceInventory = service.reserveResource(entity);
		assertNotNull(resourceInventory);
	}

	@Test
	public void testDoExecutionOfferEditionDslamSucess() throws OSSBusinessException {
		
		ResourceInventoryEntity resourceInventoryEntity = entity;
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerOrderType(CustomerOrderType.OFFER_EDITION.getValue());
		resourceInventoryEntity.setCustomerOrder(customerOrder);
		
		
		RetrieveMaxSpeedResourceEntity retrieveMaxSpeedResponse = new RetrieveMaxSpeedResourceEntity();
		retrieveMaxSpeedResponse.setSpeed(SPEEDY_MAX);
		when(reserveResourceDao.speedMax(anyObject())).thenReturn(retrieveMaxSpeedResponse);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.ACTIVE);
		path.setType(TypeAvailability.DSLAM.getTypes());
		when(pathService.getPath(entity, StatusPathType.ACTIVE)).thenReturn(path);
		
		ChangeSpeedEntity offerEditionEntity = new ChangeSpeedEntity();
		offerEditionEntity.setCode("0");
		offerEditionEntity.setDescription("Operacao efetuada com sucesso.");
		
		ResultTo resultTo = new ResultTo();
		resultTo.setCode("0");
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(resultTo);
		
		when(pathService.getEquipTypeActive(anyObject())).thenReturn(path);
		when(changeSpeedDao.changeSpeed(anyObject(), (String)anyObject(), (String)anyObject())).thenReturn(offerEditionEntity);
		when(mapper.parseGetPhysicalReserveResource(anyObject(), anyObject())).thenReturn(resourceInventoryEntity);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);
		
		ResourceInventoryEntity resourceInventory = null;
		resourceInventory = service.reserveResource(resourceInventoryEntity);
		assertNotNull(resourceInventory);
	}
	
	@Test
	public void testDoExecutionOfferEditionMsanSucess() throws OSSBusinessException {
		
		ResourceInventoryEntity resourceInventoryEntity = entity;
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerOrderType(CustomerOrderType.OFFER_EDITION.getValue());
		resourceInventoryEntity.setCustomerOrder(customerOrder);
		
		
		RetrieveMaxSpeedResourceEntity retrieveMaxSpeedResponse = new RetrieveMaxSpeedResourceEntity();
		retrieveMaxSpeedResponse.setSpeed(SPEEDY_MAX);
		when(reserveResourceDao.speedMax(anyObject())).thenReturn(retrieveMaxSpeedResponse);
		
		RetrievePathEntity path = new RetrievePathEntity();
		path.setCircPathInstId(1L);
		path.setStatus(StatusPathType.ACTIVE);
		path.setType(TypeAvailability.MSAN.getTypes());
		when(pathService.getPath(entity, StatusPathType.ACTIVE)).thenReturn(path);
		
		ChangeSpeedEntity offerEditionEntity = new ChangeSpeedEntity();
		offerEditionEntity.setCode("0");
		offerEditionEntity.setDescription("Operacao efetuada com sucesso.");
		
		ResultTo resultTo = new ResultTo();
		resultTo.setCode("0");
		ResourceStatusEntity updateResourceStatusEntity = new ResourceStatusEntity();
		updateResourceStatusEntity.setResult(resultTo);
		
		when(pathService.getEquipTypeActive(anyObject())).thenReturn(path);
		when(changeSpeedDao.changeSpeed(anyObject(), (String)anyObject(), (String)anyObject())).thenReturn(offerEditionEntity);
		when(mapper.parseGetPhysicalReserveResource(anyObject(), anyObject())).thenReturn(resourceInventoryEntity);
		when(resourceStatusDao.updateStatus(anyObject())).thenReturn(updateResourceStatusEntity);
		
		ResourceInventoryEntity resourceInventory = null;
		resourceInventory = service.reserveResource(resourceInventoryEntity);
		assertNotNull(resourceInventory);
	}
	
	private RetrieveAvailabilityTO getRetrieveAvailabilityMsan() {
		RetrieveAvailabilityTO retrieveAvailabilityTO = new RetrieveAvailabilityTO();
		retrieveAvailabilityTO.setEquipmentType("MSAN");
		return retrieveAvailabilityTO;
	}
	
	private ReserveResourceEntity getReserveResourceEntity() {
		ReserveResourceEntity serviceResponse = new ReserveResourceEntity();		
		ResultTo result = new ResultTo();
		result.setCode(ReserveTest.SUCCESS);
		serviceResponse.setResult(result);
		serviceResponse.setCnl(entity.getAddress().getCnl());
		return serviceResponse;
	}
	
}