package no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.common.MapZone;

public interface MapRestrictionChecker {
	
	
	public MapZone getMapZoneFromLocation(String mapID);
	public MapZone getNextMapZone(String previous, boolean direction);


}
