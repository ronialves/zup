package com.tlf.oss.resourceinventory.schemas.api;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Circuit;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.Equipment;
import com.tlf.oss.resourceinventory.schemas.GeneralDistributor;
import com.tlf.oss.resourceinventory.schemas.OperationService;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.Resource;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceInventoryWarn;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.Satellite;
import com.tlf.oss.resourceinventory.schemas.api.resourcelifecyclemanagement.v1_0.GatherResourceInformation;

/**
 * Entidade que será trafegada entre todas as camadas do RI (WS, Orchestration e
 * API)
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceInventoryEntity", propOrder = { "networkAggregator", "customerOrder", "address", "cabinet",
		"satellite", "physicalLinks", "resourceFacingService", "customerFacingService", "circuit",
		"generalDistributors", "physicalResourceSummary", "resourceOrder", "operationService", "resource",
		"resourceInventoryWarn", "equipment", "gatherResourceInformation", "codeReturn", "messageReturn" })
public class ResourceInventoryEntity {

	private PhysicalResource networkAggregator;
	private CustomerOrder customerOrder;
	private BrazilianUrbanPropertyAddress address;
	private Cabinet cabinet;
	private Satellite satellite;
	@XmlElement(name = "physicalLinks")
	private List<PhysicalLink> physicalLinks;
	private ResourceFacingService resourceFacingService;
	private List<CustomerFacingService> customerFacingService;
	private Circuit circuit;
	private List<GeneralDistributor> generalDistributors;
	private String physicalResourceSummary;
	private ResourceOrder resourceOrder;
	private OperationService operationService;
	private Resource resource;
	private ResourceInventoryWarn resourceInventoryWarn;
	private List<Equipment> equipment;
	private GatherResourceInformation gatherResourceInformation;
	private Integer codeReturn;
	private String messageReturn;

	public List<GeneralDistributor> getGeneralDistributors() {
		if (null == generalDistributors)
			generalDistributors = new ArrayList<>();
		return generalDistributors;
	}

	public void setGeneralDistributors(List<GeneralDistributor> generalDistributors) {
		this.generalDistributors = generalDistributors;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public BrazilianUrbanPropertyAddress getAddress() {
		return address;
	}

	public void setAddress(BrazilianUrbanPropertyAddress address) {
		this.address = address;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public Satellite getSatellite() {
		return satellite;
	}

	public void setSatellite(Satellite satellite) {
		this.satellite = satellite;
	}

	public List<PhysicalLink> getPhysicalLinks() {
		if (physicalLinks == null)
			physicalLinks = new ArrayList<>();
		return physicalLinks;
	}

	public void setPhysicalLinks(List<PhysicalLink> physicalLinks) {
		this.physicalLinks = physicalLinks;
	}

	public ResourceFacingService getResourceFacingService() {
		return resourceFacingService;
	}

	public void setResourceFacingService(ResourceFacingService resourceFacingService) {
		this.resourceFacingService = resourceFacingService;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

	public PhysicalResource getNetworkAggregator() {
		return networkAggregator;
	}

	public void setNetworkAggregator(PhysicalResource networkAggregator) {
		this.networkAggregator = networkAggregator;
	}

	public List<CustomerFacingService> getCustomerFacingService() {
		return customerFacingService;
	}

	public void setCustomerFacingService(List<CustomerFacingService> customerFacingService) {
		this.customerFacingService = customerFacingService;
	}

	/**
	 * @return the physicalResourceSummary
	 */
	public String getPhysicalResourceSummary() {
		return physicalResourceSummary;
	}

	/**
	 * @param physicalResourceSummary
	 *            the physicalResourceSummary to set
	 */
	public void setPhysicalResourceSummary(String physicalResourceSummary) {
		this.physicalResourceSummary = physicalResourceSummary;
	}

	/**
	 * @return the resourceOrder
	 */
	public ResourceOrder getResourceOrder() {
		return resourceOrder;
	}

	/**
	 * @param resourceOrder
	 *            the resourceOrder to set
	 */
	public void setResourceOrder(ResourceOrder resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public ResourceInventoryWarn getResourceInventoryWarn() {
		return resourceInventoryWarn;
	}

	public void setResourceInventoryWarn(ResourceInventoryWarn resourceInventoryWarn) {
		this.resourceInventoryWarn = resourceInventoryWarn;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	public GatherResourceInformation getGatherResourceInformation() {
		return gatherResourceInformation;
	}

	public void setGatherResourceInformation(GatherResourceInformation gatherResourceInformation) {
		this.gatherResourceInformation = gatherResourceInformation;
	}

	public Integer getCodeReturn() {
		return codeReturn;
	}

	public void setCodeReturn(Integer codeReturn) {
		this.codeReturn = codeReturn;
	}

	public String getMessageReturn() {
		return messageReturn;
	}

	public void setMessageReturn(String messageReturn) {
		this.messageReturn = messageReturn;
	}

}