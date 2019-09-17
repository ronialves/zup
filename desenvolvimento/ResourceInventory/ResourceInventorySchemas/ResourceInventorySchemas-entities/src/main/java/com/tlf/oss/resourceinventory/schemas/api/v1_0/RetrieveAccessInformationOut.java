package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveAccessInformationOut", propOrder = { "resourceFacingService"})
public class RetrieveAccessInformationOut {
	
	protected ResourceFacingService resourceFacingService;
	
	public RetrieveAccessInformationOut() {
		
	}

	public ResourceFacingService getResourceFacingService() {
		return resourceFacingService;
	}

	public void setResourceFacingService(ResourceFacingService resourceFacingService) {
		this.resourceFacingService = resourceFacingService;
	}
}