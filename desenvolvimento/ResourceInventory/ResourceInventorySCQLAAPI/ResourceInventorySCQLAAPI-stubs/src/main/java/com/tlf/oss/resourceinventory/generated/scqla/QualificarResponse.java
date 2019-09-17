
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de qualificarResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="qualificarResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="scqlaResponse" minOccurs="0" form="unqualified"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="quantidadePortaATM" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="quantidadePortaETH" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="digito" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *                   &lt;element name="conjugado" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *                   &lt;element name="produtos" type="{http://br.com.vivo.indra.scqla.ws/}produtoListType" minOccurs="0"/&gt;
 *                   &lt;element name="complementos" type="{http://br.com.vivo.indra.scqla.ws/}complementoListType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "qualificarResponse", propOrder = {
    "scqlaResponse"
})
public class QualificarResponse {

    @XmlElement(namespace = "")
    protected QualificarResponse.ScqlaResponse scqlaResponse;

    /**
     * Obtém o valor da propriedade scqlaResponse.
     * 
     * @return
     *     possible object is
     *     {@link QualificarResponse.ScqlaResponse }
     *     
     */
    public QualificarResponse.ScqlaResponse getScqlaResponse() {
        return scqlaResponse;
    }

    /**
     * Define o valor da propriedade scqlaResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link QualificarResponse.ScqlaResponse }
     *     
     */
    public void setScqlaResponse(QualificarResponse.ScqlaResponse value) {
        this.scqlaResponse = value;
    }


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
     *         &lt;element name="quantidadePortaATM" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="quantidadePortaETH" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="digito" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
     *         &lt;element name="conjugado" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
     *         &lt;element name="produtos" type="{http://br.com.vivo.indra.scqla.ws/}produtoListType" minOccurs="0"/&gt;
     *         &lt;element name="complementos" type="{http://br.com.vivo.indra.scqla.ws/}complementoListType" minOccurs="0"/&gt;
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
        "quantidadePortaATM",
        "quantidadePortaETH",
        "digito",
        "conjugado",
        "produtos",
        "complementos"
    })
    public static class ScqlaResponse {

        protected String codigo;
        protected String mensagem;
        protected int quantidadePortaATM;
        protected int quantidadePortaETH;
        protected Short digito;
        protected Short conjugado;
        protected ProdutoListType produtos;
        protected ComplementoListType complementos;

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
         * Obtém o valor da propriedade quantidadePortaATM.
         * 
         */
        public int getQuantidadePortaATM() {
            return quantidadePortaATM;
        }

        /**
         * Define o valor da propriedade quantidadePortaATM.
         * 
         */
        public void setQuantidadePortaATM(int value) {
            this.quantidadePortaATM = value;
        }

        /**
         * Obtém o valor da propriedade quantidadePortaETH.
         * 
         */
        public int getQuantidadePortaETH() {
            return quantidadePortaETH;
        }

        /**
         * Define o valor da propriedade quantidadePortaETH.
         * 
         */
        public void setQuantidadePortaETH(int value) {
            this.quantidadePortaETH = value;
        }

        /**
         * Obtém o valor da propriedade digito.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getDigito() {
            return digito;
        }

        /**
         * Define o valor da propriedade digito.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setDigito(Short value) {
            this.digito = value;
        }

        /**
         * Obtém o valor da propriedade conjugado.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getConjugado() {
            return conjugado;
        }

        /**
         * Define o valor da propriedade conjugado.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setConjugado(Short value) {
            this.conjugado = value;
        }

        /**
         * Obtém o valor da propriedade produtos.
         * 
         * @return
         *     possible object is
         *     {@link ProdutoListType }
         *     
         */
        public ProdutoListType getProdutos() {
            return produtos;
        }

        /**
         * Define o valor da propriedade produtos.
         * 
         * @param value
         *     allowed object is
         *     {@link ProdutoListType }
         *     
         */
        public void setProdutos(ProdutoListType value) {
            this.produtos = value;
        }

        /**
         * Obtém o valor da propriedade complementos.
         * 
         * @return
         *     possible object is
         *     {@link ComplementoListType }
         *     
         */
        public ComplementoListType getComplementos() {
            return complementos;
        }

        /**
         * Define o valor da propriedade complementos.
         * 
         * @param value
         *     allowed object is
         *     {@link ComplementoListType }
         *     
         */
        public void setComplementos(ComplementoListType value) {
            this.complementos = value;
        }

    }

}
