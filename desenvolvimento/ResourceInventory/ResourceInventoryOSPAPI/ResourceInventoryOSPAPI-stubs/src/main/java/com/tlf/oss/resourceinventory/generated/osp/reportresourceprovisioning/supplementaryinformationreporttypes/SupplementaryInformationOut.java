
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.supplementaryinformationreporttypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourceorderinfotypes.ResourceOrderInfo;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.slotinfotypes.SlotInfo;


/**
 * <p>Classe Java de SupplementaryInformationOut complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SupplementaryInformationOut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrderInfo" type="{http://www.cpqd.com.br/etics/ResourceOrderInfoTypes}ResourceOrderInfo" minOccurs="0"/&gt;
 *         &lt;element name="splitterInstallPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
 *         &lt;element name="terminalEquipInstallPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="terminalEquipInstallTypePlace" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="attendance" type="{http://www.cpqd.com.br/etics/simpletypes}string20" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberAirGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberUndergroundGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="metreageAirSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="metreageUndergroundSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="observation" type="{http://www.cpqd.com.br/etics/simpletypes}string75" minOccurs="0"/&gt;
 *         &lt;element name="serviceExecutionTimestamp" type="{http://www.cpqd.com.br/etics/simpletypes}string19" minOccurs="0"/&gt;
 *         &lt;element name="commandType" type="{http://www.cpqd.com.br/etics/simpletypes}string4" minOccurs="0"/&gt;
 *         &lt;element name="callerProgram" type="{http://www.cpqd.com.br/etics/simpletypes}string8" minOccurs="0"/&gt;
 *         &lt;element name="osNature" type="{http://www.cpqd.com.br/etics/simpletypes}integer3" minOccurs="0"/&gt;
 *         &lt;element name="osStatus" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
 *         &lt;element name="unitQty" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
 *         &lt;element name="serviceArea" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="dedicatedArea" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="ftthTechType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string4"&gt;
 *               &lt;pattern value="FTTA|FTTB|FTTH"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="overlappedNetFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="wideBandFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="wideBandManeuverFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string14" minOccurs="0"/&gt;
 *         &lt;element name="areaCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
 *         &lt;element name="mfServiceArea" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="clientLogicalPosition" type="{http://www.cpqd.com.br/etics/simpletypes}integer4" minOccurs="0"/&gt;
 *         &lt;element name="fiberSite" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="slotInfo" type="{http://www.cpqd.com.br/etics/SlotInfoTypes}SlotInfo" minOccurs="0"/&gt;
 *         &lt;element name="customElements" type="{http://www.cpqd.com.br/etics/customelements}CustomElements" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplementaryInformationOut", propOrder = {
    "resourceOrderInfo",
    "splitterInstallPlace",
    "terminalEquipInstallPlace",
    "terminalEquipInstallTypePlace",
    "attendance",
    "cableSubscriberAirGauge",
    "cableSubscriberUndergroundGauge",
    "metreageAirSubscriberCable",
    "metreageUndergroundSubscriberCable",
    "observation",
    "serviceExecutionTimestamp",
    "commandType",
    "callerProgram",
    "osNature",
    "osStatus",
    "unitQty",
    "serviceArea",
    "dedicatedArea",
    "ftthTechType",
    "overlappedNetFlag",
    "wideBandFlag",
    "wideBandManeuverFlag",
    "areaCode",
    "mfServiceArea",
    "clientLogicalPosition",
    "fiberSite",
    "slotInfo",
    "customElements"
})
public class SupplementaryInformationOut {

    protected ResourceOrderInfo resourceOrderInfo;
    protected String splitterInstallPlace;
    protected String terminalEquipInstallPlace;
    protected String terminalEquipInstallTypePlace;
    protected String attendance;
    protected String cableSubscriberAirGauge;
    protected String cableSubscriberUndergroundGauge;
    protected String metreageAirSubscriberCable;
    protected String metreageUndergroundSubscriberCable;
    protected String observation;
    protected String serviceExecutionTimestamp;
    protected String commandType;
    protected String callerProgram;
    @XmlSchemaType(name = "integer")
    protected Integer osNature;
    @XmlSchemaType(name = "integer")
    protected Integer osStatus;
    @XmlSchemaType(name = "integer")
    protected Integer unitQty;
    protected String serviceArea;
    protected String dedicatedArea;
    protected String ftthTechType;
    protected String overlappedNetFlag;
    protected String wideBandFlag;
    protected String wideBandManeuverFlag;
    @XmlSchemaType(name = "integer")
    protected Integer areaCode;
    protected String mfServiceArea;
    @XmlSchemaType(name = "integer")
    protected Integer clientLogicalPosition;
    protected BigInteger fiberSite;
    protected SlotInfo slotInfo;
    protected CustomElements customElements;

    /**
     * Obtém o valor da propriedade resourceOrderInfo.
     * 
     * @return
     *     possible object is
     *     {@link ResourceOrderInfo }
     *     
     */
    public ResourceOrderInfo getResourceOrderInfo() {
        return resourceOrderInfo;
    }

    /**
     * Define o valor da propriedade resourceOrderInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceOrderInfo }
     *     
     */
    public void setResourceOrderInfo(ResourceOrderInfo value) {
        this.resourceOrderInfo = value;
    }

    /**
     * Obtém o valor da propriedade splitterInstallPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterInstallPlace() {
        return splitterInstallPlace;
    }

    /**
     * Define o valor da propriedade splitterInstallPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterInstallPlace(String value) {
        this.splitterInstallPlace = value;
    }

    /**
     * Obtém o valor da propriedade terminalEquipInstallPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalEquipInstallPlace() {
        return terminalEquipInstallPlace;
    }

    /**
     * Define o valor da propriedade terminalEquipInstallPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalEquipInstallPlace(String value) {
        this.terminalEquipInstallPlace = value;
    }

    /**
     * Obtém o valor da propriedade terminalEquipInstallTypePlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalEquipInstallTypePlace() {
        return terminalEquipInstallTypePlace;
    }

    /**
     * Define o valor da propriedade terminalEquipInstallTypePlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalEquipInstallTypePlace(String value) {
        this.terminalEquipInstallTypePlace = value;
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
     * Obtém o valor da propriedade cableSubscriberAirGauge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCableSubscriberAirGauge() {
        return cableSubscriberAirGauge;
    }

    /**
     * Define o valor da propriedade cableSubscriberAirGauge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCableSubscriberAirGauge(String value) {
        this.cableSubscriberAirGauge = value;
    }

    /**
     * Obtém o valor da propriedade cableSubscriberUndergroundGauge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCableSubscriberUndergroundGauge() {
        return cableSubscriberUndergroundGauge;
    }

    /**
     * Define o valor da propriedade cableSubscriberUndergroundGauge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCableSubscriberUndergroundGauge(String value) {
        this.cableSubscriberUndergroundGauge = value;
    }

    /**
     * Obtém o valor da propriedade metreageAirSubscriberCable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetreageAirSubscriberCable() {
        return metreageAirSubscriberCable;
    }

    /**
     * Define o valor da propriedade metreageAirSubscriberCable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetreageAirSubscriberCable(String value) {
        this.metreageAirSubscriberCable = value;
    }

    /**
     * Obtém o valor da propriedade metreageUndergroundSubscriberCable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetreageUndergroundSubscriberCable() {
        return metreageUndergroundSubscriberCable;
    }

    /**
     * Define o valor da propriedade metreageUndergroundSubscriberCable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetreageUndergroundSubscriberCable(String value) {
        this.metreageUndergroundSubscriberCable = value;
    }

    /**
     * Obtém o valor da propriedade observation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservation() {
        return observation;
    }

    /**
     * Define o valor da propriedade observation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservation(String value) {
        this.observation = value;
    }

    /**
     * Obtém o valor da propriedade serviceExecutionTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceExecutionTimestamp() {
        return serviceExecutionTimestamp;
    }

    /**
     * Define o valor da propriedade serviceExecutionTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceExecutionTimestamp(String value) {
        this.serviceExecutionTimestamp = value;
    }

    /**
     * Obtém o valor da propriedade commandType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * Define o valor da propriedade commandType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommandType(String value) {
        this.commandType = value;
    }

    /**
     * Obtém o valor da propriedade callerProgram.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallerProgram() {
        return callerProgram;
    }

    /**
     * Define o valor da propriedade callerProgram.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallerProgram(String value) {
        this.callerProgram = value;
    }

    /**
     * Obtém o valor da propriedade osNature.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOsNature() {
        return osNature;
    }

    /**
     * Define o valor da propriedade osNature.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOsNature(Integer value) {
        this.osNature = value;
    }

    /**
     * Obtém o valor da propriedade osStatus.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOsStatus() {
        return osStatus;
    }

    /**
     * Define o valor da propriedade osStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOsStatus(Integer value) {
        this.osStatus = value;
    }

    /**
     * Obtém o valor da propriedade unitQty.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUnitQty() {
        return unitQty;
    }

    /**
     * Define o valor da propriedade unitQty.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUnitQty(Integer value) {
        this.unitQty = value;
    }

    /**
     * Obtém o valor da propriedade serviceArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceArea() {
        return serviceArea;
    }

    /**
     * Define o valor da propriedade serviceArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceArea(String value) {
        this.serviceArea = value;
    }

    /**
     * Obtém o valor da propriedade dedicatedArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDedicatedArea() {
        return dedicatedArea;
    }

    /**
     * Define o valor da propriedade dedicatedArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDedicatedArea(String value) {
        this.dedicatedArea = value;
    }

    /**
     * Obtém o valor da propriedade ftthTechType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtthTechType() {
        return ftthTechType;
    }

    /**
     * Define o valor da propriedade ftthTechType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtthTechType(String value) {
        this.ftthTechType = value;
    }

    /**
     * Obtém o valor da propriedade overlappedNetFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverlappedNetFlag() {
        return overlappedNetFlag;
    }

    /**
     * Define o valor da propriedade overlappedNetFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverlappedNetFlag(String value) {
        this.overlappedNetFlag = value;
    }

    /**
     * Obtém o valor da propriedade wideBandFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWideBandFlag() {
        return wideBandFlag;
    }

    /**
     * Define o valor da propriedade wideBandFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWideBandFlag(String value) {
        this.wideBandFlag = value;
    }

    /**
     * Obtém o valor da propriedade wideBandManeuverFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWideBandManeuverFlag() {
        return wideBandManeuverFlag;
    }

    /**
     * Define o valor da propriedade wideBandManeuverFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWideBandManeuverFlag(String value) {
        this.wideBandManeuverFlag = value;
    }

    /**
     * Obtém o valor da propriedade areaCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * Define o valor da propriedade areaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAreaCode(Integer value) {
        this.areaCode = value;
    }

    /**
     * Obtém o valor da propriedade mfServiceArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfServiceArea() {
        return mfServiceArea;
    }

    /**
     * Define o valor da propriedade mfServiceArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfServiceArea(String value) {
        this.mfServiceArea = value;
    }

    /**
     * Obtém o valor da propriedade clientLogicalPosition.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getClientLogicalPosition() {
        return clientLogicalPosition;
    }

    /**
     * Define o valor da propriedade clientLogicalPosition.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setClientLogicalPosition(Integer value) {
        this.clientLogicalPosition = value;
    }

    /**
     * Obtém o valor da propriedade fiberSite.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFiberSite() {
        return fiberSite;
    }

    /**
     * Define o valor da propriedade fiberSite.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFiberSite(BigInteger value) {
        this.fiberSite = value;
    }

    /**
     * Obtém o valor da propriedade slotInfo.
     * 
     * @return
     *     possible object is
     *     {@link SlotInfo }
     *     
     */
    public SlotInfo getSlotInfo() {
        return slotInfo;
    }

    /**
     * Define o valor da propriedade slotInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SlotInfo }
     *     
     */
    public void setSlotInfo(SlotInfo value) {
        this.slotInfo = value;
    }

    /**
     * Obtém o valor da propriedade customElements.
     * 
     * @return
     *     possible object is
     *     {@link CustomElements }
     *     
     */
    public CustomElements getCustomElements() {
        return customElements;
    }

    /**
     * Define o valor da propriedade customElements.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomElements }
     *     
     */
    public void setCustomElements(CustomElements value) {
        this.customElements = value;
    }

}
