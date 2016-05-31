package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.StateActivator;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;

public class ColorTest implements TrainState{

	protected final TrainContext train;
	private SpeedRestrictionLevel speed = SpeedRestrictionLevel.CITY;
	
	public ColorTest(TrainContext train) {
		this.train = train;
		train.sendSpeedRestriction(speed);
	}
	
	@Override
	public void colorUpdate(ColorReading color) {
		if(color.getReading() != SleeperColor.YELLOW) return;
		StateActivator.getLogger().log(LogService.LOG_INFO, " [ColorTest] " + System.currentTimeMillis());
		speed = (speed== SpeedRestrictionLevel.NORMAL) ? SpeedRestrictionLevel.CITY : SpeedRestrictionLevel.NORMAL;
		train.sendSpeedRestriction(speed);
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
	public void nfcUpdate(NFCReading hex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sensorUpdate(ServiceReference event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}

}
