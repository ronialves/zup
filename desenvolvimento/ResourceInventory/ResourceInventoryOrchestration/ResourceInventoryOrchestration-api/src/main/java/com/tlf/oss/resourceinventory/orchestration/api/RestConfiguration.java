package com.tlf.oss.resourceinventory.orchestration.api;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
public class RestConfiguration extends Application {
	
	public Set<Class<?>> getClasses() {
        return getRestClasses();
    }
    
    private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		
		resources.add(OrchestrationService.class);
		return resources;    
    }
}