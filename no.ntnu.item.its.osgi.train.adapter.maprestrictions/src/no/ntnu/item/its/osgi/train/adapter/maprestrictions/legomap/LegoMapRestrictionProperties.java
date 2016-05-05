package no.ntnu.item.its.osgi.train.adapter.maprestrictions.legomap;

import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;

public final class LegoMapRestrictionProperties {

	private LegoMapRestrictionProperties(){};
	
	public static final SpeedRestrictionLevel SPEEDRED = SpeedRestrictionLevel.INNERCITY;
	public static final SpeedRestrictionLevel SPEEDGREEN = SpeedRestrictionLevel.NORMAL;
	public static final SpeedRestrictionLevel SPEEDYELLOW = SpeedRestrictionLevel.CITY;
	public static final SpeedRestrictionLevel SPEEDBLUE = SpeedRestrictionLevel.NORMAL;
	
}
