package com.tlf.oss.resourceinventory.sagre.core;

import java.io.Serializable;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.sagre.core.validation.Reserve;
import com.tlf.oss.resourceinventory.sagre.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.sagre.entity.ReserveEntity;
import com.tlf.oss.resourceinventory.sagre.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.sagre.repository.ReserveRepository;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class ReserveController extends ValidatorEntity implements Serializable{
	
	/**
	 * BEATRIXTWO-22 | DEMOSS-2155
	 * 
	 * @project Beatrix Fase 2
	 * @author renan.n.Oliveira
	 * @since 201709
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	public ReserveRepository reserveRepository;
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RISAGRE_003.getCode(),
			String.format(ExceptionInfoEnum.RISAGRE_003.getDescription(), "GVT_SP_SOA_CRIA_RS_CTRL"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	private static final int RESULTADO_ESPERADO = 0;
	
	public static final String P_IN_TIPO_RESERVA = "VT-GPON";
	public static final String P_IN_ORIGEM = "RI";
	public static final String P_IN_TIPO_DOCUMENTO = "PSR";
	public static final String P_IN_CLASSE_SERVICO = "LIRA";
	

	public ResourceInventoryEntity getReserve(@Reserve ResourceInventoryEntity entity)
			throws OSSBusinessException {
		ReserveEntity reserve = new ReserveEntity();
		reserve.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		reserve.setTecVoz(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		reserve.setTecAcesso(entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		reserve.setIdAcesso(entity.getResourceFacingService().getServiceId());
		reserve.setStreetCode(entity.getAddress().getStreetCode());
		reserve.setInLote(entity.getAddress().getStreetNrFirst());
		reserve.setIdentEquip1(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getId());
		reserve.setIdentEquip2(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getTerminalBox().getName());
		reserve.setInSos(null);
		reserve.setIdentEquip3(null);
		reserve.setInOrigem(P_IN_ORIGEM);
		reserve.setTipoReserva(P_IN_TIPO_RESERVA);
		reserve.setTipoDocumento(P_IN_TIPO_DOCUMENTO);
		reserve.setClasseServico(P_IN_CLASSE_SERVICO);
		
		return getResourceInventoryEntity(reserveRepository.getReserve(reserve), entity);

	}
	
	public ResourceInventoryEntity getResourceInventoryEntity(ReserveEntity reserve, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (RESULTADO_ESPERADO != reserve.getCod()) {
			String errorCode = String.valueOf(reserve.getCod());
			String errorMessage = reserve.getMsg();
			String detailMessage = errorCode + "; " + errorMessage;

		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}

		return entity;

	}
}