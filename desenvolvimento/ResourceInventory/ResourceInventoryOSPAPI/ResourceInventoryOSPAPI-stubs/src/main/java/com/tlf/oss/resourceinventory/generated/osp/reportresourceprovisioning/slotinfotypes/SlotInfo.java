
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.slotinfotypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SlotInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SlotInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="slotClientCode" type="{http://www.cpqd.com.br/etics/simpletypes}string2" minOccurs="0"/&gt;
 *         &lt;element name="slotClientPort" type="{http://www.cpqd.com.br/etics/simpletypes}integer4" minOccurs="0"/&gt;
 *         &lt;element name="slotUplinkCode" type="{http://www.cpqd.com.br/etics/simpletypes}string2" minOccurs="0"/&gt;
 *         &lt;element name="slotUplinkPort" type="{http://www.cpqd.com.br/etics/simpletypes}integer4" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SlotInfo", propOrder = {
    "slotClientCode",
    "slotClientPort",
    "slotUplinkCode",
    "slotUplinkPort"
})
public class SlotInfo {

    protected String slotClientCode;
    @XmlSchemaType(name = "integer")
    protected Integer slotClientPort;
    protected String slotUplinkCode;
    @XmlSchemaType(name = "integer")
    protected Integer slotUplinkPort;

    /**
     * Obtém o valor da propriedade slotClientCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlotClientCode() {
        return slotClientCode;
    }

    /**
     * Define o valor da propriedade slotClientCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlotClientCode(String value) {
        this.slotClientCode = value;
    }

    /**
     * Obtém o valor da propriedade slotClientPort.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSlotClientPort() {
        return slotClientPort;
    }

    /**
     * Define o valor da propriedade slotClientPort.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSlotClientPort(Integer value) {
        this.slotClientPort = value;
    }

    /**
     * Obtém o valor da propriedade slotUplinkCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlotUplinkCode() {
        return slotUplinkCode;
    }

    /**
     * Define o valor da propriedade slotUplinkCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlotUplinkCode(String value) {
        this.slotUplinkCode = value;
    }

    /**
     * Obtém o valor da propriedade slotUplinkPort.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSlotUplinkPort() {
        return slotUplinkPort;
    }

    /**
     * Define o valor da propriedade slotUplinkPort.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSlotUplinkPort(Integer value) {
        this.slotUplinkPort = value;
    }

}
