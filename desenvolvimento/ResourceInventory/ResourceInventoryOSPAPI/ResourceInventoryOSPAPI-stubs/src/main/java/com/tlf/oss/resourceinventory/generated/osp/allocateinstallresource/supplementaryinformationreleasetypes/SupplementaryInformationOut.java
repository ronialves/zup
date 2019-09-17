
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationreleasetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceorderinfotypes.ResourceOrderInfo;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceserviceinfotypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.slotinfotypes.SlotInfo;


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
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="splitterInstallTypePlace" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="terminalEquipInstallPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="terminalEquipInstallTypePlace" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="attendance" type="{http://www.cpqd.com.br/etics/simpletypes}string20" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberAirGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberUndergroundGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="metreageAirSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="metreageUndergroundSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="observation" type="{http://www.cpqd.com.br/etics/simpletypes}string75" minOccurs="0"/&gt;
 *         &lt;element name="serviceExecutionTimestamp" type="{http://www.cpqd.com.br/etics/simpletypes}string19" minOccurs="0"/&gt;
 *         &lt;element name="serviceArea" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="clientLogicalPosition" type="{http://www.cpqd.com.br/etics/simpletypes}integer4" minOccurs="0"/&gt;
 *         &lt;element name="overlappedNetFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
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
    "resourceService",
    "splitterInstallTypePlace",
    "terminalEquipInstallPlace",
    "terminalEquipInstallTypePlace",
    "attendance",
    "cableSubscriberAirGauge",
    "cableSubscriberUndergroundGauge",
    "metreageAirSubscriberCable",
    "metreageUndergroundSubscriberCable",
    "observation",
    "serviceExecutionTimestamp",
    "serviceArea",
    "clientLogicalPosition",
    "overlappedNetFlag",
    "slotInfo",
    "customElements"
})
public class SupplementaryInformationOut {

    protected ResourceOrderInfo resourceOrderInfo;
    protected ResourceService resourceService;
    protected String splitterInstallTypePlace;
    protected String terminalEquipInstallPlace;
    protected String terminalEquipInstallTypePlace;
    protected String attendance;
    protected String cableSubscriberAirGauge;
    protected String cableSubscriberUndergroundGauge;
    protected String metreageAirSubscriberCable;
    protected String metreageUndergroundSubscriberCable;
    protected String observation;
    protected String serviceExecutionTimestamp;
    protected String serviceArea;
    @XmlSchemaType(name = "integer")
    protected Integer clientLogicalPosition;
    protected String overlappedNetFlag;
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
     * Obtém o valor da propriedade resourceService.
     * 
     * @return
     *     possible object is
     *     {@link ResourceService }
     *     
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Define o valor da propriedade resourceService.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceService }
     *     
     */
    public void setResourceService(ResourceService value) {
        this.resourceService = value;
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
