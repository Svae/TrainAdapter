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
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;

public class MagTest implements TrainState{

	private TrainContext train;
	
	public MagTest(TrainContext train) {
		this.train = train;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void colorUpdate(ColorReading color) {
		if(color.getReading() == SleeperColor.GRAY || color.getReading() == SleeperColor.UNKNOWN) return;
		if(color.getReading() == SleeperColor.GREEN){
			if(train.getSpeedRestrictionLevel() == SpeedRestrictionLevel.CITY) train.sendSpeedRestriction(SpeedRestrictionLevel.NORMAL);
			else train.sendSpeedRestriction(SpeedRestrictionLevel.NORMAL);
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
