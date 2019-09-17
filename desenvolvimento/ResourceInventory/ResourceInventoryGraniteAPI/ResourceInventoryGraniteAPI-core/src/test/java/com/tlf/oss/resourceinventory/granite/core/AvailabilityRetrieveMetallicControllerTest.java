package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.to.RetrieveAvailabilityTO;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AvailabilityRetrieveMetallicControllerTest {

	@InjectMocks
	private AvailabilityRetrieveMetallicController availabilityMetallicController;

	@Mock
	private AvailabilityRetrieveMsanController availabilityRetrieveMsanController;

	@Mock
	private AvailabilityRetrieveMetallicController availabilityRetrieveMetallicController;
	
	@Mock
	private LoadConfigMemoryController resourceLoadConfigMemoryBO;
	
	@Mock
	private AvailabilityRetrieveDslamController availabilityRetrieveDslamController;
	
	@Mock
	private RetrieveResourceMapper retrieveResourceMapper;
	
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
		physicalResourceAssoc.setCabinet(cabinet);
		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);


		entity.setAddress(address);
	}

	@Test
	public void allocateResourceMsanSucessTest() throws OSSBusinessException {
  		Shelf shelf = new Shelf();
  		shelf.setTypeOfResource("MSAN");
		Cabinet cabinet = new Cabinet();
		cabinet.setName("QQE");
		entity.setCabinet(new Cabinet());
		entity.setCabinet(cabinet);
		entity.getCabinet().getHasShelves().add(shelf);
		
		RetrieveAvailabilityTO to = new RetrieveAvailabilityTO();
		to.setEquipmentType("MSAN");
		to.getResult().setCode("0");
		List<RetrieveAvailabilityMsanEntity> list = new ArrayList<>();

		when(availabilityRetrieveMsanController.getCheckMsan(anyObject(),anyObject(),anyObject())).thenReturn(to);
		when(availabilityRetrieveMsanController.getAvailabilityMsan(anyObject(),anyObject(),anyObject(),anyObject())).thenReturn(list);

		availabilityMetallicController.availabilityRetrieve(entity);

		assertEquals(shelf.getTypeOfResource(),"MSAN");
	}

	@Test
	public void allocateResourceDslamSucessTest() throws OSSBusinessException {
		Shelf shelf = new Shelf();
		shelf.setTypeOfResource("DSLAM");
		Cabinet cabinet = new Cabinet();
		cabinet.setName("QQE");
		entity.setCabinet(new Cabinet());
		entity.setCabinet(cabinet);
		entity.getCabinet().getHasShelves().add(shelf);
		
		RetrieveAvailabilityTO to = new RetrieveAvailabilityTO();
		to.setEquipmentType("DSLAM");
		to.getResult().setCode("0");
		Collection<RetrieveAvailabilityDslamEntity> list = new ArrayList<>();

		when(availabilityRetrieveMsanController.getCheckMsan(anyObject(),anyObject(),anyObject())).thenReturn(to);
		when(availabilityRetrieveDslamController.getAvailabilityDSLAM(anyObject(),anyObject())).thenReturn(list);

		availabilityMetallicController.availabilityRetrieve(entity);

		assertEquals(shelf.getTypeOfResource(),"DSLAM");
	}
	
	@Test(expected=NullPointerException.class)
	public void allocateResourceMsanException() throws OSSBusinessException {
		
		RetrieveAvailabilityTO to = new RetrieveAvailabilityTO();
		to.setEquipmentType("MSAN");
		to.getResult().setCode("1");
		List<RetrieveAvailabilityMsanEntity> list = new ArrayList<>();

		when(availabilityRetrieveMsanController.getCheckMsan(anyObject(),anyObject(),anyObject())).thenReturn(to);
		when(availabilityRetrieveMsanController.getAvailabilityMsan(anyObject(),anyObject(),anyObject(),anyObject())).thenReturn(list);

		availabilityMetallicController.availabilityRetrieve(entity);

	}
	
	@Test(expected=NullPointerException.class)
	public void allocateResourceMsanCabinetException() throws OSSBusinessException {
		
		RetrieveAvailabilityTO to = new RetrieveAvailabilityTO();
		to.setEquipmentType("MSAN");
		to.getResult().setCode("1");
		List<RetrieveAvailabilityMsanEntity> list = new ArrayList<>();

		when(availabilityRetrieveMsanController.getCheckMsan(anyObject(),anyObject(),anyObject())).thenReturn(to);
		when(availabilityRetrieveMsanController.getAvailabilityMsan(anyObject(),anyObject(),anyObject(),anyObject())).thenReturn(list);

		availabilityMetallicController.availabilityRetrieve(entity);

		assertEquals(to.getEquipmentType(),"MSAN");
	}
	
	@Test
	public void allocateResourceCabinetMsan() throws OSSBusinessException {
		Shelf shelf = new Shelf();
		shelf.setTypeOfResource("MSAN");
		Cabinet cabinet = new Cabinet();
		cabinet.setName("QQE");
		entity.setCabinet(new Cabinet());
		entity.setCabinet(cabinet);
		entity.getCabinet().getHasShelves().add(shelf);
		
		RetrieveAvailabilityTO to = new RetrieveAvailabilityTO();
		to.setEquipmentType("MSAN");
		to.getResult().setCode("0");
		List<RetrieveAvailabilityMsanEntity> list = new ArrayList<>();

		when(availabilityRetrieveMsanController.getCheckMsan(anyObject(),anyObject(),anyObject())).thenReturn(to);
		when(availabilityRetrieveMsanController.getAvailabilityMsan(anyObject(),anyObject(),anyObject(),anyObject())).thenReturn(list);

		availabilityMetallicController.availabilityRetrieve(entity);

		assertEquals(shelf.getTypeOfResource(),"MSAN");
	}
	
	@Test
	public void allocateResourceCabinetDslam() throws OSSBusinessException {
		Shelf shelf = new Shelf();
		shelf.setTypeOfResource("DSLAM");
		Cabinet cabinet = new Cabinet();
		cabinet.setName("QQE");
		entity.setCabinet(new Cabinet());
		entity.setCabinet(cabinet);
		entity.getCabinet().getHasShelves().add(shelf);
		
		RetrieveAvailabilityTO to = new RetrieveAvailabilityTO();
		to.setEquipmentType("MSAN");
		to.getResult().setCode("0");
		List<RetrieveAvailabilityMsanEntity> list = new ArrayList<>();

		when(availabilityRetrieveMsanController.getCheckMsan(anyObject(),anyObject(),anyObject())).thenReturn(to);
		when(availabilityRetrieveMsanController.getAvailabilityMsan(anyObject(),anyObject(),anyObject(),anyObject())).thenReturn(list);

		availabilityMetallicController.availabilityRetrieve(entity);

		assertEquals(shelf.getTypeOfResource(),"DSLAM");
	}
}
