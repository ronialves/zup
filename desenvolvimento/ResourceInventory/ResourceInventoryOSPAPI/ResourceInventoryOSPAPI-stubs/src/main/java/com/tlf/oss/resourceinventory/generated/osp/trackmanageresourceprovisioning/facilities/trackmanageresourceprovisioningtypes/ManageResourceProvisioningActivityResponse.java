
package com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.facilities.trackmanageresourceprovisioningtypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.provisiongtypes.ResultTypeWithErrorCode;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.resourceorderinfotypes.ResourceOrderInfoFull;
import com.tlf.oss.resourceinventory.generated.osp.trackmanageresourceprovisioning.supplementaryinformationmanageprovtypes.SupplementaryInformationOut;


/**
 * <p>Classe Java de ManageResourceProvisioningActivityResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ManageResourceProvisioningActivityResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="result" type="{http://www.cpqd.com.br/etics/provisiongtypes}ResultTypeWithErrorCode"/&gt;
 *         &lt;element name="resourceOrderInfoBD" type="{http://www.cpqd.com.br/etics/ResourceOrderInfoTypes}ResourceOrderInfoFull" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryInformation" type="{http://www.cpqd.com.br/etics/SupplementaryInformationManageProvTypes}SupplementaryInformationOut" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManageResourceProvisioningActivityResponse", propOrder = {
    "result",
    "resourceOrderInfoBD",
    "supplementaryInformation"
})
public class ManageResourceProvisioningActivityResponse {

    @XmlElement(required = true)
    protected ResultTypeWithErrorCode result;
    protected List<ResourceOrderInfoFull> resourceOrderInfoBD;
    protected SupplementaryInformationOut supplementaryInformation;

    /**
     * Obtém o valor da propriedade result.
     * 
     * @return
     *     possible object is
     *     {@link ResultTypeWithErrorCode }
     *     
     */
    public ResultTypeWithErrorCode getResult() {
        return result;
    }

    /**
     * Define o valor da propriedade result.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultTypeWithErrorCode }
     *     
     */
    public void setResult(ResultTypeWithErrorCode value) {
        this.result = value;
    }

    /**
     * Gets the value of the resourceOrderInfoBD property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceOrderInfoBD property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceOrderInfoBD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceOrderInfoFull }
     * 
     * 
     */
    public List<ResourceOrderInfoFull> getResourceOrderInfoBD() {
        if (resourceOrderInfoBD == null) {
            resourceOrderInfoBD = new ArrayList<ResourceOrderInfoFull>();
        }
        return this.resourceOrderInfoBD;
    }

    /**
     * Obtém o valor da propriedade supplementaryInformation.
     * 
     * @return
     *     possible object is
     *     {@link SupplementaryInformationOut }
     *     
     */
    public SupplementaryInformationOut getSupplementaryInformation() {
        return supplementaryInformation;
    }

    /**
     * Define o valor da propriedade supplementaryInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementaryInformationOut }
     *     
     */
    public void setSupplementaryInformation(SupplementaryInformationOut value) {
        this.supplementaryInformation = value;
    }

}
