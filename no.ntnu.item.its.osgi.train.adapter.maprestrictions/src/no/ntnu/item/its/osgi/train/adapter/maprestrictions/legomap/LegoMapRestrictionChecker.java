package no.ntnu.item.its.osgi.train.adapter.maprestrictions.legomap;

import java.util.Arrays;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.common.MapZone;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionChecker;

public class LegoMapRestrictionChecker implements MapRestrictionChecker{


	@Override
	public MapZone getMapZoneFromLocation(String locationID) {
		if(Arrays.asList(LegoMapRestrictionProperties.CITY).contains(locationID)) return MapZone.CITY;
		if(Arrays.asList(LegoMapRestrictionProperties.INNERCITY).contains(locationID)) return MapZone.INNERCITY;
		return MapZone.NORMAL;
	}

	@Override
	public MapZone getNextMapZone(String previous, boolean direction) {
		int id = direction ? Integer.valueOf(previous) + 1 : Integer.valueOf(previous) - 1;
		return getMapZoneFromLocation(String.valueOf(id));
	}
	
	
	
	

}
