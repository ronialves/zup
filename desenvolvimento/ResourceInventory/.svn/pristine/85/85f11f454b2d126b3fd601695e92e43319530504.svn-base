package com.tlf.oss.resourceinventory.tbs.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.core.v2_0.FacilityResourceController;
import com.tlf.oss.resourceinventory.tbs.entity.v2_0.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.tbs.repository.v2_0.FacilityResourceRepository;

@RunWith(MockitoJUnitRunner.class)
public class FacilityTest {
	
	@InjectMocks
	private FacilityResourceController facilityController;
	
	@Mock
	private FacilityResourceRepository facilityRepository;
	
	@Mock
	private OSSLogger logger;
	
	private ResourceInventoryEntity resourceInventoryEntity;
	private RetrieveFacilityEntity retrieveFacilityEntity;
	
	@Before
	public void before() {

		resourceInventoryEntity = buildResourceInventoryEntity();
		retrieveFacilityEntity = buildInstallEntity(resourceInventoryEntity);
	}

	@Test
	public void testDoExecution() throws OSSBusinessException {
		when(facilityRepository.retrieveFacility((anyObject()))).thenReturn(retrieveFacilityEntity);
		ResourceInventoryEntity out = facilityController.retrieveFacility(resourceInventoryEntity);

		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(retrieveFacilityEntity.getResultCode().toString()));
	}

	@Test
	public void testDoExecutionOSSBusinessException() {
		OSSBusinessException exception = null;

		try {
			resourceInventoryEntity.setCustomerOrder(null);;
			facilityController.retrieveFacility(resourceInventoryEntity);

		} catch (Exception e) {
			exception = new OSSBusinessException("ERRO: " + e.getMessage(), "0", "RI-TBS");
		}

		assertNotNull(exception);
	}

	
	private ResourceInventoryEntity buildResourceInventoryEntity(){
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("CTA-818CTJ7SD-013");
		
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrderItem.setId("19738753");
		
		ResourceOrder resourceOrder = new ResourceOrder();
		resourceOrder.setResourceOrderItem(resourceOrderItem);
		
		entity.setResourceFacingService(resourceFacingService);
		entity.setResourceOrder(resourceOrder);
		
		return entity;
	}
	
	
	private RetrieveFacilityEntity buildInstallEntity(ResourceInventoryEntity entity){
		retrieveFacilityEntity = new RetrieveFacilityEntity();
		
		retrieveFacilityEntity.setDesignator(entity.getResourceFacingService().getServiceId());
		retrieveFacilityEntity.setIpAddress("10.18.76.235");
		retrieveFacilityEntity.setActivity("N");
		retrieveFacilityEntity.setResultCode(0);
		retrieveFacilityEntity.setMessage("SUCESSO");
		
		return retrieveFacilityEntity;
	}
	

}
