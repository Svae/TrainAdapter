package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.service.log.LogService;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.StateActivator;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;

public class ColorAndNFCTest implements TrainState{

	protected final TrainContext train;
	private SpeedRestrictionLevel speed = SpeedRestrictionLevel.CITY;
	public ColorAndNFCTest(TrainContext train) {
		this.train = train;
		train.sendSpeedRestriction(speed);
		

	}
	
	@Override
	public void colorUpdate(ColorReading color) {
		if(color.getReading() == SleeperColor.UNKNOWN || color.getReading() == SleeperColor.GRAY) return;
		
		StateActivator.getLogger().log(LogService.LOG_INFO, String.format("[%s] %d %s", this.getClass().getSimpleName(), System.currentTimeMillis(), color.getReading()));
		if(color.getReading() == SleeperColor.BLUE){			
			train.reconfigureSensor(new SensorReconfiguration(PublisherType.BEACON, SensorConfigurationOption.READ, 0));
		}
	}
	
	@Override
	public void accelerationUpdate(AccelerometerReading acc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		
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
	public void sensorUpdate(SensorStateEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}
	

}
