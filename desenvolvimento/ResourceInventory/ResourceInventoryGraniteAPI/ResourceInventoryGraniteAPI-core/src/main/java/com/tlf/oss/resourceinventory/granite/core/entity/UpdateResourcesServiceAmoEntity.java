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
@NamedStoredProcedureQuery(name = UpdateResourcesServiceAmoEntity.UPDATE_RESOURCE_AMO, resultClasses = UpdateResourcesServiceAmoEntity.class,procedureName = UpdateResourcesServiceAmoEntity.UPDATE_RESOURCE_AMO_PROC,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = UpdateResourcesServiceAmoEntity.SERVICE_ID, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = UpdateResourcesServiceAmoEntity.SERVICE_CODE, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = UpdateResourcesServiceAmoEntity.STATUS, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
}) 
public class UpdateResourcesServiceAmoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String UPDATE_RESOURCE_AMO = "updateResourcesServiceAmo";
	public static final String UPDATE_RESOURCE_AMO_PROC = "PKG_ALLOCATE.PRC_PARTIAL_DISCONNECTION";
	public static final String SERVICE_ID = "p_access_designator";
	public static final String SERVICE_CODE = "p_service_code";
	public static final String STATUS = "p_status";
	
	@Basic
	@Column(name=SERVICE_ID)
	private String accessDesignator;
	
	@Basic
	@Column(name=STATUS)
	private String status;
	
	@Basic
	@Column(name=SERVICE_CODE)
	private String serviceCode;
	
	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;
	
	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getAccessDesignator() {
		return accessDesignator;
	}

	public void setAccessDesignator(String accessDesignator) {
		this.accessDesignator = accessDesignator;
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
