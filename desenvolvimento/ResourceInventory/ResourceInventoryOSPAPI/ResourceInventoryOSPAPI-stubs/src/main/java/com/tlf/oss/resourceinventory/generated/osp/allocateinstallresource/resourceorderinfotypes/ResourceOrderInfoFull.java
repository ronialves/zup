
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceorderinfotypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de ResourceOrderInfoFull complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ResourceOrderInfoFull"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrderType" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="resourceOrderDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceOrderInfoFull", propOrder = {
    "resourceOrderType",
    "resourceOrder",
    "resourceOrderDate"
})
public class ResourceOrderInfoFull {

    protected String resourceOrderType;
    protected String resourceOrder;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar resourceOrderDate;

    /**
     * Obtém o valor da propriedade resourceOrderType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceOrderType() {
        return resourceOrderType;
    }

    /**
     * Define o valor da propriedade resourceOrderType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceOrderType(String value) {
        this.resourceOrderType = value;
    }

    /**
     * Obtém o valor da propriedade resourceOrder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceOrder() {
        return resourceOrder;
    }

    /**
     * Define o valor da propriedade resourceOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceOrder(String value) {
        this.resourceOrder = value;
    }

    /**
     * Obtém o valor da propriedade resourceOrderDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResourceOrderDate() {
        return resourceOrderDate;
    }

    /**
     * Define o valor da propriedade resourceOrderDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResourceOrderDate(XMLGregorianCalendar value) {
        this.resourceOrderDate = value;
    }

}
