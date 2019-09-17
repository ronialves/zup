package com.tlf.oss.resourceinventory.granite.mapper.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityDslamEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveResourceMapper;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class RetrieveResourceMapperTest {

	@InjectMocks
	private RetrieveResourceMapper retrieveResourceMapper;
	
	@Test
	public void shouldExecuteWithSuccessAndReturnAListShelvesEmpty() throws OSSBusinessException {
		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabinet Test");
		
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		entity.setCabinet(cabinet);
		
		retrieveResourceMapper.parseGetPhysicalResourceAvailabilityDslam(Collections.emptyList(), entity);
		
		assertNotNull(entity.getCabinet());
		assertNotNull(entity.getCabinet().getHasShelves());
		Assert.assertTrue(entity.getCabinet().getHasShelves().isEmpty());
	}
	
	@Test
	public void shouldExecuteWithSuccessReceivingAListNullAndReturnAListShelvesEmpty() throws OSSBusinessException {
		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabinet Test");
		
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		entity.setCabinet(cabinet);
		
		retrieveResourceMapper.parseGetPhysicalResourceAvailabilityDslam(null, entity);
		
		assertNotNull(entity.getCabinet());
		assertNotNull(entity.getCabinet().getHasShelves());
		Assert.assertTrue(entity.getCabinet().getHasShelves().isEmpty());
	}
	
	@Test(expected=OSSBusinessException.class)
	public void shouldThrowAnExceptionOnListSorterBecauseSpeedIsNull() throws OSSBusinessException {
		RetrieveAvailabilityDslamEntity adsl = new RetrieveAvailabilityDslamEntity();
		adsl.setQuantityPort(10);
		
		RetrieveAvailabilityDslamEntity adsl2Plus = new RetrieveAvailabilityDslamEntity();
		adsl2Plus.setQuantityPort(20);
		
		RetrieveAvailabilityDslamEntity vdsl = new RetrieveAvailabilityDslamEntity();
		vdsl.setQuantityPort(5);
		
		Collection<RetrieveAvailabilityDslamEntity> availabilityResultCollection = new ArrayList<>();
		availabilityResultCollection.add(adsl);
		availabilityResultCollection.add(adsl2Plus);
		availabilityResultCollection.add(vdsl);

		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		
		try {
			retrieveResourceMapper.parseGetPhysicalResourceAvailabilityDslam(availabilityResultCollection, entity);
		} catch (OSSBusinessException e) {
			assertNotNull(e);
			assertEquals(Code.RIGRANITE_001.getValue(), e.getStatusCode());
			assertEquals("Erro ao retornar o objeto ReserveAvailabilityResourceServiceDslam", e.getDescription());
			throw e;
		}
	}
	
	@Test
	public void shouldExecuteWithSuccess() throws OSSBusinessException {
		RetrieveAvailabilityDslamEntity adsl = new RetrieveAvailabilityDslamEntity();
		adsl.setTechnology("ADSL");
		adsl.setQuantityPort(10);
		adsl.setSpeed(1000);
		
		RetrieveAvailabilityDslamEntity adsl2Plus = new RetrieveAvailabilityDslamEntity();
		adsl2Plus.setTechnology("ADSL2+");
		adsl2Plus.setQuantityPort(20);
		adsl2Plus.setSpeed(2000);
		
		RetrieveAvailabilityDslamEntity vdsl = new RetrieveAvailabilityDslamEntity();
		vdsl.setTechnology("VDSL");
		vdsl.setQuantityPort(5);
		vdsl.setSpeed(5000);
		
		Collection<RetrieveAvailabilityDslamEntity> availabilityResultCollection = new ArrayList<>();
		availabilityResultCollection.add(adsl);
		availabilityResultCollection.add(adsl2Plus);
		availabilityResultCollection.add(vdsl);

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabinet Test");
		
		if(cabinet.getHasShelves().size()==0){
			Shelf shelf = new Shelf();
			cabinet.getHasShelves().add(shelf);
		};
		
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		entity.setCabinet(cabinet);
		
		retrieveResourceMapper.parseGetPhysicalResourceAvailabilityDslam(availabilityResultCollection, entity);
		
		assertNotNull(entity.getCabinet().getHasShelves().get(0));
		assertNotNull(entity.getCabinet().getHasShelves().get(0).getHasCards().get(0).getMaxBroadbandSpeed());
		assertEquals(entity.getCabinet().getHasShelves().get(0).getHasCards().get(0).getTechnology(), "VDSL");
		assertEquals(entity.getCabinet().getHasShelves().get(0).getHasCards().get(0).getMaxBroadbandSpeed(), Integer.toString(5000));
	}
	
}
