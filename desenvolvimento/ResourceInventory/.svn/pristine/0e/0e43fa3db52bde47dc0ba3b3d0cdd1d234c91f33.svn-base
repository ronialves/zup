package com.tlf.oss.resourceinventory.granite.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveAvailabilityMsanEntity;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveUdaEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.UDA;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveAvailabilityMsanDao;
import com.tlf.oss.resourceinventory.granite.core.to.RetrieveAvailabilityTO;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;

@RunWith(MockitoJUnitRunner.class)
public class AvailabilityRetrieveMsanControllerTest {

	@InjectMocks	private AvailabilityRetrieveMsanController controller;

	@Mock
	private RetrieveAvailabilityMsanDao availabilityMsanDao;

	@Mock
	private OSSLogger logger;

	@Test
	public void testGetCheckMsan() {
		String cnl = "CNL teste";
		String at = "AT teste";
		String cabinetName = "Nome cabine teste";
		RetrieveAvailabilityTO equipmentType = new RetrieveAvailabilityTO();
		equipmentType.getResult().setCode("0");
		equipmentType.setEquipmentType("MSAN");

		when(availabilityMsanDao.getCheckMSAM(cnl, at, cabinetName)).thenReturn(equipmentType);

		RetrieveAvailabilityTO msan = controller.getCheckMsan(cnl, at, cabinetName);

		assertNotNull(msan);
		assertEquals("MSAN", msan.getEquipmentType());

	}

	@Test
	public void testGetCheckDsalm() {
		String cnl = "CNL teste";
		String at = "AT teste";
		String cabinetName = "Nome cabine teste";
		RetrieveAvailabilityTO equipmentType = new RetrieveAvailabilityTO();
		equipmentType.getResult().setCode("0");
		equipmentType.setEquipmentType("DSLAM");

		when(availabilityMsanDao.getCheckMSAM(cnl, at, cabinetName)).thenReturn(equipmentType);
		RetrieveAvailabilityTO dslam = controller.getCheckMsan(cnl, at, cabinetName);

		assertNotNull(dslam);
		assertEquals("DSLAM", dslam.getEquipmentType());
		

	}
	@Test
	public void testGetAvailabilityMsan() throws OSSBusinessException {
		String TypeEquipment = "VDSL";

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabine teste");

		List<RetrieveUdaEntity> udas = getUdas();

		List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMSAN = new ArrayList<RetrieveAvailabilityMsanEntity>();
		
		RetrieveAvailabilityMsanEntity reponse = new RetrieveAvailabilityMsanEntity();
		reponse.getResult().setCode("0");
		retrieveAvailabilityMSAN.add(reponse);

		when(availabilityMsanDao.getAvailabilityMSAN(null, address, cabinet)).thenReturn(retrieveAvailabilityMSAN);

		controller.getAvailabilityMsan(address, cabinet, udas, TypeEquipment);
		
	}

	@Test(expected=OSSBusinessException.class)
	public void testGetAvailabilityMsanNoUda_VPN() throws OSSBusinessException {
		String TypeEquipment = "Tipo teste";

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabine teste");

		List<RetrieveUdaEntity> udas = getUdas();

		udas.remove(1);

		List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMSAN = new ArrayList<>();

		when(availabilityMsanDao.getAvailabilityMSAN(null, address, cabinet)).thenReturn(retrieveAvailabilityMSAN);

		controller.getAvailabilityMsan(address, cabinet, udas, TypeEquipment);

	}

	@Test(expected=OSSBusinessException.class)
	public void testGetAvailabilityMsanNoUda_IP() throws OSSBusinessException {
		String TypeEquipment = "Tipo teste";

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabine teste");

		List<RetrieveUdaEntity> udas = getUdas();

		udas.remove(2);

		List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMSAN = new ArrayList<>();
		when(availabilityMsanDao.getAvailabilityMSAN(null, address, cabinet)).thenReturn(retrieveAvailabilityMSAN);

		controller.getAvailabilityMsan(address, cabinet, udas, TypeEquipment);

	}

	@Test(expected=OSSBusinessException.class)
	public void testGetAvailabilityMsanNoUda_TipoPorta() throws OSSBusinessException {
		String TypeEquipment = "Tipo teste";

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabine teste");

		List<RetrieveUdaEntity> udas = getUdas();

		udas.remove(3);

		List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMSAN = new ArrayList<>();

		when(availabilityMsanDao.getAvailabilityMSAN(null, address, cabinet)).thenReturn(retrieveAvailabilityMSAN);

		controller.getAvailabilityMsan(address, cabinet, udas, TypeEquipment);
		
	}

	@Test(expected=OSSBusinessException.class)
	public void testGetAvailabilityMsanNoUda_TipoRede() throws OSSBusinessException {
		String TypeEquipment = "Tipo teste";

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabine teste");

		List<RetrieveUdaEntity> udas = getUdas();
		udas.remove(4);

		List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMSAN = new ArrayList<>();
		when(availabilityMsanDao.getAvailabilityMSAN(null, address, cabinet)).thenReturn(retrieveAvailabilityMSAN);

		controller.getAvailabilityMsan(address, cabinet, udas, TypeEquipment);
		
	}

	@Test(expected=OSSBusinessException.class)
	public void testGetAvailabilityMsanNoUdaCnl() throws OSSBusinessException {
		String TypeEquipment = "Tipo teste";

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabine teste");

		List<RetrieveUdaEntity> udas = getUdas();

		udas.remove(5);

		List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMSAN = new ArrayList<>();
		when(availabilityMsanDao.getAvailabilityMSAN(null, address, cabinet)).thenReturn(retrieveAvailabilityMSAN);

	controller.getAvailabilityMsan(address, cabinet, udas, TypeEquipment);
		
	}

	@Test(expected=OSSBusinessException.class)
	public void testGetAvailabilityMsanNoUdaProtocolo() throws OSSBusinessException {
		String TypeEquipment = "Tipo teste";

		BrazilianUrbanPropertyAddress address = new BrazilianUrbanPropertyAddress();
		address.setCnl("11000");
		address.setTelephonicArea("SA");

		Cabinet cabinet = new Cabinet();
		cabinet.setName("Cabine teste");

		List<RetrieveUdaEntity> udas = getUdas();

		udas.remove(6);

		List<RetrieveAvailabilityMsanEntity> retrieveAvailabilityMSAN = new ArrayList<>();
		when(availabilityMsanDao.getAvailabilityMSAN(null, address, cabinet)).thenReturn(retrieveAvailabilityMSAN);

		controller.getAvailabilityMsan(address, cabinet, udas, TypeEquipment);
		
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

		RetrieveUdaEntity udaAt = new RetrieveUdaEntity();
		udaAt.setUda_nome(UDA.SIGLA_AT.getValue());

		RetrieveUdaEntity udaNomeEngenharia = new RetrieveUdaEntity();
		udaNomeEngenharia.setUda_nome(UDA.NOME_ENGENHARIA.getValue());

		List<RetrieveUdaEntity> udas = new ArrayList<>();
		udas.add(udaAt);
		udas.add(udaVpn);
		udas.add(udaIp);
		udas.add(udaTipoPorta);
		udas.add(udaTipoRede);
		udas.add(udaCnl);
		udas.add(udaProtocolo);
		udas.add(udaNomeEngenharia);
		return udas;
	}
}
