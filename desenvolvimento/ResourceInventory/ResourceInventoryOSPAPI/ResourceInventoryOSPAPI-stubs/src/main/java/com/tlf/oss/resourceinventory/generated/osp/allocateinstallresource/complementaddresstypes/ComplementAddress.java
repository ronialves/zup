
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.complementaddresstypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ComplementAddress complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ComplementAddress"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type1" type="{http://www.cpqd.com.br/etics/simpletypes}string06" minOccurs="0"/&gt;
 *         &lt;element name="value1" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="type2" type="{http://www.cpqd.com.br/etics/simpletypes}string06" minOccurs="0"/&gt;
 *         &lt;element name="value2" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="type3" type="{http://www.cpqd.com.br/etics/simpletypes}string06" minOccurs="0"/&gt;
 *         &lt;element name="value3" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplementAddress", propOrder = {
    "type1",
    "value1",
    "type2",
    "value2",
    "type3",
    "value3"
})
@XmlSeeAlso({
    com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.ComplementList.HorizontalComplementAddress.class
})
public class ComplementAddress {

    protected String type1;
    protected String value1;
    protected String type2;
    protected String value2;
    protected String type3;
    protected String value3;

    /**
     * Obtém o valor da propriedade type1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType1() {
        return type1;
    }

    /**
     * Define o valor da propriedade type1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType1(String value) {
        this.type1 = value;
    }

    /**
     * Obtém o valor da propriedade value1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue1() {
        return value1;
    }

    /**
     * Define o valor da propriedade value1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue1(String value) {
        this.value1 = value;
    }

    /**
     * Obtém o valor da propriedade type2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType2() {
        return type2;
    }

    /**
     * Define o valor da propriedade type2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType2(String value) {
        this.type2 = value;
    }

    /**
     * Obtém o valor da propriedade value2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue2() {
        return value2;
    }

    /**
     * Define o valor da propriedade value2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue2(String value) {
        this.value2 = value;
    }

    /**
     * Obtém o valor da propriedade type3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType3() {
        return type3;
    }

    /**
     * Define o valor da propriedade type3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType3(String value) {
        this.type3 = value;
    }

    /**
     * Obtém o valor da propriedade value3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue3() {
        return value3;
    }

    /**
     * Define o valor da propriedade value3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue3(String value) {
        this.value3 = value;
    }

}
