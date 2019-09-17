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
@NamedStoredProcedureQuery(name = ChangeSpeedEntity.NAMED_PROC_QUERY, resultClasses = ChangeSpeedEntity.class, procedureName = ChangeSpeedEntity.PRC_NAME, 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_circ_path_inst_id", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_speed", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_unit_speed", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_code", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ret_msg", type = String.class) 
})
public class ChangeSpeedEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String PRC_NAME = "PKG_RESERVE.PRC_CHANGE_SPEED";
	public static final String NAMED_PROC_QUERY = "changeSpeed";
	public static final String P_CIRC_PATH_INST_ID = "p_circ_path_inst_id";
	public static final String P_SPEED = "p_speed";
	public static final String P_UNIT_SPEED = "p_unit_speed";

	@Id
	@Basic
	@Column(name = "p_ret_code")
	private String code;

	@Basic
	@Column(name = "p_ret_msg")
	private String description;
	
	@Column(name = ChangeSpeedEntity.P_CIRC_PATH_INST_ID)
	private Long circPathInstId;

	@Column(name = "p_speed")
	private String speed;

	@Column(name = "p_unit_speed")
	private String unitSpeed;

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

	public String getUnitSpeed() {
		return unitSpeed;
	}

	public void setUnitSpeed(String unitSpeed) {
		this.unitSpeed = unitSpeed;
	}

}
