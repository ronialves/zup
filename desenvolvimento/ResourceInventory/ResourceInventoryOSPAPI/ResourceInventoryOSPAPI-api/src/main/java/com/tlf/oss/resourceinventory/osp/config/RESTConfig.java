package com.tlf.oss.resourceinventory.osp.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.tlf.oss.resourceinventory.osp.api.v1_0.Allocate;
import com.tlf.oss.resourceinventory.osp.api.v1_0.AvailabilityRetrieval;
import com.tlf.oss.resourceinventory.osp.api.v1_0.CancelReserved;
import com.tlf.oss.resourceinventory.osp.api.v1_0.Deallocate;
import com.tlf.oss.resourceinventory.osp.api.v1_0.FacilityRetrieval;
import com.tlf.oss.resourceinventory.osp.api.v1_0.Install;
import com.tlf.oss.resourceinventory.osp.api.v1_0.Reserve;
import com.tlf.oss.resourceinventory.osp.api.v1_0.Uninstall;

/**
 * 
 * @author ptessuto - Phillip
 * @since 2017
 */
@ApplicationPath("1.0")
public class RESTConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> s = new HashSet<>();

		s.add(CancelReserved.class);
		s.add(FacilityRetrieval.class);
		s.add(Reserve.class);
		s.add(Allocate.class);
		s.add(Deallocate.class);
		s.add(Install.class);
		s.add(AvailabilityRetrieval.class);
		s.add(Uninstall.class);

		return s;
	}
}