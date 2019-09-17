package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveGponResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.repository.IdentifyNetworkDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveFacilityGponDao;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.AtomicNetworkAddress;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.NetworkAddressAssociation;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class FacilityResourceGponControllerTest {
	
	@Mock
	private OSSLogger logger;
	
	@Mock
	private RetrieveFacilityGponDao dao;
	
	@Mock
	private RetrieveGponResourceMapper mapper;
	
	@InjectMocks
	private FacilityResourceGponController controller;
	
	@Mock
	private IdentifyNetworkController identifyNetworkController;
	
	@Mock
	private IdentifyNetworkDao identifyNetworkDao;
	
	private ResourceInventoryEntity entity;
	
	@Before
	public void before(){
		entity = new ResourceInventoryEntity();
		
		identifyNetworkController = new IdentifyNetworkController();
		identifyNetworkDao = new IdentifyNetworkDao();
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("AT");
		address.setNetworkOwner("VIVO1");
		
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("110004569084571");

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("A000000B40");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NRC");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);

		resourceFacingService.setServiceDescribedBy(new ArrayList<>());
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);

		entity.setResourceFacingService(resourceFacingService);
		entity.setAddress(address);
	}
	
	@Test
	public void testDoExecution() throws OSSBusinessException{
		RetrieveFacilityGponEntity serviceResponse = new RetrieveFacilityGponEntity();
		serviceResponse = getRetrieveFacilityGponEntity(serviceResponse);
		
		ResultTo result = new ResultTo();
		result.setCode(Message.SUCCESS.getValue());
		result.setDescription("");
		serviceResponse.setResult(result);
		serviceResponse.setId((long) 1);
		
		when(dao.facilityRetrieval(anyObject())).thenReturn(serviceResponse);
				
		RetrieveFacilityGponEntity rfr = controller.getRetrieveFacilityResourceGponEntity(entity);
		
		assertNotNull(rfr);		
		assertTrue("0".equalsIgnoreCase(serviceResponse.getResult().getCode()));
	}

	@Test
	public void testDoExecutionOSSBusinessException(){
		OSSBusinessException exception = null;
		
		try{
			entity.setResourceFacingService(null);
			controller.resourceFacility(entity);
		}
		catch (Exception e){
			exception = new OSSBusinessException("ERRO AO PEGAR FACILIDADE "+ e.getMessage(), "0", "RI-GRANITE");
		}
		
		assertNotNull(exception);
		
	}
	
	@Test
	public void resourceFacilitySucces() throws OSSBusinessException {
		RetrieveFacilityGponEntity serviceResponse = new RetrieveFacilityGponEntity();
		serviceResponse = getRetrieveFacilityGponEntity(serviceResponse);
		
		ResultTo result = new ResultTo();
		result.setCode(Message.SUCCESS.getValue());
		result.setDescription("");
		serviceResponse.setResult(result);
		serviceResponse.setId((long) 1);
		
		when(dao.facilityRetrieval(anyObject())).thenReturn(serviceResponse);				
		when(controller.identifyNetwork(anyObject())).thenReturn(entity);
		when(mapper.parseGetPhysicalResourceFacility(anyObject(), anyObject())).thenReturn(entity);
		
		controller.resourceFacility(entity);
		
		assertNotNull(entity);
		
	}
	
	public RetrieveFacilityGponEntity getRetrieveFacilityGponEntity(RetrieveFacilityGponEntity entity){
		
		Cabinet cabinet = new Cabinet();
		
		PhysicalResource networkAggregator = new PhysicalResource();
		ResourceFacingService facingService = new ResourceFacingService();

		TerminalBox box = new TerminalBox();
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setStreetName("VICENTE HECKEL");
		address.setStreetNrFirst("27");
		address.setStreetType("R.");
		box.setAddress(address);

		box.setId("06");
		box.setCableNumber("01-F#79");
		box.setSideCableNumber("02");
		box.setType("Terminal de Fibras (TFO)");
		cabinet.setTerminalBox(box);
		
		List<Shelf> hasShelves = new ArrayList<>();
		Shelf shelf = new Shelf();
		List<PortAdapterCard> hasCards = new ArrayList<>();
		PortAdapterCard adapterCard = new PortAdapterCard();
		adapterCard.setId("03");
		List<PhysicalPort> containsPorts = new ArrayList<>();
		PhysicalPort physicalPort = new PhysicalPort();
		physicalPort.setId("00");
		containsPorts.add(physicalPort);
		adapterCard.setContainsPorts(containsPorts);
		hasCards.add(adapterCard);
		shelf.setHasCards(hasCards);
		NetworkAddressAssociation networkAddressAssociation = new NetworkAddressAssociation();
		AtomicNetworkAddress atomicNetworkAddress = new AtomicNetworkAddress();
		atomicNetworkAddress.setHostname("BR_SPOGO_OLT03");
		networkAddressAssociation.setAtomicNetworkAddress(atomicNetworkAddress);
		shelf.setNetworkAddressAssociation(networkAddressAssociation );
		hasShelves.add(shelf);
		cabinet.setHasShelves(hasShelves);
		cabinet.setPrimaryCable("01");
		cabinet.setPrimaryFiber("79");

		NetworkAddressAssociation networkAddressAssociation2 = new NetworkAddressAssociation();
		IPAddress ipAddress = new IPAddress();
		ipAddress.setNetworkNumber("187.100.231.3");
		networkAddressAssociation.addIpAddress(ipAddress);
		networkAggregator.setNetworkAddressAssociation(networkAddressAssociation2);
		
		List<ServiceDescribedBy> serviceDescribedBy = new  ArrayList<>();
		ServiceDescribedBy by = new ServiceDescribedBy();
		by.setName("NRC");
		List<ServiceSpecCharDescribes> serviceSpecCharDescribes = new ArrayList<>();
		ServiceSpecCharDescribes charDescribes = new ServiceSpecCharDescribes();
		charDescribes.setValue("C000024445");
		serviceSpecCharDescribes.add(charDescribes);
		by.setServiceSpecCharDescribes(serviceSpecCharDescribes);
		serviceDescribedBy.add(by);
		facingService.setServiceDescribedBy(serviceDescribedBy);
		
		return entity;
	}
}
