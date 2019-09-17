package com.tlf.oss.resourceinventory.osp.core;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.addresstypes.Address;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityRequest.InService;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.Messages;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.Messages.Message;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources.Resource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes.Tag;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.osp.core.enums.ComplementType;
import com.tlf.oss.resourceinventory.osp.core.mapper.OspRequestMapper;
import com.tlf.oss.resourceinventory.osp.core.service.AvailabilityService;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.Complement;
import com.tlf.oss.resourceinventory.schemas.ComplementSummary;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * 
 * @author Washington Oliveira
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class AvailabilityControllerTest {

	@InjectMocks
	private AvailabilityController availabilityController;

	@Mock
	private AvailabilityService availabilityService;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;

	private DetermineResourceAvailabilityResponse response;

	@Before
	public void before() {
		entity = new ResourceInventoryEntity();
		response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11425");
		address.setTelephonicArea("SA");
		address.setStreetCode("10219");
		address.setStreetNrFirst("11");
		Circuit circuit = new Circuit();
		circuit.setId("123");

		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("123455");
		
		PhysicalLink link = new PhysicalLink();		
		link.setAccessTechnology("GPON");
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);

		entity.setAddress(address);
		entity.setCircuit(circuit);
		entity.setCustomerOrder(customerOrder);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowExceptionWhenResultNull()
			throws OSSBusinessException, FacilitiesException {

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		Resource resource = new Resource();
		response.getQualifiedResources().getResource().add(resource);
		response.setResult(null);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowExceptionWhenSetCode() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(999);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		Resource resource = new Resource();
		response.getQualifiedResources().getResource().add(resource);
		response.setResult(result);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldExecuteAccessTechnology() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("METALICO");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		Resource resource = new Resource();
		resource.setNetType(BigInteger.ONE);
		response.setCoverage(BigInteger.ONE);
		response.getQualifiedResources().getResource().add(resource);
		response.setResult(result);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldExecutePhysicalLinksWhenNull() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		entity.setPhysicalLinks(null);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		Resource resource = new Resource();
		response.getQualifiedResources().getResource().add(resource);
		response.setResult(result);
		response.setCoverage(BigInteger.ONE);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldExecuteAccessTechnologyWhenIsEmpty() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		entity.setPhysicalLinks(physicalLinks);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.ONE);
		Resource resource = new Resource();
		response.getQualifiedResources().getResource().add(resource);
		response.setResult(result);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test
	public void shouldExecuteSucess() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.ONE);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(2));
		resource.setResourceFeasibility(BigInteger.valueOf(1));
		resource.setResourceCoverage(BigInteger.valueOf(1));
		Attributes attributes = new Attributes();

		Tag tag = new Tag();
		tag.setLabel("ALIM_CABLE_NUM");

		Tag tag1 = new Tag();
		tag.setLabel("ALIM_FIBER_NUM");

		attributes.getTag().add(tag);
		attributes.getTag().add(tag1);

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);

		response.setResult(result);
		entity.setCabinet(null);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldExecuteValidadeResultCabbinet() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.ONE);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		Resource resource = new Resource();
		resource.setNetType(null);

		response.getQualifiedResources().getResource().add(resource);
		response.setResult(result);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldExecuteValidateNetTypeWhengetNetType1() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.ONE);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(1));

		response.getQualifiedResources().getResource().add(resource);
		response.setResult(result);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldReturnAnErrorCodeAndThrowExceptionWhenUNAVAILABLE() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.ZERO);
		
		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(2));
		resource.setResourceFeasibility(BigInteger.valueOf(0));

		response.getQualifiedResources().getResource().add(resource);

		response.setResult(result);
		entity.setCabinet(null);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldExecutecreateAvailabilityRequestIsMetalic() throws OSSBusinessException, FacilitiesException {

		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		Resource resource = new Resource();
		response.getQualifiedResources().getResource().add(resource);
		response.setResult(null);

		PhysicalLink link = new PhysicalLink();
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		link.setAccessTechnology("METALICO");

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11425");
		address.setTelephonicArea("SA");
		address.setStreetCode("10219");
		address.setStreetNrFirst("11");
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		entity.setAddress(address);

		ServiceDescribedBy describedBy = new ServiceDescribedBy();
		describedBy.setName("VIVO1");
		List<ServiceDescribedBy> serviceDescribedBy = new ArrayList<ServiceDescribedBy>();
		serviceDescribedBy.add(describedBy);

		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("VIVO");
		entity.setResourceFacingService(resourceFacingService);

		InService inService = new InService();
		inService.setIdentifier("1");

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		availabilityController.availability(entity);
	}

	@Test
	public void shouldExecutecreateAvailabilityRequestIsGPON() throws OSSBusinessException, FacilitiesException {
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(2));
		resource.setResourceCoverage(BigInteger.ONE);
		Attributes attributes = new Attributes();

		Tag tag = new Tag();
		tag.setLabel("ALIM_CABLE_NUM");

		Tag tag1 = new Tag();
		tag.setLabel("ALIM_FIBER_NUM");

		attributes.getTag().add(tag);
		attributes.getTag().add(tag1);

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		response.setResult(result);

		PhysicalLink link = new PhysicalLink();
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		link.setAccessTechnology("GPON");

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11425");
		address.setTelephonicArea("SA");
		address.setStreetCode("10219");
		address.setStreetNrFirst("11");
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		entity.setAddress(address);

		ServiceDescribedBy describedBy = new ServiceDescribedBy();
		describedBy.setName("VIVO1");
		List<ServiceDescribedBy> serviceDescribedBy = new ArrayList<ServiceDescribedBy>();
		serviceDescribedBy.add(describedBy);

		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("VIVO");
		entity.setResourceFacingService(resourceFacingService);

		InService inService = new InService();
		inService.setIdentifier("1");
		response.setCoverage(BigInteger.ONE);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		availabilityController.availability(entity);
	}
	
	@Test
	public void shouldExecuteSucessWhenAddressMsan() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11948");
		address.setStreetCode("10332");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("HT");
		address.setStreetNrFirst("469");
		entity.setAddress(address);
		
		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setVoiceProtocol("SIP");
		link.setAccessTechnology("METALICO");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.valueOf(1));
		response.setResult(result);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(1));
		resource.setResourceCoverage(BigInteger.valueOf(1));
		Attributes attributes = new Attributes();

		Tag tag = new Tag();
		tag.setLabel("MINI_DSLAM");
		tag.setValue("N");
		
		Tag tag1 = new Tag();
		tag1.setLabel("HOUSING_TYPE");
		tag1.setValue("MSAN");

		attributes.getTag().add(tag);
		attributes.getTag().add(tag1);

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}
	
	@Test(expected = OSSBusinessException.class)
	public void shouldReturnResponseBlankWhenAddressMiniDslam() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11948");
		address.setStreetCode("12289");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("HT");
		address.setStreetNrFirst("106");
		entity.setAddress(address);
		
		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setVoiceProtocol("SIP");
		link.setAccessTechnology("METALICO");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.valueOf(1));
		response.setResult(result);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(1));
		resource.setResourceCoverage(BigInteger.valueOf(1));
		Attributes attributes = new Attributes();

		Tag tag = new Tag();
		tag.setLabel("MINI_DSLAM");
		tag.setValue("S");
		
		Tag tag1 = new Tag();
		tag1.setLabel("HOUSING_TYPE");
		tag1.setValue("MSAN");

		attributes.getTag().add(tag);
		attributes.getTag().add(tag1);

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}
	
	@Test
	public void shouldExecuteSucessWhenAddressDslam() throws OSSBusinessException, FacilitiesException {

		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11135");
		address.setStreetCode("44806");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("SG");
		address.setStreetNrFirst("858");
		entity.setAddress(address);
		
		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setVoiceProtocol("SIP");
		link.setAccessTechnology("METALICO");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.valueOf(1));
		response.setResult(result);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(1));
		resource.setResourceCoverage(BigInteger.valueOf(1));
		Attributes attributes = new Attributes();

		Tag tag = new Tag();
		tag.setLabel("MINI_DSLAM");
		tag.setValue("N");
		
		Tag tag1 = new Tag();
		tag1.setLabel("HOUSING_TYPE");
		tag1.setValue("DSLAM");

		attributes.getTag().add(tag);
		attributes.getTag().add(tag1);

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}
	
	@Test
	public void shouldExecuteSucessWhenAccessTechnologyGpon() throws OSSBusinessException, FacilitiesException {
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11948");
		address.setStreetCode("10219");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("HT");
		address.setStreetNrFirst("108");
		entity.setAddress(address);
		
		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.valueOf(1));
		response.setResult(result);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(2));
		resource.setResourceCoverage(BigInteger.valueOf(1));
		resource.setResourceFeasibility(BigInteger.valueOf(1));
		Attributes attributes = new Attributes();
		
		Tag tag = new Tag();
		tag.setLabel("ALIM_CABLE_NUM");
		tag.setValue("");
		
		Tag tag1 = new Tag();
		tag1.setLabel("ALIM_FIBER_NUM");
		tag1.setValue("");

		attributes.getTag().add(tag);
		attributes.getTag().add(tag1);

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}
	
	@Test
	public void shouldReturnResponseBlankWhenAccessTechnologyGpon() throws OSSBusinessException, FacilitiesException {
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11948");
		address.setStreetCode("10219");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("HT");
		address.setStreetNrFirst("109");
		entity.setAddress(address);
		
		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.ONE);
		response.setResult(result);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(2));
		resource.setResourceCoverage(BigInteger.ONE);
		resource.setResourceFeasibility(BigInteger.ONE);
		Attributes attributes = new Attributes();

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}

	@Test
	public void shouldReturnBlockedWarningWhenAccessTechnologyGpon() throws OSSBusinessException, FacilitiesException {
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11948");
		address.setStreetCode("10219");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("HT");
		address.setStreetNrFirst("109");
		entity.setAddress(address);
		
		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("GPON");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();
		
		Message message = new Message();
		message.setRuleName("Verificação de Blacklist_24");
		Messages messages  = new  Messages();
		messages.getMessage().add(message);
		response.setMessages(messages);
		
		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.ONE);
		response.setResult(result);
		
		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(2));
		resource.setResourceCoverage(BigInteger.ONE);
		resource.setResourceFeasibility(BigInteger.ONE);
		Attributes attributes = new Attributes();
		
		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);
		
		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);
		
		doNothing().when(logger).error(anyString(), anyObject());
		
		availabilityController.availability(entity);
	}
	
	@Test(expected = OSSBusinessException.class)
	public void shouldReturnResponseBlankWhenAccessTechnologyMetalicoAndVoiceProtocolSip() throws OSSBusinessException, FacilitiesException {
		ResultTypeWithErrorCode result = new ResultTypeWithErrorCode();
		result.setCode(0);
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11451");
		address.setStreetCode("5398");
		address.setNetworkOwner("VIVO1");
		address.setTelephonicArea("LE");
		address.setStreetNrFirst("1053");
		entity.setAddress(address);
		
		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		PhysicalLink link = new PhysicalLink();
		link.setAccessTechnology("METALICO");
		link.setVoiceProtocol("SIP");
		physicalLinks.add(link);
		entity.setPhysicalLinks(physicalLinks);
		
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(link);
		
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		DetermineResourceAvailabilityResponse response = new DetermineResourceAvailabilityResponse();

		QualifiedResources qualifiedResources = new QualifiedResources();
		response.setQualifiedResources(qualifiedResources);
		response.setCoverage(BigInteger.valueOf(1));
		response.setResult(result);

		Resource resource = new Resource();
		resource.setNetType(BigInteger.valueOf(2));
		resource.setResourceCoverage(BigInteger.valueOf(1));
		Attributes attributes = new Attributes();

		resource.setAttributes(attributes);
		response.getQualifiedResources().getResource().add(resource);

		when(availabilityService.determineResourceAvailability(anyObject(), anyObject())).thenReturn(response);

		doNothing().when(logger).error(anyString(), anyObject());

		availabilityController.availability(entity);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void shouldHaveComplementsInOrder() throws OSSBusinessException, FacilitiesException {
		entity.getAddress().setComplementSummary(new ComplementSummary());
		Complement complement1 = new Complement();
		complement1.setType(ComplementType.HORIZONTAL.getCode());
		complement1.setOrder("2");
		Complement complement2 = new Complement();
		complement2.setType(ComplementType.VERTICAL.getCode());
		complement2.setOrder("1");
		Complement complement3 = new Complement();
		complement3.setType("ERRADO");
		complement3.setOrder("5");
		entity.getAddress().getComplementSummary().getComplement().add(complement1);
		entity.getAddress().getComplementSummary().getComplement().add(complement2);
		entity.getAddress().getComplementSummary().getComplement().add(complement3);
		
		Address address = OspRequestMapper.parseAddress(entity.getAddress());
		
		assertTrue(address.getSubUnit().size() == 2 
				&& address.getSubUnit().get(0).getCharacterist().toString().equals("1") 
				&& address.getSubUnit().get(1).getCharacterist().toString().equals("2"));
		entity.getAddress().setComplementSummary(null);
	}
}
