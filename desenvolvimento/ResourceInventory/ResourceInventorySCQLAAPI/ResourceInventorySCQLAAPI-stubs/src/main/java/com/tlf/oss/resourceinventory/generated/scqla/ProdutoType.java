
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de produtoType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="produtoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="classe" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aptoDescricao" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nvt" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="perfilProduto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sistemaQualificacao" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tecnologia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="familiaProduto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipoTecnologia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="familiaTecnologia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produtoType", propOrder = {
    "classe",
    "tipo",
    "apto",
    "aptoDescricao",
    "nvt",
    "perfilProduto",
    "sistemaQualificacao",
    "tecnologia",
    "familiaProduto",
    "tipoTecnologia",
    "familiaTecnologia"
})
public class ProdutoType {

    @XmlElement(required = true)
    protected String classe;
    @XmlElement(required = true)
    protected String tipo;
    @XmlElement(required = true)
    protected String apto;
    @XmlElement(required = true)
    protected String aptoDescricao;
    @XmlElement(required = true)
    protected String nvt;
    @XmlElement(required = true)
    protected String perfilProduto;
    @XmlElement(required = true)
    protected String sistemaQualificacao;
    @XmlElement(required = true)
    protected String tecnologia;
    @XmlElement(required = true)
    protected String familiaProduto;
    @XmlElement(required = true)
    protected String tipoTecnologia;
    @XmlElement(required = true)
    protected String familiaTecnologia;

    /**
     * Obtém o valor da propriedade classe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasse() {
        return classe;
    }

    /**
     * Define o valor da propriedade classe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasse(String value) {
        this.classe = value;
    }

    /**
     * Obtém o valor da propriedade tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o valor da propriedade tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtém o valor da propriedade apto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApto() {
        return apto;
    }

    /**
     * Define o valor da propriedade apto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApto(String value) {
        this.apto = value;
    }

    /**
     * Obtém o valor da propriedade aptoDescricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAptoDescricao() {
        return aptoDescricao;
    }

    /**
     * Define o valor da propriedade aptoDescricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAptoDescricao(String value) {
        this.aptoDescricao = value;
    }

    /**
     * Obtém o valor da propriedade nvt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNvt() {
        return nvt;
    }

    /**
     * Define o valor da propriedade nvt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNvt(String value) {
        this.nvt = value;
    }

    /**
     * Obtém o valor da propriedade perfilProduto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerfilProduto() {
        return perfilProduto;
    }

    /**
     * Define o valor da propriedade perfilProduto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerfilProduto(String value) {
        this.perfilProduto = value;
    }

    /**
     * Obtém o valor da propriedade sistemaQualificacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSistemaQualificacao() {
        return sistemaQualificacao;
    }

    /**
     * Define o valor da propriedade sistemaQualificacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSistemaQualificacao(String value) {
        this.sistemaQualificacao = value;
    }

    /**
     * Obtém o valor da propriedade tecnologia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTecnologia() {
        return tecnologia;
    }

    /**
     * Define o valor da propriedade tecnologia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTecnologia(String value) {
        this.tecnologia = value;
    }

    /**
     * Obtém o valor da propriedade familiaProduto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamiliaProduto() {
        return familiaProduto;
    }

    /**
     * Define o valor da propriedade familiaProduto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamiliaProduto(String value) {
        this.familiaProduto = value;
    }

    /**
     * Obtém o valor da propriedade tipoTecnologia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTecnologia() {
        return tipoTecnologia;
    }

    /**
     * Define o valor da propriedade tipoTecnologia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTecnologia(String value) {
        this.tipoTecnologia = value;
    }

    /**
     * Obtém o valor da propriedade familiaTecnologia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamiliaTecnologia() {
        return familiaTecnologia;
    }

    /**
     * Define o valor da propriedade familiaTecnologia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamiliaTecnologia(String value) {
        this.familiaTecnologia = value;
    }

}
