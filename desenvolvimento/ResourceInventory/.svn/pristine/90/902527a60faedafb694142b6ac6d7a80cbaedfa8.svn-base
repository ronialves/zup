package com.tlf.oss.resourceinventory.orchestration.core.entity;

import java.util.List;

public class ResourceJson {

	private String name;
	private String version;
	private List<Action> actions;
	private String networkOwner;

	public ResourceJson() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getNetworkOwner() {
		return networkOwner;
	}

	public void setNetworkOwner(String networkOwner) {
		this.networkOwner = networkOwner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((networkOwner == null) ? 0 : networkOwner.hashCode());
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
		ResourceJson other = (ResourceJson) obj;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (networkOwner == null) {
			if (other.networkOwner != null)
				return false;
		} else if (!networkOwner.equals(other.networkOwner))
			return false;
		return true;
	}

}