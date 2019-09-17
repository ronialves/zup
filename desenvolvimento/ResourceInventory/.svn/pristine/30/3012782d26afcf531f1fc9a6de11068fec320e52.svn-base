package com.tlf.oss.resourceinventory.terus.core;

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
import com.tlf.oss.resourceinventory.generated.terus.desbloqueioportaresponse.DesbloqueioPortaResponseType;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.OperationService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.terus.core.service.TerusService;
import com.tlf.oss.resourceinventory.terus.core.util.CalendarUtil;

@RunWith(MockitoJUnitRunner.class)
public class DeallocateControllerTest {
	
	private static final String TRUE = "true";

	@InjectMocks
	private DeallocateController deallocateController;
	
	@Mock
	private TerusService terusService;
	
	@Mock
	private OSSLogger logger;
	
	private ResourceInventoryEntity entity;

	@Before
	public void before() {
		entity = new ResourceInventoryEntity();
		
		Cabinet cabinet = new Cabinet();
		cabinet.setIdMsan("CAS.CB.MSO02");
		cabinet.setLic("A-000045-00");
		
		OperationService operationService = new OperationService();
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName(TerusService.UPDATEPOTS);
		
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue(TRUE);
		
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
		operationService.getServiceDescribedBy().add(serviceDescribedBy);
		
		entity.setCabinet(cabinet);
		entity.setOperationService(operationService);
	}
	
	@Test
	public void testTerusDoorLockSucess() throws OSSBusinessException {
		
		DesbloqueioPortaResponseType response = new DesbloqueioPortaResponseType();
		response.setCODMSG("0");
		response.setDATAHORA(CalendarUtil.getCurrentTime());
		response.setDSCMSG("Operacao efetuada com sucesso");
		
		when(terusService.desbloqueioPorta(anyObject())).thenReturn(response);
		
		deallocateController.unLock(entity);
	}

}
