package com.tlf.oss.resourceinventory.cpe.enums;

public enum TipoRfs {
	
	ACCESS_PORT("ACCESS_PORT","R_CPE_ACCESS_PORT", "Banda", ""),
	ACCESS("ACCESS","R_CPE_ACCESS", "Banda", "BB_EQUIPMENT_TYPE"),
	VOIP("VOIP","R_CPE_VOIP", "Linha Telefônica", "VOICE_EQUIPMENT_TYPE"),
	STB("STB","R_CPE_STB", "TV", "EQUIPMENT_TYPE");
	
	private final String tipoRfs;
	private final String roiName;
	private final String type;
	private final String equipmentType;

	private TipoRfs(String tipoRfs, String roiName, String type, String equipmentType){
		this.tipoRfs = tipoRfs;
		this.roiName = roiName;
		this.type = type;
		this.equipmentType = equipmentType;
	}
	
	public String getTipoRfs() {
		return tipoRfs;
	}
	
	public String getRoiName() {
		return roiName;
	}
	
	public String getType() {
		return type;
	}
	
	public String getEquipmentType() {
		return equipmentType;
	}
	
	public static TipoRfs fromRoiName(final String roiName) {
		for(TipoRfs rfs : TipoRfs.values()) {
			if(rfs.getRoiName().equalsIgnoreCase(roiName)) {
				return rfs;
			}
		}
		return null;
	}
}
