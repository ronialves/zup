package com.tlf.oss.resourceinventory.schemas;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceSpecCharDescribes", propOrder = { "id", "value", "valueType"})
public class ServiceSpecCharDescribes {

	protected String id;
	@NotNull
	@Size(min=1)
    protected String value;
    protected String valueType;
    
    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String value) {
        this.valueType = value;
    }
}
