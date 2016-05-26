package no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain;

import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SensorPriorityLevel;

public final class LegoTrainRestrictionProperties {
	
	
	// Restrict instantiation
	private LegoTrainRestrictionProperties(){}
	
	public static final double SPEEDNORMAL = 120;
	public static final double SPEEDCITY = 110;
	public static final double SPEEDINNERCITY = 100;
	public static final double SPEEDLOW = 90;
	public static final double SPEEDINCREASETURN = 10;
	
	public static final int TEMPERATUREOKMIN = 5;
	public static final int TEMPERATUREOKMAX = 35;
	public static final int TEMPERATUREWARNINGMIN = -15;
	public static final int TEMPERATUREWARNINGMAX = 55;
	
	public static final int LIGHTTHERSHOLD = 10;
	
	public static final SensorPriorityLevel SENSORLIGHT = SensorPriorityLevel.PERIPHERAL;
	public static final SensorPriorityLevel SENSORCOLOR = SensorPriorityLevel.VITAL;
	public static final SensorPriorityLevel SENSORBEACON = SensorPriorityLevel.VITAL;
	public static final SensorPriorityLevel SENSORMAGNETOMETER = SensorPriorityLevel.PERIPHERAL;
	public static final SensorPriorityLevel SENSORTEMPERATURE = SensorPriorityLevel.IMPORTENT;
	public static final SensorPriorityLevel SENSORACCELEROMETER = SensorPriorityLevel.PERIPHERAL;
		
	
	public static final long DEFAULTCOLORPUBLISHRATE = 25;
	public static final long DEFAULTMAGPUBLISHRATE = 300;
}
