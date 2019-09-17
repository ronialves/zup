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
import com.tlf.oss.resourceinventory.sagre.entity.ReserveEntity;
import com.tlf.oss.resourceinventory.sagre.repository.ReserveRepository;
import com.tlf.oss.resourceinventory.sagre.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class ReserveTest {
	
	@InjectMocks
	private ReserveController reserveController;

	@Mock
	private ReserveRepository reserveRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {

		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setStreetCode("6587");
		address.setCnl("41000");

		Cabinet cabinet = new Cabinet();
		cabinet.setId("TESTE");
		
		TerminalBox terminalBox = new TerminalBox();
		terminalBox.setName("TERMINAL");
		cabinet.setTerminalBox(terminalBox);

		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		physicalLink.setVoiceProtocol("SIP");

		physicalResourceAssoc.setPhysicalLink(physicalLink);
		physicalResourceAssoc.setCabinet(cabinet);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);

		ResourceFacingService resourcefacing = new ResourceFacingService();
		resourcefacing.setServiceId("BET-15649462-069");
		
		entity.setAddress(address);
		entity.setResourceFacingService(resourcefacing);
	}
	
	@Test
	public void testDoExecutionSucess() throws OSSBusinessException {
		
		ReserveEntity serviceResponse = new ReserveEntity();		
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		serviceResponse.setCnl(Integer.parseInt(entity.getAddress().getCnl()));
		serviceResponse.setIdentEquip2("A08G0006");
		serviceResponse.setIdentEquip1("O1A08");
		serviceResponse.setCod(0);
		
		when(reserveRepository.getReserve((anyObject()))).thenReturn(serviceResponse);
		ResourceInventoryEntity resourceInventoryEntity = reserveController
				.getReserve(entity);
		
		assertNotNull(resourceInventoryEntity);
		assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
		
	}
	
	@Test
	public void testDoExecutionOSSBusinessException() {

		OSSBusinessException exception = null;

		try {
			entity.setAddress(null);
			reserveController.getReserve(entity);

		} catch (Exception e) {
			exception = new OSSBusinessException("Code: 0", "RI-SAGRE", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);

	}

}
