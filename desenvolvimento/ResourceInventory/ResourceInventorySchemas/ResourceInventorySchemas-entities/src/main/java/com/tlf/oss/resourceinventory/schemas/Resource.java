package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resource", propOrder = { "stateOfResource" })
public class Resource {

	protected String stateOfResource;

	public String getStateOfResource() {
		return stateOfResource;
	}

	public void setStateOfResource(String stateOfResource) {
		this.stateOfResource = stateOfResource;
	}
}
