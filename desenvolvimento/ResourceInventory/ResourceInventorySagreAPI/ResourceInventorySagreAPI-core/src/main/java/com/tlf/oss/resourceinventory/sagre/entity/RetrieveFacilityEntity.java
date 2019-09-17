package com.tlf.oss.resourceinventory.sagre.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.sagre.to.ResultTo;

/**
 * BEATRIXTWO-441 | DEMOSS-2279
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@SuppressWarnings("serial")
@Entity
@NamedStoredProcedureQuery(name = "facilityRetrievalResource", resultClasses = RetrieveFacilityEntity.class, procedureName = "SAGREMAN.GVT_SP_SOA_FAC_CTRL", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_cnl", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_voz", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_id_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tipo", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_armario", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_caixa", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_equip_gen_1", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_equip_gen_2", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_equip_gen_3", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_nota", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_cod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_msg", type = String.class) })
public class RetrieveFacilityEntity implements Serializable {

	@Basic
	@Column(name = "p_in_cnl")
	private Integer cnl;

	@Basic
	@Column(name = "p_in_tec_acesso")
	private String accessTechnology;

	@Basic
	@Column(name = "p_in_tec_voz")
	private String voiceTechnology;

	@Basic
	@Column(name = "p_in_id_acesso")
	private String accessId;

	@Basic
	@Column(name = "p_in_tipo")
	private String type;

	@Basic
	@Column(name = "p_out_armario")
	private String cabinet;

	@Basic
	@Column(name = "p_out_caixa")
	private String terminalBox;

	@Basic
	@Column(name = "p_out_equip_gen_1")
	private String equipGen1;

	@Basic
	@Column(name = "p_out_equip_gen_2")
	private String equipGen2;

	@Basic
	@Column(name = "p_out_equip_gen_3")
	private String equipGen3;

	@Basic
	@Column(name = "p_out_nota")
	private String note;

	@Id
	@Basic
	@Column(name = "p_out_cod")
	private Integer resultCode;

	@Basic
	@Column(name = "p_out_msg")
	private String message;

	@Transient
	private ResultTo result;

	public RetrieveFacilityEntity() {
		super();
	}

	public RetrieveFacilityEntity(Integer cnl, String accessTechnology, String voiceTechnology, String accessId,
			String type, String cabinet, String terminalBox, String equipGen1, String equipGen2, String equipGen3,
			String note, Integer resultCode, String message, ResultTo result) {
		super();
		this.cnl = cnl;
		this.accessTechnology = accessTechnology;
		this.voiceTechnology = voiceTechnology;
		this.accessId = accessId;
		this.type = type;
		this.cabinet = cabinet;
		this.terminalBox = terminalBox;
		this.equipGen1 = equipGen1;
		this.equipGen2 = equipGen2;
		this.equipGen3 = equipGen3;
		this.note = note;
		this.resultCode = resultCode;
		this.message = message;
		this.result = result;
	}

	/**
	 * @return the cnl
	 */
	public Integer getCnl() {
		return cnl;
	}

	/**
	 * @param cnl
	 *            the cnl to set
	 */
	public void setCnl(Integer cnl) {
		this.cnl = cnl;
	}

	/**
	 * @return the accessTechnology
	 */
	public String getAccessTechnology() {
		return accessTechnology;
	}

	/**
	 * @param accessTechnology
	 *            the accessTechnology to set
	 */
	public void setAccessTechnology(String accessTechnology) {
		this.accessTechnology = accessTechnology;
	}

	/**
	 * @return the voiceTechnology
	 */
	public String getVoiceTechnology() {
		return voiceTechnology;
	}

	/**
	 * @param voiceTechnology
	 *            the voiceTechnology to set
	 */
	public void setVoiceTechnology(String voiceTechnology) {
		this.voiceTechnology = voiceTechnology;
	}

	/**
	 * @return the accessId
	 */
	public String getAccessId() {
		return accessId;
	}

	/**
	 * @param accessId
	 *            the accessId to set
	 */
	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the cabinet
	 */
	public String getCabinet() {
		return cabinet;
	}

	/**
	 * @param cabinet
	 *            the cabinet to set
	 */
	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	/**
	 * @return the terminalBox
	 */
	public String getTerminalBox() {
		return terminalBox;
	}

	/**
	 * @param terminalBox
	 *            the terminalBox to set
	 */
	public void setTerminalBox(String terminalBox) {
		this.terminalBox = terminalBox;
	}

	/**
	 * @return the equipGen1
	 */
	public String getEquipGen1() {
		return equipGen1;
	}

	/**
	 * @param equipGen1
	 *            the equipGen1 to set
	 */
	public void setEquipGen1(String equipGen1) {
		this.equipGen1 = equipGen1;
	}

	/**
	 * @return the equipGen2
	 */
	public String getEquipGen2() {
		return equipGen2;
	}

	/**
	 * @param equipGen2
	 *            the equipGen2 to set
	 */
	public void setEquipGen2(String equipGen2) {
		this.equipGen2 = equipGen2;
	}

	/**
	 * @return the equipGen3
	 */
	public String getEquipGen3() {
		return equipGen3;
	}

	/**
	 * @param equipGen3
	 *            the equipGen3 to set
	 */
	public void setEquipGen3(String equipGen3) {
		this.equipGen3 = equipGen3;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the resultCode
	 */
	public Integer getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode
	 *            the resultCode to set
	 */
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public ResultTo getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(ResultTo result) {
		this.result = result;
	}
}