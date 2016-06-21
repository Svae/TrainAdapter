package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SensorEventType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SensorPriorityLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class Running extends LegoTrain{

	
	public Running(TrainContext train) {
		super(train);
		train.sendSpeedRestriction(SpeedRestrictionLevel.NORMAL);
	}

	@Override
	public void dummyUpdate() {
		
	}
	@Override
	public void sensorUpdate(SensorStateEvent event) {
		if(event.getEvent() == SensorEventType.UNREGISTERED){
			if(train.getTrainRestrictionChecker().getSensorPriority(event.getType()) == SensorPriorityLevel.VITAL){
				train.stopTrain();
				train.setTrainState(TrainStates.STOPPED);
			}
			if(train.getTrainRestrictionChecker().getSensorPriority(event.getType()) == SensorPriorityLevel.IMPORTANT){
				if(event.getType() == PublisherType.BEACON){
					train.setTrainState(TrainStates.RUNNINGNFC);
				}
			}
			
		}
		updateSensorState(event);
		
	}
	


}
