package com.tlf.oss.resourceinventory.sophia.core.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.ReserveResourceGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.sophia.core.entity.RetrieveFacilityResourceGponEntity;

public class RetrieveFacilityResourceGponDao extends GenericDao implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private OSSLogger logger;

	public RetrieveFacilityResourceGponEntity facilityRetrieval(RetrieveFacilityResourceGponEntity entity) throws OSSBusinessException {
		RetrieveFacilityResourceGponEntity result = new RetrieveFacilityResourceGponEntity();
		try {
			
			TypedQuery<RetrieveFacilityResourceGponEntity> q = getEntityManager().createNamedQuery("QueryFacilityGpon", RetrieveFacilityResourceGponEntity.class)
					.setParameter(1, entity.getTerminalNumber());

			logIn("TERMINAL", entity.getTerminalNumber());

			result = q.getSingleResult();

			logOut(result);
			
			if(null == result){
				logger.log(OSSLogger.ERROR, "Erro ao consultar o objeto RetrieveFacilityGponEntity - Facilidades não encontradas");
				throw new OSSBusinessException("Erro ao consultar o objeto RetrieveFacilityGponEntity ", Code.RIGRANITE_001.getValue(), "- Facilidades não encontradas");
			}

		} catch (PersistenceException e) {
			result.getResult().setCode(Code.RIGRANITE_002.getValue());
			result.getResult().setDescription(Code.RIGRANITE_002.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro de conexão", e.getMessage()));		
		} catch (Exception e) {
			result.getResult().setCode(Code.RIGRANITE_999.getValue());
			result.getResult().setDescription(Code.RIGRANITE_999.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_999.getDescription(), Code.RIGRANITE_999.getValue(), Code.RIGRANITE_999.getMessage());
		}
		return result;
	}

	private void logIn(String temrinal,String param) {
		logger.log(OSSLogger.INFO, "Param IN: "+temrinal +": "+ param);
	}
	
	private void logOut(RetrieveFacilityResourceGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("TECNOLOGY: ").append(result.getTecnology())
				.append("TERMINAL_NUMBER: ").append(result.getTerminalNumber())
				.append("AGGREGATOR_EQUIPMENT_NAME: ").append(result.getAggregatorEquipmentName())
				.append("CABLE: ").append(result.getPrimaryCable())
				.append("FIBER: ").append(result.getPrimaryFiber())
				.append("ACCESS_EQUIPMENT_NAME: ").append(result.getAccessEquipmentName())
				.append("ACCESS_EQUIPMENT_PORT: ").append(result.getAccessEquipmentPort())
				.append("ACCESS_EQUIPMENT_SLOT: ").append(result.getAccessEquipmentSlot())
				.append("LOGICAL_PORT: ").append(result.getLogical_port())
				.append("ACCESS_EQUIPMENT_VENDOR: ").append(result.getAccess_equipment_vendor())
				.append("NASPORT: ").append(result.getNasport())
				.append("NASIP: ").append(result.getNasip())
				.append("NETWORK_VLAN: ").append(result.getNetwork_vlan())
				.append("ONT_ID: ").append(result.getOnt_id())
				.append("USER_VLAN: ").append(result.getUser_vlan())
				.append("FIXED_IP_FLAG: ").append(result.getFixed_ip_flag())
				.append("FIXED_IP_ADDRESS_V4: ").append(result.getFixed_ip_address_v4())
				.append("FIXED_IP_ADDRESS_V6: ").append(result.getFixed_ip_address_v6())
				.append("BHS_HGU_CONFIGURATION: ").append(result.getBhsHguConfiguration())
				.append("PATH_SPEEDY_STATUS: ").append(result.getPathSpeedyStatus())
				.append("PATH_TRANSPORTE_STATUS: ").append(result.getPathTransporteStatus())
				.append("VOIP_VLAN: ").append(result.getVlan_voip())
				.append("GPON_PASSWORD: ").append(result.getGpon_password())
				.append("SERVICE_DESCRIPTION: ").append(result.getService_description()).toString();
		logger.log(OSSLogger.INFO, log);
	}
}