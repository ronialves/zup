
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.terminalresourcetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourcetypes.Resource;


/**
 * <p>Classe Java de TerminalResource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TerminalResource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="terminalResource" type="{http://www.cpqd.com.br/etics/ResourceTypes}Resource" minOccurs="0"/&gt;
 *         &lt;element name="terminalLogicalCable" type="{http://www.cpqd.com.br/etics/LogicalCableTypes}LogicalCable" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminalResource", propOrder = {
    "terminalResource",
    "terminalLogicalCable"
})
public class TerminalResource {

    protected Resource terminalResource;
    protected LogicalCable terminalLogicalCable;

    /**
     * Obtém o valor da propriedade terminalResource.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getTerminalResource() {
        return terminalResource;
    }

    /**
     * Define o valor da propriedade terminalResource.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setTerminalResource(Resource value) {
        this.terminalResource = value;
    }

    /**
     * Obtém o valor da propriedade terminalLogicalCable.
     * 
     * @return
     *     possible object is
     *     {@link LogicalCable }
     *     
     */
    public LogicalCable getTerminalLogicalCable() {
        return terminalLogicalCable;
    }

    /**
     * Define o valor da propriedade terminalLogicalCable.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicalCable }
     *     
     */
    public void setTerminalLogicalCable(LogicalCable value) {
        this.terminalLogicalCable = value;
    }

}
