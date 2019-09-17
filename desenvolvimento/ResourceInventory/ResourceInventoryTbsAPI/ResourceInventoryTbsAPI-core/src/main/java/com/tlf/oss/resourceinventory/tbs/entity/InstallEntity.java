package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.tbs.to.ResultTo;

/**
 * BEATRIXTWO-29 | DEMOSS-2218
 * 
 * @author rodrigo.de.freitas
 * @project Beatrix Fase 2
 * @since 201710
 *
 */
@Entity
@NamedStoredProcedureQuery(name = "install", resultClasses = InstallEntity.class, procedureName = "ASAP.TLF_SP_INSTALL", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_pon", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_designador_acesso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_cod_retorno", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_msg_retorno", type = String.class) })
public class InstallEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(name = "p_pon")
	private String purchaseOrderNumber;
	
	@Basic
	@Column(name = "p_designador_acesso")
	private String designadorAcesso;
	
	@Id
	@Basic
	@Column(name = "p_cod_retorno")
	private Integer returnCode;
	
	@Basic
	@Column(name = "p_msg_retorno")
	private String message;
	
	@Transient
	private ResultTo result;

	public InstallEntity() {
		super();
	}

	public InstallEntity(String purchaseOrderNumber, String designadorAcesso, Integer returnCode, String message, ResultTo result) {
		super();
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.designadorAcesso = designadorAcesso;
		this.returnCode = returnCode;
		this.message = message;
		this.result = result;
	}
	
	/**
	 * @return the purchaseOrderNumber
	 */
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	/**
	 * @param purchaseOrderNumber the purchaseOrderNumber to set
	 */
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	/**
	 * @return the designadorAcesso
	 */
	public String getDesignadorAcesso() {
		return designadorAcesso;
	}

	/**
	 * @param designadorAcesso the designadorAcesso to set
	 */
	public void setDesignadorAcesso(String designadorAcesso) {
		this.designadorAcesso = designadorAcesso;
	}

	/**
	 * @return the returnCode
	 */
	public Integer getReturnCode() {
		return returnCode;
	}

	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * @return the returnMessage
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param returnMessage the returnMessage to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public ResultTo getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultTo result) {
		this.result = result;
	}
}
