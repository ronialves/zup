
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.intermediaryresourcetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourcetypes.Resource;


/**
 * <p>Classe Java de IntermediaryResource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="IntermediaryResource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intermediaryResource" type="{http://www.cpqd.com.br/etics/ResourceTypes}Resource" minOccurs="0"/&gt;
 *         &lt;element name="intermediaryLogicalCable" type="{http://www.cpqd.com.br/etics/LogicalCableTypes}LogicalCable" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntermediaryResource", propOrder = {
    "intermediaryResource",
    "intermediaryLogicalCable"
})
public class IntermediaryResource {

    protected Resource intermediaryResource;
    protected LogicalCable intermediaryLogicalCable;

    /**
     * Obtém o valor da propriedade intermediaryResource.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getIntermediaryResource() {
        return intermediaryResource;
    }

    /**
     * Define o valor da propriedade intermediaryResource.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setIntermediaryResource(Resource value) {
        this.intermediaryResource = value;
    }

    /**
     * Obtém o valor da propriedade intermediaryLogicalCable.
     * 
     * @return
     *     possible object is
     *     {@link LogicalCable }
     *     
     */
    public LogicalCable getIntermediaryLogicalCable() {
        return intermediaryLogicalCable;
    }

    /**
     * Define o valor da propriedade intermediaryLogicalCable.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicalCable }
     *     
     */
    public void setIntermediaryLogicalCable(LogicalCable value) {
        this.intermediaryLogicalCable = value;
    }

}
