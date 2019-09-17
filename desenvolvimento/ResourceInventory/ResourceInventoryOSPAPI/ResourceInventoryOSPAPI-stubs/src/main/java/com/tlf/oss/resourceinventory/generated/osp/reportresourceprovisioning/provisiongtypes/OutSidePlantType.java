
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de OutSidePlantType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="OutSidePlantType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Site" type="{http://www.cpqd.com.br/etics/provisiongtypes}SiteType" minOccurs="0"/&gt;
 *         &lt;element name="XBox" type="{http://www.cpqd.com.br/etics/provisiongtypes}XBoxType" minOccurs="0"/&gt;
 *         &lt;element name="Feeder" type="{http://www.cpqd.com.br/etics/provisiongtypes}CableType" minOccurs="0"/&gt;
 *         &lt;element name="TerminalBox" type="{http://www.cpqd.com.br/etics/provisiongtypes}TerminalBoxType" minOccurs="0"/&gt;
 *         &lt;element name="Distribution" type="{http://www.cpqd.com.br/etics/provisiongtypes}CableType" minOccurs="0"/&gt;
 *         &lt;element name="Latitude" type="{http://www.cpqd.com.br/etics/simpletypes}CoordinateType" minOccurs="0"/&gt;
 *         &lt;element name="Longitude" type="{http://www.cpqd.com.br/etics/simpletypes}CoordinateType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutSidePlantType", propOrder = {
    "site",
    "xBox",
    "feeder",
    "terminalBox",
    "distribution",
    "latitude",
    "longitude"
})
public class OutSidePlantType {

    @XmlElement(name = "Site")
    protected SiteType site;
    @XmlElement(name = "XBox")
    protected XBoxType xBox;
    @XmlElement(name = "Feeder")
    protected CableType feeder;
    @XmlElement(name = "TerminalBox")
    protected TerminalBoxType terminalBox;
    @XmlElement(name = "Distribution")
    protected CableType distribution;
    @XmlElement(name = "Latitude")
    protected BigDecimal latitude;
    @XmlElement(name = "Longitude")
    protected BigDecimal longitude;

    /**
     * Obtém o valor da propriedade site.
     * 
     * @return
     *     possible object is
     *     {@link SiteType }
     *     
     */
    public SiteType getSite() {
        return site;
    }

    /**
     * Define o valor da propriedade site.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteType }
     *     
     */
    public void setSite(SiteType value) {
        this.site = value;
    }

    /**
     * Obtém o valor da propriedade xBox.
     * 
     * @return
     *     possible object is
     *     {@link XBoxType }
     *     
     */
    public XBoxType getXBox() {
        return xBox;
    }

    /**
     * Define o valor da propriedade xBox.
     * 
     * @param value
     *     allowed object is
     *     {@link XBoxType }
     *     
     */
    public void setXBox(XBoxType value) {
        this.xBox = value;
    }

    /**
     * Obtém o valor da propriedade feeder.
     * 
     * @return
     *     possible object is
     *     {@link CableType }
     *     
     */
    public CableType getFeeder() {
        return feeder;
    }

    /**
     * Define o valor da propriedade feeder.
     * 
     * @param value
     *     allowed object is
     *     {@link CableType }
     *     
     */
    public void setFeeder(CableType value) {
        this.feeder = value;
    }

    /**
     * Obtém o valor da propriedade terminalBox.
     * 
     * @return
     *     possible object is
     *     {@link TerminalBoxType }
     *     
     */
    public TerminalBoxType getTerminalBox() {
        return terminalBox;
    }

    /**
     * Define o valor da propriedade terminalBox.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalBoxType }
     *     
     */
    public void setTerminalBox(TerminalBoxType value) {
        this.terminalBox = value;
    }

    /**
     * Obtém o valor da propriedade distribution.
     * 
     * @return
     *     possible object is
     *     {@link CableType }
     *     
     */
    public CableType getDistribution() {
        return distribution;
    }

    /**
     * Define o valor da propriedade distribution.
     * 
     * @param value
     *     allowed object is
     *     {@link CableType }
     *     
     */
    public void setDistribution(CableType value) {
        this.distribution = value;
    }

    /**
     * Obtém o valor da propriedade latitude.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Define o valor da propriedade latitude.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLatitude(BigDecimal value) {
        this.latitude = value;
    }

    /**
     * Obtém o valor da propriedade longitude.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Define o valor da propriedade longitude.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongitude(BigDecimal value) {
        this.longitude = value;
    }

}
