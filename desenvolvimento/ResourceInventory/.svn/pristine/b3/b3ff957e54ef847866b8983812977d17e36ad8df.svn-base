package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetermineResourceAvailabilityIn", propOrder = { "cabinet","brazilianUrbanPropertyAddress","resourceFacingService","customerFacingServices","customerOrder" })
public class DetermineResourceAvailabilityIn {

	private Cabinet cabinet;
	private BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress;
	protected ResourceFacingService resourceFacingService;
	protected List<CustomerFacingService> customerFacingServices;
	private CustomerOrder customerOrder;
	
	public DetermineResourceAvailabilityIn() {
	}
	
	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
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
