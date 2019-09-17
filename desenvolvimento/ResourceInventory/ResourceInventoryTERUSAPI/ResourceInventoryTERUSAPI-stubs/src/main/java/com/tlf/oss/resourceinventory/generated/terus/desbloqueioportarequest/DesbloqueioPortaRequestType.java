
package com.tlf.oss.resourceinventory.generated.terus.desbloqueioportarequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de DesbloqueioPortaRequestType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DesbloqueioPortaRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DATA_HORA" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="NOME"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LIC"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="23"/&gt;
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
@XmlType(name = "DesbloqueioPortaRequestType", propOrder = {
    "datahora",
    "nome",
    "lic"
})
public class DesbloqueioPortaRequestType {

    @XmlElement(name = "DATA_HORA", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datahora;
    @XmlElement(name = "NOME", required = true)
    protected String nome;
    @XmlElement(name = "LIC", required = true)
    protected String lic;

    /**
     * Obtém o valor da propriedade datahora.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATAHORA() {
        return datahora;
    }

    /**
     * Define o valor da propriedade datahora.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATAHORA(XMLGregorianCalendar value) {
        this.datahora = value;
    }

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOME() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOME(String value) {
        this.nome = value;
    }

    /**
     * Obtém o valor da propriedade lic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLIC() {
        return lic;
    }

    /**
     * Define o valor da propriedade lic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLIC(String value) {
        this.lic = value;
    }

}
