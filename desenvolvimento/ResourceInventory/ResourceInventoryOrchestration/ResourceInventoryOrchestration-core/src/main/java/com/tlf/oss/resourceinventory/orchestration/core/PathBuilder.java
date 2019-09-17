package com.tlf.oss.resourceinventory.orchestration.core;

public class PathBuilder {
	
	private static final String BAR = "/";

	private String protocol;
	private String node;
	private String port;
	private String application;
	private String version;
	private String path;
	
	public PathBuilder setProtocol(String protocol) {
		this.protocol = protocol;
		return this;
	}
	
	public PathBuilder setNode(String node) {
		this.node = node;
		return this;
	}

	public PathBuilder setPort(String port) {
		this.port = port;
		return this;
	}

	public PathBuilder setApplication(String application) {
		this.application = application;
		return this;
	}
	
	public PathBuilder setVersion(String version) {
		this.version = (version == null || "".equals(version) ? "" : (BAR + version)); 
		return this;
	}
	
	public PathBuilder setPath(String path) {
		this.path = path;
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder(protocol)
			.append(node)
			.append(":")
			.append(port)
			.append(BAR)
			.append(application)
			.append(version)
			.append(BAR)
			.append(path);
		
		return strBuilder.toString();
	}
	
}
