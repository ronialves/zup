package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ChangeSpeedEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.ResourceStatusEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMaxSpeedResourceEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveMsanPotsEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrievePathEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.Operation;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.enums.TypeAvailability;
import com.tlf.oss.resourceinventory.granite.core.repository.ChangeSpeedDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ReserveResourceDao;
import com.tlf.oss.resourceinventory.granite.core.repository.ResourceStatusDao;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveMsanPotsDao;
import com.tlf.oss.resourceinventory.granite.core.service.PathService;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ReservationResourceMetallicController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	@Inject
	public ReserveResourceDao rdao;

	@Inject
	private RetrieveMsanPotsDao retrieveMsanPotsDao;
	
	@Inject
	private PathService pathService;

	@Inject
	private ResourceStatusDao resourceStatusDao;
	
	@Inject
	public ChangeSpeedDao changeSpeedDao;


	/**
	 * Chama proc que realiza a reserva
	 */
	public ReserveResourceEntity reserveResource(ResourceInventoryEntity entity) throws OSSBusinessException {
		return rdao.reserveResource(getReserveResourceEntity(entity));
	}

	private void updatePotsMsan(final ResourceInventoryEntity entity, final ReserveResourceEntity reserveResource,
			RetrieveMsanPotsEntity retrieveMsanPotsFreeEntity) throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "Iniciando o processo de busca e atualização na tabela conexoes_pots_msan");

		final Cabinet cabinet = entity.getCabinet() != null ? entity.getCabinet() : new Cabinet();
		cabinet.setLic(retrieveMsanPotsFreeEntity.getLic());
		cabinet.setIdMsan(retrieveMsanPotsFreeEntity.getIdMsan());

		reserveResource.setCabinet(cabinet);
		reserveResource.setOperationService(getOperationService(retrieveMsanPotsFreeEntity));
	}

	@Transactional(rollbackOn=Exception.class)
	public ReserveResourceEntity validateReserve(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		validateRequest(entity);
		
		// Faz a reserva
		ReserveResourceEntity reserveResourceEntity = reserveResource(entity);

		// Busca recurso do MSAN para enviar ao terus
		RetrieveMsanPotsEntity retrieveMsanPotsEntity = getResourceMsan(entity);

		// atualiza os valores da entidade unica necessarios para o bloqueio no terus		
		updatePotsMsan(entity, reserveResourceEntity, retrieveMsanPotsEntity);

		return reserveResourceEntity;
	}
	
	public ReserveResourceEntity reserveOfferEdition(ResourceInventoryEntity entity) throws OSSBusinessException {
		
		ReserveResourceEntity reserveResourceEntity = null;

		String newSpeed = getDownloadSpeed(entity);

		RetrievePathEntity path = pathService.getPath(entity, StatusPathType.ACTIVE);
		logger.log(OSSLogger.INFO, "Path retrieved: " + path);

		if (null == path) {
			return validateReserve(entity);
		}

		RetrievePathEntity equipamentType = checkEquipment(entity);

		if (TypeAvailability.MSAN.getTypes().equalsIgnoreCase(equipamentType.getType())) {
			// Edição de reserva
			reserveResourceEntity = UpdateOfferEdition(path, newSpeed);

		} 
		else if (TypeAvailability.DSLAM.getTypes().equalsIgnoreCase(equipamentType.getType())) {

			if (Operation.OFFER_EDITION.equals(checkSpeed(entity, newSpeed))) {
				// Edição de reserva
				reserveResourceEntity = UpdateOfferEdition(path, newSpeed);
			} else {
				// faz uma nova reserva DSLAM
				reserveResourceEntity = reserveResource(entity);
			}
		}
		return reserveResourceEntity;
	}
	
	/**
	 * Metodo responsavel por retornar a velocidade maxima que o path suporta
	 * @param entity
	 * @param newSpeed
	 * @return
	 * @throws OSSBusinessException
	 */
	private Operation checkSpeed(ResourceInventoryEntity entity, String newSpeed) throws OSSBusinessException {
		String terminal = getNetworkOwnerID(entity);
		// Retrieve responsavel por retornar a velocidade maxima que o path suporta
		RetrieveMaxSpeedResourceEntity recoverSpeedMax = rdao.speedMax(terminal);

		long speedMax = (recoverSpeedMax != null && recoverSpeedMax.getSpeed() != null
				&& !"".equals(recoverSpeedMax.getSpeed()) ? Long.parseLong(recoverSpeedMax.getSpeed()) : 0);
		if (speedMax <= 0) {
			throw new OSSBusinessException(Message.ERRO_RESOURCE_MAXSPEEDRESOURCEENTITY.getValue(),
					Code.RIGRANITE_001.getValue(), Message.ERRO_RESOURCE_NOT_MAXSPEED.getValue());
		}
		if (speedMax >= (newSpeed == null || "".equals(newSpeed)? 0 : Long.parseLong(newSpeed)) ) {
			return Operation.OFFER_EDITION;
		}
		return Operation.SALE_OFFER;
	}

	
	private void updateStatusOf(RetrievePathEntity path, StatusPathType statusPathType) throws OSSBusinessException {
		ResourceStatusEntity resourceStatusEntity = new ResourceStatusEntity(path.getCircPathInstId(),
				statusPathType.getValue());
		logger.log(OSSLogger.INFO, "executing updateStatus: " + resourceStatusEntity);

		resourceStatusDao.updateStatus(resourceStatusEntity);

	}

	private ReserveResourceEntity UpdateOfferEdition(RetrievePathEntity path, String newSpeed) throws OSSBusinessException{
		ReserveResourceEntity reserveResourceEntity = new ReserveResourceEntity();

		// atualiza a velocidade para a velocidade nova
		ChangeSpeedEntity changeSpeedEntity = changeSpeedOf(path, newSpeed);

		// altera o status de ATIVO para EM CONFIGURAÇÃO
		updateStatusOf(path, StatusPathType.IN_CONFIGURATION);

		reserveResourceEntity.setCode(changeSpeedEntity.getCode());
		reserveResourceEntity.setDescription(changeSpeedEntity.getDescription());

		return reserveResourceEntity;
	}

	private ChangeSpeedEntity changeSpeedOf(RetrievePathEntity path, String newSpeed) throws OSSBusinessException {
		ChangeSpeedEntity changeSpeedEntity = changeSpeedDao.changeSpeed(path.getCircPathInstId(), newSpeed, "KB");
		logger.log(OSSLogger.INFO, "Path speed changed: " + path.getCircPathInstId());

		return changeSpeedEntity;
	}

	// Verifica equipamento (Msan/Dslam) ativos
	protected RetrievePathEntity checkEquipment(ResourceInventoryEntity entity) throws OSSBusinessException {
		RetrievePathEntity equipamentType = pathService.getEquipTypeActive(entity);
		return equipamentType;
	}


	private ReserveResourceEntity getReserveResourceEntity(ResourceInventoryEntity entity) throws OSSBusinessException {
		ReserveResourceEntity reserveEntity = new ReserveResourceEntity();
		reserveEntity.setCnl(entity.getAddress().getCnl());
		reserveEntity.setTelephonicArea(entity.getAddress().getTelephonicArea());
		reserveEntity.setLocker(entity.getCabinet() != null ? entity.getCabinet().getName() : "");
		reserveEntity.setTerminal(getNetworkOwnerID(entity));
		reserveEntity.setSpeed(getDownloadSpeed(entity));
		reserveEntity.setUnit("");
		reserveEntity
		.setProtocol(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		return reserveEntity;
	}

	private String getDownloadSpeed(ResourceInventoryEntity entity) throws OSSBusinessException {
		CustomerFacingService customerFacingService = getCustomerFacingService(entity, "BROADBAND", "Downstream");
		return customerFacingService.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	private RetrieveMsanPotsEntity getResourceMsan(ResourceInventoryEntity entity) throws OSSBusinessException {
		final RetrieveMsanPotsEntity retrieveMsanPotsEntity = retrieveMsanPotsDao.getMsanPots(getNetworkOwnerID(entity));
		return retrieveMsanPotsEntity;
	}

	private void validateRequest(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<BrazilianUrbanPropertyAddress> address = Optional.ofNullable(entity.getAddress());

		if (!address.map(BrazilianUrbanPropertyAddress::getPlacePhysicalResourceAssoc)
				.map(PlacePhysicalResourceAssoc::getPhysicalLink).map(PhysicalLink::getVoiceProtocol)
				.filter(d -> !d.isEmpty()).isPresent())
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), Code.RIGRANITE_001.getValue(),
					"O valor do campo address.placePhysical.physicalLink.voiceProtocol eh nulo");

	}
}