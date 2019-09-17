
package com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.provisiongtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TerminalBoxType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TerminalBoxType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Code" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="BuildingFlag" type="{http://www.cpqd.com.br/etics/simpletypes}integer1" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{http://www.cpqd.com.br/etics/provisiongtypes}AddressType" minOccurs="0"/&gt;
 *         &lt;element name="HasTransformer" type="{http://www.cpqd.com.br/etics/simpletypes}integer1" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminalBoxType", propOrder = {
    "code",
    "buildingFlag",
    "type",
    "address",
    "hasTransformer"
})
public class TerminalBoxType {

    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "BuildingFlag")
    @XmlSchemaType(name = "integer")
    protected Integer buildingFlag;
    @XmlElement(name = "Type")
    protected String type;
    @XmlElement(name = "Address")
    protected AddressType address;
    @XmlElement(name = "HasTransformer")
    @XmlSchemaType(name = "integer")
    protected Integer hasTransformer;

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
     * Obtém o valor da propriedade buildingFlag.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuildingFlag() {
        return buildingFlag;
    }

    /**
     * Define o valor da propriedade buildingFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuildingFlag(Integer value) {
        this.buildingFlag = value;
    }

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
     * Obtém o valor da propriedade address.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Define o valor da propriedade address.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Obtém o valor da propriedade hasTransformer.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHasTransformer() {
        return hasTransformer;
    }

    /**
     * Define o valor da propriedade hasTransformer.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHasTransformer(Integer value) {
        this.hasTransformer = value;
    }

}
