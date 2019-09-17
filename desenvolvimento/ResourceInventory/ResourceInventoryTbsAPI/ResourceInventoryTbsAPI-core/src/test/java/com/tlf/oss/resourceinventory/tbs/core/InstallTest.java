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
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.entity.InstallEntity;
import com.tlf.oss.resourceinventory.tbs.repository.InstallRepository;

/**
 * BEATRIXTWO-29 | DEMOSS-2218
 * 
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@RunWith(MockitoJUnitRunner.class)
public class InstallTest {

	@InjectMocks
	private InstallController installController;

	@Mock
	private InstallRepository installRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity resourceInventoryEntity;
	private InstallEntity installResponse;

	@Before
	public void before() {

		resourceInventoryEntity = buildResourceInventoryEntity();
		installResponse = buildInstallEntity(resourceInventoryEntity);
	}

	@Test
	public void testDoExecution() throws OSSBusinessException {
		when(installRepository.getInstall((anyObject()))).thenReturn(installResponse);
		ResourceInventoryEntity out = installController.getInstall(resourceInventoryEntity);

		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(installResponse.getReturnCode().toString()));
	}

	@Test
	public void testDoExecutionOSSBusinessException() {
		OSSBusinessException exception = null;

		try {
			installController.getInstall(resourceInventoryEntity);

		} catch (Exception e) {
			exception = new OSSBusinessException("Code: 0", "RI-TBS", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);
	}

	
	private ResourceInventoryEntity buildResourceInventoryEntity(){
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("BRU-02282072-069");
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("8-A4336E869B-1");
		
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerOrder(customerOrder);
		
		return entity;
	}
	
	
	private InstallEntity buildInstallEntity(ResourceInventoryEntity entity){
		installResponse = new InstallEntity();

		installResponse.setPurchaseOrderNumber(entity.getCustomerOrder().getPurchaseOrderNumber());
		installResponse.setDesignadorAcesso(entity.getResourceFacingService().getServiceId());
		installResponse.setReturnCode(0);
		installResponse.setMessage(null);
		
		return installResponse;
	}
}
