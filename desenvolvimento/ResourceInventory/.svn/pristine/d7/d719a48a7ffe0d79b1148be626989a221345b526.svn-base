
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
@XmlType(name = "LogicalResourceAssociation", propOrder = { "logicalResource" })
public class LogicalResourceAssociation {

	@XmlElement(name="logicalResource")
    protected List<LogicalResource> logicalResource;//@maintained

    public List<LogicalResource> getLogicalResource() {
        if (logicalResource == null) {
            logicalResource = new ArrayList<LogicalResource>();
        }
        return this.logicalResource;
    }
}
