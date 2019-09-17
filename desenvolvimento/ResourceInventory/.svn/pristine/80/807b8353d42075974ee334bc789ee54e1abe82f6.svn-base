package com.tlf.oss.resourceinventory.sagre.api.v1_0;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Stateless
@ApplicationPath("1.0")
public class RestConfig extends Application{
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(DetermineAvailabilityService.class);
		s.add(ReserveService.class);
		s.add(AllocateService.class);
		s.add(InstallService.class);
		s.add(FacilityRetrievalService.class);	
		s.add(DeallocateService.class);
		s.add(ReleaseService.class);
		s.add(UninstallService.class);
		return s;
	}
}
