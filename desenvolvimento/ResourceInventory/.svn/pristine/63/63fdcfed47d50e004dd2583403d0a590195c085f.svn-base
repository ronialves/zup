package com.tlf.oss.resourceinventory.schemas;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacePhysicalResourceAssoc", propOrder = { "cabinet", "physicalLink"})
public class PlacePhysicalResourceAssoc extends PhysicalLinkServiceAssocSummaryType {
	
	protected Cabinet cabinet;
	@NotNull
	@Valid
	protected PhysicalLink physicalLink;
	
	public PhysicalLink getPhysicalLink() {
		return physicalLink;
	}

	public void setPhysicalLink(PhysicalLink physicalLink) {
		this.physicalLink = physicalLink;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

}
