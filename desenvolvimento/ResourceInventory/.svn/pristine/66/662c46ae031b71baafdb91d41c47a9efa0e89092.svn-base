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
 * BEATRIXTWO-26 | DEMOSS-2171
 * 
 * @project Beatrix Fase 2
 * @author jannayna.c.araujo
 * @since 201709
 */

@Entity
@NamedStoredProcedureQuery(name = "allocate", resultClasses = AllocateEntity.class, procedureName = "ASAP.TLF_SP_ALLOCATE", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PON", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_RPON", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ACCOUNT_NBR", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CUSTOMER_LOCATION", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_REQUEST_TYPE", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ACTIVITY_IND", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOTE_TEXT", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DESIGNADOR_ACESSO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_SWITCH", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_BIT_RATE_QUANTITY_U", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_BIT_RATE_QUANTITY_D", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ACTIVITY_IND_ACESSO", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_DOCUMENT_NUMBER", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_COD_RETORNO", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_MSG_RETORNO", type = String.class) })
public class AllocateEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name = "P_PON")
	private String purchaseOrderNumber;

	@Basic
	@Column(name = "P_RPON")
	private String rpon;

	@Basic
	@Column(name = "P_ACCOUNT_NBR")
	private String accountNumber;

	@Basic
	@Column(name = "P_CUSTOMER_LOCATION")
	private String customerLocation;

	@Basic
	@Column(name = "P_REQUEST_TYPE")
	private String requestType;

	@Basic
	@Column(name = "P_ACTIVITY_IND")
	private String activityInd;

	@Basic
	@Column(name = "P_NOTE_TEXT")
	private String noteText;

	@Basic
	@Column(name = "P_DESIGNADOR_ACESSO")
	private String designadorAcesso;

	@Basic
	@Column(name = "P_SWITCH")
	private String switchName;

	@Basic
	@Column(name = "P_BIT_RATE_QUANTITY_U")
	private String rateQuantityU;

	@Basic
	@Column(name = "P_BIT_RATE_QUANTITY_D")
	private String rateQuantityD;

	@Basic
	@Column(name = "P_ACTIVITY_IND_ACESSO")
	private String activityIndAcesso;

	@Basic
	@Column(name = "P_DOCUMENT_NUMBER")
	private Integer documentNumber;

	@Id
	@Basic
	@Column(name = "P_COD_RETORNO")
	private Integer returnCode;

	@Basic
	@Column(name = "P_MSG_RETORNO")
	private String message;

	@Transient
	private ResultTo result;

	public AllocateEntity() {
		super();
	}

	public AllocateEntity(String purchaseOrderNumber, String rpon, String accountNumber, String customerLocation,
			String requestType, String activityInd, String noteText, String designadorAcesso, String switchName,
			String rateQuantityU, String rateQuantityD, String activityIndAcesso, Integer documentNumber,
			Integer returnCode, String message, ResultTo result) {
		super();
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.rpon = rpon;
		this.accountNumber = accountNumber;
		this.customerLocation = customerLocation;
		this.requestType = requestType;
		this.activityInd = activityInd;
		this.noteText = noteText;
		this.designadorAcesso = designadorAcesso;
		this.switchName = switchName;
		this.rateQuantityU = rateQuantityU;
		this.rateQuantityD = rateQuantityD;
		this.activityIndAcesso = activityIndAcesso;
		this.documentNumber = documentNumber;
		this.returnCode = returnCode;
		this.message = message;
		this.result = result;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public String getRpon() {
		return rpon;
	}

	public void setRpon(String rpon) {
		this.rpon = rpon;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getActivityInd() {
		return activityInd;
	}

	public void setActivityInd(String activityInd) {
		this.activityInd = activityInd;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public String getDesignadorAcesso() {
		return designadorAcesso;
	}

	public void setDesignadorAcesso(String designadorAcesso) {
		this.designadorAcesso = designadorAcesso;
	}

	public String getSwitchName() {
		return switchName;
	}

	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}

	public String getRateQuantityU() {
		return rateQuantityU;
	}

	public void setRateQuantityU(String rateQuantityU) {
		this.rateQuantityU = rateQuantityU;
	}

	public String getRateQuantityD() {
		return rateQuantityD;
	}

	public void setRateQuantityD(String rateQuantityD) {
		this.rateQuantityD = rateQuantityD;
	}

	public String getActivityIndAcesso() {
		return activityIndAcesso;
	}

	public void setActivityIndAcesso(String activityIndAcesso) {
		this.activityIndAcesso = activityIndAcesso;
	}

	public Integer getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
