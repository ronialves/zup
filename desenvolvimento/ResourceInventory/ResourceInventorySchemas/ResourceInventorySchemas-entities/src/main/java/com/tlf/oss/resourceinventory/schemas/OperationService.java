package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationService", propOrder = { "serviceDescribedBy" })
public class OperationService {

	@XmlElement(name = "serviceDescribedBy")
	protected List<ServiceDescribedBy> serviceDescribedBy;

	public List<ServiceDescribedBy> getServiceDescribedBy() {
		if (serviceDescribedBy == null)
			serviceDescribedBy = new ArrayList<ServiceDescribedBy>();
		return serviceDescribedBy;
	}

	public void setServiceDescribedBy(List<ServiceDescribedBy> serviceDescribedBy) {
		this.serviceDescribedBy = serviceDescribedBy;
	}
}