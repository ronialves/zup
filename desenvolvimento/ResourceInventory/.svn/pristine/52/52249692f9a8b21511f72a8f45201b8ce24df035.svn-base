package com.tlf.oss.resourceinventory.terus.core;

import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import org.jvnet.jaxb2_commons.lang.Validate;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.terus.desbloqueioportarequest.DesbloqueioPortaRequestType;
import com.tlf.oss.resourceinventory.generated.terus.desbloqueioportaresponse.DesbloqueioPortaResponseType;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.terus.core.enums.Code;
import com.tlf.oss.resourceinventory.terus.core.enums.Message;
import com.tlf.oss.resourceinventory.terus.core.service.TerusService;
import com.tlf.oss.resourceinventory.terus.core.util.CalendarUtil;
import com.tlf.oss.resourceinventory.terus.core.validator.Deallocate;

public class DeallocateController extends Validate {

	@Inject
	private OSSLogger logger;

	@Inject
	private TerusService terusService;

	public ResourceInventoryEntity unLock(@Deallocate ResourceInventoryEntity entity) throws OSSBusinessException {

		if(isUnLockPort(entity)){

			try {
				DesbloqueioPortaRequestType request = createRequest(entity);
				DesbloqueioPortaResponseType response = terusService.desbloqueioPorta(request);
				updateEntity(response);
			} catch (OSSBusinessException e) {

				logger.log(OSSLogger.ERROR, Message.ERRO_DESBLOQUEIO_PORTA_VOZ_TERUS.getValue() + ": " + e.getDescription() + ": " + e.getStatusCode() + ": " + e.getDetail()); 

			} catch (Exception e) {
				if (e instanceof TimeoutException) {
					logger.log(OSSLogger.ERROR, Message.ERRO_DESBLOQUEIO_PORTA_VOZ_TERUS.getValue() + ": " +  Code.RITERUS_002.getValue() + ": " + Message.BUSINESS_ERROR_TIMEOUT_MSG.getValue()); 
				}

				logger.log(OSSLogger.ERROR, Message.ERRO_DESBLOQUEIO_PORTA_VOZ_TERUS.getValue() + ": " +  Code.RITERUS_002.getValue() + ": " + e.getMessage()); 
			}
		}

		return entity;
	}
	private boolean isUnLockPort(ResourceInventoryEntity entity) throws OSSBusinessException {

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
	private DesbloqueioPortaRequestType createRequest(ResourceInventoryEntity entity) {
		DesbloqueioPortaRequestType request = new DesbloqueioPortaRequestType();
		if (entity.getCabinet() != null) {
			request.setDATAHORA(CalendarUtil.getCurrentTime());
			request.setNOME(entity.getCabinet().getIdMsan());
			request.setLIC(entity.getCabinet().getLic());
		}

		return request;
	}

	private void updateEntity(DesbloqueioPortaResponseType createResponse) {
		if (createResponse != null) {
			logOut(createResponse);
		}

	}

	private void logOut(DesbloqueioPortaResponseType createResponse) {
		StringBuilder log = new StringBuilder("Param OUT: ");
		if (createResponse != null) {
			log.append("DATAHORA = ").append(createResponse.getDATAHORA() != null ? createResponse.getDATAHORA().toString() : null)
			.append("CODMSG = ").append(createResponse.getCODMSG()).append("DSCMSG = ").append(createResponse.getDSCMSG()).toString();
			logger.log(OSSLogger.INFO, log.toString()); 
		}
	}
}