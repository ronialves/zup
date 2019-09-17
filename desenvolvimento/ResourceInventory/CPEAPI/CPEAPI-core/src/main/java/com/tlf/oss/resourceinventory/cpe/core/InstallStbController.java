package com.tlf.oss.resourceinventory.cpe.core;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.CpeWsName;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Install;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class InstallStbController {

	@Inject
	private OSSLogger logger;

	@Inject
	private EstadoServicoAssinanteRepository estadoServicoAssinanteRepository;

	@Inject
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	@Inject
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Inject
	private RecursoLogicoRepository recursoLogicoRepository;

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity install(@Install ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			logger.log(OSSLogger.INFO, "Iniciando o install no CPE...");

			ativarServicoAssinante(entity);
			ativarRecursoLogico(entity);

			logger.log(OSSLogger.INFO, "Finalizando o install no CPE...");

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

	private void ativarServicoAssinante(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Ativando Servicço Assinante.");

		ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);

		if (null != servicoAssinante) {

			EstadoServicoAssinante estadoServicoAssinante = estadoServicoAssinanteRepository
			        .findByEstadoServico(EstadoServico.ATIVADO);

			if (!estadoServicoAssinante.getId().equals(servicoAssinante.getEstadoServicoAssinanteId())) {

				servicoAssinante.setEstadoServicoAssinanteId(estadoServicoAssinante.getId());

				servicoAssinanteRepository.update(servicoAssinante);

				logger.log(OSSLogger.INFO, "Serviço Assinante ativado.");

			} else {
				logger.log(OSSLogger.INFO, "Serviço Assinante já está ativo.");
			}
		} else {
			String type = TipoRfs.fromRoiName(EntityExtractor.extractResourceOrderItemName(entity)).getType();
			String serviceId = EntityExtractor.extractServiceId(entity);
			String message = "Não foi encontrado um cliente com o Designador de " + type + " " + serviceId;

			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(
			        OssBusinessExceptionFactory.DEFAULT_ERROR_CODE, message, CpeWsName.INSTALL);
		}
	}

	private void ativarRecursoLogico(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Ativando Recurso Lógico.");

		String serviceId = EntityExtractor.extractServiceId(entity);

		Optional<RecursoLogico> recursoLogicoFound = findRecursoLogico(serviceId);

		if (recursoLogicoFound.isPresent()) {

			RecursoLogico recursoLogico = recursoLogicoFound.get();

			EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
			        .findByEstadoRecurso(EstadoRecurso.INSTALADO);

			recursoLogico.setEstadoRecursoLogicoId(estadoRecursoLogico.getId());

			recursoLogicoRepository.update(recursoLogico);

			logger.log(OSSLogger.INFO, "Recurso Lógico instalado.");

		} else {
			throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
			        "Nenhum recurso encontrado para o serviceId " + serviceId);
		}
	}

	private Optional<RecursoLogico> findRecursoLogico(String serviceId) throws OSSBusinessException {

		EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
		        .findByEstadoRecurso(EstadoRecurso.NAO_INSTALADO);

		List<RecursoLogico> recursosLogicos = recursoLogicoRepository.listByServiceId(serviceId);

		return recursosLogicos.stream()
		        .filter(recursoLogico -> estadoRecursoLogico.getId().equals(recursoLogico.getEstadoRecursoLogicoId()))
		        .findFirst();
	}
}
