
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ServiceType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{http://www.cpqd.com.br/etics/provisiongtypes}ServiceTypeType" minOccurs="0"/&gt;
 *         &lt;element name="Number" type="{http://www.cpqd.com.br/etics/provisiongtypes}ServiceNumberType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceType", propOrder = {
    "type",
    "number"
})
public class ServiceType {

    @XmlElement(name = "Type", defaultValue = "P")
    protected String type;
    @XmlElement(name = "Number")
    @XmlSchemaType(name = "integer")
    protected long number;

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade number.
     * 
     */
    public long getNumber() {
        return number;
    }

    /**
     * Define o valor da propriedade number.
     * 
     */
    public void setNumber(long value) {
        this.number = value;
    }

}
