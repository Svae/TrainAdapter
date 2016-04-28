package no.ntnu.item.its.osgi.train.adapter.maprestrictions.legomap;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.common.MapZone;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionChecker;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;

public class LegoMapRestrictionChecker implements MapRestrictionChecker{

	@Override
	public SpeedRestrictionLevel getSpeedLevelforZone(MapZone zone) {
		switch (zone) {
		case RED:
			return LegoMapRestrictionProperties.SPEEDRED;
		case GREEN:
			return LegoMapRestrictionProperties.SPEEDGREEN;
		case BLUE:
			return LegoMapRestrictionProperties.SPEEDBLUE;
		case YELLOW:
			return LegoMapRestrictionProperties.SPEEDYELLOW;
		default:
			return null;
		}
	}
	
	

}
