package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.tbs.to.ResultTo;


@Entity
@NamedStoredProcedureQuery(name = "reserve", resultClasses = ReserveEntity.class, procedureName = "ASAP.GVT_SP_FTNET_RESERVA_S8", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ard_otico", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ard_metalico", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefone", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_switch", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tecnologia_voz", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rate_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_designador", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_status", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_msg", type = String.class)})

public class ReserveEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "p_ard_otico")
	private String ardOtico;

	@Basic
	@Column(name = "p_ard_metalico")
	private String ardMetalico;

	@Basic
	@Column(name = "p_telefone")
	private String telephone;

	@Basic
	@Column(name = "p_switch")
	private String switchName;

	@Basic
	@Column(name = "p_tecnologia_voz")
	private String tecVoz;

	@Basic
	@Column(name = "p_rate_code")
	private String rateCode;

	@Basic
	@Column(name = "p_designador")
	private String designador;

	@Id
	@Basic
	@Column(name = "p_status")
	private Integer status;

	@Basic
	@Column(name = "p_msg")
	private String message;
	
	@Transient
	private ResultTo result;

	public ReserveEntity() {
		super();
	}
	
	
	public ReserveEntity(String ardOtico, String ardMetalico, String telephone, String switchName, String tecVoz,
			String rateCode, String designador, Integer status, String message, ResultTo result) {
		super();
		this.ardOtico = ardOtico;
		this.ardMetalico = ardMetalico;
		this.telephone = telephone;
		this.switchName = switchName;
		this.tecVoz = tecVoz;
		this.rateCode = rateCode;
		this.designador = designador;
		this.status = status;
		this.message = message;
		this.result = result;
	}


	public String getArdOtico() {
		return ardOtico;
	}


	public void setArdOtico(String ardOtico) {
		this.ardOtico = ardOtico;
	}


	public String getArdMetalico() {
		return ardMetalico;
	}


	public void setArdMetalico(String ardMetalico) {
		this.ardMetalico = ardMetalico;
	}


	public String getTelephone() {
		
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getSwitchName() {
		return switchName;
	}


	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}


	public String getTecVoz() {
		return tecVoz;
	}


	public void setTecVoz(String tecVoz) {
		this.tecVoz = tecVoz;
	}


	public String getRateCode() {
		return rateCode;
	}


	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}


	public String getDesignador() {
		return designador;
	}


	public void setDesignador(String designador) {
		this.designador = designador;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
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
