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
@XmlType(name = "ResourceFacingService", propOrder = { "serviceId", "category", "action", "status", "serviceDescribedBy"})
public class ResourceFacingService {

	@NotNull
	@Size(min=1)
	protected String serviceId;
	protected String category;
	protected String action;
	protected String status;
	@XmlElement(name="serviceDescribedBy")
    protected List<ServiceDescribedBy> serviceDescribedBy;

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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ServiceDescribedBy> getServiceDescribedBy() {
		if(serviceDescribedBy == null)
			serviceDescribedBy = new ArrayList<ServiceDescribedBy>();
		return serviceDescribedBy;
	}

	public void setServiceDescribedBy(List<ServiceDescribedBy> serviceDescribedBy) {
		this.serviceDescribedBy = serviceDescribedBy;
	}
}
