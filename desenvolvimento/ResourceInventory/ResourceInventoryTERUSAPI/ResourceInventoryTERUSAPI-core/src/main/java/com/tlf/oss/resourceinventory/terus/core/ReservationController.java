package com.tlf.oss.resourceinventory.terus.core;

import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.terus.bloqueioportarequest.BloqueioPortaRequestType;
import com.tlf.oss.resourceinventory.generated.terus.bloqueioportaresponse.BloqueioPortaResponseType;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.terus.core.enums.Code;
import com.tlf.oss.resourceinventory.terus.core.enums.Message;
import com.tlf.oss.resourceinventory.terus.core.service.TerusService;
import com.tlf.oss.resourceinventory.terus.core.util.CalendarUtil;
import com.tlf.oss.resourceinventory.terus.core.validator.Reserve;

public class ReservationController  {

	@Inject
	private OSSLogger logger;

	@Inject
	private TerusService terusService;

	public void lock(@Reserve ResourceInventoryEntity entity) throws OSSBusinessException {

		if(isLockPort(entity)){
		
			try {
				BloqueioPortaRequestType request = createRequest(entity);
				BloqueioPortaResponseType response = terusService.bloqueioPorta(request);
				updateEntity(response);
			} catch (OSSBusinessException e) {
				throw new OSSBusinessException(e.getDescription(), e.getStatusCode(), e.getDetail());
			} catch (Exception e) {
				if (e instanceof TimeoutException) {
					throw new OSSBusinessException(Message.ERRO_BLOQUEIO_PORTA_VOZ_TERUS.getValue(), Code.RITERUS_002.getValue(), Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue());
				}
				throw new OSSBusinessException(Message.ERRO_BLOQUEIO_PORTA_VOZ_TERUS.getValue(), Code.RITERUS_002.getValue(), e.getMessage());
			}
		}

	}

	private boolean isLockPort(ResourceInventoryEntity entity) throws OSSBusinessException {
		
			boolean result = entity.getOperationService().getServiceDescribedBy().stream()
					.filter(p -> TerusService.UPDATEPOTS.equalsIgnoreCase(p.getName()))
					.map(p -> p.getServiceSpecCharDescribes())
					.filter(p -> "TRUE".equalsIgnoreCase(p.get(0).getValue()))
					.findFirst()
					.isPresent();

			logger.log(OSSLogger.INFO, "Propriedade " + TerusService.UPDATEPOTS + " encontrada. valor: "+entity.getOperationService().
					getServiceDescribedBy().
					get(0).getServiceSpecCharDescribes().
					get(0).getValue());
			
			return result;
			
	}

	private BloqueioPortaRequestType createRequest(ResourceInventoryEntity entity) {
		BloqueioPortaRequestType request = new BloqueioPortaRequestType();
		if (entity.getCabinet() != null) {
			request.setDATAHORA(CalendarUtil.getCurrentTime());
			request.setNOME(entity.getCabinet().getIdMsan());
			request.setLIC(entity.getCabinet().getLic());
		}
		
		return request;
	}
	
	private void updateEntity(BloqueioPortaResponseType createResponse) {
		if (createResponse != null) {
			logOut(createResponse);
		}
		
	}
	
	private void logOut(BloqueioPortaResponseType createResponse) {
		StringBuilder log = new StringBuilder("Param OUT: ");
		if (createResponse != null) {
					log.append("DATAHORA = ").append(createResponse.getDATAHORA() != null ? createResponse.getDATAHORA().toString() : null)
					.append("CODMSG = ").append(createResponse.getCODMSG()).append("DSCMSG = ").append(createResponse.getDSCMSG()).toString();
			logger.log(OSSLogger.INFO, log.toString()); 
		}
	}	
}