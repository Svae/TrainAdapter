package no.ntnu.item.its.osgi.train.adapter.maprestrictions.legomap;

import java.util.Arrays;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.common.MapZone;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapChecker;

public class LegoMapChecker implements MapChecker{


	@Override
	public MapZone getMapZoneFromLocation(String locationID) {
		if(Arrays.asList(LegoMapProperties.CITY).contains(locationID)) return MapZone.CITY;
		if(Arrays.asList(LegoMapProperties.INNERCITY).contains(locationID)) return MapZone.INNERCITY;
		return MapZone.NORMAL;
	}

	@Override
	public MapZone getNextMapZone(String previous, boolean direction) {
		int id = direction ? Integer.valueOf(previous) + 1 : Integer.valueOf(previous) - 1;
		return getMapZoneFromLocation(String.valueOf(id));
	}
	
	
	
	

}
