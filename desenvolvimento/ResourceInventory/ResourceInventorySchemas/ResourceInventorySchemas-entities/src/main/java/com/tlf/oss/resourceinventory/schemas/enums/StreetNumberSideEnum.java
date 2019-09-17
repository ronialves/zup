package com.tlf.oss.resourceinventory.schemas.enums;

public enum StreetNumberSideEnum {
	
	ODD("IMPAR"),
    EVEN("PAR"),
    BOTH("AMBOS");
     
    private String description;
     
    private StreetNumberSideEnum(String description){
        this.setDescription(description);
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
     
    public static StreetNumberSideEnum findSide(int numero) {
        return  (numero % 2) == 0 ? EVEN : ODD;
    }
    public static StreetNumberSideEnum getStreetNumberSideEnum(String description){
        StreetNumberSideEnum side = BOTH;
        if(description != null){
            if(EVEN.getDescription().equalsIgnoreCase(description)){
                side = EVEN;
            }else if(ODD.getDescription().equalsIgnoreCase(description)){
                side = ODD;
            }
        }
        return side;
    }

}
