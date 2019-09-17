
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.commonsexceptiontypes.CommonsExceptionElementType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.ManageResourceProvisioningActivityResponse;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.UpdateResourceRepositoryRequest;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes.UpdateResourceRepositoryResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning package. 
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

    private final static QName _MngResProvActRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", "mngResProvActRequest");
    private final static QName _MngResProvActResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", "mngResProvActResponse");
    private final static QName _UpdtResRepoRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", "updtResRepoRequest");
    private final static QName _UpdtResRepoResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", "updtResRepoResponse");
    private final static QName _FaultData_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", "faultData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManageResourceProvisioningActivityRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", name = "mngResProvActRequest")
    public JAXBElement<ManageResourceProvisioningActivityRequest> createMngResProvActRequest(ManageResourceProvisioningActivityRequest value) {
        return new JAXBElement<ManageResourceProvisioningActivityRequest>(_MngResProvActRequest_QNAME, ManageResourceProvisioningActivityRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManageResourceProvisioningActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", name = "mngResProvActResponse")
    public JAXBElement<ManageResourceProvisioningActivityResponse> createMngResProvActResponse(ManageResourceProvisioningActivityResponse value) {
        return new JAXBElement<ManageResourceProvisioningActivityResponse>(_MngResProvActResponse_QNAME, ManageResourceProvisioningActivityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResourceRepositoryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", name = "updtResRepoRequest")
    public JAXBElement<UpdateResourceRepositoryRequest> createUpdtResRepoRequest(UpdateResourceRepositoryRequest value) {
        return new JAXBElement<UpdateResourceRepositoryRequest>(_UpdtResRepoRequest_QNAME, UpdateResourceRepositoryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResourceRepositoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", name = "updtResRepoResponse")
    public JAXBElement<UpdateResourceRepositoryResponse> createUpdtResRepoResponse(UpdateResourceRepositoryResponse value) {
        return new JAXBElement<UpdateResourceRepositoryResponse>(_UpdtResRepoResponse_QNAME, UpdateResourceRepositoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonsExceptionElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/TrackManageResourceProvisioning", name = "faultData")
    public JAXBElement<CommonsExceptionElementType> createFaultData(CommonsExceptionElementType value) {
        return new JAXBElement<CommonsExceptionElementType>(_FaultData_QNAME, CommonsExceptionElementType.class, null, value);
    }

}
