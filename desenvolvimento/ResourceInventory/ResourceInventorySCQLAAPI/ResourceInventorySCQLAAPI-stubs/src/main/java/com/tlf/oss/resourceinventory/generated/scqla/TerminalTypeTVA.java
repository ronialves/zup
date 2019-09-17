
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de terminalTypeTVA complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="terminalTypeTVA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="digito" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="conjugado" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "terminalTypeTVA", propOrder = {
    "digito",
    "conjugado"
})
public class TerminalTypeTVA {

    protected short digito;
    protected short conjugado;

    /**
     * Obtém o valor da propriedade digito.
     * 
     */
    public short getDigito() {
        return digito;
    }

    /**
     * Define o valor da propriedade digito.
     * 
     */
    public void setDigito(short value) {
        this.digito = value;
    }

    /**
     * Obtém o valor da propriedade conjugado.
     * 
     */
    public short getConjugado() {
        return conjugado;
    }

    /**
     * Define o valor da propriedade conjugado.
     * 
     */
    public void setConjugado(short value) {
        this.conjugado = value;
    }

}
