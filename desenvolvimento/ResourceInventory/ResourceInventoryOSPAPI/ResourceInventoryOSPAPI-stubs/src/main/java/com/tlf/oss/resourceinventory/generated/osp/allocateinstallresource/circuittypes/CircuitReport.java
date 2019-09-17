
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuittypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.addresstypes.Address;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.customerresourcetypes.CustomerResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.intermediaryresourcetypes.IntermediaryResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.servicecustomertypes.ServiceCustomer;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.terminalresourcetypes.TerminalResource;


/**
 * <p>Classe Java de CircuitReport complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CircuitReport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="circuitIdentifier" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
 *         &lt;element name="circuitStatus"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1|2|3|4|5|7|8|9|10|11|12"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="characteristic" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *               &lt;pattern value="0|2|3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="address" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
 *         &lt;element name="resources" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="relatedInicialResources" type="{http://www.cpqd.com.br/etics/InicialResourceTypes}InicialResource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="relatedIntermediaryResources" type="{http://www.cpqd.com.br/etics/IntermediaryResourceTypes}IntermediaryResource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="relatedTerminalResources" type="{http://www.cpqd.com.br/etics/TerminalResourceTypes}TerminalResource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="relatedAditionalResources" type="{http://www.cpqd.com.br/etics/CustomerResourceTypes}CustomerResource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="relatedServices" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="service" type="{http://www.cpqd.com.br/etics/ServiceCustomerTypes}ServiceCustomer" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CircuitReport", propOrder = {
    "circuitIdentifier",
    "circuitStatus",
    "characteristic",
    "address",
    "resources",
    "relatedServices"
})
public class CircuitReport {

    @XmlElement(required = true)
    protected String circuitIdentifier;
    @XmlElement(required = true)
    protected BigInteger circuitStatus;
    @XmlElement(defaultValue = "0")
    protected String characteristic;
    protected Address address;
    protected CircuitReport.Resources resources;
    protected CircuitReport.RelatedServices relatedServices;

    /**
     * Obtém o valor da propriedade circuitIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircuitIdentifier() {
        return circuitIdentifier;
    }

    /**
     * Define o valor da propriedade circuitIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircuitIdentifier(String value) {
        this.circuitIdentifier = value;
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
     * Obtém o valor da propriedade characteristic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * Define o valor da propriedade characteristic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristic(String value) {
        this.characteristic = value;
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
     * Obtém o valor da propriedade resources.
     * 
     * @return
     *     possible object is
     *     {@link CircuitReport.Resources }
     *     
     */
    public CircuitReport.Resources getResources() {
        return resources;
    }

    /**
     * Define o valor da propriedade resources.
     * 
     * @param value
     *     allowed object is
     *     {@link CircuitReport.Resources }
     *     
     */
    public void setResources(CircuitReport.Resources value) {
        this.resources = value;
    }

    /**
     * Obtém o valor da propriedade relatedServices.
     * 
     * @return
     *     possible object is
     *     {@link CircuitReport.RelatedServices }
     *     
     */
    public CircuitReport.RelatedServices getRelatedServices() {
        return relatedServices;
    }

    /**
     * Define o valor da propriedade relatedServices.
     * 
     * @param value
     *     allowed object is
     *     {@link CircuitReport.RelatedServices }
     *     
     */
    public void setRelatedServices(CircuitReport.RelatedServices value) {
        this.relatedServices = value;
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
     *         &lt;element name="service" type="{http://www.cpqd.com.br/etics/ServiceCustomerTypes}ServiceCustomer" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "service"
    })
    public static class RelatedServices {

        protected List<ServiceCustomer> service;

        /**
         * Gets the value of the service property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the service property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ServiceCustomer }
         * 
         * 
         */
        public List<ServiceCustomer> getService() {
            if (service == null) {
                service = new ArrayList<ServiceCustomer>();
            }
            return this.service;
        }

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
     *         &lt;element name="relatedInicialResources" type="{http://www.cpqd.com.br/etics/InicialResourceTypes}InicialResource" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="relatedIntermediaryResources" type="{http://www.cpqd.com.br/etics/IntermediaryResourceTypes}IntermediaryResource" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="relatedTerminalResources" type="{http://www.cpqd.com.br/etics/TerminalResourceTypes}TerminalResource" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="relatedAditionalResources" type="{http://www.cpqd.com.br/etics/CustomerResourceTypes}CustomerResource" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "relatedInicialResources",
        "relatedIntermediaryResources",
        "relatedTerminalResources",
        "relatedAditionalResources"
    })
    public static class Resources {

        protected List<InicialResource> relatedInicialResources;
        protected List<IntermediaryResource> relatedIntermediaryResources;
        protected List<TerminalResource> relatedTerminalResources;
        protected List<CustomerResource> relatedAditionalResources;

        /**
         * Gets the value of the relatedInicialResources property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relatedInicialResources property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelatedInicialResources().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InicialResource }
         * 
         * 
         */
        public List<InicialResource> getRelatedInicialResources() {
            if (relatedInicialResources == null) {
                relatedInicialResources = new ArrayList<InicialResource>();
            }
            return this.relatedInicialResources;
        }

        /**
         * Gets the value of the relatedIntermediaryResources property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relatedIntermediaryResources property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelatedIntermediaryResources().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IntermediaryResource }
         * 
         * 
         */
        public List<IntermediaryResource> getRelatedIntermediaryResources() {
            if (relatedIntermediaryResources == null) {
                relatedIntermediaryResources = new ArrayList<IntermediaryResource>();
            }
            return this.relatedIntermediaryResources;
        }

        /**
         * Gets the value of the relatedTerminalResources property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relatedTerminalResources property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelatedTerminalResources().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TerminalResource }
         * 
         * 
         */
        public List<TerminalResource> getRelatedTerminalResources() {
            if (relatedTerminalResources == null) {
                relatedTerminalResources = new ArrayList<TerminalResource>();
            }
            return this.relatedTerminalResources;
        }

        /**
         * Gets the value of the relatedAditionalResources property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relatedAditionalResources property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelatedAditionalResources().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CustomerResource }
         * 
         * 
         */
        public List<CustomerResource> getRelatedAditionalResources() {
            if (relatedAditionalResources == null) {
                relatedAditionalResources = new ArrayList<CustomerResource>();
            }
            return this.relatedAditionalResources;
        }

    }

}
