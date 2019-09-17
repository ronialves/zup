package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="EquipmentServiceIn", propOrder= { "networkAggregator", "resourceFacingService" })
public class EquipmentServiceIn {
	
	public EquipmentServiceIn() {
		
	}
	
	protected PhysicalResource networkAggregator;
	protected ResourceFacingService resourceFacingService;
	
	public PhysicalResource getNetworkAggregator() {
		return networkAggregator;
	}

	public void setNetworkAggregator(PhysicalResource networkAggregator) {
		this.networkAggregator = networkAggregator;
	}

	public ResourceFacingService getResourceFacingService() {
		return resourceFacingService;
	}

	public void setResourceFacingService(ResourceFacingService resourceFacingService) {
		this.resourceFacingService = resourceFacingService;
	}
}
