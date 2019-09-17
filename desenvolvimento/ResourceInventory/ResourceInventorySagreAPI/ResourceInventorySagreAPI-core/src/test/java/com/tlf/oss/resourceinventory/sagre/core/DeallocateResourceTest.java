package com.tlf.oss.resourceinventory.sagre.core;

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
import com.tlf.oss.resourceinventory.sagre.entity.DeallocateResourceEntity;
import com.tlf.oss.resourceinventory.sagre.repository.DeallocateRepository;
import com.tlf.oss.resourceinventory.sagre.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * BEATRIXTWO-935 | DEMOSS-2995
 * @project Beatrix Fase 2
 * @author renan.n.oliveira
 * @since 201803
 */

@RunWith(MockitoJUnitRunner.class)
public class DeallocateResourceTest {

	@InjectMocks
	private DeallocateController deallocateController;

	@Mock
	private DeallocateRepository deallocateRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity resourceInventoryEntity;
	private DeallocateResourceEntity serviceResponse;
	
	@Before
	public void before() {

		resourceInventoryEntity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("41000");
		address.setNetworkOwner("VIVO2");

		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		physicalLink.setVoiceProtocol("SIP");

		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);

		resourceInventoryEntity.setAddress(address);
		resourceInventoryEntity.setResourceFacingService(new ResourceFacingService());
		resourceInventoryEntity.getResourceFacingService().setServiceId("ARQ-02294391-069");
		resourceInventoryEntity.setCabinet(new Cabinet());
		resourceInventoryEntity.getCabinet().setStatus("DS");
		
		serviceResponse = new DeallocateResourceEntity();		
		serviceResponse.setCnl(Integer.parseInt(resourceInventoryEntity.getAddress().getCnl()));
		serviceResponse.setAccessTechnology(
				resourceInventoryEntity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		serviceResponse.setVoiceTechnology(
				resourceInventoryEntity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		serviceResponse.setAccessId(resourceInventoryEntity.getResourceFacingService().getServiceId());
		serviceResponse.setType(resourceInventoryEntity.getCabinet().getStatus());
		serviceResponse.setResultCode(0);
		serviceResponse.setMessage("MESSAGE");
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);		
	}
	
	@Test
	public void testDoExecution() throws OSSBusinessException {
		when(deallocateRepository.deallocate((anyObject()))).thenReturn(serviceResponse);
		ResourceInventoryEntity out = deallocateController.deallocate(resourceInventoryEntity);

		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
	}
	
	@Test
	public void testDoExecutionOSSBusinessException() {
		OSSBusinessException exception = null;

		try {
			resourceInventoryEntity.setAddress(null);
			deallocateController.deallocate(resourceInventoryEntity);
		} catch (Exception e) {
			exception = new OSSBusinessException("Code: 0", "RI-SAGRE", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);
	}
}
