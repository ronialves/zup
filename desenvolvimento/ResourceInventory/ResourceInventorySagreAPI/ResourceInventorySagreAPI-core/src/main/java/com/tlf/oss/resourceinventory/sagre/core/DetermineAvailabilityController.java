package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.DetermineAvailability;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.DetermineAvailabilityEntity;
import com.tlf.oss.resourceinventory.sagre.entity.DetermineDistanceEntity;
import com.tlf.oss.resourceinventory.sagre.entity.DetermineResourceAvailabilityMetallic;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.enums.WarnEnum;
import com.tlf.oss.resourceinventory.sagre.repository.DetermineAvailabilityRepository;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceInventoryWarn;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class DetermineAvailabilityController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public DetermineAvailabilityRepository determineAvailabilityRepository;
	
	@Inject
	protected OSSLogger logger;

	public static final String GPON = "GPON";
	public static final String METALICO = "METALICO";
	public static final String SIP = "SIP";
	public static final String VELOCIDADE_MAXIMA_GPON = "307200";
	public static final String VELOCIDADE_MAXIMA_METALLIC = "51200";
	private static final int SUCCESS = 0;
	private static final Integer IS_BLOCKED = 1;
	private OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(), "",
            Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);

	public ResourceInventoryEntity getDetermineAvailability(@DetermineAvailability ResourceInventoryEntity entity)
			throws OSSBusinessException {

		ResourceInventoryEntity result = new ResourceInventoryEntity();
		String accessTechnology = entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink()
				.getAccessTechnology();
		
		if (GPON.equals(accessTechnology)) {

			DetermineAvailabilityEntity determineAvailability = new DetermineAvailabilityEntity();

			determineAvailability.setCnl(Integer.parseInt(entity.getAddress().getCnl()));
			determineAvailability.setStreetCode(entity.getAddress().getStreetCode());
			determineAvailability.setStreetNumber(entity.getAddress().getStreetNrFirst());

			logger.log(OSSLogger.INFO, this.getClass().getName() + "Realizando consulta de cobertura - Access technology: " + GPON);

			result = getResourceInventoryEntity(
					determineAvailabilityRepository.getDetermineAvailability(determineAvailability), entity);
			
			logger.log(OSSLogger.INFO, this.getClass().getName() + "Realizada consulta de cobertura - Access technology: " + GPON);
		} else if (METALICO.equals(accessTechnology)) {

			DetermineResourceAvailabilityMetallic determineAvailabilityMetallic = new DetermineResourceAvailabilityMetallic();

			determineAvailabilityMetallic.setCnl(Integer.parseInt(entity.getAddress().getCnl()));
			determineAvailabilityMetallic.setStreetCode(entity.getAddress().getStreetCode());
			determineAvailabilityMetallic.setAddressNum(entity.getAddress().getStreetNrFirst());

			determineAvailabilityMetallic = determineAvailabilityRepository
					.getDetermineAvailabilityMetallic(determineAvailabilityMetallic);

			if (SUCCESS == determineAvailabilityMetallic.getReturnCode()) {
				 
                DetermineDistanceEntity determineDistanceEntity = new DetermineDistanceEntity(entity.getAddress());
 
                determineDistanceEntity.setCabinetId(determineAvailabilityMetallic.getIdentEquip1());
                determineDistanceEntity.setTerminalBoxId(determineAvailabilityMetallic.getIdentEquip2());
 
                determineDistanceEntity = determineAvailabilityRepository.getDistance(determineDistanceEntity);
 
                result = getResourceInventoryMetallic(determineAvailabilityMetallic, determineDistanceEntity, entity);
 
            }else {
                if (!isCoverageError(determineAvailabilityMetallic.getStatus(), determineAvailabilityMetallic.getFailDiag())) {
					falloutConfig.setErrorCode(String.valueOf(determineAvailabilityMetallic.getFailDiag() + "" + determineAvailabilityMetallic.getReturnCode()));
					falloutConfig.setErrorMessage(determineAvailabilityMetallic.getMessage());
					falloutConfig.setDetailMessage(determineAvailabilityMetallic.getFailDiag() + "; " + determineAvailabilityMetallic.getMessage());
					falloutConfig.setOriginAPIDescription(String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_CONSULTA_COBERTURA"));

					throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
                }else {
                    result = new ResourceInventoryEntity();
                    
                    ResourceInventoryWarn warn = new ResourceInventoryWarn();
                    warn.setCode(WarnEnum.SEM_COBERTURA.getcode());
                    result.setResourceInventoryWarn(warn);
                }
            }
		}

		return result;
	}

	public ResourceInventoryEntity getResourceInventoryEntity(DetermineAvailabilityEntity determineAvailability,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		if (SUCCESS == determineAvailability.getReturnCode()) {

			String quantityPort = "0";
			if (determineAvailability.getQuantityPort() != null) {
				quantityPort = determineAvailability.getQuantityPort().toString();

			}

			TerminalBox terminalBox = new TerminalBox();
			terminalBox.setName(determineAvailability.getIdentEquip2());
			terminalBox.setType(determineAvailability.getEquipmentType());
			terminalBox.setPairNumber(quantityPort);

			Cabinet cabinet = new Cabinet();
			cabinet.setTerminalBox(terminalBox);
			cabinet.setName(determineAvailability.getCabinetName());
			cabinet.setTypeOfTopology(determineAvailability.getTypeCoverage());
			cabinet.setId(determineAvailability.getIdentEquip1());

			SwitchesAssociated switchesAssociated = new SwitchesAssociated();
			switchesAssociated.setName(determineAvailability.getSwitchName());
			cabinet.setSwitchesAssociated(switchesAssociated);

			PortAdapterCard portAdapterCard = new PortAdapterCard();
			portAdapterCard.setTechnology(GPON);
			portAdapterCard.setFreePorts(quantityPort);
			portAdapterCard.setMaxBroadbandSpeed(VELOCIDADE_MAXIMA_GPON);

			List<Shelf> shelves = new ArrayList<Shelf>();
			shelves.add(new Shelf());
			cabinet.setHasShelves(shelves);
			cabinet.getHasShelves().get(0).getHasCards().add(portAdapterCard);

			PhysicalLink physicalLink = new PhysicalLink();
			if (getVoiceProtocolIsNotNull(entity)) {

				physicalLink.setVoiceProtocol(
						entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());

			} else {

				physicalLink.setVoiceProtocol(SIP);
			}


			if (determineAvailability.getTechnology() != null) {
                physicalLink.setAccessTechnology(determineAvailability.getTechnology() == 2 ? GPON : METALICO);        
            }
			
			List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
			physicalLinks.add(physicalLink);

			entity.setCabinet(cabinet);
			entity.setPhysicalLinks(physicalLinks);
			
		    entity.setResourceInventoryWarn(generateBlockageWarn(determineAvailability.getBlockageAddress(), determineAvailability.getBlockageEquipment()));

		} else {
			if (!isCoverageError(determineAvailability.getStatus(), determineAvailability.getFailDiag())) {
				falloutConfig.setErrorCode(String.valueOf(determineAvailability.getFailDiag() + "" + determineAvailability.getReturnCode()));
				falloutConfig.setErrorMessage(determineAvailability.getMessage());
				falloutConfig.setDetailMessage(determineAvailability.getFailDiag() + "; " + determineAvailability.getMessage());
				falloutConfig.setOriginAPIDescription(String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_CONS_COB_FIBRA"));
				throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
			} else {
				entity = new ResourceInventoryEntity();
			}
		}

		return entity;
	}

	public ResourceInventoryEntity getResourceInventoryMetallic(
			DetermineResourceAvailabilityMetallic determineAvailabilityMetallic,
			DetermineDistanceEntity determineDistance, ResourceInventoryEntity entity) throws OSSBusinessException {

		TerminalBox terminalBox = new TerminalBox();
		terminalBox.setName(determineAvailabilityMetallic.getIdentEquip2());
		terminalBox.setType(determineAvailabilityMetallic.getEquipmentType());
		terminalBox.setPairNumber(determineAvailabilityMetallic.getQtdPares() != null
				? determineAvailabilityMetallic.getQtdPares().toString()
				: "0");

		Cabinet cabinet = new Cabinet();
		cabinet.setId(determineAvailabilityMetallic.getIdentEquip1());
		cabinet.setTerminalBox(terminalBox);

		if (determineDistance.getDistance() != null) {

			cabinet.setDistance(determineDistance.getDistance().toString());
		}

		String cabinetName = determineAvailabilityMetallic.getArmarioOptico();

		if (cabinetName == null || cabinetName.isEmpty()) {
			cabinetName = determineAvailabilityMetallic.getArmarioMetalico();
		}
		cabinet.setName(cabinetName);

		SwitchesAssociated switchesAssociated = new SwitchesAssociated();
		switchesAssociated.setName(determineAvailabilityMetallic.getSwitchName());

		cabinet.setSwitchesAssociated(switchesAssociated);

		PhysicalLink physicalLink = new PhysicalLink();
		if (getVoiceProtocolIsNotNull(entity)) {
			physicalLink.setVoiceProtocol(
					entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());

		} else {

			physicalLink.setVoiceProtocol(SIP);
		}

		if (determineAvailabilityMetallic.getTechnology() != null) {
            physicalLink.setAccessTechnology(determineAvailabilityMetallic.getTechnology() == 2 ? GPON : METALICO);        
        }

		List<PhysicalLink> physicalLinks = new ArrayList<PhysicalLink>();
		physicalLinks.add(physicalLink);

		entity.setCabinet(cabinet);
		entity.setPhysicalLinks(physicalLinks);
	    entity.setResourceInventoryWarn(generateBlockageWarn(determineAvailabilityMetallic.getBlockageAddress(), determineAvailabilityMetallic.getBlockageEquipment()));

		
		return entity;
	}

	private boolean getVoiceProtocolIsNotNull(ResourceInventoryEntity entity) {

		if (entity.getAddress() != null) {
			if (entity.getAddress().getPlacePhysicalResourceAssoc() != null) {
				if (entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null) {
					if (entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink()
							.getVoiceProtocol() != null) {

						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isCoverageError(int status, int failDiag) {
		if (status == 2 && failDiag == 36) {
			return true;
		}
		return false;
	}
	
	
	public ResourceInventoryWarn generateBlockageWarn(Integer addressStatus, Integer equipmentStatus) {
		ResourceInventoryWarn warn = null;
		if (new Integer(IS_BLOCKED).equals(addressStatus)) {
			warn = new ResourceInventoryWarn();
			warn.setCode(WarnEnum.ENDERECO_BLOQUEADO.getcode());
			warn.setMessage(WarnEnum.ENDERECO_BLOQUEADO.getMessage());
		} else if (new Integer(IS_BLOCKED).equals(equipmentStatus)) {
			warn = new ResourceInventoryWarn();
			warn.setCode(WarnEnum.EQUIPAMENTO_BLOQUEADO.getcode());
			warn.setMessage(WarnEnum.EQUIPAMENTO_BLOQUEADO.getMessage());
		}
		return warn;
	}
}
