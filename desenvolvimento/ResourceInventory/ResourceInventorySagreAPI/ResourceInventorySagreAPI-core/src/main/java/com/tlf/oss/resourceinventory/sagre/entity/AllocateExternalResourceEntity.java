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
 * BEATRIXTWO-25 | DEMOSS-2164
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201709
 */
@Entity
@NamedStoredProcedureQuery(name = "allocateExternalResource", resultClasses = AllocateExternalResourceEntity.class, procedureName = "SAGREMAN.GVT_SP_SOA_DS_CTRL", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_cnl", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_acesso_origem", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_voz_origem", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_id_acesso_origem", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_acesso_destino", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_voz_destino", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_id_acesso_destino", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_sos", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip1", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip2", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip3", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_street_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_lote", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_pon", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_rpon", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_origem", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_nota", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_cod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_msg", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tipo_documento", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_classe_servico", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tipo_ordem", type = String.class) })
public class AllocateExternalResourceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(name = "p_in_cnl")
	private Integer cnl;
	
	@Basic
	@Column(name = "p_in_tec_acesso_origem")
	private String accessTechnology;
	
	@Basic
	@Column(name = "p_in_tec_voz_origem")
	private String voiceTechnology;
	
	@Basic
	@Column(name = "p_in_id_acesso_origem")
	private String accessId;
	
	@Basic
	@Column(name = "p_in_tec_acesso_destino")
	private String targetAccessTechnology;
	
	@Basic
	@Column(name = "p_in_tec_voz_destino")
	private String targetVoiceTechnology;
	
	@Basic
	@Column(name = "p_in_id_acesso_destino")
	private String targetAccessId;
	
	@Basic
	@Column(name = "p_in_sos")
	private String sos;
	
	@Basic
	@Column(name = "p_in_ident_equip1")
	private String identEquip1;
	
	@Basic
	@Column(name = "p_in_ident_equip2")
	private String identEquip2;
	
	@Basic
	@Column(name = "p_in_ident_equip3")
	private String identEquip3;
	
	@Basic
	@Column(name = "p_in_street_code")
	private String streetCode;
	
	@Basic
	@Column(name = "p_in_lote")
	private String lote;
	
	@Basic
	@Column(name = "p_in_pon")
	private String pon;
	
	@Basic
	@Column(name = "p_in_rpon")
	private String rpon;
	
	@Basic
	@Column(name = "p_in_origem")
	private String originSystem;
	
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
	
	@Basic
	@Column(name = "p_in_tipo_documento")
	private String documentType;
	
	@Basic
	@Column(name = "p_in_classe_servico")
	private String serviceClass;
	
	@Basic
	@Column(name = "p_in_tipo_ordem")
	private String orderType;	
	
	@Transient
	private ResultTo result;
	
	public AllocateExternalResourceEntity() {
		super();
	}

	public AllocateExternalResourceEntity(Integer cnl, String accessTechnology, String voiceTechnology, String accessId,
			String targetAccessTechnology, String targetVoiceTechnology, String targetAccessId, String sos,
			String identEquip1, String identEquip2, String identEquip3, String streetCode, String lote, String pon,
			String rpon, String originSystem, String note, Integer resultCode, String message, String documentType,
			String serviceClass, String orderType, ResultTo result) {
		super();
		this.cnl = cnl;
		this.accessTechnology = accessTechnology;
		this.voiceTechnology = voiceTechnology;
		this.accessId = accessId;
		this.targetAccessTechnology = targetAccessTechnology;
		this.targetVoiceTechnology = targetVoiceTechnology;
		this.targetAccessId = targetAccessId;
		this.sos = sos;
		this.identEquip1 = identEquip1;
		this.identEquip2 = identEquip2;
		this.identEquip3 = identEquip3;
		this.streetCode = streetCode;
		this.lote = lote;
		this.pon = pon;
		this.rpon = rpon;
		this.originSystem = originSystem;
		this.note = note;
		this.resultCode = resultCode;
		this.message = message;
		this.documentType = documentType;
		this.serviceClass = serviceClass;
		this.orderType = orderType;
		this.result = result;
	}

	/**
	 * @return the cnl
	 */
	public Integer getCnl() {
		return cnl;
	}

	/**
	 * @param cnl the cnl to set
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
	 * @param accessTechnology the accessTechnology to set
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
	 * @param voiceTechnology the voiceTechnology to set
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
	 * @param accessId the accessId to set
	 */
	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	/**
	 * @return the targetAccessTechnology
	 */
	public String getTargetAccessTechnology() {
		return targetAccessTechnology;
	}

	/**
	 * @param targetAccessTechnology the targetAccessTechnology to set
	 */
	public void setTargetAccessTechnology(String targetAccessTechnology) {
		this.targetAccessTechnology = targetAccessTechnology;
	}

	/**
	 * @return the targetVoiceTechnology
	 */
	public String getTargetVoiceTechnology() {
		return targetVoiceTechnology;
	}

	/**
	 * @param targetVoiceTechnology the targetVoiceTechnology to set
	 */
	public void setTargetVoiceTechnology(String targetVoiceTechnology) {
		this.targetVoiceTechnology = targetVoiceTechnology;
	}

	/**
	 * @return the targetAccessId
	 */
	public String getTargetAccessId() {
		return targetAccessId;
	}

	/**
	 * @param targetAccessId the targetAccessId to set
	 */
	public void setTargetAccessId(String targetAccessId) {
		this.targetAccessId = targetAccessId;
	}

	/**
	 * @return the sos
	 */
	public String getSos() {
		return sos;
	}

	/**
	 * @param sos the sos to set
	 */
	public void setSos(String sos) {
		this.sos = sos;
	}

	/**
	 * @return the identEquip1
	 */
	public String getIdentEquip1() {
		return identEquip1;
	}

	/**
	 * @param identEquip1 the identEquip1 to set
	 */
	public void setIdentEquip1(String identEquip1) {
		this.identEquip1 = identEquip1;
	}

	/**
	 * @return the identEquip2
	 */
	public String getIdentEquip2() {
		return identEquip2;
	}

	/**
	 * @param identEquip2 the identEquip2 to set
	 */
	public void setIdentEquip2(String identEquip2) {
		this.identEquip2 = identEquip2;
	}

	/**
	 * @return the identEquip3
	 */
	public String getIdentEquip3() {
		return identEquip3;
	}

	/**
	 * @param identEquip3 the identEquip3 to set
	 */
	public void setIdentEquip3(String identEquip3) {
		this.identEquip3 = identEquip3;
	}

	/**
	 * @return the streetCode
	 */
	public String getStreetCode() {
		return streetCode;
	}

	/**
	 * @param streetCode the streetCode to set
	 */
	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	/**
	 * @return the pon
	 */
	public String getPon() {
		return pon;
	}

	/**
	 * @param pon the pon to set
	 */
	public void setPon(String pon) {
		this.pon = pon;
	}

	/**
	 * @return the rpon
	 */
	public String getRpon() {
		return rpon;
	}

	/**
	 * @param rpon the rpon to set
	 */
	public void setRpon(String rpon) {
		this.rpon = rpon;
	}

	/**
	 * @return the originSystem
	 */
	public String getOriginSystem() {
		return originSystem;
	}

	/**
	 * @param originSystem the originSystem to set
	 */
	public void setOriginSystem(String originSystem) {
		this.originSystem = originSystem;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
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
	 * @param resultCode the resultCode to set
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
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}

	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	/**
	 * @return the serviceClass
	 */
	public String getServiceClass() {
		return serviceClass;
	}

	/**
	 * @param serviceClass the serviceClass to set
	 */
	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the result
	 */
	public ResultTo getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultTo result) {
		this.result = result;
	}
}
