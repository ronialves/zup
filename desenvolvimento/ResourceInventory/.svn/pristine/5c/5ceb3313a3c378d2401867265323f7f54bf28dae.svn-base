package com.tlf.oss.resourceinventory.osp.core;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresource.FacilitiesException;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityRequest.InService;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources.Resource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.DetermineResourceAvailabilityResponse.QualifiedResources.Resource.Attributes.Tag;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.Message;
import com.tlf.oss.resourceinventory.osp.core.enums.ResourceEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.Warn;
import com.tlf.oss.resourceinventory.osp.core.mapper.OspRequestMapper;
import com.tlf.oss.resourceinventory.osp.core.service.AvailabilityService;
import com.tlf.oss.resourceinventory.osp.core.validation.AvailabilityRetrieval;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.ResourceInventoryWarn;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

@Logged
@RequestScoped
public class AvailabilityController extends ValidatorEntity {

	private static final String BLACKLIST = "blacklist";
	private static final BigInteger OK = BigInteger.ONE;

	@Inject
	protected OSSLogger logger;

	@Inject
	protected AvailabilityService availabilityService;

	private WsContext wsContext = new WsContext();

	public ResourceInventoryEntity availability(@AvailabilityRetrieval ResourceInventoryEntity entity)
			throws OSSBusinessException {

		DetermineResourceAvailabilityRequest request = createAvailabilityRequest(entity);
		DetermineResourceAvailabilityResponse response = null;

		try {
			response = availabilityService.determineResourceAvailability(request,	wsContext);
		} catch (FacilitiesException e) {
			logger.log(OSSLogger.ERROR, e.getMessage());
		}

		validateResult(response);

		if (hasCoverage(response)) {
    		if (isGpon(entity)) {
    			validateAvailabilityResultGpon(response, entity);
    		} else {
    			validateAvailabilityResultMetallic(response, entity);
    		}
		} else {
			throw new OSSBusinessException("Consulta Cobertura", Code.RIOSP_003.getValue(),
					Message.BUSINESS_ERROR_UNCOVERED_ADDRESS.getValue());
		}

		return createResponse(response, entity);
	}
	
	/**
	 * Metodo reponsavel por criar um request e enviar ao OSP.
	 * 
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	private DetermineResourceAvailabilityRequest createAvailabilityRequest(ResourceInventoryEntity entity) throws OSSBusinessException {

		DetermineResourceAvailabilityRequest determineResourceAvailability = new DetermineResourceAvailabilityRequest();
		InService inService = new InService();

		if (isClientActive(entity) && isMetallic(entity)) {
			inService.setCityCode(Integer.parseInt(entity.getAddress().getCnl()));
			inService.setIdentifier(getNetworkOwnerID(entity));
			determineResourceAvailability.setInService(inService);
		} else {
			determineResourceAvailability.setAddress(OspRequestMapper.parseAddress(entity.getAddress()));
		}

		wsContext.setRegionCode(entity.getAddress().getCnl());
		wsContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		return determineResourceAvailability;
	}

	private void validateResult(DetermineResourceAvailabilityResponse response) throws OSSBusinessException {
		if (response.getResult() == null || (response.getResult() != null && response.getResult().getCode() != 0)) {
			throw new OSSBusinessException("Consulta Facilidades", Code.RIOSP_002.getValue(),
					Message.BUSINESS_ERROR_ADDRESS.getValue());
		}
	}
	
	/**
	 * Metodo reponsavel por validar o retorno da consulta disponilidade gpon.
	 * 
	 * @param response
	 * @return
	 * @throws OSSBusinessException
	 */
	private void validateAvailabilityResultGpon(DetermineResourceAvailabilityResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		Optional<Resource> resource = hasGponResource(response);

		if (resource.isPresent()) {
			if (hasGponCoverage(response)) {
				if (!hasGponFeasability(response)) {
    				entity.setResourceInventoryWarn(determineWarning(response));
				}
			} else {
				throw new OSSBusinessException("Consulta Cobertura",
                    						   Code.RIOSP_003.getValue(),
                    						   Message.BUSINESS_ERROR_GPON_UNCOVERED_ADDRESS.getValue());
			}
		} else {
			throw new OSSBusinessException("Consulta Cobertura",
										   Code.RIOSP_003.getValue(),
										   Message.BUSINESS_ERROR_GPON_UNCOVERED_ADDRESS.getValue());
		}
	}

	/**
	 * Metodo reponsavel por validar o retorno da consulta disponilidade metalica.
	 * 
	 * @param response
	 * @throws OSSBusinessException
	 */
	private void validateAvailabilityResultMetallic(DetermineResourceAvailabilityResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {
		if ((null != response && "0" == response.getCoverage().toString()) || null == response.getResult()) {
			throw new OSSBusinessException("Consulta Cobertura no Endereço", Code.RIOSP_003.getValue(),
					Message.BUSINESS_UNCOVERED_ADDRESS.getValue());
		}
		if (null != response) {

			boolean hasMetallicTopology = response.getQualifiedResources().getResource().stream()
					.anyMatch(resource -> isMetallicTopology(resource));

			boolean hasResourceCoverage = response.getQualifiedResources().getResource().stream()
					.anyMatch(resource -> isResourceCoverage(resource));
			
			boolean hasMiniDslam = response.getQualifiedResources().getResource().stream()
					.anyMatch(resource -> isMiniDslam(resource));

			if (!hasMetallicFeasability(response)) {
    			entity.setResourceInventoryWarn(determineWarning(response));
			}

			if (!hasMetallicTopology || (hasMetallicTopology && !hasResourceCoverage) || (hasMetallicTopology && hasResourceCoverage && hasMiniDslam)) {
				throw new OSSBusinessException("Consulta Cobertura no Endereço", Code.RIOSP_003.getValue(),
						Message.BUSINESS_UNCOVERED_ADDRESS.getValue());
			}
		}
	}

	/**
	 * Metodo reponsavel por criar o response, seja metalico ou gpon.
	 * 
	 * @param response, entity
	 * @return
	 * @throws OSSBusinessException
	 */
	private ResourceInventoryEntity createResponse(DetermineResourceAvailabilityResponse response,
			ResourceInventoryEntity entity) throws OSSBusinessException {
		validateNetType(response, entity);
		return entity;
	}

	/**
	 * Metodo reponsavel por verificar o netType, se for 1 e metalico, se for 2
	 * gpon.
	 * 
	 * @param response, entity
	 * @throws OSSBusinessException
	 */
	private void validateNetType(DetermineResourceAvailabilityResponse response, ResourceInventoryEntity entity) {
		for (Resource resource : response.getQualifiedResources().getResource()) {
			if (resource.getNetType() != null
					&& (isMetallic(entity) && ResourceEnum.NetType_1.getValue() == resource.getNetType().intValue())) {
				updateEntity(resource, entity);
			}
			if (resource.getNetType() != null
					&& (isGpon(entity) && ResourceEnum.NetType_2.getValue() == resource.getNetType().intValue())) {
				updateEntity(resource, entity);
			}
		}
	}

	/**
	 * Metodo reponsavel por identificar a tecnologia e atualizar o entity.
	 * 
	 * @param response, entity
	 * @throws OSSBusinessException
	 */
	private void updateEntity(Resource resource, ResourceInventoryEntity entity) {
		Cabinet cabinet = getCabinet(entity);
		if (isGpon(entity)) {
			cabinet.setPrimaryCable(getValueTag(resource, "ALIM_CABLE_NUM"));
			cabinet.setPrimaryFiber(getValueTag(resource, "ALIM_FIBER_NUM"));
		} else {
			cabinet.setDistance(getValueTag(resource, "DISTANCE_TT_CEAS"));
			cabinet.setName(getValueTag(resource, "CABINET_CODE"));
			Shelf shelf = new Shelf();
			shelf.setTypeOfResource("MSAN".equalsIgnoreCase(getValueTag(resource, "HOUSING_TYPE"))
					|| "FTTC".equalsIgnoreCase(getValueTag(resource, "HOUSING_TYPE")) ? "MSAN" : "DSLAM");
			List<Shelf> shelves = new ArrayList<>();
			shelves.add(shelf);
			cabinet.setHasShelves(shelves);
			TerminalBox terminalBox = getTerminalBox(entity);
			terminalBox.setCableNumber(getValueTag(resource, "ALIM_CABLE_NUM"));
			terminalBox.setPairNumber(getValueTag(resource, "PRIMARY_PAIR"));
			cabinet.setTerminalBox(terminalBox);
		}
		entity.setCabinet(cabinet);
	}

	private String getValueTag(Resource resource, String label) {
		for (Tag tag : resource.getAttributes().getTag()) {
			if (label.equalsIgnoreCase(tag.getLabel())) {
				return tag.getValue();
			}
		}
		return null;
	}

	/**
	 * Metodo reponsavel por verificar se existe um cliente ativo.
	 * 
	 * @param entity
	 * @return
	 * @throws OSSBusinessException
	 */
	private boolean isClientActive(ResourceInventoryEntity entity) throws OSSBusinessException {
		// Caso o campo NetWorkOwnerId venham nulo, não iremos gerar
		// exceção, o processo
		// continua por endereço no metodo create request
		if (null != entity.getResourceFacingService()) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isResourceFeasibility(final Resource resource) {
	    return (resource.getResourceFeasibility() != null && resource.getResourceFeasibility().intValue() == 1);
	}

	/**
	 * Metodo reponsavel por validar se existe o cobertura gpon no
	 * endereco(NetType==2).
	 * 
	 * @param resource
	 * @return
	 * 
	 */
	private boolean isFiberTopology(Resource resource) {
		return (resource.getNetType() != null && resource.getNetType().intValue() == ResourceEnum.NetType_2.getValue());
	}

	/**
	 * Metodo reponsavel por validar se existe o disponibilidade metalica no
	 * endereco(NetType==1).
	 * 
	 * @param resource
	 * @return
	 * 
	 */
	private boolean isMetallicTopology(Resource resource) {
		return (resource.getNetType() != null && resource.getNetType().intValue() == ResourceEnum.NetType_1.getValue());
	}

	/**
	 * Metodo reponsavel por validar se existe o cobertura metalica no
	 * endereco(NetType==1 && ResourceCoverage==1).
	 * 
	 * @param resource
	 * @return
	 * 
	 */
	private boolean isResourceCoverage(Resource resource) {
		return (resource.getNetType() != null && (resource.getNetType().intValue() == ResourceEnum.NetType_1.getValue()
				&& resource.getResourceCoverage().intValueExact() == ResourceEnum.ResourceCoverage_1.getValue()));
	}
	
	/**
	 * Metodo responsavel por validar se a cobertura retornada pelo OSP para o endereço e de um armario mini dslam (nao utilizado pelo PSTN)
	 * 
	 * @param resource
	 * @return
	 */
	private boolean isMiniDslam(Resource resource) {
		return (isMetallicTopology(resource)
				&& (!"MSAN".equalsIgnoreCase(getValueTag(resource, "HOUSING_TYPE")) || !"FTTC".equalsIgnoreCase(getValueTag(resource, "HOUSING_TYPE")))
				&& "S".equalsIgnoreCase(getValueTag(resource, "MINI_DSLAM")));
	}

	private boolean hasCoverage(DetermineResourceAvailabilityResponse response) {
		return OK.equals(response.getCoverage());
	}

	private boolean hasMetallicCoverage(DetermineResourceAvailabilityResponse response) {
		Optional<Resource> metallicResource = hasMetallicResource(response);

		if (metallicResource.isPresent()) {
			return hasResourceCoverage(metallicResource.get());
		}

		return false;
	}

	private boolean hasGponCoverage(DetermineResourceAvailabilityResponse response) {
		Optional<Resource> gponResource = hasGponResource(response);

		if (gponResource.isPresent()) {
			return hasResourceCoverage(gponResource.get());
		}

		return false;
	}

	private boolean hasMetallicFeasability(DetermineResourceAvailabilityResponse response) {
		Optional<Resource> metallicResource = hasMetallicResource(response);

		if (metallicResource.isPresent()) {
			return hasResourceFeasability(metallicResource.get());
		}

		return false;
	}

	private boolean hasGponFeasability(DetermineResourceAvailabilityResponse response) {
		Optional<Resource> gponResource = hasGponResource(response);

		if (gponResource.isPresent()) {
			return hasResourceFeasability(gponResource.get());
		}

		return false;
	}

	private Optional<Resource> hasMetallicResource(DetermineResourceAvailabilityResponse response) {
		return hasResource(response, CircuitTypeEnum.METALICO);
	}

	private Optional<Resource> hasGponResource(DetermineResourceAvailabilityResponse response) {
		return hasResource(response, CircuitTypeEnum.GPON);
	}

	private Optional<Resource> hasResource(DetermineResourceAvailabilityResponse response, CircuitTypeEnum circuitType) {
		return response.getQualifiedResources()
                	   .getResource()
                	   .stream()
                	   .filter(resource -> circuitType.getCode().equals(resource.getNetType()))
                	   .findFirst();
	}

	private boolean hasResourceCoverage(Resource resource) {
		return OK.equals(resource.getResourceCoverage());
	}

	private boolean hasResourceFeasability(Resource resource) {
		return OK.equals(resource.getResourceFeasibility());
	}

	private ResourceInventoryWarn determineWarning(DetermineResourceAvailabilityResponse response) {
		ResourceInventoryWarn warn = new ResourceInventoryWarn();

		if(response.getMessages() != null && 
		   response.getMessages().getMessage() != null && 
		  !response.getMessages().getMessage().isEmpty() && 
		   response.getMessages().getMessage().stream()
											  .anyMatch(m -> null != m.getMessageCode() && m.getRuleName().toLowerCase().contains(BLACKLIST))) {
			warn.setCode(Warn.ENDERECO_BLOQUEADO.getCode());
			warn.setMessage(Warn.ENDERECO_BLOQUEADO.getMessage());
		} else {
			warn.setCode(Warn.ENDERECO_SATURADO.getCode());
			warn.setMessage(Warn.ENDERECO_SATURADO.getMessage());
		}

		return warn;
	}
}
