package com.tlf.oss.resourceinventory.scqla.core;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidade.ScqlaRequest;
import com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidadeResponse.ConsultaFacilidadeResponse;
import com.tlf.oss.resourceinventory.generated.scqla.RedeMetalicaType;
import com.tlf.oss.resourceinventory.generated.scqla.TerminalType;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.scqla.core.enums.Message;
import com.tlf.oss.resourceinventory.scqla.core.service.AvailabilityRetrievalService;
import com.tlf.oss.resourceinventory.scqla.core.validation.ValidatorEntity;

@RunWith(MockitoJUnitRunner.class)
public class RetrievalControllerTest {

	@InjectMocks
	private RetrievalController retrievalController;

	@Mock
	ValidatorEntity ValidatorEntity;

	@Mock
	private AvailabilityRetrievalService retrievalService;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;

	@Before
	public void initializeEntity() {
		entity = new ResourceInventoryEntity();

		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");

		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(physicalLink);

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		address.setStreetCode("05565-010");
		address.setStreetNrFirst("548");

		Circuit circuit = new Circuit();
		circuit.setId("123");

		Cabinet cabinet = new Cabinet();
		cabinet.setDistance("teste");

		TerminalBox terminalBox = new TerminalBox();
		terminalBox.setCableNumber("teste");

		entity.setAddress(address);
		entity.setCircuit(circuit);
		entity.setCabinet(cabinet);
		entity.getCabinet().setTerminalBox(terminalBox);
	}

	@Test
	public void shouldExecuteWithResourceFacingAndCustomerFacing() throws OSSBusinessException {

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("TELEPHONE");
		customerFacingService.setServiceId("1111");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110001234567890");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);

		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);

		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		TerminalType terminalType = new TerminalType();
		terminalType.setDdd(1111);
		terminalType.setTelefone(1111111);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertEquals(response.getRedeMetalica().getCaboPrimario(), "106");
		Assert.assertEquals(customerFacingService.getServiceId().substring(0, 2), "11");
		Assert.assertEquals(resourceFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0)
				.getValue().substring(5, 13), "12345678");
	}

	@Test(expected = OSSBusinessException.class)
	public void shouldExecuteWithServiceDescribeNull() throws OSSBusinessException {

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("TELEPHONE");
		customerFacingService.setServiceId("1111");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110001234567890");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		TerminalType terminalType = new TerminalType();
		terminalType.setDdd(1111);
		terminalType.setTelefone(1111111);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertEquals(customerFacingService.getServiceId().substring(0, 2), "11");
		Assert.assertEquals(response.getRedeMetalica().getIdentificadorMsan(), "S");
	}

	@Test
	public void shouldExecuteWithCategoryTelephoneInvalid() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("teste");
		customerFacingService.setServiceId("1111");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110001234567890");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);

		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);

		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		TerminalType terminalType = new TerminalType();
		terminalType.setDdd(1111);
		terminalType.setTelefone(1111111);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);

		try {
			retrievalController.retrieval(entity);
		} catch (OSSBusinessException e) {

			Assert.assertEquals(customerFacingService.getServiceId().substring(0, 2), "11");
			Assert.assertEquals(resourceFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes()
					.get(0).getValue().substring(5, 13), "12345678");
		}
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithServiceIdNull() throws OSSBusinessException {

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("TELEPHONE");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110001234567890");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);

		ServiceSpecCharDescribes serviceSpecCharDescribesNrc = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesNrc.setValue("C066532635");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesNrcList = new ArrayList<>();
		serviceSpecCharDescribesNrcList.add(serviceSpecCharDescribesNrc);

		ServiceDescribedBy serviceDescribedByNrc = new ServiceDescribedBy();
		serviceDescribedByNrc.setName("NRC");
		serviceDescribedByNrc.setServiceSpecCharDescribes(serviceSpecCharDescribesNrcList);

		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		serviceDescribedByList.add(serviceDescribedByNrc);

		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		TerminalType terminalType = new TerminalType();
		terminalType.setDdd(1111);
		terminalType.setTelefone(1111111);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertEquals(resourceFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0)
				.getValue().substring(5, 13), "12345678");
		Assert.assertEquals(response.getRedeMetalica().getCaboPrimario(), "106");
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithServiceSpecCharDescribeInvalid() throws OSSBusinessException {

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("TELEPHONE");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);

		ServiceSpecCharDescribes serviceSpecCharDescribesNrc = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesNrc.setValue("");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesNrcList = new ArrayList<>();
		serviceSpecCharDescribesNrcList.add(serviceSpecCharDescribesNrc);

		ServiceDescribedBy serviceDescribedByNrc = new ServiceDescribedBy();
		serviceDescribedByNrc.setName("NRC");
		serviceDescribedByNrc.setServiceSpecCharDescribes(serviceSpecCharDescribesNrcList);

		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		serviceDescribedByList.add(serviceDescribedByNrc);

		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		TerminalType terminalType = new TerminalType();
		terminalType.setDdd(1111);
		terminalType.setTelefone(1111111);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertEquals(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(),
				"Erro ao validar o objeto ResourceInventoryEntity");
		Assert.assertEquals(response.getRedeMetalica().getParPrimario(), "107");
	}

	@Test
	public void shouldExecuteWithServiceDescribeInvalid() throws OSSBusinessException {

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("TELEPHONE");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110001234567890");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		TerminalType terminalType = new TerminalType();
		terminalType.setDdd(1111);
		terminalType.setTelefone(1111111);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);

		try {
			retrievalController.retrieval(entity);
		} catch (OSSBusinessException e) {
			Assert.assertEquals(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(),
					"Erro ao validar o objeto ResourceInventoryEntity");
		}
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldExecuteWithServiceIdIsEmpty() throws OSSBusinessException {

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("TELEPHONE");
		customerFacingService.setServiceId("");

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110001234567890");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);

		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);

		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		TerminalType terminalType = new TerminalType();
		terminalType.setDdd(1111);
		terminalType.setTelefone(1111111);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertEquals(resourceFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0)
				.getValue().substring(5, 13), "12345678");
		Assert.assertEquals(response.getRedeMetalica().getIdentificadorMsan(), "S");
	}

	@Test
	public void shouldExecuteWithResponseNull() {

		when(retrievalService.consultarFacilidade(anyObject())).thenReturn(null);

		try {
			retrievalController.retrieval(entity);
		} catch (OSSBusinessException e) {
		}
	}

	@Test
	public void shouldExecuteWithCabinetNull() throws OSSBusinessException {

		entity = new ResourceInventoryEntity();
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		address.setStreetCode("05565-010");
		address.setStreetNrFirst("548");
		entity.setAddress(address);

		Cabinet cabinet = null;
		entity.setCabinet(cabinet);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica().getCaboPrimario(), "106");
	}

	@Test
	public void shouldExecuteWithTelephonicAreaInvalid() throws OSSBusinessException {

		entity = new ResourceInventoryEntity();
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("");
		address.setStreetCode("05565-010");
		address.setStreetNrFirst("548");
		entity.setAddress(address);

		Cabinet cabinet = null;
		entity.setCabinet(cabinet);

		try {
			retrievalController.retrieval(entity);
		} catch (OSSBusinessException e) {
			Assert.assertEquals(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(),
					"Erro ao validar o objeto ResourceInventoryEntity");
		}
	}

	@Test
	public void shouldExecuteWithStreetCodeInvalid() throws OSSBusinessException {

		entity = new ResourceInventoryEntity();
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		address.setStreetCode("");
		address.setStreetNrFirst("548");
		entity.setAddress(address);

		Cabinet cabinet = null;
		entity.setCabinet(cabinet);

		try {
			retrievalController.retrieval(entity);
		} catch (OSSBusinessException e) {
			Assert.assertEquals(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(),
					"Erro ao validar o objeto ResourceInventoryEntity");
		}
	}

	@Test
	public void shouldExecuteWithStreetNrFirstInvalid() throws OSSBusinessException {

		entity = new ResourceInventoryEntity();
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		address.setStreetCode("05565-010");
		address.setStreetNrFirst("");
		entity.setAddress(address);

		Cabinet cabinet = null;
		entity.setCabinet(cabinet);

		try {
			retrievalController.retrieval(entity);
		} catch (OSSBusinessException e) {
			Assert.assertEquals(Message.ERRO_RESOURCE_INVENTORY_ENTITY.getValue(),
					"Erro ao validar o objeto ResourceInventoryEntity");
		}
	}

	@Test
	public void shouldExecuteWithTerminalBoxNull() throws OSSBusinessException {

		entity = new ResourceInventoryEntity();
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");
		address.setStreetCode("05565-010");
		address.setStreetNrFirst("548");
		entity.setAddress(address);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		TerminalBox terminalBox = null;
		entity.getCabinet().setTerminalBox(terminalBox);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica().getCaboPrimario(), "106");
	}

	@Test
	public void shouldExecuteWithAddress() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setTelephonicArea("SA");
		address.setCnl("11000");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(new RedeMetalicaType());
		response.getRedeMetalica().setIdentificadorMsan("S");
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getTelephonicArea(), "SA");
	}

	@Test
	public void shouldExecuteWithTelephonicArea() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setTelephonicArea("SA");
		address.setCnl("11000");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(new RedeMetalicaType());
		response.getRedeMetalica().setIdentificadorMsan("S");
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getTelephonicArea(), "SA");
	}

	@Test
	public void shouldExecuteWithStreetCode() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setStreetCode("05565010");
		address.setTelephonicArea("DC");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(new RedeMetalicaType());
		response.getRedeMetalica().setIdentificadorMsan("N");
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getStreetCode(), "05565010");
	}

	@Test
	public void shouldExecuteWithNumeroLogradouro() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setStreetNrFirst("100");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(new RedeMetalicaType());
		response.getRedeMetalica().setIdentificadorMsan("N");
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertEquals(entity.getAddress().getStreetNrFirst(), "100");
	}

	@Test
	public void shouldExecuteWithCnl() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		response.setRedeMetalica(new RedeMetalicaType());
		response.getRedeMetalica().setIdentificadorMsan("N");
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
	}

	@Test
	public void shouldExecuteWithRedeMetalica() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		redeMetalicaType.setIdentificadorMsan("S");
		response.setRedeMetalica(redeMetalicaType);
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica(), redeMetalicaType);
	}

	@Test
	public void shouldExecuteWithDistanceAndName() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		response.setRedeMetalica(redeMetalicaType);
		redeMetalicaType.setDistanciaTotal("106");
		redeMetalicaType.setArmario("107");
		response.getRedeMetalica().setIdentificadorMsan("S");
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica().getDistanciaTotal(), "106");
	}

	@Test
	public void shouldExecuteWithCaboPrimario() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		response.setRedeMetalica(new RedeMetalicaType());
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setIdentificadorMsan("N");
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica().getCaboPrimario(), "106");
	}

	@Test
	public void shouldExecuteWithParPrimario() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();

		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		response.setRedeMetalica(redeMetalicaType);
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		response.getRedeMetalica().setIdentificadorMsan("S");

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica().getParPrimario(), "107");
	}

	@Test
	public void shouldExecuteWithResponseNullTerminalBox() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		redeMetalicaType.setIdentificadorMsan("N");
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		response.setRedeMetalica(redeMetalicaType);

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica().getCaboPrimario(), "106");
	}

	@Test
	public void shouldExecuteWithResponseMSAN() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		response.setRedeMetalica(redeMetalicaType);
		redeMetalicaType.setIdentificadorMsan("S");
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);
		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertFalse(entity.getCabinet().getHasShelves().isEmpty());
		Assert.assertEquals(entity.getCabinet().getHasShelves().get(0).getTypeOfResource(), "MSAN");
	}

	@Test
	public void shouldExecuteWithSuccess() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("DC");
		address.setStreetCode("000");
		address.setStreetNrFirst("000");
		entity.setAddress(address);

		Cabinet cabinet = new Cabinet();
		entity.setCabinet(cabinet);

		TerminalBox terminalBox = new TerminalBox();
		entity.getCabinet().setTerminalBox(terminalBox);

		ConsultaFacilidadeResponse response = new ConsultaFacilidadeResponse();
		RedeMetalicaType redeMetalicaType = new RedeMetalicaType();
		response.setRedeMetalica(redeMetalicaType);
		redeMetalicaType.setCaboPrimario("106");
		redeMetalicaType.setParPrimario("107");
		redeMetalicaType.setIdentificadorMsan("S");

		when(retrievalService.consultarFacilidade((ScqlaRequest) anyObject())).thenReturn(response);

		retrievalController.retrieval(entity);

		Assert.assertNotNull(entity.getCabinet());
		Assert.assertNotNull(entity.getCabinet().getTerminalBox());
		Assert.assertEquals(entity.getAddress().getCnl(), "11000");
		Assert.assertEquals(response.getRedeMetalica().getCaboPrimario(), "106");
		Assert.assertFalse(entity.getCabinet().getHasShelves().isEmpty());
		Assert.assertEquals(entity.getCabinet().getHasShelves().get(0).getTypeOfResource(), "MSAN");
	}
}
