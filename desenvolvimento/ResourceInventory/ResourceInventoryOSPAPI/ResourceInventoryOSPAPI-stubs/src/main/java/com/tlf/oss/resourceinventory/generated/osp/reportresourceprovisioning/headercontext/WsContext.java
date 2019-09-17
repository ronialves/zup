
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.headercontext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de wsContext complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="wsContext"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="regionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="centralOffice" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsContext", propOrder = {
    "regionCode",
    "centralOffice"
})
public class WsContext {

    @XmlElement(required = true)
    protected String regionCode;
    @XmlElement(required = true)
    protected String centralOffice;

    /**
     * Obtém o valor da propriedade regionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * Define o valor da propriedade regionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionCode(String value) {
        this.regionCode = value;
    }

    /**
     * Obtém o valor da propriedade centralOffice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentralOffice() {
        return centralOffice;
    }

    /**
     * Define o valor da propriedade centralOffice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentralOffice(String value) {
        this.centralOffice = value;
    }

}
