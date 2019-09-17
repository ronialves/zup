package com.tlf.oss.resourceinventory.tbs.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.fallout.OSSExceptionFactory;
import com.tlf.oss.common.fallout.entity.OSSFalloutConfiguration;
import com.tlf.oss.resourceinventory.core.Constants;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.core.validation.Reserve;
import com.tlf.oss.resourceinventory.tbs.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.tbs.entity.ReserveEntity;
import com.tlf.oss.resourceinventory.tbs.enums.ExceptionInfoEnum;
import com.tlf.oss.resourceinventory.tbs.repository.ReserveRepository;

public class ReserveController extends ValidatorEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	public ReserveRepository reserveRepository;
	
	List<String> TDMVoiceProcolList = Arrays.asList("TDM", "H248", "TDM/H248");
	
	OSSFalloutConfiguration falloutConfig = new OSSFalloutConfiguration(ExceptionInfoEnum.RITBS_003.getCode(),
			String.format(ExceptionInfoEnum.RITBS_003.getDescription(), "GVT_SP_FTNET_RESERVA_S8"),
			Constants.FALLOUT_EXCEPTIONS_FILENAME, Constants.FALLOUT_DESCRIPTION_FILENAME);
	
	private static final int RESULTADO_ESPERADO = 0;

	public ResourceInventoryEntity getReserve(@Reserve ResourceInventoryEntity entity)
			throws OSSBusinessException {
		
		ReserveEntity reserve = new ReserveEntity();
		
		reserve.setArdOtico(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getName());
		reserve.setSwitchName(entity.getAddress().getPlacePhysicalResourceAssoc().getCabinet().getSwitchesAssociated().getName());
		
		String voiceProtocol = entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol();
		if(TDMVoiceProcolList.contains(voiceProtocol)) {
			voiceProtocol = "TDM/H248";
		}
		
		reserve.setTecVoz(voiceProtocol);
		
		for (CustomerFacingService cfs : entity.getCustomerFacingService()) {

			if ("BROADBAND".equalsIgnoreCase(cfs.getCategory())) {

				reserve.setDesignador(cfs.getServiceId());

				if(cfs.getServiceDescribedBy() != null){
					
					for (ServiceDescribedBy serviceDescribedBy : cfs.getServiceDescribedBy()) {
						
						if ("TECHNOLOGY".equalsIgnoreCase(serviceDescribedBy.getName())) {
							
							if (serviceDescribedBy.getServiceSpecCharDescribes() != null
									&& !serviceDescribedBy.getServiceSpecCharDescribes().isEmpty()) {
								
								reserve.setRateCode(serviceDescribedBy.getServiceSpecCharDescribes().get(0).getValue());
							}
						}
					}
				}
			}
		}
		
		
		
		return getResourceInventoryEntity(reserveRepository.getReserve(reserve), entity);
	}
	
	public ResourceInventoryEntity getResourceInventoryEntity(ReserveEntity reserve, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (RESULTADO_ESPERADO != reserve.getStatus()) {
			String errorCode = String.valueOf(reserve.getStatus());
			String errorMessage = reserve.getMessage();
			String detailMessage = errorCode + "; " + errorMessage;

		    falloutConfig.setErrorCode(errorCode);
		    falloutConfig.setErrorMessage(errorMessage);
			falloutConfig.setDetailMessage(detailMessage);
			throw OSSExceptionFactory.getOSSBusinessException(falloutConfig);
		}

		return entity;
	}
}