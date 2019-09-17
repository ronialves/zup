package com.tlf.oss.resourceinventory.granite.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAvailabilityGponDao;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AvailabilityRetrieveGponController {

	@Inject
	private RetrieveAvailabilityGponDao retrieveAvailabilityGponDao;

	public ResourceInventoryEntity availabilityRetrieve(ResourceInventoryEntity entity) throws OSSBusinessException {

		RetrieveAvailabilityGponEntity retrieveAvailabilityGponEntity =	getRetrieveAvailabilityGponEntity(entity);
		
		retrieveAvailabilityGponEntity = retrieveAvailabilityGponDao.availabilityRetrieve(retrieveAvailabilityGponEntity);
		if (!Code.SUCCESS.getValue().equals(retrieveAvailabilityGponEntity.getCode()) && entity.getResourceInventoryWarn() == null) {
			throw new OSSBusinessException("Erro ao retornar o objeto RetrieveAvailabilityGpon", Code.RIGRANITE_001.getValue(),
					retrieveAvailabilityGponEntity.getCode() + " - " + retrieveAvailabilityGponEntity.getDescription());
		}

		return getRetrieveResourceEntity(retrieveAvailabilityGponEntity, entity);
	}

	private RetrieveAvailabilityGponEntity getRetrieveAvailabilityGponEntity(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		RetrieveAvailabilityGponEntity availabilityEntity = new RetrieveAvailabilityGponEntity();

		availabilityEntity.setCnl(entity.getAddress().getCnl());
		availabilityEntity.setAt(entity.getAddress().getTelephonicArea());

		if(entity.getResourceFacingService() != null && entity.getResourceFacingService().getServiceId() != null){
			availabilityEntity.setTerminal(entity.getResourceFacingService().getServiceId());
			availabilityEntity.setPrimaryCable("");
			availabilityEntity.setPrimaryFiber("");
			return availabilityEntity;
		}
		availabilityEntity.setPrimaryCable(entity.getCabinet().getPrimaryCable());
		availabilityEntity.setPrimaryFiber(entity.getCabinet().getPrimaryFiber());

		return availabilityEntity;
	}

	private ResourceInventoryEntity getRetrieveResourceEntity(RetrieveAvailabilityGponEntity availabilityEntity,
			ResourceInventoryEntity entity) throws OSSBusinessException {

		Cabinet cabinet = new Cabinet();

		if(entity.getCabinet() != null){
			cabinet = entity.getCabinet();
		}

		PortAdapterCard portAdapterCard = new PortAdapterCard();
		portAdapterCard.setMaxBroadbandSpeed(availabilityEntity.getMaxBroadbandSpeed());
		portAdapterCard.setTechnology("GPON");
		portAdapterCard.setFreePorts(availabilityEntity.getFreePorts());
		List<PortAdapterCard> hasCards = new ArrayList<PortAdapterCard>();
		hasCards.add(portAdapterCard);

		Shelf shelf = new Shelf();
		shelf.setHasCards(hasCards);
		List<Shelf> hasShelves = new ArrayList<Shelf>();
		hasShelves.add(shelf);
		cabinet.setHasShelves(hasShelves);
		entity.setCabinet(cabinet);

		return entity;
	}
}