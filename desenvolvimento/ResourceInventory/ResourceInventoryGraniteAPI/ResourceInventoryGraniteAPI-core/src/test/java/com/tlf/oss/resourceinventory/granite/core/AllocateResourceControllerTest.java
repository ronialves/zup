package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertEquals;
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
import com.tlf.oss.resourceinventory.granite.core.entity.AllocateResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.repository.AllocateResourceDao;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AllocateResourceControllerTest {

	@InjectMocks
	private AllocateResourceController allocateController;

	@Mock
	private AllocateResourceMetallicController allocateResourceMetallic;
	
	@Mock
	private AllocateResourceGponController AllocateResourceGponController;
	
	@Mock
	private AllocateResourceDao allocateResourceMetallicDao;
	
	@Mock
	private PathService pathService;
	
	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {
		
		entity = new ResourceInventoryEntity();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		
		Cabinet cabinet = new Cabinet();
		cabinet.setName("");
		
		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");
		physicalLink.setVoiceProtocol("SIP");
		
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		physicalResourceAssoc.setCabinet(cabinet);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		entity.setAddress(address);
	}

	@Test
	public void allocateResourceGponSucessTest() throws OSSBusinessException {
		
		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("GPON");
		
		when(AllocateResourceGponController.allocateResource(anyObject(),anyObject())).thenReturn(entity);
		
		allocateController.allocateResource(entity);
		
		assertEquals(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology(),"GPON");
	}

	@Test
	public void allocateResourceMetallicSucessTest() throws OSSBusinessException {
		
		AllocateResourceEntity allocateEntity = new AllocateResourceEntity();
		
		when(allocateResourceMetallicDao.allocateResource(anyObject())).thenReturn(allocateEntity);
		
		allocateController.allocateResource(entity);
		
		assertEquals(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology(),"METALICO");
	}
}
