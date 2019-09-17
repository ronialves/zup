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
@NamedStoredProcedureQuery(name = CancelChangeSpeedGponEntity.NAMED_PROC_QUERY, 
resultClasses = CancelChangeSpeedGponEntity.class, 
procedureName = CancelChangeSpeedGponEntity.PRC_NAME, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = CancelChangeSpeedGponEntity.SERVICE_ID, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = CancelChangeSpeedGponEntity.SERVICE_CODE, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})
public class CancelChangeSpeedGponEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String PRC_NAME = "pkg_reserve.PRC_CANCEL_OFFER_EDITION";
	public static final String NAMED_PROC_QUERY = "cancelChangeGponSpeed";
	public static final String SERVICE_ID = "p_access_designator";
	public static final String SERVICE_CODE = "p_service_code";
	
	@Id
	@Basic
	@Column(name = "p_ret_code")
	private String code;
	
	@Basic
	@Column(name = "p_ret_msg")
	private String description;
	
	@Column(name = SERVICE_CODE)
	private String serviceCode;
	
	@Column(name = SERVICE_ID)
	private String serviceId;

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
	
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
}
