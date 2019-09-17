
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de complementoHorizontalType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="complementoHorizontalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valor1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valor2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valor3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complementoHorizontalType", propOrder = {
    "tipo1",
    "valor1",
    "tipo2",
    "valor2",
    "tipo3",
    "valor3"
})
public class ComplementoHorizontalType {

    protected String tipo1;
    protected String valor1;
    protected String tipo2;
    protected String valor2;
    protected String tipo3;
    protected String valor3;

    /**
     * Obtém o valor da propriedade tipo1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo1() {
        return tipo1;
    }

    /**
     * Define o valor da propriedade tipo1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo1(String value) {
        this.tipo1 = value;
    }

    /**
     * Obtém o valor da propriedade valor1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor1() {
        return valor1;
    }

    /**
     * Define o valor da propriedade valor1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor1(String value) {
        this.valor1 = value;
    }

    /**
     * Obtém o valor da propriedade tipo2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo2() {
        return tipo2;
    }

    /**
     * Define o valor da propriedade tipo2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo2(String value) {
        this.tipo2 = value;
    }

    /**
     * Obtém o valor da propriedade valor2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor2() {
        return valor2;
    }

    /**
     * Define o valor da propriedade valor2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor2(String value) {
        this.valor2 = value;
    }

    /**
     * Obtém o valor da propriedade tipo3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo3() {
        return tipo3;
    }

    /**
     * Define o valor da propriedade tipo3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo3(String value) {
        this.tipo3 = value;
    }

    /**
     * Obtém o valor da propriedade valor3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor3() {
        return valor3;
    }

    /**
     * Define o valor da propriedade valor3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor3(String value) {
        this.valor3 = value;
    }

}
