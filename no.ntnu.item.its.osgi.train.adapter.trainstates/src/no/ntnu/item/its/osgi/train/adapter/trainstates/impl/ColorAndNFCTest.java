package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import java.util.ArrayList;

import org.osgi.framework.ServiceEvent;
import org.osgi.service.log.LogService;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.StateActivator;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;

public class ColorAndNFCTest implements TrainState{

	protected final TrainContext train;
	private SpeedRestrictionLevel speed = SpeedRestrictionLevel.CITY;
	private ArrayList<String> writevalues;
	public ColorAndNFCTest(TrainContext train) {
		this.train = train;
		train.sendSpeedRestriction(speed);
		

	}
	
	@Override
	public void colorUpdate(ColorReading color) {
		if(color.getReading() == SleeperColor.UNKNOWN || color.getReading() == SleeperColor.GRAY) return;
		
		StateActivator.getLogger().log(LogService.LOG_INFO, String.format("[%s] %d %s", this.getClass().getSimpleName(), System.currentTimeMillis(), color.getReading()));
		if(color.getReading() == SleeperColor.BLUE){
			train.getSensorConfigurator().configureSensor(SensorConfigurationOption.READ, 0, PublisherType.BEACON);
		}
		if(color.getReading() == SleeperColor.YELLOW){
			speed = (speed== SpeedRestrictionLevel.NORMAL) ? SpeedRestrictionLevel.CITY : SpeedRestrictionLevel.NORMAL;
			train.sendSpeedRestriction(speed);
			reconfigureSensors(PublisherType.SLEEPER, speed);
		}
		if(color.getReading() == SleeperColor.RED){
			train.getSensorConfigurator().configureSensor(SensorConfigurationOption.WRITE, writevalues.remove(0), PublisherType.BEACON);
		}
	}

	protected void reconfigureSensors(PublisherType type, SpeedRestrictionLevel level){	
		train.getSensorConfigurator().configureSensor(SensorConfigurationOption.PUBLISHRATE, calculateColorPullRate(level), type);
	}
	
	@Override
	public void accelerationUpdate(AccelerometerReading acc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void temperaturUpdate(TemperatureReading temp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nfcUpdate(NFCReading locationID) {
		
	}

	@Override
	public void sensorUpdate(ServiceEvent event) {
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

}
