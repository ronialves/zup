package com.tlf.oss.resourceinventory.osp.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.circuitlottypes.CircuitLotAllocate;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceRequest;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.facilities.allocateinstallresourcetypes.AllocateInstallResourceResponse;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.headercontext.WsContext;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.inicialresourcetypes.InicialResource;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.resourceserviceinfotypes.ResourceService;
import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.supplementaryinformationallocatetypes.SupplementaryInformationIn;
import com.tlf.oss.resourceinventory.osp.core.enums.CircuitTypeEnum;
import com.tlf.oss.resourceinventory.osp.core.enums.Code;
import com.tlf.oss.resourceinventory.osp.core.enums.OSPWSName;
import com.tlf.oss.resourceinventory.osp.core.service.AllocateService;
import com.tlf.oss.resourceinventory.osp.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.osp.factory.OssBusinessExceptionFactory;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PhysicalLink;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public class AllocateGponController extends ValidatorEntity {

	@Inject
	protected OSSLogger logger;

	@Inject
	protected AllocateService allocateService;

	/**
	 * Classe responsavel por controlar a requisicao entre o recurso disponivel e o
	 * servico exposto.
	 * 
	 * @param entity Entidade representando os valores de requisicao
	 * @return ResourceInventoryEntity Entidade representando os valores da resposta
	 * @throws OSSBusinessException excecao lancada em caso de erro ao invocar
	 *                              AllocateService
	 */
	public ResourceInventoryEntity allocate(ResourceInventoryEntity entity) throws OSSBusinessException {

		logDebug("Start - AllocateGponController");
		WsContext headerContext = new WsContext();
		headerContext.setRegionCode(entity.getAddress().getCnl());
		headerContext.setCentralOffice(entity.getAddress().getTelephonicArea());

		try {
			logInfo("Criando requisicao para AllocateGponService");
			AllocateInstallResourceRequest request = createRequest(entity);

			logInfo("Invocando AllocateService");
			AllocateInstallResourceResponse allocateInstallResourceResponse = allocateService.allocateResource(request,
					headerContext);

			logInfo("Atualizando resposta recebida do servico AllocateService");
			updateEntity(allocateInstallResourceResponse, entity);

		} catch (Exception e) {
			throw OssBusinessExceptionFactory.getOSSBusinessException(e, OSPWSName.AllocateInstallResource);
		}

		logDebug("End - AllocateGponController");
		return entity;
	}

	private AllocateInstallResourceRequest createRequest(ResourceInventoryEntity entity) throws OSSBusinessException {

		AllocateInstallResourceRequest allocateInstallResourceRequest = new AllocateInstallResourceRequest();

		allocateInstallResourceRequest.setReserveOrder(getNRC(entity));
		allocateInstallResourceRequest.setSupplementaryInformation(new SupplementaryInformationIn());
		allocateInstallResourceRequest.getSupplementaryInformation().setResourceService(new ResourceService());
		allocateInstallResourceRequest.getSupplementaryInformation().getResourceService()
				.setIdentifier(getServiceID(entity));
		allocateInstallResourceRequest.setResourceOrder(entity.getCustomerOrder().getPurchaseOrderNumber());
		allocateInstallResourceRequest.setCircuitId(getServiceID(entity));
		if (entity.getAddress() != null && entity.getAddress().getPlacePhysicalResourceAssoc() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null && entity.getAddress()
						.getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology() != null) {

			allocateInstallResourceRequest.setCircuitType(CircuitTypeEnum.parse(
					entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink().getAccessTechnology()));
		} else {
			if (entity.getPhysicalLinks() != null && !entity.getPhysicalLinks().isEmpty()
					&& entity.getPhysicalLinks().get(0).getAccessTechnology() != null) {

				allocateInstallResourceRequest
						.setCircuitType(CircuitTypeEnum.parse(entity.getPhysicalLinks().get(0).getAccessTechnology()));
			}
		}

		return allocateInstallResourceRequest;
	}

	private String getServiceID(ResourceInventoryEntity entity) throws OSSBusinessException {
		Optional<String> serviceID = Optional.ofNullable(entity.getResourceFacingService().getServiceId());
		if (serviceID.filter(d -> d.isEmpty()).isPresent()) {
			throw new OSSBusinessException("Erro ao validar o objeto ReserveResourceService", Code.RIOSP_001.getValue(),
					"O valor do campo serviceId eh nulo");
		}

		return serviceID.get();
	}

	private void updateEntity(AllocateInstallResourceResponse response, ResourceInventoryEntity entity)
			throws OSSBusinessException {

		if (response.getResult() != null && response.getResult().getCode() != 0) {
			final String code = String.valueOf(response.getResult().getErrorCode());
			final String description = String.valueOf(response.getResult().getDescription());
			final OSPWSName serviceOperation = OSPWSName.AllocateInstallResource;
			throw OssBusinessExceptionFactory.getFalloutOSSBusinessException(code, description, serviceOperation);
		}

		PhysicalLink physicalLink = (entity.getAddress() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc() != null
				&& entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink() != null)
						? entity.getAddress().getPlacePhysicalResourceAssoc().getPhysicalLink()
						: new PhysicalLink();

		Cabinet cabinet = entity.getCabinet() != null ? entity.getCabinet() : new Cabinet();

		TerminalBox terminalBox = (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null)
				? entity.getCabinet().getTerminalBox()
				: new TerminalBox();

		response.getInformations().forEach(info -> {

			physicalLink.setAccessTechnology(CircuitTypeEnum.parse(info.getCircuitType()));

			List<CircuitLotAllocate> circuits = new ArrayList<>();
			if (info.getRelatedCircuits().getCircuit() != null && !info.getRelatedCircuits().getCircuit().isEmpty()) {
				circuits = info.getRelatedCircuits().getCircuit();
			}

			if (circuits != null && !circuits.isEmpty()) {
				circuits.forEach(circuit -> {

					getRelatedInicialResources(cabinet, terminalBox, circuit, entity);

				});
			}
		});

		entity.setCabinet(cabinet);
		entity.getCabinet().setTerminalBox(terminalBox);
	}

	private String getNRC(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNrc = getResourceFacingService(entity, "NRC");
		return rfsNrc.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue();
	}

	private void getRelatedInicialResources(Cabinet cabinet, TerminalBox terminalBox, CircuitLotAllocate circuit,
			ResourceInventoryEntity entity) {
		List<InicialResource> inicialResources = new ArrayList<>();

		if (circuit.getResources() != null && (circuit.getResources().getRelatedInicialResources() != null
				&& !circuit.getResources().getRelatedInicialResources().isEmpty())) {
			inicialResources = circuit.getResources().getRelatedInicialResources();
		}

		if (inicialResources != null && !inicialResources.isEmpty()) {
			inicialResources.forEach(inicialResource -> {

				cabinet.setPrimaryCable(inicialResource.getInitialLogicalCable().getCode() != null
						? inicialResource.getInitialLogicalCable().getCode()
						: null);
				cabinet.setPrimaryFiber(String.valueOf(inicialResource.getInitialLogicalCable().getLogicalUnit()));
			});
		}
	}

	private void logInfo(String message) {
		logger.log(OSSLogger.INFO, message);
	}

	private void logDebug(String message) {
		logger.log(OSSLogger.DEBUG, message);
	}
}
