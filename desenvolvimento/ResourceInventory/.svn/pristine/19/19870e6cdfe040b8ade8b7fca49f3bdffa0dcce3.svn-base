package com.tlf.oss.resourceinventory.api.resourceordermanagement.v2_0;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.SoapInterceptor;
import com.tlf.oss.resourceinventory.core.resourceordermanagement.v2_0.ResourceDataCollectionV2;
import com.tlf.oss.resourceinventory.schemas.api.v2_0.RetrieveResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v2_0.RetrieveResourceInformationOut;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Holder;

/**
 * Interface nova para busca de dados
 */
@Stateless
@WebService(name = "ResourceDataCollectionV2Port", serviceName = "ResourceDataCollectionV2", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION_V2)
@SoapInterceptor
public class ResourceDataCollectionV2WS {

	@Inject private ResourceDataCollectionV2 resourceDataCollectionV2;

	/**
	 * Metodo responsavel por consultar a facilidade do cliente
	 * 
	 * @param header
	 * @param retrieveResourceInformationIn
	 * @throws OSSBusinessException
	 */
	@WebMethod(operationName = "retrieveResourceInformation")
	@WebResult(name = "retrieveResourceInformationOut", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION_V2)
	public RetrieveResourceInformationOut retrieveResourceInformation(
			@WebParam(name = "header", targetNamespace = RIConstants.NAMESPACE_HEADER, header = true, mode = Mode.INOUT) Holder<Header> header,
			@WebParam(name = "retrieveResourceInformationIn", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION_V2) RetrieveResourceInformationIn retrieveResourceInformationIn)
			throws OSSBusinessException {

		return resourceDataCollectionV2.retrieveResourceInformation(header.value, retrieveResourceInformationIn);
	}

}