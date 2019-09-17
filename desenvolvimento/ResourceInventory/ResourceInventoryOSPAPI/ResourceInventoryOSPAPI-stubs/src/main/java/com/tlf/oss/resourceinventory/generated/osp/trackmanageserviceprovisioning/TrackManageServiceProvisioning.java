package com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2019-08-22T10:32:23.709-03:00
 * Generated source version: 3.1.10
 * 
 */
@WebService(targetNamespace = "http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", name = "TrackManageServiceProvisioning")
@XmlSeeAlso({com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.customertypes.ObjectFactory.class, br.com.cpqd.etics.resourcespecificationtypes.ObjectFactory.class, ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.commonsexceptiontypes.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.resourceserviceinfotypes.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.resourceorderinfoTypes.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.supplementaryinformationmanageservtypes.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.resourceservicetypes.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.servicetypes.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.customelements.ObjectFactory.class, com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.provisiongtypes.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TrackManageServiceProvisioning {

    @WebMethod
    @WebResult(name = "trkMngServProvResponse", targetNamespace = "http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", partName = "outputData")
    public com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningResponse manageServiceProvisioningActivity(
        @WebParam(partName = "inputData", name = "mngServProvActRequest", targetNamespace = "http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning")
        com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningRequest inputData,
        @WebParam(partName = "context", name = "context", targetNamespace = "http://www.cpqd.com.br/etics/headerContext", header = true)
        com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext.WsContext context
    ) throws FacilitiesException;
}
