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
@NamedStoredProcedureQuery(name = RetrieveAvailabilityGponEntity.RETRIEVE_AVAILABILITY_GPON, resultClasses = RetrieveAvailabilityGponEntity.class, procedureName = "PKG_RESERVE.PRC_AVAILABILITY_GPON",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cnl", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_at", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_primary_cable", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_primary_fiber", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_access_designator", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_down", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_up", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_free_ports", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})

public class RetrieveAvailabilityGponEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String RETRIEVE_AVAILABILITY_GPON = "retrieveAvailabilityGpon";

	@Basic
	@Column(name="p_cnl")
	private String cnl;

	@Basic
	@Column(name="p_at")
	private String at;

	@Basic
	@Column(name="p_primary_cable")
	private String primaryCable;

	@Basic
	@Column(name="p_primary_fiber")
	private String primaryFiber;

	@Basic
	@Column(name="p_access_designator")
	private String terminal;
	
	@Basic
	@Column(name="p_down")
	private String maxBroadbandSpeed;

	@Basic
	@Column(name="p_up")
	private String up;
	
	@Basic
	@Column(name="p_free_ports")
	private String freePorts;

	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;

	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	public RetrieveAvailabilityGponEntity() {
		super();
	}

	public String getCnl() {
		return cnl;
	}

	public void setCnl(String cnl) {
		this.cnl = cnl;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public String getPrimaryCable() {
		return primaryCable;
	}

	public void setPrimaryCable(String primaryCable) {
		this.primaryCable = primaryCable;
	}

	public String getPrimaryFiber() {
		return primaryFiber;
	}

	public void setPrimaryFiber(String primaryFiber) {
		this.primaryFiber = primaryFiber;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getMaxBroadbandSpeed() {
		return maxBroadbandSpeed;
	}

	public void setMaxBroadbandSpeed(String maxBroadbandSpeed) {
		this.maxBroadbandSpeed = maxBroadbandSpeed;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}
	
	public String getFreePorts() {
		return freePorts;
	}

	public void setFreePorts(String freePorts) {
		this.freePorts = freePorts;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
