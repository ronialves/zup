package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

public class PhysicalResourceSummary {

    protected List<PhysicalResource> physicalResource;

	public List<PhysicalResource> getPhysicalResource() {
		if(physicalResource == null)
			physicalResource = new ArrayList<>();
		return physicalResource;
	}

	public void setPhysicalResource(List<PhysicalResource> physicalResource) {
		this.physicalResource = physicalResource;
	}


}