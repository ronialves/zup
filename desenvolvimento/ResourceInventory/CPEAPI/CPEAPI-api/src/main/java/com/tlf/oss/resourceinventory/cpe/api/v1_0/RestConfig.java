package com.tlf.oss.resourceinventory.cpe.api.v1_0;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Stateless
@ApplicationPath("1.0")
public class RestConfig extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(AllocateService.class);
		s.add(AllocateStbService.class);
		s.add(DeallocateService.class);
		s.add(DeallocateStbService.class);
		s.add(InstallService.class);
		s.add(InstallStbService.class);
		s.add(UninstallService.class);
		s.add(UninstallStbService.class);
		s.add(UpdateService.class);
		s.add(UpdateStbService.class);
		s.add(RetrieveService.class);
		s.add(CatalogService.class);
		return s;
	}
}
