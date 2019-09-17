
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.supplementaryinformationmanageprovtypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.customelements.CustomElements;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceorderinfotypes.ResourceOrderInfo;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceserviceinfotypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.subunittypes.SubUnit;


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
 *         &lt;element name="oneStopShop" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="complAddressInfo" type="{http://www.cpqd.com.br/etics/SubUnitTypes}SubUnit" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "oneStopShop",
    "resourceService",
    "complAddressInfo",
    "customElements"
})
public class SupplementaryInformationIn {

    protected ResourceOrderInfo resourceOrderInfo;
    protected BigInteger oneStopShop;
    protected ResourceService resourceService;
    protected List<SubUnit> complAddressInfo;
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
     * Gets the value of the complAddressInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complAddressInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplAddressInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubUnit }
     * 
     * 
     */
    public List<SubUnit> getComplAddressInfo() {
        if (complAddressInfo == null) {
            complAddressInfo = new ArrayList<SubUnit>();
        }
        return this.complAddressInfo;
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
