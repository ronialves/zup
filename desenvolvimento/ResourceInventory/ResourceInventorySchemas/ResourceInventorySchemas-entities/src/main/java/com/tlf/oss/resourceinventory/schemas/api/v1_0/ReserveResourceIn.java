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

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveResourceIn", propOrder = { "brazilianUrbanPropertyAddress", "resourceFacingService", "customerFacingServices", "customerOrder" })
public class ReserveResourceIn {

	private BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress;
	private ResourceFacingService resourceFacingService;
	private List<CustomerFacingService> customerFacingServices;
	private CustomerOrder customerOrder;

	public ReserveResourceIn() {
	}

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

	public List<CustomerFacingService> getCustomerFacingServices() {
		return customerFacingServices;
	}

	public void setCustomerFacingServices(List<CustomerFacingService> customerFacingServices) {
		this.customerFacingServices = customerFacingServices;
	}
	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
}
