package com.tlf.oss.resourceinventory.cpe.core;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoRecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.enums.CpeWsName;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoRecurso;
import com.tlf.oss.resourceinventory.cpe.enums.FalloutCode;
import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.cpe.helper.UpdateHelper;
import com.tlf.oss.resourceinventory.cpe.repository.DispositivoFisicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoRecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.RecursoLogicoRepository;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Update;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UpdateStbController {

	@Inject
	private OSSLogger logger;

	@Inject
	private DispositivoFisicoRepository dispositivoFisicoRepository;

	@Inject
	private RecursoLogicoRepository recursoLogicoRepository;

	@Inject
	private UpdateHelper helper;
	
	@Inject
	private EstadoRecursoLogicoRepository estadoRecursoLogicoRepository;

	@Transactional(rollbackOn = OSSBusinessException.class)
	public ResourceInventoryEntity update(@Update ResourceInventoryEntity entity) throws OSSBusinessException {

		try {

			logger.log(OSSLogger.INFO, "Iniciando o update de R_CPE_STB...");
			
			String roiAction = EntityExtractor.extractResourceOrderItemAction(entity);
			
			if (isProvide(roiAction)) {
				provideAndAdd(entity);
			} else if (isCease(roiAction)) {
				cease(entity);
			} else {
				throw new OSSBusinessException(FalloutCode.RICPE_003.getDescription(), FalloutCode.RICPE_003.getValue(),
				        "Ação inválida no ResourceOrder " + roiAction);
			}

			logger.log(OSSLogger.INFO, "Finalizando o update no CPE...");

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
	
	private void cease(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Iniciando o update CEASE de R_CPE_STB ...");
		
		String serviceId = EntityExtractor.extractServiceId(entity);
		Optional<ServiceSpecCharDescribes> serialNumber = EntityExtractor.extractSerialNumber(entity);

		List<DispositivoFisico> dispositivos = dispositivoFisicoRepository.listByServiceId(serviceId);

		Optional<DispositivoFisico> dispositivoFisicoFound = dispositivos.stream()
		        .filter(dispositivo -> serialNumber.get().getValue().equals(dispositivo.getNumeroSerial())).findFirst();

		if (dispositivoFisicoFound.isPresent()) {

			DispositivoFisico dispositivoFisico = dispositivoFisicoFound.get();
			RecursoLogico recursoLogico = recursoLogicoRepository.findByDispositivoFisicoId(dispositivoFisico.getId());

			if (null != recursoLogico) {

				EstadoRecursoLogico estadoRecursoLogico = estadoRecursoLogicoRepository
				        .findByEstadoRecurso(EstadoRecurso.DESCONECTADO);
				recursoLogico.setEstadoRecursoLogicoId(estadoRecursoLogico.getId());

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
		
		logger.log(OSSLogger.INFO, "Finalizando o update no R_CPE_STB...");

	}
	
	private void provideAndAdd(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		logger.log(OSSLogger.INFO, "Action PROVIDE or ADD");
		
		String serviceId = EntityExtractor.extractServiceId(entity);
		String serialNumber = EntityExtractor.extractSerialNumber(entity).get().getValue();

		CatalogoDispositivo equipment = helper.getCatalogoDispositivo(entity);

		List<DispositivoFisico> dispositivos = dispositivoFisicoRepository.listByServiceId(serviceId);

		// Encontrando pelo número serial
		// Isto evita considerar como inexistente um cliente que existe
		Optional<DispositivoFisico> dispositivoFisicoFound = dispositivos.stream()
		        .filter(dispositivo -> dispositivo.getNumeroSerial() != null
		                && dispositivo.getNumeroSerial().equals(serialNumber))
		        .findFirst();

		// Selecionando o primeiro sem número serial
		if (!dispositivoFisicoFound.isPresent()) {
			dispositivoFisicoFound = dispositivos.stream()
			        .filter(dispositivo -> dispositivo.getCategoriaDispositivoEsperada()
			                .equals(equipment.getCategoriaDispositivoId())
			                && (dispositivo.getNumeroSerial() == null || dispositivo.getNumeroSerial().isEmpty()))
			        .findFirst();
		} 

		if (dispositivoFisicoFound.isPresent()) {
			String macAddress = EntityExtractor.extractMacAddress(entity).get().getValue();
			Optional<DispositivoFisico> macAddressResult = dispositivoFisicoRepository.findByMacaddress(macAddress);

			if (!macAddressResult.isPresent()) {
				Optional<DispositivoFisico> serialNumberResult = dispositivoFisicoRepository
				        .findBySerialNumber(serialNumber);

				if (!serialNumberResult.isPresent()) {
					DispositivoFisico dispositivoFisico = dispositivoFisicoFound.get();

					dispositivoFisico.setCategoriaDispositivoCorrente(equipment.getCategoriaDispositivoId());
					dispositivoFisico.setCatalagoDispositivoId(equipment.getId());
					dispositivoFisico.setMacAddress(macAddress);
					dispositivoFisico.setNumeroSerial(serialNumber);

					RecursoLogico recursoLogico = recursoLogicoRepository
					        .findByDispositivoFisicoId(dispositivoFisico.getId());
					recursoLogico.setCasn(EntityExtractor.extractCasn(entity).get().getValue());

					dispositivoFisicoRepository.update(dispositivoFisico);
					recursoLogicoRepository.update(recursoLogico);
				} else {
					String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
					String errorMessage = "Número Serial " + serialNumber + " já utilizado por outro cliente";

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
			String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
			String errorMessage = "Não foi encontrado um cliente com o Designador de TV " + serviceId;

			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(errorCode, errorMessage,
			        CpeWsName.UPDATE);
		}
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
