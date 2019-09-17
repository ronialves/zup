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
import javax.persistence.Transient;
import javax.transaction.Transactional;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.OperationService;

@Entity
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "reserveResource", resultClasses = ReserveResourceEntity.class,procedureName = "PKG_RESERVE.PRC_RESERVE_RESOURCE",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cnl", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_at", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cabinete", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_terminal", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_speed", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_unit_speed", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_voice_protocol", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_access_type", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_service_type", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_readonly", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_id_resource", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_type_resource", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class)
})
})
@Transactional
public class ReserveResourceEntity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String OUT_P_RET_CODE = "p_ret_code";
    public static final String OUT_P_RET_MSG = "p_ret_msg";
	
	public static final String IN_P_CIRC_PATH_INST_ID = "p_circ_path_inst_id";
	public static final String IN_P_SPEED = "p_speed";
	public static final String IN_P_UNIT_SPEED = "p_unit_speed";
	
	public static final String OFFER_EDITION = "offerEdition";
	public static final String PKG_RESERVE_PRC_CHANGE_SPEED = "PKG_RESERVE.PRC_CHANGE_SPEED";
	
	@Basic
	@Column(name="cnl_in")
	private String cnl;

	@Basic
	@Column(name="p_ret_code")
	private String code;
	
	@Basic
	@Column(name="p_ret_msg")
	private String description;
	
	@Basic
	@Column(name="p_type_resource")
	private String resourceType;
	
	@Id
	@Basic
	@Column(name="p_id_resource")
	private String listCode;
	
	@Basic
	@Column(name="p_readonly")
	private String readonly;
	
	@Transient
	private Cabinet cabinet;
	
	@Transient
	private OperationService operationService;
	
	@Transient
	private String speed;
	
	@Transient
	private String unitSpeed;
	
	@Transient
	private String telephonicArea;
	
	@Transient
	private String locker;
	
	@Transient
	private String terminal;
	
	@Transient
	private String unit;
	
	@Transient
	private String protocol;
	
	@Transient
	private ResultTo result ;

	public String getCnl() {
		return cnl;
	}

	public void setCnl(String cnl) {
		this.cnl = cnl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public ResultTo getResult() {
		if(null==result){
			result= new ResultTo();
		}
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getListCode() {
		return listCode;
	}

	public void setListCode(String listCode) {
		this.listCode = listCode;
	}
	
	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	public String getLocker() {
		return locker;
	}

	public void setLocker(String locker) {
		this.locker = locker;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
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

	public String getTelephonicArea() {
		return telephonicArea;
	}

	public void setTelephonicArea(String telephonicArea) {
		this.telephonicArea = telephonicArea;
	}

	public String getUnitSpeed() {
		return unitSpeed;
	}

	public void setUnitSpeed(String unitSpeed) {
		this.unitSpeed = unitSpeed;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

}
