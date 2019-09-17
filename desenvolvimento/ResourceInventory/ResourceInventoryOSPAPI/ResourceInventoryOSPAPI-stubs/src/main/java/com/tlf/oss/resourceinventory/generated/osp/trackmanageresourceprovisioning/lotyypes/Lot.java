
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.lotyypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Lot complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Lot"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lotClass" type="{http://www.cpqd.com.br/etics/simpletypes}string040" minOccurs="0"/&gt;
 *         &lt;element name="fttxAttendance" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *               &lt;pattern value="1|2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lot", propOrder = {
    "lotClass",
    "fttxAttendance"
})
public class Lot {

    protected String lotClass;
    protected String fttxAttendance;

    /**
     * Obtém o valor da propriedade lotClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLotClass() {
        return lotClass;
    }

    /**
     * Define o valor da propriedade lotClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLotClass(String value) {
        this.lotClass = value;
    }

    /**
     * Obtém o valor da propriedade fttxAttendance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFttxAttendance() {
        return fttxAttendance;
    }

    /**
     * Define o valor da propriedade fttxAttendance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFttxAttendance(String value) {
        this.fttxAttendance = value;
    }

}
