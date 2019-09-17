package com.tlf.oss.resourceinventory.schemas.api.v1_0;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.GeneralDistributor;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveResourceInformationOut", propOrder = { "cabinet", "networkAggregator", "generalDistributors",
		"resourceOrder", "resourceFacingService", "customerFacingService", "address" })
public class RetrieveResourceInformationOut {

	protected Cabinet cabinet;
	protected PhysicalResource networkAggregator;
	private List<GeneralDistributor> generalDistributors;	
	protected ResourceOrder resourceOrder; 
	protected ResourceFacingService resourceFacingService;
	protected List<CustomerFacingService> customerFacingService;
	private BrazilianUrbanPropertyAddress address;

	public RetrieveResourceInformationOut() {
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public PhysicalResource getNetworkAggregator() {
		return networkAggregator;
	}

	public void setNetworkAggregator(PhysicalResource networkAggregator) {
		this.networkAggregator = networkAggregator;
	}

	public List<GeneralDistributor> getGeneralDistributors() {
		return generalDistributors;
	}

	public void setGeneralDistributors(List<GeneralDistributor> generalDistributors) {
		this.generalDistributors = generalDistributors;
	}

	/**
	 * @return the resourceOrder
	 */
	public ResourceOrder getResourceOrder() {
		return resourceOrder;
	}

	/**
	 * @param resourceOrder the resourceOrder to set
	 */
	public void setResourceOrder(ResourceOrder resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

	/**
	 * @return the resourceFacingService
	 */
	public ResourceFacingService getResourceFacingService() {
		return resourceFacingService;
	}

	/**
	 * @param resourceFacingService the resourceFacingService to set
	 */
	public void setResourceFacingService(ResourceFacingService resourceFacingService) {
		this.resourceFacingService = resourceFacingService;
	}

	public List<CustomerFacingService> getCustomerFacingService() {
		return customerFacingService;
	}

	public void setCustomerFacingService(List<CustomerFacingService> customerFacingService) {
		this.customerFacingService = customerFacingService;
	}

	public BrazilianUrbanPropertyAddress getAddress() {
		return address;
	}

	public void setAddress(BrazilianUrbanPropertyAddress address) {
		this.address = address;
	}
}