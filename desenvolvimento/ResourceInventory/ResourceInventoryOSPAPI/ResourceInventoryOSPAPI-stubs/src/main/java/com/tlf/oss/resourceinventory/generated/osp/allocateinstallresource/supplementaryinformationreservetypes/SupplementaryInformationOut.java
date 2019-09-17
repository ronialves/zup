
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationreservetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.fulladdresstypes.FullAddress;
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
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="slotInfo" type="{http://www.cpqd.com.br/etics/SlotInfoTypes}SlotInfo" minOccurs="0"/&gt;
 *         &lt;element name="subscriberAddress" type="{http://www.cpqd.com.br/etics/FullAddressTypes}FullAddress" minOccurs="0"/&gt;
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
    "resourceService",
    "slotInfo",
    "subscriberAddress",
    "clientLogicalPosition",
    "overlappedNetFlag",
    "customElements"
})
public class SupplementaryInformationOut {

    protected ResourceService resourceService;
    protected SlotInfo slotInfo;
    protected FullAddress subscriberAddress;
    @XmlSchemaType(name = "integer")
    protected Integer clientLogicalPosition;
    protected String overlappedNetFlag;
    protected CustomElements customElements;

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
