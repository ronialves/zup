
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.dedicatedresourcetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de DedicatedResource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DedicatedResource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="regionCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer9" minOccurs="0"/&gt;
 *         &lt;element name="site" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="streetCode" type="{http://www.cpqd.com.br/etics/simpletypes}string12" minOccurs="0"/&gt;
 *         &lt;element name="streetType" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="streetTitle" type="{http://www.cpqd.com.br/etics/simpletypes}string14" minOccurs="0"/&gt;
 *         &lt;element name="streetName" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="lotNum" type="{http://www.cpqd.com.br/etics/simpletypes}string35" minOccurs="0"/&gt;
 *         &lt;element name="addressCompl" type="{http://www.cpqd.com.br/etics/simpletypes}string45" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DedicatedResource", propOrder = {
    "regionCode",
    "site",
    "streetCode",
    "streetType",
    "streetTitle",
    "streetName",
    "lotNum",
    "addressCompl"
})
public class DedicatedResource {

    @XmlSchemaType(name = "integer")
    protected Integer regionCode;
    protected String site;
    protected String streetCode;
    protected String streetType;
    protected String streetTitle;
    protected String streetName;
    protected String lotNum;
    protected String addressCompl;

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
     * Obtém o valor da propriedade site.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSite() {
        return site;
    }

    /**
     * Define o valor da propriedade site.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSite(String value) {
        this.site = value;
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
     * Obtém o valor da propriedade lotNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLotNum() {
        return lotNum;
    }

    /**
     * Define o valor da propriedade lotNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLotNum(String value) {
        this.lotNum = value;
    }

    /**
     * Obtém o valor da propriedade addressCompl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressCompl() {
        return addressCompl;
    }

    /**
     * Define o valor da propriedade addressCompl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressCompl(String value) {
        this.addressCompl = value;
    }

}
