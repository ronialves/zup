package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveResourceOut", propOrder = { "cabinet", "physicalLinks" })
public class ReserveResourceOut {

	protected Cabinet cabinet;
	protected List<PhysicalLink> physicalLinks;

	public ReserveResourceOut() {
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public List<PhysicalLink> getPhysicalLinks() {
		return physicalLinks;
	}

	public void setPhysicalLinks(List<PhysicalLink> physicalLinks) {
		this.physicalLinks = physicalLinks;
	}

}
