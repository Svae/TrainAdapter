package no.ntnu.item.its.osgi.train.adapter.trainstates;

import org.osgi.service.log.LogService;

import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.City;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.Innercity;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.LocalTest;
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
		case RUNNINGCITY:
			return new City(train);
		case RUNNINGINNERCITY:
			return new Innercity(train);
		case TEST:
			return new LocalTest(train);
		default:
			((LogService)StateActivator.logServiceTracker.getService()).log(LogService.LOG_WARNING, "Could not find train state " + state);
			break;
		}
		return null;
	}
	
	
}
