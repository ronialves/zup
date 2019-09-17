
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationallocatetypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.dedicatedresourcetypes.DedicatedResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.fulladdresstypes.FullAddress;
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
 *         &lt;element name="serviceArea" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="attendanceType" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="oneStopShop" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dedicatedRegion" type="{http://www.cpqd.com.br/etics/DedicatedResourceTypes}DedicatedResource" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberAirGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="cableSubscriberUndergroundGauge" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="metreageAirSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="metreageUndergroundSubscriberCable" type="{http://www.cpqd.com.br/etics/simpletypes}string5" minOccurs="0"/&gt;
 *         &lt;element name="observation" type="{http://www.cpqd.com.br/etics/simpletypes}string75" minOccurs="0"/&gt;
 *         &lt;element name="serviceExecutionTimestamp" type="{http://www.cpqd.com.br/etics/simpletypes}string19" minOccurs="0"/&gt;
 *         &lt;element name="subscriberAddress" type="{http://www.cpqd.com.br/etics/FullAddressTypes}FullAddress" minOccurs="0"/&gt;
 *         &lt;element name="siteCode" type="{http://www.cpqd.com.br/etics/simpletypes}string40" minOccurs="0"/&gt;
 *         &lt;element name="fiberSite" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ftthTechType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string4"&gt;
 *               &lt;pattern value="FTTA|FTTB|FTTH"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="terminalSiteInstallPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string10" minOccurs="0"/&gt;
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="overlappedNetFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="wideBandFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="wideBandManeuverFlag" type="{http://www.cpqd.com.br/etics/simpletypes}string14" minOccurs="0"/&gt;
 *         &lt;element name="pupFeederPairNum" type="{http://www.cpqd.com.br/etics/simpletypes}string4" minOccurs="0"/&gt;
 *         &lt;element name="slotInfo" type="{http://www.cpqd.com.br/etics/SlotInfoTypes}SlotInfo" minOccurs="0"/&gt;
 *         &lt;element name="tfoInstallTypePlace" type="{http://www.cpqd.com.br/etics/simpletypes}string3" minOccurs="0"/&gt;
 *         &lt;element name="tfoAttendance" type="{http://www.cpqd.com.br/etics/simpletypes}string20" minOccurs="0"/&gt;
 *         &lt;element name="clientLogicalPosition" type="{http://www.cpqd.com.br/etics/simpletypes}integer4" minOccurs="0"/&gt;
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
    "serviceArea",
    "attendanceType",
    "oneStopShop",
    "dedicatedRegion",
    "cableSubscriberAirGauge",
    "cableSubscriberUndergroundGauge",
    "metreageAirSubscriberCable",
    "metreageUndergroundSubscriberCable",
    "observation",
    "serviceExecutionTimestamp",
    "subscriberAddress",
    "siteCode",
    "fiberSite",
    "ftthTechType",
    "terminalSiteInstallPlace",
    "resourceService",
    "overlappedNetFlag",
    "wideBandFlag",
    "wideBandManeuverFlag",
    "pupFeederPairNum",
    "slotInfo",
    "tfoInstallTypePlace",
    "tfoAttendance",
    "clientLogicalPosition",
    "customElements"
})
public class SupplementaryInformationOut {

    protected ResourceOrderInfo resourceOrderInfo;
    protected String serviceArea;
    protected String attendanceType;
    protected BigInteger oneStopShop;
    protected DedicatedResource dedicatedRegion;
    protected String cableSubscriberAirGauge;
    protected String cableSubscriberUndergroundGauge;
    protected String metreageAirSubscriberCable;
    protected String metreageUndergroundSubscriberCable;
    protected String observation;
    protected String serviceExecutionTimestamp;
    protected FullAddress subscriberAddress;
    protected String siteCode;
    protected BigInteger fiberSite;
    protected String ftthTechType;
    protected String terminalSiteInstallPlace;
    protected ResourceService resourceService;
    protected String overlappedNetFlag;
    protected String wideBandFlag;
    protected String wideBandManeuverFlag;
    protected String pupFeederPairNum;
    protected SlotInfo slotInfo;
    protected String tfoInstallTypePlace;
    protected String tfoAttendance;
    @XmlSchemaType(name = "integer")
    protected Integer clientLogicalPosition;
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
     * Obtém o valor da propriedade attendanceType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttendanceType() {
        return attendanceType;
    }

    /**
     * Define o valor da propriedade attendanceType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttendanceType(String value) {
        this.attendanceType = value;
    }

    /**
     * Obtém o valor da propriedade oneStopShop.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOneStopShop() {
        return oneStopShop;
    }

    /**
     * Define o valor da propriedade oneStopShop.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOneStopShop(BigInteger value) {
        this.oneStopShop = value;
    }

    /**
     * Obtém o valor da propriedade dedicatedRegion.
     * 
     * @return
     *     possible object is
     *     {@link DedicatedResource }
     *     
     */
    public DedicatedResource getDedicatedRegion() {
        return dedicatedRegion;
    }

    /**
     * Define o valor da propriedade dedicatedRegion.
     * 
     * @param value
     *     allowed object is
     *     {@link DedicatedResource }
     *     
     */
    public void setDedicatedRegion(DedicatedResource value) {
        this.dedicatedRegion = value;
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
     * Obtém o valor da propriedade subscriberAddress.
     * 
     * @return
     *     possible object is
     *     {@link FullAddress }
     *     
     */
    public FullAddress getSubscriberAddress() {
        return subscriberAddress;
    }

    /**
     * Define o valor da propriedade subscriberAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link FullAddress }
     *     
     */
    public void setSubscriberAddress(FullAddress value) {
        this.subscriberAddress = value;
    }

    /**
     * Obtém o valor da propriedade siteCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteCode() {
        return siteCode;
    }

    /**
     * Define o valor da propriedade siteCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteCode(String value) {
        this.siteCode = value;
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
