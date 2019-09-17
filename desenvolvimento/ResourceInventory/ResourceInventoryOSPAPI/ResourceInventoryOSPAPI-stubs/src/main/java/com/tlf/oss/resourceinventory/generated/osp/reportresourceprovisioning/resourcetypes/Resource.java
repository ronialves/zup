
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcetypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.equipmentstructuretypes.EquipmentStructure;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.logicalcabletypes.LogicalCable;
import com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.resourcespecificationtypes.ResourceSpecification;


/**
 * <p>Classe Java de Resource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Resource"&gt;
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
 *         &lt;element name="code" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="equipmentStructure" type="{http://www.cpqd.com.br/etics/EquipmentStructureTypes}EquipmentStructure" minOccurs="0"/&gt;
 *         &lt;element name="logicalUnit" type="{http://www.cpqd.com.br/etics/simpletypes}integer6" minOccurs="0"/&gt;
 *         &lt;element name="atenuation" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="5"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="-999.99"/&gt;
 *               &lt;maxInclusive value="999.99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="equipamentDistance" type="{http://www.cpqd.com.br/etics/simpletypes}integer6" minOccurs="0"/&gt;
 *         &lt;element name="equipmentPlace" type="{http://www.cpqd.com.br/etics/simpletypes}string1" minOccurs="0"/&gt;
 *         &lt;element name="thirdEquipmentPresence" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.cpqd.com.br/etics/simpletypes}string1"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="buildingFlag" type="{http://www.cpqd.com.br/etics/simpletypes}integerBinary" minOccurs="0"/&gt;
 *         &lt;element name="installationPlace" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="connectorizationType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="function" type="{http://www.cpqd.com.br/etics/simpletypes}integer1" minOccurs="0"/&gt;
 *         &lt;element name="resourceSpecification" type="{http://www.cpqd.com.br/etics/ResourceSpecificationTypes}ResourceSpecification" minOccurs="0"/&gt;
 *         &lt;element name="resourceCharacterist" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
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
@XmlType(name = "Resource", propOrder = {
    "type",
    "code",
    "equipmentStructure",
    "logicalUnit",
    "atenuation",
    "equipamentDistance",
    "equipmentPlace",
    "thirdEquipmentPresence",
    "buildingFlag",
    "installationPlace",
    "connectorizationType",
    "function",
    "resourceSpecification",
    "resourceCharacterist",
    "terminalLogicalCable"
})
public class Resource {

    protected BigInteger type;
    protected String code;
    protected EquipmentStructure equipmentStructure;
    @XmlSchemaType(name = "integer")
    protected Integer logicalUnit;
    protected BigDecimal atenuation;
    @XmlSchemaType(name = "integer")
    protected Integer equipamentDistance;
    protected String equipmentPlace;
    protected String thirdEquipmentPresence;
    protected BigInteger buildingFlag;
    protected BigInteger installationPlace;
    protected BigInteger connectorizationType;
    @XmlSchemaType(name = "integer")
    protected Integer function;
    protected ResourceSpecification resourceSpecification;
    protected Address resourceCharacterist;
    protected LogicalCable terminalLogicalCable;

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
     * Obtém o valor da propriedade equipmentStructure.
     * 
     * @return
     *     possible object is
     *     {@link EquipmentStructure }
     *     
     */
    public EquipmentStructure getEquipmentStructure() {
        return equipmentStructure;
    }

    /**
     * Define o valor da propriedade equipmentStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentStructure }
     *     
     */
    public void setEquipmentStructure(EquipmentStructure value) {
        this.equipmentStructure = value;
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
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAtenuation() {
        return atenuation;
    }

    /**
     * Define o valor da propriedade atenuation.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAtenuation(BigDecimal value) {
        this.atenuation = value;
    }

    /**
     * Obtém o valor da propriedade equipamentDistance.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEquipamentDistance() {
        return equipamentDistance;
    }

    /**
     * Define o valor da propriedade equipamentDistance.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEquipamentDistance(Integer value) {
        this.equipamentDistance = value;
    }

    /**
     * Obtém o valor da propriedade equipmentPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipmentPlace() {
        return equipmentPlace;
    }

    /**
     * Define o valor da propriedade equipmentPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipmentPlace(String value) {
        this.equipmentPlace = value;
    }

    /**
     * Obtém o valor da propriedade thirdEquipmentPresence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThirdEquipmentPresence() {
        return thirdEquipmentPresence;
    }

    /**
     * Define o valor da propriedade thirdEquipmentPresence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThirdEquipmentPresence(String value) {
        this.thirdEquipmentPresence = value;
    }

    /**
     * Obtém o valor da propriedade buildingFlag.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBuildingFlag() {
        return buildingFlag;
    }

    /**
     * Define o valor da propriedade buildingFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBuildingFlag(BigInteger value) {
        this.buildingFlag = value;
    }

    /**
     * Obtém o valor da propriedade installationPlace.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInstallationPlace() {
        return installationPlace;
    }

    /**
     * Define o valor da propriedade installationPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInstallationPlace(BigInteger value) {
        this.installationPlace = value;
    }

    /**
     * Obtém o valor da propriedade connectorizationType.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getConnectorizationType() {
        return connectorizationType;
    }

    /**
     * Define o valor da propriedade connectorizationType.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setConnectorizationType(BigInteger value) {
        this.connectorizationType = value;
    }

    /**
     * Obtém o valor da propriedade function.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFunction() {
        return function;
    }

    /**
     * Define o valor da propriedade function.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFunction(Integer value) {
        this.function = value;
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

    /**
     * Obtém o valor da propriedade resourceCharacterist.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getResourceCharacterist() {
        return resourceCharacterist;
    }

    /**
     * Define o valor da propriedade resourceCharacterist.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setResourceCharacterist(Address value) {
        this.resourceCharacterist = value;
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
