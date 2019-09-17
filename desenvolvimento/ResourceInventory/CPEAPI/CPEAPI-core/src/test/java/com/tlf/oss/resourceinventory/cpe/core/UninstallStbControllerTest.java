package com.tlf.oss.resourceinventory.cpe.core;

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
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
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
public class UninstallStbControllerTest {

	@InjectMocks
	private UninstallStbController uninstallStbController;

	@Mock
	private OSSLogger logger;

	@Mock
	private RecursoLogicoRepository recursoLogicoRepository;

	@Mock
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Mock
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Mock
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

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
	public void testUnistallStbTOTALSucess() throws OSSBusinessException {

		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(createServiceDescribedBy(CpeConstants.IPTV_CEASE_TYPE, CpeConstants.IPTV_CEASE_TYPE_VALUE_TOTAL));

		when(recursoLogicoRepository.listByServiceId(anyObject())).thenReturn(getListRecursoLogico());
		when(estadoRecursoLogicoRepository.findByEstadoRecurso(anyObject())).thenReturn(getEstadoRecursoLogico());
		when(recursoLogicoRepository.listByAccessId(anyObject())).thenReturn(getListRecursoLogico());
		when(dispositivoFisicoRepository.listByAccessId(anyObject())).thenReturn(getListDispositivoFisico());
		when(servicoAssinanteRepository.listByAccessId(anyObject())).thenReturn(getListServicoAssinante());
		uninstallStbController.uninstall(entity);
	}

	@Test
	public void testUnistallStbPARTIALSucess() throws OSSBusinessException {

		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(
				createServiceDescribedBy(CpeConstants.IPTV_CEASE_TYPE, CpeConstants.IPTV_CEASE_TYPE_VALUE_PARTIAL));

		when(recursoLogicoRepository.listByServiceId(anyObject())).thenReturn(getListRecursoLogico());
		when(estadoRecursoLogicoRepository.findByEstadoRecurso(anyObject())).thenReturn(getEstadoRecursoLogico());
		when(servicoAssinanteRepository.findByServiceId(anyObject())).thenReturn(getServicoAssinante());

		uninstallStbController.uninstall(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void testUnistallStbPARTIALrecursoLogicoNotFoundException() throws OSSBusinessException {

		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(
				createServiceDescribedBy(CpeConstants.IPTV_CEASE_TYPE, CpeConstants.IPTV_CEASE_TYPE_VALUE_PARTIAL));

		uninstallStbController.uninstall(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void testUnistallStbTOTALException() throws OSSBusinessException {

		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(createServiceDescribedBy(CpeConstants.IPTV_CEASE_TYPE, CpeConstants.IPTV_CEASE_TYPE_VALUE_TOTAL));
		when(recursoLogicoRepository.listByAccessId(anyObject())).thenThrow(new NullPointerException());
		when(recursoLogicoRepository.listByServiceId(anyObject())).thenReturn(getListRecursoLogico());
		when(estadoRecursoLogicoRepository.findByEstadoRecurso(anyObject())).thenReturn(getEstadoRecursoLogico());

		uninstallStbController.uninstall(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void testUnistallStbPARTIALException() throws OSSBusinessException {

		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(
				createServiceDescribedBy(CpeConstants.IPTV_CEASE_TYPE, CpeConstants.IPTV_CEASE_TYPE_VALUE_PARTIAL));
		when(recursoLogicoRepository.listByAccessId(anyObject())).thenThrow(new NullPointerException());
		when(recursoLogicoRepository.listByServiceId(anyObject())).thenReturn(getListRecursoLogico());
		when(estadoRecursoLogicoRepository.findByEstadoRecurso(anyObject())).thenReturn(getEstadoRecursoLogico());

		uninstallStbController.uninstall(entity);
	}
	
	@Test(expected = OSSBusinessException.class)
	public void testUnistallStbTOTALOssBussinessException() throws OSSBusinessException {

		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(
				createServiceDescribedBy(CpeConstants.IPTV_CEASE_TYPE, CpeConstants.IPTV_CEASE_TYPE_VALUE_TOTAL));
		when(recursoLogicoRepository.listByAccessId(anyObject())).thenThrow(new OSSBusinessException());
		when(recursoLogicoRepository.listByServiceId(anyObject())).thenReturn(getListRecursoLogico());
		when(estadoRecursoLogicoRepository.findByEstadoRecurso(anyObject())).thenReturn(getEstadoRecursoLogico());

		uninstallStbController.uninstall(entity);
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
		listOfCustomerFacingService.get(0).getServiceDescribedBy()
				.add(createServiceDescribedBy(CpeConstants.EQUIPMENT_TYPE, CpeConstants.HGU));

		return listOfCustomerFacingService;
	}

	private List<RecursoLogico> getListRecursoLogico() {
		List<RecursoLogico> listRecursoLogico = new ArrayList<>();
		RecursoLogico recursoLogico = new RecursoLogico();
		recursoLogico.setId(881);
		recursoLogico.setIdFxs(0);
		recursoLogico.setDispositivoFisicoId(762);
		recursoLogico.setServicoAssinanteId(1041);
		recursoLogico.setMainKey(null);
		recursoLogico.setEstadoRecursoLogicoId(2);
		listRecursoLogico.add(recursoLogico);

		return listRecursoLogico;
	}

	private List<DispositivoFisico> getListDispositivoFisico() {

		List<DispositivoFisico> dispositivosFisicos = new ArrayList<>();

		dispositivosFisicos.add(getDispositivoFisico());

		return dispositivosFisicos;
	}

	private DispositivoFisico getDispositivoFisico() {
		DispositivoFisico dispositivoFisico = new DispositivoFisico();
		dispositivoFisico.setId(762);
		dispositivoFisico.setNumeroSerial(null);
		dispositivoFisico.setMacAddress(null);
		dispositivoFisico.setCategoriaDispositivoEsperada(11);
		dispositivoFisico.setCategoriaDispositivoCorrente(null);
		dispositivoFisico.setCatalagoDispositivoId(null);
		dispositivoFisico.setNumeroSerialGpon(null);

		return dispositivoFisico;
	}

	private EstadoRecursoLogico getEstadoRecursoLogico() {
		EstadoRecursoLogico estadoRecursoLogico = new EstadoRecursoLogico();
		estadoRecursoLogico.setId(2);

		return estadoRecursoLogico;
	}

	private List<ServicoAssinante> getListServicoAssinante() {
		List<ServicoAssinante> servicoAssinante = new ArrayList<>();
		servicoAssinante.add(getServicoAssinante());
		return servicoAssinante;
	}

	private ServicoAssinante getServicoAssinante() {
		ServicoAssinante servicoAssinante = new ServicoAssinante();
		servicoAssinante.setId(1041);
		servicoAssinante.setTipoRfs(TipoRfs.STB.getRoiName());
		servicoAssinante.setEstadoServicoAssinanteId(1);
		servicoAssinante.setServiceId("1001");
		servicoAssinante.setAccessId("00000000000004");
		servicoAssinante.setNrc(null);
		servicoAssinante.setNumeroTelefone(null);

		return servicoAssinante;
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
}
