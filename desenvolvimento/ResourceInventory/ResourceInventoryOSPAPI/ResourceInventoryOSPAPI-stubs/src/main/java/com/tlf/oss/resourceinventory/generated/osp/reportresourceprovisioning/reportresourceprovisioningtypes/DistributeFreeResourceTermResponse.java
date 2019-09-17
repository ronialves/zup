
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.customerresourcetypes.CustomAvailableResources;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes.ResultType;


/**
 * <p>Classe Java de DistributeFreeResourceTermResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DistributeFreeResourceTermResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="result" type="{http://www.cpqd.com.br/etics/provisiongtypes}ResultType"/&gt;
 *         &lt;element name="informations" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *                   &lt;element name="circuitType"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string30"&gt;
 *                         &lt;pattern value="1|2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="circuitIdentifier" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *                   &lt;element name="statusNetwork"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *                         &lt;pattern value="0|1|2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="serviceNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *                   &lt;element name="address" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
 *                   &lt;element name="resources" type="{http://www.cpqd.com.br/etics/CustomerResourceTypes}CustomAvailableResources" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DistributeFreeResourceTermResponse", propOrder = {
    "result",
    "informations"
})
public class DistributeFreeResourceTermResponse {

    @XmlElement(required = true)
    protected ResultType result;
    protected List<DistributeFreeResourceTermResponse.Informations> informations;

    /**
     * Obtém o valor da propriedade result.
     * 
     * @return
     *     possible object is
     *     {@link ResultType }
     *     
     */
    public ResultType getResult() {
        return result;
    }

    /**
     * Define o valor da propriedade result.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *     
     */
    public void setResult(ResultType value) {
        this.result = value;
    }

    /**
     * Gets the value of the informations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributeFreeResourceTermResponse.Informations }
     * 
     * 
     */
    public List<DistributeFreeResourceTermResponse.Informations> getInformations() {
        if (informations == null) {
            informations = new ArrayList<DistributeFreeResourceTermResponse.Informations>();
        }
        return this.informations;
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
     *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
     *         &lt;element name="circuitType"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string30"&gt;
     *               &lt;pattern value="1|2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="circuitIdentifier" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
     *         &lt;element name="statusNetwork"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
     *               &lt;pattern value="0|1|2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="serviceNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
     *         &lt;element name="address" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
     *         &lt;element name="resources" type="{http://www.cpqd.com.br/etics/CustomerResourceTypes}CustomAvailableResources" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "resourceOrder",
        "circuitType",
        "circuitIdentifier",
        "statusNetwork",
        "serviceNumber",
        "address",
        "resources"
    })
    public static class Informations {

        protected String resourceOrder;
        @XmlElement(required = true)
        protected String circuitType;
        protected String circuitIdentifier;
        @XmlElement(required = true, defaultValue = "0")
        protected String statusNetwork;
        protected String serviceNumber;
        protected Address address;
        protected List<CustomAvailableResources> resources;

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
         * Obtém o valor da propriedade statusNetwork.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatusNetwork() {
            return statusNetwork;
        }

        /**
         * Define o valor da propriedade statusNetwork.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatusNetwork(String value) {
            this.statusNetwork = value;
        }

        /**
         * Obtém o valor da propriedade serviceNumber.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceNumber() {
            return serviceNumber;
        }

        /**
         * Define o valor da propriedade serviceNumber.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceNumber(String value) {
            this.serviceNumber = value;
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
         * Gets the value of the resources property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resources property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResources().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CustomAvailableResources }
         * 
         * 
         */
        public List<CustomAvailableResources> getResources() {
            if (resources == null) {
                resources = new ArrayList<CustomAvailableResources>();
            }
            return this.resources;
        }

    }

}
