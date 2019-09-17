package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.repository.UpdateResourcesServiceAmoDao;
import com.tlf.oss.resourceinventory.granite.core.entity.AllocateResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusGponEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.UpdateResourcesServiceAmoEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.repository.AllocateResourceGponDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusGponDao;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AllocateResourceGponControllerTest {

	@InjectMocks
	AllocateResourceGponController allocateResourceGponController;

	@Mock
	private AllocateResourceGponDao allocateResourceGponDao;
	
	@Mock
	private ResourceStatusGponDao resourceStatusGponDao;
	
	@Mock
	UpdateResourcesServiceAmoDao updateResourcesServiceAmoDao;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {

		entity = new ResourceInventoryEntity();
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("110748763444230");

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NRC");

		List<ServiceSpecCharDescribes> servicesSpecCharDescribes = new ArrayList<>();
		ServiceSpecCharDescribes specCharDescribes = new ServiceSpecCharDescribes();
		specCharDescribes.setValue("C000048438");
		servicesSpecCharDescribes.add(specCharDescribes);
		serviceDescribedBy.setServiceSpecCharDescribes(servicesSpecCharDescribes);

		List<ServiceDescribedBy> listServiceDescribedBy = new ArrayList<>();
		listServiceDescribedBy.add(serviceDescribedBy);

		resourceFacingService.setServiceDescribedBy(listServiceDescribedBy);

		entity.setResourceFacingService(resourceFacingService);
	}

	@Test
	public void shouldAllocateResource() throws OSSBusinessException {

		AllocateResourceGponEntity allocateResourceGponEntity = getAllocateResourceGponEntity(entity);
		allocateResourceGponEntity.setCode("0");

		when(allocateResourceGponDao.allocateResource(anyObject())).thenReturn(allocateResourceGponEntity);

		entity = allocateResourceGponController.allocateResource(entity, Operation.SALE_OFFER);
		assertEquals("C000048438", entity.getResourceFacingService()
				.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue());
		assertEquals("110748763444230", entity.getResourceFacingService().getServiceId());
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldNotAllocateResource() throws OSSBusinessException {

		AllocateResourceGponEntity resourceGponEntity = getAllocateResourceGponEntity(entity);
		resourceGponEntity.setCode("10");
		resourceGponEntity.setDescription(Code.RIGRANITE_003.getDescription());

		when(allocateResourceGponDao.allocateResource(anyObject())).thenReturn(resourceGponEntity);
		try {
			entity = allocateResourceGponController.allocateResource(entity, Operation.SALE_OFFER);
		} catch (OSSBusinessException e) {
			assertNotNull(e.getDescription());
			assertTrue(e.getDescription().contains("Erro ao chamar a procedure"));
			throw e;
		}
	}

	private AllocateResourceGponEntity getAllocateResourceGponEntity(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		AllocateResourceGponEntity resourceGponEntity = new AllocateResourceGponEntity();

		resourceGponEntity.setCustomerId(getResourceFacingServiceByValue(entity, "NRC"));
		resourceGponEntity.setAccessDesignator(entity.getResourceFacingService().getServiceId());

		return resourceGponEntity;
	}
	
	private ResourceStatusGponEntity getResourceStatusGponEntity(final ResourceInventoryEntity entity) {
		entity.getResourceFacingService().setStatus(StatusPathType.IN_CONFIGURATION.getValue());
		final ResourceStatusGponEntity updateEntity = new ResourceStatusGponEntity();
		updateEntity.setTerminal(entity.getResourceFacingService().getServiceId());
		updateEntity.setStatus(entity.getResourceFacingService().getStatus());
		
		return updateEntity;
	}

	private String getResourceFacingServiceByValue(ResourceInventoryEntity entity, String value) {

		Optional<ServiceDescribedBy> serviceDescribedBy = entity.getResourceFacingService().getServiceDescribedBy()
				.stream()
				.filter(s -> value.equals(s.getName()))
				.findFirst();

		if (serviceDescribedBy.isPresent()) {
			Optional<String> serviceSpecCharDescribes = serviceDescribedBy.get().getServiceSpecCharDescribes()
					.stream()
					.filter(s -> !s.getValue().isEmpty())
					.map(ServiceSpecCharDescribes::getValue)
					.findFirst();

			if (serviceSpecCharDescribes.isPresent()) {
				return serviceSpecCharDescribes.get();
			}
		}

		return "";
	}
	
	@Test
	public void shouldAllocateResourceOfferEdition() throws OSSBusinessException {
		
		ResourceStatusGponEntity allocateResourceGponEntity = getResourceStatusGponEntity(entity);
		allocateResourceGponEntity.setReturnCode("0");
		when(resourceStatusGponDao.updateStatus(anyObject())).thenReturn(allocateResourceGponEntity);
		
		final UpdateResourcesServiceAmoEntity updateResourcesServiceAmoEntity = new UpdateResourcesServiceAmoEntity();
		updateResourcesServiceAmoEntity.setAccessDesignator(entity.getResourceFacingService().getServiceId());
		updateResourcesServiceAmoEntity.setStatus(entity.getResourceFacingService().getStatus());
		updateResourcesServiceAmoEntity.setCode(allocateResourceGponEntity.getReturnCode());
		when(updateResourcesServiceAmoDao.updateResourcesServiceAmo(anyObject())).thenReturn(updateResourcesServiceAmoEntity);

		entity = allocateResourceGponController.allocateResource(entity, Operation.OFFER_EDITION);
		assertEquals("C000048438", entity.getResourceFacingService()
				.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue());
		
		assertEquals("110748763444230", entity.getResourceFacingService().getServiceId());
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldNotAllocateResourceOfferEdition() throws OSSBusinessException {

		ResourceStatusGponEntity allocateResourceGponEntity = getResourceStatusGponEntity(entity);
		allocateResourceGponEntity.setReturnCode("10");
		allocateResourceGponEntity.setReturnMessage(Code.RIGRANITE_003.getDescription());

		when(resourceStatusGponDao.updateStatus(anyObject())).thenReturn(allocateResourceGponEntity);

		try {
			entity = allocateResourceGponController.allocateResource(entity, Operation.OFFER_EDITION);
		} catch (OSSBusinessException e) {
			assertNotNull(e.getMessage());
			assertTrue(e.getDetail().contains("Erro ao chamar a procedure"));
			throw e;
		}
	}
}
