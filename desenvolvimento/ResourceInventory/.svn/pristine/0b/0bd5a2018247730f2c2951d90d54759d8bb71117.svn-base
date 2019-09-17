package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Shelf", propOrder = { "hasCards", "networkAddressAssociation", "rack", "subRack", "ipController",
		"logicalResourceAssociation", "typeOfResource", "name", "dslam", "profile", "id", "slotId", "status",
		"resourceCharacteristicSpecifications", "physicalResourceSpecAttributes","vendor", "model", "ipAddress"  })
public class Shelf {

	/**
	 * Id do shelf se existir i.e Número do shelf dentro do Rack (dependendo do vendor, pode ser 0 ou 1)
	 */
	protected String id; //@maintained
	protected String vendor;//@new
	protected String model;//@new
	protected String name;//@maintained

	/**
	 * Ip do equipamento na rede de gerencia
	 */
	protected IPAddress ipAddress; //@new @movedFrom ipController
	protected IPAddress ipController;//@movedTo ipAddress
	protected String rack;//@maintained
	protected String subRack;//@maintained
	@XmlElement(name = "hasCards")
	protected List<PortAdapterCard> hasCards;//@maintained
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected NetworkAddressAssociation networkAddressAssociation;
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected LogicalResourceAssociation logicalResourceAssociation;
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String typeOfResource;
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String dslam;
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String profile;
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String slotId;
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String status;
	protected List<ResourceCharacteristicSpecification> resourceCharacteristicSpecifications;//@maintained
	
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected PhysicalResourceSpecAttributes physicalResourceSpecAttributes;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getTypeOfResource() {
		return typeOfResource;
	}

	public void setTypeOfResource(String typeOfResource) {
		this.typeOfResource = typeOfResource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDslam() {
		return dslam;
	}

	public void setDslam(String dslam) {
		this.dslam = dslam;
	}

	public List<PortAdapterCard> getHasCards() {
		if (hasCards == null) {
			hasCards = new ArrayList<PortAdapterCard>();
		}
		return this.hasCards;
	}

	public void setHasCards(List<PortAdapterCard> hasCards) {
		this.hasCards = hasCards;
	}

	public NetworkAddressAssociation getNetworkAddressAssociation() {
		return networkAddressAssociation;
	}

	public void setNetworkAddressAssociation(NetworkAddressAssociation networkAddressAssociation) {
		this.networkAddressAssociation = networkAddressAssociation;
	}

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public String getSubRack() {
		return subRack;
	}

	public void setSubRack(String subRack) {
		this.subRack = subRack;
	}

	public IPAddress getIpController() {
		return ipController;
	}

	public void setIpController(IPAddress ipController) {
		this.ipController = ipController;
	}

	public LogicalResourceAssociation getLogicalResourceAssociation() {
		return logicalResourceAssociation;
	}

	public void setLogicalResourceAssociation(LogicalResourceAssociation logicalResourceAssociation) {
		this.logicalResourceAssociation = logicalResourceAssociation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the slotId
	 */
	public String getSlotId() {
		return slotId;
	}

	/**
	 * @param slotId
	 *            the slotId to set
	 */
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the resourceCharacteristicSpecifications
	 */
	public List<ResourceCharacteristicSpecification> getResourceCharacteristicSpecifications() {
		if (resourceCharacteristicSpecifications == null) {
			resourceCharacteristicSpecifications = new ArrayList<ResourceCharacteristicSpecification>();
        }
		return resourceCharacteristicSpecifications;
	}

	/**
	 * @param resourceCharacteristicSpecifications
	 *            the resourceCharacteristicSpecifications to set
	 */
	public void setResourceCharacteristicSpecifications(
			List<ResourceCharacteristicSpecification> resourceCharacteristicSpecifications) {
		this.resourceCharacteristicSpecifications = resourceCharacteristicSpecifications;
	}
	
	public PhysicalResourceSpecAttributes getPhysicalResourceSpecAttributes() {
		return physicalResourceSpecAttributes;
	}

	public void setPhysicalResourceSpecAttributes(PhysicalResourceSpecAttributes physicalResourceSpecAttributes) {
		this.physicalResourceSpecAttributes = physicalResourceSpecAttributes;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public IPAddress getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(IPAddress ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
}
