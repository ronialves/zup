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
@NamedStoredProcedureQuery(name = ResourceStatusGponEntity.ALTER_STATUS, resultClasses = ResourceStatusGponEntity.class,  procedureName = "PKG_PATH.PRC_ALTER_STATUS_GPON",
parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = ResourceStatusGponEntity.IN_P_TERMINAL, type = String.class)
			, @StoredProcedureParameter(mode = ParameterMode.IN, name = ResourceStatusGponEntity.IN_P_STATUS, type = String.class)
			, @StoredProcedureParameter(mode = ParameterMode.OUT, name = ResourceStatusGponEntity.OUT_P_RET_CODE, type = String.class)
			, @StoredProcedureParameter(mode = ParameterMode.OUT, name = ResourceStatusGponEntity.OUT_P_RET_MSG, type = String.class)
			})
public class ResourceStatusGponEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String OUT_P_RET_CODE = "p_ret_code";
	public static final String OUT_P_RET_MSG = "p_ret_msg";
	public static final String IN_P_TERMINAL = "p_terminal";
	public static final String IN_P_STATUS = "p_status";
	
	public static final String ALTER_STATUS = "alterStatus";
	public static final String PKG_PATH_PRC_ALTER_STATUS_GPON = "PKG_PATH.PRC_ALTER_STATUS_GPON";

	
	@Column(name="p_terminal")
	private String terminal;
	
	@Column(name="p_status")
	private String status;
	
	@Id
	@Column(name="p_ret_code")
	private String returnCode;
	
	@Column(name="p_ret_msg")
	private String returnMessage;
	
	@Transient
	private ResultTo result;

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
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

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ResourceStatusGponEntity [terminal=" + terminal + ", status" + status + ", returnCode="
				+ returnCode + ", returnMessage=" + returnMessage + "]";
	}
}
