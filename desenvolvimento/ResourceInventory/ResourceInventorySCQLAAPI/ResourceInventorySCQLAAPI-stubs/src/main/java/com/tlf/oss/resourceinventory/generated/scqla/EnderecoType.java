
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de enderecoType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="enderecoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cnl" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="at" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="complementoEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enderecoType", propOrder = {
    "codigoLogradouro",
    "cnl",
    "numeroLogradouro",
    "at",
    "complementoEndereco"
})
public class EnderecoType {

    @XmlElement(required = true)
    protected String codigoLogradouro;
    protected int cnl;
    @XmlElement(required = true)
    protected String numeroLogradouro;
    @XmlElement(required = true)
    protected String at;
    protected String complementoEndereco;

    /**
     * Obtém o valor da propriedade codigoLogradouro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoLogradouro() {
        return codigoLogradouro;
    }

    /**
     * Define o valor da propriedade codigoLogradouro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoLogradouro(String value) {
        this.codigoLogradouro = value;
    }

    /**
     * Obtém o valor da propriedade cnl.
     * 
     */
    public int getCnl() {
        return cnl;
    }

    /**
     * Define o valor da propriedade cnl.
     * 
     */
    public void setCnl(int value) {
        this.cnl = value;
    }

    /**
     * Obtém o valor da propriedade numeroLogradouro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    /**
     * Define o valor da propriedade numeroLogradouro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroLogradouro(String value) {
        this.numeroLogradouro = value;
    }

    /**
     * Obtém o valor da propriedade at.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAt() {
        return at;
    }

    /**
     * Define o valor da propriedade at.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAt(String value) {
        this.at = value;
    }

    /**
     * Obtém o valor da propriedade complementoEndereco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    /**
     * Define o valor da propriedade complementoEndereco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplementoEndereco(String value) {
        this.complementoEndereco = value;
    }

}
