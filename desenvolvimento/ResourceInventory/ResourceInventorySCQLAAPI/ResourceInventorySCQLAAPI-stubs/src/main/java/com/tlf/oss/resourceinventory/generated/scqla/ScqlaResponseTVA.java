
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminal" type="{http://br.com.vivo.indra.scqla.ws/}terminalTypeTVA" minOccurs="0"/&gt;
 *         &lt;element name="endereco" type="{http://br.com.vivo.indra.scqla.ws/}enderecoType" minOccurs="0"/&gt;
 *         &lt;element name="fibra" type="{http://br.com.vivo.indra.scqla.ws/}fibraType" minOccurs="0"/&gt;
 *         &lt;element name="tva" type="{http://br.com.vivo.indra.scqla.ws/}tvaType" minOccurs="0"/&gt;
 *         &lt;element name="complementoHorizontal" type="{http://br.com.vivo.indra.scqla.ws/}complementoHorizontalListType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codigo",
    "mensagem",
    "terminal",
    "endereco",
    "fibra",
    "tva",
    "complementoHorizontal"
})
@XmlRootElement(name = "scqlaResponseTVA")
public class ScqlaResponseTVA {

    protected String codigo;
    protected String mensagem;
    protected TerminalTypeTVA terminal;
    protected EnderecoType endereco;
    protected FibraType fibra;
    protected TvaType tva;
    protected ComplementoHorizontalListType complementoHorizontal;

    /**
     * Obtém o valor da propriedade codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtém o valor da propriedade mensagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Define o valor da propriedade mensagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Obtém o valor da propriedade terminal.
     * 
     * @return
     *     possible object is
     *     {@link TerminalTypeTVA }
     *     
     */
    public TerminalTypeTVA getTerminal() {
        return terminal;
    }

    /**
     * Define o valor da propriedade terminal.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalTypeTVA }
     *     
     */
    public void setTerminal(TerminalTypeTVA value) {
        this.terminal = value;
    }

    /**
     * Obtém o valor da propriedade endereco.
     * 
     * @return
     *     possible object is
     *     {@link EnderecoType }
     *     
     */
    public EnderecoType getEndereco() {
        return endereco;
    }

    /**
     * Define o valor da propriedade endereco.
     * 
     * @param value
     *     allowed object is
     *     {@link EnderecoType }
     *     
     */
    public void setEndereco(EnderecoType value) {
        this.endereco = value;
    }

    /**
     * Obtém o valor da propriedade fibra.
     * 
     * @return
     *     possible object is
     *     {@link FibraType }
     *     
     */
    public FibraType getFibra() {
        return fibra;
    }

    /**
     * Define o valor da propriedade fibra.
     * 
     * @param value
     *     allowed object is
     *     {@link FibraType }
     *     
     */
    public void setFibra(FibraType value) {
        this.fibra = value;
    }

    /**
     * Obtém o valor da propriedade tva.
     * 
     * @return
     *     possible object is
     *     {@link TvaType }
     *     
     */
    public TvaType getTva() {
        return tva;
    }

    /**
     * Define o valor da propriedade tva.
     * 
     * @param value
     *     allowed object is
     *     {@link TvaType }
     *     
     */
    public void setTva(TvaType value) {
        this.tva = value;
    }

    /**
     * Obtém o valor da propriedade complementoHorizontal.
     * 
     * @return
     *     possible object is
     *     {@link ComplementoHorizontalListType }
     *     
     */
    public ComplementoHorizontalListType getComplementoHorizontal() {
        return complementoHorizontal;
    }

    /**
     * Define o valor da propriedade complementoHorizontal.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplementoHorizontalListType }
     *     
     */
    public void setComplementoHorizontal(ComplementoHorizontalListType value) {
        this.complementoHorizontal = value;
    }

}
