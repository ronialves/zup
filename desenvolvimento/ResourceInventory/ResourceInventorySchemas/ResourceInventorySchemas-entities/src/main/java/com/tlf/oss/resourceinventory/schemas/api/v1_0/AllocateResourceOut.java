package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllocateResourceOut", propOrder = { "physicalLinks", "cabinet", "circuit", "resourceOrder" })
public class AllocateResourceOut {

	protected List<PhysicalLink> physicalLinks;
	protected Cabinet cabinet;
	protected Circuit circuit;
	protected ResourceOrder resourceOrder;

	public AllocateResourceOut() {	
	}

	public List<PhysicalLink> getPhysicalLinks() {
		return physicalLinks;
	}

	public void setPhysicalLinks(List<PhysicalLink> physicalLinks) {
		this.physicalLinks = physicalLinks;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

	public ResourceOrder getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(ResourceOrder resourceOrder) {
		this.resourceOrder = resourceOrder;
	}
}
