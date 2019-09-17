package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;

@Entity
@NamedStoredProcedureQuery(name = CancelResourceGponEntity.CANCEL_RESOURCE_GPON, resultClasses = CancelResourceGponEntity.class,
	procedureName = CancelResourceGponEntity.PKG_RESERVE_PRC_CANCEL_RESERVE_GPON, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = CancelResourceGponEntity.IN_P_TERMINAL, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = CancelResourceGponEntity.OUT_P_RET_CODE, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = CancelResourceGponEntity.OUT_P_RET_MSG, type = String.class)
	})
public class CancelResourceGponEntity extends EntityCommon<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String OUT_P_RET_CODE = "p_ret_code";
	public static final String OUT_P_RET_MSG = "p_ret_msg";
	
	public static final String IN_P_TERMINAL = "p_access_designator";

	public static final String CANCEL_RESOURCE_GPON = "cancelResourceGpon";
	public static final String PKG_RESERVE_PRC_CANCEL_RESERVE_GPON = "PKG_RESERVE.PRC_CANCEL_RESERVE_GPON";

	@Basic
	@Column(name="p_terminal")
	private String terminal;

	@Id
	@Basic
	@Column(name="p_ret_code")
	private String code;

	@Basic
	@Column(name="p_ret_msg")
	private String description;

	@Transient
        private ResultTo result ;

	public CancelResourceGponEntity() {
		super();
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
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

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
	}
}
