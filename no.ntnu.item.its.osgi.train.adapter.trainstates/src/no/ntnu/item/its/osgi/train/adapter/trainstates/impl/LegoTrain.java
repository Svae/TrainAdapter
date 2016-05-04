package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import java.awt.SecondaryLoop;

import org.osgi.framework.ServiceEvent;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public abstract class LegoTrain implements TrainState{

	protected final TrainContext train;

	
	public LegoTrain(TrainContext train) {
		this.train = train;
	}
	
	@Override
	public void sensorUpdate(ServiceEvent event) {
	}
	
	@Override
	public void colorUpdate(ColorReading reading){
		if(reading.getReading() == SleeperColor.GREEN) {
			train.setTrainState(TrainStates.RUNNING);
			train.sendSpeedRestriction(SpeedRestrictionLevel.NORMAL);
		}
		if(reading.getReading() == SleeperColor.BLUE){
			train.setTrainState(TrainStates.RUNNINGCITY);
			train.sendSpeedRestriction(SpeedRestrictionLevel.CITY);
		}
	}
	
	@Override
	public void accelerationUpdate(AccelerometerReading acc) {
		
	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		System.out.println("Train: " + train.isInTurn() + " Reading: " + reading.isTurning());
		if(train.getSpeed() == 0) return;
		if(!train.isInTurn() && reading.isTurning()) train.increaseSpeedForTurn();
		if(train.isInTurn() && !reading.isTurning()) train.decreaseSpeedForTurn();
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
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}

	
}
