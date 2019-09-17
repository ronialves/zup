package com.tlf.oss.resourceinventory.osp.core.enums;

import java.util.EnumSet;

public enum TerminalBoxTypeStrategy {

	ONE(1) {
		@Override
		public String getDescriptionType() {
			return "Caixa terminal";
		}
	},
	TWO(2) {
		@Override
		public String getDescriptionType() {
			return "Caixa predial";
		}
	},
	THREE(3) {
		@Override
		public String getDescriptionType() {
			return "ONU";
		}
	},
	FOUR(4) {
		@Override
		public String getDescriptionType() {
			return "Splitter";
		}
	},
	FIVE(5) {
		@Override
		public String getDescriptionType() {
			return "DGO (ODF)";
		}
	},
	SIX(6) {
		@Override
		public String getDescriptionType() {
			return "Terminal de Fibras (TFO)";
		}
	},
	SEVEN(7) {
		@Override
		public String getDescriptionType() {
			return "Armário de Distribuição";
		}
	},
	EIGHT(8) {
		@Override
		public String getDescriptionType() {
			return "Armário de Equipamento";
		}
	},
	NINE(9) {
		@Override
		public String getDescriptionType() {
			return "ONT";
		}
	},
	TEN(10) {
		@Override
		public String getDescriptionType() {
			return "DG";
		}
	},
	ELEVEN(11) {
		@Override
		public String getDescriptionType() {
			return "Estação";
		}
	},
	TWELVE(12) {
		@Override
		public String getDescriptionType() {
			return "DLC";
		}
	},
	THIRTEEN(13) {
		@Override
		public String getDescriptionType() {
			return "Outro";
		}
	},
	FOURTEEN(14) {
		@Override
		public String getDescriptionType() {
			return "OLT";
		}
	},
	FIFTEEN(15) {
		@Override
		public String getDescriptionType() {
			return "Distribuidor Interno";
		}
	};
	
	private final int value;

	private TerminalBoxTypeStrategy(int type) {
		this.value = type;
	}

	private int getValue() {
		return value;
	}

	public static TerminalBoxTypeStrategy getType(int value) {
		for (TerminalBoxTypeStrategy e : EnumSet.allOf(TerminalBoxTypeStrategy.class)) {
			if (e.getValue() == value) {
				return e;
			}
		}
		return null;
	}
	
	public abstract String getDescriptionType();
}
