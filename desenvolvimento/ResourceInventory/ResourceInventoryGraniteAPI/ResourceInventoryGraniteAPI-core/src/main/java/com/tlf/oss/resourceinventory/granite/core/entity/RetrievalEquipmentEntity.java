package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(name = RetrievalEquipmentEntity.RETRIEVAL_EQUIPMENT, resultClasses = RetrievalEquipmentEntity.class, procedureName = "PKG_RESERVE.PRC_RETRIEVE_EQUIP_BY_LOC",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_cnl_acronym", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "in_microarea", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})
public class RetrievalEquipmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String RETRIEVAL_EQUIPMENT = "retrievalEquipment";
	
	
	@Basic
	@Column(name="TYPE_OF_RESOURCE")
	private String typeOfResource;
	
	@Basic
	@Column(name="OUT_HOSTNAME")
	private String outHostname;
	
	@Basic
	@Column(name="ORIGEM")
	private String origem;
	
	@Id
	@Basic
	@Column(name="ID_EQUIP")
	private String idEquip;
	
	@Basic
	@Column(name="VENDOR")
	private String vendor;
	
	@Basic
	@Column(name="MODEL")
	private String model;
	
	@Basic
	@Column(name="IP")
	private String ip;	

	public String getTypeOfResource() {
		return typeOfResource;
	}

	public void setTypeOfResource(String typeOfResource) {
		this.typeOfResource = typeOfResource;
	}

	public String getOutHostname() {
		return outHostname;
	}

	public void setOutHostname(String outHostname) {
		this.outHostname = outHostname;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getIdEquip() {
		return idEquip;
	}

	public void setIdEquip(String idEquip) {
		this.idEquip = idEquip;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}			
}