package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CategoriaDispositivo;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;

public class CategoriaDispositivoRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;

	@SuppressWarnings(value = "unchecked")
	public CategoriaDispositivo findByNomeCategoria(String nomeCategoria) {

		logger.log(OSSLogger.INFO, "Buscando id correspondente à categoria: " + nomeCategoria + " na tabela CategoriaDispositivo...");

		Query query = factory.createQuery("SELECT cd FROM CategoriaDispositivo cd WHERE UPPER(cd.nomeCategoria) = ?1");
		query.setParameter(1, nomeCategoria.toUpperCase());

		List<CategoriaDispositivo> categoriaDispositivo = query.getResultList();

		return categoriaDispositivo.isEmpty() ? null : categoriaDispositivo.get(0);
	}
	
	@SuppressWarnings(value = "unchecked")
	public List<CategoriaDispositivo> listAll() {
		logger.log(OSSLogger.INFO, "Buscando o catálogo de dispositivos");

		Query query = factory.createQuery(
				"SELECT a FROM CategoriaDispositivo a");
		List<CategoriaDispositivo> categoria = query.getResultList();

		logger.log(OSSLogger.INFO, "Encontrados " + categoria.size() + " categorias!");

		return categoria;
	}
}
