
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.provisiongtypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ResultTypeWithErrorCode complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ResultTypeWithErrorCode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.cpqd.com.br/etics/provisiongtypes}ResultType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErrorCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer5" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultTypeWithErrorCode", propOrder = {
    "errorCode"
})
public class ResultTypeWithErrorCode
    extends ResultType
{

    @XmlElement(name = "ErrorCode")
    @XmlSchemaType(name = "integer")
    protected Integer errorCode;

    /**
     * Obtém o valor da propriedade errorCode.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * Define o valor da propriedade errorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCode(Integer value) {
        this.errorCode = value;
    }

}
