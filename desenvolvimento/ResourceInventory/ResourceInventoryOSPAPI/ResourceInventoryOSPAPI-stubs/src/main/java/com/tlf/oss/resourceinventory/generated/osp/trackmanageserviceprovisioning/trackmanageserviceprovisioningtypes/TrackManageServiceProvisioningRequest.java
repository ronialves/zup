
package com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.trackmanageserviceprovisioningtypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.customertypes.Customer;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.resourceservicetypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.servicetypes.ServiceServiceType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageserviceprovisioning.supplementaryinformationmanageservtypes.SupplementaryInformationIn;


/**
 * <p>Classe Java de TrackManageServiceProvisioningRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TrackManageServiceProvisioningRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="circuitId" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="operation" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1|2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dedication" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="service" type="{http://www.cpqd.com.br/etics/ServiceTypes}ServiceServiceType"/&gt;
 *         &lt;element name="customer" type="{http://www.cpqd.com.br/etics/CustomerTypes}Customer" minOccurs="0"/&gt;
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationManageServTypes}SupplementaryInformationIn" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackManageServiceProvisioningRequest", propOrder = {
    "resourceOrder",
    "circuitId",
    "operation",
    "dedication",
    "service",
    "customer",
    "resourceService",
    "supplementaryInformation"
})
public class TrackManageServiceProvisioningRequest {

    protected String resourceOrder;
    protected String circuitId;
    @XmlElement(defaultValue = "1")
    protected BigInteger operation;
    @XmlElement(defaultValue = "1")
    protected BigInteger dedication;
    @XmlElement(required = true)
    protected ServiceServiceType service;
    protected Customer customer;
    protected ResourceService resourceService;
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
     * Obtém o valor da propriedade operation.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOperation() {
        return operation;
    }

    /**
     * Define o valor da propriedade operation.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOperation(BigInteger value) {
        this.operation = value;
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
     * Obtém o valor da propriedade service.
     * 
     * @return
     *     possible object is
     *     {@link ServiceServiceType }
     *     
     */
    public ServiceServiceType getService() {
        return service;
    }

    /**
     * Define o valor da propriedade service.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceServiceType }
     *     
     */
    public void setService(ServiceServiceType value) {
        this.service = value;
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
     * Obtém o valor da propriedade resourceService.
     * 
     * @return
     *     possible object is
     *     {@link ResourceService }
     *     
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Define o valor da propriedade resourceService.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceService }
     *     
     */
    public void setResourceService(ResourceService value) {
        this.resourceService = value;
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
