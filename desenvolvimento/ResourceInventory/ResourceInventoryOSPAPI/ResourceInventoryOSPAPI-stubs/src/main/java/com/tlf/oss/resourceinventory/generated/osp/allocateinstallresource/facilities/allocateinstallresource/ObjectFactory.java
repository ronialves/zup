
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.commonsexceptiontypes.CommonsExceptionElementType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource package. 
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

    private final static QName _AllocateResourceRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "allocateResourceRequest");
    private final static QName _ReserveResourceRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "reserveResourceRequest");
    private final static QName _ReleaseResourceRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "releaseResourceRequest");
    private final static QName _DetermineResourceAvailabilityRequest_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "determineResourceAvailabilityRequest");
    private final static QName _AllocateInstallResourceResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "allocateInstallResourceResponse");
    private final static QName _ReserveResourceResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "reserveResourceResponse");
    private final static QName _ReleaseResourceResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "releaseResourceResponse");
    private final static QName _DetermineResourceAvailabilityResponse_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "determineResourceAvailabilityResponse");
    private final static QName _FaultData_QNAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "faultData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllocateInstallResourceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "allocateResourceRequest")
    public JAXBElement<AllocateInstallResourceRequest> createAllocateResourceRequest(AllocateInstallResourceRequest value) {
        return new JAXBElement<AllocateInstallResourceRequest>(_AllocateResourceRequest_QNAME, AllocateInstallResourceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveResourceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "reserveResourceRequest")
    public JAXBElement<ReserveResourceRequest> createReserveResourceRequest(ReserveResourceRequest value) {
        return new JAXBElement<ReserveResourceRequest>(_ReserveResourceRequest_QNAME, ReserveResourceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseResourceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "releaseResourceRequest")
    public JAXBElement<ReleaseResourceRequest> createReleaseResourceRequest(ReleaseResourceRequest value) {
        return new JAXBElement<ReleaseResourceRequest>(_ReleaseResourceRequest_QNAME, ReleaseResourceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineResourceAvailabilityRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "determineResourceAvailabilityRequest")
    public JAXBElement<DetermineResourceAvailabilityRequest> createDetermineResourceAvailabilityRequest(DetermineResourceAvailabilityRequest value) {
        return new JAXBElement<DetermineResourceAvailabilityRequest>(_DetermineResourceAvailabilityRequest_QNAME, DetermineResourceAvailabilityRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllocateInstallResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "allocateInstallResourceResponse")
    public JAXBElement<AllocateInstallResourceResponse> createAllocateInstallResourceResponse(AllocateInstallResourceResponse value) {
        return new JAXBElement<AllocateInstallResourceResponse>(_AllocateInstallResourceResponse_QNAME, AllocateInstallResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "reserveResourceResponse")
    public JAXBElement<ReserveResourceResponse> createReserveResourceResponse(ReserveResourceResponse value) {
        return new JAXBElement<ReserveResourceResponse>(_ReserveResourceResponse_QNAME, ReserveResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "releaseResourceResponse")
    public JAXBElement<ReleaseResourceResponse> createReleaseResourceResponse(ReleaseResourceResponse value) {
        return new JAXBElement<ReleaseResourceResponse>(_ReleaseResourceResponse_QNAME, ReleaseResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineResourceAvailabilityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "determineResourceAvailabilityResponse")
    public JAXBElement<DetermineResourceAvailabilityResponse> createDetermineResourceAvailabilityResponse(DetermineResourceAvailabilityResponse value) {
        return new JAXBElement<DetermineResourceAvailabilityResponse>(_DetermineResourceAvailabilityResponse_QNAME, DetermineResourceAvailabilityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonsExceptionElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", name = "faultData")
    public JAXBElement<CommonsExceptionElementType> createFaultData(CommonsExceptionElementType value) {
        return new JAXBElement<CommonsExceptionElementType>(_FaultData_QNAME, CommonsExceptionElementType.class, null, value);
    }

}
