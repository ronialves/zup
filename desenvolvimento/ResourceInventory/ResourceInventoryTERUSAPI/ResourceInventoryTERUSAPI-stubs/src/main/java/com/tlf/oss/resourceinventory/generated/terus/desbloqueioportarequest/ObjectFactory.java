
package com.tlf.oss.resourceinventory.generated.terus.desbloqueioportarequest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tlf.oss.resourceinventory.generated.terus.desbloqueioportarequest package. 
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

    private final static QName _DesbloqueioPortaRequest_QNAME = new QName("http://www.cpqd.com.br/TERUS/DesbloqueioPortaRequest", "DesbloqueioPortaRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tlf.oss.resourceinventory.generated.terus.desbloqueioportarequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DesbloqueioPortaRequestType }
     * 
     */
    public DesbloqueioPortaRequestType createDesbloqueioPortaRequestType() {
        return new DesbloqueioPortaRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloqueioPortaRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/TERUS/DesbloqueioPortaRequest", name = "DesbloqueioPortaRequest")
    public JAXBElement<DesbloqueioPortaRequestType> createDesbloqueioPortaRequest(DesbloqueioPortaRequestType value) {
        return new JAXBElement<DesbloqueioPortaRequestType>(_DesbloqueioPortaRequest_QNAME, DesbloqueioPortaRequestType.class, null, value);
    }

}
