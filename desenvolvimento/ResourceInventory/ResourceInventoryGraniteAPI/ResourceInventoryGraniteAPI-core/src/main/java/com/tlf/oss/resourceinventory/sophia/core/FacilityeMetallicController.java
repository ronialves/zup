package com.tlf.oss.resourceinventory.sophia.core;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.resourceinventory.granite.core.IdentifyNetworkController;
import com.tlf.oss.resourceinventory.granite.core.entity.RetrieveFacilityEntity;
import com.tlf.oss.resourceinventory.granite.core.enums.Code;
import com.tlf.oss.resourceinventory.granite.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.granite.core.enums.Message;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusFacilityType;
import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;
import com.tlf.oss.resourceinventory.granite.core.mapper.impl.RetrieveResourceMapper;
import com.tlf.oss.resourceinventory.granite.core.repository.RetrieveFacilityDao;
import com.tlf.oss.resourceinventory.granite.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Resource;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
public class FacilityeMetallicController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public RetrieveFacilityDao rdao;

	@Inject
	private RetrieveResourceMapper mapper;

	@Inject
	private IdentifyNetworkController identifyNetworkController;

	public ResourceInventoryEntity facilityResource(ResourceInventoryEntity entity) throws OSSBusinessException {

		entity = identifyNetwork(entity);

		RetrieveFacilityEntity retrieveFacilityEntity = getFacility(entity);

		entity = mapper.parseGetPhysicalResourceFacility(retrieveFacilityEntity, entity);

		return entity;

	}

	private RetrieveFacilityEntity getRetrieveFacilityResourceEntity(ResourceInventoryEntity entity) throws OSSBusinessException {

		RetrieveFacilityEntity retrieveFacilityEntity = new RetrieveFacilityEntity();

		retrieveFacilityEntity.setTerminal(getNetworkOwnerID(entity));

		return retrieveFacilityEntity;

	}

	protected String getNetworkOwnerID(ResourceInventoryEntity entity) throws OSSBusinessException {

		ResourceFacingService rfsTerminal = getResourceFacingService(entity, EntityFields.NETWORK_OWNER_ID.getValue());

		return rfsTerminal.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();

	}

	public RetrieveFacilityEntity getFacility(ResourceInventoryEntity entity) throws OSSBusinessException {

		RetrieveFacilityEntity retrieveFacilityEntity = getRetrieveFacilityResourceEntity(entity);

		return getStateFacility(entity, retrieveFacilityEntity);

	}

	/**
	 * 
	 * Metodo responsavel em valdiar as regras de negocio da consulta facilidade
	 * 
	 */

	private RetrieveFacilityEntity getStateFacility(ResourceInventoryEntity entity,
			RetrieveFacilityEntity retrieveFacilityEntity) throws OSSBusinessException {

		RetrieveFacilityEntity retrieveFacility = null;

		List<RetrieveFacilityEntity> retrieveFacilityList = rdao.getfacility(retrieveFacilityEntity);

		Optional<Resource> resource = Optional.ofNullable(entity.getResource());

		if (!resource.isPresent()) {

			retrieveFacility = retrieveFacilityList.stream().findFirst().get();

		} else {

			if (StatusFacilityType.ACTIVE.getValue().equalsIgnoreCase(entity.getResource().getStateOfResource())) {

				retrieveFacility = retrieveFacilityList.stream()
						.filter(p -> p.getStatus().equalsIgnoreCase(StatusPathType.ACTIVE.getValue()))

						.findFirst()

						.orElseThrow(() -> new OSSBusinessException(

								Message.ERRO_RESOURCE_RETRIEVE_PATH_BY_TERMINAL.getValue(),
								Code.RIGRANITE_003.getValue(),

								Message.ERRO_RESOURCE_RETRIEVE_PATH.getValue() + " active: "
										+ StatusPathType.ACTIVE.getValue() + " não encontrado"));

			} else if (StatusFacilityType.NEW.getValue().equalsIgnoreCase(entity.getResource().getStateOfResource())) {

				retrieveFacility = retrieveFacilityList.stream().filter((p) ->

				p.getStatus().equalsIgnoreCase(StatusPathType.RESERVED.getValue()) ||

				p.getStatus().equalsIgnoreCase(StatusPathType.IN_CONFIGURATION.getValue()))

						.findFirst()

						.orElseThrow(() -> new OSSBusinessException(

								Message.ERRO_RESOURCE_RETRIEVE_PATH_BY_TERMINAL.getValue(),
								Code.RIGRANITE_003.getValue(),

								Message.ERRO_RESOURCE_RETRIEVE_PATH.getValue() + " new: "
										+ StatusPathType.RESERVED.getValue() + " e "
										+ StatusPathType.IN_CONFIGURATION.getValue() + " não encontrado"));

			}

		}

		return retrieveFacility;

	}

	public ResourceInventoryEntity identifyNetwork(ResourceInventoryEntity entity) {
		return identifyNetworkController.identifyNetwork(entity);
	}
}