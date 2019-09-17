package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityGponEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.granite.core.utils.Constants;

public class RetrieveFacilityGponDao extends GenericDao implements Serializable {

private static final long serialVersionUID = 1L;
private static final String RIGRANITE_003 = "RIGRANITE-003";
	
	@Inject
	private OSSLogger logger;	
	
	public RetrieveFacilityGponEntity facilityRetrieval(RetrieveFacilityGponEntity entity) throws OSSBusinessException {
		RetrieveFacilityGponEntity result = new RetrieveFacilityGponEntity();
		try {
			
			TypedQuery<RetrieveFacilityGponEntity> q = getEntityManager().createNamedQuery("QueryGponFacility", RetrieveFacilityGponEntity.class)
					.setParameter(1, entity.getTerminalNumber());

			logIn("TERMINAL", entity.getTerminalNumber());

			result = q.getSingleResult();
			
			if(null != result) logOut(result);
		} catch (NoResultException e) {
			//Será tratado na classe que chamou o servico. NÃO APAGAR
			return null;	
		} catch (PersistenceException e) {
			result.setResult(new ResultTo());
			result.getResult().setCode(Code.RIGRANITE_002.getValue());
			result.getResult().setDescription(Code.RIGRANITE_002.getDescription());
			logger.log(OSSLogger.ERROR, "Error:" + e.getMessage());
			throw new OSSBusinessException(Code.RIGRANITE_002.getDescription(), Code.RIGRANITE_002.getValue(), String.format(Code.RIGRANITE_002.getMessage(), "Erro de conexão", e.getMessage()));		
		} catch (Exception e) {
			result.setResult(new ResultTo());
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
	
	private void logOut(RetrieveFacilityGponEntity result) {
		String log = new StringBuilder("Param OUT: ").append("TECNOLOGY: ").append(result.getTecnology())
				.append("TERMINAL_NUMBER: ").append(result.getTerminalNumber())
				.append("AGGREGATOR_EQUIPMENT_NAME: ").append(result.getAggregatorEquipmentName())
				.append("AGGREGATOR_EQUIPMENT_MODEL: ").append(result.getAggregatorEquipmentModel())
				.append("CABLE: ").append(result.getPrimaryCable())
				.append("FIBER: ").append(result.getPrimaryFiber())
				.append("ACCESS_EQUIPMENT_NAME: ").append(result.getAccessEquipmentName())
				.append("ACCESS_EQUIPMENT_PORT: ").append(result.getAccessEquipmentPort())
				.append("ACCESS_EQUIPMENT_SLOT: ").append(result.getAccessEquipmentSlot())
				.append("LOGICAL_PORT: ").append(result.getLogical_port())
				.append("ACCESS_EQUIPMENT_VENDOR: ").append(result.getAccess_equipment_vendor())
				.append("ACCESS_EQUIPMENT_MODEL: ").append(result.getAccess_equipment_model())
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