package com.tlf.oss.resourceinventory.cpe.helper;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoDispositivo;
import com.tlf.oss.resourceinventory.cpe.enums.CpeWsName;
import com.tlf.oss.resourceinventory.cpe.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.cpe.repository.CatalogoDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.repository.CategoriaDispositivoRepository;
import com.tlf.oss.resourceinventory.cpe.rules.ExecutionRules;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class UpdateHelper {

	@Inject
	private OSSLogger logger;

	@Inject
	private CategoriaDispositivoRepository categoriaDispositivoRepository;

	@Inject
	private CatalogoDispositivoRepository catalogoDispositivoRepository;

	@Inject
	private ExecutionRules rules;

	public CatalogoDispositivo getCatalogoDispositivo(ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Buscando equipamento de acordo com os dados do Request...");

		String defineNomeCategoria = rules.defineNomeCategoria(entity);
		String model = EntityExtractor.extractModel(entity).get().getValue();

		Integer categoriaDispositivoId = categoriaDispositivoRepository.findByNomeCategoria(defineNomeCategoria).getId();
		List<CatalogoDispositivo> catalogos = catalogoDispositivoRepository.findByCategoriaDispositivoIdAndModel(categoriaDispositivoId, model);

		Optional<CatalogoDispositivo> equipment = catalogos.stream().findFirst();

		if (!equipment.isPresent()) {
			String errorCode = OssBusinessExceptionFactory.DEFAULT_ERROR_CODE;
			String errorMessage = "Não foi possível definir um catalogo para o dispositivo.";

			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(errorCode,
                                                							 errorMessage,
                                                							 CpeWsName.UPDATE);
		}

		logger.log(OSSLogger.INFO, "Equipamento encontrado: " + equipment.get().getDescricao());

		return equipment.get();
	}

}
