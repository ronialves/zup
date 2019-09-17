package com.tlf.oss.resourceinventory.schemas.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "SEQ_RI_CUSTOMER", allocationSize = 1)	
@NamedQuery(name = "CustomerEntity.byAccessDesignator", query = "SELECT c FROM CustomerEntity c WHERE c.accessDesignator = :accessDesignator")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerEntity", propOrder = { "accessDesignator", "accessId", "customerId", "networkOwner", "accessTechnology", "status", "provider", "createDate" })
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
	@Column(name = "ID")
	@XmlTransient
	private Long id;
	
	@Column(name = "ACCESS_DESIGNATOR")
	private String accessDesignator;
	
	@Column(name = "ACCESS_ID")
	private String accessId;
	
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	@Column(name = "NETWORK_OWNER")
	private String networkOwner;
	
	@Column(name = "ACCESS_TECHNOLOGY")
	private String accessTechnology;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "PROVIDER")
	private String provider;
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public String getAccessDesignator() {
		return accessDesignator;
	}

	public void setAccessDesignator(String accessDesignator) {
		this.accessDesignator = accessDesignator;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getNetworkOwner() {
		return networkOwner;
	}

	public void setNetworkOwner(String networkOwner) {
		this.networkOwner = networkOwner;
	}

	public String getAccessTechnology() {
		return accessTechnology;
	}

	public void setAccessTechnology(String accessTechnology) {
		this.accessTechnology = accessTechnology;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
