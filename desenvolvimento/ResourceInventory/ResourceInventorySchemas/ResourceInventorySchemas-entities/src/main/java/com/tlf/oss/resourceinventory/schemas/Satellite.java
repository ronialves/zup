/**
 * 
 */
package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author melissa.d.goncalves
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Satellite", propOrder = { "technology" })
public class Satellite {

	@XmlElement(name = "technology")
	protected List<Technology> technology;
	
	/**
	 * @param technology
	 */
	public Satellite() {
	}


	public List<Technology> getTechnology() {
        if (technology == null) {
        	technology = new ArrayList<Technology>();
        }
        return this.technology;
    }

	public void setTechnology(List<Technology> technologies) {
		this.technology = technologies;
	}

}
