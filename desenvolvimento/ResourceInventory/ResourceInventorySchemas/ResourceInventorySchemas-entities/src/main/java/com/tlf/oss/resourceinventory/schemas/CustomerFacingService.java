package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerFacingService", propOrder = { "serviceId", "category", "serviceDescribedBy","resourceFacingService"})
public class CustomerFacingService {

	@NotNull
	@Size(min = 1)
	protected String serviceId;
	@NotNull
	@Size(min = 1)
	protected String category;
	@XmlElement(name = "serviceDescribedBy")
	protected List<ServiceDescribedBy> serviceDescribedBy;
	@XmlElement(name = "resourceFacingService")
	protected List<ResourceFacingService> resourceFacingService;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ServiceDescribedBy> getServiceDescribedBy() {
		if (serviceDescribedBy == null)
			serviceDescribedBy = new ArrayList<ServiceDescribedBy>();
		return serviceDescribedBy;
	}

	public void setServiceDescribedBy(List<ServiceDescribedBy> serviceDescribedBy) {
		this.serviceDescribedBy = serviceDescribedBy;
	}

	public List<ResourceFacingService> getResourceFacingService() {
		if (resourceFacingService == null)
			resourceFacingService = new ArrayList<ResourceFacingService>();
		return resourceFacingService;
	}

	public void setResourceFacingService(List<ResourceFacingService> resourceFacingService) {
		this.resourceFacingService = resourceFacingService;
	}
	
	
}
