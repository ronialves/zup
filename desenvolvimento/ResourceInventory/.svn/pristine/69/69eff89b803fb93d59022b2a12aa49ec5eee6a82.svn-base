package com.tlf.oss.resourceinventory.osp.core.mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.tlf.oss.resourceinventory.generated.osp.allocateinstallresource.addresstypes.Address;
import com.tlf.oss.resourceinventory.osp.core.enums.ComplementType;
import com.tlf.oss.resourceinventory.schemas.BrazilianUrbanPropertyAddress;
import com.tlf.oss.resourceinventory.schemas.Complement;

public class OspRequestMapper {

	public static Address parseReserveAddress(BrazilianUrbanPropertyAddress bupat) {
		Address address = new Address();

		if (bupat != null) {
			address.setCityCode((bupat.getCnl() != null? Integer.valueOf(bupat.getCnl()) : null));
			address.setSiteCode(bupat.getTelephonicArea());
			address.setStreetCode(bupat.getStreetCode());
			address.setStreetNumber(bupat.getStreetNrFirst());
			address.setStreetType(bupat.getStreetType());
		}

		return address;
	}
	
	@SuppressWarnings("deprecation")
	public static Address parseAddress(final BrazilianUrbanPropertyAddress bupa) {
		final Address address = new Address();
		
		if (bupa != null) {
			
			address.setCityCode((bupa.getCnl() != null? Integer.valueOf(bupa.getCnl()) : null));
			address.setSiteCode(bupa.getTelephonicArea());
			address.setStreetCode(bupa.getStreetCode());
			address.setStreetNumber(bupa.getStreetNrFirst());

			if(bupa.getComplementSummary() != null && bupa.getComplementSummary().getComplement() != null) {
				
				organizeComplements(bupa.getComplementSummary().getComplement()).forEach(complement -> {
					final ComplementType type = ComplementType.getByCode(complement.getType());
					if(type != null) {
						Address.SubUnit subUnit = new Address.SubUnit();
						subUnit.setCharacterist(BigInteger.valueOf(Long.parseLong(type.getValue())));
						subUnit.setValue(complement.getValue());
						subUnit.setType(complement.getName());
						address.getSubUnit().add(subUnit);
					}
				});
			}
		}

		return address;
	}

	public static com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address parseReserveFacilityAddress(
			BrazilianUrbanPropertyAddress bupat) {
		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address address = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address();

		if (bupat != null) {
			if (bupat.getCnl() != null) {
				try {
					address.setCityCode(Integer.parseInt(bupat.getCnl()));
				} catch (Exception e) {
					address.setCityCode(-1);
				}
			}

			address.setSiteCode(bupat.getTelephonicArea() != null ? bupat.getTelephonicArea() : null);
		}

		return address;
	}
	
	public static com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address parseResourceProvisioningReserveAddress(
			BrazilianUrbanPropertyAddress bupat) {
		com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address address = new com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.addresstypes.Address();

		if (bupat != null) {
			if (bupat.getCnl() != null) {
				try {
					address.setCityCode(Integer.parseInt(bupat.getCnl()));
				} catch (Exception e) {
					address.setCityCode(-1);
				}
			}

			address.setSiteCode(bupat.getTelephonicArea() != null ? bupat.getTelephonicArea() : null);
		}

		return address;
	}
	
	private static List<Complement> organizeComplements(final List<Complement> complements){

		List<Complement> newComplements = new ArrayList<>();
		newComplements.addAll(complements);
		newComplements.sort(Comparator.comparing(Complement::getOrder));
		newComplements = newComplements
				.stream()
				.filter(c -> ComplementType.getByCode(c.getType()) != null).collect(Collectors.toList());
		
		return newComplements;
	}

}