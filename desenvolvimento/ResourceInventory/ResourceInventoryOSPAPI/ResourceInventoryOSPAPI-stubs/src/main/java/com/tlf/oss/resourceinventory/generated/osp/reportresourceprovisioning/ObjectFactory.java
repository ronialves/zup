
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.commonsexceptiontypes.CommonsExceptionElementType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.DistributeFreeResourceTermRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.DistributeFreeResourceTermResponse;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningRequest;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes.ReportResourceProvisioningResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning package. 
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

    private final static QName _DistResProvRepoRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", "distResProvRepoRequest");
    private final static QName _DistFreeResTermRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", "distFreeResTermRequest");
    private final static QName _ReportResourceProvisioningResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", "reportResourceProvisioningResponse");
    private final static QName _DistributeFreeResourceTermResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", "distributeFreeResourceTermResponse");
    private final static QName _FaultData_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", "faultData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportResourceProvisioningRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", name = "distResProvRepoRequest")
    public JAXBElement<ReportResourceProvisioningRequest> createDistResProvRepoRequest(ReportResourceProvisioningRequest value) {
        return new JAXBElement<ReportResourceProvisioningRequest>(_DistResProvRepoRequest_QNAME, ReportResourceProvisioningRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributeFreeResourceTermRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", name = "distFreeResTermRequest")
    public JAXBElement<DistributeFreeResourceTermRequest> createDistFreeResTermRequest(DistributeFreeResourceTermRequest value) {
        return new JAXBElement<DistributeFreeResourceTermRequest>(_DistFreeResTermRequest_QNAME, DistributeFreeResourceTermRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportResourceProvisioningResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", name = "reportResourceProvisioningResponse")
    public JAXBElement<ReportResourceProvisioningResponse> createReportResourceProvisioningResponse(ReportResourceProvisioningResponse value) {
        return new JAXBElement<ReportResourceProvisioningResponse>(_ReportResourceProvisioningResponse_QNAME, ReportResourceProvisioningResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributeFreeResourceTermResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", name = "distributeFreeResourceTermResponse")
    public JAXBElement<DistributeFreeResourceTermResponse> createDistributeFreeResourceTermResponse(DistributeFreeResourceTermResponse value) {
        return new JAXBElement<DistributeFreeResourceTermResponse>(_DistributeFreeResourceTermResponse_QNAME, DistributeFreeResourceTermResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonsExceptionElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/ReportResourceProvisioning", name = "faultData")
    public JAXBElement<CommonsExceptionElementType> createFaultData(CommonsExceptionElementType value) {
        return new JAXBElement<CommonsExceptionElementType>(_FaultData_QNAME, CommonsExceptionElementType.class, null, value);
    }

}
