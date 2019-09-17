package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDescribedBy", propOrder = { "serviceType", "name", "serviceSpecCharDescribes"})
public class ServiceDescribedBy {

	@Deprecated
	protected String serviceType;
	@NotNull
	@Size(min=1)
	protected String name;
    protected List<ServiceSpecCharDescribes> serviceSpecCharDescribes;
    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public List<ServiceSpecCharDescribes> getServiceSpecCharDescribes() {
        if (serviceSpecCharDescribes == null) {
        	serviceSpecCharDescribes = new ArrayList<ServiceSpecCharDescribes>();
        }
        return this.serviceSpecCharDescribes;
    }

	public void setServiceSpecCharDescribes(List<ServiceSpecCharDescribes> serviceSpecCharDescribes) {
		this.serviceSpecCharDescribes = serviceSpecCharDescribes;
	}
	
}
