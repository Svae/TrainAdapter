package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;

public class RunningInCurve extends Running{

	public RunningInCurve(TrainContext train) {
		super(train);
	}
	
	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		train.setTrainState(new Running(train));
	}
	
	

}
