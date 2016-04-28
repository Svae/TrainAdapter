package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.framework.ServiceEvent;

import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;

public abstract class LegoTrain implements TrainState{

	protected final TrainContext train;

	
	public LegoTrain(TrainContext train) {
		this.train = train;
	}
	
	@Override
	public void sensorUpdate(ServiceEvent event) {
		train
	}
	
}
