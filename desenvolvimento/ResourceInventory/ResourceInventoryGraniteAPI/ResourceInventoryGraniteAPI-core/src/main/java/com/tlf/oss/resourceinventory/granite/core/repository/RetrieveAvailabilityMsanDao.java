package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.UDA;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.granite.core.to.RetrieveAvailabilityTO;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;

@Logged
public class RetrieveAvailabilityMsanDao extends GenericDao implements Serializable {

	@Inject
	private OSSLogger logger;
	private static final long serialVersionUID = 1L;

	public RetrieveAvailabilityTO getCheckMSAM(String cnl, String at, String cabinetName) {

		logIn(cnl, at, cabinetName);

		RetrieveAvailabilityTO result = new RetrieveAvailabilityTO();

		try {
			Query q = getEntityManager().createNamedQuery("QueryCheckMSAN").setParameter(1, cnl).setParameter(2, at).setParameter(3, cabinetName);

			logIn(q);

			result.setEquipmentType((String) q.getSingleResult());
			result.getResult().setCode("0");

			logOutGetMsan(result);

		} catch (NoResultException e) {
			result.setEquipmentType("DSLAM");
			result.getResult().setCode("0");
			logOut(result);

		} catch (Exception e) {
			result.getResult().setCode("10");
			result.getResult().setDescription(e.getMessage());
		}
		return result;
	}

	private void logIn(String cnl, String at, String cabinetName) {
		StringBuilder stringBuilder = new StringBuilder().append("Param IN: [").append("CNL: ").append(cnl).append(";")
				.append("AT: ").append(at).append(";").append("ARMARIO: ").append(cabinetName).append("]");
		logger.log(OSSLogger.INFO, stringBuilder.toString());
	}

	private void logOutGetMsan(RetrieveAvailabilityTO result) {
		StringBuilder stringBuilder = new StringBuilder().append("Param OUT: [").append("CODE: ")
				.append(result.getResult().getCode()).append(";").append("TIPO: ").append(result.getEquipmentType())
				.append("]");

		logger.log(OSSLogger.INFO, stringBuilder.toString());
	}

	public List<RetrieveAvailabilityMsanEntity> getAvailabilityMSAN(Map<UDA, RetrieveUdaEntity> udas,
			com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress ra,
			com.tlf.oss.resourceinventory.schemas.Cabinet ca) throws OSSBusinessException {

		List<RetrieveAvailabilityMsanEntity> resultList = null;

		try {

			TypedQuery<RetrieveAvailabilityMsanEntity> query = getEntityManager()
					.createNamedQuery("QueryAvailabilityMSAN", RetrieveAvailabilityMsanEntity.class)
					.setParameter(1, udas.get(UDA.TIPO_PORTA).getUda_id())
					.setParameter(2, udas.get(UDA.VPN).getUda_id())
					.setParameter(3, udas.get(UDA.IP).getUda_id())
					.setParameter(4, udas.get(UDA.SIGLA_AT).getUda_id())
					.setParameter(5, udas.get(UDA.TIPO_REDE).getUda_id())
					.setParameter(6, udas.get(UDA.NOME_ENGENHARIA).getUda_id())
					.setParameter(7, udas.get(UDA.CNL).getUda_id())
					.setParameter(8, ca.getName())
					.setParameter(9, ra.getCnl())
					.setParameter(10, ra.getTelephonicArea())
					.setParameter(11, udas.get(UDA.PROTOCOLO).getUda_id())
					.setParameter(12, "SIP");

			logIn(udas, ca, ra);

			resultList = query.getResultList();
			
			logOut(resultList);

		} catch (Exception e) {

			logger.log(OSSLogger.ERROR, "erro no cast do ResultList:" + e.getMessage());

			throw new OSSBusinessException(Message.ERRO_RESOURCE_RETRIEVE_AVAILABILITY_MSANDAO.getValue(),
					Code.RIGRANITE_001.getValue(), e.getMessage());
		}
		return resultList;
	}

	private void logIn(Map<UDA, RetrieveUdaEntity> udas, Cabinet cabinet,BrazilianUrbanPropertyAddress resourceAddress) {
		StringBuilder builder = new StringBuilder("Param IN: [")
				.append("uda_tipo_porta = ").append(udas.get(UDA.TIPO_PORTA).getUda_id()).append(";")
				.append("uda_vpn = ").append(udas.get(UDA.VPN).getUda_id()).append(";")
				.append("uda_ip = ").append(udas.get(UDA.IP).getUda_id()).append(";")
				.append("uda_sigla_at = ").append(udas.get(UDA.SIGLA_AT).getUda_id()).append(";")
				.append("uda_tipo_rede = ").append(udas.get(UDA.TIPO_REDE).getUda_id()).append(";")
				.append("uda_cnl = ").append(udas.get(UDA.CNL).getUda_id()).append(";")
				.append("uda_nome_engenharia = ").append(udas.get(UDA.NOME_ENGENHARIA).getUda_id()).append(";")
				.append("cabinet = ").append(cabinet.getName()).append(";")
				.append("cnl = ").append(resourceAddress.getCnl()).append(";")
				.append("at = ").append(resourceAddress.getTelephonicArea()).append(";")
				.append("uda_protocolo").append(udas.get(UDA.PROTOCOLO).getUda_id()).append("]");
		logger.log(OSSLogger.INFO, builder.toString());
	}

	private void logOut(Collection<RetrieveAvailabilityMsanEntity> resultList) {
		StringBuilder log = new StringBuilder("Param OUT: ");
		if (resultList != null) {

			resultList.forEach(result -> log.append("[")
					.append("technology = ").append(result.getTechnology()).append(";")
					.append("free_ports = ").append(result.getQuantityPort()).append(";")
					.append("velocity_down = ").append(result.getSpeed())
					.append("]")
			);
		}
		logger.log(OSSLogger.INFO, log.toString());
	}

	private void logIn(Query query) {
		String log = getlogIn("SELECT am.tipo FROM aloc_minidslam am", query);
		logger.log(OSSLogger.INFO, log);
	}

	private void logOut(RetrieveAvailabilityTO result) {
		String log = new StringBuilder("Param OUT: [").append("free_ports = ").append(result.getFreePorts()).append(";")
				.append("velocity_down = ").append(result.getSpeed()).append("]").toString();

		logger.log(OSSLogger.INFO, log);
	}
}