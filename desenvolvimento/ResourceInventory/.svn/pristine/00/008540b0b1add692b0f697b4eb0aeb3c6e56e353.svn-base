package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerOrderComprisedOf", propOrder = { "id","productCode","productBundle" })
public class CustomerOrderComprisedOf {

	private String id;
	protected String productCode;	
	protected ProductBundle productBundle;
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	
	/**
	 * @return productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public ProductBundle getProductBundle() {
		return productBundle;
	}

	public void setProductBundle(ProductBundle productBundle) {
		this.productBundle = productBundle;
	}

	@Override
	public String toString() {
		return "CustomerOrderComprisedOf [id=" + id + ", productCode=" + productCode + "]";
	}
	
}