package com.tlf.oss.resourceinventory.sagre.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.sagre.entity.DetermineAvailabilityEntity;
import com.tlf.oss.resourceinventory.sagre.repository.DetermineAvailabilityRepository;
import com.tlf.oss.resourceinventory.sagre.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.GeographicLocation;
import com.tlf.oss.resourceinventory.schemas.GeographicPoint;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.enums.GeometryTypeEnum;

@RunWith(MockitoJUnitRunner.class)
public class DetermineAvailabilityTest {

	@InjectMocks
	private DetermineAvailabilityController determineAvailabilityController;

	@Mock
	private DetermineAvailabilityRepository determineAvailabilityRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity resourceInventoryEntity;
	private DetermineAvailabilityEntity serviceResponse;

	@Before
	public void before() {

		resourceInventoryEntity = new ResourceInventoryEntity();
		
		GeographicPoint geo = new GeographicPoint();
		geo.setCoordinateSystem("WSG84");
		geo.setCoordinateX(-23.5475);
		geo.setCoordinateY(-46.63611);
		geo.setCoordinateZ(778.0);
		
        ArrayList<GeographicPoint> geometry = new ArrayList<GeographicPoint>();
        geometry.add(geo);

		GeographicLocation geographicLocation = new GeographicLocation();
		geographicLocation.setAccurany(100.0);
		geographicLocation.setGeometry(geometry);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setStreetCode("6587");
		address.setStreetNrFirst("1288");
		address.setCnl("41000");
		address.setNetworkOwner("VIVO2");
		

		address.setStreetNrFirst("ODD");



		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		physicalLink.setVoiceProtocol("SIP");

		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);

		resourceInventoryEntity.setAddress(address);
		
		serviceResponse = new DetermineAvailabilityEntity();
		ResultTo result = new ResultTo();
		result.setCode("0");
		serviceResponse.setResult(result);
		serviceResponse.setCnl(Integer.parseInt(resourceInventoryEntity.getAddress().getCnl()));
		serviceResponse.setIdentEquip2("D23G0061");
		serviceResponse.setEquipmentType("Caixa Terminal Optica");
		serviceResponse.setQuantityPort(2);
		serviceResponse.setCabinetName("PRCTA_G1D23");
		serviceResponse.setTypeCoverage("LOTE");
		serviceResponse.setIdentEquip1("id");
		serviceResponse.setSwitchName("PRCTA_VMS02");
		serviceResponse.setTechnology(2);
		serviceResponse.setReturnCode(0);
		
	}

	@Test
	public void testDoExecution() throws OSSBusinessException {
		when(determineAvailabilityRepository.getDetermineAvailability((anyObject()))).thenReturn(serviceResponse);
		ResourceInventoryEntity out = determineAvailabilityController
				.getDetermineAvailability(resourceInventoryEntity);

		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
	}

	@Test
	public void testDoExecutionOSSBusinessException() {
		
		try {
			serviceResponse = new DetermineAvailabilityEntity();
			ResultTo result = new ResultTo();
			result.setCode("1");
			serviceResponse.setResult(result);
			serviceResponse.setReturnCode(0);
			
			when(determineAvailabilityRepository.getDetermineAvailability((anyObject()))).thenReturn(serviceResponse);
			ResourceInventoryEntity out = determineAvailabilityController
					.getDetermineAvailability(resourceInventoryEntity);

			assertNotNull(out);
			assertFalse("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
		} catch (OSSBusinessException e) {
			assertEquals("RISAGRE-003", e.getStatusCode());
		}


	}

}
