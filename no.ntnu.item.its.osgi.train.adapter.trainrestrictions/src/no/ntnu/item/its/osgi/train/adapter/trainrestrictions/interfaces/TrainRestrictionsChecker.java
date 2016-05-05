package no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SensorPriorityLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.TrainTemperatureLevel;

public interface TrainRestrictionsChecker {
	
	public TrainTemperatureLevel getTemperatureLevel(double temp);
	public boolean checkSpeed(double speed, SpeedRestrictionLevel level);
	public SensorPriorityLevel getSensorPriority(PublisherType type);
	public double getSpeedRestriction(SpeedRestrictionLevel level);
	public boolean checkTemperture(double temp, TrainTemperatureLevel level);
	public SpeedRestrictionLevel getSpeedLevel(double speed);
	public double getSpeedIncreaseInTurne();
	public long getPublishRate(PublisherType type);
	
	
}

