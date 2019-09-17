package com.tlf.oss.resourceinventory.cpe.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
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
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateHelper {

	@Inject
	private OSSLogger logger;

	@Inject
	private RecursoLogicoRepository recursoLogicoRepository;

	@Inject
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	@Inject
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Inject
	private EstadoServicoAssinanteRepository estadoServicoAssinanteRepository;

	public void validate(DispositivoFisico dispositivoFisico) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Verificando se é uma alocação válida...");

		if (null != dispositivoFisico) {

			RecursoLogico recurso = recursoLogicoRepository.findByDispositivoFisicoId(dispositivoFisico.getId());

			EstadoRecursoLogico estadoRecursoLogicoDesconectado = estadoRecursoLogicoRepository
					.findByEstadoRecurso(EstadoRecurso.DESCONECTADO);

			if (null != recurso
					&& !estadoRecursoLogicoDesconectado.getId().equals(recurso.getEstadoRecursoLogicoId())) {

				ServicoAssinante servicoAssinante = servicoAssinanteRepository
						.findById(recurso.getServicoAssinanteId());

				String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
				String errorMessage = "Designador de " + TipoRfs.fromRoiName(servicoAssinante.getTipoRfs()).getType()
						+ " " + servicoAssinante.getServiceId() + " já alocado para o Designador de Acesso "
						+ servicoAssinante.getAccessId();

				throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(errorCode, errorMessage,
						CpeWsName.ALLOCATE);
			}
		}
	}

	public Integer defineIdFxs(final ResourceInventoryEntity entity) throws OSSBusinessException {

		try {
			logger.log(OSSLogger.INFO, "Iniciando a definição do campo ID_FXS da entidade Recursos Lógico...");

			Integer idFxs = 0;
			ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);

			if (null != servicoAssinante && TipoRfs.VOIP.getRoiName().equalsIgnoreCase(servicoAssinante.getTipoRfs())) {

				List<ServicoAssinante> servicoAssinanteList = servicoAssinanteRepository.listByAccessId(entity).stream()
						.filter(sa -> TipoRfs.VOIP.getRoiName().equalsIgnoreCase(sa.getTipoRfs()))
						.collect(Collectors.toList());

				List<RecursoLogico> recursoLogicoList = recursoLogicoRepository.listByAccessId(entity).stream()
						.filter(rl -> servicoAssinanteList.stream()
								.anyMatch(sa -> sa.getId().equals(rl.getServicoAssinanteId())))
						.collect(Collectors.toList());

				Optional<ServiceSpecCharDescribes> voiceTotalPortsOptional = EntityExtractor
						.extractVoiceTotalPorts(entity);

				if (voiceTotalPortsOptional.isPresent()) {
					Integer voiceTotalPortsConvertido = Integer.parseInt(voiceTotalPortsOptional.get().getValue());

					if (voiceTotalPortsConvertido > recursoLogicoList.size()) {
						idFxs = recursoLogicoList.size() + 1;
					}

					logger.log(OSSLogger.INFO, "Finalizando a definição do campo ID_FXS da entidade Recursos Lógico");

				} else {
					throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(
							OssBusinessExceptionFactory.DEFAULT_ERROR_CODE, "Quantidades de portas Fxs indisponível",
							CpeWsName.ALLOCATE);
				}
			}

			return idFxs;

		} catch (OSSBusinessException obe) {
			logger.error(obe.getMessage(), obe);
			throw obe;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					e.getMessage());
		}

	}

	public void modify(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Action MODIFY");

		ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);

		if (null != servicoAssinante) {
			ResourceFacingService rfsCease = EntityExtractor.extractTelephoneRfs(entity, RoiAction.CEASE).get();

			String numberCease = EntityExtractor.extractTelephoneNumber(rfsCease);

			if (servicoAssinante.getNumeroTelefone().equals(numberCease)) {
				ResourceFacingService rfsProvide = EntityExtractor.extractTelephoneRfs(entity, RoiAction.PROVIDE).get();

				String numberProvide = EntityExtractor.extractTelephoneNumber(rfsProvide);

				servicoAssinante.setNumeroTelefone(numberProvide);

				EstadoServicoAssinante estadoServicoAssinante = estadoServicoAssinanteRepository
						.findByEstadoServico(EstadoServico.EM_APROVISIONAMENTO);

				servicoAssinante.setEstadoServicoAssinanteId(estadoServicoAssinante.getId());

				servicoAssinanteRepository.update(servicoAssinante);
			} else {
				throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(
						OssBusinessExceptionFactory.DEFAULT_ERROR_CODE,
						"O Número de Telefone no inventário não é o mesmo que está sendo enviado para desconexão (Inventário: "
								+ servicoAssinante.getNumeroTelefone() + " | Enviado: " + numberCease + ")",
						CpeWsName.ALLOCATE);
			}
		} else {
			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(
					OssBusinessExceptionFactory.DEFAULT_ERROR_CODE,
					"Nenhum recurso encontrado para o Designador de Linha Telefônica "
							+ EntityExtractor.extractServiceId(entity),
					CpeWsName.ALLOCATE);
		}
	}

}
