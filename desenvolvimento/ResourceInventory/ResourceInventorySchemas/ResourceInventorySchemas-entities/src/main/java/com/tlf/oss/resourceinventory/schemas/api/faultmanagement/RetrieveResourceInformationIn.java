package com.tlf.oss.resourceinventory.schemas.api.faultmanagement;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Equipment;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveResourceInformationIn", propOrder = { "address", "equipment", "resourceOrder" })
public class RetrieveResourceInformationIn {

	protected List<BrazilianUrbanPropertyAddress> address;
	protected Equipment equipment;
	protected ResourceOrder resourceOrder;
	
	/**
	 * @return the address
	 */
	public List<BrazilianUrbanPropertyAddress> getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(List<BrazilianUrbanPropertyAddress> address) {
		this.address = address;
	}
	
	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}
	
	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the resourceOrder
	 */
	public ResourceOrder getResourceOrder() {
		return resourceOrder;
	}

	/**
	 * @param resourceOrder the resourceOrder to set
	 */
	public void setResourceOrder(ResourceOrder resourceOrder) {
		this.resourceOrder = resourceOrder;
	}	
	
	
}