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
@NamedStoredProcedureQuery(name = AllocateResourceGponEntity.ALLOCATE_RESOURCE_GPON, resultClasses = AllocateResourceGponEntity.class, procedureName = "PKG_ALLOCATE.PRC_ALLOCATE_GPON",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_customer_id", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_access_designator", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})
public class AllocateResourceGponEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ALLOCATE_RESOURCE_GPON = "allocateResourceGpon";
	public static final String PKG_ALLOCATE_PRC_ALLOCATE_GPON = "PKG_ALLOCATE.PRC_ALLOCATE_GPON";

	@Basic
	@Column(name="p_customer_id")
	private String customerId;

	@Basic
	@Column(name="p_access_designator")
	private String accessDesignator;

	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;

	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	public AllocateResourceGponEntity() {
		super();
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
