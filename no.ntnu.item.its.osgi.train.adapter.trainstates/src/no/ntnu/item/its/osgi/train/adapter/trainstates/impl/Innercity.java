package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SensorEventType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SensorPriorityLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class Innercity extends LegoTrain {

	public Innercity(TrainContext train) {
		super(train);
		train.sendSpeedRestriction(SpeedRestrictionLevel.INNERCITY);
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sensorUpdate(SensorStateEvent event) {
		if (event.getEvent() == SensorEventType.UNREGISTERED) {
			if (train.getTrainRestrictionChecker().getSensorPriority(event.getType()) == SensorPriorityLevel.VITAL) {
				train.stopTrain();
			}
			if (train.getTrainRestrictionChecker()
					.getSensorPriority(event.getType()) == SensorPriorityLevel.IMPORTANT) {
				if (event.getType() == PublisherType.BEACON) {
					train.setTrainState(TrainStates.INNERCITYNFC);
				}
			}
		}
		updateSensorState(event);

	}

}
