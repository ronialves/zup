package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.repository.EquipmentDetailDao;
import com.tlf.oss.resourceinventory.granite.core.repository.EquipmentRetrievalDao;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * Controller responsável por verificar o fluxo de Consultas aos Equipamentos e iniciar o processo de Retrieve. 
 */
@Logged
public class EquipmentRetrievalController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected OSSLogger logger;
	
	@Inject
	private EquipmentRetrievalDao equipRetrievaldao;
	
	@Inject
	private EquipmentDetailDao equipDetailDao;
	
	/**
	 * Start do fluxo de Consultas aos Equipamentos de Rede.
	 * @param entity
	 * @return
	 */
	public ResourceInventoryEntity retrieval(ResourceInventoryEntity entity) {
			
		String flow = identifyFlow(entity);
		
		if(Constants.EQUIPMENT_RETRIEVAL.equalsIgnoreCase(flow)) {
			logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Consulta: " + Constants.EQUIPMENT_RETRIEVAL);
			return getEquipmentByLocation(entity);
		} else if(Constants.EQUIPMENT_DETAIL.equalsIgnoreCase(flow)) {
			logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Consulta: " + Constants.EQUIPMENT_DETAIL);
			return getEquipmentDetail(entity);
		} else {
			return entity;
		}
	}
	
	/**
	 * Fluxo de Consulta dos Equipamentos de uma Localidade.
	 * @param entity
	 * @return
	 */
	private ResourceInventoryEntity getEquipmentByLocation(ResourceInventoryEntity entity) {
		logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Iniciando fluxo do EquipmentByLocation.");
		return equipRetrievaldao.getEquipmentByLocation(entity);
	}
	
	/**
	 * Fluxo de Consulta de Detalhe de Equipamentos.
	 * @param entity
	 * @return
	 */
	private ResourceInventoryEntity getEquipmentDetail(ResourceInventoryEntity entity) {
		logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Iniciando fluxo do EquipmentDetail.");
		return equipDetailDao.getEquipmentDetail(entity);
	}
	
	/**
	 * Verifica o fluxo de Consultas aos Equipamentos.
	 * @param entity
	 * @return
	 */
	private String identifyFlow(ResourceInventoryEntity entity) {
		
		logger.log(OSSLogger.INFO, "EquipmentRetrievalController - Identificando tipo de consulta.");
		
		if (entity.getResourceFacingService() != null
				&& entity.getResourceFacingService().getServiceDescribedBy() != null
				&& !entity.getResourceFacingService().getServiceDescribedBy().isEmpty()) {
									
			for (ServiceDescribedBy sdb : entity.getResourceFacingService().getServiceDescribedBy()) {
				if (Constants.NETWORK_OWNER_VIVO1.equalsIgnoreCase(sdb.getName())
						|| Constants.NETWORK_OWNER_VIVO2.equalsIgnoreCase(sdb.getName())) {
					return Constants.EQUIPMENT_RETRIEVAL;
				} 
			}
			
			for (ServiceDescribedBy sdb : entity.getResourceFacingService().getServiceDescribedBy()) {
				if (Constants.EQUIPMENT.equalsIgnoreCase(sdb.getName())) {
					return Constants.EQUIPMENT_DETAIL;
				} 
			}
		}
		
		return null;
	}
}