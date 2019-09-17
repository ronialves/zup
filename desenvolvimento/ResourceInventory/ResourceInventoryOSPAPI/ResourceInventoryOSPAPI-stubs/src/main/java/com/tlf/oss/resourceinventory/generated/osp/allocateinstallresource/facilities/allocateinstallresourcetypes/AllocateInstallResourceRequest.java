
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.addresstypes.Address;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationallocatetypes.SupplementaryInformationIn;


/**
 * <p>Classe Java de AllocateInstallResourceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AllocateInstallResourceRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="reserveOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
 *         &lt;element name="circuitType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string30"&gt;
 *               &lt;pattern value="1|2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="transmissionUnits" type="{http://www.cpqd.com.br/etics/simpletypes}integer5" minOccurs="0"/&gt;
 *         &lt;element name="dedication" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="category" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *               &lt;pattern value="0|2|3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="circuitId" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="mainCircuitId" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="returnCircuitIdOnly" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="address" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationAllocateTypes}SupplementaryInformationIn" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllocateInstallResourceRequest", propOrder = {
    "resourceOrder",
    "reserveOrder",
    "circuitType",
    "transmissionUnits",
    "dedication",
    "serviceType",
    "category",
    "circuitId",
    "mainCircuitId",
    "returnCircuitIdOnly",
    "address",
    "supplementaryInformation"
})
public class AllocateInstallResourceRequest {

    protected String resourceOrder;
    protected String reserveOrder;
    protected String circuitType;
    @XmlElement(defaultValue = "1")
    @XmlSchemaType(name = "integer")
    protected Integer transmissionUnits;
    @XmlElement(defaultValue = "1")
    protected BigInteger dedication;
    protected String serviceType;
    @XmlElement(defaultValue = "0")
    protected String category;
    protected String circuitId;
    protected String mainCircuitId;
    @XmlElement(defaultValue = "0")
    protected BigInteger returnCircuitIdOnly;
    protected Address address;
    protected SupplementaryInformationIn supplementaryInformation;

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
     * Obtém o valor da propriedade reserveOrder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserveOrder() {
        return reserveOrder;
    }

    /**
     * Define o valor da propriedade reserveOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserveOrder(String value) {
        this.reserveOrder = value;
    }

    /**
     * Obtém o valor da propriedade circuitType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircuitType() {
        return circuitType;
    }

    /**
     * Define o valor da propriedade circuitType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircuitType(String value) {
        this.circuitType = value;
    }

    /**
     * Obtém o valor da propriedade transmissionUnits.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTransmissionUnits() {
        return transmissionUnits;
    }

    /**
     * Define o valor da propriedade transmissionUnits.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTransmissionUnits(Integer value) {
        this.transmissionUnits = value;
    }

    /**
     * Obtém o valor da propriedade dedication.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDedication() {
        return dedication;
    }

    /**
     * Define o valor da propriedade dedication.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDedication(BigInteger value) {
        this.dedication = value;
    }

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
     * Obtém o valor da propriedade category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Define o valor da propriedade category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Obtém o valor da propriedade circuitId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircuitId() {
        return circuitId;
    }

    /**
     * Define o valor da propriedade circuitId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircuitId(String value) {
        this.circuitId = value;
    }

    /**
     * Obtém o valor da propriedade mainCircuitId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainCircuitId() {
        return mainCircuitId;
    }

    /**
     * Define o valor da propriedade mainCircuitId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainCircuitId(String value) {
        this.mainCircuitId = value;
    }

    /**
     * Obtém o valor da propriedade returnCircuitIdOnly.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReturnCircuitIdOnly() {
        return returnCircuitIdOnly;
    }

    /**
     * Define o valor da propriedade returnCircuitIdOnly.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReturnCircuitIdOnly(BigInteger value) {
        this.returnCircuitIdOnly = value;
    }

    /**
     * Obtém o valor da propriedade address.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Define o valor da propriedade address.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Obtém o valor da propriedade supplementaryInformation.
     * 
     * @return
     *     possible object is
     *     {@link SupplementaryInformationIn }
     *     
     */
    public SupplementaryInformationIn getSupplementaryInformation() {
        return supplementaryInformation;
    }

    /**
     * Define o valor da propriedade supplementaryInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementaryInformationIn }
     *     
     */
    public void setSupplementaryInformation(SupplementaryInformationIn value) {
        this.supplementaryInformation = value;
    }

}
