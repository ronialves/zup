package com.tlf.oss.resourceinventory.api.resourcelifecyclemanagement.v1_0;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.header.Header;
import com.tlf.oss.common.interceptor.annotation.SoapInterceptor;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.core.resourcelifecyclemanagement.v1_0.GatherAndAnalyseResourceInformation;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformationOut;
import com.tlf.oss.resourceinventory.schemas.util.RIConstants;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Holder;

@Stateless
@WebService(name = "GatherAndAnalyseResourceInformationPort", serviceName = "GatherAndAnalyseResourceInformation", targetNamespace = RIConstants.NAMESPACE_GATHER_AND_ANALYSE_RESOURCE_INFORMATION)
@SoapInterceptor
public class GatherAndAnalyseResourceInformationWS {

    @Inject protected OSSLogger logger;
    @Inject protected GatherAndAnalyseResourceInformation gatherAndAnalyseResourceInformation;

    @WebMethod(operationName = "gatherResourceInformation")
    @WebResult(name = "gatherResourceInformationOut", targetNamespace = RIConstants.NAMESPACE_GATHER_AND_ANALYSE_RESOURCE_INFORMATION)
    public GatherResourceInformationOut gatherResourceInformation(
            @WebParam(name = "header", targetNamespace = RIConstants.NAMESPACE_HEADER, header = true, mode = Mode.INOUT) Holder<Header> header,
            @WebParam(name = "gatherResourceInformationIn", targetNamespace = RIConstants.NAMESPACE_GATHER_AND_ANALYSE_RESOURCE_INFORMATION) GatherResourceInformationIn gatherResourceInformationIn)
            throws OSSBusinessException
    {

        logger.log(OSSLogger.INFO, "GatherAndAnalyseResourceInformationWS - Iniciando o fluxo de busca de recursos.");
        return this.gatherAndAnalyseResourceInformation.gatherResourceInformation(header.value, gatherResourceInformationIn);
    }
}
