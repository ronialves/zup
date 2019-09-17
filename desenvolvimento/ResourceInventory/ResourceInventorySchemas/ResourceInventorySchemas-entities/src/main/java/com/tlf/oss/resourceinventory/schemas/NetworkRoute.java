
package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkRoute", propOrder = { "nasPost", "vlanId", "virtualPort", "virtualChannel", "svlan", "cvlan", "bng",
		"type", "serviceDescription" })
public class NetworkRoute {

	@XmlElement(name = "nasPort")
	protected String nasPost;
	protected String vlanId;
	protected String virtualPort;
	protected String virtualChannel;
	protected String svlan;
	protected String cvlan;
	protected String bng;
	protected String type;
	protected String serviceDescription;


	public String getNasPost() {
		return nasPost;
	}

	public void setNasPost(String value) {
		this.nasPost = value;
	}

	public String getVlanId() {
		return vlanId;
	}

	public void setVlanId(String value) {
		this.vlanId = value;
	}

	public String getVirtualPort() {
		return virtualPort;
	}

	public void setVirtualPort(String value) {
		this.virtualPort = value;
	}

	public String getVirtualChannel() {
		return virtualChannel;
	}

	public void setVirtualChannel(String value) {
		this.virtualChannel = value;
	}

	public String getSvlan() {
		return svlan;
	}

	public void setSvlan(String svlan) {
		this.svlan = svlan;
	}

	public String getCvlan() {
		return cvlan;
	}

	public void setCvlan(String cvlan) {
		this.cvlan = cvlan;
	}

	public String getBng() {
		return bng;
	}

	public void setBng(String bng) {
		this.bng = bng;
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
}
