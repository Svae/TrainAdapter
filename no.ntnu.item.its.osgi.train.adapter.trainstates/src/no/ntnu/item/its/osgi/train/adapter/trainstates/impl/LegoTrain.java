package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.framework.ServiceEvent;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public abstract class LegoTrain implements TrainState{

	protected final TrainContext train;

	
	public LegoTrain(TrainContext train) {
		this.train = train;
	}
	
	@Override
	public void sensorUpdate(ServiceEvent event) {
	}
	
	@Override
	public void colorUpdate(ColorReading reading){
		TrainStates newState = null;
		SpeedRestrictionLevel level = null;
		switch (reading.getReading()) {
			case GREEN:
				newState = TrainStates.RUNNING;
				level = SpeedRestrictionLevel.NORMAL;
				break;
			case BLUE:
				newState = TrainStates.RUNNINGCITY;
				level = SpeedRestrictionLevel.CITY;
				break;
			case RED:
				newState = TrainStates.RUNNINGINNERCITY;
				level = SpeedRestrictionLevel.INNERCITY;
				break;
			default:
				break;
		}
		train.setTrainState(newState);
		reconfigureSensors(PublisherType.MAG, level);
		train.sendSpeedRestriction(level);
		
	}
	
	protected void reconfigureSensors(PublisherType type, SpeedRestrictionLevel level){
		train.getSensorConfigurator().configureSensor(SensorConfigurationOption.PUBLISHRATE, calculateMagPullRate(level), type);
	}

	@Override
	public void accelerationUpdate(AccelerometerReading acc) {
		
	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		if(train.getSpeed() == 0) return;
		if(!train.isInTurn() && reading.isTurning()) train.increaseSpeedForTurn();
		if(train.isInTurn() && !reading.isTurning()) train.decreaseSpeedForTurn();
	}

	@Override
	public void temperaturUpdate(TemperatureReading temp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nfcUpdate(NFCReading hex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	protected long calculateColorPullRate(SpeedRestrictionLevel level){
		if(level == SpeedRestrictionLevel.CITY) return 50;
		if(level == SpeedRestrictionLevel.INNERCITY) return 100;
		return train.getTrainRestrictionChecker().getPublishRate(PublisherType.SLEEPER);
	}

	protected long calculateMagPullRate(SpeedRestrictionLevel level){
		if(level == SpeedRestrictionLevel.CITY) return 400;
		if(level == SpeedRestrictionLevel.INNERCITY) return 800;
		return train.getTrainRestrictionChecker().getPublishRate(PublisherType.MAG);
	}
	
}
