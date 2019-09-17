package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;

@Entity
@NamedStoredProcedureQuery(name = ResourceStatusEntity.CONFIRM_INTERNAL, resultClasses = ResourceStatusEntity.class,  procedureName = "PKG_PATH.PRC_ALTER_STATUS",
parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = ResourceStatusEntity.IN_P_CIRC_PATH_INST_ID, type = Long.class)
		    , @StoredProcedureParameter(mode = ParameterMode.IN, name = ResourceStatusEntity.IN_P_STATUS, type = String.class)
      		, @StoredProcedureParameter(mode = ParameterMode.OUT, name = ResourceStatusEntity.OUT_P_RET_CODE, type = String.class)
			, @StoredProcedureParameter(mode = ParameterMode.OUT, name = ResourceStatusEntity.OUT_P_RET_MSG, type = String.class)
			})
public class ResourceStatusEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String OUT_P_RET_CODE = "p_ret_code";
	public static final String OUT_P_RET_MSG = "p_ret_msg";
	public static final String IN_P_STATUS = "p_status";
	public static final String IN_P_CIRC_PATH_INST_ID = "p_circ_path_inst_id";
	
	public static final String CONFIRM_INTERNAL = "confirmInternal";
	
	@Column(name="p_circ_path_inst_id")
	private Long circPathInstId;
	
	@Column(name="p_status")
	private String status;
	
	@Id
	@Column(name="p_ret_code")
	private String returnCode;
	
	@Column(name="p_ret_msg")
	private String returnMessage;
	
	@Transient
	private ResultTo result;
	
	public ResourceStatusEntity() {
	}
	
	public ResourceStatusEntity(Long circPathInstId, String status) {
		this.circPathInstId = circPathInstId;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getCircPathInstId() {
		return circPathInstId;
	}

	public void setCircPathInstId(Long circPathInstId) {
		this.circPathInstId = circPathInstId;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}
	
	public ResultTo getResult() {
		if(null==result){
			result= new ResultTo();
		}
		return result;
	}

	@Override
	public String toString() {
		return "ResourceStatusEntity [circPathInstId=" + circPathInstId + ", status=" + status + ", returnCode="
				+ returnCode + ", returnMessage=" + returnMessage + "]";
	}
	
}
