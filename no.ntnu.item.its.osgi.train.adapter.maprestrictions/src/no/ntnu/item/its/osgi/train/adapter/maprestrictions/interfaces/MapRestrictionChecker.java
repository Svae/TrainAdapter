package no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.common.MapZone;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;

public interface MapRestrictionChecker {
	
	
	public SpeedRestrictionLevel getSpeedLevelforZone(MapZone zone);
	
	


}
