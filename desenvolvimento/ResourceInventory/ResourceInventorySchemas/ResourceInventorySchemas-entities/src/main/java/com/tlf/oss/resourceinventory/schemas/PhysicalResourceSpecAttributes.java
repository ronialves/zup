
package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalResourceSpecAttributes", propOrder = {"vendor", "model"})
public class PhysicalResourceSpecAttributes {

    protected String vendor;
    protected String model;

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String value) {
        this.vendor = value;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String value) {
        this.model = value;
    }
}
