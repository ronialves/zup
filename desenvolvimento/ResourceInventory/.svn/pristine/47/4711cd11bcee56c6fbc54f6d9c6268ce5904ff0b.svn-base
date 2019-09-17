package com.tlf.oss.resourceinventory.scqla.api.v1_0;

import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * 
 * @author lgomesf - Lucas
 * @since 2017
 */
@Stateless
@ApplicationPath("1.0")
public class RESTConfig extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        
        s.add(AvailabilityRetrievalService.class);
        
        return s;
    }
}
