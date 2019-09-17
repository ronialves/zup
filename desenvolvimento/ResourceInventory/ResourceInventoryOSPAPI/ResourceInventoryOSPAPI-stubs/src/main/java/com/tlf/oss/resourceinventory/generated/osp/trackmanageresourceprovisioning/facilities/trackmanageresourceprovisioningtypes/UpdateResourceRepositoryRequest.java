
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceservicetypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.supplementaryinformationbdtypes.SupplementaryInformationIn;


/**
 * <p>Classe Java de UpdateResourceRepositoryRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="UpdateResourceRepositoryRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="circuitId" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="operation"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1|2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationBDTypes}SupplementaryInformationIn" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateResourceRepositoryRequest", propOrder = {
    "resourceOrder",
    "circuitId",
    "operation",
    "resourceService",
    "supplementaryInformation"
})
public class UpdateResourceRepositoryRequest {

    protected String resourceOrder;
    protected String circuitId;
    @XmlElement(required = true)
    protected BigInteger operation;
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
