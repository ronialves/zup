package com.tlf.oss.resourceinventory.cpe.utils;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.tlf.oss.resourceinventory.cpe.enums.RoiAction;
import com.tlf.oss.resourceinventory.cpe.enums.TipoRfs;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.Resource;
import com.tlf.oss.resourceinventory.schemas.ResourceFacingService;
import com.tlf.oss.resourceinventory.schemas.ResourceOrder;
import com.tlf.oss.resourceinventory.schemas.ResourceOrderItem;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.ServiceSpecCharDescribes;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public abstract class EntityExtractor {

	public static Optional<ResourceFacingService> extractRfs(ResourceInventoryEntity entity) {
		return Optional.ofNullable(entity.getResourceFacingService());
	}

	public static Optional<List<CustomerFacingService>> extractCfs(ResourceInventoryEntity entity) {
		return Optional.ofNullable(entity.getCustomerFacingService());
	}

	public static String extractServiceIdFromCfs(ResourceInventoryEntity entity) {
		Optional<List<CustomerFacingService>> cfs = extractCfs(entity);
		String serviceID = null;

		if (cfs.isPresent()) {
			serviceID = cfs.get().get(0).getServiceId();
		}

		return serviceID;
	}

	public static String extractServiceIdFromRfs(ResourceInventoryEntity entity) {
		Optional<ResourceFacingService> rfs = extractRfs(entity);
		String serviceID = null;

		if (rfs.isPresent()) {
			serviceID = rfs.get().getServiceId();
		}

		return serviceID;
	}

	public static Optional<List<ResourceFacingService>> extractRfsOfCfs(ResourceInventoryEntity entity) {
		Optional<List<CustomerFacingService>> cfs = extractCfs(entity);
		List<ResourceFacingService> rfs = null;

		if (cfs.isPresent()) {
			rfs = cfs.get().get(0).getResourceFacingService();
		}

		return Optional.ofNullable(rfs);
	}

	public static Optional<ResourceOrder> extractResourceOrder(ResourceInventoryEntity entity) {
		return Optional.ofNullable(entity.getResourceOrder());
	}

	public static ResourceOrderItem extractResourceOrderItem(ResourceInventoryEntity entity) {
		Optional<ResourceOrder> ro = extractResourceOrder(entity);
		ResourceOrderItem roi = null;

		if (ro.isPresent()) {

			roi = ro.get().getResourceOrderItem();
		}

		return roi;
	}

	public static String extractResourceOrderItemName(ResourceInventoryEntity entity) {
		ResourceOrderItem roi = extractResourceOrderItem(entity);

		String name = null;

		if (roi != null) {
			name = roi.getName();
		}

		return name;
	}

	public static String extractServiceId(ResourceInventoryEntity entity) {
		String serviceId;

		if (TipoRfs.VOIP.getRoiName().equalsIgnoreCase(extractResourceOrderItemName(entity))) {
			// No cenário de VOIP, o serviceId a buscar está dentro da estrutura
			// CFS/RFS[category = TELEPHONE]
			serviceId = extractTelephoneRfs(entity).get().getServiceId();
		} else {
			// Para Banda (ACCESS) e TV (STB), o serviceId está na estrutura CFS
			serviceId = extractServiceIdFromCfs(entity);
		}

		return serviceId;
	}

	public static String extractAccessId(ResourceInventoryEntity entity) {
		return entity.getResourceFacingService().getServiceId();
	}

	public static Optional<ResourceFacingService> extractTelephoneRfs(ResourceInventoryEntity entity,
			RoiAction action) {

		final Optional<List<ResourceFacingService>> rfsOfCfs = extractRfsOfCfs(entity);
		if (rfsOfCfs.isPresent()) {
			final List<ResourceFacingService> rfsList = rfsOfCfs.get();

			return rfsList.stream().filter(defineTelephoneRfsPredicate(action)).findFirst();
		}
		return Optional.ofNullable(null);
	}

	public static String extractTelephoneNumber(ResourceFacingService rfs) {
		Optional<ServiceDescribedBy> sdb = rfs.getServiceDescribedBy().stream()
				.filter(service -> CpeConstants.TELEPHONE_NUMBER.equalsIgnoreCase(service.getName())).findFirst();

		if (sdb.isPresent()) {
			return sdb.get().getServiceSpecCharDescribes().get(0).getValue();
		}

		return null;
	}

	public static Optional<ServiceSpecCharDescribes> extractValueFromSdb(List<ServiceDescribedBy> sdbList,
			String name) {
		ServiceSpecCharDescribes sdbReturn = null;

		Optional<ServiceDescribedBy> sdbOpt = sdbList.stream().filter(sdb -> name.equalsIgnoreCase(sdb.getName()))
				.findFirst();
		if (sdbOpt.isPresent()) {
			sdbReturn = sdbOpt.get().getServiceSpecCharDescribes().get(0);
		}

		return Optional.ofNullable(sdbReturn);
	}

	public static Optional<ServiceSpecCharDescribes> extractMacAddress(ResourceInventoryEntity entity) {
		List<CustomerFacingService> cfsList = extractCfs(entity).get();
		List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();

		return extractValueFromSdb(sdbList, CpeConstants.MACADDRESS);
	}

	public static Optional<ServiceSpecCharDescribes> extractGponSerialNumber(ResourceInventoryEntity entity) {
		List<CustomerFacingService> cfsList = extractCfs(entity).get();
		List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();

		return extractValueFromSdb(sdbList, CpeConstants.GPON_SERIAL_NUMBER);
	}

	public static Optional<ServiceSpecCharDescribes> extractSerialNumber(ResourceInventoryEntity entity) {
		List<CustomerFacingService> cfsList = extractCfs(entity).get();
		List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();

		return extractValueFromSdb(sdbList, CpeConstants.SERIAL_NUMBER);
	}

	public static Optional<ServiceSpecCharDescribes> extractCasn(ResourceInventoryEntity entity) {
		List<CustomerFacingService> cfsList = extractCfs(entity).get();
		List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();

		return extractValueFromSdb(sdbList, CpeConstants.CASN);
	}

	public static Optional<ServiceSpecCharDescribes> extractModel(ResourceInventoryEntity entity) {
		List<CustomerFacingService> cfsList = extractCfs(entity).get();
		List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();

		return extractValueFromSdb(sdbList, CpeConstants.EQUIPMENT_MODEL);
	}

	public static Optional<ServiceSpecCharDescribes> extractVendor(ResourceInventoryEntity entity) {
		List<CustomerFacingService> cfsList = extractCfs(entity).get();
		List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();

		return extractValueFromSdb(sdbList, CpeConstants.EQUIPMENT_VENDOR);
	}

	public static String extractNetworkOwner(ResourceInventoryEntity entity) {
		return entity.getAddress().getNetworkOwner();
	}

	public static Optional<List<ServiceDescribedBy>> extractSdbFromCfs(CustomerFacingService cfs) {
		return Optional.ofNullable(cfs.getServiceDescribedBy());
	}

	public static Optional<List<ServiceDescribedBy>> extractSdbFromRfs(ResourceFacingService rfs) {
		return Optional.ofNullable(rfs.getServiceDescribedBy());
	}

	public static String extractResourceOrderItemAction(ResourceInventoryEntity entity) {
		return entity.getResourceOrder().getResourceOrderItem().getAction();
	}

	public static Optional<ResourceFacingService> extractTelephoneRfs(ResourceInventoryEntity entity) {

		return extractTelephoneRfs(entity, null);
	}

	private static Predicate<ResourceFacingService> defineTelephoneRfsPredicate(final RoiAction action) {
		return null == action ? rfs -> CpeConstants.TELEPHONE.equalsIgnoreCase(rfs.getCategory())
				: rfs -> CpeConstants.TELEPHONE.equalsIgnoreCase(rfs.getCategory())
						&& action.getAction().equalsIgnoreCase(rfs.getAction());
	}

	public static Optional<ServiceSpecCharDescribes> extractIptvCeaseType(ResourceInventoryEntity entity) {

		List<CustomerFacingService> cfsList = extractCfs(entity).get();
		
		List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();

		return extractValueFromSdb(sdbList, CpeConstants.IPTV_CEASE_TYPE);
	}
	
	public static Optional<ServiceSpecCharDescribes> extractVoiceTotalPorts(ResourceInventoryEntity entity) {
	    List<CustomerFacingService> cfsList = extractCfs(entity).get();
	    List<ServiceDescribedBy> sdbList = extractSdbFromCfs(cfsList.get(0)).get();
	 
	    return extractValueFromSdb(sdbList, CpeConstants.VOICE_TOTAL_PORTS);
	}

	public static Optional<Resource> extractResource(ResourceInventoryEntity entity) {
		return Optional.ofNullable(entity.getResource());
	}

	public static String extractStateOfResource(ResourceInventoryEntity entity) {
		Optional<Resource> resourceOpt = extractResource(entity);

		if (resourceOpt.isPresent()) {
			Resource resource = resourceOpt.get();

			if (null != resource.getStateOfResource() && !resource.getStateOfResource().isEmpty()) {
				return resource.getStateOfResource();
			}
		}

		return null;
	}
}
