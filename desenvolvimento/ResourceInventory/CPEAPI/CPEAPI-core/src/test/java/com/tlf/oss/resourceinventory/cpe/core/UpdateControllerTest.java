package com.tlf.oss.resourceinventory.cpe.core;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CategoriaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.helper.UpdateHelper;
import com.tlf.oss.resourceinventory.cpe.mapping.EntityConverter;
import com.tlf.oss.resourceinventory.cpe.repository.AllocateRepository;
import com.tlf.oss.resourceinventory.cpe.repository.CatalogoDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.CategoriaDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class UpdateControllerTest {

	@InjectMocks
	private UpdateController updateController;

	@Spy
	@InjectMocks
	private EntityConverter entityConverter = new EntityConverter();

	@Mock
	private OSSLogger logger;

	@Mock
	private AllocateRepository allocateRepository;

	@Mock
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Mock
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Mock
	private RecursoLogicoRepository recursoLogicoRepository;

	@Mock
	private EstadoServicoAssinanteRepository estadoServicoAssinanteRepository;

	@Mock
	private CategoriaDispositivoRepository categoriaDispositivoRepository;

	@Mock
	private CatalogoDispositivoRepository catalogoDispositivoRepository;
	
	@Mock
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;
	@Mock
	private ExecutionRules executionRules;
	
	@Mock
	private UpdateHelper helper;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {
		entity = new ResourceInventoryEntity();

		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		placePhysicalResourceAssoc.setPhysicalLink(new PhysicalLink());
		placePhysicalResourceAssoc.getPhysicalLink().setAccessTechnology("GPON");

		entity.setAddress(getBrazilianUrbanPropertyAddress());

		entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);

		entity.setCustomerFacingService(getListCustomerFacingService());

		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("00000000000004");
		entity.setResourceFacingService(resourceFacingService);

		ResourceOrder resourceOrder = new ResourceOrder();
		resourceOrder.setResourceOrderItem(new ResourceOrderItem());
		entity.setResourceOrder(resourceOrder);

		entity.setAddress(getBrazilianUrbanPropertyAddress());
		entity.setCustomerFacingService(getListCustomerFacingService());
	}
	
	@Test
	public void testUpdateVoiceEquipmentTypeATASucess() throws OSSBusinessException {
		
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.VOIP.getRoiName());
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.VOICE_EQUIPMENT_TYPE, CpeConstants.ATA));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.TELEPHONE_NUMBER, "1129110139"));
	
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.MACADDRESS, "A2:B3:C4:D5:G9"));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_MODEL, "GPT-2541GNAC-N1"));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_VENDOR, "Mitrastar"));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.SERIAL_NUMBER, "A2B3C4D5E6F7"));
		
		List<ResourceFacingService> rfsList = new ArrayList<>();
		
		ResourceFacingService rfsVoip = new ResourceFacingService();
		
		rfsVoip.setCategory(CpeConstants.TELEPHONE);
		
		rfsVoip.setServiceId("CTA-AA012-042");
		
		rfsList.add(rfsVoip);

		entity.getCustomerFacingService().get(0).setResourceFacingService(rfsList);
		
		entity.getResourceFacingService().setServiceId("CTA-AA012-069");
		
		EstadoServicoAssinante estadoServicoAssinante = getEstadoServicoAssinante();
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		CategoriaDispositivo categoriaDispositivo = getCategoriaDispositivo();
		List<CatalogoDispositivo> catalogo = getCatalogoDispositivo();
		Optional<DispositivoFisico> macAddressResult = Optional.empty();
		Optional<DispositivoFisico> serialNumberResult = Optional.empty();

		
		when(dispositivoFisicoRepository.findBySerialNumber(anyObject())).thenReturn(serialNumberResult);
		when(dispositivoFisicoRepository.findByMacaddress(anyObject())).thenReturn(macAddressResult);
		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);
		when(dispositivoFisicoRepository.findByServiceId(anyObject())).thenReturn(dispositivoFisico);
		when(categoriaDispositivoRepository.findByNomeCategoria(anyObject())).thenReturn(categoriaDispositivo);
		when(helper.getCatalogoDispositivo(anyObject())).thenReturn(catalogo.get(0));

		updateController.update(entity);
	}

	@Test
	public void testUpdateNumberSerialSucess() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS_PORT.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.GPON_SERIAL_NUMBER, "MSTC12345679"));

		EstadoServicoAssinante estadoServicoAssinante = getEstadoServicoAssinante();
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		CategoriaDispositivo categoriaDispositivo = getCategoriaDispositivo();
		
		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);
		when(dispositivoFisicoRepository.findByServiceId(anyObject())).thenReturn(dispositivoFisico);
		when(categoriaDispositivoRepository.findByNomeCategoria(anyObject())).thenReturn(categoriaDispositivo);

		updateController.update(entity);
	}

	@Test
	public void testUpdateMACADDRESSSucess() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.MACADDRESS, "A2:B3:C4:D5"));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_MODEL, "GPT-2541GNAC-N1"));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_VENDOR, "Mitrastar"));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.SERIAL_NUMBER, "A2B3C4D5E6F7"));

		EstadoServicoAssinante estadoServicoAssinante = getEstadoServicoAssinante();
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		CategoriaDispositivo categoriaDispositivo = getCategoriaDispositivo();
		List<CatalogoDispositivo> catalogo = getCatalogoDispositivo();
		Optional<DispositivoFisico> macAddressResult = Optional.empty();
		Optional<DispositivoFisico> serialNumberResult = Optional.empty();

		
		when(dispositivoFisicoRepository.findBySerialNumber(anyObject())).thenReturn(serialNumberResult);
		when(dispositivoFisicoRepository.findByMacaddress(anyObject())).thenReturn(macAddressResult);
		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);
		when(dispositivoFisicoRepository.findByServiceId(anyObject())).thenReturn(dispositivoFisico);
		when(categoriaDispositivoRepository.findByNomeCategoria(anyObject())).thenReturn(categoriaDispositivo);
		when(helper.getCatalogoDispositivo(anyObject())).thenReturn(catalogo.get(0));

		updateController.update(entity);
	}
	
	@Test
	public void testUpdateCeaseSuccess() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setAction(RoiAction.CEASE.getAction());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.SERIAL_NUMBER, "A2B3C4D5E6F7"));

		Optional<DispositivoFisico> dispositivoFisicoFound = Optional.ofNullable(getDispositivoFisico());
		RecursoLogico recursoLogico = getRecursoLogico();
		EstadoRecursoLogico estadoRecursoLogico = getEstadoRecursoLogico();
		List<RecursoLogico> listaRecursoLogico = new ArrayList<RecursoLogico>();
		listaRecursoLogico.add(recursoLogico);
//		
		when(dispositivoFisicoRepository.findBySerialNumber(anyObject())).thenReturn(dispositivoFisicoFound);
		when(recursoLogicoRepository.listByServiceId(anyObject())).thenReturn(listaRecursoLogico);
		when(estadoRecursoLogicoRepository.findByEstadoRecurso(anyObject())).thenReturn(estadoRecursoLogico);

		updateController.update(entity);
	}
	
	@Test(expected = OSSBusinessException.class)
	public void testUpdateCeaseDispositivoFisicoFoundException() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setAction(RoiAction.CEASE.getAction());
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.SERIAL_NUMBER, "A2B3C4D5E6F7"));
		
		Optional<DispositivoFisico> dispositivoFisicoFound = Optional.ofNullable(getDispositivoFisico());
		
		when(dispositivoFisicoRepository.findBySerialNumber(anyObject())).thenReturn(dispositivoFisicoFound);
		
		updateController.update(entity);
	}
		
	@Test(expected = OSSBusinessException.class)
	public void testUpdateDefineEquipmentException() throws OSSBusinessException {
		
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.VOIP.getRoiName());
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.VOICE_EQUIPMENT_TYPE, CpeConstants.ATA));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.TELEPHONE_NUMBER, "1129110139"));
	
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.MACADDRESS, "A2:B3:C4:D5"));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_MODEL, "GPT-2541GNAC-N1"));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_VENDOR, "Mitrastar"));
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.SERIAL_NUMBER, "A2B3C4D5E6F7"));
		
		List<ResourceFacingService> rfsList = new ArrayList<>();
		
		ResourceFacingService rfsVoip = new ResourceFacingService();
		
		rfsVoip.setCategory(CpeConstants.TELEPHONE);
		
		rfsVoip.setServiceId("CTA-AA012-042");
		
		rfsList.add(rfsVoip);

		entity.getCustomerFacingService().get(0).setResourceFacingService(rfsList);
		
		entity.getResourceFacingService().setServiceId("CTA-AA012-069");
		
		EstadoServicoAssinante estadoServicoAssinante = getEstadoServicoAssinante();
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		CategoriaDispositivo categoriaDispositivo = getCategoriaDispositivo();

		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);
		when(dispositivoFisicoRepository.findByServiceId(anyObject())).thenReturn(dispositivoFisico);
		when(categoriaDispositivoRepository.findByNomeCategoria(anyObject())).thenReturn(categoriaDispositivo);

		updateController.update(entity);
	}
	
	@Test(expected = OSSBusinessException.class)
	public void testUpdateDispositivoFisicoNullException() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.MACADDRESS, "A2:B3:C4:D5"));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_MODEL, "GPT-2541GNAC-N1"));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.EQUIPMENT_VENDOR, "Mitrastar"));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(createServiceDescribedBy(CpeConstants.SERIAL_NUMBER, "A2B3C4D5E6F7"));

		EstadoServicoAssinante estadoServicoAssinante = getEstadoServicoAssinante();
		DispositivoFisico dispositivoFisico = null;
		CategoriaDispositivo categoriaDispositivo = getCategoriaDispositivo();
		List<CatalogoDispositivo> catalogo = getCatalogoDispositivo();

		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);
		when(dispositivoFisicoRepository.findByServiceId(anyObject())).thenReturn(dispositivoFisico);
		when(categoriaDispositivoRepository.findByNomeCategoria(anyObject())).thenReturn(categoriaDispositivo);
		when(helper.getCatalogoDispositivo(anyObject())).thenReturn(catalogo.get(0));

		updateController.update(entity);
	}
	

	@SuppressWarnings("unchecked")
	@Test(expected = OSSBusinessException.class)
	public void testUpdateException() throws OSSBusinessException {

		when(updateController.update(entity)).thenThrow(OSSBusinessException.class);

		updateController.update(entity);
	}

	private BrazilianUrbanPropertyAddress getBrazilianUrbanPropertyAddress() {
		BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress = new BrazilianUrbanPropertyAddress();
		brazilianUrbanPropertyAddress.setStreetCode("237558");
		brazilianUrbanPropertyAddress.setStreetNrFirst("154");
		brazilianUrbanPropertyAddress.setCnl("11000");
		brazilianUrbanPropertyAddress.setNetworkOwner("VIVO1");
		brazilianUrbanPropertyAddress.setTelephonicArea("AT");

		return brazilianUrbanPropertyAddress;
	}

	private List<CustomerFacingService> getListCustomerFacingService() {
		List<CustomerFacingService> listOfCustomerFacingService = new ArrayList<CustomerFacingService>();
		listOfCustomerFacingService.add(new CustomerFacingService());
		listOfCustomerFacingService.get(0).setServiceId("1001");
		listOfCustomerFacingService.get(0).getServiceDescribedBy().add(new ServiceDescribedBy());
		listOfCustomerFacingService.get(0).getServiceDescribedBy().get(0).getServiceSpecCharDescribes()
				.add(new ServiceSpecCharDescribes());
		listOfCustomerFacingService.get(0).getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0)
				.setValue("1234321234");

		return listOfCustomerFacingService;
	}

	private EstadoServicoAssinante getEstadoServicoAssinante() {
		final EstadoServicoAssinante estadoServicoAssinante = new EstadoServicoAssinante();
		estadoServicoAssinante.setEstadoServico(EstadoServico.EM_APROVISIONAMENTO.getValue());
		estadoServicoAssinante.setId(1);
		return estadoServicoAssinante;
	}

	private DispositivoFisico getDispositivoFisico() {
		DispositivoFisico dispositivoFisico = new DispositivoFisico();
		dispositivoFisico.setId(762);
		dispositivoFisico.setNumeroSerial(null);
		dispositivoFisico.setMacAddress(null);
		dispositivoFisico.setCategoriaDispositivoEsperada(11);
		dispositivoFisico.setCategoriaDispositivoCorrente(null);
		dispositivoFisico.setCatalagoDispositivoId(null);
		dispositivoFisico.setNumeroSerialGpon("1234321234");

		return dispositivoFisico;
	}

	private CategoriaDispositivo getCategoriaDispositivo() {
		CategoriaDispositivo categoriaDispositivo = new CategoriaDispositivo();
		categoriaDispositivo.setId(1);
		categoriaDispositivo.setNomeCategoria("ATA 16 Portas");
		categoriaDispositivo.setTipoRfs(entity.getResourceOrder().getResourceOrderItem().getName());
		return categoriaDispositivo;
	}

	private List<CatalogoDispositivo> getCatalogoDispositivo() {
		List<CatalogoDispositivo> catalogo = new ArrayList<>();
		CatalogoDispositivo equipment = new CatalogoDispositivo();

		equipment.setRede("VIVO1");
		catalogo.add(equipment);

		return catalogo;
	}

	private ServiceDescribedBy createServiceDescribedBy(String name, String value) {
		ServiceDescribedBy sdb = new ServiceDescribedBy();
		ServiceSpecCharDescribes sscd = new ServiceSpecCharDescribes();
		List<ServiceSpecCharDescribes> sscdList = new ArrayList<>();

		sdb.setName(name);
		sscd.setValue(value);
		sscdList.add(sscd);
		sdb.setServiceSpecCharDescribes(sscdList);

		return sdb;
	}
	
	private RecursoLogico getRecursoLogico() {
		RecursoLogico recursoLogico = new RecursoLogico();
		recursoLogico.setId(2);
		return recursoLogico;
	}
	
	private EstadoRecursoLogico getEstadoRecursoLogico() {
		EstadoRecursoLogico estadoRecursoLogico = new EstadoRecursoLogico();
		estadoRecursoLogico.setId(2);
		return estadoRecursoLogico;
	}
}
