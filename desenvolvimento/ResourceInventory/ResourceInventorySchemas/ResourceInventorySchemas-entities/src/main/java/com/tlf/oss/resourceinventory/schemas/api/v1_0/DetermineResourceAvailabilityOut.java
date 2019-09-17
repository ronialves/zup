package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.Satellite;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetermineResourceAvailabilityOut", propOrder = { "networkOwner", "cabinet", "satellite", "physicalLinks" })
public class DetermineResourceAvailabilityOut {

	protected String networkOwner;
	protected Cabinet cabinet;
	protected Satellite satellite;
	protected List<PhysicalLink> physicalLinks;

	public DetermineResourceAvailabilityOut() {
		
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

	public String getNetworkOwner() {
		return networkOwner;
	}

	public void setNetworkOwner(String networkOwner) {
		this.networkOwner = networkOwner;
	}
	
	public Satellite getSatellite() {
		return satellite;
	}

	public void setSatellite(Satellite satellite) {
		this.satellite = satellite;
	}

}
