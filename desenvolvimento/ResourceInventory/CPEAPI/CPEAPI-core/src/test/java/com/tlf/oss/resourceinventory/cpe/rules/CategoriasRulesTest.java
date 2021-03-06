package com.tlf.oss.resourceinventory.cpe.rules;

import static org.junit.Assert.assertEquals;

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
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class CategoriasRulesTest {

	@Mock
	protected OSSLogger logger;

	private ResourceInventoryEntity entity;

	@InjectMocks
	private ExecutionRules executionRules;
	
	@Before
	public void before() throws OSSBusinessException {
		entity = new ResourceInventoryEntity();

		ResourceFacingService resourceFacingService = new ResourceFacingService();
		List<CustomerFacingService> listOfCustomerFacingService = new ArrayList<CustomerFacingService>();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		ResourceOrder resourceOrder = new ResourceOrder();

		entity.setResourceFacingService(resourceFacingService);
		entity.setAddress(new BrazilianUrbanPropertyAddress());

		resourceOrder.setResourceOrderItem(resourceOrderItem);

		entity.setResourceOrder(resourceOrder);

		listOfCustomerFacingService.add(new CustomerFacingService());

		entity.setCustomerFacingService(listOfCustomerFacingService);
	}

	@Test
	public void shouldValidateRuleVOIPATAWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.VOIP.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.VOICE_EQUIPMENT_TYPE, CpeConstants.ATA));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.VOICE_TOTAL_PORTS, "8"));
		
		String ataPortas = CpeConstants.ATA + " "
				+ entity.getCustomerFacingService().get(0).getServiceDescribedBy().stream()
						.filter(ata -> CpeConstants.VOICE_TOTAL_PORTS.equals(ata.getName())).findFirst().get()
						.getServiceSpecCharDescribes().get(0).getValue()
				+ " Portas";

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(ataPortas, category);
	}

	@Test
	public void shouldValidateRuleAccessHGUWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.BB_EQUIPMENT_TYPE, CpeConstants.HGU));

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(CpeConstants.HGU, category);
	}

	@Test
	public void shouldValidateRuleAccessHGUHPNAWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.BB_EQUIPMENT_TYPE, CpeConstants.HGU));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.HPNA, String.valueOf(Boolean.TRUE)));

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(CpeConstants.HGU + " " + CpeConstants.HPNA, category);
	}

	@Test
	public void shouldValidateRuleAccessHGUHPNAFalseWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.BB_EQUIPMENT_TYPE, CpeConstants.HGU));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.HPNA, String.valueOf(Boolean.FALSE)));

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(CpeConstants.HGU, category);
	}

	@Test
	public void shouldValidateRuleVOIPWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.VOIP.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.VOICE_EQUIPMENT_TYPE, CpeConstants.HGU));

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(CpeConstants.HGU, category);
	}

	@Test
	public void shouldValidateRuleSTBWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.EQUIPMENT_TYPE, CpeConstants.STB));

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(CpeConstants.SET_TOP_BOX, category);
	}

	@Test
	public void shouldValidateRuleSTBDVRIPTVWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.EQUIPMENT_TYPE, CpeConstants.STB));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.DVR, String.valueOf(Boolean.TRUE)));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.TECHNOLOGY, CpeConstants.IPTV));

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(
				CpeConstants.SET_TOP_BOX.concat(" ").concat(CpeConstants.DVR).concat(" ").concat(CpeConstants.IPTV),
				category);
	}

	@Test
	public void shouldValidateRuleSTBIPTVWithSucess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.EQUIPMENT_TYPE, CpeConstants.STB));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.DVR, String.valueOf(Boolean.FALSE)));
		entity.getCustomerFacingService().get(0).getServiceDescribedBy()
				.add(getServiceDescribedBy(CpeConstants.TECHNOLOGY, CpeConstants.IPTV));

		String category = executionRules.defineNomeCategoria(entity);

		assertEquals(CpeConstants.SET_TOP_BOX.concat(" ").concat(CpeConstants.IPTV), category);
	}

	@Test
	public void testValidateVoipSuccess() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.ACCESS.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();

		executionRules.defineNomeCategoria(entity);
		
	}
	
	@Test(expected = OSSBusinessException.class)
	public void testValidateSTBException() throws OSSBusinessException {

		entity.getResourceOrder().getResourceOrderItem().setName(TipoRfs.STB.getRoiName());
		entity.getCustomerFacingService().get(0).getServiceDescribedBy().clear();

		executionRules.defineNomeCategoria(entity);
		
	}
	
	private ServiceDescribedBy getServiceDescribedBy(String name, String value) {

		final ServiceDescribedBy serviceDescribedByDs = new ServiceDescribedBy();
		ServiceSpecCharDescribes serviceSpecCharDescribes = new ServiceSpecCharDescribes();

		serviceSpecCharDescribes.setValue(value);
		serviceDescribedByDs.setName(name);
		serviceDescribedByDs.getServiceSpecCharDescribes().add(serviceSpecCharDescribes);

		return serviceDescribedByDs;
	}
}
