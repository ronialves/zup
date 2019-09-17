package com.tlf.oss.resourceinventory.sagre.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AllocateExternalResourceTest.class, 
	DetermineAvailabilityTest.class,
	InstallResourceTest.class,
	ReserveTest.class,
	RetrieveFacilityResourceTest.class,
	ReleaseResourceTest.class,
	DeallocateResourceTest.class,
	UninstallResourceTest.class})
public class AllTests {

}
