package com.tlf.oss.resourceinventory.scqla.core;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.interceptor.annotation.Logged;
import com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidade.ScqlaRequest;
import com.tlf.oss.resourceinventory.generated.scqla.ConsultarFacilidadeResponse.ConsultaFacilidadeResponse;
import com.tlf.oss.resourceinventory.generated.scqla.EnderecoType;
import com.tlf.oss.resourceinventory.generated.scqla.TerminalType;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.TerminalBox;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.scqla.core.enums.EntityFields;
import com.tlf.oss.resourceinventory.scqla.core.service.AvailabilityRetrievalService;
import com.tlf.oss.resourceinventory.scqla.core.validation.Retrieval;
import com.tlf.oss.resourceinventory.scqla.core.validation.ValidatorEntity;

@Logged
@RequestScoped
public class RetrievalController extends ValidatorEntity {

	@Inject
	private AvailabilityRetrievalService service;

	public ResourceInventoryEntity retrieval(@Retrieval ResourceInventoryEntity entity) throws OSSBusinessException {
		ScqlaRequest request = createRequest(entity);

		ConsultaFacilidadeResponse response = service.consultarFacilidade(request);
		
		updateEntity(response, entity);
		
		return entity;
	}

	private ScqlaRequest createRequest(ResourceInventoryEntity entity) throws NumberFormatException, OSSBusinessException{
		ScqlaRequest scqlaRequest = new ScqlaRequest();
		EnderecoType enderecoType = new EnderecoType();

		if(isClientActive(entity)){
			TerminalType terminalType = new TerminalType();
			terminalType.setDdd(Integer.parseInt(getTelephoneDDD(entity)));
			terminalType.setTelefone(Integer.parseInt(getNetworkOwnerID(entity)));
			scqlaRequest.setTerminal(terminalType);
		} else{		
			enderecoType.setAt(entity.getAddress().getTelephonicArea());
			enderecoType.setCodigoLogradouro(entity.getAddress().getStreetCode());
			enderecoType.setNumeroLogradouro(entity.getAddress().getStreetNrFirst());
			enderecoType.setCnl(Integer.parseInt(entity.getAddress().getCnl()));
			scqlaRequest.setEndereco(enderecoType);
		}		

		scqlaRequest.setEndereco(enderecoType);
		return scqlaRequest;
	}

	private void updateEntity(ConsultaFacilidadeResponse response, ResourceInventoryEntity entity) throws OSSBusinessException {
		if(null == response || null == response.getRedeMetalica() || 
				null == response.getRedeMetalica().getIdentificadorMsan()) {
			throw new OSSBusinessException("Consulta Cobertura no Endereço", "RISCQLA-003", "Sem cobertura de Rede Metálica");
		}
		
		Cabinet cabinet = getCabinet(entity);		
		TerminalBox terminalBox = getTerminalBox(entity);

		cabinet.setDistance(response.getRedeMetalica().getDistanciaTotal() != null ? response.getRedeMetalica().getDistanciaTotal() : null);
		cabinet.setName(response.getRedeMetalica().getArmario() != null ? response.getRedeMetalica().getArmario() : null);

		Shelf shelf = new Shelf();
		shelf.setTypeOfResource("S".equalsIgnoreCase(response.getRedeMetalica().getIdentificadorMsan()) ? "MSAN" : "DSLAM");

		List<Shelf> shelves = new ArrayList<>();
		shelves.add(shelf);	
		cabinet.setHasShelves(shelves);

		if (response.getRedeMetalica().getCaboPrimario() != null) {
			terminalBox.setCableNumber(response.getRedeMetalica().getCaboPrimario());
			cabinet.setTerminalBox(terminalBox);
		}

		if (response.getRedeMetalica().getParPrimario() != null) {
			terminalBox.setPairNumber(response.getRedeMetalica().getParPrimario());
			cabinet.setTerminalBox(terminalBox);
		}

		entity.setCabinet(cabinet);
		entity.getCabinet().setTerminalBox(terminalBox);
	}
	

	private Cabinet getCabinet(ResourceInventoryEntity entity) {
		if (entity.getCabinet() != null) {
			return entity.getCabinet();
		} 
		return new Cabinet();
	}

	private TerminalBox getTerminalBox(ResourceInventoryEntity entity) {
		if (entity.getCabinet() != null && entity.getCabinet().getTerminalBox() != null) {
			return entity.getCabinet().getTerminalBox();
		}
		return new TerminalBox();
	}

	private String getNetworkOwnerID(ResourceInventoryEntity entity) throws OSSBusinessException {
		ResourceFacingService rfsNetworkOwner = getResourceFacingService(entity, EntityFields.NETWORKOWNERID.getValue());
		return rfsNetworkOwner.getServiceDescribedBy().get(0).getServiceSpecCharDescribes().get(0).getValue().substring(5, 13);
	}

	private String getTelephoneDDD(ResourceInventoryEntity entity) throws OSSBusinessException {
		CustomerFacingService cfsTelephone = getCustomerFacingService(entity, EntityFields.TELEPHONE.getValue());
		return cfsTelephone.getServiceId().substring(0, 2);
	}

	/**
	 * Metodo para validar os objetos de uma consulta sobre cliente ativo.
	 * @param entity
	 * @return
	 * @throws OSSBusinessException 
	 */
	private boolean isClientActive(ResourceInventoryEntity entity) throws OSSBusinessException{
		//Caso os campos NetWorkOwnerId e Telephone venham nulos, não iremos gerar exceção, o processo
		//continua por endereço no metodo create request
		if(null != entity.getResourceFacingService() && null != entity.getCustomerFacingService()){
			return true;
		} else {
			return false;
		}

	}
}
