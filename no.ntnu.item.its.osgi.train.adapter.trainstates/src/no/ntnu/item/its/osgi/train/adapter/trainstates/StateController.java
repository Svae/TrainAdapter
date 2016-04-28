package no.ntnu.item.its.osgi.train.adapter.trainstates;

import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.Running;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.Stopped;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController;

public class StateController implements TrainStateController{

	@Override
	public TrainState getTrainState(TrainStates state, TrainContext train) {
		switch (state) {
		case RUNNING:
			return new Running(train);
		case STOPPED:
			return new Stopped(train);
		case FAILED:
			break;
		default:
			break;
		}
		return null;
	}
	
	
}
