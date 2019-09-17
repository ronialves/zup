package com.tlf.oss.resourceinventory.terus.core.service;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.terus.bloqueioportarequest.BloqueioPortaRequestType;
import com.tlf.oss.resourceinventory.generated.terus.bloqueioportaresponse.BloqueioPortaResponseType;
import com.tlf.oss.resourceinventory.generated.terus.desbloqueioportarequest.DesbloqueioPortaRequestType;
import com.tlf.oss.resourceinventory.generated.terus.desbloqueioportaresponse.DesbloqueioPortaResponseType;

import br.com.cpqd.gercentrais.interfacews.terusoperacoes.ejb.TerusOperacoesService;


@Logged
public class TerusService {
	
	public static final String UPDATEPOTS = "UPDATEPOTS";
	
	@Inject
	private OSSLogger logger;
	
	public BloqueioPortaResponseType bloqueioPorta(BloqueioPortaRequestType request) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Started call web service (bloqueioPorta)");
		TerusOperacoesService service = new TerusOperacoesService();
	
		logger.log(OSSLogger.INFO, "Called service (bloqueioPorta) - request " + XMLUtil.getXMLValue(request));
		BloqueioPortaResponseType response = service.getTerusOperacoesPort().bloqueioPorta(request);
		
		logger.log(OSSLogger.INFO, "Called service (allocateResource) - response " + XMLUtil.getXMLValue(response));
		logger.log(OSSLogger.INFO, "Finished call web service (bloqueioPorta)");
		return response;
	}
	
	public DesbloqueioPortaResponseType desbloqueioPorta(DesbloqueioPortaRequestType request) throws OSSBusinessException {
		logger.log(OSSLogger.INFO, "Started call web service (desbloqueioPorta)");
		TerusOperacoesService service = new TerusOperacoesService();
	
		logger.log(OSSLogger.INFO, "Called service (desbloqueioPorta) - request " + XMLUtil.getXMLValue(request));
		DesbloqueioPortaResponseType response = service.getTerusOperacoesPort().desbloqueioPorta(request);
		
		logger.log(OSSLogger.INFO, "Called service (desbloqueioPorta) - response " + XMLUtil.getXMLValue(response));
		logger.log(OSSLogger.INFO, "Finished call web service (desbloqueioPorta)");
		return response;
	}
}