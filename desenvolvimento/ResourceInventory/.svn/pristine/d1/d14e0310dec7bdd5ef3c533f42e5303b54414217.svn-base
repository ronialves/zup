package com.tlf.oss.resourceinventory.schemas;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalLink", propOrder = { "voiceProtocol", "mediaType", "accessTechnology", "typeOfResource", "typeOfResourceId", "modemResource"})
public class PhysicalLink {
	@NotNull
	@Size(min=1)
	protected String voiceProtocol;
	protected String mediaType;
	@NotNull
	@Size(min=1)
	protected String accessTechnology;
	protected String typeOfResource;
	protected String typeOfResourceId;
	protected ModemResource modemResource;

	public String getVoiceProtocol() {
		return voiceProtocol;
	}
	public void setVoiceProtocol(String voiceProtocol) {
		this.voiceProtocol = voiceProtocol;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getAccessTechnology() {
		return accessTechnology;
	}
	public void setAccessTechnology(String accessTechnology) {
		this.accessTechnology = accessTechnology;
	}
	public String getTypeOfResource() {
		return typeOfResource;
	}
	public void setTypeOfResource(String typeOfResource) {
		this.typeOfResource = typeOfResource;
	}
	public String getTypeOfResourceId() {
		return typeOfResourceId;
	}
	public void setTypeOfResourceId(String typeOfResourceId) {
		this.typeOfResourceId = typeOfResourceId;
	}
	public ModemResource getModemResource() {
		return modemResource;
	}
	public void setModemResource(ModemResource modemResource) {
		this.modemResource = modemResource;
	}

}
