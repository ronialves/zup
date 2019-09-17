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
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.mapping.EntityConverter;
import com.tlf.oss.resourceinventory.cpe.repository.AllocateRepository;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class InstallSTBControllerTest {

	@InjectMocks
	private InstallStbController installSTBController;

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
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {
		entity = new ResourceInventoryEntity();
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("VIVO1");
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwner");
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
		entity.setResourceFacingService(resourceFacingService);
		entity.setAddress(new BrazilianUrbanPropertyAddress());
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		ResourceOrder resourceOrder = new ResourceOrder();
		resourceOrder.setResourceOrderItem(resourceOrderItem);
		entity.setResourceOrder(resourceOrder);

		List<CustomerFacingService> listOfCustomerFacingService = new ArrayList<CustomerFacingService>();
		listOfCustomerFacingService.add(new CustomerFacingService());
		listOfCustomerFacingService.get(0).setCategory("BROADBAND");

		sdbNew(CpeConstants.EQUIPMENT_TYPE, CpeConstants.STB);

		listOfCustomerFacingService.get(0).getServiceDescribedBy()
				.add(sdbNew(CpeConstants.EQUIPMENT_TYPE, CpeConstants.STB));
		listOfCustomerFacingService.get(0).getServiceDescribedBy().add(sdbNew(CpeConstants.SERIAL_NUMBER, "100"));

		listOfCustomerFacingService.add(new CustomerFacingService());
		listOfCustomerFacingService.get(1).setCategory("IPTV");

		entity.setCustomerFacingService(listOfCustomerFacingService);
	}

	@Test
	public void testInstallStbSucess() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());

		final EstadoServicoAssinante estadoServicoAssinante = new EstadoServicoAssinante();

		final ServicoAssinante servicoAssinante = new ServicoAssinante();

		List<DispositivoFisico> dispositivosFisicos = new ArrayList<DispositivoFisico>();
		dispositivosFisicos.add(new DispositivoFisico());
		dispositivosFisicos.get(0).setNumeroSerial("100");
		servicoAssinante.setId(1);

		EstadoRecursoLogico estadoRecursoLogico = new EstadoRecursoLogico();

		estadoRecursoLogico.setId(2);

		estadoServicoAssinante.setEstadoServico(EstadoServico.ATIVADO.getValue());
		estadoServicoAssinante.setId(1);
		
		List<RecursoLogico> recursosLogicos = new ArrayList<RecursoLogico>();
		recursosLogicos.add(new RecursoLogico());
		
		recursosLogicos.get(0).setEstadoRecursoLogicoId(2);

		when(recursoLogicoRepository.listByServiceId(anyObject())).thenReturn(recursosLogicos);
		when(estadoRecursoLogicoRepository.findByEstadoRecurso(anyObject())).thenReturn(estadoRecursoLogico);

		when(dispositivoFisicoRepository.listByServiceId(anyObject())).thenReturn(dispositivosFisicos);
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class)))
				.thenReturn(servicoAssinante);
		when(recursoLogicoRepository.findByDispositivoFisicoId(anyObject())).thenReturn(new RecursoLogico());
		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);
		installSTBController.install(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void testInstallStbServicoAssinanteNullException() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());

		final EstadoServicoAssinante estadoServicoAssinante = new EstadoServicoAssinante();

		final ServicoAssinante servicoAssinante = new ServicoAssinante();

		List<DispositivoFisico> dispositivosFisicos = new ArrayList<DispositivoFisico>();
		dispositivosFisicos.add(new DispositivoFisico());
		dispositivosFisicos.get(0).setNumeroSerial("100");
		servicoAssinante.setId(1);

		estadoServicoAssinante.setEstadoServico(EstadoServico.ATIVADO.getValue());
		estadoServicoAssinante.setId(1);
		when(dispositivoFisicoRepository.listByServiceId(anyObject())).thenReturn(dispositivosFisicos);
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(null);

		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);

		installSTBController.install(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void testInstallStbRecursoLogicoNullException() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());

		final EstadoServicoAssinante estadoServicoAssinante = new EstadoServicoAssinante();

		final ServicoAssinante servicoAssinante = new ServicoAssinante();

		List<DispositivoFisico> dispositivosFisicos = new ArrayList<DispositivoFisico>();
		dispositivosFisicos.add(new DispositivoFisico());
		dispositivosFisicos.get(0).setNumeroSerial("100");
		servicoAssinante.setId(1);

		estadoServicoAssinante.setEstadoServico(EstadoServico.ATIVADO.getValue());
		estadoServicoAssinante.setId(1);
		when(dispositivoFisicoRepository.listByServiceId(anyObject())).thenReturn(dispositivosFisicos);
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class)))
				.thenReturn(servicoAssinante);

		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);

		installSTBController.install(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void testInstallStbServicoAssinanteEstadoServicoAssinateIDequalsTrueException() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());

		final EstadoServicoAssinante estadoServicoAssinante = new EstadoServicoAssinante();

		final ServicoAssinante servicoAssinante = new ServicoAssinante();
		servicoAssinante.setEstadoServicoAssinanteId(1);

		List<DispositivoFisico> dispositivosFisicos = new ArrayList<DispositivoFisico>();
		servicoAssinante.setId(1);

		estadoServicoAssinante.setEstadoServico(EstadoServico.ATIVADO.getValue());
		estadoServicoAssinante.setId(1);
		when(dispositivoFisicoRepository.listByServiceId(anyObject())).thenReturn(dispositivosFisicos);
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class)))
				.thenReturn(servicoAssinante);

		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);

		installSTBController.install(entity);
	}

	@Test(expected = OSSBusinessException.class)
	public void testInstallStbdispositivoFisicoFoundEmptyException() throws OSSBusinessException {
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());

		final EstadoServicoAssinante estadoServicoAssinante = new EstadoServicoAssinante();

		final ServicoAssinante servicoAssinante = new ServicoAssinante();

		List<DispositivoFisico> dispositivosFisicos = new ArrayList<DispositivoFisico>();
		servicoAssinante.setId(1);

		estadoServicoAssinante.setEstadoServico(EstadoServico.ATIVADO.getValue());
		estadoServicoAssinante.setId(1);
		when(dispositivoFisicoRepository.listByServiceId(anyObject())).thenReturn(dispositivosFisicos);
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class)))
				.thenReturn(servicoAssinante);

		when(estadoServicoAssinanteRepository.findByEstadoServico(anyObject())).thenReturn(estadoServicoAssinante);

		installSTBController.install(entity);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = OSSBusinessException.class)
	public void testInstallException() throws OSSBusinessException {

		when(installSTBController.install(entity)).thenThrow(OSSBusinessException.class);

		installSTBController.install(entity);
	}

	public ServiceDescribedBy sdbNew(String tag, String value) {
		ServiceDescribedBy sdb = new ServiceDescribedBy();

		sdb.setName(tag);
		sdb.setServiceSpecCharDescribes(new ArrayList<ServiceSpecCharDescribes>());
		sdb.getServiceSpecCharDescribes().add(new ServiceSpecCharDescribes());
		sdb.getServiceSpecCharDescribes().get(0).setValue(value);

		return sdb;
	}
}
