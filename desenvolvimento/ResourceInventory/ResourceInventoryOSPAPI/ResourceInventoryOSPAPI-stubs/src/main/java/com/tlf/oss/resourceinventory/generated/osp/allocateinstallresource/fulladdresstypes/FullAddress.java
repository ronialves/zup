
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.fulladdresstypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.subunittypes.SubUnit;


/**
 * <p>Classe Java de FullAddress complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="FullAddress"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="streetType" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="streetTitle" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="streetName" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="streetCode" type="{http://www.cpqd.com.br/etics/simpletypes}string12" minOccurs="0"/&gt;
 *         &lt;element name="streetNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string35" minOccurs="0"/&gt;
 *         &lt;element name="addressComplement" type="{http://www.cpqd.com.br/etics/simpletypes}string45" minOccurs="0"/&gt;
 *         &lt;element name="subUnit" type="{http://www.cpqd.com.br/etics/SubUnitTypes}SubUnit" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="neighborhood" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="zipCode" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="city" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="stateAcronym" type="{http://www.cpqd.com.br/etics/simpletypes}string4" minOccurs="0"/&gt;
 *         &lt;element name="country" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="regionCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer9" minOccurs="0"/&gt;
 *         &lt;element name="crossingStreetCode" type="{http://www.cpqd.com.br/etics/simpletypes}string12" minOccurs="0"/&gt;
 *         &lt;element name="block" type="{http://www.cpqd.com.br/etics/simpletypes}string12" minOccurs="0"/&gt;
 *         &lt;element name="blockNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string35" minOccurs="0"/&gt;
 *         &lt;element name="coordinateX" type="{http://www.cpqd.com.br/etics/simpletypes}GenericCoordType" minOccurs="0"/&gt;
 *         &lt;element name="coordinateY" type="{http://www.cpqd.com.br/etics/simpletypes}GenericCoordType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullAddress", propOrder = {
    "streetType",
    "streetTitle",
    "streetName",
    "streetCode",
    "streetNumber",
    "addressComplement",
    "subUnit",
    "neighborhood",
    "zipCode",
    "city",
    "stateAcronym",
    "country",
    "regionCode",
    "crossingStreetCode",
    "block",
    "blockNumber",
    "coordinateX",
    "coordinateY"
})
public class FullAddress {

    protected String streetType;
    protected String streetTitle;
    protected String streetName;
    protected String streetCode;
    protected String streetNumber;
    protected String addressComplement;
    protected List<SubUnit> subUnit;
    protected String neighborhood;
    protected String zipCode;
    protected String city;
    protected String stateAcronym;
    protected String country;
    @XmlSchemaType(name = "integer")
    protected Integer regionCode;
    protected String crossingStreetCode;
    protected String block;
    protected String blockNumber;
    protected BigDecimal coordinateX;
    protected BigDecimal coordinateY;

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
     * Obtém o valor da propriedade addressComplement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressComplement() {
        return addressComplement;
    }

    /**
     * Define o valor da propriedade addressComplement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressComplement(String value) {
        this.addressComplement = value;
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
     * {@link SubUnit }
     * 
     * 
     */
    public List<SubUnit> getSubUnit() {
        if (subUnit == null) {
            subUnit = new ArrayList<SubUnit>();
        }
        return this.subUnit;
    }

    /**
     * Obtém o valor da propriedade neighborhood.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Define o valor da propriedade neighborhood.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeighborhood(String value) {
        this.neighborhood = value;
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
     * Obtém o valor da propriedade city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Define o valor da propriedade city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Obtém o valor da propriedade stateAcronym.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateAcronym() {
        return stateAcronym;
    }

    /**
     * Define o valor da propriedade stateAcronym.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateAcronym(String value) {
        this.stateAcronym = value;
    }

    /**
     * Obtém o valor da propriedade country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define o valor da propriedade country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

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

}
