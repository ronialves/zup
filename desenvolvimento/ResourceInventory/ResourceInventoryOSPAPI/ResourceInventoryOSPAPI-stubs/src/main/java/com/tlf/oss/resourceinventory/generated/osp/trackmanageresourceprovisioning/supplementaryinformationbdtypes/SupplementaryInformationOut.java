
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.supplementaryinformationbdtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.dedicatedresourcetypes.DedicatedResource;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceorderinfotypes.ResourceOrderInfo;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceserviceinfotypes.ResourceService;


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
 *         &lt;element name="resourceServiceCopper" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="resourceServiceLP" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="resourceServiceFTTx" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="timeStamp" type="{http://www.cpqd.com.br/etics/simpletypes}string19" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberAirGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberUndergroundGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="metreageAirSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="metreageUndergroundSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="observation" type="{http://www.cpqd.com.br/etics/simpletypes}string75" minOccurs="0"/&gt;
 *         &lt;element name="serviceExecutionTimestamp" type="{http://www.cpqd.com.br/etics/simpletypes}string19" minOccurs="0"/&gt;
 *         &lt;element name="pupFeederPairNum" type="{http://www.cpqd.com.br/etics/simpletypes}string4" minOccurs="0"/&gt;
 *         &lt;element name="serviceArea" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="tfoInstallPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="tfoInstallTypePlace" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="tfoAttendance" type="{http://www.cpqd.com.br/etics/simpletypes}string20" minOccurs="0"/&gt;
 *         &lt;element name="splitterInstallPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="splitterInstallTypePlace" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="splitterAttendance" type="{http://www.cpqd.com.br/etics/simpletypes}string20" minOccurs="0"/&gt;
 *         &lt;element name="terminalSiteInstallPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="terminalSiteInstallTypePlace" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="terminalSiteAttendance" type="{http://www.cpqd.com.br/etics/simpletypes}string20" minOccurs="0"/&gt;
 *         &lt;element name="slotClientCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="slotClientPort" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="slotUplinkCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="slotUplinkPort" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="unitQty" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
 *         &lt;element name="dGNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="dGVerticalNumber" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="dedicatedResource" type="{http://www.cpqd.com.br/etics/DedicatedResourceTypes}DedicatedResource" minOccurs="0"/&gt;
 *         &lt;element name="clientLogicalPosition" type="{http://www.cpqd.com.br/etics/simpletypes}integer4" minOccurs="0"/&gt;
 *         &lt;element name="overlappedNetFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
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
    "resourceServiceCopper",
    "resourceServiceLP",
    "resourceServiceFTTx",
    "timeStamp",
    "cableSubscriberAirGauge",
    "cableSubscriberUndergroundGauge",
    "metreageAirSubscriberCable",
    "metreageUndergroundSubscriberCable",
    "observation",
    "serviceExecutionTimestamp",
    "pupFeederPairNum",
    "serviceArea",
    "tfoInstallPlace",
    "tfoInstallTypePlace",
    "tfoAttendance",
    "splitterInstallPlace",
    "splitterInstallTypePlace",
    "splitterAttendance",
    "terminalSiteInstallPlace",
    "terminalSiteInstallTypePlace",
    "terminalSiteAttendance",
    "slotClientCode",
    "slotClientPort",
    "slotUplinkCode",
    "slotUplinkPort",
    "unitQty",
    "dgNumber",
    "dgVerticalNumber",
    "dedicatedResource",
    "clientLogicalPosition",
    "overlappedNetFlag",
    "customElements"
})
public class SupplementaryInformationOut {

    protected ResourceOrderInfo resourceOrderInfo;
    protected ResourceService resourceServiceCopper;
    protected ResourceService resourceServiceLP;
    protected ResourceService resourceServiceFTTx;
    protected String timeStamp;
    protected String cableSubscriberAirGauge;
    protected String cableSubscriberUndergroundGauge;
    protected String metreageAirSubscriberCable;
    protected String metreageUndergroundSubscriberCable;
    protected String observation;
    protected String serviceExecutionTimestamp;
    protected String pupFeederPairNum;
    protected String serviceArea;
    protected String tfoInstallPlace;
    protected String tfoInstallTypePlace;
    protected String tfoAttendance;
    protected String splitterInstallPlace;
    protected String splitterInstallTypePlace;
    protected String splitterAttendance;
    protected String terminalSiteInstallPlace;
    protected String terminalSiteInstallTypePlace;
    protected String terminalSiteAttendance;
    protected String slotClientCode;
    protected String slotClientPort;
    protected String slotUplinkCode;
    protected String slotUplinkPort;
    @XmlSchemaType(name = "integer")
    protected Integer unitQty;
    @XmlElement(name = "dGNumber")
    protected String dgNumber;
    @XmlElement(name = "dGVerticalNumber")
    protected String dgVerticalNumber;
    protected DedicatedResource dedicatedResource;
    @XmlSchemaType(name = "integer")
    protected Integer clientLogicalPosition;
    protected String overlappedNetFlag;
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
     * Obtém o valor da propriedade resourceServiceCopper.
     * 
     * @return
     *     possible object is
     *     {@link ResourceService }
     *     
     */
    public ResourceService getResourceServiceCopper() {
        return resourceServiceCopper;
    }

    /**
     * Define o valor da propriedade resourceServiceCopper.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceService }
     *     
     */
    public void setResourceServiceCopper(ResourceService value) {
        this.resourceServiceCopper = value;
    }

    /**
     * Obtém o valor da propriedade resourceServiceLP.
     * 
     * @return
     *     possible object is
     *     {@link ResourceService }
     *     
     */
    public ResourceService getResourceServiceLP() {
        return resourceServiceLP;
    }

    /**
     * Define o valor da propriedade resourceServiceLP.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceService }
     *     
     */
    public void setResourceServiceLP(ResourceService value) {
        this.resourceServiceLP = value;
    }

    /**
     * Obtém o valor da propriedade resourceServiceFTTx.
     * 
     * @return
     *     possible object is
     *     {@link ResourceService }
     *     
     */
    public ResourceService getResourceServiceFTTx() {
        return resourceServiceFTTx;
    }

    /**
     * Define o valor da propriedade resourceServiceFTTx.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceService }
     *     
     */
    public void setResourceServiceFTTx(ResourceService value) {
        this.resourceServiceFTTx = value;
    }

    /**
     * Obtém o valor da propriedade timeStamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Define o valor da propriedade timeStamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
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
     * Obtém o valor da propriedade pupFeederPairNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPupFeederPairNum() {
        return pupFeederPairNum;
    }

    /**
     * Define o valor da propriedade pupFeederPairNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPupFeederPairNum(String value) {
        this.pupFeederPairNum = value;
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
     * Obtém o valor da propriedade tfoInstallPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTfoInstallPlace() {
        return tfoInstallPlace;
    }

    /**
     * Define o valor da propriedade tfoInstallPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTfoInstallPlace(String value) {
        this.tfoInstallPlace = value;
    }

    /**
     * Obtém o valor da propriedade tfoInstallTypePlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTfoInstallTypePlace() {
        return tfoInstallTypePlace;
    }

    /**
     * Define o valor da propriedade tfoInstallTypePlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTfoInstallTypePlace(String value) {
        this.tfoInstallTypePlace = value;
    }

    /**
     * Obtém o valor da propriedade tfoAttendance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTfoAttendance() {
        return tfoAttendance;
    }

    /**
     * Define o valor da propriedade tfoAttendance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTfoAttendance(String value) {
        this.tfoAttendance = value;
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
     * Obtém o valor da propriedade splitterInstallTypePlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterInstallTypePlace() {
        return splitterInstallTypePlace;
    }

    /**
     * Define o valor da propriedade splitterInstallTypePlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterInstallTypePlace(String value) {
        this.splitterInstallTypePlace = value;
    }

    /**
     * Obtém o valor da propriedade splitterAttendance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitterAttendance() {
        return splitterAttendance;
    }

    /**
     * Define o valor da propriedade splitterAttendance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitterAttendance(String value) {
        this.splitterAttendance = value;
    }

    /**
     * Obtém o valor da propriedade terminalSiteInstallPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalSiteInstallPlace() {
        return terminalSiteInstallPlace;
    }

    /**
     * Define o valor da propriedade terminalSiteInstallPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalSiteInstallPlace(String value) {
        this.terminalSiteInstallPlace = value;
    }

    /**
     * Obtém o valor da propriedade terminalSiteInstallTypePlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalSiteInstallTypePlace() {
        return terminalSiteInstallTypePlace;
    }

    /**
     * Define o valor da propriedade terminalSiteInstallTypePlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalSiteInstallTypePlace(String value) {
        this.terminalSiteInstallTypePlace = value;
    }

    /**
     * Obtém o valor da propriedade terminalSiteAttendance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalSiteAttendance() {
        return terminalSiteAttendance;
    }

    /**
     * Define o valor da propriedade terminalSiteAttendance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalSiteAttendance(String value) {
        this.terminalSiteAttendance = value;
    }

    /**
     * Obtém o valor da propriedade slotClientCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlotClientCode() {
        return slotClientCode;
    }

    /**
     * Define o valor da propriedade slotClientCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlotClientCode(String value) {
        this.slotClientCode = value;
    }

    /**
     * Obtém o valor da propriedade slotClientPort.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlotClientPort() {
        return slotClientPort;
    }

    /**
     * Define o valor da propriedade slotClientPort.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlotClientPort(String value) {
        this.slotClientPort = value;
    }

    /**
     * Obtém o valor da propriedade slotUplinkCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlotUplinkCode() {
        return slotUplinkCode;
    }

    /**
     * Define o valor da propriedade slotUplinkCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlotUplinkCode(String value) {
        this.slotUplinkCode = value;
    }

    /**
     * Obtém o valor da propriedade slotUplinkPort.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlotUplinkPort() {
        return slotUplinkPort;
    }

    /**
     * Define o valor da propriedade slotUplinkPort.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlotUplinkPort(String value) {
        this.slotUplinkPort = value;
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
     * Obtém o valor da propriedade dgNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDGNumber() {
        return dgNumber;
    }

    /**
     * Define o valor da propriedade dgNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDGNumber(String value) {
        this.dgNumber = value;
    }

    /**
     * Obtém o valor da propriedade dgVerticalNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDGVerticalNumber() {
        return dgVerticalNumber;
    }

    /**
     * Define o valor da propriedade dgVerticalNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDGVerticalNumber(String value) {
        this.dgVerticalNumber = value;
    }

    /**
     * Obtém o valor da propriedade dedicatedResource.
     * 
     * @return
     *     possible object is
     *     {@link DedicatedResource }
     *     
     */
    public DedicatedResource getDedicatedResource() {
        return dedicatedResource;
    }

    /**
     * Define o valor da propriedade dedicatedResource.
     * 
     * @param value
     *     allowed object is
     *     {@link DedicatedResource }
     *     
     */
    public void setDedicatedResource(DedicatedResource value) {
        this.dedicatedResource = value;
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
