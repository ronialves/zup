
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.supplementaryinformationreporttypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourceorderinfotypes.ResourceOrderInfo;


/**
 * <p>Classe Java de SupplementaryInformationIn complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SupplementaryInformationIn"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrderInfo" type="{http://www.cpqd.com.br/etics/ResourceOrderInfoTypes}ResourceOrderInfo" minOccurs="0"/&gt;
 *         &lt;element name="commandType" type="{http://www.cpqd.com.br/etics/simpletypes}string4" minOccurs="0"/&gt;
 *         &lt;element name="areaCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
 *         &lt;element name="callerProgram" type="{http://www.cpqd.com.br/etics/simpletypes}string8" minOccurs="0"/&gt;
 *         &lt;element name="dedicatedFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="osNature" type="{http://www.cpqd.com.br/etics/simpletypes}integer3" minOccurs="0"/&gt;
 *         &lt;element name="osStatus" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
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
@XmlType(name = "SupplementaryInformationIn", propOrder = {
    "resourceOrderInfo",
    "commandType",
    "areaCode",
    "callerProgram",
    "dedicatedFlag",
    "osNature",
    "osStatus",
    "customElements"
})
public class SupplementaryInformationIn {

    protected ResourceOrderInfo resourceOrderInfo;
    protected String commandType;
    @XmlSchemaType(name = "integer")
    protected Integer areaCode;
    protected String callerProgram;
    protected String dedicatedFlag;
    @XmlSchemaType(name = "integer")
    protected Integer osNature;
    @XmlSchemaType(name = "integer")
    protected Integer osStatus;
    protected CustomElements customElements;

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
     * Obtém o valor da propriedade commandType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * Define o valor da propriedade commandType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommandType(String value) {
        this.commandType = value;
    }

    /**
     * Obtém o valor da propriedade areaCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * Define o valor da propriedade areaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAreaCode(Integer value) {
        this.areaCode = value;
    }

    /**
     * Obtém o valor da propriedade callerProgram.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallerProgram() {
        return callerProgram;
    }

    /**
     * Define o valor da propriedade callerProgram.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallerProgram(String value) {
        this.callerProgram = value;
    }

    /**
     * Obtém o valor da propriedade dedicatedFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDedicatedFlag() {
        return dedicatedFlag;
    }

    /**
     * Define o valor da propriedade dedicatedFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDedicatedFlag(String value) {
        this.dedicatedFlag = value;
    }

    /**
     * Obtém o valor da propriedade osNature.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOsNature() {
        return osNature;
    }

    /**
     * Define o valor da propriedade osNature.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOsNature(Integer value) {
        this.osNature = value;
    }

    /**
     * Obtém o valor da propriedade osStatus.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOsStatus() {
        return osStatus;
    }

    /**
     * Define o valor da propriedade osStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOsStatus(Integer value) {
        this.osStatus = value;
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
