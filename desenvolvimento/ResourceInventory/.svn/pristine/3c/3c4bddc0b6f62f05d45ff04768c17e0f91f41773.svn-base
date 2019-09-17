package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;

public class EstadoRecursoLogicoRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;

	@SuppressWarnings(value = "unchecked")
	public EstadoRecursoLogico findByEstadoRecurso(EstadoRecurso estadoRecurso) {

		logger.log(OSSLogger.INFO, "Buscando o id correspondente ao estado " + estadoRecurso.getValue() + "...");

		Query query = factory.createQuery("SELECT er FROM EstadoRecursoLogico er WHERE UPPER(er.estadoRecurso) = ?1");
		query.setParameter(1, estadoRecurso.getValue().toUpperCase());

		List<EstadoRecursoLogico> estadoRecursoLogicoList = query.getResultList();

		return estadoRecursoLogicoList.isEmpty() ? null : estadoRecursoLogicoList.get(0);
	}
}
