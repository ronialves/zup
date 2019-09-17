
package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalResource", propOrder = { "name","value", "typeOfResource", "networkRouteAssociation" })
public class LogicalResource {

	protected String name; //@new
	protected String value; //@new
	protected String typeOfResource; //@new
	@Deprecated //deprecated em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
    protected NetworkRouteAssociation networkRouteAssociation;

    public NetworkRouteAssociation getNetworkRouteAssociation() {
        return networkRouteAssociation;
    }

    public void setNetworkRouteAssociation(NetworkRouteAssociation value) {
        this.networkRouteAssociation = value;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTypeOfResource() {
		return typeOfResource;
	}

	public void setTypeOfResource(String typeOfResource) {
		this.typeOfResource = typeOfResource;
	}

}
