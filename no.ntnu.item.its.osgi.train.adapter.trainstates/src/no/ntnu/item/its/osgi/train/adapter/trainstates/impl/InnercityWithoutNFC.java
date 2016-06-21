package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SensorEventType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class InnercityWithoutNFC extends LegoTrainNFC{

	public InnercityWithoutNFC(TrainContext train) {
		super(train);
		train.sendSpeedRestriction(SpeedRestrictionLevel.INNERCITY);
	}

	
	@Override
	public void sensorUpdate(SensorStateEvent event) {
		if(event.getEvent() == SensorEventType.REGISTERED){
			if(event.getType() == PublisherType.BEACON){
				train.setTrainState(TrainStates.INNERCITY);
			}
		}else if(event.getEvent() == SensorEventType.UNREGISTERED){
			if(event.getType() == PublisherType.SLEEPER){
				train.stopTrain();
				train.setTrainState(TrainStates.STOPPED);
			}
		}
		updateSensorState(event);
	}


	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}
}
