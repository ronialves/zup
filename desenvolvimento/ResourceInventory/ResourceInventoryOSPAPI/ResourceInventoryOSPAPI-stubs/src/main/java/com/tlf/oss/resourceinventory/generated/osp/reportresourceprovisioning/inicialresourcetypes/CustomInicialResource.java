
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.inicialresourcetypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcetypes.Resource;


/**
 * <p>Classe Java de CustomInicialResource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CustomInicialResource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="initialResource" type="{http://www.cpqd.com.br/etics/ResourceTypes}Resource" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomInicialResource", propOrder = {
    "initialResource"
})
public class CustomInicialResource {

    protected Resource initialResource;

    /**
     * Obtém o valor da propriedade initialResource.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getInitialResource() {
        return initialResource;
    }

    /**
     * Define o valor da propriedade initialResource.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setInitialResource(Resource value) {
        this.initialResource = value;
    }

}
