
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2019-08-22T10:32:24.501-03:00
 * Generated source version: 3.1.10
 * 
 */
public final class AllocateInstallResource_AllocateInstallResourcePort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.cpqd.com.br/etics/facilities/AllocateInstallResource", "AllocateInstallResource");

    private AllocateInstallResource_AllocateInstallResourcePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = AllocateInstallResource_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        AllocateInstallResource_Service ss = new AllocateInstallResource_Service(wsdlURL, SERVICE_NAME);
        AllocateInstallResource port = ss.getAllocateInstallResourcePort();  
        
        {
        System.out.println("Invoking determineResourceAvailability...");
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityRequest _determineResourceAvailability_inputData = null;
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext _determineResourceAvailability_context = null;
        try {
            com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse _determineResourceAvailability__return = port.determineResourceAvailability(_determineResourceAvailability_inputData, _determineResourceAvailability_context);
            System.out.println("determineResourceAvailability.result=" + _determineResourceAvailability__return);

        } catch (FacilitiesException e) { 
            System.out.println("Expected exception: facilitiesException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking allocateResource...");
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceRequest _allocateResource_inputData = null;
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext _allocateResource_context = null;
        try {
            com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceResponse _allocateResource__return = port.allocateResource(_allocateResource_inputData, _allocateResource_context);
            System.out.println("allocateResource.result=" + _allocateResource__return);

        } catch (FacilitiesException e) { 
            System.out.println("Expected exception: facilitiesException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking reserveResource...");
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceRequest _reserveResource_inputData = null;
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext _reserveResource_context = null;
        try {
            com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReserveResourceResponse _reserveResource__return = port.reserveResource(_reserveResource_inputData, _reserveResource_context);
            System.out.println("reserveResource.result=" + _reserveResource__return);

        } catch (FacilitiesException e) { 
            System.out.println("Expected exception: facilitiesException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking releaseResource...");
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceRequest _releaseResource_inputData = null;
        com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext _releaseResource_context = null;
        try {
            com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.ReleaseResourceResponse _releaseResource__return = port.releaseResource(_releaseResource_inputData, _releaseResource_context);
            System.out.println("releaseResource.result=" + _releaseResource__return);

        } catch (FacilitiesException e) { 
            System.out.println("Expected exception: facilitiesException has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
