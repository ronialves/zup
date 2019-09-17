
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.provisiongtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AddressType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RegionCode" type="{http://www.cpqd.com.br/etics/provisiongtypes}RegionCodeZeroType" minOccurs="0"/&gt;
 *         &lt;element name="RegionName" type="{http://www.cpqd.com.br/etics/provisiongtypes}RegionNameType" minOccurs="0"/&gt;
 *         &lt;element name="StreetType" type="{http://www.cpqd.com.br/etics/provisiongtypes}StreetTypeType" minOccurs="0"/&gt;
 *         &lt;element name="StreetTitle" type="{http://www.cpqd.com.br/etics/provisiongtypes}StreetTitleType" minOccurs="0"/&gt;
 *         &lt;element name="StreetCode" type="{http://www.cpqd.com.br/etics/provisiongtypes}StreetCodeType" minOccurs="0"/&gt;
 *         &lt;element name="StreetName" type="{http://www.cpqd.com.br/etics/provisiongtypes}StreetNameType" minOccurs="0"/&gt;
 *         &lt;element name="DoorNumber" type="{http://www.cpqd.com.br/etics/provisiongtypes}DoorNumberType" minOccurs="0"/&gt;
 *         &lt;element name="Complement" type="{http://www.cpqd.com.br/etics/provisiongtypes}ComplementType" minOccurs="0"/&gt;
 *         &lt;element name="AddressGPS" type="{http://www.cpqd.com.br/etics/provisiongtypes}AddressGPSType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "regionCode",
    "regionName",
    "streetType",
    "streetTitle",
    "streetCode",
    "streetName",
    "doorNumber",
    "complement",
    "addressGPS"
})
public class AddressType {

    @XmlElement(name = "RegionCode")
    protected String regionCode;
    @XmlElement(name = "RegionName")
    protected String regionName;
    @XmlElement(name = "StreetType")
    protected String streetType;
    @XmlElement(name = "StreetTitle")
    protected String streetTitle;
    @XmlElement(name = "StreetCode")
    protected String streetCode;
    @XmlElement(name = "StreetName")
    protected String streetName;
    @XmlElement(name = "DoorNumber")
    protected String doorNumber;
    @XmlElement(name = "Complement")
    protected String complement;
    @XmlElement(name = "AddressGPS")
    protected String addressGPS;

    /**
     * Obtém o valor da propriedade regionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * Define o valor da propriedade regionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionCode(String value) {
        this.regionCode = value;
    }

    /**
     * Obtém o valor da propriedade regionName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * Define o valor da propriedade regionName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionName(String value) {
        this.regionName = value;
    }

    /**
     * Obtém o valor da propriedade streetType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetType() {
        return streetType;
    }

    /**
     * Define o valor da propriedade streetType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetType(String value) {
        this.streetType = value;
    }

    /**
     * Obtém o valor da propriedade streetTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetTitle() {
        return streetTitle;
    }

    /**
     * Define o valor da propriedade streetTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetTitle(String value) {
        this.streetTitle = value;
    }

    /**
     * Obtém o valor da propriedade streetCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetCode() {
        return streetCode;
    }

    /**
     * Define o valor da propriedade streetCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetCode(String value) {
        this.streetCode = value;
    }

    /**
     * Obtém o valor da propriedade streetName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Define o valor da propriedade streetName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Obtém o valor da propriedade doorNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoorNumber() {
        return doorNumber;
    }

    /**
     * Define o valor da propriedade doorNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoorNumber(String value) {
        this.doorNumber = value;
    }

    /**
     * Obtém o valor da propriedade complement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplement() {
        return complement;
    }

    /**
     * Define o valor da propriedade complement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplement(String value) {
        this.complement = value;
    }

    /**
     * Obtém o valor da propriedade addressGPS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressGPS() {
        return addressGPS;
    }

    /**
     * Define o valor da propriedade addressGPS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressGPS(String value) {
        this.addressGPS = value;
    }

}
