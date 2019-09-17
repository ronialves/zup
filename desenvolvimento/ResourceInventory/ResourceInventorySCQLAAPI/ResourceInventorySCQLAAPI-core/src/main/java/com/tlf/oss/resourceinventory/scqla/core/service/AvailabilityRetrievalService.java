package com.tlf.oss.resourceinventory.scqla.core.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.common.xml.XMLUtil;
import com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidade.ScqlaRequest;
import com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidadeResponse.ConsultaFacilidadeResponse;
import com.tlf.oss.resourceinventory.generated.scqla.PreQualificacaoService;

@Logged
@Stateless
public class AvailabilityRetrievalService {

	@Inject
	private OSSLogger logger;
	
	public ConsultaFacilidadeResponse consultarFacilidade(ScqlaRequest request) {
		
		logger.log(OSSLogger.INFO, "Started call web service SCQLA (consultarFacilidade)");
		
		logger.log(OSSLogger.INFO,
				"Called web service SCQLA (consultarFacilidade) - request \n" + XMLUtil.getXMLValue(request));
		
		PreQualificacaoService pqs = new PreQualificacaoService();
		ConsultaFacilidadeResponse response = pqs.getPreQualificacaoPort().consultarFacilidade(request);
		
		logger.log(OSSLogger.INFO,
				"Called web service SCQLA (consultarFacilidade) - response \n" + XMLUtil.getXMLValue(response));
		
		logger.log(OSSLogger.INFO, "Finished call web service SCQLA (consultarFacilidade)");
		
		return response;
	}
}
