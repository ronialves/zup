package com.tlf.oss.resourceinventory.granite.api.v2_0;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("2.0")
public class RESTConfig extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(FacilityRetrievalServiceV2.class);
		
		return s;
	}
}