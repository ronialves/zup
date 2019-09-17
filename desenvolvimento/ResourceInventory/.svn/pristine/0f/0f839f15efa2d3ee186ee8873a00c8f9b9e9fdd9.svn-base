package com.tlf.oss.resourceinventory.granite.core;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.UDA;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAvailabilityMsanDao;
import com.tlf.oss.resourceinventory.granite.core.to.RetrieveAvailabilityTO;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;

public class AvailabilityRetrieveMsanController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	public RetrieveAvailabilityMsanDao rdao;

	public RetrieveAvailabilityTO getCheckMsan(String cnl, String at, String cabinetName) {

		RetrieveAvailabilityTO equipamentType = new RetrieveAvailabilityTO();
		equipamentType = rdao.getCheckMSAM(cnl,at,cabinetName);
		
		return equipamentType;
	}
	
	public List<RetrieveAvailabilityMsanEntity> getAvailabilityMsan(BrazilianUrbanPropertyAddress ra, Cabinet ca, List<RetrieveUdaEntity> loadConfig, String typeEquipament) throws OSSBusinessException {

		//percorre a lista e preenche meus atributos
		EnumMap<UDA, RetrieveUdaEntity> udas = getUdas(loadConfig);
		
		return rdao.getAvailabilityMSAN(udas,ra,ca);
	}
	
	private EnumMap<UDA, RetrieveUdaEntity> getUdas(List<RetrieveUdaEntity> listUDA) throws OSSBusinessException {
		EnumMap<UDA, RetrieveUdaEntity> udas = new EnumMap<>(UDA.class); 
		udas.put(UDA.VPN, getUda(listUDA, UDA.VPN));
		udas.put(UDA.IP, getUda(listUDA, UDA.IP));
		udas.put(UDA.TIPO_PORTA, getUda(listUDA, UDA.TIPO_PORTA));
		udas.put(UDA.TIPO_REDE, getUda(listUDA, UDA.TIPO_REDE));
		udas.put(UDA.PROTOCOLO, getUda(listUDA, UDA.PROTOCOLO));
		udas.put(UDA.CNL, getUda(listUDA, UDA.CNL));
		udas.put(UDA.SIGLA_AT, getUda(listUDA, UDA.SIGLA_AT));
		udas.put(UDA.NOME_ENGENHARIA, getUda(listUDA, UDA.NOME_ENGENHARIA));
		return udas;
	}
	
	private RetrieveUdaEntity getUda(List<RetrieveUdaEntity> listUDA, UDA uda) throws OSSBusinessException {
		Optional<RetrieveUdaEntity> udaEntity = listUDA.stream().filter(p -> uda.getValue().equals(p.getUda_nome())).findFirst();
		if (!udaEntity.isPresent()) {
			throw new OSSBusinessException("Erro ao retornar o objeto ResourceInventoryEntity", 
					Code.RIGRANITE_001.getValue(),
					"Erro ao recuperar as informacoes de configuracao da UDA: " + uda.getValue());
		}
		return udaEntity.get();
	}
}