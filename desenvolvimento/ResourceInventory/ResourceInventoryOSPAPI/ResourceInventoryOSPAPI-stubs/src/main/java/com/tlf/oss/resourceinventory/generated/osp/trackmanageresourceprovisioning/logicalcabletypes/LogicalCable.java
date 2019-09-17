
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.logicalcabletypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de LogicalCable complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="LogicalCable"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="regionCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer9" minOccurs="0"/&gt;
 *         &lt;element name="siteCode" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="code" type="{http://www.cpqd.com.br/etics/simpletypes}string40"/&gt;
 *         &lt;element name="lateral" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
 *         &lt;element name="logicalUnit" type="{http://www.cpqd.com.br/etics/simpletypes}integer4"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalCable", propOrder = {
    "regionCode",
    "siteCode",
    "code",
    "lateral",
    "function",
    "logicalUnit"
})
public class LogicalCable {

    @XmlSchemaType(name = "integer")
    protected Integer regionCode;
    protected String siteCode;
    @XmlElement(required = true)
    protected String code;
    protected String lateral;
    @XmlSchemaType(name = "integer")
    protected Integer function;
    @XmlSchemaType(name = "integer")
    protected int logicalUnit;

    /**
     * Obtém o valor da propriedade regionCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRegionCode() {
        return regionCode;
    }

    /**
     * Define o valor da propriedade regionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRegionCode(Integer value) {
        this.regionCode = value;
    }

    /**
     * Obtém o valor da propriedade siteCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteCode() {
        return siteCode;
    }

    /**
     * Define o valor da propriedade siteCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteCode(String value) {
        this.siteCode = value;
    }

    /**
     * Obtém o valor da propriedade code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define o valor da propriedade code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtém o valor da propriedade lateral.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLateral() {
        return lateral;
    }

    /**
     * Define o valor da propriedade lateral.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLateral(String value) {
        this.lateral = value;
    }

    /**
     * Obtém o valor da propriedade function.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFunction() {
        return function;
    }

    /**
     * Define o valor da propriedade function.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFunction(Integer value) {
        this.function = value;
    }

    /**
     * Obtém o valor da propriedade logicalUnit.
     * 
     */
    public int getLogicalUnit() {
        return logicalUnit;
    }

    /**
     * Define o valor da propriedade logicalUnit.
     * 
     */
    public void setLogicalUnit(int value) {
        this.logicalUnit = value;
    }

}
