
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de fibraType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="fibraType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caboAlimentador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fibraAlimentadora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attendance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="splitterFirstLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="splitterFirstLevelAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="distributionLowFiber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="distributionHighFiber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="splitterSecondLevelFiberNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="splitterSecondLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="splitterSecondLevelAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lateralCableDistribution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalEquipmentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalEquipmentAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="opticaTerminal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="portaClient" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="technology" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="splitterFirstLevelSTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="splitterFirstLevelLotFace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="splitterSecondLevelSTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="splitterSecondLevelLotFace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fttxClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="slotUpLink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="slotClient" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fibraType", propOrder = {
    "caboAlimentador",
    "fibraAlimentadora",
    "attendance",
    "splitterFirstLevelCode",
    "splitterFirstLevelAddress",
    "distributionLowFiber",
    "distributionHighFiber",
    "splitterSecondLevelFiberNum",
    "splitterSecondLevelCode",
    "splitterSecondLevelAddress",
    "lateralCableDistribution",
    "terminalEquipmentType",
    "nome",
    "terminalEquipmentAddress",
    "opticaTerminal",
    "portaClient",
    "technology",
    "splitterFirstLevelSTCode",
    "splitterFirstLevelLotFace",
    "splitterSecondLevelSTCode",
    "splitterSecondLevelLotFace",
    "fttxClient",
    "slotUpLink",
    "slotClient"
})
public class FibraType {

    protected String caboAlimentador;
    protected String fibraAlimentadora;
    protected String attendance;
    protected String splitterFirstLevelCode;
    protected String splitterFirstLevelAddress;
    protected Integer distributionLowFiber;
    protected Integer distributionHighFiber;
    protected Integer splitterSecondLevelFiberNum;
    protected String splitterSecondLevelCode;
    protected String splitterSecondLevelAddress;
    protected String lateralCableDistribution;
    protected String terminalEquipmentType;
    protected String nome;
    protected String terminalEquipmentAddress;
    protected String opticaTerminal;
    protected Integer portaClient;
    protected String technology;
    protected String splitterFirstLevelSTCode;
    protected String splitterFirstLevelLotFace;
    protected String splitterSecondLevelSTCode;
    protected String splitterSecondLevelLotFace;
    protected String fttxClient;
    protected String slotUpLink;
    protected Integer slotClient;

    /**
     * Obtém o valor da propriedade caboAlimentador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaboAlimentador() {
        return caboAlimentador;
    }

    /**
     * Define o valor da propriedade caboAlimentador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaboAlimentador(String value) {
        this.caboAlimentador = value;
    }

    /**
     * Obtém o valor da propriedade fibraAlimentadora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFibraAlimentadora() {
        return fibraAlimentadora;
    }

    /**
     * Define o valor da propriedade fibraAlimentadora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFibraAlimentadora(String value) {
        this.fibraAlimentadora = value;
    }

    /**
     * Obtém o valor da propriedade attendance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttendance() {
        return attendance;
    }

    /**
     * Define o valor da propriedade attendance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttendance(String value) {
        this.attendance = value;
    }

    /**
     * Obtém o valor da propriedade splitterFirstLevelCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterFirstLevelCode() {
        return splitterFirstLevelCode;
    }

    /**
     * Define o valor da propriedade splitterFirstLevelCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterFirstLevelCode(String value) {
        this.splitterFirstLevelCode = value;
    }

    /**
     * Obtém o valor da propriedade splitterFirstLevelAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterFirstLevelAddress() {
        return splitterFirstLevelAddress;
    }

    /**
     * Define o valor da propriedade splitterFirstLevelAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterFirstLevelAddress(String value) {
        this.splitterFirstLevelAddress = value;
    }

    /**
     * Obtém o valor da propriedade distributionLowFiber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDistributionLowFiber() {
        return distributionLowFiber;
    }

    /**
     * Define o valor da propriedade distributionLowFiber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDistributionLowFiber(Integer value) {
        this.distributionLowFiber = value;
    }

    /**
     * Obtém o valor da propriedade distributionHighFiber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDistributionHighFiber() {
        return distributionHighFiber;
    }

    /**
     * Define o valor da propriedade distributionHighFiber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDistributionHighFiber(Integer value) {
        this.distributionHighFiber = value;
    }

    /**
     * Obtém o valor da propriedade splitterSecondLevelFiberNum.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSplitterSecondLevelFiberNum() {
        return splitterSecondLevelFiberNum;
    }

    /**
     * Define o valor da propriedade splitterSecondLevelFiberNum.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSplitterSecondLevelFiberNum(Integer value) {
        this.splitterSecondLevelFiberNum = value;
    }

    /**
     * Obtém o valor da propriedade splitterSecondLevelCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterSecondLevelCode() {
        return splitterSecondLevelCode;
    }

    /**
     * Define o valor da propriedade splitterSecondLevelCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterSecondLevelCode(String value) {
        this.splitterSecondLevelCode = value;
    }

    /**
     * Obtém o valor da propriedade splitterSecondLevelAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterSecondLevelAddress() {
        return splitterSecondLevelAddress;
    }

    /**
     * Define o valor da propriedade splitterSecondLevelAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterSecondLevelAddress(String value) {
        this.splitterSecondLevelAddress = value;
    }

    /**
     * Obtém o valor da propriedade lateralCableDistribution.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLateralCableDistribution() {
        return lateralCableDistribution;
    }

    /**
     * Define o valor da propriedade lateralCableDistribution.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLateralCableDistribution(String value) {
        this.lateralCableDistribution = value;
    }

    /**
     * Obtém o valor da propriedade terminalEquipmentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalEquipmentType() {
        return terminalEquipmentType;
    }

    /**
     * Define o valor da propriedade terminalEquipmentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalEquipmentType(String value) {
        this.terminalEquipmentType = value;
    }

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
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
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Obtém o valor da propriedade terminalEquipmentAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalEquipmentAddress() {
        return terminalEquipmentAddress;
    }

    /**
     * Define o valor da propriedade terminalEquipmentAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalEquipmentAddress(String value) {
        this.terminalEquipmentAddress = value;
    }

    /**
     * Obtém o valor da propriedade opticaTerminal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpticaTerminal() {
        return opticaTerminal;
    }

    /**
     * Define o valor da propriedade opticaTerminal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpticaTerminal(String value) {
        this.opticaTerminal = value;
    }

    /**
     * Obtém o valor da propriedade portaClient.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortaClient() {
        return portaClient;
    }

    /**
     * Define o valor da propriedade portaClient.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortaClient(Integer value) {
        this.portaClient = value;
    }

    /**
     * Obtém o valor da propriedade technology.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * Define o valor da propriedade technology.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnology(String value) {
        this.technology = value;
    }

    /**
     * Obtém o valor da propriedade splitterFirstLevelSTCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterFirstLevelSTCode() {
        return splitterFirstLevelSTCode;
    }

    /**
     * Define o valor da propriedade splitterFirstLevelSTCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterFirstLevelSTCode(String value) {
        this.splitterFirstLevelSTCode = value;
    }

    /**
     * Obtém o valor da propriedade splitterFirstLevelLotFace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterFirstLevelLotFace() {
        return splitterFirstLevelLotFace;
    }

    /**
     * Define o valor da propriedade splitterFirstLevelLotFace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterFirstLevelLotFace(String value) {
        this.splitterFirstLevelLotFace = value;
    }

    /**
     * Obtém o valor da propriedade splitterSecondLevelSTCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterSecondLevelSTCode() {
        return splitterSecondLevelSTCode;
    }

    /**
     * Define o valor da propriedade splitterSecondLevelSTCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterSecondLevelSTCode(String value) {
        this.splitterSecondLevelSTCode = value;
    }

    /**
     * Obtém o valor da propriedade splitterSecondLevelLotFace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterSecondLevelLotFace() {
        return splitterSecondLevelLotFace;
    }

    /**
     * Define o valor da propriedade splitterSecondLevelLotFace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterSecondLevelLotFace(String value) {
        this.splitterSecondLevelLotFace = value;
    }

    /**
     * Obtém o valor da propriedade fttxClient.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFttxClient() {
        return fttxClient;
    }

    /**
     * Define o valor da propriedade fttxClient.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFttxClient(String value) {
        this.fttxClient = value;
    }

    /**
     * Obtém o valor da propriedade slotUpLink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlotUpLink() {
        return slotUpLink;
    }

    /**
     * Define o valor da propriedade slotUpLink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlotUpLink(String value) {
        this.slotUpLink = value;
    }

    /**
     * Obtém o valor da propriedade slotClient.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSlotClient() {
        return slotClient;
    }

    /**
     * Define o valor da propriedade slotClient.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSlotClient(Integer value) {
        this.slotClient = value;
    }

}
