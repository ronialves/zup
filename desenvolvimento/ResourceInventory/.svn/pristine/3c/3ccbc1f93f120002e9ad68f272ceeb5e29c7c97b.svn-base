package com.tlf.oss.resourceinventory.schemas;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SwitchesAssociated", propOrder = { "name", "model", "vendor" })
public class SwitchesAssociated {

	/**
	 * Nome da switch que atenderah o assinante no armario.<br>
	 * Esse eh um valor unico para cada assinante.
	 * @example PRCTA_VMS02
	 */
	@NotNull
	protected String name;//@maintained Ex: PRCTA_VMS02
	protected String model;
	protected String vendor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}
