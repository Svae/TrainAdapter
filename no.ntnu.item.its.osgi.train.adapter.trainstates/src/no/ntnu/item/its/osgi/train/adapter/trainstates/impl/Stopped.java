package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SensorEventType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class Stopped extends LegoTrain{

	
	public Stopped(TrainContext train) {
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
	public void sensorUpdate(SensorStateEvent event) {
		if(event.getEvent() ==SensorEventType.REGISTERED && event.getType() == PublisherType.SLEEPER){
			train.setTrainState(TrainStates.RUNNING);
		}
		
	}

	@Override
	public void dummyUpdate() {
		
	}


}
