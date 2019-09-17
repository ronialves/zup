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
@XmlType(name = "PortAdapterCard", propOrder = { "technology", "freePorts", "maxBroadbandSpeed", "slot", "subSlotId",
		"containsPorts", "slotId", "model", "physicalResource", "id", "subSlot", "vendor", "origin", "name", "notes" })
public class PortAdapterCard {

	@Deprecated //depreciado em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String id;//@movedTo slot
	protected String slot;//@new @movedFrom id and slotId
	protected String subSlot;//@new @movedFrom subSlotId
	protected String vendor;//@new
	protected String model;//@maintained
	protected String technology;
	protected String freePorts;
	protected String maxBroadbandSpeed;
	protected String subSlotId;//@movedTo subSlot
	@XmlElement(name = "containsPorts")
	protected List<PhysicalPort> containsPorts;//@maintained
	@Deprecated //depreciado em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String slotId;//@movedTo slot
	protected PhysicalResource physicalResource;
	protected String origin;
	protected String name;
	protected String notes;
	
	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String value) {
		this.technology = value;
	}

	public String getFreePorts() {
		return freePorts;
	}

	public void setFreePorts(String value) {
		this.freePorts = value;
	}

	public String getMaxBroadbandSpeed() {
		return maxBroadbandSpeed;
	}

	public void setMaxBroadbandSpeed(String value) {
		this.maxBroadbandSpeed = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubSlotId() {
		return subSlotId;
	}

	public void setSubSlotId(String subSlotId) {
		this.subSlotId = subSlotId;
	}

	public List<PhysicalPort> getContainsPorts() {
		if (containsPorts == null)
			containsPorts = new ArrayList<PhysicalPort>();
		return containsPorts;
	}

	public void setContainsPorts(List<PhysicalPort> containsPorts) {
		this.containsPorts = containsPorts;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public PhysicalResource getPhysicalResource() {
		return physicalResource;
	}

	public void setPhysicalResource(PhysicalResource physicalResource) {
		this.physicalResource = physicalResource;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getSubSlot() {
		return subSlot;
	}

	public void setSubSlot(String subSlot) {
		this.subSlot = subSlot;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((containsPorts == null) ? 0 : containsPorts.hashCode());
		result = prime * result + ((freePorts == null) ? 0 : freePorts.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxBroadbandSpeed == null) ? 0 : maxBroadbandSpeed.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((physicalResource == null) ? 0 : physicalResource.hashCode());
		result = prime * result + ((slot == null) ? 0 : slot.hashCode());
		result = prime * result + ((slotId == null) ? 0 : slotId.hashCode());
		result = prime * result + ((subSlot == null) ? 0 : subSlot.hashCode());
		result = prime * result + ((subSlotId == null) ? 0 : subSlotId.hashCode());
		result = prime * result + ((technology == null) ? 0 : technology.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortAdapterCard other = (PortAdapterCard) obj;
		if (containsPorts == null) {
			if (other.containsPorts != null)
				return false;
		} else if (!containsPorts.equals(other.containsPorts))
			return false;
		if (freePorts == null) {
			if (other.freePorts != null)
				return false;
		} else if (!freePorts.equals(other.freePorts))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxBroadbandSpeed == null) {
			if (other.maxBroadbandSpeed != null)
				return false;
		} else if (!maxBroadbandSpeed.equals(other.maxBroadbandSpeed))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (physicalResource == null) {
			if (other.physicalResource != null)
				return false;
		} else if (!physicalResource.equals(other.physicalResource))
			return false;
		if (slot == null) {
			if (other.slot != null)
				return false;
		} else if (!slot.equals(other.slot))
			return false;
		if (slotId == null) {
			if (other.slotId != null)
				return false;
		} else if (!slotId.equals(other.slotId))
			return false;
		if (subSlot == null) {
			if (other.subSlot != null)
				return false;
		} else if (!subSlot.equals(other.subSlot))
			return false;
		if (subSlotId == null) {
			if (other.subSlotId != null)
				return false;
		} else if (!subSlotId.equals(other.subSlotId))
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}		
}