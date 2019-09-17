
package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalPort", propOrder = { "id", "fiberId", "logicalResourceAssociation" })
public class PhysicalPort {

    protected String id;//@maintained
	@Deprecated //depreciado em 20180430. A ser removido na proxima release. Nao utilizar ou evoluir
    protected String fiberId;
    
    protected LogicalResourceAssociation logicalResourceAssociation;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

	public String getFiberId() {
		return fiberId;
	}

	public void setFiberId(String fiberId) {
		this.fiberId = fiberId;
	}

	public LogicalResourceAssociation getLogicalResourceAssociation() {
		return logicalResourceAssociation;
	}

	public void setLogicalResourceAssociation(LogicalResourceAssociation logicalResourceAssociation) {
		this.logicalResourceAssociation = logicalResourceAssociation;
	}

}
