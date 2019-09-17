package com.tlf.oss.resourceinventory.granite.core;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.UDA;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAvailabilityDslamDao;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AvailabilityRetrieveDslamController {

	@Inject
	private RetrieveAvailabilityDslamDao availabilityDslamDao;
	
	/**
	 * Metodo responsavel em fazer a consulta disponibilidade
	 * @throws OSSBusinessException 
	 * 
	 */
	public Collection<RetrieveAvailabilityDslamEntity> getAvailabilityDSLAM(List<RetrieveUdaEntity> listUDA, ResourceInventoryEntity entity) throws OSSBusinessException {
		
		EnumMap<UDA, RetrieveUdaEntity> udas = getUdas(listUDA);
		
		Collection<RetrieveAvailabilityDslamEntity> availabilityResultCollection = availabilityDslamDao.getAvailabilityDSLAM(udas, entity.getAddress());
		
		return availabilityResultCollection;
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
		return udas;
	}

	private RetrieveUdaEntity getUda(List<RetrieveUdaEntity> listUDA, UDA uda) throws OSSBusinessException {
		Optional<RetrieveUdaEntity> udaEntity = listUDA.stream().filter(p -> uda.getValue().equals(p.getUda_nome())).findFirst();
		if (!udaEntity.isPresent()) {
			throw new OSSBusinessException(Message.ERRO_RESOURCE_ENTITY.getValue(), 
					Code.RIGRANITE_001.getValue(),
					"Erro ao recuperar as informacoes de configuracao da UDA: " + uda.getValue());
		}
		return udaEntity.get();
	}

}
