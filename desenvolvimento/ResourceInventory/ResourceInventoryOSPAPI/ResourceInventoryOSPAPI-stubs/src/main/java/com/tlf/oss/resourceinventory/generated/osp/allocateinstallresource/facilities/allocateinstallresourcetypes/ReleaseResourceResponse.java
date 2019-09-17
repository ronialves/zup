
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuitrelatedresourcetypes.CircuitResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationreleasetypes.SupplementaryInformationOut;


/**
 * <p>Classe Java de ReleaseResourceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ReleaseResourceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="result" type="{http://www.cpqd.com.br/etics/provisiongtypes}ResultTypeWithErrorCode"/&gt;
 *         &lt;element name="informations" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="level"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;pattern value="1|2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="circuitType"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string30"&gt;
 *                         &lt;pattern value="1|2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="dedication" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;pattern value="0|1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="massive" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;pattern value="0|1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *                   &lt;element name="reserveOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
 *                   &lt;element name="transmissionUnits" type="{http://www.cpqd.com.br/etics/simpletypes}integer5"/&gt;
 *                   &lt;element name="statusNetwork"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *                         &lt;pattern value="0|1|2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="relatedCircuits" type="{http://www.cpqd.com.br/etics/CircuitRelatedResourceTypes}CircuitResource" minOccurs="0"/&gt;
 *                   &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationReleaseTypes}SupplementaryInformationOut" minOccurs="0"/&gt;
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
@XmlType(name = "ReleaseResourceResponse", propOrder = {
    "result",
    "informations"
})
public class ReleaseResourceResponse {

    @XmlElement(required = true)
    protected ResultTypeWithErrorCode result;
    protected List<ReleaseResourceResponse.Informations> informations;

    /**
     * Obtém o valor da propriedade result.
     * 
     * @return
     *     possible object is
     *     {@link ResultTypeWithErrorCode }
     *     
     */
    public ResultTypeWithErrorCode getResult() {
        return result;
    }

    /**
     * Define o valor da propriedade result.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultTypeWithErrorCode }
     *     
     */
    public void setResult(ResultTypeWithErrorCode value) {
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
     * {@link ReleaseResourceResponse.Informations }
     * 
     * 
     */
    public List<ReleaseResourceResponse.Informations> getInformations() {
        if (informations == null) {
            informations = new ArrayList<ReleaseResourceResponse.Informations>();
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
     *         &lt;element name="level"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *               &lt;pattern value="1|2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="circuitType"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string30"&gt;
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
     *         &lt;element name="massive" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *               &lt;pattern value="0|1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
     *         &lt;element name="reserveOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
     *         &lt;element name="transmissionUnits" type="{http://www.cpqd.com.br/etics/simpletypes}integer5"/&gt;
     *         &lt;element name="statusNetwork"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
     *               &lt;pattern value="0|1|2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="relatedCircuits" type="{http://www.cpqd.com.br/etics/CircuitRelatedResourceTypes}CircuitResource" minOccurs="0"/&gt;
     *         &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationReleaseTypes}SupplementaryInformationOut" minOccurs="0"/&gt;
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
        "level",
        "circuitType",
        "dedication",
        "massive",
        "resourceOrder",
        "reserveOrder",
        "transmissionUnits",
        "statusNetwork",
        "relatedCircuits",
        "supplementaryInformation"
    })
    public static class Informations {

        @XmlElement(required = true)
        protected BigInteger level;
        @XmlElement(required = true)
        protected String circuitType;
        protected BigInteger dedication;
        protected BigInteger massive;
        protected String resourceOrder;
        protected String reserveOrder;
        @XmlSchemaType(name = "integer")
        protected int transmissionUnits;
        @XmlElement(required = true, defaultValue = "0")
        protected String statusNetwork;
        protected CircuitResource relatedCircuits;
        protected SupplementaryInformationOut supplementaryInformation;

        /**
         * Obtém o valor da propriedade level.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getLevel() {
            return level;
        }

        /**
         * Define o valor da propriedade level.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setLevel(BigInteger value) {
            this.level = value;
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
         * Obtém o valor da propriedade massive.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMassive() {
            return massive;
        }

        /**
         * Define o valor da propriedade massive.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMassive(BigInteger value) {
            this.massive = value;
        }

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
         * Obtém o valor da propriedade transmissionUnits.
         * 
         */
        public int getTransmissionUnits() {
            return transmissionUnits;
        }

        /**
         * Define o valor da propriedade transmissionUnits.
         * 
         */
        public void setTransmissionUnits(int value) {
            this.transmissionUnits = value;
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
         * Obtém o valor da propriedade relatedCircuits.
         * 
         * @return
         *     possible object is
         *     {@link CircuitResource }
         *     
         */
        public CircuitResource getRelatedCircuits() {
            return relatedCircuits;
        }

        /**
         * Define o valor da propriedade relatedCircuits.
         * 
         * @param value
         *     allowed object is
         *     {@link CircuitResource }
         *     
         */
        public void setRelatedCircuits(CircuitResource value) {
            this.relatedCircuits = value;
        }

        /**
         * Obtém o valor da propriedade supplementaryInformation.
         * 
         * @return
         *     possible object is
         *     {@link SupplementaryInformationOut }
         *     
         */
        public SupplementaryInformationOut getSupplementaryInformation() {
            return supplementaryInformation;
        }

        /**
         * Define o valor da propriedade supplementaryInformation.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplementaryInformationOut }
         *     
         */
        public void setSupplementaryInformation(SupplementaryInformationOut value) {
            this.supplementaryInformation = value;
        }

    }

}
