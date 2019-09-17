/**
 * 
 */
package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author melissa.d.goncalves
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Technology", propOrder = { "name", "conditionalAccessSystem" })
public class Technology {
	
	protected String name;
	protected String conditionalAccessSystem;
		
	public Technology() {
		
	}
	
	/**
	 * @param name
	 * @param conditionalAccessSystem
	 */
	public Technology(String name, String conditionalAccessSystem) {
		this.name = name;
		this.conditionalAccessSystem = conditionalAccessSystem;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConditionalAccessSystem() {
		return conditionalAccessSystem;
	}

	public void setConditionalAccessSystem(String conditionalAccessSystem) {
		this.conditionalAccessSystem = conditionalAccessSystem;
	}

	
}
