package com.tlf.oss.resourceinventory.cpe.core;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CategoriaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.repository.CatalogoDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.CategoriaDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;

public class CatalogController {

	@Inject
	private OSSLogger logger;

	@Inject
	private CatalogoDispositivoRepository catalogoDispositivoRepository;

	@Inject
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Inject
	private CategoriaDispositivoRepository categoriaDispositivoRepository;

	public List<CatalogoDispositivo> listAll() {
		logger.log(OSSLogger.INFO, "Iniciando o CatalogController no CPE...");

		return catalogoDispositivoRepository.listAll();
	}

	public void delete(Integer catalogoId) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Iniciando o delete CatalogController no CPE...");

		try {
			CatalogoDispositivo catalogoDispositivo = catalogoDispositivoRepository.findById(catalogoId);

			if (null != catalogoDispositivo) {
				catalogoDispositivoRepository.delete(catalogoDispositivo);
			} else {
				throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
						"Nenhum resgistro encontrado ");
			}

		} catch (Exception e) {
			logger.log(OSSLogger.ERROR, e.getMessage());
			throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
					"O equipamento não pode ser excluído pois possui um dispositivo vinculado a ele ");
		}

	}

	public void merge(CatalogoDispositivo catalogo) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Iniciando o merge CatalogController no CPE...");

		Optional<CatalogoDispositivo> modelo = catalogoDispositivoRepository.findByModel(catalogo.getModelo());
		if (!modelo.isPresent() || modelo.get().getId().equals(catalogo.getId())) {
			Optional<CatalogoDispositivo> sku = catalogoDispositivoRepository.findBySku(catalogo.getSku());
			if (!sku.isPresent() || sku.get().getId().equals(catalogo.getId())) {
				catalogoDispositivoRepository.merge(catalogo);
			} else {
				throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
						"SKU já existente na base do Inventário de Equipamentos");
			}
		} else {
			throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
					"Modelo já existente na base do Inventário de Equipamentos");
		}
	}

	public CatalogoDispositivo getById(Integer catalogoId) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "CatalogController CPE Buscando Catalogo por id...");

		try {

			return catalogoDispositivoRepository.findById(catalogoId);

		} catch (Exception e) {

			throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
					"Nenhum resgistro encontrado ");
		}

	}

	public boolean hasAssociatedDevices(CatalogoDispositivo catalogo) throws OSSBusinessException {
		Optional<DispositivoFisico> dispositivoFisico = dispositivoFisicoRepository.findByCatalogo(catalogo);
		return dispositivoFisico.isPresent();
	}

	public List<String> listAllVendors() {
		return catalogoDispositivoRepository.listAllVendors();
	}

	public List<CategoriaDispositivo> listAllCategories() {
		return categoriaDispositivoRepository.listAll();
	}
}
