
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.addresstypes.Address;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.complementaddresstypes.ComplementAddress;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.provisiongtypes.ResultTypeWithErrorCode;


/**
 * <p>Classe Java de DetermineResourceAvailabilityResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DetermineResourceAvailabilityResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="result" type="{http://www.cpqd.com.br/etics/provisiongtypes}ResultTypeWithErrorCode"/&gt;
 *         &lt;element name="inService" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="cityCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer9"/&gt;
 *                   &lt;element name="identifier" type="{http://www.cpqd.com.br/etics/simpletypes}string60"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="reserveOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string015" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
 *         &lt;element name="restrictions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="restriction" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="restrictionObject"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="0|1|2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="restrictionObjectId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                             &lt;element name="restrictionCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
 *                             &lt;element name="restrictionDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="serviceRestrictions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="serviceRestriction" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="serviceRestrictObject"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="0|1|2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="serviceRestrictObjectId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                             &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30"/&gt;
 *                             &lt;element name="serviceRestrictCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
 *                             &lt;element name="serviceRestrictDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="coverage" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="feasibility" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;pattern value="0|1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="qualifiedServices" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="service" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="serviceCoverage"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="0|1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="serviceFeasibility" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="0|1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30"/&gt;
 *                             &lt;element name="serviceTypeDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
 *                             &lt;element name="category" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *                             &lt;element name="categoryDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
 *                             &lt;element name="facility" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *                             &lt;element name="facilityDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *                             &lt;element name="facilityValue" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *                             &lt;element name="facilityUnit" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *                             &lt;element name="facilityTech" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
 *                             &lt;element name="serviceGroup" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *                             &lt;element name="resourcesList" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="resourceByPriority" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *                                                 &lt;element name="netTypePriority" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="qualifiedResources" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="resource" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="netType"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="1|2|3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="resourceType" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="0|1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *                             &lt;element name="resourceCoverage"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="0|1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="resourceFeasibility" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                   &lt;pattern value="0|1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="attributes" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                               &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                             &lt;/extension&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="additionalInformation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="complementList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="horizontalComplementAddress" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="verticalComplementAddress" type="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="verticalComplementAddress" type="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="messages" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="message" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ruleName" type="{http://www.cpqd.com.br/etics/simpletypes}string100" minOccurs="0"/&gt;
 *                             &lt;element name="messageCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
 *                             &lt;element name="messageDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
 *                             &lt;element name="attributes" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                                               &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                             &lt;/extension&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetermineResourceAvailabilityResponse", propOrder = {
    "result",
    "inService",
    "reserveOrder",
    "address",
    "restrictions",
    "serviceRestrictions",
    "coverage",
    "feasibility",
    "qualifiedServices",
    "qualifiedResources",
    "additionalInformation",
    "complementList",
    "messages"
})
public class DetermineResourceAvailabilityResponse {

    @XmlElement(required = true)
    protected ResultTypeWithErrorCode result;
    protected DetermineResourceAvailabilityResponse.InService inService;
    protected String reserveOrder;
    protected Address address;
    protected DetermineResourceAvailabilityResponse.Restrictions restrictions;
    protected DetermineResourceAvailabilityResponse.ServiceRestrictions serviceRestrictions;
    protected BigInteger coverage;
    protected BigInteger feasibility;
    protected DetermineResourceAvailabilityResponse.QualifiedServices qualifiedServices;
    protected DetermineResourceAvailabilityResponse.QualifiedResources qualifiedResources;
    protected DetermineResourceAvailabilityResponse.AdditionalInformation additionalInformation;
    protected DetermineResourceAvailabilityResponse.ComplementList complementList;
    protected DetermineResourceAvailabilityResponse.Messages messages;

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
     * Obtém o valor da propriedade inService.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.InService }
     *     
     */
    public DetermineResourceAvailabilityResponse.InService getInService() {
        return inService;
    }

    /**
     * Define o valor da propriedade inService.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.InService }
     *     
     */
    public void setInService(DetermineResourceAvailabilityResponse.InService value) {
        this.inService = value;
    }

    /**
     * Obtém o valor da propriedade reserveOrder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserveOrder() {
        return reserveOrder;
    }

    /**
     * Define o valor da propriedade reserveOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserveOrder(String value) {
        this.reserveOrder = value;
    }

    /**
     * Obtém o valor da propriedade address.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Define o valor da propriedade address.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Obtém o valor da propriedade restrictions.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.Restrictions }
     *     
     */
    public DetermineResourceAvailabilityResponse.Restrictions getRestrictions() {
        return restrictions;
    }

    /**
     * Define o valor da propriedade restrictions.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.Restrictions }
     *     
     */
    public void setRestrictions(DetermineResourceAvailabilityResponse.Restrictions value) {
        this.restrictions = value;
    }

    /**
     * Obtém o valor da propriedade serviceRestrictions.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.ServiceRestrictions }
     *     
     */
    public DetermineResourceAvailabilityResponse.ServiceRestrictions getServiceRestrictions() {
        return serviceRestrictions;
    }

    /**
     * Define o valor da propriedade serviceRestrictions.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.ServiceRestrictions }
     *     
     */
    public void setServiceRestrictions(DetermineResourceAvailabilityResponse.ServiceRestrictions value) {
        this.serviceRestrictions = value;
    }

    /**
     * Obtém o valor da propriedade coverage.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCoverage() {
        return coverage;
    }

    /**
     * Define o valor da propriedade coverage.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCoverage(BigInteger value) {
        this.coverage = value;
    }

    /**
     * Obtém o valor da propriedade feasibility.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFeasibility() {
        return feasibility;
    }

    /**
     * Define o valor da propriedade feasibility.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFeasibility(BigInteger value) {
        this.feasibility = value;
    }

    /**
     * Obtém o valor da propriedade qualifiedServices.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.QualifiedServices }
     *     
     */
    public DetermineResourceAvailabilityResponse.QualifiedServices getQualifiedServices() {
        return qualifiedServices;
    }

    /**
     * Define o valor da propriedade qualifiedServices.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.QualifiedServices }
     *     
     */
    public void setQualifiedServices(DetermineResourceAvailabilityResponse.QualifiedServices value) {
        this.qualifiedServices = value;
    }

    /**
     * Obtém o valor da propriedade qualifiedResources.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.QualifiedResources }
     *     
     */
    public DetermineResourceAvailabilityResponse.QualifiedResources getQualifiedResources() {
        return qualifiedResources;
    }

    /**
     * Define o valor da propriedade qualifiedResources.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.QualifiedResources }
     *     
     */
    public void setQualifiedResources(DetermineResourceAvailabilityResponse.QualifiedResources value) {
        this.qualifiedResources = value;
    }

    /**
     * Obtém o valor da propriedade additionalInformation.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.AdditionalInformation }
     *     
     */
    public DetermineResourceAvailabilityResponse.AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Define o valor da propriedade additionalInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.AdditionalInformation }
     *     
     */
    public void setAdditionalInformation(DetermineResourceAvailabilityResponse.AdditionalInformation value) {
        this.additionalInformation = value;
    }

    /**
     * Obtém o valor da propriedade complementList.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.ComplementList }
     *     
     */
    public DetermineResourceAvailabilityResponse.ComplementList getComplementList() {
        return complementList;
    }

    /**
     * Define o valor da propriedade complementList.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.ComplementList }
     *     
     */
    public void setComplementList(DetermineResourceAvailabilityResponse.ComplementList value) {
        this.complementList = value;
    }

    /**
     * Obtém o valor da propriedade messages.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityResponse.Messages }
     *     
     */
    public DetermineResourceAvailabilityResponse.Messages getMessages() {
        return messages;
    }

    /**
     * Define o valor da propriedade messages.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityResponse.Messages }
     *     
     */
    public void setMessages(DetermineResourceAvailabilityResponse.Messages value) {
        this.messages = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tag"
    })
    public static class AdditionalInformation {

        @XmlElement(nillable = true)
        protected List<DetermineResourceAvailabilityResponse.AdditionalInformation.Tag> tag;

        /**
         * Gets the value of the tag property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tag property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTag().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetermineResourceAvailabilityResponse.AdditionalInformation.Tag }
         * 
         * 
         */
        public List<DetermineResourceAvailabilityResponse.AdditionalInformation.Tag> getTag() {
            if (tag == null) {
                tag = new ArrayList<DetermineResourceAvailabilityResponse.AdditionalInformation.Tag>();
            }
            return this.tag;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Tag {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "label")
            protected String label;

            /**
             * Obtém o valor da propriedade value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define o valor da propriedade value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtém o valor da propriedade label.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLabel() {
                return label;
            }

            /**
             * Define o valor da propriedade label.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLabel(String value) {
                this.label = value;
            }

        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="horizontalComplementAddress" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="verticalComplementAddress" type="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="verticalComplementAddress" type="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "horizontalComplementAddress",
        "verticalComplementAddress"
    })
    public static class ComplementList {

        protected List<DetermineResourceAvailabilityResponse.ComplementList.HorizontalComplementAddress> horizontalComplementAddress;
        protected List<ComplementAddress> verticalComplementAddress;

        /**
         * Gets the value of the horizontalComplementAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the horizontalComplementAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHorizontalComplementAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetermineResourceAvailabilityResponse.ComplementList.HorizontalComplementAddress }
         * 
         * 
         */
        public List<DetermineResourceAvailabilityResponse.ComplementList.HorizontalComplementAddress> getHorizontalComplementAddress() {
            if (horizontalComplementAddress == null) {
                horizontalComplementAddress = new ArrayList<DetermineResourceAvailabilityResponse.ComplementList.HorizontalComplementAddress>();
            }
            return this.horizontalComplementAddress;
        }

        /**
         * Gets the value of the verticalComplementAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the verticalComplementAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVerticalComplementAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ComplementAddress }
         * 
         * 
         */
        public List<ComplementAddress> getVerticalComplementAddress() {
            if (verticalComplementAddress == null) {
                verticalComplementAddress = new ArrayList<ComplementAddress>();
            }
            return this.verticalComplementAddress;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="verticalComplementAddress" type="{http://www.cpqd.com.br/etics/ComplementAddressTypes}ComplementAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "verticalComplementAddress"
        })
        public static class HorizontalComplementAddress
            extends ComplementAddress
        {

            protected List<ComplementAddress> verticalComplementAddress;

            /**
             * Gets the value of the verticalComplementAddress property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the verticalComplementAddress property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVerticalComplementAddress().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ComplementAddress }
             * 
             * 
             */
            public List<ComplementAddress> getVerticalComplementAddress() {
                if (verticalComplementAddress == null) {
                    verticalComplementAddress = new ArrayList<ComplementAddress>();
                }
                return this.verticalComplementAddress;
            }

        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="cityCode" type="{http://www.cpqd.com.br/etics/simpletypes}integer9"/&gt;
     *         &lt;element name="identifier" type="{http://www.cpqd.com.br/etics/simpletypes}string60"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cityCode",
        "identifier"
    })
    public static class InService {

        @XmlSchemaType(name = "integer")
        protected int cityCode;
        @XmlElement(required = true)
        protected String identifier;

        /**
         * Obtém o valor da propriedade cityCode.
         * 
         */
        public int getCityCode() {
            return cityCode;
        }

        /**
         * Define o valor da propriedade cityCode.
         * 
         */
        public void setCityCode(int value) {
            this.cityCode = value;
        }

        /**
         * Obtém o valor da propriedade identifier.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdentifier() {
            return identifier;
        }

        /**
         * Define o valor da propriedade identifier.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdentifier(String value) {
            this.identifier = value;
        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="message" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ruleName" type="{http://www.cpqd.com.br/etics/simpletypes}string100" minOccurs="0"/&gt;
     *                   &lt;element name="messageCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
     *                   &lt;element name="messageDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
     *                   &lt;element name="attributes" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                                     &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                                   &lt;/extension&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "message"
    })
    public static class Messages {

        protected List<DetermineResourceAvailabilityResponse.Messages.Message> message;

        /**
         * Gets the value of the message property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the message property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMessage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetermineResourceAvailabilityResponse.Messages.Message }
         * 
         * 
         */
        public List<DetermineResourceAvailabilityResponse.Messages.Message> getMessage() {
            if (message == null) {
                message = new ArrayList<DetermineResourceAvailabilityResponse.Messages.Message>();
            }
            return this.message;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ruleName" type="{http://www.cpqd.com.br/etics/simpletypes}string100" minOccurs="0"/&gt;
         *         &lt;element name="messageCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
         *         &lt;element name="messageDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
         *         &lt;element name="attributes" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *                           &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                         &lt;/extension&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "ruleName",
            "messageCode",
            "messageDesc",
            "attributes"
        })
        public static class Message {

            protected String ruleName;
            protected String messageCode;
            protected String messageDesc;
            protected DetermineResourceAvailabilityResponse.Messages.Message.Attributes attributes;

            /**
             * Obtém o valor da propriedade ruleName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRuleName() {
                return ruleName;
            }

            /**
             * Define o valor da propriedade ruleName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRuleName(String value) {
                this.ruleName = value;
            }

            /**
             * Obtém o valor da propriedade messageCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMessageCode() {
                return messageCode;
            }

            /**
             * Define o valor da propriedade messageCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMessageCode(String value) {
                this.messageCode = value;
            }

            /**
             * Obtém o valor da propriedade messageDesc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMessageDesc() {
                return messageDesc;
            }

            /**
             * Define o valor da propriedade messageDesc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMessageDesc(String value) {
                this.messageDesc = value;
            }

            /**
             * Obtém o valor da propriedade attributes.
             * 
             * @return
             *     possible object is
             *     {@link DetermineResourceAvailabilityResponse.Messages.Message.Attributes }
             *     
             */
            public DetermineResourceAvailabilityResponse.Messages.Message.Attributes getAttributes() {
                return attributes;
            }

            /**
             * Define o valor da propriedade attributes.
             * 
             * @param value
             *     allowed object is
             *     {@link DetermineResourceAvailabilityResponse.Messages.Message.Attributes }
             *     
             */
            public void setAttributes(DetermineResourceAvailabilityResponse.Messages.Message.Attributes value) {
                this.attributes = value;
            }


            /**
             * <p>Classe Java de anonymous complex type.
             * 
             * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
             *                 &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *               &lt;/extension&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "tag"
            })
            public static class Attributes {

                @XmlElement(nillable = true)
                protected List<DetermineResourceAvailabilityResponse.Messages.Message.Attributes.Tag> tag;

                /**
                 * Gets the value of the tag property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the tag property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTag().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link DetermineResourceAvailabilityResponse.Messages.Message.Attributes.Tag }
                 * 
                 * 
                 */
                public List<DetermineResourceAvailabilityResponse.Messages.Message.Attributes.Tag> getTag() {
                    if (tag == null) {
                        tag = new ArrayList<DetermineResourceAvailabilityResponse.Messages.Message.Attributes.Tag>();
                    }
                    return this.tag;
                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
                 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
                 *     &lt;/extension&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Tag {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "label")
                    protected String label;

                    /**
                     * Obtém o valor da propriedade value.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Define o valor da propriedade value.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Obtém o valor da propriedade label.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLabel() {
                        return label;
                    }

                    /**
                     * Define o valor da propriedade label.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLabel(String value) {
                        this.label = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="resource" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="netType"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="1|2|3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="resourceType" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="0|1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
     *                   &lt;element name="resourceCoverage"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="0|1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="resourceFeasibility" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="0|1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="attributes" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                                     &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                                   &lt;/extension&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "resource"
    })
    public static class QualifiedResources {

        protected List<DetermineResourceAvailabilityResponse.QualifiedResources.Resource> resource;

        /**
         * Gets the value of the resource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetermineResourceAvailabilityResponse.QualifiedResources.Resource }
         * 
         * 
         */
        public List<DetermineResourceAvailabilityResponse.QualifiedResources.Resource> getResource() {
            if (resource == null) {
                resource = new ArrayList<DetermineResourceAvailabilityResponse.QualifiedResources.Resource>();
            }
            return this.resource;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="netType"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="1|2|3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="resourceType" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="0|1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
         *         &lt;element name="resourceCoverage"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="0|1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="resourceFeasibility" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="0|1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="attributes" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
         *                           &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *                         &lt;/extension&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "netType",
            "resourceType",
            "resourceIdentifier",
            "resourceCoverage",
            "resourceFeasibility",
            "attributes"
        })
        public static class Resource {

            @XmlElement(required = true)
            protected BigInteger netType;
            protected BigInteger resourceType;
            protected BigInteger resourceIdentifier;
            @XmlElement(required = true)
            protected BigInteger resourceCoverage;
            protected BigInteger resourceFeasibility;
            protected DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes attributes;

            /**
             * Obtém o valor da propriedade netType.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNetType() {
                return netType;
            }

            /**
             * Define o valor da propriedade netType.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNetType(BigInteger value) {
                this.netType = value;
            }

            /**
             * Obtém o valor da propriedade resourceType.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getResourceType() {
                return resourceType;
            }

            /**
             * Define o valor da propriedade resourceType.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setResourceType(BigInteger value) {
                this.resourceType = value;
            }

            /**
             * Obtém o valor da propriedade resourceIdentifier.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getResourceIdentifier() {
                return resourceIdentifier;
            }

            /**
             * Define o valor da propriedade resourceIdentifier.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setResourceIdentifier(BigInteger value) {
                this.resourceIdentifier = value;
            }

            /**
             * Obtém o valor da propriedade resourceCoverage.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getResourceCoverage() {
                return resourceCoverage;
            }

            /**
             * Define o valor da propriedade resourceCoverage.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setResourceCoverage(BigInteger value) {
                this.resourceCoverage = value;
            }

            /**
             * Obtém o valor da propriedade resourceFeasibility.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getResourceFeasibility() {
                return resourceFeasibility;
            }

            /**
             * Define o valor da propriedade resourceFeasibility.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setResourceFeasibility(BigInteger value) {
                this.resourceFeasibility = value;
            }

            /**
             * Obtém o valor da propriedade attributes.
             * 
             * @return
             *     possible object is
             *     {@link DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes }
             *     
             */
            public DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes getAttributes() {
                return attributes;
            }

            /**
             * Define o valor da propriedade attributes.
             * 
             * @param value
             *     allowed object is
             *     {@link DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes }
             *     
             */
            public void setAttributes(DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes value) {
                this.attributes = value;
            }


            /**
             * <p>Classe Java de anonymous complex type.
             * 
             * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="tag" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
             *                 &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *               &lt;/extension&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "tag"
            })
            public static class Attributes {

                @XmlElement(nillable = true)
                protected List<DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes.Tag> tag;

                /**
                 * Gets the value of the tag property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the tag property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTag().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes.Tag }
                 * 
                 * 
                 */
                public List<DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes.Tag> getTag() {
                    if (tag == null) {
                        tag = new ArrayList<DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes.Tag>();
                    }
                    return this.tag;
                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
                 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
                 *     &lt;/extension&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Tag {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "label")
                    protected String label;

                    /**
                     * Obtém o valor da propriedade value.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Define o valor da propriedade value.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Obtém o valor da propriedade label.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLabel() {
                        return label;
                    }

                    /**
                     * Define o valor da propriedade label.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLabel(String value) {
                        this.label = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="service" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="serviceCoverage"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="0|1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="serviceFeasibility" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="0|1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30"/&gt;
     *                   &lt;element name="serviceTypeDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
     *                   &lt;element name="category" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
     *                   &lt;element name="categoryDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
     *                   &lt;element name="facility" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
     *                   &lt;element name="facilityDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
     *                   &lt;element name="facilityValue" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
     *                   &lt;element name="facilityUnit" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
     *                   &lt;element name="facilityTech" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
     *                   &lt;element name="serviceGroup" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
     *                   &lt;element name="resourcesList" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="resourceByPriority" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
     *                                       &lt;element name="netTypePriority" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "service"
    })
    public static class QualifiedServices {

        protected List<DetermineResourceAvailabilityResponse.QualifiedServices.Service> service;

        /**
         * Gets the value of the service property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the service property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetermineResourceAvailabilityResponse.QualifiedServices.Service }
         * 
         * 
         */
        public List<DetermineResourceAvailabilityResponse.QualifiedServices.Service> getService() {
            if (service == null) {
                service = new ArrayList<DetermineResourceAvailabilityResponse.QualifiedServices.Service>();
            }
            return this.service;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="serviceCoverage"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="0|1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="serviceFeasibility" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="0|1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30"/&gt;
         *         &lt;element name="serviceTypeDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
         *         &lt;element name="category" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
         *         &lt;element name="categoryDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string300" minOccurs="0"/&gt;
         *         &lt;element name="facility" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
         *         &lt;element name="facilityDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
         *         &lt;element name="facilityValue" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
         *         &lt;element name="facilityUnit" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
         *         &lt;element name="facilityTech" type="{http://www.cpqd.com.br/etics/simpletypes}string15" minOccurs="0"/&gt;
         *         &lt;element name="serviceGroup" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
         *         &lt;element name="resourcesList" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="resourceByPriority" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
         *                             &lt;element name="netTypePriority" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "serviceCoverage",
            "serviceFeasibility",
            "serviceType",
            "serviceTypeDesc",
            "category",
            "categoryDesc",
            "facility",
            "facilityDesc",
            "facilityValue",
            "facilityUnit",
            "facilityTech",
            "serviceGroup",
            "resourcesList"
        })
        public static class Service {

            @XmlElement(required = true)
            protected BigInteger serviceCoverage;
            protected BigInteger serviceFeasibility;
            @XmlElement(required = true)
            protected String serviceType;
            protected String serviceTypeDesc;
            protected String category;
            protected String categoryDesc;
            protected String facility;
            protected String facilityDesc;
            protected BigInteger facilityValue;
            protected String facilityUnit;
            protected String facilityTech;
            protected String serviceGroup;
            protected DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList resourcesList;

            /**
             * Obtém o valor da propriedade serviceCoverage.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getServiceCoverage() {
                return serviceCoverage;
            }

            /**
             * Define o valor da propriedade serviceCoverage.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setServiceCoverage(BigInteger value) {
                this.serviceCoverage = value;
            }

            /**
             * Obtém o valor da propriedade serviceFeasibility.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getServiceFeasibility() {
                return serviceFeasibility;
            }

            /**
             * Define o valor da propriedade serviceFeasibility.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setServiceFeasibility(BigInteger value) {
                this.serviceFeasibility = value;
            }

            /**
             * Obtém o valor da propriedade serviceType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceType() {
                return serviceType;
            }

            /**
             * Define o valor da propriedade serviceType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceType(String value) {
                this.serviceType = value;
            }

            /**
             * Obtém o valor da propriedade serviceTypeDesc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceTypeDesc() {
                return serviceTypeDesc;
            }

            /**
             * Define o valor da propriedade serviceTypeDesc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceTypeDesc(String value) {
                this.serviceTypeDesc = value;
            }

            /**
             * Obtém o valor da propriedade category.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategory() {
                return category;
            }

            /**
             * Define o valor da propriedade category.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategory(String value) {
                this.category = value;
            }

            /**
             * Obtém o valor da propriedade categoryDesc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategoryDesc() {
                return categoryDesc;
            }

            /**
             * Define o valor da propriedade categoryDesc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategoryDesc(String value) {
                this.categoryDesc = value;
            }

            /**
             * Obtém o valor da propriedade facility.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFacility() {
                return facility;
            }

            /**
             * Define o valor da propriedade facility.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFacility(String value) {
                this.facility = value;
            }

            /**
             * Obtém o valor da propriedade facilityDesc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFacilityDesc() {
                return facilityDesc;
            }

            /**
             * Define o valor da propriedade facilityDesc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFacilityDesc(String value) {
                this.facilityDesc = value;
            }

            /**
             * Obtém o valor da propriedade facilityValue.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getFacilityValue() {
                return facilityValue;
            }

            /**
             * Define o valor da propriedade facilityValue.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setFacilityValue(BigInteger value) {
                this.facilityValue = value;
            }

            /**
             * Obtém o valor da propriedade facilityUnit.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFacilityUnit() {
                return facilityUnit;
            }

            /**
             * Define o valor da propriedade facilityUnit.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFacilityUnit(String value) {
                this.facilityUnit = value;
            }

            /**
             * Obtém o valor da propriedade facilityTech.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFacilityTech() {
                return facilityTech;
            }

            /**
             * Define o valor da propriedade facilityTech.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFacilityTech(String value) {
                this.facilityTech = value;
            }

            /**
             * Obtém o valor da propriedade serviceGroup.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceGroup() {
                return serviceGroup;
            }

            /**
             * Define o valor da propriedade serviceGroup.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceGroup(String value) {
                this.serviceGroup = value;
            }

            /**
             * Obtém o valor da propriedade resourcesList.
             * 
             * @return
             *     possible object is
             *     {@link DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList }
             *     
             */
            public DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList getResourcesList() {
                return resourcesList;
            }

            /**
             * Define o valor da propriedade resourcesList.
             * 
             * @param value
             *     allowed object is
             *     {@link DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList }
             *     
             */
            public void setResourcesList(DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList value) {
                this.resourcesList = value;
            }


            /**
             * <p>Classe Java de anonymous complex type.
             * 
             * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="resourceByPriority" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
             *                   &lt;element name="netTypePriority" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "resourceByPriority"
            })
            public static class ResourcesList {

                protected List<DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList.ResourceByPriority> resourceByPriority;

                /**
                 * Gets the value of the resourceByPriority property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the resourceByPriority property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getResourceByPriority().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList.ResourceByPriority }
                 * 
                 * 
                 */
                public List<DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList.ResourceByPriority> getResourceByPriority() {
                    if (resourceByPriority == null) {
                        resourceByPriority = new ArrayList<DetermineResourceAvailabilityResponse.QualifiedServices.Service.ResourcesList.ResourceByPriority>();
                    }
                    return this.resourceByPriority;
                }


                /**
                 * <p>Classe Java de anonymous complex type.
                 * 
                 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
                 *         &lt;element name="netTypePriority" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "resourceIdentifier",
                    "netTypePriority"
                })
                public static class ResourceByPriority {

                    protected BigInteger resourceIdentifier;
                    protected BigInteger netTypePriority;

                    /**
                     * Obtém o valor da propriedade resourceIdentifier.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getResourceIdentifier() {
                        return resourceIdentifier;
                    }

                    /**
                     * Define o valor da propriedade resourceIdentifier.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setResourceIdentifier(BigInteger value) {
                        this.resourceIdentifier = value;
                    }

                    /**
                     * Obtém o valor da propriedade netTypePriority.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getNetTypePriority() {
                        return netTypePriority;
                    }

                    /**
                     * Define o valor da propriedade netTypePriority.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setNetTypePriority(BigInteger value) {
                        this.netTypePriority = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="restriction" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="restrictionObject"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="0|1|2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="restrictionObjectId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *                   &lt;element name="restrictionCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
     *                   &lt;element name="restrictionDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "restriction"
    })
    public static class Restrictions {

        @XmlElement(required = true)
        protected List<DetermineResourceAvailabilityResponse.Restrictions.Restriction> restriction;

        /**
         * Gets the value of the restriction property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the restriction property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRestriction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetermineResourceAvailabilityResponse.Restrictions.Restriction }
         * 
         * 
         */
        public List<DetermineResourceAvailabilityResponse.Restrictions.Restriction> getRestriction() {
            if (restriction == null) {
                restriction = new ArrayList<DetermineResourceAvailabilityResponse.Restrictions.Restriction>();
            }
            return this.restriction;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="restrictionObject"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="0|1|2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="restrictionObjectId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
         *         &lt;element name="restrictionCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
         *         &lt;element name="restrictionDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "restrictionObject",
            "restrictionObjectId",
            "restrictionCode",
            "restrictionDesc"
        })
        public static class Restriction {

            @XmlElement(required = true)
            protected BigInteger restrictionObject;
            @XmlElement(required = true)
            protected BigInteger restrictionObjectId;
            @XmlElement(required = true)
            protected String restrictionCode;
            protected String restrictionDesc;

            /**
             * Obtém o valor da propriedade restrictionObject.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getRestrictionObject() {
                return restrictionObject;
            }

            /**
             * Define o valor da propriedade restrictionObject.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setRestrictionObject(BigInteger value) {
                this.restrictionObject = value;
            }

            /**
             * Obtém o valor da propriedade restrictionObjectId.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getRestrictionObjectId() {
                return restrictionObjectId;
            }

            /**
             * Define o valor da propriedade restrictionObjectId.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setRestrictionObjectId(BigInteger value) {
                this.restrictionObjectId = value;
            }

            /**
             * Obtém o valor da propriedade restrictionCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRestrictionCode() {
                return restrictionCode;
            }

            /**
             * Define o valor da propriedade restrictionCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRestrictionCode(String value) {
                this.restrictionCode = value;
            }

            /**
             * Obtém o valor da propriedade restrictionDesc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRestrictionDesc() {
                return restrictionDesc;
            }

            /**
             * Define o valor da propriedade restrictionDesc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRestrictionDesc(String value) {
                this.restrictionDesc = value;
            }

        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="serviceRestriction" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="serviceRestrictObject"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                         &lt;pattern value="0|1|2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="serviceRestrictObjectId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *                   &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30"/&gt;
     *                   &lt;element name="serviceRestrictCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
     *                   &lt;element name="serviceRestrictDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "serviceRestriction"
    })
    public static class ServiceRestrictions {

        @XmlElement(required = true)
        protected List<DetermineResourceAvailabilityResponse.ServiceRestrictions.ServiceRestriction> serviceRestriction;

        /**
         * Gets the value of the serviceRestriction property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the serviceRestriction property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServiceRestriction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DetermineResourceAvailabilityResponse.ServiceRestrictions.ServiceRestriction }
         * 
         * 
         */
        public List<DetermineResourceAvailabilityResponse.ServiceRestrictions.ServiceRestriction> getServiceRestriction() {
            if (serviceRestriction == null) {
                serviceRestriction = new ArrayList<DetermineResourceAvailabilityResponse.ServiceRestrictions.ServiceRestriction>();
            }
            return this.serviceRestriction;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="serviceRestrictObject"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *               &lt;pattern value="0|1|2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="serviceRestrictObjectId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
         *         &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30"/&gt;
         *         &lt;element name="serviceRestrictCode" type="{http://www.cpqd.com.br/etics/simpletypes}string50"/&gt;
         *         &lt;element name="serviceRestrictDesc" type="{http://www.cpqd.com.br/etics/simpletypes}string50" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "serviceRestrictObject",
            "serviceRestrictObjectId",
            "serviceType",
            "serviceRestrictCode",
            "serviceRestrictDesc"
        })
        public static class ServiceRestriction {

            @XmlElement(required = true)
            protected BigInteger serviceRestrictObject;
            @XmlElement(required = true)
            protected BigInteger serviceRestrictObjectId;
            @XmlElement(required = true)
            protected String serviceType;
            @XmlElement(required = true)
            protected String serviceRestrictCode;
            protected String serviceRestrictDesc;

            /**
             * Obtém o valor da propriedade serviceRestrictObject.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getServiceRestrictObject() {
                return serviceRestrictObject;
            }

            /**
             * Define o valor da propriedade serviceRestrictObject.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setServiceRestrictObject(BigInteger value) {
                this.serviceRestrictObject = value;
            }

            /**
             * Obtém o valor da propriedade serviceRestrictObjectId.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getServiceRestrictObjectId() {
                return serviceRestrictObjectId;
            }

            /**
             * Define o valor da propriedade serviceRestrictObjectId.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setServiceRestrictObjectId(BigInteger value) {
                this.serviceRestrictObjectId = value;
            }

            /**
             * Obtém o valor da propriedade serviceType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceType() {
                return serviceType;
            }

            /**
             * Define o valor da propriedade serviceType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceType(String value) {
                this.serviceType = value;
            }

            /**
             * Obtém o valor da propriedade serviceRestrictCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceRestrictCode() {
                return serviceRestrictCode;
            }

            /**
             * Define o valor da propriedade serviceRestrictCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceRestrictCode(String value) {
                this.serviceRestrictCode = value;
            }

            /**
             * Obtém o valor da propriedade serviceRestrictDesc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceRestrictDesc() {
                return serviceRestrictDesc;
            }

            /**
             * Define o valor da propriedade serviceRestrictDesc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceRestrictDesc(String value) {
                this.serviceRestrictDesc = value;
            }

        }

    }

}
