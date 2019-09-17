package com.tlf.oss.resourceinventory.granite.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tlf.oss.resourceinventory.granite.core.enums.StatusPathType;

public class StatusPathTypeTest {

	@Test
	public void getReserved() {
		StatusPathType statusPathType = StatusPathType.getStatusPathType("RESERVADO");
		assertEquals(StatusPathType.RESERVED, statusPathType);	
	}
}
