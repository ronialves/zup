package com.tlf.oss.resourceinventory.cpe.core;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.CpeWsName;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.cpe.helper.UpdateHelper;
import com.tlf.oss.resourceinventory.cpe.mapping.EntityConverter;
import com.tlf.oss.resourceinventory.cpe.repository.CategoriaDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Update;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UpdateController {

	@Inject
	private OSSLogger logger;

	@Inject
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Inject
	private EntityConverter entityConverter;

	@Inject
	private CategoriaDispositivoRepository categoriaDispositivoRepository;

	@Inject
	private ExecutionRules rules;

	@Inject
	private UpdateHelper helper;
	
	@Inject
	private RecursoLogicoRepository recursoLogicoRepository; 
	
	@Inject
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity update(@Update ResourceInventoryEntity entity) throws OSSBusinessException {
		try {
			logger.log(OSSLogger.INFO, "Iniciando o update no CPE...");
			
			String roiAction = EntityExtractor.extractResourceOrderItemAction(entity);
			
			if (isProvide(roiAction)) {
				provideAndAdd(entity);
			} else if (isCease(roiAction)) {
				updateCease(entity);
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
		
		ServicoAssinante servicoAssinante = entityConverter.toServicoAssinante(entity,
				EstadoServico.EM_APROVISIONAMENTO);
		DispositivoFisico dispositivoFisico = dispositivoFisicoRepository
				.findByServiceId(servicoAssinante.getServiceId());

		if (null != dispositivoFisico) {
			if (isSelfProvisioning(entity)) {
				String macAddress = EntityExtractor.extractMacAddress(entity).get().getValue();
				Optional<DispositivoFisico> macAddressResult = dispositivoFisicoRepository
						.findByMacaddress(macAddress);

				if (!macAddressResult.isPresent()) {
					String serialNumber = EntityExtractor.extractSerialNumber(entity).get().getValue();
					Optional<DispositivoFisico> serialNumberResult = dispositivoFisicoRepository
							.findBySerialNumber(serialNumber);

					if (!serialNumberResult.isPresent()) {
						String defineNomeCategoria = rules.defineNomeCategoria(entity);

						Integer categoriaDispositivoId = categoriaDispositivoRepository
								.findByNomeCategoria(defineNomeCategoria).getId();

						CatalogoDispositivo equipment = helper.getCatalogoDispositivo(entity);

						dispositivoFisico.setCategoriaDispositivoCorrente(categoriaDispositivoId);
						dispositivoFisico.setMacAddress(macAddress);
						dispositivoFisico.setCatalagoDispositivoId(equipment.getId());
						dispositivoFisico.setNumeroSerial(serialNumber);
					} else {
						String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
						String errorMessage = "Número serial " + serialNumber + " já utilizado por outro cliente";

						throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(errorCode, errorMessage,
								CpeWsName.UPDATE);
					}
				} else {
					String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
					String errorMessage = "Macaddress " + macAddress + " já utilizado por outro cliente";

					throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(errorCode, errorMessage,
							CpeWsName.UPDATE);
				}
			} else {
				dispositivoFisico
						.setNumeroSerialGpon(EntityExtractor.extractGponSerialNumber(entity).get().getValue());
			}

			dispositivoFisicoRepository.update(dispositivoFisico);

			logger.log(OSSLogger.INFO, "Finalizando o update no CPE...");
		} else {
			String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
			String errorMessage = "Não foi encontrado um cliente com o Designador de " 
			+ TipoRfs.fromRoiName(servicoAssinante.getTipoRfs()).getType() + " " + servicoAssinante.getServiceId();

			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(errorCode,
                                                							 errorMessage,
                                                							 CpeWsName.UPDATE);
		}
		
	}
	
	private void updateCease(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Action CEASE ...");

		String serviceId = EntityExtractor.extractServiceId(entity);

		Optional<ServiceSpecCharDescribes> serialNumber = EntityExtractor.extractSerialNumber(entity);

		Optional<DispositivoFisico> dispositivoFisicoFound = dispositivoFisicoRepository.findBySerialNumber(serialNumber.get().getValue());

		if (dispositivoFisicoFound.isPresent()) {
			
			Optional<RecursoLogico> recursoLogico = recursoLogicoRepository.listByServiceId(serviceId).stream().findFirst();

			if (recursoLogico.isPresent()) {
				EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
				        .findByEstadoRecurso(EstadoRecurso.DESCONECTADO);

				recursoLogico.get().setEstadoRecursoLogicoId(estadoRecursoLogico.getId());

				recursoLogicoRepository.update(recursoLogico.get());
			} else {
				throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(
						OssBusinessExceptionFactory.DEFAULT_ERROR_CODE, 
				        "Não foi encontrado um recurso para o Designador de " + 
				        		TipoRfs.fromRoiName(EntityExtractor.extractResourceOrderItemName(entity)).getType() + " " + 
				        		serviceId +
				        		" e Número Serial " + 
				        		serialNumber.get().getValue(), 
				        CpeWsName.ALLOCATE);
			}
		} else {
			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(
					OssBusinessExceptionFactory.DEFAULT_ERROR_CODE, 
			        "Não foi encontrado um dispositivo para o Designador de " + 
			        		TipoRfs.fromRoiName(EntityExtractor.extractResourceOrderItemName(entity)).getType() + " " +
			        		serviceId +
			        		" e Número Serial " + 
			        		serialNumber.get().getValue(), 
			        CpeWsName.ALLOCATE);
		}
	}
	

	private boolean isSelfProvisioning(ResourceInventoryEntity entity) {
		return !TipoRfs.ACCESS_PORT.getRoiName().equalsIgnoreCase(EntityExtractor.extractResourceOrderItemName(entity));
	}
	
	private boolean isProvide(String action) {
		return null == action 
				|| action.isEmpty() 
				|| RoiAction.PROVIDE.getAction().equalsIgnoreCase(action)
				|| RoiAction.ADD.getAction().equalsIgnoreCase(action);
	}
	
	private boolean isCease(String action) {
		return null != action 
				&& (RoiAction.CEASE.getAction().equalsIgnoreCase(action)
				|| RoiAction.DELETE.getAction().equalsIgnoreCase(action));
	}
}
