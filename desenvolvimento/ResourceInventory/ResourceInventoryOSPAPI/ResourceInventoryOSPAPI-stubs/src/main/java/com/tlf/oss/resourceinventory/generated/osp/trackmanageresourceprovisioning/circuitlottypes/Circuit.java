
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.circuitlottypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.customerresourcetypes.CustomerResource;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.intermediaryresourcetypes.IntermediaryResource;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.lotyypes.Lot;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.terminalresourcetypes.TerminalResource;


/**
 * <p>Classe Java de Circuit complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Circuit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="circuitIdentifier" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
 *         &lt;element name="circuitStatus"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1|3"/&gt;
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
 *         &lt;element name="lot" type="{http://www.cpqd.com.br/etics/LotTypes}Lot" minOccurs="0"/&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Circuit", propOrder = {
    "circuitIdentifier",
    "circuitStatus",
    "characteristic",
    "lot",
    "resources"
})
public class Circuit {

    @XmlElement(required = true)
    protected String circuitIdentifier;
    @XmlElement(required = true, defaultValue = "1")
    protected BigInteger circuitStatus;
    @XmlElement(defaultValue = "0")
    protected String characteristic;
    protected Lot lot;
    protected Circuit.Resources resources;

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
     * Obtém o valor da propriedade lot.
     * 
     * @return
     *     possible object is
     *     {@link Lot }
     *     
     */
    public Lot getLot() {
        return lot;
    }

    /**
     * Define o valor da propriedade lot.
     * 
     * @param value
     *     allowed object is
     *     {@link Lot }
     *     
     */
    public void setLot(Lot value) {
        this.lot = value;
    }

    /**
     * Obtém o valor da propriedade resources.
     * 
     * @return
     *     possible object is
     *     {@link Circuit.Resources }
     *     
     */
    public Circuit.Resources getResources() {
        return resources;
    }

    /**
     * Define o valor da propriedade resources.
     * 
     * @param value
     *     allowed object is
     *     {@link Circuit.Resources }
     *     
     */
    public void setResources(Circuit.Resources value) {
        this.resources = value;
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
