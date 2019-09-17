package com.tlf.oss.resourceinventory.television.entity;

public class Cobertura {

	String technology;
	String cas;
	String satellite;
	String networkOwner;
	String tvPlatform;

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public String getSatellite() {
		return satellite;
	}

	public void setSatellite(String satellite) {
		this.satellite = satellite;
	}

	public String getNetworkOwner() {
		return networkOwner;
	}

	public void setNetworkOwner(String networkOwner) {
		this.networkOwner = networkOwner;
	}

	public String getTvPlatform() {
		return tvPlatform;
	}

	public void setTvPlatform(String tvPlatform) {
		this.tvPlatform = tvPlatform;
	}

	public Cobertura(String technology, String cas, String satellite, String networkOwner) {
		super();
		this.technology = technology;
		this.cas = cas;
		this.satellite = satellite;
		this.networkOwner = networkOwner;
	}
	
	public Cobertura(String technology, String cas, String satellite, String networkOwner, String tvPlatform) {
		super();
		this.technology = technology;
		this.cas = cas;
		this.satellite = satellite;
		this.networkOwner = networkOwner;
		this.tvPlatform = tvPlatform;
	}

}
