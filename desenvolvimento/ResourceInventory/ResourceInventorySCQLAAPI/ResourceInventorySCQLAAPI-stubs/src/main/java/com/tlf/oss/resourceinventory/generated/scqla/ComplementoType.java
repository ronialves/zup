
package com.tlf.oss.resourceinventory.generated.scqla;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de complementoType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="complementoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="detalhes" type="{http://br.com.vivo.indra.scqla.ws/}detalheType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complementoType", propOrder = {
    "detalhes"
})
public class ComplementoType {

    @XmlElement(required = true)
    protected List<DetalheType> detalhes;

    /**
     * Gets the value of the detalhes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalhes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalhes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalheType }
     * 
     * 
     */
    public List<DetalheType> getDetalhes() {
        if (detalhes == null) {
            detalhes = new ArrayList<DetalheType>();
        }
        return this.detalhes;
    }

}
