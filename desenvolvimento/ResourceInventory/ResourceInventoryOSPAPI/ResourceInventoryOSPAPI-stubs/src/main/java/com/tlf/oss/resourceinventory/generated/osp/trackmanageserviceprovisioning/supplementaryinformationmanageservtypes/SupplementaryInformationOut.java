
package com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.supplementaryinformationmanageservtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.resourceorderinfoTypes.ResourceOrderInfo;


/**
 * <p>Classe Java de SupplementaryInformationOut complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SupplementaryInformationOut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="adServiceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="resourceOrderInfo" type="{http://www.cpqd.com.br/etics/ResourceOrderInfoTypes}ResourceOrderInfo" minOccurs="0"/&gt;
 *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="timeStamp" type="{http://www.cpqd.com.br/etics/simpletypes}string19" minOccurs="0"/&gt;
 *         &lt;element name="customElements" type="{http://www.cpqd.com.br/etics/customelements}CustomElements" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplementaryInformationOut", propOrder = {
    "serviceType",
    "adServiceType",
    "resourceOrderInfo",
    "resourceOrder",
    "timeStamp",
    "customElements"
})
public class SupplementaryInformationOut {

    protected String serviceType;
    protected String adServiceType;
    protected ResourceOrderInfo resourceOrderInfo;
    protected String resourceOrder;
    protected String timeStamp;
    protected CustomElements customElements;

    /**
     * Obtém o valor da propriedade serviceType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Define o valor da propriedade serviceType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Obtém o valor da propriedade adServiceType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdServiceType() {
        return adServiceType;
    }

    /**
     * Define o valor da propriedade adServiceType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdServiceType(String value) {
        this.adServiceType = value;
    }

    /**
     * Obtém o valor da propriedade resourceOrderInfo.
     * 
     * @return
     *     possible object is
     *     {@link ResourceOrderInfo }
     *     
     */
    public ResourceOrderInfo getResourceOrderInfo() {
        return resourceOrderInfo;
    }

    /**
     * Define o valor da propriedade resourceOrderInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceOrderInfo }
     *     
     */
    public void setResourceOrderInfo(ResourceOrderInfo value) {
        this.resourceOrderInfo = value;
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
     * Obtém o valor da propriedade timeStamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Define o valor da propriedade timeStamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

    /**
     * Obtém o valor da propriedade customElements.
     * 
     * @return
     *     possible object is
     *     {@link CustomElements }
     *     
     */
    public CustomElements getCustomElements() {
        return customElements;
    }

    /**
     * Define o valor da propriedade customElements.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomElements }
     *     
     */
    public void setCustomElements(CustomElements value) {
        this.customElements = value;
    }

}
