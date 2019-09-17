package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstallResourceIn", propOrder = { "brazilianUrbanPropertyAddress", 
		"resourceFacingService", "customerOrder", "customerFacingService","resourceOrder"})
public class InstallResourceIn {
	
	protected BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress;	
	protected ResourceFacingService resourceFacingService;
	protected List<CustomerFacingService> customerFacingService;
	protected CustomerOrder customerOrder;
	protected ResourceOrder resourceOrder;
		
	public BrazilianUrbanPropertyAddress getBrazilianUrbanPropertyAddress() {
		return brazilianUrbanPropertyAddress;
	}

	public void setBrazilianUrbanPropertyAddress(BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress) {
		this.brazilianUrbanPropertyAddress = brazilianUrbanPropertyAddress;
	}
	
	public ResourceFacingService getResourceFacingService() {
		return resourceFacingService;
	}

	public void setResourceFacingService(ResourceFacingService resourceFacingService) {
		this.resourceFacingService = resourceFacingService;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	
	public List<CustomerFacingService> getCustomerFacingService() {
		return customerFacingService;
	}

	public void setCustomerFacingService(List<CustomerFacingService> customerFacingServices) {
		this.customerFacingService = customerFacingServices;
	}
	
	/**
	 * @return the resourceOrder
	 */
	public ResourceOrder getResourceOrder() {
		return resourceOrder;
	}

	/**
	 * @param resourceOrder the resourceOrder to set
	 */
	public void setResourceOrder(ResourceOrder resourceOrder) {
		this.resourceOrder = resourceOrder;
	}
	
}
