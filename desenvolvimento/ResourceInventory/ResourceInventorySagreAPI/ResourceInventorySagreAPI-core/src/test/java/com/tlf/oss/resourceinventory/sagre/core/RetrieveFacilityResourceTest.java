package com.tlf.oss.resourceinventory.sagre.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.sagre.entity.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.sagre.repository.FacilityResourceRepository;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.PlacePhysicalResourceAssoc;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

/**
 * BEATRIXTWO-441 | DEMOSS-2279
 *
 * @project Beatrix Fase 2
 * @author rodrigo.de.freitas
 * @since 201710
 */
@RunWith(MockitoJUnitRunner.class)
public class RetrieveFacilityResourceTest {

	@InjectMocks
	private FacilityResourceController facilityController;

	@Mock
	private FacilityResourceRepository facilityRepository;

	private ResourceInventoryEntity resourceInventoryEntity;
	private RetrieveFacilityEntity retrieveFacilityEntity;
	
	@Before
	public void before(){
		
		facilityController.logger = new OSSLogger();
		
		resourceInventoryEntity = buildResourceInventory();
		
		retrieveFacilityEntity = buildFacilityRetrievalResource(resourceInventoryEntity);
		
	}
	
	/**
	 * Teste do fluxo sem gerar exececao e realizando todos os passos necessarios para o enriquecimento
	 * @throws OSSBusinessException
	 */
	@Test
	public void testDoExecution() throws OSSBusinessException{
		when(facilityRepository.retrieveFacility(anyObject())).thenReturn(retrieveFacilityEntity);
		ResourceInventoryEntity out = facilityController.retrieveFacility(resourceInventoryEntity);
		
		assertNotNull(out);
		assertTrue("0".equalsIgnoreCase(retrieveFacilityEntity.getResultCode().toString()));
	}
	
	/**
	 * Teste da leitura do campo P_OUT_NOTA e enriquecimento do {@link ResourceInventoryEntity}
	 * @throws OSSBusinessException
	 */
	@Test
	public void testGetResourceInventoryEntity() throws OSSBusinessException{
		ResourceInventoryEntity out = facilityController.getResourceInventoryEntity(retrieveFacilityEntity, resourceInventoryEntity);
		
		assertNotNull(out.getCabinet());
		
		assertTrue("MGBET_O1A08".equalsIgnoreCase(out.getCabinet().getName()));
		assertTrue("A08SP2".equals(out.getCabinet().getSplitter().get(0).getId()));
		assertTrue("2".equals(out.getCabinet().getSplitter().get(0).getFiberId()));
		assertTrue("A08G0006".equals(out.getCabinet().getTerminalBox().getName()));
		assertTrue("O1A08SS6".equals(out.getCabinet().getSplitter().get(1).getId()));
		assertTrue("7".equals(out.getCabinet().getSplitter().get(1).getFiberId()));
		assertTrue("DS".equals(out.getCabinet().getSplitter().get(1).getStatus()));
		assertTrue("A08".equals(out.getCabinet().getFeederCable()));
	}

	/**
	 * Teste do fluxo gerando excecao
	 */
	@Test
	public void testDoExecutionOSSBusinessException() {

		OSSBusinessException exception = null;

		try {
			resourceInventoryEntity.setAddress(null);
			facilityController.retrieveFacility(resourceInventoryEntity);

		} catch (Exception e) {
			exception = new OSSBusinessException("Code: 0", "RI-SAGRE", "ERRO: " + e.getMessage());
		}

		assertNotNull(exception);

	}

	/**
	 * Metodo criado para facilitar a leitura e a manipulacao do objeto {@link ResourceInventoryEntity}
	 * @return {@link ResourceInventoryEntity}
	 */
	private ResourceInventoryEntity buildResourceInventory() {

		resourceInventoryEntity = new ResourceInventoryEntity();

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11074");
		
		PlacePhysicalResourceAssoc physicalResourceAssoc = new PlacePhysicalResourceAssoc();
		PhysicalLink physicalLink = new PhysicalLink();
		physicalLink.setAccessTechnology("GPON");
		physicalLink.setVoiceProtocol("SIP");

		physicalResourceAssoc.setPhysicalLink(physicalLink);
		address.setPlacePhysicalResourceAssoc(physicalResourceAssoc);
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		resourceFacingService.setServiceId("BRU-02282072-069");
		
		resourceInventoryEntity.setAddress(address);
		resourceInventoryEntity.setResourceFacingService(resourceFacingService);
		
		return resourceInventoryEntity;
	}

	/**
	 * Metodo criado para facilitar a leitura e a manipulacao do objeto {@link RetrieveFacilityEntity}
	 * @param entity
	 * @return {@link RetrieveFacilityEntity}
	 */
	private RetrieveFacilityEntity buildFacilityRetrievalResource(ResourceInventoryEntity entity) {
		retrieveFacilityEntity = new RetrieveFacilityEntity();

		retrieveFacilityEntity.setCnl(Integer.valueOf(entity.getAddress().getCnl()));
		retrieveFacilityEntity.setAccessTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology());
		retrieveFacilityEntity.setVoiceTechnology(
				entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getVoiceProtocol());
		retrieveFacilityEntity.setAccessId(entity.getResourceFacingService().getServiceId());
		retrieveFacilityEntity.setType(null);
		retrieveFacilityEntity.setEquipGen1("GEN1");
		retrieveFacilityEntity.setEquipGen2("GEN2");
		retrieveFacilityEntity.setEquipGen3("GEN3");
		retrieveFacilityEntity.setNote(
				"Armario: MGBET_O1A08 Splitter_1n: A08SP2 Fibra_1n: 2 Conexao_1n2n: EXISTENTE Splitter_2n: O1A08SS6 Fibra_2n: 7 Caixa: A08G0006 Cabo: A08 Status: DS");
		retrieveFacilityEntity.setResultCode(0);
		retrieveFacilityEntity.setMessage(null);

		return retrieveFacilityEntity;
	}
}
