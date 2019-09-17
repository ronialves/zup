package com.tlf.oss.resourceinventory.cpe.core;

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
import com.tlf.oss.resourceinventory.cpe.entity.CaracteristicaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoInfo;
import com.tlf.oss.resourceinventory.cpe.entity.ClientInformation;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.repository.RetrieveRepository;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.Resource;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveControllerTest {

	@InjectMocks
	private RetrieveController retrieveController;

	@Mock
	private RetrieveRepository retrieveRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity entity;
	private List<CatalogoInfo> catalogs;
	private int attributesNumber = 8;

	@Before
	public void before() {
		entity = new ResourceInventoryEntity();

		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("110001234567890");

		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(new ServiceDescribedBy());
		serviceDescribedByList.get(0).setName("OPERATION");

		PhysicalResource networkAggregator = new PhysicalResource();
		networkAggregator.setTypeOfResource("CPE");
		entity.setNetworkAggregator(networkAggregator);

		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());

		// entity.
		catalogs = new ArrayList<>();
		CatalogoInfo catalog = new CatalogoInfo();
		catalog.setId(1);
		catalog.setModelo("G5500T");
		catalog.setFabricante("PACE");
		catalog.setRede("VIVO2");
		catalog.setTipoDispositivo(null);
		catalog.setDescricao("PACE G5500T");
		catalog.setTipoRFS("R_CPE_ACCESS");
		catalog.setNomeCategoria("Modem - SIP WiFi Metalico");
		catalog.setNomeCaracteristica("Tecnologia");
		catalog.setValor("VDSL");
		catalogs.add(catalog);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = OSSBusinessException.class)
	public void testRetriveError() throws OSSBusinessException {

		when(retrieveController.retrieve(entity)).thenThrow(OSSBusinessException.class);
		retrieveController.retrieve(entity);
	}

	@Test
	public void testRetriveCatalogSuccess() throws OSSBusinessException {

		when(retrieveRepository.retrieveCatalog()).thenReturn(catalogs);
		retrieveController.retrieve(entity);
		assertTrue((entity.getResourceFacingService().getServiceDescribedBy().size() - 1) == (catalogs.size()
				* attributesNumber));
	}

	@Test
	public void testRetriveClientSuccess() throws OSSBusinessException {

		ResourceOrder resourceOrder = new ResourceOrder();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrderItem.setName("CPE");
		resourceOrder.setResourceOrderItem(resourceOrderItem);
		entity.setResourceOrder(resourceOrder);

		List<ClientInformation> client = new ArrayList<>();
		getClientInformation(client);

		when(retrieveRepository.retrieveClientInformation(anyObject(), anyObject())).thenReturn(client);
		retrieveController.retrieve(entity);
	}

	@Test
	public void testRetriveClientSuccessVoip() throws OSSBusinessException {

		ResourceOrder resourceOrder = new ResourceOrder();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrderItem.setName(TipoRfs.VOIP.getRoiName());

		resourceOrder.setResourceOrderItem(resourceOrderItem);

		entity.setResourceOrder(resourceOrder);

		Resource resource = new Resource();
		resource.setStateOfResource(CpeConstants.STATE_ACTIVE);
		entity.setResource(resource);

		List<ClientInformation> client = new ArrayList<>();
		client = getClientInformationComplete(client);

		when(retrieveRepository.retrieveClientInformation(anyObject(), anyObject())).thenReturn(client);
		retrieveController.retrieve(entity);
	}

	@Test
	public void testRetriveClientSuccessAccess() throws OSSBusinessException {

		ResourceOrder resourceOrder = new ResourceOrder();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrderItem.setName(TipoRfs.ACCESS.getRoiName());

		resourceOrder.setResourceOrderItem(resourceOrderItem);

		entity.setResourceOrder(resourceOrder);

		Resource resource = new Resource();
		resource.setStateOfResource(CpeConstants.STATE_ACTIVE);
		entity.setResource(resource);

		List<ClientInformation> client = new ArrayList<>();
		client = getClientInformationComplete(client);
		client.get(0).setTipoRfs(TipoRfs.ACCESS.getRoiName());

		when(retrieveRepository.retrieveClientInformation(anyObject(), anyObject())).thenReturn(client);
		retrieveController.retrieve(entity);
	}

	@Test
	public void testRetriveClientSuccessSb() throws OSSBusinessException {

		ResourceOrder resourceOrder = new ResourceOrder();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrderItem.setName(TipoRfs.STB.getRoiName());

		resourceOrder.setResourceOrderItem(resourceOrderItem);

		entity.setResourceOrder(resourceOrder);

		Resource resource = new Resource();
		resource.setStateOfResource(CpeConstants.STATE_ACTIVE);
		entity.setResource(resource);

		List<ClientInformation> client = new ArrayList<>();
		client = getClientInformationComplete(client);
		client.get(0).setTipoRfs(TipoRfs.STB.getRoiName());

		when(retrieveRepository.retrieveClientInformation(anyObject(), anyObject())).thenReturn(client);
		retrieveController.retrieve(entity);
	}

	@Test
	public void testRetriveClientEmptySuccess() throws OSSBusinessException {

		ResourceOrder resourceOrder = new ResourceOrder();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrderItem.setName("CPE");
		resourceOrder.setResourceOrderItem(resourceOrderItem);
		entity.setResourceOrder(resourceOrder);

		List<ClientInformation> client = new ArrayList<>();

		when(retrieveRepository.retrieveClientInformation(anyObject(), anyObject())).thenReturn(client);
		retrieveController.retrieve(entity);
	}

	@Test
	public void testResourceFacingServiceandCatalogFieldsNullSuccess() throws OSSBusinessException {

		entity.setResourceFacingService(null);
		catalogs.set(0, new CatalogoInfo());
		catalogs.get(0).setTipoDispositivo("null");
		when(retrieveRepository.retrieveCatalog()).thenReturn(catalogs);
		retrieveController.retrieve(entity);
	}

	@Test
	public void testCatalogFieldsEmptySuccess() throws OSSBusinessException {

		catalogs.get(0).setModelo("");
		catalogs.get(0).setFabricante("");
		catalogs.get(0).setRede("");
		catalogs.get(0).setTipoDispositivo("");
		catalogs.get(0).setDescricao("");
		catalogs.get(0).setTipoRFS("");
		catalogs.get(0).setNomeCategoria("");
		catalogs.get(0).setNomeCaracteristica("");
		catalogs.get(0).setValor("");
		when(retrieveRepository.retrieveCatalog()).thenReturn(catalogs);
		retrieveController.retrieve(entity);
	}

	private void getClientInformation(List<ClientInformation> client) {
		ClientInformation clientInformation = new ClientInformation();
		clientInformation.setServiceId("00000000111111");
		clientInformation.setMacAddress("4D:5S:SS:88");
		clientInformation.setModel("MODEL");
		clientInformation.setNumeroSerial("123456999");
		clientInformation.setNumeroSerialGpon("123456789");
		clientInformation.setStatus("Em aprovisionamento");
		clientInformation.setNumeroTelefone("1129110139");
		client.add(clientInformation);
	}

	private List<ClientInformation> getClientInformationComplete(List<ClientInformation> client) {
		ClientInformation clientInformation = new ClientInformation();
		clientInformation.setServiceId("00000000111111");
		clientInformation.setMacAddress("4D:5S:SS:88");
		clientInformation.setModel("MODEL");
		clientInformation.setNumeroSerial("123456999");
		clientInformation.setNumeroSerialGpon("123456789");
		clientInformation.setStatus(EstadoServico.ATIVADO.getValue());
		clientInformation.setNumeroTelefone("1129110139");
		clientInformation.setTipoRfs(TipoRfs.VOIP.getRoiName());
		clientInformation.setCategoriaCorrente(CpeConstants.ATA);
		clientInformation.setCategoriaEsperada("test1");
		clientInformation.setVendor("test");
		List<CaracteristicaDispositivo> caracteristicas = new ArrayList<>();
		clientInformation.setCaracteristicas(caracteristicas);
		client.add(clientInformation);
		return client;
	}
}
