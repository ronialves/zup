package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CaracteristicaDispositivo;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;

public class CaracteristicaDispositivoRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;
	
	public void merge(CaracteristicaDispositivo caracteristica) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Mesclando o registro na tabela CaracteristicaDispositivo: " + caracteristica);
	
		super.update(caracteristica);
	}

	@SuppressWarnings(value = "unchecked")
	public List<CaracteristicaDispositivo> findByCatalogoDispositivoId(Integer id) {
		logger.log(OSSLogger.INFO, "Buscando as características do catálogo de id: " + id + "...");

		Query query = factory.createQuery("SELECT cd FROM CaracteristicaDispositivo cd WHERE cd.catalogo.id = ?1");

		query.setParameter(1, id);

		List<CaracteristicaDispositivo> caracteristicas = query.getResultList();

		logger.log(OSSLogger.INFO, "Encontradas " + caracteristicas.size() + " características no catálogo!");

		return caracteristicas;
	}
}
