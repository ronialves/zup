package com.tlf.oss.resourceinventory.tbs.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ 
	AllocateTest.class, 
	FacilityTest.class,
	InstallTest.class,
	DeallocateTest.class,	
	FacilityRetrievalTest.class, 
	CabinetRetrievalControllerTest.class
	})
public class AllTests {

}
