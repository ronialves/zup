package com.tlf.oss.resourceinventory.granite.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ServiceCodeEntity extends EntityCommon<Long> {

	private static final long serialVersionUID = 1L;

	public static final String RETRIEVE_SERVICE_CODE_QUERY = "ServiceCodeEntity.retrieveServiceCode";

	@Id
	@Column(name = "ID_SERVICO")
	private Long id;

	@Column(name = "SERVICE_CODE")
	private String serviceCode;

	@Column(name = "SERVICE_CLASS")
	private String serviceClass;

	@Column(name = "TYPE_SERVICE")
	private String serviceType;

	@Column(name = "NOME_PRODUTO")
	private String productName;

	@Column(name = "VELOCIDADE_UP")
	private String velocityUp;

	@Column(name = "VELOCIDADE_UP_FTB")
	private String velocityUpFtb;

	@Column(name = "VELOCIDADE_DOWN")
	private String velocityDown;

	@Column(name = "VELOCIDADE_DOWN_FTB")
	private String velocityDownFtb;

	@Column(name = "BW_NAME")
	private String bwName;

	@Column(name = "ACCESS_TYPE")
	private String accessType;

	@Column(name = "PROFILE_TYPE")
	private String profileType;

	@Column(name = "BITSTREAM")
	private String bitstream;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getVelocityUp() {
		return velocityUp;
	}

	public void setVelocityUp(String velocityUp) {
		this.velocityUp = velocityUp;
	}

	public String getVelocityUpFtb() {
		return velocityUpFtb;
	}

	public void setVelocityUpFtb(String velocityUpFtb) {
		this.velocityUpFtb = velocityUpFtb;
	}

	public String getVelocityDown() {
		return velocityDown;
	}

	public void setVelocityDown(String velocityDown) {
		this.velocityDown = velocityDown;
	}

	public String getVelocityDownFtb() {
		return velocityDownFtb;
	}

	public void setVelocityDownFtb(String velocityDownFtb) {
		this.velocityDownFtb = velocityDownFtb;
	}

	public String getBwName() {
		return bwName;
	}

	public void setBwName(String bwName) {
		this.bwName = bwName;
	}

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	public String getBitstream() {
		return bitstream;
	}

	public void setBitstream(String bitstream) {
		this.bitstream = bitstream;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceCodeEntity [id=").append(id)
			   .append(", serviceCode=").append(serviceCode)
			   .append(", serviceClass=").append(serviceClass)
			   .append(", serviceType=").append(serviceType)
			   .append(", productName=").append(productName)
			   .append(", velocityUp=").append(velocityUp)
			   .append(", velocityUpFtb=").append(velocityUpFtb)
			   .append(", velocityDown=").append(velocityDown)
			   .append(", velocityDownFtb=").append(velocityDownFtb)
			   .append(", bwName=").append(bwName)
			   .append(", accessType=").append(accessType)
			   .append(", profileType=").append(profileType)
			   .append(", bitstream=").append(bitstream).append("]");
		return builder.toString();
	}
}
