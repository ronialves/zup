
package com.tlf.oss.resourceinventory.generated.scqla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de terminalType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="terminalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ddd" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="telefone" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "terminalType", propOrder = {
    "ddd",
    "telefone"
})
public class TerminalType {

    protected int ddd;
    protected int telefone;

    /**
     * Obtém o valor da propriedade ddd.
     * 
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * Define o valor da propriedade ddd.
     * 
     */
    public void setDdd(int value) {
        this.ddd = value;
    }

    /**
     * Obtém o valor da propriedade telefone.
     * 
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * Define o valor da propriedade telefone.
     * 
     */
    public void setTelefone(int value) {
        this.telefone = value;
    }

}
