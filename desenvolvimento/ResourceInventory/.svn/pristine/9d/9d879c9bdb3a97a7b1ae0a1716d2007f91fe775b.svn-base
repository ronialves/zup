package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;

public class RetrieveFacilityDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;

	public List<RetrieveFacilityEntity> getfacility(RetrieveFacilityEntity entity) throws OSSBusinessException {
		List<RetrieveFacilityEntity> result = new ArrayList<>();
		try {

			TypedQuery<RetrieveFacilityEntity> query = getEntityManager()
					.createNamedQuery("QueryFacility", RetrieveFacilityEntity.class)
					.setParameter(1, entity.getTerminal());

			logIn("QueryFacility", null , entity.getTerminal());

			result = query.getResultList();

			if(result.isEmpty()){
				throw new OSSBusinessException(Message.ERRO_RESOURCE_NOT_FACILITY.getValue(),
						Code.RIGRANITE_003.getValue(), Message.ERRO_RESOURCE_NOT_FACILITY_BY_TERMINAL.getValue());
			}

			logOut(result);
		} catch (OSSBusinessException e) {
			throw new OSSBusinessException(e.getDescription(),
					e.getStatusCode(), e.getDetail());
		} catch (Exception e) {
			throw new OSSBusinessException(Message.ERRO_RESOURCE_NOT_FACILITY.getValue(),
					Code.RIGRANITE_001.getValue(), e.getMessage());
		}

		return result;
	}

	private void logIn(String logIn, Query query, String... param) {
		String log = getlogIn(logIn, query, param);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(List<RetrieveFacilityEntity> retrieveFacilityEntity) {
		for (RetrieveFacilityEntity result : retrieveFacilityEntity) {
			String log = new StringBuilder("Param OUT: ").append("HORIZONTALONE: ").append(result.getHorizontalOne()).append("HORIZONTALTWO: ")
					.append(result.getHorizontalTwo()).append("HOTNAME: ").append(result.getHostname()).append("IP_CONTROLE: ")
					.append(result.getIp_controller()).append("IP_EQUIPMANETO: ").append(result.getIp_equipamento())
					.append("MANUFACTURER: ").append(result.getManufacturer()).append("MASC_IP_MODEMWAN: ")
					.append(result.getMascipmodemwan()).append("MASC_MODEM_LAN: ").append(result.getMascmodemlan())
					.append("MODEL: ").append(result.getModel()).append("NAS_IP: ").append(result.getNasip())
					.append("NAS_PORT: ").append(result.getNasport()).append("NETWORKTYPE: ")
					.append(result.getNetworkType()).append("PINONE: ").append(result.getPinOne()).append("PINTWO: ")
					.append(result.getPinTwo()).append("PORT: ").append(result.getPort())
					.append("STATUS: ").append(result.getStatus()).append("PERFIL_ATIVACAO: ").append(result.getProfile_activation())
					.append("RACK: ").append(result.getRack()).append("SIGRES_NAME: ").append(result.getSigresName()).append("SLOT: ")
					.append(result.getSlot()).append("SUBRACK: ").append(result.getSubrack()).append("SUBSLOT: ").append(result.getSubslot())
					.append("TIPO: ").append(result.getType()).append("VERTICALONE: ").append(result.getVerticalOne()).append("VERTICALTWO: ")
					.append(result.getVerticalTwo()).append("VIRTUAL_CANAL: ").append(result.getVirtualChannel()).append("VIRTUAL_PORT: ")
					.append(result.getVirtualPort()).append("CLIENTE: ").append(result.getVlanCustomer()).append("VLAN_NETWORK: ")
					.append(result.getVlanNetwork()).append("VLAN_VOIP: ").append(result.getVlanVoip()).append("LIC: ")
					.append(result.getLic()).toString();
			logger.log(OSSLogger.INFO, log);
		}
	}
}