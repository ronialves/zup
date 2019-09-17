package com.tlf.oss.resourceinventory.cpe.mapping;

import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CategoriaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.DispositivoFisico;
import com.tlf.oss.resourceinventory.cpe.entity.EstadoServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.entity.RecursoLogico;
import com.tlf.oss.resourceinventory.cpe.entity.ServicoAssinante;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.repository.CategoriaDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.EstadoServicoAssinanteRepository;
import com.tlf.oss.resourceinventory.cpe.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class EntityConverter {

	@Inject
	private OSSLogger logger;

	@Inject 
	private EstadoServicoAssinanteRepository estadoServicoAssinanteRepository;

	@Inject
	private CategoriaDispositivoRepository categoriaDispositivoRepository;

	@Inject
	private ExecutionRules rules;
	 
	public ServicoAssinante toServicoAssinante(final ResourceInventoryEntity entity, final EstadoServico estado) {

		logger.log(OSSLogger.INFO, "Convertendo ResourceInventoryEntity para ServicoAssinante...");

		final EstadoServicoAssinante estadoServico = estadoServicoAssinanteRepository.findByEstadoServico(estado);
		ServicoAssinante servicoAssinante = new ServicoAssinante();
		String serviceId = EntityExtractor.extractServiceId(entity);
		String accessId = EntityExtractor.extractAccessId(entity);
		String roiName = EntityExtractor.extractResourceOrderItemName(entity);

		logger.log(OSSLogger.INFO, "Criando registro ServicoAssinante com serviceId = " + serviceId + " e accessId = " + accessId);


		if (TipoRfs.VOIP.getRoiName().equalsIgnoreCase(entity.getResourceOrder().getResourceOrderItem().getName())) {

			// No cenario de alocacaoo de VOIP, eh necessario buscar o numero de telefone do cliente para salvar no Inventario
			Optional<ResourceFacingService> telephoneRfs = EntityExtractor.extractTelephoneRfs(entity);

			if (telephoneRfs.isPresent()) {
    			Optional<ServiceDescribedBy> serviceDescribedBy = telephoneRfs.get()
    																		  .getServiceDescribedBy()
    																		  .stream()
    																		  .filter(service -> CpeConstants.TELEPHONE_NUMBER.equalsIgnoreCase(service.getName()))
    																		  .findFirst();
    			if (serviceDescribedBy.isPresent()) {
    				String telephone = serviceDescribedBy.get()
                            							 .getServiceSpecCharDescribes()
                            							 .get(0)
                            							 .getValue();

    				logger.log(OSSLogger.INFO, "Numero de telefone do cliente: " + telephone);

    				servicoAssinante.setNumeroTelefone(telephone);
    			}
			}
		}

		// Armazena o ID do servico no campo serviceId
		servicoAssinante.setServiceId(serviceId);

		// Armazena o designador de acesso no campo accessId
		servicoAssinante.setAccessId(accessId);

		servicoAssinante.setTipoRfs(roiName);
		servicoAssinante.setEstadoServicoAssinanteId(estadoServico.getId());

		return servicoAssinante;
	}
	
	public DispositivoFisico toDispositivoFisico(final ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Convertendo ResourceInventoryEntity para DispositivoFisico...");

		DispositivoFisico dispositivoFisico = new DispositivoFisico();

		final String categoria = rules.defineNomeCategoria(entity);
		CategoriaDispositivo categoriaDispositivo = categoriaDispositivoRepository.findByNomeCategoria(categoria);

		if (null != categoriaDispositivo) {
			dispositivoFisico.setCategoriaDispositivoEsperada(categoriaDispositivo.getId());
		}

		return dispositivoFisico;
	}

	public RecursoLogico toRecursoLogico(final DispositivoFisico dispositivoFisico, final ServicoAssinante servicoAssinante) {

		logger.log(OSSLogger.INFO, "Convertendo DispositivoFisico e ServicoAssinante para RecursoLogico...");

		RecursoLogico recursoLogico = new RecursoLogico();

		recursoLogico.setIdFxs(0);
		recursoLogico.setDispositivoFisicoId(dispositivoFisico.getId());
		recursoLogico.setServicoAssinanteId(servicoAssinante.getId());

		return recursoLogico;
	}
}

