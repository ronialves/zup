package com.tlf.oss.resourceinventory.granite.core.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.UDA;
import com.tlf.oss.resourceinventory.granite.core.repository.factory.GenericDao;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;

@Logged
public class RetrieveAvailabilityDslamDao extends GenericDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OSSLogger logger;
	
	public Collection<RetrieveAvailabilityDslamEntity> getAvailabilityDSLAM(Map<UDA, RetrieveUdaEntity> udas, 
			BrazilianUrbanPropertyAddress resourceAddress) throws OSSBusinessException {

		Collection<RetrieveAvailabilityDslamEntity> resultList = null;

		try {
			TypedQuery<RetrieveAvailabilityDslamEntity> query = getEntityManager()
					.createNamedQuery("QueryAvailabilityDSLAM", RetrieveAvailabilityDslamEntity.class)
					.setParameter("uda_tipo_porta", udas.get(UDA.TIPO_PORTA).getUda_id())
					.setParameter("uda_cnl", udas.get(UDA.CNL).getUda_id())
					.setParameter("cnl", resourceAddress.getCnl())
					.setParameter("uda_sigla_at", udas.get(UDA.SIGLA_AT).getUda_id())
					.setParameter("sigla_at", resourceAddress.getTelephonicArea())
					.setParameter("uda_tipo_rede", udas.get(UDA.TIPO_REDE).getUda_id())
					.setParameter("uda_protocolo", udas.get(UDA.PROTOCOLO).getUda_id())
					.setParameter("protocolo", "SIP")
					.setParameter("uda_vpn", udas.get(UDA.VPN).getUda_id())
					.setParameter("uda_ip", udas.get(UDA.IP).getUda_id());
			
			logIn(udas, resourceAddress);
			
			resultList = query.getResultList();
			
			logOut(resultList);
			
		} catch (Exception e) {
			logger.log(OSSLogger.ERROR,"erro no cast do ResultList:" + e.getMessage());
			throw new OSSBusinessException(Message.ERRO_RESOURCE_RETRIEVE_AVAILABILITY_DSLAMDAO.getValue(), Code.RIGRANITE_001.getValue(), e.getMessage());
		}
		return resultList;
	}
	
	private void logIn(Map<UDA, RetrieveUdaEntity> udas, BrazilianUrbanPropertyAddress resourceAddress) {
		StringBuilder builder = new StringBuilder("Param IN: [")
		.append("uda_tipo_porta").append(" = ").append(udas.get(UDA.TIPO_PORTA).getUda_id()).append(";")
		.append("uda_cnl = ").append(udas.get(UDA.CNL).getUda_id()).append(";")
		.append("cnl = ").append(resourceAddress.getCnl()).append(";")
		.append("uda_sigla_at = ").append(udas.get(UDA.SIGLA_AT).getUda_id()).append(";")
		.append("at = ").append(resourceAddress.getTelephonicArea()).append(";")
		.append("uda_tipo_rede = ").append(udas.get(UDA.TIPO_REDE).getUda_id()).append(";")
		.append("uda_protocolo = ").append(udas.get(UDA.PROTOCOLO).getUda_id()).append(";")
		.append("protolocolo = ").append("SIP").append(";")
		.append("uda_vpn = ").append(udas.get(UDA.VPN).getUda_id()).append(";")
		.append("uda_ip = ").append(udas.get(UDA.IP).getUda_id())
		.append("]");
	
		logger.log(OSSLogger.INFO, builder.toString());
	}
	
	private void logOut(Collection<RetrieveAvailabilityDslamEntity> resultList) {
		StringBuilder log = new StringBuilder("Param OUT: ");
		
		if (resultList != null) {
			resultList.forEach(result -> 
				log
				.append("[")
				.append("technology = ").append(result.getTechnology()).append(";")
				.append("free_ports = ").append(result.getQuantityPort()).append(";")
				.append("velocity_down = ").append(result.getSpeed())
				.append("]")
			);
		}		
		logger.log(OSSLogger.INFO, log.toString());
	}	
}