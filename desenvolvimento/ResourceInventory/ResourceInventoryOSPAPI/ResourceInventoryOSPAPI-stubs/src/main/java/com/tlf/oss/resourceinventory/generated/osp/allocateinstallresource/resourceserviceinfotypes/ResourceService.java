
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceserviceinfotypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ResourceService complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ResourceService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="regionCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer9" minOccurs="0"/&gt;
 *         &lt;element name="siteCode" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="identifier" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="portableIdentifier" type="{http://www.cpqd.com.br/etics/simpletypes}string60" minOccurs="0"/&gt;
 *         &lt;element name="portableType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}integer1"&gt;
 *               &lt;pattern value="0|1|2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="donateCompany" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="serviceClass" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceService", propOrder = {
    "regionCode",
    "siteCode",
    "identifier",
    "portableIdentifier",
    "portableType",
    "donateCompany",
    "serviceType",
    "serviceClass"
})
public class ResourceService {

    @XmlSchemaType(name = "integer")
    protected Integer regionCode;
    protected String siteCode;
    protected String identifier;
    protected String portableIdentifier;
    protected Integer portableType;
    protected String donateCompany;
    protected String serviceType;
    protected String serviceClass;

    /**
     * Obtém o valor da propriedade regionCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRegionCode() {
        return regionCode;
    }

    /**
     * Define o valor da propriedade regionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRegionCode(Integer value) {
        this.regionCode = value;
    }

    /**
     * Obtém o valor da propriedade siteCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteCode() {
        return siteCode;
    }

    /**
     * Define o valor da propriedade siteCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteCode(String value) {
        this.siteCode = value;
    }

    /**
     * Obtém o valor da propriedade identifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Define o valor da propriedade identifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Obtém o valor da propriedade portableIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortableIdentifier() {
        return portableIdentifier;
    }

    /**
     * Define o valor da propriedade portableIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortableIdentifier(String value) {
        this.portableIdentifier = value;
    }

    /**
     * Obtém o valor da propriedade portableType.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortableType() {
        return portableType;
    }

    /**
     * Define o valor da propriedade portableType.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortableType(Integer value) {
        this.portableType = value;
    }

    /**
     * Obtém o valor da propriedade donateCompany.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDonateCompany() {
        return donateCompany;
    }

    /**
     * Define o valor da propriedade donateCompany.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDonateCompany(String value) {
        this.donateCompany = value;
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
     * Obtém o valor da propriedade serviceClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceClass() {
        return serviceClass;
    }

    /**
     * Define o valor da propriedade serviceClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceClass(String value) {
        this.serviceClass = value;
    }

}
