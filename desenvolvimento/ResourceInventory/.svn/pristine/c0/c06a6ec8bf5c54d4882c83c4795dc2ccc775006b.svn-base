package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveExpiredResourcesEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveExpiredResourcesDao;
import com.tlf.oss.resourceinventory.schemas.ExpiredResource;
import com.tlf.oss.resourceinventory.schemas.RetrieveExpiredResources;

/**
 * 
 * @author luiz
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RetrieveExpiredResourcesControllerTest {
	
	@InjectMocks
	RetrieveExpiredResourcesController retrieveExpiredResourcesController;
	
	@Mock
	private RetrieveExpiredResourcesDao retrieveExpiredResourcesDao;
	
	@Mock
	private OSSLogger logger;
	
	private RetrieveExpiredResources entity;
	@Before
	public void before() {
		entity = new RetrieveExpiredResources();
		List<ExpiredResource> expiredResourceList = new ArrayList<>();
		expiredResourceList.add(new ExpiredResource());
		expiredResourceList.get(0).setTelephonicArea("JG");
		expiredResourceList.get(0).setCnl("11000");
		expiredResourceList.get(0).setExpiredHours("100.4");
		expiredResourceList.get(0).setStatus("RESERVADO");
		expiredResourceList.get(0).setTechnology("GPON");
		expiredResourceList.get(0).setServiceId("110003714782700");
		expiredResourceList.add(new ExpiredResource());
		expiredResourceList.get(1).setTelephonicArea("VM");
		expiredResourceList.get(1).setCnl("11000");
		expiredResourceList.get(1).setExpiredHours("101.8");
		expiredResourceList.get(1).setStatus("RESERVADO");
		expiredResourceList.get(1).setTechnology("GPON");
		expiredResourceList.get(1).setServiceId("110003564766200");
		entity.setExpiredResourceList(expiredResourceList);
		
		entity.setExpiredResourceList(new ArrayList<>());
		
	}
	
	@Test
	public void shouldReturnExpiredResourcesList() throws OSSBusinessException {
		RetrieveExpiredResourcesEntity mockedReturn1 = new RetrieveExpiredResourcesEntity();
		RetrieveExpiredResourcesEntity mockedReturn2 = new RetrieveExpiredResourcesEntity();
		mockedReturn1.setAt("JG");
		mockedReturn1.setCnl("11000");
		mockedReturn1.setHoursReserved(100.4f);
		mockedReturn1.setStatus("RESERVADO");
		mockedReturn1.setTechnology("GPON");
		mockedReturn1.setTerminal("110003714782700");
		
		mockedReturn2.setAt("VM");
		mockedReturn2.setCnl("11000");
		mockedReturn2.setHoursReserved(101.8f);
		mockedReturn2.setStatus("RESERVADO");
		mockedReturn2.setTechnology("GPON");
		mockedReturn2.setTerminal("110003564766200");
		
		
		when(retrieveExpiredResourcesDao.getExpired()).thenReturn(Arrays.asList(mockedReturn1,mockedReturn2));
		
		RetrieveExpiredResources mockedEntity = retrieveExpiredResourcesController.getExpired();
			
		assertArrayEquals(mockedEntity.getExpiredResourceList().toArray(),mockedEntity.getExpiredResourceList().toArray());
	}
	@Test(expected=OSSBusinessException.class)
	public void shouldThrowException() throws OSSBusinessException {
		
		when(retrieveExpiredResourcesDao.getExpired()).thenThrow(new OSSBusinessException());
		
		retrieveExpiredResourcesController.getExpired();
	}
	@Test
	public void shouldReturnNoExpiredResources() throws OSSBusinessException {
		when(retrieveExpiredResourcesDao.getExpired()).thenReturn(new ArrayList<RetrieveExpiredResourcesEntity>());
		
		RetrieveExpiredResources mockedEntity = retrieveExpiredResourcesController.getExpired();
		
		assertArrayEquals(mockedEntity.getExpiredResourceList().toArray(), new ArrayList<ExpiredResource>().toArray());
		
		
	}

}
