package com.tlf.oss.resourceinventory.cpe.core;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CategoriaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.CpeWsName;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.cpe.helper.AllocateHelper;
import com.tlf.oss.resourceinventory.cpe.mapping.EntityConverter;
import com.tlf.oss.resourceinventory.cpe.repository.CategoriaDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Allocate;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateController {

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
	private ExecutionRules executionRules;

	@Inject
	private CategoriaDispositivoRepository categoriaDispositivoRepository;

	@Inject
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	@Inject
	private EstadoServicoAssinanteRepository estadoServicoAssinanteRepository;

	@Inject
	private AllocateHelper helper;

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity allocate(@Allocate ResourceInventoryEntity entity) throws OSSBusinessException {

		try {
			String roiAction = EntityExtractor.extractResourceOrderItemAction(entity);
			String extractResourceOrderItemName = EntityExtractor.extractResourceOrderItemName(entity);
			String serviceId = EntityExtractor.extractServiceIdFromCfs(entity);
			DispositivoFisico dispositivoFisico = dispositivoFisicoRepository.findByServiceId(serviceId);

			if (null == dispositivoFisico && TipoRfs.VOIP.getRoiName().equals(extractResourceOrderItemName)) {
				throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(
						OssBusinessExceptionFactory.DEFAULT_ERROR_CODE,
						"Não é permitido efetuar alocação de Linha Telefônica (VOIP) sem antes efetuar uma alocação de Banda (ACCESS).",
						CpeWsName.ALLOCATE);
			}

			logger.log(OSSLogger.INFO, "Iniciando o allocate de R_CPE_ACCESS/R_CPE_VOIP ...");

			if (isProvide(roiAction)) {
				provideAndAdd(entity);
			} else if (isModify(roiAction)) {
				modify(entity);
			} else {
				throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
						"Ação inválida no ResourceOrder " + roiAction);
			}

			logger.log(OSSLogger.INFO, "Finalizando o allocate de R_CPE_ACCESS/R_CPE_VOIP...");
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

	private boolean isVoiceEquipmentType(ResourceInventoryEntity entity, String name, TipoRfs type)
			throws OSSBusinessException {

		boolean result = false;

		if (null != entity && null != name && null != type) {

			String defineNomeCategoria = executionRules.defineNomeCategoria(entity);

			CategoriaDispositivo categoriaDispositivo = categoriaDispositivoRepository
					.findByNomeCategoria(defineNomeCategoria);

			if (null != categoriaDispositivo) {
				result = categoriaDispositivo.getNomeCategoria().toUpperCase().contains(name.toUpperCase())
						&& type.getRoiName().equalsIgnoreCase(categoriaDispositivo.getTipoRfs());
			}
		}

		logger.log(OSSLogger.INFO, "Verificando VOICE_EQUIPMENT_TYPE para " + name + " : " + type + " = " + result);

		return result;
	}

	private void provideAndAdd(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Action PROVIDE or ADD");

		ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);

		if (servicoAssinante == null || servicoAssinante.getId() == null) {

			servicoAssinante = entityConverter.toServicoAssinante(entity, EstadoServico.EM_APROVISIONAMENTO);

			servicoAssinanteRepository.create(servicoAssinante);

		}

		EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
				.findByEstadoRecurso(EstadoRecurso.NAO_INSTALADO);

		DispositivoFisico dispositivoFisico = dispositivoFisicoRepository.findByAccessId(servicoAssinante.getAccessId(),
				estadoRecursoLogico);

		EstadoServicoAssinante estadoServicoAssinante = estadoServicoAssinanteRepository
				.findByEstadoServico(EstadoServico.EM_APROVISIONAMENTO);

		if (servicoAssinante.getEstadoServicoAssinanteId().equals(estadoServicoAssinante.getId())
				&& TipoRfs.ACCESS.getRoiName().equals(servicoAssinante.getTipoRfs())) {
			helper.validate(dispositivoFisico);
		}

		boolean isVoiceEquipmentTypeATA = isVoiceEquipmentType(entity, CpeConstants.ATA, TipoRfs.VOIP);

		if (null == dispositivoFisico || isVoiceEquipmentTypeATA) {
			dispositivoFisico = entityConverter.toDispositivoFisico(entity);

			dispositivoFisicoRepository.create(dispositivoFisico);
		}

		RecursoLogico recursoLogico = entityConverter.toRecursoLogico(dispositivoFisico, servicoAssinante);
		recursoLogico.setIdFxs(helper.defineIdFxs(entity));

		recursoLogico.setEstadoRecursoLogicoId(estadoRecursoLogico.getId());

		recursoLogicoRepository.create(recursoLogico);
	}

	private void modify(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Action MODIFY");
		helper.modify(entity);
	}

	private boolean isProvide(String action) {
		return null == action || action.isEmpty() || RoiAction.PROVIDE.getAction().equalsIgnoreCase(action)
				|| RoiAction.ADD.getAction().equalsIgnoreCase(action);
	}

	private boolean isModify(String action) {
		return null != action && RoiAction.MODIFY.getAction().equalsIgnoreCase(action);
	}
}
