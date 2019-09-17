
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceaditionalservicetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ResourceAditionalService complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ResourceAditionalService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="wideBandfeature" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="speed" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceAditionalService", propOrder = {
    "type",
    "wideBandfeature",
    "speed"
})
public class ResourceAditionalService {

    protected String type;
    protected String wideBandfeature;
    protected String speed;

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade wideBandfeature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWideBandfeature() {
        return wideBandfeature;
    }

    /**
     * Define o valor da propriedade wideBandfeature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWideBandfeature(String value) {
        this.wideBandfeature = value;
    }

    /**
     * Obtém o valor da propriedade speed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * Define o valor da propriedade speed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpeed(String value) {
        this.speed = value;
    }

}
