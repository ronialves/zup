package com.tlf.oss.resourceinventory.orchestration.core.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.tlf.oss.common.xml.XMLUtil;

@XmlRootElement
public class Action {

	private String name;
	private String mode;
	private String className = "com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity";
	private List<Execution> execution;

	public Action() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Execution> getExecution() {
		return execution;
	}

	public void setExecution(List<Execution> execution) {
		this.execution = execution;
	}

	@Override
	public String toString() {
		return XMLUtil.getXMLValue(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((execution == null) ? 0 : execution.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Action other = (Action) obj;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		
		if (mode == null) {
			if (other.mode != null)
				return false;
		} else if (!mode.equals(other.mode))
			return false;
		
		if (execution == null) {
			if (other.execution != null)
				return false;
		} else if (!execution.equals(other.execution))
			return false;
		
		
		return true;
	}
}
