package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.sensors.common.enums.EColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;

public class Running extends LegoTrain{

	protected int direction;
	
	public Running(TrainContext train) {
		this.train = train;
	}
	
	@Override
	public void colorUpdate(ColorReading color) {
		if(color.getReading() == EColor.RED) train.setTrainState(new RunningInRedZone(train));
		train.sendSpeedRestriction(train.getTrainRestriction().getSpeedRestriction(SpeedRestrictionLevel.CITY));
	}

	@Override
	public void accelerationUpdate(AccelerometerReading acc) {
		if(train.getSpeed() == 0) train.setTrainState(new Stopped(train));
		
	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		if(reading.getX() == 1) train.setTrainState(new RunningInCurve(train));
	}

	@Override
	public void temperaturUpdate(TemperatureReading temp) {
		if(train.getTrainRestriction().checkTemperture(temp.getReading()) != 0) train.sendSpeedRestriction(SpeedLevel.LOW);
	}

	@Override
	public void nfcUpdate(NFCReading hex) {
		
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
