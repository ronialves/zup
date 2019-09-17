package com.tlf.oss.resourceinventory.cpe.core;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.mapping.EntityConverter;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Allocate;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateStbController {

	@Inject
	private OSSLogger logger;

	@Inject
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Inject
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Inject
	private RecursoLogicoRepository recursoLogicoRepository;

	@Inject
	private EntityConverter entityConverter;

	@Inject
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity allocate(@Allocate ResourceInventoryEntity entity) throws OSSBusinessException {

		try {

			String roiAction = EntityExtractor.extractResourceOrderItemAction(entity);

			if (isProvide(roiAction)) {
				provideAndAdd(entity);
			} else {
				throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
						"Ação inválida no ResourceOrder " + roiAction);
			}

		} catch (OSSBusinessException obe) {
			logger.error(obe.getMessage(), obe);
			throw obe;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					e.getMessage());
		}

		return entity;
	}

	private void provideAndAdd(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Iniciando o allocate de R_CPE_STB ...");

		ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);

		if (servicoAssinante == null || servicoAssinante.getId() == null) {
			servicoAssinante = entityConverter.toServicoAssinante(entity, EstadoServico.EM_APROVISIONAMENTO);
			servicoAssinanteRepository.create(servicoAssinante);
		}

		DispositivoFisico dispositivoFisico = entityConverter.toDispositivoFisico(entity);
		dispositivoFisicoRepository.create(dispositivoFisico);

		RecursoLogico recursoLogico = entityConverter.toRecursoLogico(dispositivoFisico, servicoAssinante);
		EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
				.findByEstadoRecurso(EstadoRecurso.NAO_INSTALADO);
		recursoLogico.setEstadoRecursoLogicoId(estadoRecursoLogico.getId());
		recursoLogicoRepository.create(recursoLogico);

		logger.log(OSSLogger.INFO, "Finalizando o allocate de R_CPE_STB...");
	}

	private boolean isProvide(String action) {
		return null == action || action.isEmpty() || RoiAction.PROVIDE.getAction().equalsIgnoreCase(action)
				|| RoiAction.ADD.getAction().equalsIgnoreCase(action);
	}

}
