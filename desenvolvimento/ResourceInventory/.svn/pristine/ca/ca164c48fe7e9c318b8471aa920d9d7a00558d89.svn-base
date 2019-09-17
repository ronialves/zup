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
import com.tlf.oss.resourceinventory.sagre.entity.InstallResourceEntity;
import com.tlf.oss.resourceinventory.sagre.repository.InstallRepository;
import com.tlf.oss.resourceinventory.sagre.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

	@RunWith(MockitoJUnitRunner.class)
	public class InstallResourceTest {

		@InjectMocks
		private InstallController installController;

		@Mock
		private InstallRepository installRepository;

		@Mock
		private OSSLogger logger;

		private ResourceInventoryEntity resourceInventoryEntity;
		private InstallResourceEntity serviceResponse;

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
			
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.setServiceId("BRU-02282072-069");
			
			serviceResponse = new InstallResourceEntity();
			ResultTo result = new ResultTo();
			result.setCode("0");
			serviceResponse.setResult(result);
			serviceResponse.setCnl(Integer.parseInt(resourceInventoryEntity.getAddress().getCnl()));
			serviceResponse.setResultCode(0);
			
			resourceInventoryEntity.setResourceFacingService(resourceFacingService);
		}

		@Test
		public void testDoExecution() throws OSSBusinessException {
			when(installRepository.install((anyObject()))).thenReturn(serviceResponse);
			ResourceInventoryEntity out = installController
					.install(resourceInventoryEntity);

			assertNotNull(out);
			assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
		}

		@Test
		public void testDoExecutionOSSBusinessException() {

			OSSBusinessException exception = null;

			try {
				resourceInventoryEntity.setAddress(null);
				installController.install(resourceInventoryEntity);

			} catch (Exception e) {
				exception = new OSSBusinessException("Code: 0", "RI-SAGRE", "ERRO: " + e.getMessage());
			}

			assertNotNull(exception);

		}

	}
