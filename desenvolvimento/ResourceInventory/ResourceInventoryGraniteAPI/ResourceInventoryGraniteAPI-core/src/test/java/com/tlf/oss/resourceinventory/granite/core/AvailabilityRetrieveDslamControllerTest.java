package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.UDA;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAvailabilityDslamDao;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@RunWith(MockitoJUnitRunner.class)
public class AvailabilityRetrieveDslamControllerTest {

	@InjectMocks
	private AvailabilityRetrieveDslamController controller;
	
	@Mock
	private RetrieveAvailabilityDslamDao availabilityDslamDao;

	@Mock
	@Inject
	private RetrieveResourceMapper retrieveResourceMapper;
	
	@Test(expected=OSSBusinessException.class)
	public void doesNotFindUdaVPN() throws OSSBusinessException {
		try {
			controller.getAvailabilityDSLAM(new ArrayList<>(), new ResourceInventoryEntity());
		} catch (OSSBusinessException e) {
			String message = e.getDetail();
			assertNotNull(message);
			assertTrue(message.contains(UDA.VPN.getValue()));
			throw e;
		}
	}
	
	@Test(expected=OSSBusinessException.class)
	public void doesNotFindUdaIP() throws OSSBusinessException {
		
		RetrieveUdaEntity udaVpn = new RetrieveUdaEntity();
		udaVpn.setUda_nome(UDA.VPN.getValue());
		
		List<RetrieveUdaEntity> listUDA = new ArrayList<>();
		listUDA.add(udaVpn);
		
		controller.getAvailabilityDSLAM(listUDA, new ResourceInventoryEntity());
	}
	
	@Test(expected=OSSBusinessException.class)
	public void doesNotFindUdaTIPOPORTA() throws OSSBusinessException {
		
		RetrieveUdaEntity udaVpn = new RetrieveUdaEntity();
		udaVpn.setUda_nome(UDA.VPN.getValue());
		
		RetrieveUdaEntity udaIp = new RetrieveUdaEntity();
		udaIp.setUda_nome(UDA.IP.getValue());
		
		List<RetrieveUdaEntity> listUDA = new ArrayList<>();
		listUDA.add(udaVpn);
		listUDA.add(udaIp);
		
		controller.getAvailabilityDSLAM(listUDA, new ResourceInventoryEntity());
	}
	
	@Test(expected=OSSBusinessException.class)
	public void doesNotFindUdaTIPOREDE() throws OSSBusinessException {
		
		RetrieveUdaEntity udaVpn = new RetrieveUdaEntity();
		udaVpn.setUda_nome(UDA.VPN.getValue());
		
		RetrieveUdaEntity udaIp = new RetrieveUdaEntity();
		udaIp.setUda_nome(UDA.IP.getValue());
		
		RetrieveUdaEntity udaTipoPorta = new RetrieveUdaEntity();
		udaTipoPorta.setUda_nome(UDA.TIPO_PORTA.getValue());
		
		List<RetrieveUdaEntity> listUDA = new ArrayList<>();
		listUDA.add(udaVpn);
		listUDA.add(udaIp);
		listUDA.add(udaTipoPorta);
		
		controller.getAvailabilityDSLAM(listUDA, new ResourceInventoryEntity());
	}
	
	@Test(expected=OSSBusinessException.class)
	public void doesNotFindUdaPROTOCOLO() throws OSSBusinessException {
		
		RetrieveUdaEntity udaVpn = new RetrieveUdaEntity();
		udaVpn.setUda_nome(UDA.VPN.getValue());
		
		RetrieveUdaEntity udaIp = new RetrieveUdaEntity();
		udaIp.setUda_nome(UDA.IP.getValue());
		
		RetrieveUdaEntity udaTipoPorta = new RetrieveUdaEntity();
		udaTipoPorta.setUda_nome(UDA.TIPO_PORTA.getValue());
		
		RetrieveUdaEntity udaTipoRede = new RetrieveUdaEntity();
		udaTipoRede.setUda_nome(UDA.TIPO_REDE.getValue());
		
		List<RetrieveUdaEntity> listUDA = new ArrayList<>();
		listUDA.add(udaVpn);
		listUDA.add(udaIp);
		listUDA.add(udaTipoPorta);
		listUDA.add(udaTipoRede);
		
		controller.getAvailabilityDSLAM(listUDA, new ResourceInventoryEntity());
	}
	
	@Test(expected=OSSBusinessException.class)
	public void doesNotFindUdaCNL() throws OSSBusinessException {
		
		RetrieveUdaEntity udaVpn = new RetrieveUdaEntity();
		udaVpn.setUda_nome(UDA.VPN.getValue());
		
		RetrieveUdaEntity udaIp = new RetrieveUdaEntity();
		udaIp.setUda_nome(UDA.IP.getValue());
		
		RetrieveUdaEntity udaTipoPorta = new RetrieveUdaEntity();
		udaTipoPorta.setUda_nome(UDA.TIPO_PORTA.getValue());
		
		RetrieveUdaEntity udaTipoRede = new RetrieveUdaEntity();
		udaTipoRede.setUda_nome(UDA.TIPO_REDE.getValue());

		RetrieveUdaEntity udaProtocolo = new RetrieveUdaEntity();
		udaProtocolo.setUda_nome(UDA.PROTOCOLO.getValue());
		
		List<RetrieveUdaEntity> listUDA = new ArrayList<>();
		listUDA.add(udaVpn);
		listUDA.add(udaIp);
		listUDA.add(udaTipoPorta);
		listUDA.add(udaTipoRede);
		listUDA.add(udaProtocolo);
		
		try {
			controller.getAvailabilityDSLAM(listUDA, new ResourceInventoryEntity());
		} catch (OSSBusinessException e) {
			String message = e.getDetail();
			assertNotNull(message);
			assertTrue(message.contains(UDA.CNL.getValue()));
			throw e;
		}
	}
	
	@Test(expected=OSSBusinessException.class)
	public void doesNotFindUdaSIGLAAT() throws OSSBusinessException {
		
		RetrieveUdaEntity udaVpn = new RetrieveUdaEntity();
		udaVpn.setUda_nome(UDA.VPN.getValue());
		
		RetrieveUdaEntity udaIp = new RetrieveUdaEntity();
		udaIp.setUda_nome(UDA.IP.getValue());
		
		RetrieveUdaEntity udaTipoPorta = new RetrieveUdaEntity();
		udaTipoPorta.setUda_nome(UDA.TIPO_PORTA.getValue());
		
		RetrieveUdaEntity udaTipoRede = new RetrieveUdaEntity();
		udaTipoRede.setUda_nome(UDA.TIPO_REDE.getValue());

		RetrieveUdaEntity udaProtocolo = new RetrieveUdaEntity();
		udaProtocolo.setUda_nome(UDA.PROTOCOLO.getValue());
		
		RetrieveUdaEntity udaCnl = new RetrieveUdaEntity();
		udaCnl.setUda_nome(UDA.CNL.getValue());
		
		List<RetrieveUdaEntity> listUDA = new ArrayList<>();
		listUDA.add(udaVpn);
		listUDA.add(udaIp);
		listUDA.add(udaTipoPorta);
		listUDA.add(udaTipoRede);
		listUDA.add(udaProtocolo);
		listUDA.add(udaCnl);
		
		try {
			controller.getAvailabilityDSLAM(listUDA, new ResourceInventoryEntity());
		} catch (OSSBusinessException e) {
			String message = e.getDetail();
			assertNotNull(message);
			assertTrue(message.contains(UDA.SIGLA_AT.getValue()));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldExecuteWithSuccess() throws OSSBusinessException {
		
		List<RetrieveUdaEntity> udas = getUdas();
		
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		
		when(availabilityDslamDao.getAvailabilityDSLAM(anyMapOf(UDA.class, RetrieveUdaEntity.class), anyObject())).thenReturn(Collections.EMPTY_LIST);
		
		controller.getAvailabilityDSLAM(udas, entity);
	}

	private List<RetrieveUdaEntity> getUdas() {
		RetrieveUdaEntity udaVpn = new RetrieveUdaEntity();
		udaVpn.setUda_nome(UDA.VPN.getValue());
		
		RetrieveUdaEntity udaIp = new RetrieveUdaEntity();
		udaIp.setUda_nome(UDA.IP.getValue());
		
		RetrieveUdaEntity udaTipoPorta = new RetrieveUdaEntity();
		udaTipoPorta.setUda_nome(UDA.TIPO_PORTA.getValue());
		
		RetrieveUdaEntity udaTipoRede = new RetrieveUdaEntity();
		udaTipoRede.setUda_nome(UDA.TIPO_REDE.getValue());

		RetrieveUdaEntity udaProtocolo = new RetrieveUdaEntity();
		udaProtocolo.setUda_nome(UDA.PROTOCOLO.getValue());
		
		RetrieveUdaEntity udaCnl = new RetrieveUdaEntity();
		udaCnl.setUda_nome(UDA.CNL.getValue());
		
		RetrieveUdaEntity udaSiglaAt = new RetrieveUdaEntity();
		udaSiglaAt.setUda_nome(UDA.SIGLA_AT.getValue());
		
		List<RetrieveUdaEntity> udas = new ArrayList<>();
		udas.add(udaVpn);
		udas.add(udaIp);
		udas.add(udaTipoPorta);
		udas.add(udaTipoRede);
		udas.add(udaProtocolo);
		udas.add(udaCnl);
		udas.add(udaSiglaAt);
		return udas;
	}
	
}
