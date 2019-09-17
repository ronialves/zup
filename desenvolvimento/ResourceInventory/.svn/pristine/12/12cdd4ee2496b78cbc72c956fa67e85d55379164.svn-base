package com.tlf.oss.resourceinventory.cpe.core;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.helper.AllocateHelper;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.ServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Deallocate;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DeallocateController {

	@Inject
	private ServicoAssinanteRepository servicoAssinanteRepository;

	@Inject
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Inject
	private RecursoLogicoRepository recursoLogicoRepository;

	@Inject
	private OSSLogger logger;
	
	@Inject
	private AllocateHelper helper;

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity deallocate(@Deallocate final ResourceInventoryEntity entity)
			throws OSSBusinessException {

		try {
			
			logger.log(OSSLogger.INFO, "Iniciando o deallocate no CPE...");

			String roiAction = EntityExtractor.extractResourceOrderItemAction(entity);
			
			if(isModify(roiAction)) {
				modify(entity);
			} else {
				delete(entity);

			}
			
			logger.log(OSSLogger.INFO, "Finalizando o deallocate no CPE...");
			
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


	private void redefineIdFxs(final ResourceInventoryEntity entity) throws OSSBusinessException {
		try {

			logger.log(OSSLogger.INFO, "Iniciando a redefinição dos campos ID_FXS das entidades Recursos Lógico...");

			List<ServicoAssinante> servicoAssinanteList = servicoAssinanteRepository.listByAccessId(entity).stream()
					.filter(sa -> TipoRfs.VOIP.getRoiName().equalsIgnoreCase(sa.getTipoRfs()))
					.collect(Collectors.toList());
			List<RecursoLogico> recursoLogicoList = recursoLogicoRepository.listByAccessId(entity).stream().filter(
					rl -> servicoAssinanteList.stream().anyMatch(sa -> sa.getId().equals(rl.getServicoAssinanteId())))
					.collect(Collectors.toList());

			Optional<ServiceSpecCharDescribes> voiceTotalPortsOptional = EntityExtractor.extractVoiceTotalPorts(entity);

			if (voiceTotalPortsOptional.isPresent()) {

				List<RecursoLogico> recursoLogicoListPorIdFxs = recursoLogicoList.stream()
						.sorted((p1, p2) -> p1.getIdFxs().compareTo(p2.getIdFxs())).collect(Collectors.toList());

				Integer numero = 1;
				for (RecursoLogico rl : recursoLogicoListPorIdFxs) {
					rl.setIdFxs(numero);
					numero = +1;
					recursoLogicoRepository.update(rl);
				}
			}

			logger.log(OSSLogger.INFO, "Finalizando a redefinição dos campos ID_FXS das entidades Recursos Lógico...");

		} catch (OSSBusinessException obe) {
			logger.error(obe.getMessage(), obe);
			throw obe;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new OSSBusinessException(FalloutCode.RICPE_999.getDescription(), FalloutCode.RICPE_999.getValue(),
					e.getMessage());
		}

	}
	
	private void delete(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		final ServicoAssinante servicoAssinante = servicoAssinanteRepository.findByServiceId(entity);

		if (null != servicoAssinante) {
			final RecursoLogico recursoLogico = recursoLogicoRepository
					.findByServicoAssinanteId(servicoAssinante.getId());

			final DispositivoFisico dispositivoFisico = dispositivoFisicoRepository
					.findById(recursoLogico.getDispositivoFisicoId());
		
			recursoLogicoRepository.delete(recursoLogico);
	
			servicoAssinanteRepository.delete(servicoAssinante);
	
			if (!hasDispositivoFisicoChildren(dispositivoFisico)) {
				dispositivoFisicoRepository.delete(dispositivoFisico);
			}
			
			if (TipoRfs.VOIP.getRoiName().equalsIgnoreCase(servicoAssinante.getTipoRfs())){
				redefineIdFxs(entity);
			}
		}
	}
	
	private boolean hasDispositivoFisicoChildren(final DispositivoFisico df) throws OSSBusinessException {
		return recursoLogicoRepository.findByDispositivoFisicoId(df.getId()) != null;
	}
	
	private boolean isModify(String action) {
	    return null != action && RoiAction.MODIFY.getAction().equalsIgnoreCase(action);
	}
	
	private void modify(ResourceInventoryEntity entity) throws OSSBusinessException {
		 
	    logger.log(OSSLogger.INFO, "Action MODIFY");
	    helper.modify(entity);
	}

}
