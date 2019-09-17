
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceservicetypes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourcespecificationtypes.ResourceSpecification;


/**
 * <p>Classe Java de ResourceService complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ResourceService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="code" type="{http://www.cpqd.com.br/etics/simpletypes}string050" minOccurs="0"/&gt;
 *         &lt;element name="logicalUnit" type="{http://www.cpqd.com.br/etics/simpletypes}integer6" minOccurs="0"/&gt;
 *         &lt;element name="atenuation" type="{http://www.cpqd.com.br/etics/provisiongtypes}decimal-or-empty" minOccurs="0"/&gt;
 *         &lt;element name="resourceSpecification" type="{http://www.cpqd.com.br/etics/ResourceSpecificationTypes}ResourceSpecification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceService", propOrder = {
    "type",
    "code",
    "logicalUnit",
    "atenuation",
    "resourceSpecification"
})
public class ResourceService {

    protected BigInteger type;
    protected String code;
    @XmlSchemaType(name = "integer")
    protected Integer logicalUnit;
    @XmlSchemaType(name = "anySimpleType")
    protected String atenuation;
    protected ResourceSpecification resourceSpecification;

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setType(BigInteger value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define o valor da propriedade code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtém o valor da propriedade logicalUnit.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLogicalUnit() {
        return logicalUnit;
    }

    /**
     * Define o valor da propriedade logicalUnit.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLogicalUnit(Integer value) {
        this.logicalUnit = value;
    }

    /**
     * Obtém o valor da propriedade atenuation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtenuation() {
        return atenuation;
    }

    /**
     * Define o valor da propriedade atenuation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtenuation(String value) {
        this.atenuation = value;
    }

    /**
     * Obtém o valor da propriedade resourceSpecification.
     * 
     * @return
     *     possible object is
     *     {@link ResourceSpecification }
     *     
     */
    public ResourceSpecification getResourceSpecification() {
        return resourceSpecification;
    }

    /**
     * Define o valor da propriedade resourceSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceSpecification }
     *     
     */
    public void setResourceSpecification(ResourceSpecification value) {
        this.resourceSpecification = value;
    }

}
