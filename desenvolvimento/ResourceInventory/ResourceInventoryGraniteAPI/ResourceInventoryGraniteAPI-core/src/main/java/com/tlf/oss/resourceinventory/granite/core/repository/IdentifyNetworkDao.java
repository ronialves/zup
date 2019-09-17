package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.IdentifyNetworkEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class IdentifyNetworkDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final String NETWORK_OWNER_ID = "NetworkOwnerID";
	private static final String P_NETWORK_OWNER_ID = "p_networkownerid";
	private static final String NRC = "NRC";
	private static final String P_NRC = "p_nrc";
	private static final String P_DESIGNADOR = "p_designador";
	private static final String FUSION_TOPOLOGY = "Rede Fusionada";
	private static final String OTHER_TOPOLOGY = "Rede Não Fusionada";
	private static final String ERROR_NOT_IDENTIFIED = "Erro - Rede não Identificada";
	
	@Inject
	private OSSLogger logger;
	
	public ResourceInventoryEntity identifyNetwork(ResourceInventoryEntity entity) {
		logger.log(OSSLogger.INFO, "IdentifyNetworkDao - identifyNetwork - Iniciando chamada a Procedure PRC_IDENTIFY_NETWORK do GRANITE.");
		
		IdentifyNetworkEntity result = new IdentifyNetworkEntity();	
		String designador = null;
		
		TypedQuery<IdentifyNetworkEntity> query = getEntityManager().createNamedQuery(IdentifyNetworkEntity.IDENTIFY_NETWORK, IdentifyNetworkEntity.class);		
			query.setParameter(P_NETWORK_OWNER_ID, getParamValue(entity, NETWORK_OWNER_ID));
			query.setParameter(P_NRC, getParamValue(entity, NRC));			
				
			if(entity.getResourceFacingService().getServiceId() != null)
				designador = entity.getResourceFacingService().getServiceId(); 
				
			query.setParameter(P_DESIGNADOR, designador);	
		result =  query.getSingleResult();
		
		return identifyNetworkMapper(entity, result);
	}
	
	private String getParamValue(ResourceInventoryEntity entity, String paramName) {

		if (entity != null && entity.getResourceFacingService() != null
				&& !entity.getResourceFacingService().getServiceDescribedBy().isEmpty()) {
			
			for (ServiceDescribedBy sdb : entity.getResourceFacingService().getServiceDescribedBy()) {
				
				if (paramName.equalsIgnoreCase(sdb.getName()) && sdb.getServiceSpecCharDescribes() != null
						&& !sdb.getServiceSpecCharDescribes().isEmpty()) {
					
					for (ServiceSpecCharDescribes sscd : sdb.getServiceSpecCharDescribes()) {
						
						if (sscd.getValue() != null) {
							return sscd.getValue();
						}
					}
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param entity
	 * @param identify
	 * @return
	 */
	private ResourceInventoryEntity identifyNetworkMapper(ResourceInventoryEntity entity,
			IdentifyNetworkEntity identify) {

		if (identify != null && identify.getCodMessage() != null) {
   
			if ("0".equals(identify.getCodMessage())) {
				logger.log(OSSLogger.INFO, "IdentifyNetworkDao - identifyNetworkMapper - Topologia Fusionada.");
				entity.getAddress().setNetworkTopology(FUSION_TOPOLOGY);
			} else if ("1".equals(identify.getCodMessage())) {
				logger.log(OSSLogger.INFO, "IdentifyNetworkDao - identifyNetworkMapper - Topologia Não Fusionada.");
				entity.getAddress().setNetworkTopology(OTHER_TOPOLOGY);
			} else if ("-1".equals(identify.getCodMessage())) {
				logger.log(OSSLogger.INFO,
						"IdentifyNetworkDao - identifyNetworkMapper - A Procedure PRC_IDENTIFY_NETWORK do GRANITE não retornou dados para o cliente.");
				entity.getAddress().setNetworkTopology(ERROR_NOT_IDENTIFIED);
			}

			return entity;
		} else {
			logger.log(OSSLogger.INFO,
					"IdentifyNetworkDao - identifyNetworkMapper - A Procedure PRC_IDENTIFY_NETWORK do GRANITE não retornou dados para o cliente.");
			return entity;
		}
	}
}
