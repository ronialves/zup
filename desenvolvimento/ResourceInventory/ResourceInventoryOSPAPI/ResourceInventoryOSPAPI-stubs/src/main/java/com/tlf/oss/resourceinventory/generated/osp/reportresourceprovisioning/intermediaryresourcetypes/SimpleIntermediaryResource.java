
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.intermediaryresourcetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcetypes.SimpleResource;


/**
 * <p>Classe Java de SimpleIntermediaryResource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SimpleIntermediaryResource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intermediaryResource" type="{http://www.cpqd.com.br/etics/ResourceTypes}SimpleResource" minOccurs="0"/&gt;
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
@XmlType(name = "SimpleIntermediaryResource", propOrder = {
    "intermediaryResource",
    "intermediaryLogicalCable"
})
public class SimpleIntermediaryResource {

    protected SimpleResource intermediaryResource;
    protected LogicalCable intermediaryLogicalCable;

    /**
     * Obtém o valor da propriedade intermediaryResource.
     * 
     * @return
     *     possible object is
     *     {@link SimpleResource }
     *     
     */
    public SimpleResource getIntermediaryResource() {
        return intermediaryResource;
    }

    /**
     * Define o valor da propriedade intermediaryResource.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleResource }
     *     
     */
    public void setIntermediaryResource(SimpleResource value) {
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
