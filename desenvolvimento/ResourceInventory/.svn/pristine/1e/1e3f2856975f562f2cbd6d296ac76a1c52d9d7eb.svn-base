package com.tlf.oss.resourceinventory.schemas;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminalBox", propOrder = { "id", "name", "cableNumber", "pairNumber", "sideCableNumber", "type",
		"address", "splitter" })
public class TerminalBox {

	protected String id;
	@NotNull
	protected String name;
	protected String cableNumber;
	protected String pairNumber;
	protected String sideCableNumber;
	protected String type;
	protected BrazilianUrbanPropertyAddress address;
	protected Splitter splitter; 

	public BrazilianUrbanPropertyAddress getAddress() {
		return address;
	}

	public void setAddress(BrazilianUrbanPropertyAddress address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCableNumber() {
		return cableNumber;
	}

	public void setCableNumber(String cableNumber) {
		this.cableNumber = cableNumber;
	}

	public String getPairNumber() {
		return pairNumber;
	}

	public void setPairNumber(String pairNumber) {
		this.pairNumber = pairNumber;
	}

	public String getSideCableNumber() {
		return sideCableNumber;
	}

	public void setSideCableNumber(String sideCableNumber) {
		this.sideCableNumber = sideCableNumber;
	}

	public Splitter getSplitter() {
		return splitter;
	}

	public void setSplitter(Splitter splitter) {
		this.splitter = splitter;
	}
}
