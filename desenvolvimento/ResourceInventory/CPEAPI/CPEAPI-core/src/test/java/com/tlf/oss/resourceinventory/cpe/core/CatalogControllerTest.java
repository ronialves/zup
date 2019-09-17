package com.tlf.oss.resourceinventory.cpe.core;

import static org.junit.Assert.assertNotNull;
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
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CaracteristicaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CategoriaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.repository.CatalogoDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.CategoriaDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;

@RunWith(MockitoJUnitRunner.class)
public class CatalogControllerTest {

	@InjectMocks
	private CatalogController catalogController;

	private CatalogoDispositivo catalogoDispositivo;

	private CaracteristicaDispositivo caracteristicaDispositivo;

	private CategoriaDispositivo categoriaDispositivo;

	@Mock
	private CategoriaDispositivoRepository categoriaDispositivoRepository;

	@Mock
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Mock
	private CatalogoDispositivoRepository catalogoDispositivoRepository;

	@Mock
	private OSSLogger logger;

	@Before
	public void Before() {
		catalogoDispositivo = new CatalogoDispositivo();

		catalogoDispositivo.setId(1);
		catalogoDispositivo.setModelo("DSL-2740E");
		catalogoDispositivo.setFabricante("D-Link");
		catalogoDispositivo.setRede("VIVO2");
		catalogoDispositivo.setCategoriaDispositivoId(13);
		catalogoDispositivo.setDescricao("D-Link DSL-2740E");

		categoriaDispositivo = new CategoriaDispositivo();

		categoriaDispositivo.setId(6);
		categoriaDispositivo.setTipoRfs("R_CPE_ACCESS");
		categoriaDispositivo.setNomeCategoria("Modem - SIP WiFi Metalico");

		catalogoDispositivo.setCategoriaDispositivo(categoriaDispositivo);

		List<CaracteristicaDispositivo> caracteristicaDispositivoList = new ArrayList<CaracteristicaDispositivo>();
		caracteristicaDispositivo = new CaracteristicaDispositivo();

		caracteristicaDispositivo.setId(1);
		caracteristicaDispositivo.setNome("Wifi");
		caracteristicaDispositivo.setValor("2.4GHz");
		caracteristicaDispositivo.setCatalogo(catalogoDispositivo);

		caracteristicaDispositivoList.add(caracteristicaDispositivo);
		catalogoDispositivo.setCaracteristicas(caracteristicaDispositivoList);

	}

	@Test
	public void testMerge() throws OSSBusinessException {

		when(catalogoDispositivoRepository.findByModel(anyObject()))
				.thenReturn(Optional.ofNullable(catalogoDispositivo));
		when(catalogoDispositivoRepository.findBySku(anyObject())).thenReturn(Optional.ofNullable(catalogoDispositivo));
		catalogController.merge(catalogoDispositivo);
	}

	@Test
	public void testGetById() throws OSSBusinessException {

		when(catalogoDispositivoRepository.findById(anyObject())).thenReturn(catalogoDispositivo);
		catalogController.getById(catalogoDispositivo.getId());
	}

	@Test
	public void testHasAssociatedDevices() throws OSSBusinessException {

		when(dispositivoFisicoRepository.findByCatalogo(anyObject()))
				.thenReturn(Optional.ofNullable(new DispositivoFisico()));
		catalogController.hasAssociatedDevices(catalogoDispositivo);
	}

	@Test
	public void testAllVendors() {
		List<String> vendors = new ArrayList<>();

		when(catalogoDispositivoRepository.listAllVendors()).thenReturn(vendors);

		assertNotNull(catalogController.listAllVendors());
	}

	@Test
	public void listAllCategories() {
		List<CategoriaDispositivo> categoriaDispositivoList = new ArrayList<>();

		when(categoriaDispositivoRepository.listAll()).thenReturn(categoriaDispositivoList);

		assertNotNull(catalogController.listAllCategories());
	}

	@Test
	public void testListAll() {
		List<CatalogoDispositivo> catalogoDispositivoList = new ArrayList<CatalogoDispositivo>();
		catalogoDispositivoList.add(catalogoDispositivo);

		when(catalogoDispositivoRepository.listAll()).thenReturn(catalogoDispositivoList);

		assertNotNull(catalogController.listAll());
	}

	@Test
	public void testDelete() throws OSSBusinessException {
		CatalogoDispositivo catalogoDispositivo = new CatalogoDispositivo();

		when(catalogoDispositivoRepository.findById(anyObject())).thenReturn(catalogoDispositivo);

		catalogController.delete(1);

	}

	@Test(expected = OSSBusinessException.class)
	public void testGetByIdException() throws OSSBusinessException {

		when(catalogoDispositivoRepository.findById(anyObject())).thenThrow(new OSSBusinessException());
		catalogController.getById(catalogoDispositivo.getId());
	}

	@Test(expected = OSSBusinessException.class)
	public void testMergeModeloException() throws OSSBusinessException {
		CatalogoDispositivo catalogo = new CatalogoDispositivo();
		catalogo.setId(10);
		when(catalogoDispositivoRepository.findByModel(anyObject())).thenReturn(Optional.ofNullable(catalogo));
		catalogController.merge(catalogoDispositivo);
	}

	@Test(expected = OSSBusinessException.class)
	public void testMergeSkuException() throws OSSBusinessException {
		CatalogoDispositivo catalogo = new CatalogoDispositivo();
		catalogo.setId(10);
		when(catalogoDispositivoRepository.findByModel(anyObject()))
				.thenReturn(Optional.ofNullable(catalogoDispositivo));
		when(catalogoDispositivoRepository.findBySku(anyObject())).thenReturn(Optional.ofNullable(catalogo));
		catalogController.merge(catalogoDispositivo);
	}

	@Test(expected = OSSBusinessException.class)
	public void testCatalogNotExist() throws OSSBusinessException {

		when(catalogoDispositivoRepository.findById(anyObject())).thenReturn(null);

		catalogController.delete(1);
	}

}
