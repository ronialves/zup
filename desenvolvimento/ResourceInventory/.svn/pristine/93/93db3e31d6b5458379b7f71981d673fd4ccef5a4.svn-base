package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cabinet", propOrder = { "id", "name", "customName", "distance", "terminalBox", "switchesAssociated", "hasShelves", "typeOfTopology", "feederCable",
										 "feederSideCable", "feederPair", "distributionCable", "distributionSideCable", "distributionPair", "idConexoesPotsMsan", 
										 "idMsan", "lic", "primaryCable", "primaryFiber", "splitter", "status", "type", "brazilianUrbanPropertyAddress", "typeOfResource",
										 "bRASAssociated", "agregatorAssociated"})
public class Cabinet {
	
	@NotNull
	protected String id;
	protected String type; //@new Ex: GPON | METALIC
	protected String name; //@maintained Ex: PRCTA_G1D23
	protected BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress; //@new
	protected String typeOfResource; //@new Ex: VIRTUAL | INTERNO | EXTERNO
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String customName;
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String distance;
	protected TerminalBox terminalBox; //@maintained
	protected SwitchesAssociated switchesAssociated; //@maintained
	@XmlElement(name = "BRASAssociated")
	protected SwitchesAssociated bRASAssociated; //@new TODO Rever
	@XmlElement(name = "agregatorAssociated")
	protected SwitchesAssociated agregatorAssociated; //@new TODO Rever
	
	@XmlElement(name = "hasShelves") //@maintained
	protected List<Shelf> hasShelves;
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String typeOfTopology;

	protected String feederCable;//@maintained EX: D23
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String feederSideCable;
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String feederPair;
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String distributionCable;
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String distributionSideCable;
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String distributionPair;
	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String idConexoesPotsMsan;
	@Transient
	@NotNull
	@Size(min=1)
	protected String idMsan;
	@Transient
	@NotNull
	@Size(min=1)
	protected String lic;
	@NotNull
	@Size(min=1)
	protected String primaryCable;//@manteined Passado internamente do OSP para o Grannite
	@NotNull
	@Size(min=1)
	protected String primaryFiber;//@manteined Passado internamente do OSP para o Grannite
	//protected Splitter splitter;//@removed Atualmente eh uma unidade, porem tem que ser array
	
	@XmlElement(name="splitter")
	protected List<Splitter> splitter;//@new Conferir Geracao
    public List<Splitter> getSplitter() {
        if (splitter == null) {
        	splitter = new ArrayList<Splitter>();
        }
        return this.splitter;
    }

	@Deprecated //@deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
	protected String status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrimaryCable() {
		return primaryCable;
	}

	public void setPrimaryCable(String primaryCable) {
		this.primaryCable = primaryCable;
	}

	public String getPrimaryFiber() {
		return primaryFiber;
	}

	public void setPrimaryFiber(String primaryFiber) {
		this.primaryFiber = primaryFiber;
	}
		
	public String getFeederCable() {
		return feederCable;
	}

	public void setFeederCable(String feederCable) {
		this.feederCable = feederCable;
	}

	public String getFeederSideCable() {
		return feederSideCable;
	}

	public void setFeederSideCable(String feederSideCable) {
		this.feederSideCable = feederSideCable;
	}

	public String getFeederPair() {
		return feederPair;
	}

	public void setFeederPair(String feederPair) {
		this.feederPair = feederPair;
	}

	public String getDistributionCable() {
		return distributionCable;
	}

	public void setDistributionCable(String distributionCable) {
		this.distributionCable = distributionCable;
	}

	public String getDistributionSideCable() {
		return distributionSideCable;
	}

	public void setDistributionSideCable(String distributionSideCable) {
		this.distributionSideCable = distributionSideCable;
	}

	public String getDistributionPair() {
		return distributionPair;
	}

	public void setDistributionPair(String distributionPair) {
		this.distributionPair = distributionPair;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public TerminalBox getTerminalBox() {
		return terminalBox; 
	}
	
	public void setTerminalBox(TerminalBox terminalBox) {
		this.terminalBox = terminalBox; 
	}

	public SwitchesAssociated getSwitchesAssociated() {
		return switchesAssociated;
	}

	public void setSwitchesAssociated(SwitchesAssociated switchesAssociated) {
		this.switchesAssociated = switchesAssociated;
	}

	public List<Shelf> getHasShelves() {
		if (hasShelves == null) {
			hasShelves = new ArrayList<Shelf>();
        }
		return hasShelves;
	}

	public void setHasShelves(List<Shelf> hasShelves) {
		this.hasShelves = hasShelves;
	}

	public String getTypeOfTopology() {
		return typeOfTopology;
	}
	
	public void setTypeOfTopology(String typeOfTopology) {
		this.typeOfTopology = typeOfTopology;
	}
	
	public String getIdConexoesPotsMsan() {
		return idConexoesPotsMsan;
	}
	
	public void setIdConexoesPotsMsan(String idConexoesPotsMsan) {
		this.idConexoesPotsMsan = idConexoesPotsMsan;
	}
	
	public String getIdMsan() {
		return idMsan;
	}
	
	public void setIdMsan(String idMsan) {
		this.idMsan = idMsan;
	}
	
	public String getLic() {
		return lic;
	}
	
	public void setLic(String lic) {
		this.lic = lic;
	}
	
/*	public Splitter getSplitter() {
		return splitter;
	}

	public void setSplitter(Splitter splitter) {
		this.splitter = splitter;
	}
*/
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BrazilianUrbanPropertyAddress getBrazilianUrbanPropertyAddress() {
		return brazilianUrbanPropertyAddress;
	}

	public void setBrazilianUrbanPropertyAddress(BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress) {
		this.brazilianUrbanPropertyAddress = brazilianUrbanPropertyAddress;
	}

	public String getTypeOfResource() {
		return typeOfResource;
	}

	public void setTypeOfResource(String typeOfResource) {
		this.typeOfResource = typeOfResource;
	}

	public SwitchesAssociated getBRASAssociated() {
		return bRASAssociated;
	}

	public void setBRASAssociated(SwitchesAssociated bRASAssociated) {
		this.bRASAssociated = bRASAssociated;
	}

	public SwitchesAssociated getAgregatorAssociated() {
		return agregatorAssociated;
	}

	public void setAgregatorAssociated(SwitchesAssociated agregatorAssociated) {
		this.agregatorAssociated = agregatorAssociated;
	}

}
