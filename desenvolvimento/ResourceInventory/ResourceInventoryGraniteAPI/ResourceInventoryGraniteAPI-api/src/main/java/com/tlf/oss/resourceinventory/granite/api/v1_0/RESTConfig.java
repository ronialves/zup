package com.tlf.oss.resourceinventory.granite.api.v1_0;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("1.0")
public class RESTConfig extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(AvailabilityRetrievalService.class);
		s.add(AccessRetrievalService.class);
		s.add(FacilityRetrievalService.class);
		s.add(ReserveService.class);
		s.add(CancelReservedService.class);
		s.add(InstallService.class);
		s.add(AllocateService.class);
		s.add(DeallocateService.class);
		s.add(UninstallService.class);
		s.add(ReserveRetrieval.class);
		
		return s;
	}
}