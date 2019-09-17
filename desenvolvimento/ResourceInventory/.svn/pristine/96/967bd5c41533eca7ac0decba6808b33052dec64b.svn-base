package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.PortDetailEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.SlotDetailEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.SubSlotDetailEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.schemas.Equipment;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class EquipmentDetailDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String GRANITE = "GRANITE";
	private static final String SLOT = "SLOT";
	private static final String SUBSLOT = "SUBSLOT";
	private static final String IN_HOSTNAME = "p_in_hostname";
	private static final String IN_TYPE = "p_in_type";
	private static final String IN_ID = "p_in_id";
	private static final String IN_SLOT_ID = "p_in_slot_id";
	
	@Inject
	private OSSLogger logger;

	/**
	 * Método de start do fluxo de retrieve.
	 * 
	 * @param entity
	 * @return
	 */
	public ResourceInventoryEntity getEquipmentDetail(ResourceInventoryEntity entity) {
		return execute(entity);
	}
	
	/**
	 * Método que realiza a execução da Procedure PRC_RETRIEVE_SLOTS_DETAIL.
	 * 
	 * @param hostname
	 * @return
	 */
	private List<SlotDetailEntity> getSlotsDetail(String hostname) {
		logger.log(OSSLogger.INFO, "EquipmentDetailDao - getSlotsDetail - Iniciando chamada a Procedure PKG_RESERVE.PRC_RETRIEVE_SLOTS_DETAIL do GRANITE.");
		
		if(hostname != null && !hostname.isEmpty()) {
			
			List<SlotDetailEntity> slotsDetail = new ArrayList<SlotDetailEntity>();
			
			TypedQuery<SlotDetailEntity> retrieveSlotsDetail = getEntityManager()
					.createNamedQuery(SlotDetailEntity.SLOT_DETAIL, SlotDetailEntity.class);
			
				retrieveSlotsDetail.setParameter(IN_HOSTNAME, hostname.toUpperCase());			
			
			slotsDetail = retrieveSlotsDetail.getResultList();
			
			return slotsDetail;
		} else {
			return null;
		}					
	}
	
	/**
	 * Método que realiza a execução da Procedure PRC_RETRIEVE_PORTS_DETAIL.
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	private List<PortDetailEntity> getPortsDetail(String type, String id) {
		logger.log(OSSLogger.INFO, "EquipmentDetailDao - getPortsDetail - Iniciando chamada a Procedure PKG_RESERVE.PRC_RETRIEVE_PORTS_DETAIL do GRANITE.");
		
		if(type != null && id != null) {
			
			List<PortDetailEntity> portsDetail = new ArrayList<>();
			
			TypedQuery<PortDetailEntity> retrievePortsDetail = getEntityManager()
					.createNamedQuery(PortDetailEntity.PORTS_DETAIL, PortDetailEntity.class);
			
				retrievePortsDetail.setParameter(IN_TYPE, type);
				retrievePortsDetail.setParameter(IN_ID, id);
			
			portsDetail = retrievePortsDetail.getResultList();
			
			return portsDetail;
		} else {
			return null;	
		}
	}
	
	/**
	 * Método que realiza a execução da Procedure PRC_RETRIEVE_SUBSLOT_DETAIL.
	 * @param slotId
	 * @return
	 */
	private List<SubSlotDetailEntity> getSubSlotsDetail(String slotId) {
		logger.log(OSSLogger.INFO, "EquipmentDetailDao - getSlotsDetail - Iniciando chamada a Procedure PKG_RESERVE.PRC_RETRIEVE_SUBSLOT_DETAIL do GRANITE.");
		
		if(slotId != null) {
			List<SubSlotDetailEntity> subSlotsDetail = new ArrayList<SubSlotDetailEntity>();
			
			TypedQuery<SubSlotDetailEntity> retrieveSubSlotsDetail = getEntityManager()
					.createNamedQuery(SubSlotDetailEntity.SUBSLOT_DETAIL, SubSlotDetailEntity.class);
			
				retrieveSubSlotsDetail.setParameter(IN_SLOT_ID, slotId);
			
			subSlotsDetail = retrieveSubSlotsDetail.getResultList();	
				
			return subSlotsDetail;
		} else {
			return null;
		}
	}
	
	/**
	 * Método que executa todo o fluxo de retrieve.
	 * 
	 * @param entity
	 * @return
	 */
	private ResourceInventoryEntity execute(ResourceInventoryEntity entity) {
			
		logger.log(OSSLogger.INFO, "EquipmentDetailDao - execute");
		List<SlotDetailEntity> slotsDetail = getSlotsDetail(getHostname(entity));
		
		if(slotsDetail != null && !slotsDetail.isEmpty()) {
			
			List<Equipment> equipments = new ArrayList<Equipment>();
				Equipment equipment = new Equipment();
			
				List<PortAdapterCard> hasCards = new ArrayList<PortAdapterCard>();
					
				for(SlotDetailEntity slot : slotsDetail) {
					
					PortAdapterCard cardSlot = new PortAdapterCard();
						cardSlot.setSlot(slot.getSlot());
						cardSlot.setSlotId(slot.getCardInstId());
						cardSlot.setOrigin(GRANITE);
						cardSlot.setName(slot.getName());
						
						List<PortDetailEntity> ports = getPortsDetail(SLOT, slot.getCardInstId());
						cardSlot.setContainsPorts(portsMapper(ports));
						
					hasCards.add(cardSlot);
					
					hasCards = executeSubSlot(hasCards, slot.getSlot(), slot.getCardInstId());
				}
				
				equipment.setHasCards(hasCards);				
				equipments.add(equipment);
				
			entity.setEquipment(equipments);			
			
			return entity;
		} else {
			return entity;
		}		
	}	
	
	/**
	 * Método que executa o fluxo de SubSlot.
	 * 
	 * @param hasCards
	 * @param slot
	 * @param slotId
	 * @return
	 */
	private List<PortAdapterCard> executeSubSlot(List<PortAdapterCard> hasCards, String slot, String slotId) {
		
		if(hasCards != null && !hasCards.isEmpty()) {
			
			List<SubSlotDetailEntity> subSlotsDetail = getSubSlotsDetail(slotId);
			
			if(subSlotsDetail != null && !subSlotsDetail.isEmpty()) {
				
				for(SubSlotDetailEntity subSlot : subSlotsDetail) {
					PortAdapterCard cardSubSlot = new PortAdapterCard();
						cardSubSlot.setSlot(slot);
						cardSubSlot.setSlotId(slotId);
						cardSubSlot.setSubSlot(subSlot.getSlot());
						cardSubSlot.setSubSlotId(subSlot.getCardInstId());
						cardSubSlot.setOrigin(GRANITE);
						cardSubSlot.setName(subSlot.getName());
					
						List<PortDetailEntity> ports = getPortsDetail(SUBSLOT, subSlot.getCardInstId());				
						cardSubSlot.setContainsPorts(portsMapper(ports));
						
					hasCards.add(cardSubSlot);
				}
				
				return hasCards;
			} else {
				return hasCards;
			}
		} else {
			return null;
		}				
	}
	
	/**
	 * Método que busca o Hostname do Equipamento.
	 * 
	 * @param entity
	 * @return
	 */
	private String getHostname(ResourceInventoryEntity entity) {
		
		if (entity.getResourceFacingService() != null
				&& entity.getResourceFacingService().getServiceDescribedBy() != null
				&& !entity.getResourceFacingService().getServiceDescribedBy().isEmpty()) {
			
			if (entity.getResourceFacingService().getServiceDescribedBy().get(0) != null
					&& entity.getResourceFacingService().getServiceDescribedBy().get(0)
							.getServiceSpecCharDescribes() != null
					&& !entity.getResourceFacingService().getServiceDescribedBy().get(0)
							.getServiceSpecCharDescribes().isEmpty()
					&& entity.getResourceFacingService().getServiceDescribedBy().get(0)
							.getServiceSpecCharDescribes().get(0) != null) {
				
				if(entity.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue() != null) {
					return entity.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
				} else {
					return null;
				}				
			} else {
				return null;
			}			
		} else {
			return null;
		}
	}
	
	/**
	 * Mapper das Portas dos Slots e SubSlots.
	 * 
	 * @param ports
	 * @return
	 */
	private List<PhysicalPort> portsMapper(List<PortDetailEntity> ports) {
		
		List<PhysicalPort> containsPorts = new ArrayList<PhysicalPort>();
		
		if(ports != null && !ports.isEmpty()) {			
			
			for(PortDetailEntity port : ports) {
				PhysicalPort cardPort = new PhysicalPort();
					cardPort.setId(port.getName());
					cardPort.setFiberId(port.getPortHumId());							
				containsPorts.add(cardPort);
			}
			
			return containsPorts;
		} else {
			return containsPorts;
		}		
	}
}