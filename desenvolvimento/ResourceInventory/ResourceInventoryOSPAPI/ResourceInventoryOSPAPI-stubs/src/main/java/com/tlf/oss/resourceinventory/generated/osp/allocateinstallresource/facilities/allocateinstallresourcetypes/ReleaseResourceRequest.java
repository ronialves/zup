
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationreleasetypes.SupplementaryInformationIn;


/**
 * <p>Classe Java de ReleaseResourceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ReleaseResourceRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40"/&gt;
 *         &lt;element name="circuitId" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
 *         &lt;element name="removeAssocCircuit" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
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
 *         &lt;element name="characteristic" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *               &lt;pattern value="0|2|3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationReleaseTypes}SupplementaryInformationIn" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReleaseResourceRequest", propOrder = {
    "resourceOrder",
    "circuitId",
    "removeAssocCircuit",
    "dedication",
    "characteristic",
    "supplementaryInformation"
})
public class ReleaseResourceRequest {

    @XmlElement(required = true)
    protected String resourceOrder;
    @XmlElement(required = true)
    protected String circuitId;
    @XmlElement(defaultValue = "1")
    protected BigInteger removeAssocCircuit;
    @XmlElement(defaultValue = "1")
    protected BigInteger dedication;
    @XmlElement(defaultValue = "0")
    protected String characteristic;
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
     * Obtém o valor da propriedade removeAssocCircuit.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRemoveAssocCircuit() {
        return removeAssocCircuit;
    }

    /**
     * Define o valor da propriedade removeAssocCircuit.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRemoveAssocCircuit(BigInteger value) {
        this.removeAssocCircuit = value;
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
