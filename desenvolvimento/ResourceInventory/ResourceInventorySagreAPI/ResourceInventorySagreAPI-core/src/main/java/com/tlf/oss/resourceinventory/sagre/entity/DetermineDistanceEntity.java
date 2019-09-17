package com.tlf.oss.resourceinventory.sagre.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;

@SuppressWarnings("serial")
@Entity
@NamedStoredProcedureQuery(name = "determineDistance", resultClasses = DetermineDistanceEntity.class, procedureName = "SAGREMAN.GVT_SP_SOA_CONSULTA_DISTANCIA", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_cnl", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_street_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_address_num", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip1", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_ident_equip2", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_in_origem", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_distancia", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_cod", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_msg", type = String.class) })
public class DetermineDistanceEntity implements Serializable {
	
	@Basic
	@Column(name = "p_in_cnl")
	private Integer cnl;

	@Basic
	@Column(name = "p_in_street_code")
	private String streetCode;

	@Basic
	@Column(name = "p_in_address_num")
	private String streetNumber;

	@Basic
	@Column(name = "p_in_ident_equip1")
	private String cabinetId;

	@Basic
	@Column(name = "p_in_ident_equip2")
	private String terminalBoxId;

	@Basic
	@Column(name = "p_in_origem")
	private String origem;

	@Basic
	@Column(name = "p_out_distancia")
	private Integer distance;

	@Id
	@Basic
	@Column(name = "p_out_cod")
	private Integer code;

	@Basic
	@Column(name = "p_out_msg")
	private String message;
	
	public DetermineDistanceEntity () {
		super();
	}

	public DetermineDistanceEntity(Integer cnl, String streetCode, String streetNumber, String cabinetId, String terminalBoxId,
			String origem, Integer distance, Integer code, String message) {
		super();
		this.cnl = cnl;
		this.streetCode = streetCode;
		this.streetNumber = streetNumber;
		this.cabinetId = cabinetId;
		this.terminalBoxId = terminalBoxId;
		this.origem = origem;
		this.distance = distance;
		this.code = code;
		this.message = message;
	}
	
	public DetermineDistanceEntity(BrazilianUrbanPropertyAddress address) {

		this.cnl = Integer.parseInt(address.getCnl());
		this.streetCode = address.getStreetCode();
		this.streetNumber = address.getStreetNrFirst();
	}

	public Integer getCnl() {
		return cnl;
	}

	public void setCnl(Integer cnl) {
		this.cnl = cnl;
	}

	public String getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCabinetId() {
		return cabinetId;
	}

	public void setCabinetId(String cabinetId) {
		this.cabinetId = cabinetId;
	}

	public String getTerminalBoxId() {
		return terminalBoxId;
	}

	public void setTerminalBoxId(String terminalBoxId) {
		this.terminalBoxId = terminalBoxId;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
