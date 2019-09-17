
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.customerresourcetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourcetypes.Resource;


/**
 * <p>Classe Java de CustomerResource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CustomerResource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="aditionalResource" type="{http://www.cpqd.com.br/etics/ResourceTypes}Resource" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerResource", propOrder = {
    "aditionalResource"
})
public class CustomerResource {

    protected Resource aditionalResource;

    /**
     * Obtém o valor da propriedade aditionalResource.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getAditionalResource() {
        return aditionalResource;
    }

    /**
     * Define o valor da propriedade aditionalResource.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setAditionalResource(Resource value) {
        this.aditionalResource = value;
    }

}
