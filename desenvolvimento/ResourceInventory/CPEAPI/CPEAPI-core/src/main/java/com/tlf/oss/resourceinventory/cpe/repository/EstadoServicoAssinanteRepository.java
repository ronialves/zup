package com.tlf.oss.resourceinventory.cpe.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.repository.factory.GenericRepository;

public class EstadoServicoAssinanteRepository extends GenericRepository {

	@Inject
	private OSSLogger logger;

	@SuppressWarnings(value = "unchecked")
	public EstadoServicoAssinante findByEstadoServico(EstadoServico estadoServico) {

		logger.log(OSSLogger.INFO, "Buscando o id correspondente ao estado " + estadoServico.getValue() + "...");

		Query query = factory.createQuery("SELECT esa FROM EstadoServicoAssinante esa WHERE UPPER(esa.estadoServico) = ?1");
		query.setParameter(1, estadoServico.getValue().toUpperCase());

		List<EstadoServicoAssinante> estadoServicoAssinante = query.getResultList();

		return estadoServicoAssinante.isEmpty() ? null : estadoServicoAssinante.get(0);
	}
}
