package com.tlf.oss.resourceinventory.orchestration.core.util;

import org.junit.Assert;
import org.junit.Test;

import com.tlf.oss.resourceinventory.orchestration.core.PathBuilder;

public class PathBuilderTest {

	@Test
	public void isValidPath() {
		String protocol = "http://";
		String node = "127.0.0.1";
		String port = "7001";
		String application = "app-test";
		String version = "1.0";
		String path = "path-test";
		
		String strBuilder = new StringBuilder(protocol)
			.append(node)
			.append(":")
			.append(port)
			.append("/")
			.append(application)
			.append(version == null || "".equals(version) ? "" : ("/" + version))
			.append("/")
			.append(path)
			.toString();
		
		String pathBuilder = new PathBuilder()
			.setProtocol(protocol)
			.setNode(node)
			.setPort(port)
			.setApplication(application)
			.setVersion(version)
			.setPath(path)
			.toString();
		
		Assert.assertEquals(pathBuilder, strBuilder);
	}
}
