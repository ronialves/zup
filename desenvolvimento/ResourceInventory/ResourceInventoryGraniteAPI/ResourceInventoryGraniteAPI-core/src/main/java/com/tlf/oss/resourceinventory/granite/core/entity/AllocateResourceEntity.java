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
@NamedStoredProcedureQuery(name = AllocateResourceEntity.ALLOCATE_RESOURCE, resultClasses = AllocateResourceEntity.class,procedureName = "PKG_ALLOCATE.PRC_CONFIGURE_PATH",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cnl", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_sigla_at", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rack", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_circ_path_inst_id", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_speed", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_unit", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_protocol", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_customer", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_product", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_user", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_access_type", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_service_type", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_readonly", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})public class AllocateResourceEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ALLOCATE_RESOURCE = "allocateInternalResource";
	
	@Basic
	@Column(name="p_cnl")
	private String cnl;

	@Basic
	@Column(name="p_sigla_at")
	private String siglaAt;

	@Basic
	@Column(name="p_rack")
	private String rack;
	
	@Basic
	@Column(name="p_circ_path_inst_id")
	private Long circPathInstId;
	
	@Basic
	@Column(name="p_speed")
	private String speed;

	@Basic
	@Column(name="p_unit")
	private String unit;
	
	@Basic
	@Column(name="p_protocol")
	private String protocol;
	
	@Basic
	@Column(name="p_customer")
	private String customer;

	@Basic
	@Column(name="p_product")
	private String product;
	
	@Basic
	@Column(name="p_user")
	private String user;

	@Basic
	@Column(name="p_access_type")
	private String accessType;
	
	@Basic
	@Column(name="p_service_type")
	private String serviceType;
	
	@Basic
	@Column(name="p_readonly")
	private String readonly;
	
	@Id
	@Basic
	@Column(name="p_ret_code")
	private Integer code;
	
	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	public AllocateResourceEntity() {
		super();
	}
	
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

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public Long getCircPathInstId() {
		return circPathInstId;
	}

	public void setCircPathInstId(Long circPathInstId) {
		this.circPathInstId = circPathInstId;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAccesType() {
		return accessType;
	}

	public void setAccesType(String accesType) {
		this.accessType = accesType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}