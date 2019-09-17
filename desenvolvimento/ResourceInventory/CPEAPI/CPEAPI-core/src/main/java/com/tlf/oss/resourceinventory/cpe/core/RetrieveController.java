package com.tlf.oss.resourceinventory.cpe.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.cpe.entity.CaracteristicaDispositivo;
import com.tlf.oss.resourceinventory.cpe.entity.CatalogoInfo;
import com.tlf.oss.resourceinventory.cpe.entity.ClientInformation;
import com.tlf.oss.resourceinventory.cpe.enums.EstadoServico;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.cpe.repository.RetrieveRepository;
import com.tlf.oss.resourceinventory.cpe.utils.CpeConstants;
import com.tlf.oss.resourceinventory.cpe.utils.EntityExtractor;
import com.tlf.oss.resourceinventory.cpe.validation.Retrieve;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class RetrieveController {

	@Inject
	private OSSLogger logger;

	@Inject
	private RetrieveRepository retrieveRepository;

	public ResourceInventoryEntity retrieve(@Retrieve final ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (isRetrieveClientInformation(entity)) {
			logger.log(OSSLogger.INFO, "Buscando as informações de cliente no CPE...");

			EstadoServico estado;
			String status = EntityExtractor.extractStateOfResource(entity);

			if (null != status && status.equalsIgnoreCase(CpeConstants.STATE_ACTIVE)) {
				estado = EstadoServico.ATIVADO;
			} else {
				estado = EstadoServico.EM_APROVISIONAMENTO;
			}

			List<ClientInformation> result = retrieveRepository.retrieveClientInformation(entity, estado);

			return mapClientInformation(entity, result);

		} else {
			logger.log(OSSLogger.INFO, "Buscando as informações de catálogo no CPE...");
			List<CatalogoInfo> result = retrieveRepository.retrieveCatalog();
			return mapCatalogoInfo(entity, result);
		}
	}

	public boolean isRetrieveClientInformation(ResourceInventoryEntity entity) {
		if (null == entity.getResourceOrder())
			return false;
		return true;
	}

	private ResourceInventoryEntity mapCatalogoInfo(final ResourceInventoryEntity entity,
			final List<CatalogoInfo> catalogos) {

		logger.log(OSSLogger.INFO, "Mapeando os registros do banco na entidade ResourceInventoryEntity...");

		if (entity.getResourceFacingService() == null) {
			entity.setResourceFacingService(new ResourceFacingService());
		}

		catalogos.forEach(catalog -> {

			if (catalog.getModelo() != null && !catalog.getModelo().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.MODELO, catalog.getModelo()));
			}

			if (catalog.getFabricante() != null && !catalog.getFabricante().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.FABRICANTE, catalog.getFabricante()));
			}

			if (catalog.getRede() != null && !catalog.getRede().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.REDE, catalog.getRede()));
			}

			if (catalog.getTipoDispositivo() != null && !catalog.getTipoDispositivo().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.TIPO_DISPOSITIVO, catalog.getTipoDispositivo()));
			}

			if (catalog.getDescricao() != null && !catalog.getDescricao().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.DESCRICAO, catalog.getDescricao()));
			}

			if (catalog.getTipoRFS() != null && !catalog.getTipoRFS().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.TIPO_RFS, catalog.getTipoRFS()));
			}

			if (catalog.getNomeCategoria() != null && !catalog.getNomeCategoria().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.NOME_CATEGORIA, catalog.getNomeCategoria()));
			}

			if (catalog.getNomeCaracteristica() != null && !catalog.getNomeCaracteristica().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy().add(
						createServiceDescribedBy(CpeConstants.NOME_CARACTERISTICA, catalog.getNomeCaracteristica()));
			}

			if (catalog.getValor() != null && !catalog.getValor().isEmpty()) {
				entity.getResourceFacingService().getServiceDescribedBy()
						.add(createServiceDescribedBy(CpeConstants.VALOR, catalog.getValor()));
			}
		});

		return entity;
	}

	private ResourceInventoryEntity mapClientInformation(final ResourceInventoryEntity entity,
			final List<ClientInformation> clientInformations) {
		logger.log(OSSLogger.INFO, "Mapeando os registros do banco na entidade ResourceInventoryEntity...");

		if (!clientInformations.isEmpty()) {
			List<CustomerFacingService> cfsList = new ArrayList<>();

			List<ClientInformation> voIpInfo = clientInformations.stream()
					.filter(info -> TipoRfs.VOIP.getRoiName().equals(info.getTipoRfs())).collect(Collectors.toList());
			if (CollectionUtils.isNotEmpty(voIpInfo)) {
				clientInformations.removeIf(info -> TipoRfs.VOIP.getRoiName().equals(info.getTipoRfs()));
				clientInformations.add(voIpInfo.get(0));
			}

			clientInformations.forEach(clientInfo -> {
				CustomerFacingService cfs = new CustomerFacingService();
				ResourceFacingService rfs = new ResourceFacingService();
				List<ResourceFacingService> rfsList = new ArrayList<>();
				List<ServiceDescribedBy> rfsSdbList = new ArrayList<>();

				cfs.setServiceId(clientInfo.getServiceId());

				rfs.setStatus(clientInfo.getStatus());
				rfs.setCategory(clientInfo.getTipoRfs());
				rfs.setServiceDescribedBy(rfsSdbList);
				rfsList.add(rfs);
				cfs.setResourceFacingService(rfsList);

				String equipmentType;
				String categoria;

				if (EstadoServico.ATIVADO.getValue().equalsIgnoreCase(clientInfo.getStatus())) {
					categoria = clientInfo.getCategoriaCorrente();
				} else {
					categoria = clientInfo.getCategoriaEsperada();
				}

				if (!TipoRfs.VOIP.getRoiName().equalsIgnoreCase(clientInfo.getTipoRfs())) {
					equipmentType = CpeConstants.EQUIPMENT_TYPE;
				} else {
					String voiceTotalPorts = "2";

					equipmentType = CpeConstants.VOICE_EQUIPMENT_TYPE;

					if (null != categoria && categoria.contains(CpeConstants.ATA)) {
						voiceTotalPorts = categoria.replaceAll("[^0-9]", "");
					}

					for (ClientInformation voip : voIpInfo) {
						rfsSdbList
								.add(createServiceDescribedBy(CpeConstants.TELEPHONE_NUMBER, voip.getNumeroTelefone()));
						rfsSdbList.add(createServiceDescribedBy(CpeConstants.ID_FXS, voip.getIdFxs()));
					}

					rfsSdbList.add(createServiceDescribedBy(CpeConstants.VOICE_TOTAL_PORTS, voiceTotalPorts));
					rfsSdbList.add(
							createServiceDescribedBy(CpeConstants.VOICE_USED_PORTS, String.valueOf(voIpInfo.size())));
				}

				if (isNotEmpty(clientInfo.getNumeroSerialGpon())) {
					rfsSdbList.add(createServiceDescribedBy(CpeConstants.GPON_SERIAL_NUMBER,
							clientInfo.getNumeroSerialGpon()));
				}

				if (isNotEmpty(clientInfo.getNumeroSerial())) {
					rfsSdbList.add(createServiceDescribedBy(CpeConstants.SERIAL_NUMBER, clientInfo.getNumeroSerial()));
				}

				if (isNotEmpty(clientInfo.getMacAddress())) {
					rfsSdbList.add(createServiceDescribedBy(CpeConstants.MACADDRESS, clientInfo.getMacAddress()));
				}

				rfsSdbList.add(createServiceDescribedBy(equipmentType, categoria));

				if (isNotEmpty(clientInfo.getModel())) {
					rfsSdbList.add(createServiceDescribedBy(CpeConstants.EQUIPMENT_MODEL, clientInfo.getModel()));
				}

				if (isNotEmpty(clientInfo.getVendor())) {
					rfsSdbList.add(createServiceDescribedBy(CpeConstants.EQUIPMENT_VENDOR, clientInfo.getVendor()));
				}

				if (TipoRfs.ACCESS.getRoiName().equalsIgnoreCase(clientInfo.getTipoRfs())) {
					rfsSdbList.add(createServiceDescribedBy(CpeConstants.HPNA,
							null != categoria && categoria.contains(CpeConstants.HPNA) ? "true" : "false"));
				} else if (TipoRfs.STB.getRoiName().equalsIgnoreCase(clientInfo.getTipoRfs())) {
					rfsSdbList.add(createServiceDescribedBy(CpeConstants.DVR,
							null != categoria && categoria.contains(CpeConstants.DVR) ? "true" : "false"));

					Optional<CaracteristicaDispositivo> wifi = Optional.empty();

					if (null != clientInfo.getCaracteristicas()) {
						
						wifi = clientInfo.getCaracteristicas()
								.stream()
								.filter(caracteristica -> CpeConstants.WIFI.equalsIgnoreCase(caracteristica.getNome()) && CpeConstants.SUPORTA.equalsIgnoreCase(caracteristica.getValor()))
								.findAny();
					}

					rfsSdbList.add(createServiceDescribedBy(CpeConstants.WIFI, wifi.isPresent() ? "true" : "false"));

				}

				cfsList.add(cfs);
			});

			entity.setCustomerFacingService(cfsList);
		}

		return entity;
	}

	private ServiceDescribedBy createServiceDescribedBy(String name, String value) {
		ServiceDescribedBy sdb = new ServiceDescribedBy();

		sdb.getServiceSpecCharDescribes().add(new ServiceSpecCharDescribes());
		sdb.getServiceSpecCharDescribes().get(0).setValue(value);
		sdb.setName(name);

		return sdb;
	}

	private boolean isEmpty(String value) {
		return null == value || value.isEmpty();
	}

	private boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}
}
