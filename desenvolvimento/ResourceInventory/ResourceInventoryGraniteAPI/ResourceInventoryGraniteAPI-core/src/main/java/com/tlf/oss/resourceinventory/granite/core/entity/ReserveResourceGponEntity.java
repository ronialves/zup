package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.transaction.Transactional;

@Entity
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = ReserveResourceGponEntity.QUERY_NAME, resultClasses = ReserveResourceGponEntity.class, procedureName = ReserveResourceGponEntity.PROC_NAME,
parameters ={
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cnl", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_at", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_primary_cable", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_primary_fiber", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_access_designator", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_service_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
		
})
})
@Transactional
public class ReserveResourceGponEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String OUT_P_RET_CODE = "p_ret_code";
    public static final String OUT_P_RET_MSG = "p_ret_msg";
    public static final String PROC_NAME = "PKG_RESERVE.PRC_RESERVE_RESOURCE_GPON";
    public static final String QUERY_NAME = "reserveResourceGpon";
	
	@Basic
	@Column(name="cnl_in")
	private String cnl;
	
	@Basic
	@Column(name="p_at")
	private String siglaAt;
	
	@Basic
	@Column(name="p_primary_cable")
	private String primaryCable;
	
	@Basic
	@Column(name="p_primary_fiber")
	private String primaryFiber;
	
	@Basic
	@Column(name="p_access_designator")
	private String accessDesignator;
	
	@Basic
	@Column(name="p_service_code")
	private String serviceCode;
	
	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;
	
	@Basic
	@Column(name="p_ret_msg")
	private String description;

	public String getCnl() {
		return cnl;
	}

	public void setCnl(String cnl) {
		this.cnl = cnl;
	}

	public String getSiglaAt() {
		return siglaAt;
	}

	public void setSiglaAt(String siglaAt) {
		this.siglaAt = siglaAt;
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

	public String getAccessDesignator() {
		return accessDesignator;
	}

	public void setAccessDesignator(String accessDesignator) {
		this.accessDesignator = accessDesignator;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
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
