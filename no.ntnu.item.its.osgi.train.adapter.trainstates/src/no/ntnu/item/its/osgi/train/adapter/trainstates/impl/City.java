package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class City extends LegoTrain{

	public City(TrainContext train) {
		super(train);
	}

	@Override
	public void colorUpdate(ColorReading color) {
		if(color.getReading() == SleeperColor.BLUE) {
			System.out.println("Chaning train state due to color");
			train.setTrainState(TrainStates.RUNNINGINNERCITY);
			train.sendSpeedRestriction(SpeedRestrictionLevel.INNERCITY);
		}
		if(color.getReading() == SleeperColor.GREEN){
			train.setTrainState(TrainStates.RUNNING);
			train.sendSpeedRestriction(SpeedRestrictionLevel.NORMAL);
		}
	}

	
	

}
