package com.tlf.oss.resourceinventory.granite.core.enums;

import java.util.EnumSet;
import java.util.Optional;

public enum BandwidthName {

	_2M("2M", "2048"),
	_4M("4M", "4096"),
	_15M("16M", "15360"), // Em uma reserva de 15MB, será considerada a velocidade de 16MB por conta de uma premissa do projeto
	_16M("16M", "16384"),
	_25M("25M", "25600"),
	_50M("50M", "51200"),
	_100M("100M", "102400"),
	_200M("200M", "204800"),
	_300M("300M", "307200");

	private final String name;
	private final String velocity;

	private BandwidthName(String name, String velocity) {
		this.name = name;
		this.velocity = velocity;
	}

	public String getName() {
		return name;
	}

	public String getVelocity() {
		return velocity;
	}

	private static final EnumSet<BandwidthName> VALUES = EnumSet.allOf(BandwidthName.class);

	public static Optional<BandwidthName> retrieveBandwidthNameByName(String value) {
		return VALUES.stream()
					 .filter(name -> name.getName().equals(value))
					 .findFirst();
	}

	public static Optional<BandwidthName> retrieveBandwidthNameByVelocity(String value) {
		return VALUES.stream()
					 .filter(velocity -> velocity.getVelocity().equals(value))
					 .findFirst();
	}
}
