package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = RetrievalEquipmentEntity.RETRIEVAL_EQUIPMENT, procedureName = "TLF_SP_SIGITM_GET_ELEMENTO", resultClasses = RetrievalEquipmentEntity.class, 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_state_code", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_site", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "cur1", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_cod_retorno", type = Float.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_msg_retorno", type = String.class)}) })
public class RetrievalEquipmentEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String RETRIEVAL_EQUIPMENT = "retrievalEquipment";
	
	@Basic
	@Column(name="HOSTNAME")
	private String hostname;
	
	@Basic
	@Column(name="NASIP")
	private String nasip;
	
	@Basic
	@Column(name="ORIGEM")
	private String origem;
	
	@Basic
	@Column(name="EQUIPMENT_ACRONYM")
	private String acronymEquip;
	
	@Basic
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Basic
	@Column(name="EQUIPMENT_NAME")
	private String nameEquip;
	
	@Basic
	@Column(name="EQUIPSPEC_TYPE")
	private String typeEquip;

	@Basic
	@Column(name="NOTES")
	private String notes;
	
	@Id
	@Basic
	@Column(name="EQUIPMENT_ID")
	private String idEquip;
	
	@Basic
	@Column(name="p_cod_retorno")
	private Float codRetorno;
	
	@Basic
	@Column(name="p_msg_retorno")
	private String msgRetorno;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getNasip() {
		return nasip;
	}

	public void setNasip(String nasip) {
		this.nasip = nasip;
	}

	public String getAcronymEquip() {
		return acronymEquip;
	}

	public void setAcronymEquip(String acronymEquip) {
		this.acronymEquip = acronymEquip;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getNameEquip() {
		return nameEquip;
	}

	public void setNameEquip(String nameEquip) {
		this.nameEquip = nameEquip;
	}

	public String getTypeEquip() {
		return typeEquip;
	}

	public void setTypeEquip(String typeEquip) {
		this.typeEquip = typeEquip;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getIdEquip() {
		return idEquip;
	}

	public void setIdEquip(String idEquip) {
		this.idEquip = idEquip;
	}
	
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Float getCodRetorno() {
		return codRetorno;
	}

	public void setCodRetorno(Float codRetorno) {
		this.codRetorno = codRetorno;
	}

	public String getMsgRetorno() {
		return msgRetorno;
	}

	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}
}