package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveConfigUDADao;

@RunWith(MockitoJUnitRunner.class)
public class LoadConfigMemoryControllerTest {

	@InjectMocks
	private LoadConfigMemoryController loadConfigController;

	@Mock
	private RetrieveConfigUDADao rdao;
	
	@Test
	public void retrieveListUdaSucessTest() throws OSSBusinessException {
		RetrieveUdaEntity retrieveUDA = new RetrieveUdaEntity();
		retrieveUDA.setId(1L);
		retrieveUDA.setUda_id(1);
		retrieveUDA.setUda_nome("CNL");

		List<RetrieveUdaEntity>listUDA = new ArrayList<>();
		listUDA.add(retrieveUDA);
		
		when(rdao.getRetrieveUDAConfig()).thenReturn(listUDA);

		loadConfigController.getRetrieveListUDA();

		assertTrue(listUDA.size()>0);
	}

}
