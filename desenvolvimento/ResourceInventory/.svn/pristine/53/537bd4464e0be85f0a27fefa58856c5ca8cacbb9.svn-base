package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

import com.tlf.oss.resourceinventory.schemas.enums.GeometryTypeEnum;

public class GeographicLocation {
	
	private GeometryTypeEnum geometryType;
    private Double accurany;
    private String spatialRef;
    private List<GeographicPoint> geometry;
 
    public GeographicLocation() {
    }
 
    public GeographicLocation(GeometryTypeEnum geometryType, Double accurany, String spatialRef,
            List<GeographicPoint> geometry) {
        this.geometryType = geometryType;
        this.accurany = accurany;
        this.spatialRef = spatialRef;
        this.geometry = geometry;
    }
 
    public GeometryTypeEnum getGeometryType() {
        return geometryType;
    }
 
    public void setGeometryType(GeometryTypeEnum geometryType) {
        this.geometryType = geometryType;
    }
 
    public Double getAccurany() {
        return accurany;
    }
 
    public void setAccurany(Double accurany) {
        this.accurany = accurany;
    }
 
    public String getSpatialRef() {
        return spatialRef;
    }
 
    public void setSpatialRef(String spatialRef) {
        this.spatialRef = spatialRef;
    }
 
    public List<GeographicPoint> getGeometry() {
        if(geometry == null || this.geometry.size() <= 0) {
            geometry = new ArrayList<GeographicPoint>();
        }
        return geometry;
    }
 
    public void setGeometry(List<GeographicPoint> geometry) {
        this.geometry = geometry;
    }
 
    @Override
    public String toString() {
        return "GeographicLocation [geometryType=" + geometryType + ", accurany=" + accurany + ", spatialRef="
                + spatialRef + ", geometry=" + geometry + "]";
    }
 

}
