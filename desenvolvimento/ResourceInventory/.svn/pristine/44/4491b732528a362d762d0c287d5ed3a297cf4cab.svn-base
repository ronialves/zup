package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertEquals;
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
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityGponEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAvailabilityGponDao;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AvailabilityRetrieveGponControllerTest {

	@InjectMocks
	AvailabilityRetrieveGponController availabilityRetrieveGponController;

	@Mock
	private RetrieveAvailabilityGponDao retrieveAvailabilityGponDao;

	private ResourceInventoryEntity entity;

	@Before
	public void before() {

		entity = new ResourceInventoryEntity();
		BrazilianUrbanPropertyAddress ba = new BrazilianUrbanPropertyAddress();
		ba.setCnl("11135");
		ba.setTelephonicArea("AT");
		entity.setAddress(ba);

		Cabinet cabinet = new Cabinet();
		cabinet.setPrimaryCable("01");
		cabinet.setPrimaryFiber("10");
		entity.setCabinet(cabinet);
	}

	@Test
	public void shouldGetAvailabilityRetrieve() throws OSSBusinessException {

		RetrieveAvailabilityGponEntity availabilityGponEntity = getRetrieveAvailabilityGponEntity(entity);
		availabilityGponEntity.setCode("0");
		availabilityGponEntity.setMaxBroadbandSpeed("1024");
		availabilityGponEntity.setFreePorts("4");

		when(retrieveAvailabilityGponDao.availabilityRetrieve(anyObject())).thenReturn(availabilityGponEntity);

		entity = availabilityRetrieveGponController.availabilityRetrieve(entity);
		assertEquals("1024", entity.getCabinet().getHasShelves().get(0).getHasCards().get(0)
				.getMaxBroadbandSpeed());
		assertEquals("GPON", entity.getCabinet().getHasShelves().get(0).getHasCards().get(0)
				.getTechnology());
	}

	@Test(expected=OSSBusinessException.class)
	public void shouldNotGetAvailabilityRetrieve() throws OSSBusinessException {

		RetrieveAvailabilityGponEntity availabilityGponEntity = getRetrieveAvailabilityGponEntity(entity);
		availabilityGponEntity.setCode("10");

		when(retrieveAvailabilityGponDao.availabilityRetrieve(anyObject())).thenReturn(availabilityGponEntity);

		try {
			entity = availabilityRetrieveGponController.availabilityRetrieve(entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e.getDetail());
			assertTrue(e.getDescription().contains("Erro ao retornar o objeto RetrieveAvailabilityGpon"));
			throw e;
		}
	}

	private RetrieveAvailabilityGponEntity getRetrieveAvailabilityGponEntity(ResourceInventoryEntity entity)
			throws OSSBusinessException {

		RetrieveAvailabilityGponEntity availabilityEntity = new RetrieveAvailabilityGponEntity();

		availabilityEntity.setCnl(entity.getAddress().getCnl());
		availabilityEntity.setAt(entity.getAddress().getTelephonicArea());
		availabilityEntity.setPrimaryCable(entity.getCabinet().getPrimaryCable());
		availabilityEntity.setPrimaryFiber(entity.getCabinet().getPrimaryFiber());

		return availabilityEntity;
	}
}