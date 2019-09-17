
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de DistancesType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DistancesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BetweenTerminalBox_Subscriber" type="{http://www.cpqd.com.br/etics/simpletypes}DefaultDecimalDistanceType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistancesType", propOrder = {
    "betweenTerminalBoxSubscriber"
})
public class DistancesType {

    @XmlElement(name = "BetweenTerminalBox_Subscriber")
    protected BigDecimal betweenTerminalBoxSubscriber;

    /**
     * Obtém o valor da propriedade betweenTerminalBoxSubscriber.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBetweenTerminalBoxSubscriber() {
        return betweenTerminalBoxSubscriber;
    }

    /**
     * Define o valor da propriedade betweenTerminalBoxSubscriber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBetweenTerminalBoxSubscriber(BigDecimal value) {
        this.betweenTerminalBoxSubscriber = value;
    }

}
