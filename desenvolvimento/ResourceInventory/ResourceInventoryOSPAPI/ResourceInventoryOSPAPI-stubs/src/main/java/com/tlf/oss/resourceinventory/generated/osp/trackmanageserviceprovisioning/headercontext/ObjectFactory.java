
package com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext package. 
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

    private final static QName _Context_QNAME = new QName("http://www.cpqd.com.br/etics/headerContext", "context");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.headercontext
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WsContext }
     * 
     */
    public WsContext createWsContext() {
        return new WsContext();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cpqd.com.br/etics/headerContext", name = "context")
    public JAXBElement<WsContext> createContext(WsContext value) {
        return new JAXBElement<WsContext>(_Context_QNAME, WsContext.class, null, value);
    }

}
