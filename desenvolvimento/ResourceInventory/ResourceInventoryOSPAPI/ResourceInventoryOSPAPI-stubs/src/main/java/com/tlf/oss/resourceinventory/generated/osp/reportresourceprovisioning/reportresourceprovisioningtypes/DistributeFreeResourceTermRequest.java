
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.reportresourceprovisioningtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcetypes.Resource;


/**
 * <p>Classe Java de DistributeFreeResourceTermRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DistributeFreeResourceTermRequest"&gt;
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
 *         &lt;element name="serviceNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="queryType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *               &lt;pattern value="1|2|3|4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Resource" type="{http://www.cpqd.com.br/etics/ResourceTypes}Resource" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributeFreeResourceTermRequest", propOrder = {
    "resourceOrder",
    "circuitType",
    "circuitIdentifier",
    "serviceNumber",
    "queryType",
    "resource"
})
public class DistributeFreeResourceTermRequest {

    protected String resourceOrder;
    @XmlElement(required = true)
    protected String circuitType;
    protected String circuitIdentifier;
    protected String serviceNumber;
    protected String queryType;
    @XmlElement(name = "Resource")
    protected Resource resource;

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
     * Obtém o valor da propriedade queryType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryType() {
        return queryType;
    }

    /**
     * Define o valor da propriedade queryType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryType(String value) {
        this.queryType = value;
    }

    /**
     * Obtém o valor da propriedade resource.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Define o valor da propriedade resource.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setResource(Resource value) {
        this.resource = value;
    }

}
