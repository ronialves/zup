package com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2019-08-22T10:32:23.714-03:00
 * Generated source version: 3.1.10
 * 
 */
@WebServiceClient(name = "TrackManageServiceProvisioning", 
                  wsdlLocation = "http://localhost:8180/cpqd/ws/oss/TrackManageServiceProvisioning?wsdl",
                  targetNamespace = "http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning") 
public class TrackManageServiceProvisioning_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", "TrackManageServiceProvisioning");
    public final static QName TrackManageServiceProvisioningPort = new QName("http://www.cpqd.com.br/etics/facilities/TrackManageServiceProvisioning", "TrackManageServiceProvisioningPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8180/cpqd/ws/oss/TrackManageServiceProvisioning?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TrackManageServiceProvisioning_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8180/cpqd/ws/oss/TrackManageServiceProvisioning?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TrackManageServiceProvisioning_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TrackManageServiceProvisioning_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TrackManageServiceProvisioning_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public TrackManageServiceProvisioning_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TrackManageServiceProvisioning_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TrackManageServiceProvisioning_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns TrackManageServiceProvisioning
     */
    @WebEndpoint(name = "TrackManageServiceProvisioningPort")
    public TrackManageServiceProvisioning getTrackManageServiceProvisioningPort() {
        return super.getPort(TrackManageServiceProvisioningPort, TrackManageServiceProvisioning.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TrackManageServiceProvisioning
     */
    @WebEndpoint(name = "TrackManageServiceProvisioningPort")
    public TrackManageServiceProvisioning getTrackManageServiceProvisioningPort(WebServiceFeature... features) {
        return super.getPort(TrackManageServiceProvisioningPort, TrackManageServiceProvisioning.class, features);
    }

}
