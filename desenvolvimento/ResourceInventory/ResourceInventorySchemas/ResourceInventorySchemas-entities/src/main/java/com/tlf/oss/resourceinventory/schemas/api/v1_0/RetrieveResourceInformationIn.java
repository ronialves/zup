package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveResourceInformationIn", propOrder = { "resourceFacingService", "brazilianUrbanPropertyAddress",
		"customerOrder", "resourceOrder"})
public class RetrieveResourceInformationIn {

	protected ResourceFacingService resourceFacingService;
	protected BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress;
	protected CustomerOrder customerOrder;
	protected ResourceOrder resourceOrder;

	public RetrieveResourceInformationIn() {
	}

	public ResourceFacingService getResourceFacingService() {
		return resourceFacingService;
	}

	public void setResourceFacingService(ResourceFacingService resourceFacingService) {
		this.resourceFacingService = resourceFacingService;
	}

	public BrazilianUrbanPropertyAddress getBrazilianUrbanPropertyAddress() {
		return brazilianUrbanPropertyAddress;
	}

	public void setBrazilianUrbanPropertyAddress(BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress) {
		this.brazilianUrbanPropertyAddress = brazilianUrbanPropertyAddress;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	/**
	 * @return the resourceOrder
	 */
	public ResourceOrder getResourceOrder() {
		return resourceOrder;
	}

	/**
	 * @param resourceOrder
	 *            the resourceOrder to set
	 */
	public void setResourceOrder(ResourceOrder resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

}