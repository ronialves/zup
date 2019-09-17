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
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.helper.AllocateHelper;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
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
public class DeallocateControllerTest {

	@InjectMocks
	private DeallocateController deallocateController;

	@Mock
	private OSSLogger logger;

	@Mock
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Mock
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Mock
	private RecursoLogicoRepository recursoLogicoRepository;
	
	@Mock
	private AllocateHelper helper;

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
		resourceFacingService.setServiceId("333333333333333");
		entity.setResourceFacingService(resourceFacingService);

		ResourceOrder resourceOrder = new ResourceOrder();
		resourceOrder.setResourceOrderItem(new ResourceOrderItem());
		
		entity.setResourceOrder(resourceOrder);

	}
	
	@Test
	public void testDeallocateWithOneServicoAssinanteSucess() throws OSSBusinessException {
		
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.ACCESS);
		
		RecursoLogico recursoLogico = getRecursoLogico();
		
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
				
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(recursoLogicoRepository.findByDispositivoFisicoId(anyObject())).thenReturn(null);
		
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		List<ServicoAssinante> listServicoAssinate = new ArrayList<ServicoAssinante>();
		listServicoAssinate.add(servicoAssinante);
		when(servicoAssinanteRepository.findByDispositivoFisico(anyObject())).thenReturn(listServicoAssinate);
		
		deallocateController.deallocate(entity);

	}
	
	@Test
	public void testDeallocateWithMoreThanOneServicoAssinanteSucess() throws OSSBusinessException {
		
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.ACCESS);
		
		RecursoLogico recursoLogico = getRecursoLogico();
		
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
				
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(recursoLogicoRepository.findByDispositivoFisicoId(anyObject())).thenReturn(null);
		
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		List<ServicoAssinante> listServicoAssinate = new ArrayList<ServicoAssinante>();
		listServicoAssinate.add(servicoAssinante);
		listServicoAssinate.add(servicoAssinante);
		when(servicoAssinanteRepository.findByDispositivoFisico(anyObject())).thenReturn(listServicoAssinate);
		
		deallocateController.deallocate(entity);

	}
	
	@Test
	public void testDeallocateWithOneServicoAssinanteSucessVOIP() throws OSSBusinessException {
		
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.VOIP.getRoiName());
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.ACCESS);
		
		RecursoLogico recursoLogico = getRecursoLogico();
		
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
				
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(recursoLogicoRepository.findByDispositivoFisicoId(anyObject())).thenReturn(null);
		
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		List<ServicoAssinante> listServicoAssinate = new ArrayList<ServicoAssinante>();
		listServicoAssinate.add(servicoAssinante);
		when(servicoAssinanteRepository.findByDispositivoFisico(anyObject())).thenReturn(listServicoAssinate);
		
		deallocateController.deallocate(entity);

	}
	
	@Test
	public void testDeallocateModify() throws OSSBusinessException {
		
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getResourceOrder().getResourceOrderItem().setAction(RoiAction.MODIFY.getAction());
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.ACCESS);
		
		RecursoLogico recursoLogico = getRecursoLogico();
		
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
				
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(recursoLogicoRepository.findByDispositivoFisicoId(anyObject())).thenReturn(null);
		
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		List<ServicoAssinante> listServicoAssinate = new ArrayList<ServicoAssinante>();
		listServicoAssinate.add(servicoAssinante);
		listServicoAssinate.add(servicoAssinante);
		when(servicoAssinanteRepository.findByDispositivoFisico(anyObject())).thenReturn(listServicoAssinate);
		
		deallocateController.deallocate(entity);

	}
	
	@Test
	public void testDeallocateHasDispositivoFisicoChildrenTRUE() throws OSSBusinessException {
		
		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.ACCESS);
		
		RecursoLogico recursoLogico = getRecursoLogico();
		
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
				
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(recursoLogicoRepository.findByDispositivoFisicoId(anyObject())).thenReturn(recursoLogico);
		
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		List<ServicoAssinante> listServicoAssinate = new ArrayList<ServicoAssinante>();
		listServicoAssinate.add(servicoAssinante);
		when(servicoAssinanteRepository.findByDispositivoFisico(anyObject())).thenReturn(listServicoAssinate);
		
		deallocateController.deallocate(entity);

	}
	
	@Test
	public void testDeallocateRedefineIdFxs() throws OSSBusinessException {
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.VOIP);
		RecursoLogico recursoLogico = getRecursoLogico();
		List<RecursoLogico> recursoLogicoList = new ArrayList<>();
		recursoLogicoList.add(recursoLogico);
		recursoLogico.setId(421);
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		List<ServicoAssinante> servicoAssinanteList = new ArrayList<>();
		servicoAssinanteList.add(servicoAssinante);
		
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		when(servicoAssinanteRepository.listByAccessId(anyObject())).thenReturn(servicoAssinanteList);
		when(recursoLogicoRepository.listByAccessId(anyObject())).thenReturn(recursoLogicoList);
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(new ServiceDescribedBy());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().get(1).setName("VOICE_TOTAL_PORTS");
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().get(1).getServiceSpecCharDescribes()
				.add(new ServiceSpecCharDescribes());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().get(1).getServiceSpecCharDescribes().get(0)
				.setValue("2");
		
		deallocateController.deallocate(entity);

	}
	
	@Test
	public void testDeallocateSortedMethod() throws OSSBusinessException {
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.VOIP);
		RecursoLogico recursoLogico = getRecursoLogico();
		RecursoLogico recursoLogico2 = getRecursoLogico();
		List<RecursoLogico> recursoLogicoList = new ArrayList<>();
		recursoLogico.setIdFxs(2);
		recursoLogico2.setIdFxs(1);
		recursoLogicoList.add(recursoLogico);
		recursoLogicoList.add(recursoLogico2);
		recursoLogico.setId(421);
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		List<ServicoAssinante> servicoAssinanteList = new ArrayList<>();
		servicoAssinanteList.add(servicoAssinante);
		
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		when(servicoAssinanteRepository.listByAccessId(anyObject())).thenReturn(servicoAssinanteList);
		when(recursoLogicoRepository.listByAccessId(anyObject())).thenReturn(recursoLogicoList);
		
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().add(new ServiceDescribedBy());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().get(1).setName("VOICE_TOTAL_PORTS");
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().get(1).getServiceSpecCharDescribes()
				.add(new ServiceSpecCharDescribes());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().get(1).getServiceSpecCharDescribes().get(0)
				.setValue("2");
		
		deallocateController.deallocate(entity);

	}
	
	@Test
	public void testDeallocateRedefineIdFxsNoVoiceTotalPortsOptional() throws OSSBusinessException {
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.VOIP);
		RecursoLogico recursoLogico = getRecursoLogico();
		List<RecursoLogico> recursoLogicoList = new ArrayList<>();
		recursoLogicoList.add(recursoLogico);
		recursoLogico.setId(421);
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		List<ServicoAssinante> servicoAssinanteList = new ArrayList<>();
		servicoAssinanteList.add(servicoAssinante);
		
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		when(servicoAssinanteRepository.listByAccessId(anyObject())).thenReturn(servicoAssinanteList);
		when(recursoLogicoRepository.listByAccessId(anyObject())).thenReturn(recursoLogicoList);
		
		deallocateController.deallocate(entity);

	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void testDeallocateRedefineIdFxsOssBusinessException() throws OSSBusinessException {
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.VOIP);
		RecursoLogico recursoLogico = getRecursoLogico();
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		when(servicoAssinanteRepository.listByAccessId(entity)).thenThrow(OSSBusinessException.class);
		
		deallocateController.deallocate(entity);

	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void testDeallocateRedefineIdFxsException() throws OSSBusinessException {
		
		ServicoAssinante servicoAssinante = getServicoAssinante(TipoRfs.VOIP);
		RecursoLogico recursoLogico = getRecursoLogico();
		DispositivoFisico dispositivoFisico = getDispositivoFisico();
		
		when(servicoAssinanteRepository.findByServiceId(Mockito.any(ResourceInventoryEntity.class))).thenReturn(servicoAssinante);
		when(recursoLogicoRepository.findByServicoAssinanteId(anyObject())).thenReturn(recursoLogico);
		when(dispositivoFisicoRepository.findById(anyObject())).thenReturn(dispositivoFisico);
		when(servicoAssinanteRepository.listByAccessId(entity)).thenThrow(Exception.class);
		
		deallocateController.deallocate(entity);

	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void testDeallocateOSSException() throws OSSBusinessException {
		
		when(deallocateController.deallocate(entity)).thenThrow(OSSBusinessException.class);

		deallocateController.deallocate(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=OSSBusinessException.class)
	public void testDeallocateException() throws OSSBusinessException {
				
		when(deallocateController.deallocate(entity)).thenThrow(Exception.class);
		
		deallocateController.deallocate(entity);
	}
	
	
	private BrazilianUrbanPropertyAddress getBrazilianUrbanPropertyAddress()
	{
		BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress = new BrazilianUrbanPropertyAddress();
		brazilianUrbanPropertyAddress.setStreetCode("237558");
		brazilianUrbanPropertyAddress.setStreetNrFirst("154");
		brazilianUrbanPropertyAddress.setCnl("11000");
		brazilianUrbanPropertyAddress.setNetworkOwner("VIVO1");
		brazilianUrbanPropertyAddress.setTelephonicArea("AT");
		
		return brazilianUrbanPropertyAddress;
	}
	
	private List<CustomerFacingService> getListCustomerFacingService()
	{
		List<CustomerFacingService> listOfCustomerFacingService = new ArrayList<CustomerFacingService>();
		listOfCustomerFacingService.add(new CustomerFacingService());
		listOfCustomerFacingService.get(0).setServiceId("333333333333333");
		listOfCustomerFacingService.get(0).getServiceDescribedBy().add(new ServiceDescribedBy());
		listOfCustomerFacingService.get(0).getServiceDescribedBy().get(0).setName("EQUIPMENT_TYPE");
		listOfCustomerFacingService.get(0).getServiceDescribedBy().get(0).getServiceSpecCharDescribes()
				.add(new ServiceSpecCharDescribes());
		listOfCustomerFacingService.get(0).getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0)
				.setValue("HGU");
		
		return listOfCustomerFacingService;
	}
	
	private ServicoAssinante getServicoAssinante(TipoRfs tipoRfs)
	{
		ServicoAssinante servicoAssinante = new ServicoAssinante();
		servicoAssinante.setId(421);
		servicoAssinante.setTipoRfs(tipoRfs.getRoiName());
		servicoAssinante.setEstadoServicoAssinanteId(1);
		servicoAssinante.setServiceId("333333333333333");
		servicoAssinante.setNrc(null);
		servicoAssinante.setAccessId("333333333333333");
		servicoAssinante.setNumeroTelefone(null);
		
		return servicoAssinante;
	}
	
	private RecursoLogico getRecursoLogico()
	{
		RecursoLogico recursoLogico = new RecursoLogico();
		recursoLogico.setId(381);
		recursoLogico.setIdFxs(0);
		recursoLogico.setDispositivoFisicoId(321);
		recursoLogico.setServicoAssinanteId(421);
		recursoLogico.setMainKey(null);
		
		return recursoLogico;
	}
	
	private DispositivoFisico getDispositivoFisico()
	{
		DispositivoFisico dispositivoFisico = new DispositivoFisico();
		dispositivoFisico.setId(321);
		dispositivoFisico.setNumeroSerial(null);
		dispositivoFisico.setMacAddress(null);
		dispositivoFisico.setCategoriaDispositivoEsperada(11);
		dispositivoFisico.setCategoriaDispositivoCorrente(null);
		dispositivoFisico.setCatalagoDispositivoId(null);
		dispositivoFisico.setNumeroSerialGpon(null);
		
		return dispositivoFisico;
	}

}
