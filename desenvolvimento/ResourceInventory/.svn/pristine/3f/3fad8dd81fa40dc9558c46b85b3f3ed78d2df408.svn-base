package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerOrder", propOrder = { "purchaseOrderNumber", "customerOrderType", "customerOrderComprisedOfList", "involvesCustomer" })

public class CustomerOrder {

	@NotNull
	protected String purchaseOrderNumber;
	protected String customerOrderType;
	
	@XmlElement(name="customerOrderComprisedOf")
	private List<CustomerOrderComprisedOf> customerOrderComprisedOfList;
	
	private InvolvesCustomer involvesCustomer;


	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String value) {
		this.purchaseOrderNumber = value;
	}
	
	public List<CustomerOrderComprisedOf> getCustomerOrderComprisedOfList() {

		if (customerOrderComprisedOfList == null) {
			customerOrderComprisedOfList = new ArrayList<>();
		}
		return customerOrderComprisedOfList;
	}

	public void setCustomerOrderComprisedOfList(List<CustomerOrderComprisedOf> customerOrderComprisedOfList) {
		this.customerOrderComprisedOfList = customerOrderComprisedOfList;
	}

	public InvolvesCustomer getInvolvesCustomer() {
		return involvesCustomer;
	}

	public void setInvolvesCustomer(InvolvesCustomer involvesCustomer) {
		this.involvesCustomer = involvesCustomer;
	}
	
	public String getCustomerOrderType() {
		return customerOrderType;
	}

	public void setCustomerOrderType(String customerOrderType) {
		this.customerOrderType = customerOrderType;
	}

}