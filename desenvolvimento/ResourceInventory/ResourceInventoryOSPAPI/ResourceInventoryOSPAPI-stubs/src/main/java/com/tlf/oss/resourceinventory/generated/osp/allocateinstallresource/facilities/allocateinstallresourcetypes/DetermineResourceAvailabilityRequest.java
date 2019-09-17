
package com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.addresstypes.Address;


/**
 * <p>Classe Java de DetermineResourceAvailabilityRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DetermineResourceAvailabilityRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
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
 *         &lt;element name="address" type="{http://www.cpqd.com.br/etics/AddressTypes}Address" minOccurs="0"/&gt;
 *         &lt;element name="reserveOrder" type="{http://www.cpqd.com.br/etics/simpletypes}string015" minOccurs="0"/&gt;
 *         &lt;element name="serviceFilter" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
 *                   &lt;element name="facilities" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="facilityCode" type="{http://www.cpqd.com.br/etics/simpletypes}string30" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DetermineResourceAvailabilityRequest", propOrder = {
    "inService",
    "address",
    "reserveOrder",
    "serviceFilter"
})
public class DetermineResourceAvailabilityRequest {

    protected DetermineResourceAvailabilityRequest.InService inService;
    protected Address address;
    protected String reserveOrder;
    protected DetermineResourceAvailabilityRequest.ServiceFilter serviceFilter;

    /**
     * Obtém o valor da propriedade inService.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityRequest.InService }
     *     
     */
    public DetermineResourceAvailabilityRequest.InService getInService() {
        return inService;
    }

    /**
     * Define o valor da propriedade inService.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityRequest.InService }
     *     
     */
    public void setInService(DetermineResourceAvailabilityRequest.InService value) {
        this.inService = value;
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
     * Obtém o valor da propriedade serviceFilter.
     * 
     * @return
     *     possible object is
     *     {@link DetermineResourceAvailabilityRequest.ServiceFilter }
     *     
     */
    public DetermineResourceAvailabilityRequest.ServiceFilter getServiceFilter() {
        return serviceFilter;
    }

    /**
     * Define o valor da propriedade serviceFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link DetermineResourceAvailabilityRequest.ServiceFilter }
     *     
     */
    public void setServiceFilter(DetermineResourceAvailabilityRequest.ServiceFilter value) {
        this.serviceFilter = value;
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
     *         &lt;element name="serviceType" type="{http://www.cpqd.com.br/etics/simpletypes}string30" minOccurs="0"/&gt;
     *         &lt;element name="facilities" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="facilityCode" type="{http://www.cpqd.com.br/etics/simpletypes}string30" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "serviceType",
        "facilities"
    })
    public static class ServiceFilter {

        protected String serviceType;
        protected DetermineResourceAvailabilityRequest.ServiceFilter.Facilities facilities;

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
         * Obtém o valor da propriedade facilities.
         * 
         * @return
         *     possible object is
         *     {@link DetermineResourceAvailabilityRequest.ServiceFilter.Facilities }
         *     
         */
        public DetermineResourceAvailabilityRequest.ServiceFilter.Facilities getFacilities() {
            return facilities;
        }

        /**
         * Define o valor da propriedade facilities.
         * 
         * @param value
         *     allowed object is
         *     {@link DetermineResourceAvailabilityRequest.ServiceFilter.Facilities }
         *     
         */
        public void setFacilities(DetermineResourceAvailabilityRequest.ServiceFilter.Facilities value) {
            this.facilities = value;
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
         *         &lt;element name="facilityCode" type="{http://www.cpqd.com.br/etics/simpletypes}string30" maxOccurs="unbounded" minOccurs="0"/&gt;
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
            "facilityCode"
        })
        public static class Facilities {

            protected List<String> facilityCode;

            /**
             * Gets the value of the facilityCode property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the facilityCode property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFacilityCode().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getFacilityCode() {
                if (facilityCode == null) {
                    facilityCode = new ArrayList<String>();
                }
                return this.facilityCode;
            }

        }

    }

}
