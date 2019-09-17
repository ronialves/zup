
package com.tlf.oss.resourceinventory.generated.terus.desbloqueioportaresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de DesbloqueioPortaResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DesbloqueioPortaResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DATA_HORA" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="COD_MSG"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DSC_MSG"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="250"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "DesbloqueioPortaResponseType", propOrder = {
    "datahora",
    "codmsg",
    "dscmsg",
    "nome",
    "lic"
})
public class DesbloqueioPortaResponseType {

    @XmlElement(name = "DATA_HORA", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datahora;
    @XmlElement(name = "COD_MSG", required = true)
    protected String codmsg;
    @XmlElement(name = "DSC_MSG", required = true)
    protected String dscmsg;
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
     * Obtém o valor da propriedade codmsg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODMSG() {
        return codmsg;
    }

    /**
     * Define o valor da propriedade codmsg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODMSG(String value) {
        this.codmsg = value;
    }

    /**
     * Obtém o valor da propriedade dscmsg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSCMSG() {
        return dscmsg;
    }

    /**
     * Define o valor da propriedade dscmsg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSCMSG(String value) {
        this.dscmsg = value;
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
