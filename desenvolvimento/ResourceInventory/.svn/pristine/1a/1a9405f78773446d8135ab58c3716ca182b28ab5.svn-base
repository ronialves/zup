package com.tlf.oss.resourceinventory.api.faultmanagement.v1_0;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.xml.ws.Holder;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.SoapInterceptor;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.core.faultmanagement.v1_0.FaultManagementResourceDataCollection;
import com.tlf.oss.resourceinventory.schemas.api.faultmanagement.RetrieveResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.faultmanagement.RetrieveResourceInformationOut;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

@Stateless
@WebService(name = "FaultManagementResourceDataCollectionPort", serviceName = "FaultManagementResourceDataCollection", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION_FM)
@SoapInterceptor
public class FaultManagementResourceDataCollectionWS {

	@Inject
	protected OSSLogger logger;

	@Inject
	private FaultManagementResourceDataCollection faultManagementResourceDataCollection;

	@WebMethod(operationName = "retrieveResourceInformation")
	@WebResult(name = "retrieveResourceInformationOut", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION_FM)
	public RetrieveResourceInformationOut retrieveResourceInformation(
			@WebParam(name = "header", targetNamespace = RIConstants.NAMESPACE_HEADER, header = true, mode = Mode.INOUT) Holder<Header> header,
			@WebParam(name = "retrieveResourceInformationIn", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION_FM) RetrieveResourceInformationIn retrieveResourceInformationIn)
			throws OSSBusinessException {

		logger.log(OSSLogger.INFO, "FaultManagementResourceDataCollectionWS - Iniciando fluxo de Data Collection.");
		return faultManagementResourceDataCollection.retrieveResourceInformationFM(header.value, retrieveResourceInformationIn);
	}
}