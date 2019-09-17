
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.customerresourcetypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes.CustomInicialResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes.IntermediaryAvailableResource;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.terminalresourcetypes.TerminalAvailableResource;


/**
 * <p>Classe Java de CustomAvailableResources complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CustomAvailableResources"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="relatedInicialResources" type="{http://www.cpqd.com.br/etics/InicialResourceTypes}CustomInicialResource" minOccurs="0"/&gt;
 *         &lt;element name="relatedIntermediaryResources" type="{http://www.cpqd.com.br/etics/IntermediaryResourceTypes}IntermediaryAvailableResource" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="relatedTerminalResources" type="{http://www.cpqd.com.br/etics/TerminalResourceTypes}TerminalAvailableResource" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomAvailableResources", propOrder = {
    "relatedInicialResources",
    "relatedIntermediaryResources",
    "relatedTerminalResources"
})
public class CustomAvailableResources {

    protected CustomInicialResource relatedInicialResources;
    protected List<IntermediaryAvailableResource> relatedIntermediaryResources;
    protected TerminalAvailableResource relatedTerminalResources;

    /**
     * Obtém o valor da propriedade relatedInicialResources.
     * 
     * @return
     *     possible object is
     *     {@link CustomInicialResource }
     *     
     */
    public CustomInicialResource getRelatedInicialResources() {
        return relatedInicialResources;
    }

    /**
     * Define o valor da propriedade relatedInicialResources.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomInicialResource }
     *     
     */
    public void setRelatedInicialResources(CustomInicialResource value) {
        this.relatedInicialResources = value;
    }

    /**
     * Gets the value of the relatedIntermediaryResources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedIntermediaryResources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedIntermediaryResources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntermediaryAvailableResource }
     * 
     * 
     */
    public List<IntermediaryAvailableResource> getRelatedIntermediaryResources() {
        if (relatedIntermediaryResources == null) {
            relatedIntermediaryResources = new ArrayList<IntermediaryAvailableResource>();
        }
        return this.relatedIntermediaryResources;
    }

    /**
     * Obtém o valor da propriedade relatedTerminalResources.
     * 
     * @return
     *     possible object is
     *     {@link TerminalAvailableResource }
     *     
     */
    public TerminalAvailableResource getRelatedTerminalResources() {
        return relatedTerminalResources;
    }

    /**
     * Define o valor da propriedade relatedTerminalResources.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalAvailableResource }
     *     
     */
    public void setRelatedTerminalResources(TerminalAvailableResource value) {
        this.relatedTerminalResources = value;
    }

}
