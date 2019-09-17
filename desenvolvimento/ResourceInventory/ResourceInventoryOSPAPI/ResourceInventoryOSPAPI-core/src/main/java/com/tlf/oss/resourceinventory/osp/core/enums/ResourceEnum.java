package com.tlf.oss.resourceinventory.osp.core.enums;

public enum ResourceEnum {

	NetType_1(1),
	NetType_2(2),
	ResourceCoverage_1(1),
	ResourceFeasibility_0(0),
	ResourceFeasibility_1(1);

	private final int value;

	private ResourceEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}