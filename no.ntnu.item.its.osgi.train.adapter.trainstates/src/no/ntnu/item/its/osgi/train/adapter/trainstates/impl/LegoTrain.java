package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.framework.ServiceEvent;
import org.osgi.service.log.LogService;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.common.MapZone;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.trainstates.StateActivator;
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
		SleeperColor color = reading.getReading();
		if(color == SleeperColor.UNKNOWN || color == SleeperColor.GRAY) return;
		StateActivator.getLogger().log(LogService.LOG_DEBUG, String.format("Color: %s", color));
		switch (reading.getReading()) {
			case GREEN:
				break;
			case BLUE:
				train.getSensorConfigurator().configureSensor(SensorConfigurationOption.READ, 0, PublisherType.BEACON);
				break;
			case RED:
				Status sensorstatus = train.getSensorConfigurator().getPublisherStatus(PublisherType.MAG);
				if(sensorstatus == Status.STOPPED) reconfigurePublisherRate(PublisherType.MAG, train.getSpeed());
				else stopPublisher(PublisherType.MAG);
			case YELLOW:
				if(train.isInTurn()) train.decreaseSpeedForTurn();
				else train.increaseSpeedForTurn();
				break;
			default:
				return;
		}
		
	}
	
	protected void reconfigurePublisherRate(PublisherType type, double speed){
		if(type == PublisherType.MAG) train.getSensorConfigurator().configureSensor(SensorConfigurationOption.PUBLISHRATE, calculateMagPullRate(speed), type);
	}
	
	protected void stopPublisher(PublisherType type){
		train.getSensorConfigurator().configureSensor(SensorConfigurationOption.STOP, null, type);
	}

	@Override
	public void accelerationUpdate(AccelerometerReading acc) {
		
	}

	@Override
	public void nfcUpdate(NFCReading hex) {
		MapZone zone;
		StateActivator.getLogger().log(LogService.LOG_DEBUG, String.format("LocationID: %s", hex.getReading()));
		if(hex.getReading().equals("00000000")){
			if(train.getCurrentLocationID() == "00000000"){
				train.stopTrain();
				return;
			}
			zone = train.getMapRestrictions().getNextMapZone(train.getCurrentLocationID(), true);
		}
		else zone = train.getMapRestrictions().getMapZoneFromLocation(hex.getReading());
		train.setCurrentLocationID(hex.getReading());
		if(zone == MapZone.CITY) train.setTrainState(TrainStates.RUNNINGCITY);
		if(zone == MapZone.INNERCITY) train.setTrainState(TrainStates.RUNNINGINNERCITY);
		if(zone == MapZone.NORMAL) train.setTrainState(TrainStates.RUNNING);
	}
	
	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		if(train.getSpeed() == 0) return;
		StateActivator.getLogger().log(LogService.LOG_DEBUG, String.format("IsTurning: %s", reading.isTurning() ? "Turning" : "Not turning"));

	}

	@Override
	public void temperaturUpdate(TemperatureReading temp) {
		
	}


	
	protected long calculateColorPullRate(double speed){
		return (long) (145 - speed);
	}

	protected long calculateMagPullRate(double speed){
		return (long) (1000 - 5*speed);
	}
	
}
