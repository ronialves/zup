package com.tlf.oss.resourceinventory.orchestration.core.entity;

public class ResourceDoUndo {

	private String path;
	private String http_verb;
	private String subPath;
	private String pathParam;
	private String pathParamValue;
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getHttp_verb() {
		return http_verb;
	}
	
	public void setHttp_verb(String http_verb) {
		this.http_verb = http_verb;
	}
	
	public String getSubPath() {
		return subPath;
	}

	public void setSubPath(String subPath) {
		this.subPath = subPath;
	}

	public String getPathParam() {
		return pathParam;
	}

	public void setPathParam(String pathParam) {
		this.pathParam = pathParam;
	}

	public String getPathParamValue() {
		return pathParamValue;
	}

	public void setPathParamValue(String pathParamValue) {
		this.pathParamValue = pathParamValue;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((http_verb == null) ? 0 : http_verb.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		ResourceDoUndo other = (ResourceDoUndo) obj;
		if (http_verb == null) {
			if (other.http_verb != null)
				return false;
		} else if (!http_verb.equals(other.http_verb))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	
	
}
