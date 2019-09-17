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
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class FacilityResourceControllerTest {
	
	@InjectMocks
	private FacilityResourceController facilityController;

	@Mock
	private FacilityResourceGponController facilityGponController;

	@Mock
	private FacilityResourceMetallicController facilityMetallicController;

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
		physicalResourceAssoc.setCabinet(cabinet);
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		
		entity.setAddress(address);
	}
	
	@Test
	public void facilityResourceGponSucessTest() throws OSSBusinessException {

		entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().setAccessTechnology("GPON");

		when(facilityGponController.resourceFacility(anyObject())).thenReturn(entity);

		facilityController.facilityResource(entity);

		assertEquals(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology(),"GPON");
	}

	@Test
	public void facilityResourceMetallicSucessTest() throws OSSBusinessException {

		when(facilityMetallicController.resourceFacility(anyObject())).thenReturn(entity);

		facilityController.facilityResource(entity);

		assertEquals(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology(),"METALICO");
	}

}
