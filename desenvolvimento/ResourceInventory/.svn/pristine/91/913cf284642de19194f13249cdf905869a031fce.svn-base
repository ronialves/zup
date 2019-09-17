package com.tlf.oss.resourceinventory.cpe.core;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.CpeWsName;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Uninstall;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UninstallStbController {

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
	public ResourceInventoryEntity uninstall(@Uninstall final ResourceInventoryEntity entity)
			throws OSSBusinessException {

		Optional<ServiceSpecCharDescribes> iptvCeaseType = EntityExtractor.extractIptvCeaseType(entity);

		if (iptvCeaseType.isPresent()
				&& CpeConstants.IPTV_CEASE_TYPE_VALUE_TOTAL.equalsIgnoreCase(iptvCeaseType.get().getValue())) {

			uninstallTotal(entity);

		} else {

			uninstallPartial(entity);

		}

		return entity;
	}

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity uninstallPartial(@Uninstall final ResourceInventoryEntity entity)
			throws OSSBusinessException {
		try {

			logger.log(OSSLogger.INFO, "Iniciando o UninstallPartial no R_CPE_STB ...");

			String serviceId = EntityExtractor.extractServiceId(entity);

			Optional<RecursoLogico> recursoLogicoFound = findRecursoLogico(entity);

			if (recursoLogicoFound.isPresent()) {

				ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);
				DispositivoFisico dispositivoFisico = dispositivoFisicoRepository
						.findById(recursoLogicoFound.get().getDispositivoFisicoId());

				recursoLogicoRepository.delete(recursoLogicoFound.get());
				dispositivoFisicoRepository.delete(dispositivoFisico);
				if (!hasServicoAssinanteChildren(servicoAssinante)) {
					servicoAssinanteRepository.delete(servicoAssinante);
				}

			} else {
				String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
				String errorMessage = "Não foi encontrado um cliente com o Designador de TV " + serviceId;

				throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(errorCode, errorMessage,
						CpeWsName.UNINSTALL);
			}

			logger.log(OSSLogger.INFO, "Finalizando o Uninstall no R_CPE_STB ...");

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

	public ResourceInventoryEntity uninstallTotal(@Uninstall final ResourceInventoryEntity entity)
			throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Iniciando o UninstallTotal no R_CPE_STB ...");

		try {

			List<ServicoAssinante> servicoAssinante = servicoAssinanteRepository.listByAccessId(entity).stream()
					.filter(sa -> TipoRfs.STB.getRoiName().equalsIgnoreCase(sa.getTipoRfs()))
					.collect(Collectors.toList());

			List<RecursoLogico> recursoLogico = recursoLogicoRepository.listByAccessId(entity).stream().filter(
					rl -> servicoAssinante.stream().anyMatch(sa -> sa.getId().equals(rl.getServicoAssinanteId())))
					.collect(Collectors.toList());

			List<DispositivoFisico> dispositivoFisico = dispositivoFisicoRepository.listByAccessId(entity).stream()
					.filter(df -> recursoLogico.stream().anyMatch(rl -> rl.getDispositivoFisicoId().equals(df.getId())))
					.collect(Collectors.toList());

			for (RecursoLogico rl : recursoLogico) {

				recursoLogicoRepository.delete(rl);

			}

			for (ServicoAssinante sa : servicoAssinante) {

				servicoAssinanteRepository.delete(sa);
			}

			for (DispositivoFisico df : dispositivoFisico) {

				dispositivoFisicoRepository.delete(df);
			}

			logger.log(OSSLogger.INFO, "Finalizando o Uninstall no R_CPE_STB ...");
		} catch (

		OSSBusinessException obe) {
			logger.error(obe.getMessage(), obe);
			throw obe;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					e.getMessage());
		}

		return entity;

	}

	private boolean hasServicoAssinanteChildren(final ServicoAssinante servicoAssinante) throws OSSBusinessException {

		return recursoLogicoRepository.findByServicoAssinanteId(servicoAssinante.getId()) != null;
	}

	private Optional<RecursoLogico> findRecursoLogico(final ResourceInventoryEntity entity)
			throws OSSBusinessException {

		String serviceId = EntityExtractor.extractServiceId(entity);

		List<RecursoLogico> recursosLogicos = recursoLogicoRepository.listByServiceId(serviceId);
		EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
				.findByEstadoRecurso(EstadoRecurso.DESCONECTADO);

		return recursosLogicos.stream()
				.filter(recursoLogico -> estadoRecursoLogico.getId().equals(recursoLogico.getEstadoRecursoLogicoId()))
				.findFirst();
	}
}
