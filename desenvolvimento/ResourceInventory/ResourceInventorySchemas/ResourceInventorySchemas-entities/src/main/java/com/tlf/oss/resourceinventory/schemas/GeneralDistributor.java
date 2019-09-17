
package com.tlf.oss.resourceinventory.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralDistributor", propOrder = {
    "pointNumber","horizontalPosition","verticalPosition","pinPosition"
})
public class GeneralDistributor {
	
    protected String pointNumber ;
    protected String horizontalPosition;
    protected String verticalPosition;
    protected String pinPosition;
    
	public String getPointNumber() {
		return pointNumber;
	}
	public void setPointNumber(String pointNumber) {
		this.pointNumber = pointNumber;
	}
	public String getHorizontalPosition() {
		return horizontalPosition;
	}
	public void setHorizontalPosition(String horizontalPosition) {
		this.horizontalPosition = horizontalPosition;
	}
	public String getVerticalPosition() {
		return verticalPosition;
	}
	public void setVerticalPosition(String verticalPosition) {
		this.verticalPosition = verticalPosition;
	}
	public String getPinPosition() {
		return pinPosition;
	}
	public void setPinPosition(String pinPosition) {
		this.pinPosition = pinPosition;
	}
    
}
