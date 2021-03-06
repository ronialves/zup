package com.tlf.oss.resourceinventory.tbs.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.resourceinventory.schemas.AtomicNetworkAddress;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.IPAddress;
import com.tlf.oss.resourceinventory.schemas.LogicalResource;
import com.tlf.oss.resourceinventory.schemas.LogicalResourceAssociation;
import com.tlf.oss.resourceinventory.schemas.NetworkAddressAssociation;
import com.tlf.oss.resourceinventory.schemas.NetworkRoute;
import com.tlf.oss.resourceinventory.schemas.NetworkRouteAssociation;
import com.tlf.oss.resourceinventory.schemas.PhysicalPort;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.ResourceCharacteristicSpecification;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.Shelf;
import com.tlf.oss.resourceinventory.schemas.SwitchesAssociated;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.tbs.core.validation.ValidatorEntity;
import com.tlf.oss.resourceinventory.tbs.entity.RetrieveAssignedTelNumEntity;
import com.tlf.oss.resourceinventory.tbs.entity.RetrieveEntity;
import com.tlf.oss.resourceinventory.tbs.entity.RetrieveNetworkLocationEntity;
import com.tlf.oss.resourceinventory.tbs.enums.RetrieveInfoType;
import com.tlf.oss.resourceinventory.tbs.repository.RetrieveRepository;

public class RetrieveController extends ValidatorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	public RetrieveRepository retrieveRepository;

	public ResourceInventoryEntity getRetrieve(ResourceInventoryEntity entity) throws OSSBusinessException {

		ResourceInventoryEntity result_CROSS_CONNECTION_INFO = null;
		ResourceInventoryEntity result_NETWORK_SYNC_INFO = null;
		ResourceInventoryEntity result_RANGE_CORPORATE = null;
		
		if (null != entity.getResourceOrder() && null != entity.getResourceOrder().getResourceOrderItem().getId() && 
			!"".equals(entity.getResourceOrder().getResourceOrderItem().getId())) {

			RetrieveEntity retrieveEntityCrossConnection = new RetrieveEntity();
			retrieveEntityCrossConnection.setDocumentNumber(Integer.valueOf(entity.getResourceOrder().getResourceOrderItem().getId()));
			retrieveEntityCrossConnection = retrieveRepository.getRetrieveCrossConnectionInfo(retrieveEntityCrossConnection);
			
			if (retrieveEntityCrossConnection.getErro() == 0) {				
				result_CROSS_CONNECTION_INFO = getResourceInventoryEntity(retrieveEntityCrossConnection, RetrieveInfoType.CROSS_CONNECTION_INFO);
			}
			
			RetrieveEntity retrieveEntityNetworkSync = null;
			
			if (null != entity.getResourceFacingService()) {
				if ((null != entity.getResourceOrder().getResourceOrderItem().getId()
						&& !"".equals(entity.getResourceOrder().getResourceOrderItem().getId()))
						&& (null != entity.getResourceFacingService().getStatus()
						&& !"".equals(entity.getResourceFacingService().getStatus()))) {
					
					retrieveEntityNetworkSync = new RetrieveEntity();
					retrieveEntityNetworkSync.setDocumentNumber(Integer.valueOf(entity.getResourceOrder().getResourceOrderItem().getId()));
					retrieveEntityNetworkSync.setCircuitActivityInd(entity.getResourceFacingService().getStatus());
					retrieveEntityNetworkSync = retrieveRepository.getRetrieveNetworkSyncInfo(retrieveEntityNetworkSync);
					
					if (retrieveEntityNetworkSync.getErro() == 0) {							
						result_NETWORK_SYNC_INFO = getResourceInventoryEntity(retrieveEntityNetworkSync, RetrieveInfoType.NETWORK_SYNC_INFO);
					}
				}
			}
			
			if (retrieveEntityCrossConnection.getErro() != 0 && 
			   (retrieveEntityNetworkSync == null || retrieveEntityNetworkSync.getErro() != 0)) {
				
				String msg =  RetrieveInfoType.CROSS_CONNECTION_INFO.toString() + ": " + retrieveEntityCrossConnection.getMsg() + 
						(retrieveEntityNetworkSync != null ? ("; " + RetrieveInfoType.NETWORK_SYNC_INFO.toString() + ": " + retrieveEntityNetworkSync.getMsg()) : "");
				
				throw new OSSBusinessException("ERRO: " + retrieveEntityCrossConnection.getErro(), "RITBS-001", "" + msg);
				
			}
		}else {
			if (null != entity.getCustomerOrder() && !"".equals(entity.getCustomerOrder().getPurchaseOrderNumber())) {
				String purchaseOrderNumber = entity.getCustomerOrder().getPurchaseOrderNumber();
				
				RetrieveAssignedTelNumEntity retrieveAssignedTelNumEntity = new RetrieveAssignedTelNumEntity();
				retrieveAssignedTelNumEntity = retrieveRepository.getRetrieveAssignedTelNumEntity(purchaseOrderNumber);
				
				String documentNumber = retrieveAssignedTelNumEntity.getDocumentNumber();
				
				RetrieveNetworkLocationEntity retrieveNetworkLocationEntity = new RetrieveNetworkLocationEntity();
				retrieveNetworkLocationEntity = retrieveRepository.getNetworkLocationEntity(purchaseOrderNumber, documentNumber);
				
				result_RANGE_CORPORATE = getResourceRangeCorporate(retrieveAssignedTelNumEntity, retrieveNetworkLocationEntity);
			}
		}

		return enrichResourceInventoryEntity(result_CROSS_CONNECTION_INFO, result_NETWORK_SYNC_INFO, result_RANGE_CORPORATE);
	}

	/**
	 * 
	 * @param retrieveAssignedTelNumEntity
	 * @param retrieveNetworkLocationEntity
	 * @return ResourceInventoryEntity
	 * @throws OSSBusinessException
	 */
	public ResourceInventoryEntity getResourceRangeCorporate(RetrieveAssignedTelNumEntity retrieveAssignedTelNumEntity, 
								RetrieveNetworkLocationEntity retrieveNetworkLocationEntity)
			throws OSSBusinessException {

		ResourceInventoryEntity result = createInstance();
		
		
		SwitchesAssociated switchesAssociated = new SwitchesAssociated();
		switchesAssociated.setName(retrieveNetworkLocationEntity.getCLLICode());
		
		result.getCabinet().setSwitchesAssociated(switchesAssociated);
		
		
		ServiceDescribedBy serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("DOCUMENT_NUMBER");
		ServiceSpecCharDescribes serviceSpecCharDescribesBy = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesBy.setValue(retrieveAssignedTelNumEntity.getDocumentNumber());
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribesBy);
		
		result.getCustomerFacingService().get(0).getServiceDescribedBy().add(serviceDescribedBy);
		
		
		serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("INITIAL_RANGE");
		serviceSpecCharDescribesBy = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesBy.setValue(retrieveAssignedTelNumEntity.getRangeInicial());
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribesBy);
		
		result.getCustomerFacingService().get(0).getServiceDescribedBy().add(serviceDescribedBy);
		
		
		serviceDescribedBy = new ServiceDescribedBy();
		serviceDescribedBy.setName("FINAL_RANGE");
		serviceSpecCharDescribesBy = new ServiceSpecCharDescribes();
		serviceSpecCharDescribesBy.setValue(retrieveAssignedTelNumEntity.getRangeFinal());
		serviceDescribedBy.getServiceSpecCharDescribes().add(serviceSpecCharDescribesBy);
		
		result.getCustomerFacingService().get(0).getServiceDescribedBy().add(serviceDescribedBy);
		
		return result;
		
	}

	
	
	public ResourceInventoryEntity getResourceInventoryEntity(RetrieveEntity entity, RetrieveInfoType retrieveInfoType)
			throws OSSBusinessException {

		ResourceInventoryEntity result = createInstance();

		if (retrieveInfoType == RetrieveInfoType.CROSS_CONNECTION_INFO) {
			result.getCabinet().getHasShelves().get(0).setSlotId(null != entity.getSlot() ? entity.getSlot() : null);
			result.getCabinet().getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).setId(null != entity.getPortaFisica() ? entity.getPortaFisica() : null);
			result.getCabinet().getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().get(0).getNetworkRouteAssociation().getNetworkRoute().get(0).setVirtualPort(String.valueOf(null != entity.getPortaLogica() ? entity.getPortaLogica() : null));
			result.getCabinet().getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().get(0).getNetworkRouteAssociation().getNetworkRoute().get(0).setType("VOZ");

			if(entity.getVendorName() != null) {
				
				boolean alreadyHasVendor = false;
				
				if (result.getCabinet() != null && result.getCabinet().getHasShelves() != null && 
					result.getCabinet().getHasShelves().size() > 0 && 
					result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications() != null) {
					
					for (ResourceCharacteristicSpecification spec : result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications()) {
						if ("VENDOR".equals(spec.getId())) {
							alreadyHasVendor = true;
							break;
						}
					} 
				}
				if (!alreadyHasVendor) {					
					ResourceCharacteristicSpecification rce = new ResourceCharacteristicSpecification();
					rce.setId("VENDOR");
					rce.setValue(null != entity.getVendorName() ? entity.getVendorName() : null);
					result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(rce);
				}
			}

			if(null != entity.getV5id()) {
				ResourceCharacteristicSpecification rce = new ResourceCharacteristicSpecification();
				rce.setId("V5ID_VOZ");
				rce.setValue(null != entity.getV5id() ? entity.getV5id() : null);
				result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(rce);
			}
			result.getCabinet().setFeederCable(null != entity.getTributario() ? entity.getTributario() : null);
			result.getResourceFacingService().setStatus(null != entity.getCircuitActivityInd() ? entity.getCircuitActivityInd() : null);

		} else if (retrieveInfoType == RetrieveInfoType.NETWORK_SYNC_INFO) {
			result.getCabinet().getHasShelves().get(0).setSlotId(null != entity.getSlot() ? entity.getSlot() : null);
			result.getCabinet().getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).setId(null != entity.getPortaFisica() ? entity.getPortaFisica() : null);
			result.getCabinet().getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().get(0).getNetworkRouteAssociation().getNetworkRoute().get(0).setVirtualPort(String.valueOf(null != entity.getPortaLogica() ? entity.getPortaLogica() : null));
			result.getCabinet().getHasShelves().get(0).getHasCards().get(0).getContainsPorts().get(0).getLogicalResourceAssociation().getLogicalResource().get(0).getNetworkRouteAssociation().getNetworkRoute().get(0).setType("INTERNET");
			if(null != entity.getV5id()) {
				ResourceCharacteristicSpecification rce = new ResourceCharacteristicSpecification();
				rce.setId("V5ID_DADOS");
				rce.setValue(null != entity.getV5id() ? entity.getV5id() : null);
				result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(rce);
			}
			result.getCabinet().getHasShelves().get(0).getHasCards().get(0).setModel(null != entity.getModeloPlaca() ? entity.getModeloPlaca() : null);
			if(null != entity.getNameDslam()) {
				result.getCabinet().getHasShelves().get(0).getNetworkAddressAssociation().getAtomicNetworkAddress().setHostname(null != entity.getNameDslam() ? entity.getNameDslam() : null);
			}
			if(null != entity.getRin()) {
				LogicalResourceAssociation lra = new LogicalResourceAssociation();
				List<LogicalResource> lrs = new ArrayList<LogicalResource>();
				LogicalResource lr = new LogicalResource();
				NetworkRouteAssociation nra = new NetworkRouteAssociation();
				List<NetworkRoute> nrs = new ArrayList<NetworkRoute>();
				NetworkRoute nr = new NetworkRoute();
				nrs.add(nr);
				nra.getNetworkRoute().addAll(nrs);
				lr.setNetworkRouteAssociation(nra);
				lrs.add(lr);
				lra.getLogicalResource().addAll(lrs);
				result.getCabinet().getHasShelves().get(0).setLogicalResourceAssociation(lra);
				result.getCabinet().getHasShelves().get(0).getLogicalResourceAssociation().getLogicalResource().get(0).getNetworkRouteAssociation().getNetworkRoute().get(0).setVlanId(null != entity.getRin() ? entity.getRin() : null);
			}
			if(null != entity.getSvlan()) {
				ResourceCharacteristicSpecification rce = new ResourceCharacteristicSpecification();
				rce.setId("SVLAN");
				rce.setValue(null != entity.getSvlan() ? entity.getSvlan() : null);
				result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(rce);
			}

			if(null != entity.getSvlan()) {
				ResourceCharacteristicSpecification rce = new ResourceCharacteristicSpecification();
				rce.setId("CVLAN");
				rce.setValue(null != entity.getCvlan() ? entity.getCvlan() : null);
				result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(rce);
			}

			ServiceDescribedBy sdb = new ServiceDescribedBy();
			sdb.setName("BROADBANDVELOCITY");
			result.getResourceFacingService().getServiceDescribedBy().add(sdb);

			if(null != entity.getDownstream()) {
				ServiceSpecCharDescribes sscd = new ServiceSpecCharDescribes();
				sscd.setId("DOWNLOAD");
				sscd.setValue(null != entity.getDownstream() ? entity.getDownstream() :null);
				result.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().add(sscd);
			}
			if(null != entity.getUpstream()) {
				ServiceSpecCharDescribes sscd = new ServiceSpecCharDescribes();
				sscd.setId("UPLOAD");
				sscd.setValue(null != entity.getUpstream() ? entity.getUpstream() :null);
				result.getResourceFacingService().getServiceDescribedBy().get(0).getServiceSpecCharDescribes().add(sscd);
			}
			if(entity.getVendorName() != null) {
				
				boolean alreadyHasVendor = false;
				
				if (result.getCabinet() != null && result.getCabinet().getHasShelves() != null && 
					result.getCabinet().getHasShelves().size() > 0 && 
					result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications() != null) {
					
					for (ResourceCharacteristicSpecification spec : result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications()) {
						if ("VENDOR".equals(spec.getId())) {
							alreadyHasVendor = true;
							break;
						}
					} 
				}
				if (!alreadyHasVendor) {					
					ResourceCharacteristicSpecification rce = new ResourceCharacteristicSpecification();
					rce.setId("VENDOR");
					rce.setValue(null != entity.getVendorName() ? entity.getVendorName() : null);
					result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().add(rce);
				}
			}
		}

		result.getResourceOrder().getResourceOrderItem().setId(null != entity.getDocumentNumber() ? String.valueOf(entity.getDocumentNumber()) : null);
		result.getCabinet().getHasShelves().get(0).setTypeOfResource(null != entity.getTypeOfResource() ? entity.getTypeOfResource() : null);
		result.getResourceOrder().getResourceOrderItem().setId(null != String.valueOf(entity.getDocumentNumber()) ? String.valueOf(entity.getDocumentNumber()) : null);
		result.getCabinet().getHasShelves().get(0).getIpController().setNetworkNumber(null != entity.getIpAddress() ? entity.getIpAddress() : null);
		result.getResourceFacingService().setServiceId(null != entity.getInstancia() ? entity.getInstancia() : null);

		return result;
	}

	/**
	 * Cria uma instancia do ResourceInventoryEntity para retorno
	 * 
	 * @return ResourceInventoryEntity
	 */
	private ResourceInventoryEntity createInstance() {
		
		ResourceInventoryEntity result = new ResourceInventoryEntity();

		ResourceOrder resourceOrder = new ResourceOrder();
		ResourceOrderItem resourceOrderItem = new ResourceOrderItem();
		resourceOrder.setResourceOrderItem(resourceOrderItem);
		result.setResourceOrder(resourceOrder);

		Cabinet cabinet = new Cabinet();
		List<Shelf> hasShelves = new ArrayList<Shelf>();
		Shelf shelf = new Shelf();
		NetworkAddressAssociation networkAddressAssociation = new NetworkAddressAssociation();
		AtomicNetworkAddress atomicNetworkAddress = new AtomicNetworkAddress();
		List<ResourceCharacteristicSpecification> resourceCharacteristicSpecifications = new ArrayList<ResourceCharacteristicSpecification>();
		IPAddress ipController = new IPAddress();
		List<PortAdapterCard> hasCards = new ArrayList<PortAdapterCard>();
		PortAdapterCard portAdapterCard = new PortAdapterCard();
		List<PhysicalPort> containsPorts = new ArrayList<PhysicalPort>();
		PhysicalPort physicalPort = new PhysicalPort();
		LogicalResourceAssociation logicalResourceAssociation = new LogicalResourceAssociation();
		List<LogicalResource> logicalResources = new ArrayList<LogicalResource>();
		LogicalResource LogicalResource = new LogicalResource();
		NetworkRouteAssociation networkRouteAssociation = new NetworkRouteAssociation();
		List<NetworkRoute> networkRoutes = new ArrayList<NetworkRoute>();
		NetworkRoute networkRoute = new NetworkRoute();
		networkRoutes.add(networkRoute);
		networkRouteAssociation.getNetworkRoute().addAll(networkRoutes);
		LogicalResource.setNetworkRouteAssociation(networkRouteAssociation);
		logicalResources.add(LogicalResource);
		logicalResourceAssociation.getLogicalResource().addAll(logicalResources);
		physicalPort.setLogicalResourceAssociation(logicalResourceAssociation);
		containsPorts.add(physicalPort);
		portAdapterCard.setContainsPorts(containsPorts);
		hasCards.add(portAdapterCard);
		shelf.setIpController(ipController);
		shelf.setHasCards(hasCards);
		shelf.setResourceCharacteristicSpecifications(resourceCharacteristicSpecifications);
		networkAddressAssociation.setAtomicNetworkAddress(atomicNetworkAddress);
		shelf.setNetworkAddressAssociation(networkAddressAssociation);
		shelf.setLogicalResourceAssociation(logicalResourceAssociation);
		hasShelves.add(shelf);
		cabinet.setHasShelves(hasShelves);
		result.setCabinet(cabinet);
		
		ResourceFacingService resourceFacingService = new ResourceFacingService();
		List<ServiceDescribedBy> listServiceDescribedBy = new ArrayList<ServiceDescribedBy>();
		resourceFacingService.setServiceDescribedBy(listServiceDescribedBy);
		result.setResourceFacingService(resourceFacingService);
		
		CustomerFacingService customerFacingService = new CustomerFacingService();
		List<CustomerFacingService> listCustomerFacingService = new ArrayList<CustomerFacingService>();
		listCustomerFacingService.add(customerFacingService);
		
		result.setCustomerFacingService(listCustomerFacingService);
		
		return result;
	}
	
	
	
	private ResourceInventoryEntity enrichResourceInventoryEntity(ResourceInventoryEntity result_CROSS_CONNECTION_INFO, 
					ResourceInventoryEntity result_NETWORK_SYNC_INFO, ResourceInventoryEntity result_RANGE_CORPORATE) {
		
		ResourceInventoryEntity result = null;
		
		if (result_CROSS_CONNECTION_INFO != null) {
			result = result_CROSS_CONNECTION_INFO;

			if (null != result_NETWORK_SYNC_INFO) {
				result.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications().addAll(result_NETWORK_SYNC_INFO.getCabinet().getHasShelves().get(0).getResourceCharacteristicSpecifications());
				result.getCabinet().getHasShelves().get(0).getHasCards().add(result_NETWORK_SYNC_INFO.getCabinet().getHasShelves().get(0).getHasCards().get(0));
				result.getCabinet().getHasShelves().get(0).setLogicalResourceAssociation(result_NETWORK_SYNC_INFO.getCabinet().getHasShelves().get(0).getLogicalResourceAssociation());
				
				result.getResourceFacingService().setServiceDescribedBy(result_NETWORK_SYNC_INFO.getResourceFacingService().getServiceDescribedBy());
			}
		} else if (result_NETWORK_SYNC_INFO != null){
			result = result_NETWORK_SYNC_INFO;
		}else {
			result = result_RANGE_CORPORATE;
		}			
		
		return result;
	}
	
}
