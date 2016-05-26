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

public class NFCTest implements TrainState{

	protected final TrainContext train;
	private SpeedRestrictionLevel speed = SpeedRestrictionLevel.CITY;
	public NFCTest(TrainContext train) {
		this.train = train;
		train.sendSpeedRestriction(speed);
	}
	
	@Override
	public void colorUpdate(ColorReading color) {
		if(color.getReading() == SleeperColor.UNKNOWN || color.getReading() == SleeperColor.GRAY) return;
		
		if(color.getReading() == SleeperColor.BLUE){
			StateActivator.getLogger().log(LogService.LOG_INFO, String.format("[%s] %d %s", this.getClass().getSimpleName(), System.currentTimeMillis(), color.getReading()));
			train.getSensorConfigurator().configureSensor(SensorConfigurationOption.READ, 0, PublisherType.BEACON);
		}
		if(color.getReading() == SleeperColor.GREEN){
			train.stopTrain();
		}
		
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
		StateActivator.getLogger().log(LogService.LOG_INFO, String.format("[%s] %d %s", this.getClass().getSimpleName(), System.currentTimeMillis(), locationID.getReading()));
	}

	@Override
	public void sensorUpdate(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	
}
