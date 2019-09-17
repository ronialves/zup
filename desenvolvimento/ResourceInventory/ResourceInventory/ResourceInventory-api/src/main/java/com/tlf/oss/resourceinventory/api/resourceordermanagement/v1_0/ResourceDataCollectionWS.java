package com.tlf.oss.resourceinventory.api.resourceordermanagement.v1_0;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.SoapInterceptor;
import com.tlf.oss.resourceinventory.core.resourceordermanagement.v1_0.ResourceDataCollection;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveAccessInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveAccessInformationOut;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveResourceInformationOut;
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
@WebService(name = "ResourceDataCollectionPort", serviceName = "ResourceDataCollection", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION)
@SoapInterceptor
public class ResourceDataCollectionWS {
	
	@Inject
	private ResourceDataCollection resourceDataCollection;

	/**
	 * Método responsavel por consultar a facilidade do cliente
	 * 
	 * @param header
	 * @param retrieveResourceInformationIn
	 * @throws OSSBusinessException
	 */
	@WebMethod(operationName = "retrieveResourceInformation")
	@WebResult(name = "retrieveResourceInformationOut", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION)
	public RetrieveResourceInformationOut retrieveResourceInformation(
			@WebParam(name = "header", targetNamespace = RIConstants.NAMESPACE_HEADER, header = true, mode = Mode.INOUT) Holder<Header> header,
			@WebParam(name = "retrieveResourceInformationIn", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION) RetrieveResourceInformationIn retrieveResourceInformationIn)
			throws OSSBusinessException {
		
		return resourceDataCollection.retrieveResourceInformation(header.value, retrieveResourceInformationIn);
	}
	
	/**
	 * Operacao responsavel por realizar consulta do cliente PSTN
	 * 
	 * @param header
	 * @param retrieveAccessInformationIn
	 * @return retrieveAccessInformationOut
	 * @throws OSSBusinessException
	 */
	@WebMethod(operationName = "retrieveAccessInformation")
	@WebResult(name = "retrieveAccessInformationOut", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION)
	public RetrieveAccessInformationOut retrieveAccessInformation(
			@WebParam(name = "header", targetNamespace = RIConstants.NAMESPACE_HEADER, header = true, mode = Mode.INOUT) Holder<Header> header,
			@WebParam(name = "retrieveAccessInformationIn", targetNamespace = RIConstants.NAMESPACE_RESOURCE_DATA_COLLECTION) RetrieveAccessInformationIn retrieveAccessInformationIn)
					throws OSSBusinessException {
		return resourceDataCollection.retrieveAccessInformation(header.value, retrieveAccessInformationIn);
	}
}
