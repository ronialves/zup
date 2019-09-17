
package com.tlf.oss.resourceinventory.generated.scqla;

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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.10
 * 2019-08-22T10:32:55.418-03:00
 * Generated source version: 3.1.10
 * 
 */
public final class PreQualificacao_PreQualificacaoPort_Client {

    private static final QName SERVICE_NAME = new QName("http://br.com.vivo.indra.scqla.ws/", "PreQualificacaoService");

    private PreQualificacao_PreQualificacaoPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = PreQualificacaoService.WSDL_LOCATION;
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
      
        PreQualificacaoService ss = new PreQualificacaoService(wsdlURL, SERVICE_NAME);
        PreQualificacao port = ss.getPreQualificacaoPort();  
        
        {
        System.out.println("Invoking qualificarTVA...");
        com.tlf.oss.resourceinventory.generated.scqla.QualificarTVA.ScqlaRequest _qualificarTVA_scqlaRequest = null;
        com.tlf.oss.resourceinventory.generated.scqla.QualificarTVAResponse.ScqlaResponseTVA _qualificarTVA__return = port.qualificarTVA(_qualificarTVA_scqlaRequest);
        System.out.println("qualificarTVA.result=" + _qualificarTVA__return);


        }
        {
        System.out.println("Invoking consultarFacilidade...");
        com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidade.ScqlaRequest _consultarFacilidade_scqlaRequest = null;
        com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidadeResponse.ConsultaFacilidadeResponse _consultarFacilidade__return = port.consultarFacilidade(_consultarFacilidade_scqlaRequest);
        System.out.println("consultarFacilidade.result=" + _consultarFacilidade__return);


        }
        {
        System.out.println("Invoking qualificar...");
        com.tlf.oss.resourceinventory.generated.scqla.Qualificar.ScqlaRequest _qualificar_scqlaRequest = null;
        com.tlf.oss.resourceinventory.generated.scqla.QualificarResponse.ScqlaResponse _qualificar__return = port.qualificar(_qualificar_scqlaRequest);
        System.out.println("qualificar.result=" + _qualificar__return);


        }

        System.exit(0);
    }

}