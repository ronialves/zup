package com.tlf.oss.resourceinventory.tbs.api.faultmanagement.v1_0;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("faultmanagement/1.0")
public class RESTConfig extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
			s.add(EquipmentRetrievalService.class);
			s.add(CabinetRetrievalService.class);
		return s;
	}
}