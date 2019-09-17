
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.circuitresourcetypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.circuitlottypes.CircuitLotAllocate;


/**
 * <p>Classe Java de CircuitAllocate complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CircuitAllocate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="circuit" type="{http://www.cpqd.com.br/etics/CircuitLotTypes}CircuitLotAllocate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircuitAllocate", propOrder = {
    "circuit"
})
public class CircuitAllocate {

    protected List<CircuitLotAllocate> circuit;

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
     * {@link CircuitLotAllocate }
     * 
     * 
     */
    public List<CircuitLotAllocate> getCircuit() {
        if (circuit == null) {
            circuit = new ArrayList<CircuitLotAllocate>();
        }
        return this.circuit;
    }

}
