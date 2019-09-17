package com.tlf.oss.resourceinventory.granite.core.utils;

import java.util.List;
import java.util.Optional;

import com.tlf.oss.resourceinventory.granite.core.enums.ProductType;
import com.tlf.oss.resourceinventory.granite.core.enums.VelocityType;
import com.tlf.oss.resourceinventory.schemas.CustomerFacingService;
import com.tlf.oss.resourceinventory.schemas.ServiceDescribedBy;
import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;

public abstract class RIEntityGraniteUtils {

	public static Optional<CustomerFacingService> retrieveBroadband(ResourceInventoryEntity entity) {
		return retrieveCfs(entity, ProductType.BROADBAND);
	}

	public static Optional<CustomerFacingService> retrieveIptv(ResourceInventoryEntity entity) {
		return retrieveCfs(entity, ProductType.IPTV);
	}

	public static Optional<CustomerFacingService> retrieveVoIp(ResourceInventoryEntity entity) {
		return retrieveCfs(entity, ProductType.VOIP);
	}

	public static Optional<CustomerFacingService> retrieveCfs(ResourceInventoryEntity entity, ProductType productType) {
		return entity.getCustomerFacingService().stream()
				.filter(product -> productType.getType().equalsIgnoreCase(product.getCategory())).findFirst();
	}

	public static String retrieveVelocityDown(ResourceInventoryEntity entity) {
		String downstream = retrieveVelocity(entity, VelocityType.DOWNSTREAM);
		return null != downstream ? downstream : "4096";
	}

	public static String retrieveVelocityUp(ResourceInventoryEntity entity) {
		return retrieveVelocity(entity, VelocityType.UPSTREAM);
	}

	public static String retrieveVelocity(ResourceInventoryEntity entity, VelocityType velocityType) {
		return retrieveValue(entity, ProductType.BROADBAND, velocityType.getType());
	}

	public static String retrieveIpType(ResourceInventoryEntity entity) {
		return retrieveValue(entity, ProductType.BROADBAND, "IP");
	}

	public static String retrieveValue(ResourceInventoryEntity entity, ProductType productType, String name) {
		Optional<ServiceDescribedBy> serviceDescribedBy = retrieveSpecificServiceDescribedBy(entity, productType, name);
		return serviceDescribedBy.isPresent() ? retrieveValueFromServiceDescribedBy(serviceDescribedBy.get(), 0) : null;
	}

	public static List<ServiceDescribedBy> retrieveServiceDescribedBy(ResourceInventoryEntity entity,
			ProductType productType) {
		Optional<CustomerFacingService> product = retrieveCfs(entity, productType);
		return product.isPresent() ? product.get().getServiceDescribedBy() : null;
	}

	public static Optional<ServiceDescribedBy> retrieveSpecificServiceDescribedBy(ResourceInventoryEntity entity,
			ProductType productType, String serviceDescribedByName) {
		List<ServiceDescribedBy> serviceDescribedBy = retrieveServiceDescribedBy(entity, productType);

		if (null != serviceDescribedBy && !serviceDescribedBy.isEmpty()) {
			return serviceDescribedBy.stream().filter(sdb -> sdb.getName().equalsIgnoreCase(serviceDescribedByName))
					.findFirst();
		} else {
			return Optional.ofNullable(null);
		}
	}

	public static String retrieveValueFromServiceDescribedBy(ServiceDescribedBy serviceDescribedBy, int position) {
		return serviceDescribedBy.getServiceSpecCharDescribes().get(position).getValue();
	}
}