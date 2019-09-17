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
	@NamedStoredProcedureQuery(name = RetrievalEquipmentDetailTreeEntity.RETRIEVAL_EQUIPMENT_DETAIL_TREE, 
			procedureName = "TLF_SP_SIGITM_GET_FILHO", resultClasses = RetrievalEquipmentDetailTreeEntity.class, 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostname", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fusion", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "cur1", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_cod_retorno", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_msg_retorno", type = String.class)}) })
public class RetrievalEquipmentDetailTreeEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String RETRIEVAL_EQUIPMENT_DETAIL_TREE = "retrievalEquipmentDetailTree";
	
	@Basic
	@Column(name="ARVORE")
	private String tree;
	
	@Basic
	@Column(name="NIVEL")
	private String level;
	
	@Basic
	@Column(name="MOUNTING_POSITION_NUMBER")
	private String mountPosNumber;
	
	@Basic
	@Column(name="EQUIPSPEC_TYPE")
	private String equipSpecType;
	
	@Basic
	@Column(name="EQUIPMENT_ACRONYM")
	private String equipAcronym;
	
	@Basic
	@Column(name="VENDOR_NAME")
	private String vendorName;
	
	@Basic
	@Column(name="EQUIPMENT_NAME")
	private String equipName;

	@Basic
	@Column(name="NOTES")
	private String notes;
	
	@Basic
	@Column(name="FUSION")
	private String fusion;
		
	@Id
	@Basic
	@Column(name="EQUIPMENT_ID_PAI")
	private String equipParentId;
	
	@Basic
	@Column(name="EQUIPMENT_ID_FILHO")
	private String equipChildId;
	
	@Basic
	@Column(name="HAS_PORTA")
	private String hasPort;
	
	@Basic
	@Column(name="p_cod_retorno")
	private String codRetorno;
	
	@Basic
	@Column(name="p_msg_retorno")
	private String msgRetorno;

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMountPosNumber() {
		return mountPosNumber;
	}

	public void setMountPosNumber(String mountPosNumber) {
		this.mountPosNumber = mountPosNumber;
	}

	public String getEquipSpecType() {
		return equipSpecType;
	}

	public void setEquipSpecType(String equipSpecType) {
		this.equipSpecType = equipSpecType;
	}

	public String getEquipAcronym() {
		return equipAcronym;
	}

	public void setEquipAcronym(String equipAcronym) {
		this.equipAcronym = equipAcronym;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getFusion() {
		return fusion;
	}

	public void setFusion(String fusion) {
		this.fusion = fusion;
	}

	public String getEquipIdParent() {
		return equipParentId;
	}

	public void setEquipIdParent(String equipIdParent) {
		this.equipParentId = equipIdParent;
	}

	public String getEquipIdChild() {
		return equipChildId;
	}

	public void setEquipIdChild(String equipIdChild) {
		this.equipChildId = equipIdChild;
	}

	public String getHasPort() {
		return hasPort;
	}

	public void setHasPort(String hasPort) {
		this.hasPort = hasPort;
	}

	public String getCodRetorno() {
		return codRetorno;
	}

	public void setCodRetorno(String codRetorno) {
		this.codRetorno = codRetorno;
	}

	public String getMsgRetorno() {
		return msgRetorno;
	}

	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}
}