package com.tlf.oss.resourceinventory.schemas.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrchestrationAuditEntity", propOrder = { "correlationId", "type", "externalId", "startDate", "endDate",
		"status", "statusReason", "clientId", "messageId", "serviceName", "interfaceName", "operation", "version",
		"action", "request", "response", "errorClass", "error" })
@Entity
@Table(name = "ORCHESTRATION")
@SequenceGenerator(name = "ORCHESTRATION_SEQ", sequenceName = "SEQ_RI_ORCHESTRATION", allocationSize = 1)
public class OrchestrationAuditEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORCHESTRATION_SEQ")
	@Column(name = "ID")
	@XmlTransient
	private Long id;

	@Column(name = "CORRELATION_ID")
	private String correlationId;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "EXTERNAL_ID")
	private String externalId;

	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "STATUS_REASON")
	private String statusReason;

	@Column(name = "CLIENT_ID")
	private String clientId;

	@Column(name = "MESSAGE_ID")
	private String messageId;

	@Column(name = "SERVICE_NAME")
	private String serviceName;

	@Column(name = "INTERFACE_NAME")
	private String interfaceName;

	@Column(name = "OPERATION")
	private String operation;

	@Column(name = "VERSION")
	private String version;

	@Lob
	@Column(name = "ACTION")
	private String action;

	@Lob
	@Column(name = "REQUEST")
	private String request;

	@Lob
	@Column(name = "RESPONSE")
	private String response;

	@Column(name = "ERROR_CLASS")
	private String errorClass;

	@Lob
	@Column(name = "ERROR")
	private String error;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getErrorClass() {
		return errorClass;
	}

	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}