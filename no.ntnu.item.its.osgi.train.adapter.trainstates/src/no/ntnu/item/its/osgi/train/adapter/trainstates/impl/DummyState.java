package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.framework.ServiceReference;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;

public class DummyState implements TrainState{
	
	private TrainContext train;
	
	public DummyState(TrainContext train) {
		this.train = train;
	}

	@Override
	public void colorUpdate(ColorReading color) {
		// TODO Auto-generated method stub
		
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
