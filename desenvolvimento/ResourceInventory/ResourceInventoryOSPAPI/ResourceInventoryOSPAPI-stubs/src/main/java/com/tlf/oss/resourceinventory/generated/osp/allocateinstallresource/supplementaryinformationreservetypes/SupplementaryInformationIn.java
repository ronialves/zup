
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationreservetypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.customelements.CustomElements;
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
 *         &lt;element name="resourceService" type="{http://www.cpqd.com.br/etics/ResourceServiceInfoTypes}ResourceService" minOccurs="0"/&gt;
 *         &lt;element name="oneStopShop" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
    "resourceService",
    "oneStopShop",
    "customElements"
})
public class SupplementaryInformationIn {

    protected ResourceService resourceService;
    @XmlElement(defaultValue = "1")
    protected BigInteger oneStopShop;
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
