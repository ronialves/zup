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
@XmlType(name = "ReleaseResourceIn", propOrder = { "brazilianUrbanPropertyAddress", "resourceFacingService", "customerFacingServices", "customerOrder", "resourceOrder" })
public class ReleaseResourceIn {

	protected BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress;
	protected ResourceFacingService resourceFacingService;
	protected List<CustomerFacingService> customerFacingServices;
	protected CustomerOrder customerOrder;
	protected ResourceOrder resourceOrder;

	public ReleaseResourceIn() {
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

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
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
}

