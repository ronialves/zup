package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;

public class CatalogoDispositivoRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;

	@SuppressWarnings(value = "unchecked")
	public List<CatalogoDispositivo> findByCategoriaDispositivoIdAndModel(Integer categoriaDispositivoId, String model) {
		logger.log(OSSLogger.INFO, "Buscando o catálogo de dispositivos com Categoria de id: " + categoriaDispositivoId
				+ " Modelo: " + model +  "...");

		Query query = factory.createQuery(
				"SELECT cd FROM CatalogoDispositivo cd WHERE cd.categoriaDispositivoId = ?1 AND UPPER(cd.modelo) = ?2");
		query.setParameter(1, categoriaDispositivoId);
		query.setParameter(2, model.toUpperCase());

		List<CatalogoDispositivo> catalogo = query.getResultList();

		logger.log(OSSLogger.INFO, "Encontrados " + catalogo.size() + " equipamentos no catálogo!");

		return catalogo;
	}

	public CatalogoDispositivo findById(Integer id) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Buscando o registro na tabela CatalogoDispositivo com id: " + id);

		return super.findById(CatalogoDispositivo.class, id);
	}

	@SuppressWarnings(value = "unchecked")
	public List<CatalogoDispositivo> listAll() {

		logger.log(OSSLogger.INFO, "Buscando o catálogo de dispositivos");

		Query query = factory.createQuery("SELECT a FROM CatalogoDispositivo a");

		List<CatalogoDispositivo> catalogo = query.getResultList();

		logger.log(OSSLogger.INFO, "Encontrados " + catalogo.size() + " equipamentos no catálogo!");

		return catalogo;

	}

	public void delete(CatalogoDispositivo id) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Excluindo o registro na tabela CatalogoDispositivo: " + id);
		super.delete(id);
	}
	
	public void create(CatalogoDispositivo id) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Criando o registro na tabela CatalogoDispositivo: " + id);
		super.create(id);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<CatalogoDispositivo> findByModel(String modelo) {
		logger.log(OSSLogger.INFO, "Buscando registros na tabela CatalogoDispositivo com modelo: " + modelo);
		
		Query query = factory.createQuery("SELECT cd FROM CatalogoDispositivo cd WHERE cd.modelo = ?1");
		query.setParameter(1, modelo);
		
		List<CatalogoDispositivo> catalogo = query.getResultList();
		
		return catalogo.stream().findFirst();
	}
	
	@SuppressWarnings("unchecked")
	public Optional<CatalogoDispositivo> findBySku(String sku) {
		logger.log(OSSLogger.INFO, "Buscando registros na tabela CatalogoDispositivo com sku: " + sku);
		
		Query query = factory.createQuery("SELECT cd FROM CatalogoDispositivo cd WHERE cd.sku = ?1");
		query.setParameter(1, sku);
		
		List<CatalogoDispositivo> skus = query.getResultList();
		
		return skus.stream().findFirst();
	}
	
	public void merge(CatalogoDispositivo catalogo) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Incluindo o registro na tabela CatalogoDispositivo: " + catalogo);

		super.update(catalogo);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> listAllVendors() {
		logger.log(OSSLogger.INFO, "Buscando todos os registros de fabricantes da tabela CatalogoDispositivo");
		
		Query query = factory.createQuery("SELECT DISTINCT cd.fabricante FROM CatalogoDispositivo cd");
		List<String> vendors = query.getResultList();
		
		return vendors;
	}
}
