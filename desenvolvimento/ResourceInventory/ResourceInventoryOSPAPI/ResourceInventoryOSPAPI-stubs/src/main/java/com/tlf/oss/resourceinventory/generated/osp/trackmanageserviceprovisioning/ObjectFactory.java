
package com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.commonsexceptiontypes.CommonsExceptionElementType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes.TrackManageServiceProvisioningResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MngServProvActRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", "mngServProvActRequest");
    private final static QName _TrkMngServProvResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", "trkMngServProvResponse");
    private final static QName _FaultData_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", "faultData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackManageServiceProvisioningRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", name = "mngServProvActRequest")
    public JAXBElement<TrackManageServiceProvisioningRequest> createMngServProvActRequest(TrackManageServiceProvisioningRequest value) {
        return new JAXBElement<TrackManageServiceProvisioningRequest>(_MngServProvActRequest_QNAME, TrackManageServiceProvisioningRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackManageServiceProvisioningResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", name = "trkMngServProvResponse")
    public JAXBElement<TrackManageServiceProvisioningResponse> createTrkMngServProvResponse(TrackManageServiceProvisioningResponse value) {
        return new JAXBElement<TrackManageServiceProvisioningResponse>(_TrkMngServProvResponse_QNAME, TrackManageServiceProvisioningResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonsExceptionElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", name = "faultData")
    public JAXBElement<CommonsExceptionElementType> createFaultData(CommonsExceptionElementType value) {
        return new JAXBElement<CommonsExceptionElementType>(_FaultData_QNAME, CommonsExceptionElementType.class, null, value);
    }

}
