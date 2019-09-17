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
@XmlType(name = "ComplementSummary", propOrder = { "complement"})
public class ComplementSummary {

	@XmlElement(name="complement")
	protected List<Complement> complement;
	
	public List<Complement> getComplement() {
        if (complement == null) {
            complement = new ArrayList<Complement>();
        }
        return this.complement;
    }

	public void setComplement(List<Complement> complement) {
		this.complement = complement;
	}
	
}