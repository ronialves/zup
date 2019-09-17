package com.tlf.oss.resourceinventory.terus.api.v1_0;

import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Stateless
@ApplicationPath("1.0")
public class RESTConfig extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(ReserveService.class);
		s.add(CancelReservedService.class);
		s.add(DeallocateService.class);
		s.add(UninstallService.class);
		return s;
	}
}
