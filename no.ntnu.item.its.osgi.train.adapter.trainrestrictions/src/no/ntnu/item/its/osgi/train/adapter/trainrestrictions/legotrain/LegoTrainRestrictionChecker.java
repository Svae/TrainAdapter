package no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain;

import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SENSORACCELEROMETER;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SENSORBEACON;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SENSORCOLOR;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SENSORMAGNETOMETER;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SPEEDCITY;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SPEEDINNERCITY;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SPEEDLOW;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SPEEDNORMAL;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.TEMPERATUREOKMAX;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.TEMPERATUREOKMIN;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.TEMPERATUREWARNINGMAX;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.TEMPERATUREWARNINGMIN;
import static no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionProperties.SPEEDINCREASETURN;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SensorPriorityLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.TrainTemperatureLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;

public class LegoTrainRestrictionChecker implements TrainRestrictionsChecker {

	
	
	public LegoTrainRestrictionChecker() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean checkTemperture(double temp, TrainTemperatureLevel level) {
		int[] limits = getTempFromLevel(level);
		if(temp < limits[0] || temp > limits[1]) return false;
		return true;
	}

	@Override
	public boolean checkSpeed(double speed, SpeedRestrictionLevel level) {
		return speed > getSpeedFromLevel(level) ? false : true;
		
	}
	
	@Override
	public SpeedRestrictionLevel getSpeedLevel(double speed){
		if(speed <= SPEEDLOW) return SpeedRestrictionLevel.LOW;
		if(speed <= SPEEDINNERCITY) return SpeedRestrictionLevel.INNERCITY;
		if(speed <= SPEEDCITY) return SpeedRestrictionLevel.CITY;
		if(speed <= SPEEDNORMAL) return SpeedRestrictionLevel.NORMAL;
		return null;
	}

	public TrainTemperatureLevel getTemperatureLevel(double temperature){
		if(temperature < TEMPERATUREWARNINGMIN || temperature > TEMPERATUREWARNINGMIN) return TrainTemperatureLevel.CRITICAL;
		if(temperature < TEMPERATUREOKMIN || temperature > TEMPERATUREOKMAX) return TrainTemperatureLevel.WARNING;
		return TrainTemperatureLevel.OK;
	}
	
	@Override
	public SensorPriorityLevel getSensorPriority(PublisherType type) {
		switch (type) {
		case ACCEL:
			return SENSORACCELEROMETER;
		case BEACON:
			return SENSORBEACON;
		case MAG:
			return SENSORMAGNETOMETER;
		case SLEEPER:
			return SENSORCOLOR;
		default:
			return SensorPriorityLevel.UNKNOWN;
		}
	}

	@Override
	public double getSpeedRestriction(SpeedRestrictionLevel level) {
		return getSpeedFromLevel(level);
	}

	
	private double getSpeedFromLevel(SpeedRestrictionLevel level) {
		switch (level) {
		case LOW:
			return SPEEDLOW;
		case NORMAL:
			return SPEEDNORMAL;
		case CITY:
			return SPEEDCITY;
		case INNERCITY:
			return SPEEDINNERCITY;
		default:
			return 0;
		}
	}
	
	private int[] getTempFromLevel(TrainTemperatureLevel level){
		int[] res = new int[2];
		switch (level) {
		case OK:
			res[0] = TEMPERATUREOKMIN;
			res[1] = TEMPERATUREOKMAX;
			break;
		case WARNING:
			res[0] = TEMPERATUREWARNINGMIN;
			res[1] = TEMPERATUREWARNINGMAX;
			break;
		default:
			break;
		}
		return res;
	}

	@Override
	public double getSpeedIncreaseInTurne() {
		return SPEEDINCREASETURN;
	}
}
