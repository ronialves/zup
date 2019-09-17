package com.tlf.oss.resourceinventory.tbs.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.CustomerOrder;
import com.tlf.oss.resourceinventory.schemas.CustomerOrderComprisedOf;
import com.tlf.oss.resourceinventory.schemas.InvolvesCustomer;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ProductBundle;
import com.tlf.oss.resourceinventory.schemas.ProductLocatedVia;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.entity.AllocateEntity;
import com.tlf.oss.resourceinventory.tbs.repository.AllocateRepository;
import com.tlf.oss.resourceinventory.tbs.to.ResultTo;

/**
 * BEATRIXTWO-26 | DEMOSS-2171
 * 
 * @project Beatrix Fase 2
 * @author jannayna.c.araujo
 * @since 201709
 */

@RunWith(MockitoJUnitRunner.class)
public class AllocateTest {

	@InjectMocks
	private AllocateController allocateController;

	@Mock
	private AllocateRepository allocateRepository;

	@Mock
	private OSSLogger logger;

	private ResourceInventoryEntity resourceInventoryEntity;
	private AllocateEntity response;

	@Before
	public void before() {

		resourceInventoryEntity = new ResourceInventoryEntity();
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setPurchaseOrderNumber("8-A4336E869B-1");
		InvolvesCustomer involvesCustomer = new InvolvesCustomer();
		involvesCustomer.setId("123456");
		customerOrder.setInvolvesCustomer(involvesCustomer);
		
		List<CustomerOrderComprisedOf> list = new ArrayList<CustomerOrderComprisedOf>();
		CustomerOrderComprisedOf customerOrderComprisedOf = new CustomerOrderComprisedOf();
		ProductBundle productBundle = new ProductBundle();
		ProductLocatedVia productLocatedVia = new ProductLocatedVia();
		productLocatedVia.setId("123456");
		productBundle.setProductLocatedVia(productLocatedVia);
		customerOrderComprisedOf.setProductBundle(productBundle);
		list.add(customerOrderComprisedOf);	
		resourceInventoryEntity.setCustomerOrder(customerOrder);
		
		List<ServiceSpecCharDescribes> serviceSpecCharDescribesList = new ArrayList<ServiceSpecCharDescribes>();
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();
		serviceSpecCharDescribes.setValue("4096");
		serviceSpecCharDescribesList.add(serviceSpecCharDescribes);
		
		List<ServiceDescribedBy> serviceDescribedByList = new ArrayList<ServiceDescribedBy>();
		ServiceDescribedBy serviceDescribedByRpon = new ServiceDescribedBy();
		serviceDescribedByRpon.setName("RPON");
		serviceDescribedByRpon.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		ServiceDescribedBy serviceDescribedByDownstream = new ServiceDescribedBy();
		serviceDescribedByDownstream.setName("Downstream");
		serviceDescribedByDownstream.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		ServiceDescribedBy serviceDescribedByUpstream = new ServiceDescribedBy();
		serviceDescribedByUpstream.setName("Upstream");
		serviceDescribedByUpstream.setServiceSpecCharDescribes(serviceSpecCharDescribesList);
		serviceDescribedByList.add(serviceDescribedByRpon);
		serviceDescribedByList.add(serviceDescribedByDownstream);
		serviceDescribedByList.add(serviceDescribedByUpstream);
		
		CustomerFacingService customerFacingService = new CustomerFacingService();
		customerFacingService.setServiceDescribedBy(serviceDescribedByList);
		List<CustomerFacingService> customerFacingServiceList = new ArrayList<CustomerFacingService>();
		customerFacingServiceList.add(customerFacingService);
		
		resourceInventoryEntity.setCustomerFacingService(customerFacingServiceList);
		
		resourceInventoryEntity.setPhysicalResourceSummary("XXX XXXX XXX XXXX");
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("BRU-02282072-069");
		resourceInventoryEntity.setResourceFacingService(resourceFacingService);
		
		
		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		PlacePhysicalResourceAssoc placePhysicalResourceAssoc = new PlacePhysicalResourceAssoc();
		
		Cabinet cabinet = new Cabinet();
		SwitchesAssociated switchesAssociated = new SwitchesAssociated();
		switchesAssociated.setName("SPSPO_JUS03");
		cabinet.setSwitchesAssociated(switchesAssociated);
		
		placePhysicalResourceAssoc.setCabinet(cabinet);
		address.setPlacePhysicalResourceAssoc(placePhysicalResourceAssoc);
		
		resourceInventoryEntity.setAddress(address);
		
		response = new AllocateEntity();
		response.setDocumentNumber(123456);
		ResultTo result = new ResultTo();
		result.setCode("0");
		response.setResult(result);
		response.setReturnCode(0);
	}

	@Test
	public void testDoExecution() throws OSSBusinessException {
		when(allocateRepository.getAllocate((anyObject()))).thenReturn(response);
		ResourceInventoryEntity out = allocateController.getAllocate(resourceInventoryEntity);

		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(response.getResult().getCode()));
	}

	@Test
	public void testDoExecutionOSSBusinessException() {
		OSSBusinessException exception = null;

		try {
			resourceInventoryEntity.setCustomerOrder(null);;
			allocateController.getAllocate(resourceInventoryEntity);

		} catch (Exception e) {
			exception = new OSSBusinessException("Code: 0", "RI-TBS", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);
	}

}
