
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.customertypes.Customer;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.servicetypes.Service;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.supplementaryinformationreporttypes.SupplementaryInformationIn;


/**
 * <p>Classe Java de ReportResourceProvisioningRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ReportResourceProvisioningRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="reserveOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
 *         &lt;element name="circuitId" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="circuitType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string30"&gt;
 *               &lt;pattern value="1|2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="circuitStatus" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1|2|3|4|5|7|8|9|10|11|12"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="category" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *               &lt;pattern value="0|2|3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="service" type="{http://www.cpqd.com.br/etics/ServiceTypes}Service" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
 *         &lt;element name="customer" type="{http://www.cpqd.com.br/etics/CustomerTypes}Customer" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationReportTypes}SupplementaryInformationIn" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportResourceProvisioningRequest", propOrder = {
    "resourceOrder",
    "reserveOrder",
    "circuitId",
    "circuitType",
    "circuitStatus",
    "category",
    "service",
    "address",
    "customer",
    "supplementaryInformation"
})
public class ReportResourceProvisioningRequest {

    protected String resourceOrder;
    protected String reserveOrder;
    protected String circuitId;
    protected String circuitType;
    protected BigInteger circuitStatus;
    @XmlElement(defaultValue = "0")
    protected String category;
    protected Service service;
    protected Address address;
    protected Customer customer;
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
     * Obtém o valor da propriedade circuitStatus.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCircuitStatus() {
        return circuitStatus;
    }

    /**
     * Define o valor da propriedade circuitStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCircuitStatus(BigInteger value) {
        this.circuitStatus = value;
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
     * Obtém o valor da propriedade service.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getService() {
        return service;
    }

    /**
     * Define o valor da propriedade service.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setService(Service value) {
        this.service = value;
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
     * Obtém o valor da propriedade customer.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Define o valor da propriedade customer.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
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
