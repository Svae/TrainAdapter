package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;

public class Running extends LegoTrain{

	protected int direction;
	
	public Running(TrainContext train) {
		super(train);
	}
	
	@Override
	public void colorUpdate(ColorReading color) {
	}

	@Override
	public void accelerationUpdate(AccelerometerReading acc) {
		
	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
	}

	@Override
	public void temperaturUpdate(TemperatureReading temp) {
	}

	@Override
	public void nfcUpdate(NFCReading hex) {
		
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
