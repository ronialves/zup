
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.equipmentatructuretypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de EquipmentStructure complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EquipmentStructure"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rack" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="subRack" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="board" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *         &lt;element name="slot" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EquipmentStructure", propOrder = {
    "rack",
    "subRack",
    "board",
    "slot"
})
public class EquipmentStructure {

    protected String rack;
    protected String subRack;
    protected String board;
    protected String slot;

    /**
     * Obtém o valor da propriedade rack.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRack() {
        return rack;
    }

    /**
     * Define o valor da propriedade rack.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRack(String value) {
        this.rack = value;
    }

    /**
     * Obtém o valor da propriedade subRack.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubRack() {
        return subRack;
    }

    /**
     * Define o valor da propriedade subRack.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubRack(String value) {
        this.subRack = value;
    }

    /**
     * Obtém o valor da propriedade board.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoard() {
        return board;
    }

    /**
     * Define o valor da propriedade board.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoard(String value) {
        this.board = value;
    }

    /**
     * Obtém o valor da propriedade slot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlot() {
        return slot;
    }

    /**
     * Define o valor da propriedade slot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlot(String value) {
        this.slot = value;
    }

}
