
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tvaType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tvaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cabo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estrutura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="efm" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tvaType", propOrder = {
    "cabo",
    "estrutura",
    "efm"
})
public class TvaType {

    protected String cabo;
    protected String estrutura;
    protected Integer efm;

    /**
     * Obtém o valor da propriedade cabo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabo() {
        return cabo;
    }

    /**
     * Define o valor da propriedade cabo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabo(String value) {
        this.cabo = value;
    }

    /**
     * Obtém o valor da propriedade estrutura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstrutura() {
        return estrutura;
    }

    /**
     * Define o valor da propriedade estrutura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstrutura(String value) {
        this.estrutura = value;
    }

    /**
     * Obtém o valor da propriedade efm.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEfm() {
        return efm;
    }

    /**
     * Define o valor da propriedade efm.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEfm(Integer value) {
        this.efm = value;
    }

}
