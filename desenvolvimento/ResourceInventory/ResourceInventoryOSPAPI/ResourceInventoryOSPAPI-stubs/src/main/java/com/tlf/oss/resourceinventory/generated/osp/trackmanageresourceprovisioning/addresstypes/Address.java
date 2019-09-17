
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.addresstypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Address complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Address"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="siteCode" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="cityCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer9" minOccurs="0"/&gt;
 *         &lt;element name="streetCode" type="{http://www.cpqd.com.br/etics/simpletypes}string12" minOccurs="0"/&gt;
 *         &lt;element name="streetType" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="streetTitle" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="streetName" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="streetNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string35" minOccurs="0"/&gt;
 *         &lt;element name="crossingStreetCode" type="{http://www.cpqd.com.br/etics/simpletypes}string12" minOccurs="0"/&gt;
 *         &lt;element name="block" type="{http://www.cpqd.com.br/etics/simpletypes}string12" minOccurs="0"/&gt;
 *         &lt;element name="blockNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string35" minOccurs="0"/&gt;
 *         &lt;element name="zipCode" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="coordinateX" type="{http://www.cpqd.com.br/etics/simpletypes}GenericCoordType" minOccurs="0"/&gt;
 *         &lt;element name="coordinateY" type="{http://www.cpqd.com.br/etics/simpletypes}GenericCoordType" minOccurs="0"/&gt;
 *         &lt;element name="subUnit" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="characterist" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;pattern value="1|2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="type" type="{http://www.cpqd.com.br/etics/simpletypes}string03" minOccurs="0"/&gt;
 *                   &lt;element name="Value" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
    "siteCode",
    "cityCode",
    "streetCode",
    "streetType",
    "streetTitle",
    "streetName",
    "streetNumber",
    "crossingStreetCode",
    "block",
    "blockNumber",
    "zipCode",
    "coordinateX",
    "coordinateY",
    "subUnit"
})
public class Address {

    protected String siteCode;
    @XmlSchemaType(name = "integer")
    protected Integer cityCode;
    protected String streetCode;
    protected String streetType;
    protected String streetTitle;
    protected String streetName;
    protected String streetNumber;
    protected String crossingStreetCode;
    protected String block;
    protected String blockNumber;
    protected String zipCode;
    protected BigDecimal coordinateX;
    protected BigDecimal coordinateY;
    protected List<Address.SubUnit> subUnit;

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
     * Obtém o valor da propriedade cityCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCityCode() {
        return cityCode;
    }

    /**
     * Define o valor da propriedade cityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCityCode(Integer value) {
        this.cityCode = value;
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
     * Obtém o valor da propriedade streetNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Define o valor da propriedade streetNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumber(String value) {
        this.streetNumber = value;
    }

    /**
     * Obtém o valor da propriedade crossingStreetCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrossingStreetCode() {
        return crossingStreetCode;
    }

    /**
     * Define o valor da propriedade crossingStreetCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrossingStreetCode(String value) {
        this.crossingStreetCode = value;
    }

    /**
     * Obtém o valor da propriedade block.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlock() {
        return block;
    }

    /**
     * Define o valor da propriedade block.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlock(String value) {
        this.block = value;
    }

    /**
     * Obtém o valor da propriedade blockNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockNumber() {
        return blockNumber;
    }

    /**
     * Define o valor da propriedade blockNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockNumber(String value) {
        this.blockNumber = value;
    }

    /**
     * Obtém o valor da propriedade zipCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Define o valor da propriedade zipCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Obtém o valor da propriedade coordinateX.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCoordinateX() {
        return coordinateX;
    }

    /**
     * Define o valor da propriedade coordinateX.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCoordinateX(BigDecimal value) {
        this.coordinateX = value;
    }

    /**
     * Obtém o valor da propriedade coordinateY.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCoordinateY() {
        return coordinateY;
    }

    /**
     * Define o valor da propriedade coordinateY.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCoordinateY(BigDecimal value) {
        this.coordinateY = value;
    }

    /**
     * Gets the value of the subUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Address.SubUnit }
     * 
     * 
     */
    public List<Address.SubUnit> getSubUnit() {
        if (subUnit == null) {
            subUnit = new ArrayList<Address.SubUnit>();
        }
        return this.subUnit;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="characterist" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *               &lt;pattern value="1|2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="type" type="{http://www.cpqd.com.br/etics/simpletypes}string03" minOccurs="0"/&gt;
     *         &lt;element name="Value" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "characterist",
        "type",
        "value"
    })
    public static class SubUnit {

        protected BigInteger characterist;
        protected String type;
        @XmlElement(name = "Value")
        protected String value;

        /**
         * Obtém o valor da propriedade characterist.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCharacterist() {
            return characterist;
        }

        /**
         * Define o valor da propriedade characterist.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCharacterist(BigInteger value) {
            this.characterist = value;
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
         * Obtém o valor da propriedade value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Define o valor da propriedade value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

    }

}
