package com.tlf.oss.resourceinventory.granite.api;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
@RunWith(Arquillian.class)
public class CancelOfferTest {

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive a = ShrinkWrap.create(WebArchive.class,"ResourceInventoryGraniteAPI-api.war")
				.addPackages(true,"com.tlf.oss.resourceinventory.schemas")
				.addPackages(true,"com.tlf.oss.resourceinventory.granite.api.v1_0")
				.addPackages(true,"com.tlf.oss.resourceinventory.granite")
				.addPackages(true,"com.tlf.oss.common")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource( "arquillian.xml" );

		System.out.println(a.toString(true));
		return a;

	}

	ResourceInventoryEntity entity;

	@Before
	public void before(){

		entity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11047");
		address.setTelephonicArea("DC");

		Cabinet cabinet = new Cabinet();
		//cabinet.setName("EQQ");

		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("METALICO");
		physicalLink.setVoiceProtocol("SIP");

		physicalResourceAssoc.setPhysicalLink(physicalLink);
		physicalResourceAssoc.setCabinet(cabinet);

		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);

		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setCategory("BROADBAND");

		ServiceSpecCharDescribes customerServiceSpecCharDescribes = new ServiceSpecCharDescribes();
		customerServiceSpecCharDescribes.setValue("1024");

		List<ServiceSpecCharDescribes> customerServiceSpecCharDescribesList = new ArrayList<>();
		customerServiceSpecCharDescribesList.add(customerServiceSpecCharDescribes);

		ServiceDescribedBy customerServiceDescribedBy = new ServiceDescribedBy();
		customerServiceDescribedBy.setName("Downstream");
		customerServiceDescribedBy.setServiceSpecCharDescribes(customerServiceSpecCharDescribesList);

		List<ServiceDescribedBy> customerServiceDescribedByList = new ArrayList<>();
		customerServiceDescribedByList.add(customerServiceDescribedBy);

		customerFacingService.setServiceDescribedBy(customerServiceDescribedByList);

		ResourceFacingService resourceFacingService = new ResourceFacingService();

		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("110471234567890");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<>();
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);

		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("NetworkOwnerID");
		serviceDescribedBy.setServiceSpecCharDescribes(serviceSpecCharDescribesList);

		ServiceSpecCharDescribes serviceSpecCharDescribesNrc = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesNrc.setValue("C066532635");

		List<ServiceSpecCharDescribes> serviceSpecCharDescribesNrcList = new ArrayList<>();
		serviceSpecCharDescribesNrcList.add(serviceSpecCharDescribesNrc);

		ServiceDescribedBy serviceDescribedByNrc = new ServiceDescribedBy();
		serviceDescribedByNrc.setName("NRC");
		serviceDescribedByNrc.setServiceSpecCharDescribes(serviceSpecCharDescribesNrcList);

		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<>();
		serviceDescribedByList.add(serviceDescribedBy);
		serviceDescribedByList.add(serviceDescribedByNrc);

		resourceFacingService.setServiceDescribedBy(serviceDescribedByList);

		entity.setAddress(address);
		entity.setCabinet(cabinet);
		entity.setResourceFacingService(resourceFacingService);
		entity.setCustomerFacingService(new ArrayList<>());
		entity.getCustomerFacingService().add(customerFacingService);
		entity.setCustomerOrder(new CustomerOrder());
		entity.getCustomerOrder().setCustomerOrderType("Venda de Oferta");

	}


	@Test
	@RunAsClient
	@InSequence(2)
	public void cancelOs(@ArquillianResteasyResource("1.0/deallocate") final WebTarget webTarget){

		webTarget.queryParam("something", "With WebTarget Injection")	
		.request( MediaType.APPLICATION_JSON )
		.post( Entity.json( entity));

	}

	@Test
	@RunAsClient
	@InSequence(1)
	public void cancelReserve(@ArquillianResteasyResource("1.0/cancelReserved") final WebTarget webTarget){

		webTarget.queryParam("something", "With WebTarget Injection")	
		.request( MediaType.APPLICATION_JSON )
		.post( Entity.json( entity));

	}

	@Test
	@RunAsClient
	@InSequence(3)
	public void unistall(@ArquillianResteasyResource("1.0/uninstall") final WebTarget webTarget){

		webTarget.queryParam("something", "With WebTarget Injection")	
		.request( MediaType.APPLICATION_JSON )
		.post( Entity.json( entity));

	}
	
	@Test
	@RunAsClient
	@InSequence(5)
	public void cancelOsMsan(@ArquillianResteasyResource("1.0/deallocate") final WebTarget webTarget){

		entity.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).setValue("110471234567891");

		webTarget.queryParam("something", "With WebTarget Injection")	
		.request( MediaType.APPLICATION_JSON )
		.post( Entity.json( entity));

	}

	@Test
	@RunAsClient
	@InSequence(4)
	public void cancelReserveMsan(@ArquillianResteasyResource("1.0/cancelReserved") final WebTarget webTarget){

		entity.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).setValue("110471234567891");

		webTarget.queryParam("something", "With WebTarget Injection")	
		.request( MediaType.APPLICATION_JSON )
		.post( Entity.json( entity));

	}

	@Test
	@RunAsClient
	@InSequence(6)
	public void unistallMsan(@ArquillianResteasyResource("1.0/uninstall") final WebTarget webTarget){

		entity.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).setValue("110471234567891");

		webTarget.queryParam("something", "With WebTarget Injection")	
		.request( MediaType.APPLICATION_JSON )
		.post( Entity.json( entity));

	}

}
