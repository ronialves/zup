
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultarFacilidadeResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultarFacilidadeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="consultaFacilidadeResponse" minOccurs="0" form="unqualified"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="redeMetalica" type="{http://br.com.vivo.indra.scqla.ws/}redeMetalicaType" minOccurs="0"/&gt;
 *                   &lt;element name="fibra" type="{http://br.com.vivo.indra.scqla.ws/}fibraType" minOccurs="0"/&gt;
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
@XmlType(name = "consultarFacilidadeResponse", propOrder = {
    "consultaFacilidadeResponse"
})
public class ConsultarFacilidadeResponse {

    @XmlElement(namespace = "")
    protected ConsultarFacilidadeResponse.ConsultaFacilidadeResponse consultaFacilidadeResponse;

    /**
     * Obtém o valor da propriedade consultaFacilidadeResponse.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarFacilidadeResponse.ConsultaFacilidadeResponse }
     *     
     */
    public ConsultarFacilidadeResponse.ConsultaFacilidadeResponse getConsultaFacilidadeResponse() {
        return consultaFacilidadeResponse;
    }

    /**
     * Define o valor da propriedade consultaFacilidadeResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarFacilidadeResponse.ConsultaFacilidadeResponse }
     *     
     */
    public void setConsultaFacilidadeResponse(ConsultarFacilidadeResponse.ConsultaFacilidadeResponse value) {
        this.consultaFacilidadeResponse = value;
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
     *         &lt;element name="redeMetalica" type="{http://br.com.vivo.indra.scqla.ws/}redeMetalicaType" minOccurs="0"/&gt;
     *         &lt;element name="fibra" type="{http://br.com.vivo.indra.scqla.ws/}fibraType" minOccurs="0"/&gt;
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
        "redeMetalica",
        "fibra"
    })
    public static class ConsultaFacilidadeResponse {

        protected String codigo;
        protected String mensagem;
        protected RedeMetalicaType redeMetalica;
        protected FibraType fibra;

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
         * Obtém o valor da propriedade redeMetalica.
         * 
         * @return
         *     possible object is
         *     {@link RedeMetalicaType }
         *     
         */
        public RedeMetalicaType getRedeMetalica() {
            return redeMetalica;
        }

        /**
         * Define o valor da propriedade redeMetalica.
         * 
         * @param value
         *     allowed object is
         *     {@link RedeMetalicaType }
         *     
         */
        public void setRedeMetalica(RedeMetalicaType value) {
            this.redeMetalica = value;
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

    }

}
