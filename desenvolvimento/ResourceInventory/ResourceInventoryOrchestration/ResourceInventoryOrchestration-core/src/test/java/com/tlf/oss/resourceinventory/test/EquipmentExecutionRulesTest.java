package com.tlf.oss.resourceinventory.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tlf.oss.resourceinventory.schemas.PhysicalResource;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.test.AbstractExecutionRules.ExecutionTest;
import com.tlf.oss.resourceinventory.test.EquipmentExecutionRulesTest.Retrieve;

@RunWith(Suite.class)
@SuiteClasses({
	Retrieve.class
})
public class EquipmentExecutionRulesTest {
	
	@ExecutionTest(version = "1.0", action="equipment", result="1.0_RETRIEVE_CPE")
	public static class Retrieve extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.setServiceId("110001234567890");

			List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
			serviceDescribedByList.add(new ServiceDescribedBy());
			serviceDescribedByList.get(0).setName("OPERATION");
			
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("RETRIEVE");
			serviceDescribedByList.get(0).getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			
			PhysicalResource networkAggregator = new PhysicalResource();
			networkAggregator.setTypeOfResource("CPE");
			
			resourceFacingService.setServiceDescribedBy(serviceDescribedByList);
			
			entity.setResourceFacingService(resourceFacingService);
			entity.setNetworkAggregator(networkAggregator);
			
			return entity;
		}
	}
}
