package com.tlf.oss.resourceinventory.core.mapping;

import com.tlf.oss.resourceinventory.schemas.api.ResourceInventoryEntity;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.AllocateResourceIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.DeallocateResourceIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.DetermineResourceAvailabilityIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.EquipmentServiceIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.InstallResourceIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.ReleaseResourceIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.ReserveResourceIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.RetrieveResourceInformationIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.UninstallResourceIn;
import com.tlf.oss.resourceinventory.schemas.api.v1_0.UpdateResourceIn;

public class EntityConverterIn {

	public static ResourceInventoryEntity toResourceInventoryEntity(UninstallResourceIn in) {

		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());
		ri.setCustomerFacingService(in.getCustomerFacingServices());
		ri.setCustomerOrder(in.getCustomerOrder());
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setResourceOrder(in.getResourceOrder());
		return ri;

	}

	public static ResourceInventoryEntity toResourceInventoryEntity(DetermineResourceAvailabilityIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());
		ri.setCabinet(in.getCabinet());
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setCustomerFacingService(in.getCustomerFacingServices());
		ri.setCustomerOrder(in.getCustomerOrder());

		return ri;
	}

	public static ResourceInventoryEntity toResourceInventoryEntity(ReserveResourceIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setCustomerFacingService(in.getCustomerFacingServices());
		ri.setCustomerOrder(in.getCustomerOrder());
		return ri;
	}

	public static ResourceInventoryEntity toResourceInventoryEntity(ReleaseResourceIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setCustomerOrder(in.getCustomerOrder());
		ri.setCustomerFacingService(in.getCustomerFacingServices());
		ri.setResourceOrder(in.getResourceOrder());
		return ri;
	}

	public static ResourceInventoryEntity toResourceInventoryEntity(AllocateResourceIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());

		ri.setCustomerOrder(in.getCustomerOrder());
		ri.setCustomerFacingService(in.getCustomerFacingServices());
		ri.setResourceOrder(in.getResourceOrder());
		return ri;
	}

	public static ResourceInventoryEntity toResourceInventoryEntity(InstallResourceIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());
		ri.setCustomerOrder(in.getCustomerOrder());
		ri.setCustomerFacingService(in.getCustomerFacingService());
		ri.setResourceOrder(in.getResourceOrder());
		return ri;
	}

	public static ResourceInventoryEntity toResourceInventoryEntity(RetrieveResourceInformationIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());
		ri.setCustomerOrder(in.getCustomerOrder());
		ri.setResourceOrder(in.getResourceOrder());
		return ri;
	}
	
	public static ResourceInventoryEntity toResourceInventoryEntity(DeallocateResourceIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());
		ri.setCustomerOrder(in.getCustomerOrder());
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setCustomerFacingService(in.getCustomerFacingServices());
		ri.setResourceOrder(in.getResourceOrder());
		return ri;
	}
	
	public static ResourceInventoryEntity toResourceInventoryEntity(EquipmentServiceIn in) {
		ResourceInventoryEntity entity = new ResourceInventoryEntity();
		entity.setNetworkAggregator(in.getNetworkAggregator());
		entity.setResourceFacingService(in.getResourceFacingService());
		return entity;
	}

	public static ResourceInventoryEntity toResourceInventoryEntity(UpdateResourceIn in) {
		ResourceInventoryEntity ri = new ResourceInventoryEntity();
		ri.setResourceFacingService(in.getResourceFacingService());
		ri.setAddress(in.getBrazilianUrbanPropertyAddress());

		ri.setCustomerOrder(in.getCustomerOrder());
		ri.setCustomerFacingService(in.getCustomerFacingServices());
		ri.setResourceOrder(in.getResourceOrder());
		return ri;
	}
}