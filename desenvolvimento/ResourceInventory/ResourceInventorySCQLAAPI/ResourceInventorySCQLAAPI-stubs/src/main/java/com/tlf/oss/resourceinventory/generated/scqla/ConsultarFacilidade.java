
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultarFacilidade complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultarFacilidade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="scqlaRequest" minOccurs="0" form="unqualified"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="terminal" type="{http://br.com.vivo.indra.scqla.ws/}terminalType" minOccurs="0"/&gt;
 *                   &lt;element name="endereco" type="{http://br.com.vivo.indra.scqla.ws/}enderecoType" minOccurs="0"/&gt;
 *                   &lt;element name="consultaPorta" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="0"/&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="enviaEndereco" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="S"/&gt;
 *                         &lt;enumeration value="N"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "consultarFacilidade", propOrder = {
    "scqlaRequest"
})
public class ConsultarFacilidade {

    @XmlElement(namespace = "")
    protected ConsultarFacilidade.ScqlaRequest scqlaRequest;

    /**
     * Obtém o valor da propriedade scqlaRequest.
     * 
     * @return
     *     possible object is
     *     {@link ConsultarFacilidade.ScqlaRequest }
     *     
     */
    public ConsultarFacilidade.ScqlaRequest getScqlaRequest() {
        return scqlaRequest;
    }

    /**
     * Define o valor da propriedade scqlaRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultarFacilidade.ScqlaRequest }
     *     
     */
    public void setScqlaRequest(ConsultarFacilidade.ScqlaRequest value) {
        this.scqlaRequest = value;
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
     *         &lt;element name="terminal" type="{http://br.com.vivo.indra.scqla.ws/}terminalType" minOccurs="0"/&gt;
     *         &lt;element name="endereco" type="{http://br.com.vivo.indra.scqla.ws/}enderecoType" minOccurs="0"/&gt;
     *         &lt;element name="consultaPorta" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="0"/&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="enviaEndereco" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="S"/&gt;
     *               &lt;enumeration value="N"/&gt;
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
    @XmlType(name = "", propOrder = {
        "terminal",
        "endereco",
        "consultaPorta",
        "enviaEndereco"
    })
    public static class ScqlaRequest {

        protected TerminalType terminal;
        protected EnderecoType endereco;
        @XmlElement(defaultValue = "0")
        protected String consultaPorta;
        @XmlElement(defaultValue = "N")
        protected String enviaEndereco;

        /**
         * Obtém o valor da propriedade terminal.
         * 
         * @return
         *     possible object is
         *     {@link TerminalType }
         *     
         */
        public TerminalType getTerminal() {
            return terminal;
        }

        /**
         * Define o valor da propriedade terminal.
         * 
         * @param value
         *     allowed object is
         *     {@link TerminalType }
         *     
         */
        public void setTerminal(TerminalType value) {
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
         * Obtém o valor da propriedade consultaPorta.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConsultaPorta() {
            return consultaPorta;
        }

        /**
         * Define o valor da propriedade consultaPorta.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConsultaPorta(String value) {
            this.consultaPorta = value;
        }

        /**
         * Obtém o valor da propriedade enviaEndereco.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEnviaEndereco() {
            return enviaEndereco;
        }

        /**
         * Define o valor da propriedade enviaEndereco.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEnviaEndereco(String value) {
            this.enviaEndereco = value;
        }

    }

}
