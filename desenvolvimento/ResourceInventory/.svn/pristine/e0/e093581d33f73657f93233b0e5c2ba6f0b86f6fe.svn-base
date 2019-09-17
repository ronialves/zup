package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.FacilityRetrieval;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.FacilityResourceRepository;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Splitter;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.enums.SplitterLevel;

/**
 * BEATRIXTWO-441 | DEMOSS-2279
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@SuppressWarnings("serial")
public class FacilityResourceController extends ValidatorEntity implements Serializable {

	@Inject
	FacilityResourceRepository facilityResourceRepository;

	@Inject
	OSSLogger logger;

	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(),
			String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_FAC_CTRL"), 
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);

	private static final int RESULTADO_ESPERADO = 0;

	// Parametros a serem utilizados na leitura do getNote
	private static final String ARMARIO = "Armario:";
	private static final String SPLITTER1N = "Splitter_1n:";
	private static final String FIBRA1N = "Fibra_1n:";
	private static final String CAIXA = "Caixa:";
	private static final String SPLITTER2N = "Splitter_2n:";
	private static final String FIBRA2N = "Fibra_2n:";
	private static final String STATUS = "Status:";
	private static final String CABO = "Cabo:";

	/**
	 * Retorna atraves do RetrieveFacilityEntity (preenchido com
	 * ResourceInventoryEntity), o ResourceInventoryEntity enriquecido
	 * 
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity retrieveFacility(@FacilityRetrieval ResourceInventoryEntity entity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "[FacilityResourceController] Tranformando ResourceInventoryEntity em RetrieveFacilityEntity");

		RetrieveFacilityEntity retrieveFacilityEntity = new RetrieveFacilityEntity();

		retrieveFacilityEntity.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		retrieveFacilityEntity.setAccessTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		retrieveFacilityEntity.setVoiceTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		retrieveFacilityEntity.setAccessId(entity.getResourceFacingService().getServiceId());
		
		logger.log(OSSLogger.INFO, "[FacilityResourceController] Realizando chamada do facilityResourceDAO.retrieveFacility");

		return getResourceInventoryEntity(facilityResourceRepository.retrieveFacility(retrieveFacilityEntity), entity);
	}

	/**
	 * Realiza enriquecimento do {@link ResourceInventoryEntity}
	 * 
	 * @param retrieveFacilityEntity
	 * @param entity
	 * @return {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceInventoryEntity(RetrieveFacilityEntity retrieveFacilityEntity,
			ResourceInventoryEntity entity) throws OSSBusinessException {
		
		if (RESULTADO_ESPERADO != retrieveFacilityEntity.getResultCode()) {

			String errorCode = String.valueOf(retrieveFacilityEntity.getResultCode());
			String errorMessage = retrieveFacilityEntity.getMessage();
			String detailMessage = errorCode + "; " + errorMessage;

		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}


		if (retrieveFacilityEntity.getNote() != null && !"".equals(retrieveFacilityEntity.getNote())) {
			Cabinet cabinet = new Cabinet();
			Splitter splitterFirstLevel = new Splitter();
			TerminalBox terminalBox = new TerminalBox();
			Splitter splitterSecondLevel = new Splitter();

			logger.log(OSSLogger.INFO, "[FacilityResourceController] O campo retrieveFacilityEntity.note esta preenchido: ".concat(retrieveFacilityEntity.getNote()));
			
			StringTokenizer token = new StringTokenizer(retrieveFacilityEntity.getNote(), " ");

			while (token.hasMoreTokens()) {

				String chave = token.nextToken();
				switch (chave) {
				case ARMARIO:
					cabinet.setName(token.nextToken());
					break;

				case SPLITTER1N:
					splitterFirstLevel.setId(token.nextToken());
					break;

				case FIBRA1N:
					splitterFirstLevel.setFiberId(token.nextToken());
					break;

				case CAIXA:
					terminalBox.setName(token.nextToken());
					break;

				case SPLITTER2N:
					splitterSecondLevel.setId(token.nextToken());
					break;

				case FIBRA2N:
					splitterSecondLevel.setFiberId(token.nextToken());
					break;

				case STATUS:
					splitterSecondLevel.setStatus(token.nextToken());
					break;

				case CABO:
					cabinet.setFeederCable(token.nextToken());
					break;

				default:
					break;
				}

			}

			splitterFirstLevel.setTypeOfResource(SplitterLevel.FIRST.getLevel());
			cabinet.getSplitter().add(splitterFirstLevel);
			
			splitterSecondLevel.setTypeOfResource(SplitterLevel.SECOND.getLevel());
			cabinet.getSplitter().add(splitterSecondLevel);
			cabinet.setTerminalBox(terminalBox);

			entity.setCabinet(cabinet);
			
			entity.setPhysicalResourceSummary(retrieveFacilityEntity.getNote());
			logger.log(OSSLogger.INFO, "[FacilityResourceController] Enriquecimento do ResourceInventoryEntity concluido");
			
		}else{
			logger.log(OSSLogger.INFO, "[FacilityResourceController] O campo retieveFacilityEntity.note retornou nulo ou vazio");
		}

		return entity;
	}
}
