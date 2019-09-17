package com.tlf.oss.resourceinventory.repository.api.V1_0;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("1.0")
public class RESTConfig  extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        
	s.add(CustomerService.class);
        s.add(CustomerAuditService.class);
        s.add(OrchestrationAuditService.class);        
        return s;
    }
}
