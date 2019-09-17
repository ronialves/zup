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
@XmlType(name = "DeallocateResourceIn", propOrder = { "brazilianUrbanPropertyAddress", "customerOrder", "resourceFacingService", "customerFacingServices", "resourceOrder" })
public class DeallocateResourceIn {

	private BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress;
	private CustomerOrder customerOrder;
	private ResourceFacingService resourceFacingService;
	private List<CustomerFacingService> customerFacingServices;
	private ResourceOrder resourceOrder;
	
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

	public ResourceOrder getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(ResourceOrder resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("DeallocateResourceIn [brazilianUrbanPropertyAddress=");
		strBuilder.append(brazilianUrbanPropertyAddress);
		strBuilder.append(", customerOrder=");
		strBuilder.append(customerOrder);
		strBuilder.append(", resourceFacingServices =");
		strBuilder.append(resourceFacingService);
		strBuilder.append(", resourceOrder =");
		strBuilder.append(resourceOrder);
		strBuilder.append("]");
		return strBuilder.toString();
	}

}