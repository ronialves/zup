
package com.tlf.oss.resourceinventory.generated.terus.desbloqueioportaresponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tlf.oss.resourceinventory.generated.terus.desbloqueioportaresponse package. 
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

    private final static QName _DesbloqueioPortaResponse_QNAME = new QName("http://www.cpqd.com.br/TERUS/DesbloqueioPortaResponse", "DesbloqueioPortaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tlf.oss.resourceinventory.generated.terus.desbloqueioportaresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DesbloqueioPortaResponseType }
     * 
     */
    public DesbloqueioPortaResponseType createDesbloqueioPortaResponseType() {
        return new DesbloqueioPortaResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloqueioPortaResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/TERUS/DesbloqueioPortaResponse", name = "DesbloqueioPortaResponse")
    public JAXBElement<DesbloqueioPortaResponseType> createDesbloqueioPortaResponse(DesbloqueioPortaResponseType value) {
        return new JAXBElement<DesbloqueioPortaResponseType>(_DesbloqueioPortaResponse_QNAME, DesbloqueioPortaResponseType.class, null, value);
    }

}