package com.tlf.oss.resourceinventory.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.test.AbstractExecutionRules.ExecutionTest;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.Allocate;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.AllocateCPE1;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.AllocateCPE2;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.AllocateCPESTB;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.AllocateExternal;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.AllocateInternal;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.Deallocate;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.DeallocateCPEACCESS;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.DeallocateCPESTB;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.DeallocateCPEVOIP;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.DeallocateExternal;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.DeallocateInternal;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.DetermineGponOfferEdition;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.ExternalInstall;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.Install;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.InstallCPEACCESS;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.InstallCPESTB;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.InstallCPEVOIP;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.InternalInstall;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.Release;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.Reserve;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.RetrieveAddress;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.RetrieveAddress2;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.RetrieveCPE;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.RetrieveCustomerV2;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.Uninstall;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.UninstallCPE;
import com.tlf.oss.resourceinventory.test.Vivo1ExecutionRulesTest.UpdateCPE;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.Determine;
import com.tlf.oss.resourceinventory.test.Vivo2ExecutionRulesTest.RetrieveCustomer;

@RunWith(Suite.class)
@SuiteClasses({
	Determine.class,	
	DetermineGponOfferEdition.class,
	Reserve.class,
	Release.class,
	Allocate.class,	
	Deallocate.class,
	DeallocateCPEACCESS.class,
	DeallocateCPEVOIP.class,
	DeallocateCPESTB.class,
	Install.class,
	InstallCPEACCESS.class,
	InstallCPEVOIP.class,
	InstallCPESTB.class,
	Uninstall.class,
	UninstallCPE.class,
	RetrieveCustomer.class,
	RetrieveAddress.class,
	RetrieveCustomerV2.class,
	RetrieveAddress2.class,
	RetrieveCPE.class,
	ExternalInstall.class,
	InternalInstall.class,
	AllocateInternal.class,
	AllocateExternal.class,
	AllocateCPE1.class,
	AllocateCPE2.class,
	AllocateCPESTB.class,
	DeallocateInternal.class,
	DeallocateExternal.class,
	UpdateCPE.class
})
public class Vivo1ExecutionRulesTest {

	@ExecutionTest(version = "1.0", action = "determine", result = "1.0_DETERMINE_VIVO1")
	public static class Determine extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			PhysicalLink physicalLink = new PhysicalLink();
			physicalLink.setAccessTechnology("METALICO");
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="determine", result="1.0_DETERMINE_GPON_VIVO1")
	public static class DetermineGpon extends AbstractExecutionRules {

		@Override 
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			PhysicalLink physicalLink = new PhysicalLink();
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
			
			physicalLink.setAccessTechnology("GPON"); 
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1"); 
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
			return entity; 
		}
	}

	@ExecutionTest(version = "1.0", action = "reserve", result = "1.0_RESERVE_VIVO1")
	public static class Reserve extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "reserve", result = "1.0_RESERVE_VIVO1")
	public static class ReserveCustomerOrderTypeVazio extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.setCustomerOrder(new CustomerOrder());
			entity.getCustomerOrder().setCustomerOrderType("");
			entity.getAddress().setNetworkOwner("VIVO1");

			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="determine", result="1.0_DETERMINE_OFFER_EDITION_GPON_VIVO1")
	public static class DetermineGponOfferEdition extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			PhysicalLink physicalLink = new PhysicalLink();
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
			List<PhysicalLink> physicalLinks = new ArrayList<>();
			physicalLink.setAccessTechnology("GPON");
			physicalLinks.add(physicalLink);
			entity.setPhysicalLinks(physicalLinks);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
			entity.setResourceFacingService(new ResourceFacingService());
			entity.getAddress().setNetworkOwner("VIVO1");
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "reserve", result = "1.0_RESERVE_OFFER_EDITION_VIVO1")
	public static class ReserveOfferEdition extends AbstractExecutionRules {
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.setCustomerOrder(new CustomerOrder());
			entity.getCustomerOrder().setCustomerOrderType("Edição de Oferta");
			entity.getAddress().setNetworkOwner("VIVO1");
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "release", result = "1.0_RELEASE_VIVO1")
	public static class Release extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			return entity;
		}
	}
	
		
		
	

	@ExecutionTest(version = "1.0", action = "allocate", result = "1.0_ALLOCATE_VIVO1")
	public static class Allocate extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			PlacePhysicalResourceAssoc placePhysical = new PlacePhysicalResourceAssoc();
			PhysicalLink physical = new PhysicalLink();
			physical.setAccessTechnology("METALICO");
			placePhysical.setPhysicalLink(physical);
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysical);
			entity.setCustomerOrder(new CustomerOrder());
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "allocate", result = "1.0_ALLOCATE_OFFER_EDITION_VIVO1")
	public static class AllocateOfferEdition extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setCustomerOrder(new CustomerOrder());
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getCustomerOrder().setCustomerOrderType("Edição de Oferta");
			entity.getAddress().setNetworkOwner("VIVO1");
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "deallocate", result = "1.0_DEALLOCATE_VIVO1")
	public static class Deallocate extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			PhysicalLink physicalLink = new PhysicalLink();
			physicalLink.setAccessTechnology("METALICO");
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink );
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc );
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			return entity;
		}
	}
	
	
	@ExecutionTest(version = "1.0", action = "deallocate", result = "1.0_CPE_DEALLOCATE")
	public static class DeallocateCPEACCESS extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action = "deallocate", result = "1.0_CPE_DEALLOCATE")
	public static class DeallocateCPEVOIP extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_VOIP");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action = "deallocate", result = "1.0_CPE_DEALLOCATE_STB")
	public static class DeallocateCPESTB extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_STB");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "install", result = "1.0_INSTALL_VIVO1")
	public static class Install extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");

			PhysicalLink physicalLink = new PhysicalLink();
			physicalLink.setAccessTechnology("METALICO");
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);

			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "install", result = "1.0_CPE_INSTALL")
	public static class InstallCPEACCESS extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "install", result = "1.0_CPE_INSTALL")
	public static class InstallCPEVOIP extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_VOIP");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "install", result = "1.0_CPE_INSTALL_STB")
	public static class InstallCPESTB extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_STB");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "install", result = "1.0_INSTALL_OFFER_EDITION_VIVO1")
	public static class InstallOfferEdition extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			entity.setCustomerOrder(new CustomerOrder());
			entity.getCustomerOrder().setCustomerOrderType("Edição de Oferta");
			return entity;
		}
	}


	@ExecutionTest(version = "1.0", action = "uninstall", result = "1.0_UNINSTALL_VIVO1")
	public static class Uninstall extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "uninstall", result = "1.0_CPE_UNINSTALL")
	public static class UninstallCPE extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			
			entity.setResourceFacingService(resourceFacingService);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "retrieve", result = "1.0_RETRIEVE_RESOURCE_INFORMATION_ADDRESS_VIVO1")
	public static class RetrieveAddress extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			return entity;
		}
	}

	@ExecutionTest(version = "2.0", action="retrieve", result="2.0_RETRIEVE_RESOURCE_INFORMATION_CUSTOMER_VIVO1")
	public static class RetrieveCustomerV2 extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			resourceFacingService.setServiceId("1100012345678");
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			return entity;
		}
	}

	@ExecutionTest(version = "2.0", action="retrieve", result="2.0_RETRIEVE_RESOURCE_INFORMATION_ADDRESS_VIVO1")
	public static class RetrieveAddress2 extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			return entity;
		}
	}

	@ExecutionTest(version = "2.0", action="retrieve", result="2.0_RETRIEVE_CPE")
	public static class RetrieveCPE extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("CPE");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action = "release", result = "1.0_RELEASE_OFFER_EDITION_VIVO1")
	public static class ReleaseOfferEdition extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			entity.setCustomerOrder(new CustomerOrder());
			entity.getCustomerOrder().setCustomerOrderType("Edição de Oferta");
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="install", result="1.0_EXTERNAL_INSTALL_VIVO1")
	public static class ExternalInstall extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");

			ResourceOrder resourceOrder = new ResourceOrder();
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);

			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="install", result="1.0_INTERNAL_INSTALL_VIVO1")
	public static class InternalInstall extends AbstractExecutionRules {

		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");

			ResourceOrder resourceOrder = new ResourceOrder();
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_ACCESS_PORT");
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);

			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="allocate", result="1.0_INTERNAL_ALLOCATE_VIVO1")
	public static class AllocateInternal extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_ACCESS_PORT");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="allocate", result="1.0_EXTERNAL_ALLOCATE_VIVO1")
	public static class AllocateExternal extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="allocate", result="1.0_CPE_ALLOCATE")
	public static class AllocateCPE1 extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="allocate", result="1.0_CPE_ALLOCATE")
	public static class AllocateCPE2 extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_VOIP");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="allocate", result="1.0_CPE_ALLOCATE_STB")
	public static class AllocateCPESTB extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_STB");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="deallocate", result="1.0_EXTERNAL_DEALLOCATE_VIVO1")
	public static class DeallocateExternal extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_PHYSICAL_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);

			PhysicalLink physicalLink = new PhysicalLink();
                        physicalLink.setAccessTechnology("GPON");
                        PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
                        placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
                        entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);

			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="deallocate", result="1.0_INTERNAL_DEALLOCATE_VIVO1")
	public static class DeallocateInternal extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("TSS_FIBER_ACCESS_PORT");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);

			PhysicalLink physicalLink = new PhysicalLink();
                        physicalLink.setAccessTechnology("GPON");
                        PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
                        placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
                        entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);

			return entity;
		}
	}

	@ExecutionTest(version = "1.0", action="update", result="1.0_CPE_UPDATE")
	public static class UpdateCPE extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			entity.getAddress().setNetworkOwner("VIVO1");
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			
			PhysicalLink physicalLink = new PhysicalLink();
			physicalLink.setAccessTechnology("GPON");
			PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
			placePhysicalResourceAssoc.setPhysicalLink(physicalLink);
			entity.getAddress().setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
			
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="uninstall", result="1.0_CPE_UNINSTALL")
	public static class UninstallCPE1 extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_ACCESS");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="uninstall", result="1.0_CPE_UNINSTALL")
	public static class UninstallCPE2 extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_VOIP");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
	
	@ExecutionTest(version = "1.0", action="uninstall", result="1.0_CPE_UNINSTALL")
	public static class UninstallCPE3 extends AbstractExecutionRules {
		
		@Override
		protected ResourceInventoryEntity getEntity() {
			ResourceInventoryEntity entity = new ResourceInventoryEntity();
			ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
			serviceSpecCharDescribes.setValue("VIVO1");
			ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
			serviceDescribedBy.setName("NetworkOwner");
			serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);
			ResourceFacingService resourceFacingService = new ResourceFacingService();
			resourceFacingService.getServiceDescribedBy().add(serviceDescribedBy);
			entity.setResourceFacingService(resourceFacingService);
			entity.setAddress(new BrazilianUrbanPropertyAddress());
			ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
			resourceOrderItem.setName("R_CPE_STB");
			ResourceOrder resourceOrder = new ResourceOrder();
			resourceOrder.setResourceOrderItem(resourceOrderItem);
			entity.setResourceOrder(resourceOrder);
			return entity;
		}
	}
}