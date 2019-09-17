package com.tlf.oss.resourceinventory.tbs.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.core.validation.DetermineAvailability;
import com.tlf.oss.resourceinventory.tbs.core.validation.DetermineAvailabilityValidator;
import com.tlf.oss.resourceinventory.tbs.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.tbs.entity.DetermineAvailabilityEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.DetermineAvailabilityRepository;

public class DetermineAvailabilityController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String MAX_BROADBAND_SPEED_ADSL = "25600";
	private static final String MAX_BROADBAND_SPEED_VDSL = "51200";
	private static final String ADSL_TECHNOLOGY = "ADSL";
	private static final String VDSL_TECHNOLOGY = "VDSL";
	private static final Integer SUCCESS = 0;
	
	@Inject
	private DetermineAvailabilityRepository determineAvailabilityRepository;
	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RITBS_003.getCode(),
			String.format(ExceptionInfoEnum.RITBS_003.getDescription(), "TLF_SP_DETERMINE_AVAILABILITY"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	List<String> TDMVoiceProcolList = Arrays.asList("TDM", "H248", "TDM/H248");
	
	public ResourceInventoryEntity getDetermine(@DetermineAvailability ResourceInventoryEntity entity) throws OSSBusinessException {
		
		
		DetermineAvailabilityEntity determineAvailabilityEntity = new DetermineAvailabilityEntity();
		if (!(DetermineAvailabilityValidator.checkCoverageWarn(entity))) {
			String voiceProtocol = entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol();
			voiceProtocol = voiceProtocol != null ? voiceProtocol.toUpperCase() : "";
			if (null != determineAvailabilityEntity) {
				determineAvailabilityEntity.setCabinet(entity.getCabinet().getName());
				determineAvailabilityEntity.setPSwitch(entity.getCabinet().getSwitchesAssociated().getName());
				
				if (entity.getAddress() != null) {
					if (entity.getAddress().getPlacePhysicalResourceAssoc() != null) {
						if (entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null) {
							if (entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink()
									.getVoiceProtocol() != null) {
								determineAvailabilityEntity.setVoiceProtocol(voiceProtocol);
							}
						}
					}
				}
			}
			
			List<DetermineAvailabilityEntity> resultList = determineAvailabilityRepository
					.determineAvailability(determineAvailabilityEntity);

			if ("SIP".equalsIgnoreCase(determineAvailabilityEntity.getVoiceProtocol())
					|| TDMVoiceProcolList.contains(determineAvailabilityEntity.getVoiceProtocol())) {
				for (DetermineAvailabilityEntity cobertura : resultList) {

					int errorCode = cobertura.getCodeReturn();
					String errorMessage = cobertura.getMessageReturn();
					if (SUCCESS != cobertura.getCodeReturn()) {
						falloutConfig.setErrorCode(String.valueOf(errorCode));
						falloutConfig.setErrorMessage(errorMessage);
						falloutConfig.setDetailMessage(errorCode + "; " + errorMessage);
						throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
					}

					SwitchesAssociated switchesAssociated = new SwitchesAssociated();
					switchesAssociated.setName(cobertura.getTlfSwitch());

					Shelf shelf = new Shelf();
					shelf.getHasCards().add(getCardAdsl(cobertura, voiceProtocol));
					shelf.getHasCards().add(getCardVdsl(cobertura, voiceProtocol));

					entity.getCabinet().setSwitchesAssociated(switchesAssociated);
					if (entity.getPhysicalLinks() != null && !entity.getPhysicalLinks().isEmpty()) {
						entity.getPhysicalLinks().get(0).setVoiceProtocol(entity.getAddress()
								.getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
					}
					entity.getCabinet().getHasShelves().add(shelf);

				}
			}
		}
		removeCoverageWarn(entity);
		return entity;
	}

	private PortAdapterCard getCardAdsl(DetermineAvailabilityEntity determineAvailabilityEntity, String voiceProtocol) {
		int freePorts = 0;
		if ("SIP".equalsIgnoreCase(voiceProtocol)) {
			freePorts = determineAvailabilityEntity.getAvailableCapacityADSLSIP();
		} else if (TDMVoiceProcolList.contains(voiceProtocol)) {
			freePorts = determineAvailabilityEntity.getAvailableCapacityADSL();
		}

		PortAdapterCard card = new PortAdapterCard();
		card.setTechnology(ADSL_TECHNOLOGY);
		card.setFreePorts(String.valueOf(freePorts));
		card.setMaxBroadbandSpeed(MAX_BROADBAND_SPEED_ADSL);

		return card;
	}

	private PortAdapterCard getCardVdsl(DetermineAvailabilityEntity determineAvailabilityEntity, String voiceProtocol) {
		int freePorts = 0;
		if ("SIP".equalsIgnoreCase(voiceProtocol)) {
			freePorts = determineAvailabilityEntity.getAvailableCapacityVDSLSIP();
		} else if (TDMVoiceProcolList.contains(voiceProtocol)) {
			freePorts = determineAvailabilityEntity.getAvailableCapacityVDSL();
		}

		PortAdapterCard card = new PortAdapterCard();
		card.setTechnology(VDSL_TECHNOLOGY);
		card.setFreePorts(String.valueOf(freePorts));
		card.setMaxBroadbandSpeed(MAX_BROADBAND_SPEED_VDSL);

		return card;
	}
	
	private ResourceInventoryEntity removeCoverageWarn(ResourceInventoryEntity entity) {
		if (entity.getResourceInventoryWarn() != null) {
			if ("RI-0100".equals(entity.getResourceInventoryWarn().getCode())) {
				entity.setResourceInventoryWarn(null);
			}
		}
		return entity;
	}

} 