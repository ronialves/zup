package com.tlf.oss.resourceinventory.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.test.AbstractExecutionRules.ExecutionTest;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Allocate;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.AllocateInternal;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Determine;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.DetermineResourceAvailabilityMetallic;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Install;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Release;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Release.Deallocate;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Release.Uninstall;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Reserve;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.RetrieveCustomer;

@RunWith(Suite.class)
@SuiteClasses({
	Install.class,
	Reserve.class,
	Allocate.class,
	AllocateInternal.class,
	Determine.class,
	DetermineResourceAvailabilityMetallic.class,
	RetrieveCustomer.class,
	Release.class,
	Deallocate.class,
	Uninstall.class
})
public class Vivo2ExecutionRulesTest {
	
	@ExecutionTest(version = "1.0", action="install", result="1.0_EXTERNAL_INSTALL_VIVO2")
	public static class Install extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO2");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="determine", result="1.0_DETERMINE_VIVO2")
	public static class Determine extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress = new BrazilianUrbanPropertyAddress();
			brazilianUrbanPropertyAddress.setNetworkOwner("VIVO2");
			
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			
			PlacePhysicalResourceAssoc placePhysical = new PlacePhysicalResourceAssoc();
			PhysicalLink physical = new PhysicalLink();
			physical.setAccessTechnology("GPON");
			placePhysical.setPhysicalLink(physical);
			
			brazilianUrbanPropertyAddress.setPlacePhysicalResourceAssoc(placePhysical);	
			entity.setAddress(brazilianUrbanPropertyAddress);
			
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action = "determine", result = "1.0_DETERMINE_METALLIC_VIVO2")
	public static class DetermineResourceAvailabilityMetallic extends AbstractExecutionRules{

		@Override
		protected ResourceInventoryEntity getEntity() {
			
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			BrazilianUrbanPropertyAddress brazilianUrbanPropertyAddress = new BrazilianUrbanPropertyAddress();
			brazilianUrbanPropertyAddress.setNetworkOwner("VIVO2");
			
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			
			PlacePhysicalResourceAssoc placePhysical = new PlacePhysicalResourceAssoc();
			PhysicalLink physical = new PhysicalLink();
			physical.setAccessTechnology("METALICO");
			placePhysical.setPhysicalLink(physical);
			
			brazilianUrbanPropertyAddress.setPlacePhysicalResourceAssoc(placePhysical);	
			entity.setAddress(brazilianUrbanPropertyAddress);
			
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="reserve", result="1.0_EXTERNAL_RESERVE_VIVO2")
	public static class Reserve extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO2");
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			PhysicalLink physicalLink = new PhysicalLink();
			physicalLink.setAccessTechnology("GPON");
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink );
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc );
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="reserve", result="1.0_RESERVE_METALLIC_VIVO2")
	public static class ReserveMetalico extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO2");
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			PhysicalLink physicalLink = new PhysicalLink();
			physicalLink.setAccessTechnology("METALICO");
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink );
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
			
			List<CustomerFacingService> cfs = new ArrayList<>();
			CustomerFacingService cf = new CustomerFacingService();
			cf.setCategory("BROADBAND");
			cf.setServiceId("CTA-81GQSYRM3-013");
			cfs.add(cf);
			entity.setCustomerFacingService(cfs);
			
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="allocate", result="1.0_EXTERNAL_ALLOCATE_VIVO2")
	public static class Allocate extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO2");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="allocate", result="1.0_INTERNAL_ALLOCATE_VIVO2")
	public static class AllocateInternal extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO2");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_ACCESS_PORT");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "2.0", action="retrieve", result="2.0_RETRIEVE_RESOURCE_INFORMATION_CUSTOMER_VIVO2")
	public static class RetrieveCustomer extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO2");
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="release", result="1.0_EXTERNAL_RELEASE_VIVO2")
	public static class Release extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO2");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO2");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			
			return entity;
		}
		

		@ExecutionTest(version = "1.0", action="deallocate", result="1.0_EXTERNAL_DEALLOCATE_VIVO2")
		public static class Deallocate extends AbstractExecutionRules {
			@Override
			protected ResourceInventoryEntity getEntity() {
				ResourceInventoryEntity entity = new ResourceInventoryEntity();
				ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
				serviceSpecCharDescribes.setValue("VIVO2");
				ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
				serviceDescribedBy.setName("NetworkOwner");
				serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
				ResourceFacingService resourceFacingService = new ResourceFacingService();
				resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
				entity.setResourceFacingService(resourceFacingService);
				entity.setAddress(new BrazilianUrbanPropertyAddress());
				entity.getAddress().setNetworkOwner("VIVO2");
				ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
				resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
				ResourceOrder resourceOrder = new ResourceOrder();
				resourceOrder.setResourceOrderItem(resourceOrderItem);
				entity.setResourceOrder(resourceOrder);
				
				return entity;
			}
		}
		
		@ExecutionTest(version = "1.0", action="uninstall", result="1.0_EXTERNAL_UNINSTALL_VIVO2")
		public static class Uninstall extends AbstractExecutionRules {
			@Override
			protected ResourceInventoryEntity getEntity() {
				ResourceInventoryEntity entity = new ResourceInventoryEntity();
				ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
				serviceSpecCharDescribes.setValue("VIVO2");
				ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
				serviceDescribedBy.setName("NetworkOwner");
				serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
				ResourceFacingService resourceFacingService = new ResourceFacingService();
				resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
				entity.setResourceFacingService(resourceFacingService);
				entity.setAddress(new BrazilianUrbanPropertyAddress());
				entity.getAddress().setNetworkOwner("VIVO2");
				ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
				resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
				ResourceOrder resourceOrder = new ResourceOrder();
				resourceOrder.setResourceOrderItem(resourceOrderItem);
				entity.setResourceOrder(resourceOrder);
				
				return entity;
			}
		}
	}
}
