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
 * BEATRIXTWO-935 | DEMOSS-2995
 * @project Beatrix Fase 2
 * @author renan.n.oliveira
 * @since 201803
 */
@Entity
@NamedStoredProcedureQuery(name = "ReleaseResource", resultClasses = ReleaseResourceEntity.class, procedureName = "SAGREMAN.GVT_SP_SOA_LIBERA_FAC_CTRL", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_cnl", type = Integer.class), 
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tec_voz", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_id_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_tipo", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_cod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_msg", type = String.class), })
public class ReleaseResourceEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	@Id
	@Basic
	@Column(name = "p_out_cod")
	private Integer resultCode;
	
	@Basic
	@Column(name = "p_out_msg")
	private String message;
	
	@Transient
	private ResultTo result;
	
	public ReleaseResourceEntity() {
		super();
	}

	public ReleaseResourceEntity(Integer cnl, String accessTechnology, String voiceTechnology, String accessId,
			String type, Integer resultCode, String message, ResultTo result) {
		super();
		this.cnl = cnl;
		this.accessTechnology = accessTechnology;
		this.voiceTechnology = voiceTechnology;
		this.accessId = accessId;
		this.type = type;
		this.resultCode = resultCode;
		this.message = message;
		this.result = result;
	}

	public Integer getCnl() {
		return cnl;
	}

	public void setCnl(Integer cnl) {
		this.cnl = cnl;
	}

	public String getAccessTechnology() {
		return accessTechnology;
	}

	public void setAccessTechnology(String accessTechnology) {
		this.accessTechnology = accessTechnology;
	}

	public String getVoiceTechnology() {
		return voiceTechnology;
	}

	public void setVoiceTechnology(String voiceTechnology) {
		this.voiceTechnology = voiceTechnology;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}