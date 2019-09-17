
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationallocatetypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.fulladdresstypes.FullAddress;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceaditionalservicetypes.ResourceAditionalService;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceorderinfotypes.ResourceOrderInfo;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceserviceinfotypes.ResourceService;


/**
 * <p>Classe Java de SupplementaryInformationIn complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SupplementaryInformationIn"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceOrderInfo" type="{http://www.cpqd.com.br/etics/ResourceOrderInfoTypes}ResourceOrderInfo" minOccurs="0"/&gt;
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="resourceAditionalService" type="{http://www.cpqd.com.br/etics/ResourceAditionalServiceTypes}ResourceAditionalService" minOccurs="0"/&gt;
 *         &lt;element name="subscriberAddress" type="{http://www.cpqd.com.br/etics/FullAddressTypes}FullAddress" minOccurs="0"/&gt;
 *         &lt;element name="serviceArea" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *         &lt;element name="priority" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="oneStopShop" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="docNumCso" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
 *         &lt;element name="eventuality" type="{http://www.cpqd.com.br/etics/simpletypes}integer2" minOccurs="0"/&gt;
 *         &lt;element name="modemType" type="{http://www.cpqd.com.br/etics/simpletypes}integer3" minOccurs="0"/&gt;
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
@XmlType(name = "SupplementaryInformationIn", propOrder = {
    "resourceOrderInfo",
    "resourceService",
    "resourceAditionalService",
    "subscriberAddress",
    "serviceArea",
    "priority",
    "oneStopShop",
    "docNumCso",
    "eventuality",
    "modemType",
    "customElements"
})
public class SupplementaryInformationIn {

    protected ResourceOrderInfo resourceOrderInfo;
    protected ResourceService resourceService;
    protected ResourceAditionalService resourceAditionalService;
    protected FullAddress subscriberAddress;
    protected String serviceArea;
    protected String priority;
    protected BigInteger oneStopShop;
    protected String docNumCso;
    @XmlSchemaType(name = "integer")
    protected Integer eventuality;
    @XmlSchemaType(name = "integer")
    protected Integer modemType;
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
     * Obtém o valor da propriedade resourceAditionalService.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAditionalService }
     *     
     */
    public ResourceAditionalService getResourceAditionalService() {
        return resourceAditionalService;
    }

    /**
     * Define o valor da propriedade resourceAditionalService.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAditionalService }
     *     
     */
    public void setResourceAditionalService(ResourceAditionalService value) {
        this.resourceAditionalService = value;
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
     * Obtém o valor da propriedade priority.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Define o valor da propriedade priority.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
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
     * Obtém o valor da propriedade docNumCso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNumCso() {
        return docNumCso;
    }

    /**
     * Define o valor da propriedade docNumCso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNumCso(String value) {
        this.docNumCso = value;
    }

    /**
     * Obtém o valor da propriedade eventuality.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEventuality() {
        return eventuality;
    }

    /**
     * Define o valor da propriedade eventuality.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEventuality(Integer value) {
        this.eventuality = value;
    }

    /**
     * Obtém o valor da propriedade modemType.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getModemType() {
        return modemType;
    }

    /**
     * Define o valor da propriedade modemType.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setModemType(Integer value) {
        this.modemType = value;
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
