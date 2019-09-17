package com.tlf.oss.resourceinventory.cpe.core;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Deallocate;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateStbController {

	@Inject
	private OSSLogger logger;

	@Inject
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Inject
	private RecursoLogicoRepository recursoLogicoRepository;

	@Inject
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Inject
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity deallocate(@Deallocate final ResourceInventoryEntity entity)
			throws OSSBusinessException {

		try {
			logger.log(OSSLogger.INFO, "Iniciando o deallocate no R_CPE_STB...");

			final String serviceId = EntityExtractor.extractServiceId(entity);
			final ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);

			if (null != servicoAssinante) {

				final EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
						.findByEstadoRecurso(EstadoRecurso.NAO_INSTALADO);

				final List<RecursoLogico> recursosLogicos = recursoLogicoRepository.listByServiceId(serviceId);
				final Optional<RecursoLogico> recursoLogicoFound = recursosLogicos.stream().filter(
						recursoLogico -> estadoRecursoLogico.getId().equals(recursoLogico.getEstadoRecursoLogicoId()))
						.findFirst();

				if (recursoLogicoFound.isPresent()) {

					final DispositivoFisico dispositivoFisico = dispositivoFisicoRepository
							.findById(recursoLogicoFound.get().getDispositivoFisicoId());

					recursoLogicoRepository.delete(recursoLogicoFound.get());
					dispositivoFisicoRepository.delete(dispositivoFisico);

					if (recursosLogicos.size() == 1) {
						servicoAssinanteRepository.delete(servicoAssinante);
					}
				}

				logger.log(OSSLogger.INFO, "Finalizando o deallocate no R_CPE_STB...");

			}

			return entity;
		} catch (OSSBusinessException obe) {
			logger.error(obe.getMessage(), obe);
			throw obe;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					e.getMessage());
		}
	}

}
