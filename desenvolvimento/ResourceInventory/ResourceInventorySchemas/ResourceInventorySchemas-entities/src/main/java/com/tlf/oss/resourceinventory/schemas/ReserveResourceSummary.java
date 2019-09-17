package com.tlf.oss.resourceinventory.schemas;

import java.util.ArrayList;
import java.util.List;

public class ReserveResourceSummary {

	protected List<ResourceFacingService> reserveInvolvesRFS;
	
	public List<ResourceFacingService> getReserveInvolvesRFS() {
        if (reserveInvolvesRFS == null) {
            reserveInvolvesRFS = new ArrayList<ResourceFacingService>();
        }
        return this.reserveInvolvesRFS;
    }

	public void setReserveInvolvesRFS(List<ResourceFacingService> reserveInvolvesRFS) {
		this.reserveInvolvesRFS = reserveInvolvesRFS;
	}
	
}
