package com.tlf.oss.resourceinventory.television.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = CidadeCobertura.QUERY_COVERAGE, query = "SELECT ROWNUM as ID, TUC.UF, TUC.CIDADE, TC.TECHNOLOGY, TC.CAS, TC.SATELLITE, TC.NETWORK_OWNER, TC.TV_PLATFORM\r\n"
				+ "FROM RESOURCE_INVENTORY_TV_OWNER.TBL_UF_CIDADE TUC, \r\n"
				+ "	 RESOURCE_INVENTORY_TV_OWNER.TBL_COBERTURA TC,\r\n"
				+ "	 RESOURCE_INVENTORY_TV_OWNER.TBL_RL_CIDADE_COBERTURA TRCC\r\n" + "WHERE TRCC.ID_CIDADE = TUC.ID\r\n"
				+ "AND TRCC.ID_TECNOLOGIA = TC.ID", resultClass = CidadeCobertura.class) })

public class CidadeCobertura implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String QUERY_COVERAGE = "QueryCoverage";

	@Id
	@Column(name = "ID")
	private String id;

	@Column
	private String uf;

	@Column
	private String cidade;

	@Column(name = "technology")
	private String technology;

	@Column
	private String cas;

	@Column
	private String satellite;

	@Column(name = "network_owner")
	private String networkOwner;
	
	@Column(name = "tv_platform")
	private String tvPlatform;

	public CidadeCobertura() {
		super();
	}

	public CidadeCobertura(String id, String technology, String cas, String satellite, String networkOwner, String tvPlatform ) {
		super();
		this.id = id;
		this.technology = technology;
		this.cas = cas;
		this.satellite = satellite;
		this.networkOwner = networkOwner;
		this.tvPlatform = tvPlatform;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNetworkOwner() {
		return networkOwner;
	}

	public void setNetworkOwner(String networkOwner) {
		this.networkOwner = networkOwner;
	}

	@Override
	public String toString() {
		return "Cobertura [id=" + id + ", uf=" + uf + ", cidade=" + cidade + ", technology=" + technology + ", cas="
				+ cas + ", satellite=" + satellite + ", networkOwner=" + networkOwner + ", tvPlatform" + tvPlatform + "]";
	}

	public String getTvPlatform() {
		return tvPlatform;
	}

	public void setTvPlatform(String tvPlatform) {
		this.tvPlatform = tvPlatform;
	}
	
	
}