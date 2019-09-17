package com.tlf.oss.resourceinventory.osp.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.tlf.oss.resourceinventory.osp.core.enums.TerminalBoxTypeStrategy;

/**
 * 
 * @author paulo nicezio
 *
 */
public class TerminalBoxTypeStrategyTest {

	@Test
	public void shouldReturnOptionOne() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(1);
		assertEquals("Caixa terminal", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionTwo() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(2);
		assertEquals("Caixa predial", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionThree() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(3);
		assertEquals("ONU", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionFour() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(4);
		assertEquals("Splitter", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionFive() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(5);
		assertEquals("DGO (ODF)", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionSix() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(6);
		assertEquals("Terminal de Fibras (TFO)", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionSeven() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(7);
		assertEquals("Armário de Distribuição", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionEight() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(8);
		assertEquals("Armário de Equipamento", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionNine() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(9);
		assertEquals("ONT", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionTen() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(10);
		assertEquals("DG", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionEleven() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(11);
		assertEquals("Estação", terminalBoxTypeStrategy.getDescriptionType());
	}

	@Test
	public void shouldReturnOptionTwelve() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(12);
		assertEquals("DLC", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionThirteen() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(13);
		assertEquals("Outro", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionFourteen() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(14);
		assertEquals("OLT", terminalBoxTypeStrategy.getDescriptionType());
	}
	
	@Test
	public void shouldReturnOptionFifteen() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(15);
		assertEquals("Distribuidor Interno", terminalBoxTypeStrategy.getDescriptionType());
	}

	@Test
	public void shouldNotReturnAnyOption() {
		TerminalBoxTypeStrategy terminalBoxTypeStrategy = TerminalBoxTypeStrategy.getType(1000);
		assertNull(terminalBoxTypeStrategy);
	}
	
}
