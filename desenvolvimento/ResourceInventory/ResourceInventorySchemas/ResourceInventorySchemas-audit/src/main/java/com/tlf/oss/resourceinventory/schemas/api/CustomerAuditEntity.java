
package com.tlf.oss.resourceinventory.schemas.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@XmlType(name = "CustomerEntity", propOrder = { "orchestrationId", "clientId", "messageId", "accessDesignator", "action", "createDate" })
@Entity
@Table(name = "CUSTOMER_AUDIT")
@SequenceGenerator(name = "CUSTOMER_AUDIT_SEQ", sequenceName = "SEQ_RI_CUSTOMER_AUDIT", allocationSize = 1)	
public class CustomerAuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_AUDIT_SEQ")
	@Column(name = "ID")
	@XmlTransient
	private Long id;
	
	@Column(name = "ORCHESTRATION_ID")
	private String orchestrationId;
	
	@Column(name = "CLIENT_ID")
	private String clientId;
	
	@Column(name = "MESSAGE_ID")
	private String messageId;
	
	@Column(name = "ACCESS_DESIGNATOR")
	private String accessDesignator;
	
	@Column(name = "ACTION")
	private String action;
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;


	public String getOrchestrationId() {
		return orchestrationId;
	}

	public void setOrchestrationId(String orchestrationId) {
		this.orchestrationId = orchestrationId;
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

	public String getAccessDesignator() {
		return accessDesignator;
	}

	public void setAccessDesignator(String accessDesignator) {
		this.accessDesignator = accessDesignator;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
