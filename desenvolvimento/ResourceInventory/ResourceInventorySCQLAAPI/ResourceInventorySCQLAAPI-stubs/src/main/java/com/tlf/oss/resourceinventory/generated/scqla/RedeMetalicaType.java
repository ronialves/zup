
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de redeMetalicaType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="redeMetalicaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="armario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="caboPrimario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lateralPrimario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parPrimario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="caboSecundario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lateralSecundario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parSecundario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="caixa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="distanciaTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="distanciaCentralCaixa" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="distanciaCaixaAssinante" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="distanciaArmarioCentral" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="distanciaCentralUltimoElemento" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="distanciaRadialCentralCaixa" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="distanciaDslamAssinante" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="quantidadeParalelo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="delta" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="attenuation" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="resistence" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="lastObjectX" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="lastObjectY" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="identificadorCarrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificadorArmarioOptico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificadorMuxfin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificadorBobina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificadorRedesobreposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificadorPopDslam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificadorMiniDslan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codigoDslam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="distanciaMsanCentral" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="distanciaMsanAssinante" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="identificadorMsan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificadorDistanciaAbrigoEstimado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "redeMetalicaType", propOrder = {
    "armario",
    "caboPrimario",
    "lateralPrimario",
    "parPrimario",
    "caboSecundario",
    "lateralSecundario",
    "parSecundario",
    "caixa",
    "distanciaTotal",
    "distanciaCentralCaixa",
    "distanciaCaixaAssinante",
    "distanciaArmarioCentral",
    "distanciaCentralUltimoElemento",
    "distanciaRadialCentralCaixa",
    "distanciaDslamAssinante",
    "quantidadeParalelo",
    "delta",
    "attenuation",
    "resistence",
    "lastObjectX",
    "lastObjectY",
    "identificadorCarrier",
    "identificadorArmarioOptico",
    "identificadorMuxfin",
    "identificadorBobina",
    "identificadorRedesobreposta",
    "identificadorPopDslam",
    "identificadorMiniDslan",
    "codigoDslam",
    "distanciaMsanCentral",
    "distanciaMsanAssinante",
    "identificadorMsan",
    "identificadorDistanciaAbrigoEstimado"
})
public class RedeMetalicaType {

    protected String armario;
    protected String caboPrimario;
    protected String lateralPrimario;
    protected String parPrimario;
    protected String caboSecundario;
    protected String lateralSecundario;
    protected String parSecundario;
    protected String caixa;
    protected String distanciaTotal;
    protected Double distanciaCentralCaixa;
    protected Double distanciaCaixaAssinante;
    protected Double distanciaArmarioCentral;
    protected Double distanciaCentralUltimoElemento;
    protected Double distanciaRadialCentralCaixa;
    protected Double distanciaDslamAssinante;
    protected Integer quantidadeParalelo;
    protected Double delta;
    protected Double attenuation;
    protected Double resistence;
    protected Double lastObjectX;
    protected Double lastObjectY;
    protected String identificadorCarrier;
    protected String identificadorArmarioOptico;
    protected String identificadorMuxfin;
    protected String identificadorBobina;
    protected String identificadorRedesobreposta;
    protected String identificadorPopDslam;
    protected String identificadorMiniDslan;
    protected String codigoDslam;
    protected Double distanciaMsanCentral;
    protected Double distanciaMsanAssinante;
    protected String identificadorMsan;
    protected String identificadorDistanciaAbrigoEstimado;

    /**
     * Obtém o valor da propriedade armario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArmario() {
        return armario;
    }

    /**
     * Define o valor da propriedade armario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArmario(String value) {
        this.armario = value;
    }

    /**
     * Obtém o valor da propriedade caboPrimario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaboPrimario() {
        return caboPrimario;
    }

    /**
     * Define o valor da propriedade caboPrimario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaboPrimario(String value) {
        this.caboPrimario = value;
    }

    /**
     * Obtém o valor da propriedade lateralPrimario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLateralPrimario() {
        return lateralPrimario;
    }

    /**
     * Define o valor da propriedade lateralPrimario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLateralPrimario(String value) {
        this.lateralPrimario = value;
    }

    /**
     * Obtém o valor da propriedade parPrimario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParPrimario() {
        return parPrimario;
    }

    /**
     * Define o valor da propriedade parPrimario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParPrimario(String value) {
        this.parPrimario = value;
    }

    /**
     * Obtém o valor da propriedade caboSecundario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaboSecundario() {
        return caboSecundario;
    }

    /**
     * Define o valor da propriedade caboSecundario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaboSecundario(String value) {
        this.caboSecundario = value;
    }

    /**
     * Obtém o valor da propriedade lateralSecundario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLateralSecundario() {
        return lateralSecundario;
    }

    /**
     * Define o valor da propriedade lateralSecundario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLateralSecundario(String value) {
        this.lateralSecundario = value;
    }

    /**
     * Obtém o valor da propriedade parSecundario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParSecundario() {
        return parSecundario;
    }

    /**
     * Define o valor da propriedade parSecundario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParSecundario(String value) {
        this.parSecundario = value;
    }

    /**
     * Obtém o valor da propriedade caixa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaixa() {
        return caixa;
    }

    /**
     * Define o valor da propriedade caixa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaixa(String value) {
        this.caixa = value;
    }

    /**
     * Obtém o valor da propriedade distanciaTotal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistanciaTotal() {
        return distanciaTotal;
    }

    /**
     * Define o valor da propriedade distanciaTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistanciaTotal(String value) {
        this.distanciaTotal = value;
    }

    /**
     * Obtém o valor da propriedade distanciaCentralCaixa.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaCentralCaixa() {
        return distanciaCentralCaixa;
    }

    /**
     * Define o valor da propriedade distanciaCentralCaixa.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaCentralCaixa(Double value) {
        this.distanciaCentralCaixa = value;
    }

    /**
     * Obtém o valor da propriedade distanciaCaixaAssinante.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaCaixaAssinante() {
        return distanciaCaixaAssinante;
    }

    /**
     * Define o valor da propriedade distanciaCaixaAssinante.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaCaixaAssinante(Double value) {
        this.distanciaCaixaAssinante = value;
    }

    /**
     * Obtém o valor da propriedade distanciaArmarioCentral.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaArmarioCentral() {
        return distanciaArmarioCentral;
    }

    /**
     * Define o valor da propriedade distanciaArmarioCentral.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaArmarioCentral(Double value) {
        this.distanciaArmarioCentral = value;
    }

    /**
     * Obtém o valor da propriedade distanciaCentralUltimoElemento.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaCentralUltimoElemento() {
        return distanciaCentralUltimoElemento;
    }

    /**
     * Define o valor da propriedade distanciaCentralUltimoElemento.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaCentralUltimoElemento(Double value) {
        this.distanciaCentralUltimoElemento = value;
    }

    /**
     * Obtém o valor da propriedade distanciaRadialCentralCaixa.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaRadialCentralCaixa() {
        return distanciaRadialCentralCaixa;
    }

    /**
     * Define o valor da propriedade distanciaRadialCentralCaixa.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaRadialCentralCaixa(Double value) {
        this.distanciaRadialCentralCaixa = value;
    }

    /**
     * Obtém o valor da propriedade distanciaDslamAssinante.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaDslamAssinante() {
        return distanciaDslamAssinante;
    }

    /**
     * Define o valor da propriedade distanciaDslamAssinante.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaDslamAssinante(Double value) {
        this.distanciaDslamAssinante = value;
    }

    /**
     * Obtém o valor da propriedade quantidadeParalelo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantidadeParalelo() {
        return quantidadeParalelo;
    }

    /**
     * Define o valor da propriedade quantidadeParalelo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantidadeParalelo(Integer value) {
        this.quantidadeParalelo = value;
    }

    /**
     * Obtém o valor da propriedade delta.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDelta() {
        return delta;
    }

    /**
     * Define o valor da propriedade delta.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDelta(Double value) {
        this.delta = value;
    }

    /**
     * Obtém o valor da propriedade attenuation.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAttenuation() {
        return attenuation;
    }

    /**
     * Define o valor da propriedade attenuation.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAttenuation(Double value) {
        this.attenuation = value;
    }

    /**
     * Obtém o valor da propriedade resistence.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getResistence() {
        return resistence;
    }

    /**
     * Define o valor da propriedade resistence.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setResistence(Double value) {
        this.resistence = value;
    }

    /**
     * Obtém o valor da propriedade lastObjectX.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLastObjectX() {
        return lastObjectX;
    }

    /**
     * Define o valor da propriedade lastObjectX.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLastObjectX(Double value) {
        this.lastObjectX = value;
    }

    /**
     * Obtém o valor da propriedade lastObjectY.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLastObjectY() {
        return lastObjectY;
    }

    /**
     * Define o valor da propriedade lastObjectY.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLastObjectY(Double value) {
        this.lastObjectY = value;
    }

    /**
     * Obtém o valor da propriedade identificadorCarrier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorCarrier() {
        return identificadorCarrier;
    }

    /**
     * Define o valor da propriedade identificadorCarrier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorCarrier(String value) {
        this.identificadorCarrier = value;
    }

    /**
     * Obtém o valor da propriedade identificadorArmarioOptico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorArmarioOptico() {
        return identificadorArmarioOptico;
    }

    /**
     * Define o valor da propriedade identificadorArmarioOptico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorArmarioOptico(String value) {
        this.identificadorArmarioOptico = value;
    }

    /**
     * Obtém o valor da propriedade identificadorMuxfin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorMuxfin() {
        return identificadorMuxfin;
    }

    /**
     * Define o valor da propriedade identificadorMuxfin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorMuxfin(String value) {
        this.identificadorMuxfin = value;
    }

    /**
     * Obtém o valor da propriedade identificadorBobina.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorBobina() {
        return identificadorBobina;
    }

    /**
     * Define o valor da propriedade identificadorBobina.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorBobina(String value) {
        this.identificadorBobina = value;
    }

    /**
     * Obtém o valor da propriedade identificadorRedesobreposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorRedesobreposta() {
        return identificadorRedesobreposta;
    }

    /**
     * Define o valor da propriedade identificadorRedesobreposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorRedesobreposta(String value) {
        this.identificadorRedesobreposta = value;
    }

    /**
     * Obtém o valor da propriedade identificadorPopDslam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorPopDslam() {
        return identificadorPopDslam;
    }

    /**
     * Define o valor da propriedade identificadorPopDslam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorPopDslam(String value) {
        this.identificadorPopDslam = value;
    }

    /**
     * Obtém o valor da propriedade identificadorMiniDslan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorMiniDslan() {
        return identificadorMiniDslan;
    }

    /**
     * Define o valor da propriedade identificadorMiniDslan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorMiniDslan(String value) {
        this.identificadorMiniDslan = value;
    }

    /**
     * Obtém o valor da propriedade codigoDslam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDslam() {
        return codigoDslam;
    }

    /**
     * Define o valor da propriedade codigoDslam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDslam(String value) {
        this.codigoDslam = value;
    }

    /**
     * Obtém o valor da propriedade distanciaMsanCentral.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaMsanCentral() {
        return distanciaMsanCentral;
    }

    /**
     * Define o valor da propriedade distanciaMsanCentral.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaMsanCentral(Double value) {
        this.distanciaMsanCentral = value;
    }

    /**
     * Obtém o valor da propriedade distanciaMsanAssinante.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanciaMsanAssinante() {
        return distanciaMsanAssinante;
    }

    /**
     * Define o valor da propriedade distanciaMsanAssinante.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanciaMsanAssinante(Double value) {
        this.distanciaMsanAssinante = value;
    }

    /**
     * Obtém o valor da propriedade identificadorMsan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorMsan() {
        return identificadorMsan;
    }

    /**
     * Define o valor da propriedade identificadorMsan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorMsan(String value) {
        this.identificadorMsan = value;
    }

    /**
     * Obtém o valor da propriedade identificadorDistanciaAbrigoEstimado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorDistanciaAbrigoEstimado() {
        return identificadorDistanciaAbrigoEstimado;
    }

    /**
     * Define o valor da propriedade identificadorDistanciaAbrigoEstimado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorDistanciaAbrigoEstimado(String value) {
        this.identificadorDistanciaAbrigoEstimado = value;
    }

}
