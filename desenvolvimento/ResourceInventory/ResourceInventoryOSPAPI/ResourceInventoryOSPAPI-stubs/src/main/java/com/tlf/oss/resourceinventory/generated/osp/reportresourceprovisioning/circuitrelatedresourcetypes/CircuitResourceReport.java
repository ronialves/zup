
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuitrelatedresourcetypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.circuittypes.CircuitReport;


/**
 * <p>Classe Java de CircuitResourceReport complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CircuitResourceReport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="circuit" type="{http://www.cpqd.com.br/etics/CircuitTypes}CircuitReport" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircuitResourceReport", propOrder = {
    "circuit"
})
public class CircuitResourceReport {

    protected List<CircuitReport> circuit;

    /**
     * Gets the value of the circuit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the circuit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCircuit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CircuitReport }
     * 
     * 
     */
    public List<CircuitReport> getCircuit() {
        if (circuit == null) {
            circuit = new ArrayList<CircuitReport>();
        }
        return this.circuit;
    }

}
