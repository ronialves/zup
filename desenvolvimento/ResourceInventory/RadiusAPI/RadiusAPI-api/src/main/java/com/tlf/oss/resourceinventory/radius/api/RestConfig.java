package com.tlf.oss.resourceinventory.radius.api;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.tlf.oss.resourceinventory.radius.api.v1_0.AllocateService;
import com.tlf.oss.resourceinventory.radius.api.v1_0.DeallocateService;
import com.tlf.oss.resourceinventory.radius.api.v1_0.RetrieveService;



/**
 * REC3635-1110 | REC3635-2042
 * 
 * @project Fusion
 * @author 80629552
 * @since 20190325
 */
@Stateless
@ApplicationPath("")
public class RestConfig extends Application{
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(AllocateService.class);
		s.add(DeallocateService.class);
		s.add(RetrieveService.class);
		return s;
	}

}
