package no.ntnu.item.its.osgi.train.adapter.trainstates;

import org.osgi.service.log.LogService;

import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.City;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.CityWithoutNFC;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.ColorAndNFCTest;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.ColorTest;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.DummyState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.Innercity;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.InnercityWithoutNFC;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.MagTest;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.NFCTest;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.Running;
import no.ntnu.item.its.osgi.train.adapter.trainstates.impl.RunningWithoutNFC;
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
		case CITY:
			return new City(train);
		case INNERCITY:
			return new Innercity(train);
		case RUNNINGNFC:
			return new RunningWithoutNFC(train);
		case INNERCITYNFC:
			return new InnercityWithoutNFC(train);
		case CITYNFC:
			return new CityWithoutNFC(train);
		case TEST:
			return new ColorAndNFCTest(train);
		case MTEST:
			return new MagTest(train);
		case CNTEST:
			return new ColorAndNFCTest(train);
		case CTEST:
			return new ColorTest(train);
		case DUMMY:
			return new DummyState(train);
		case NTEST: 
			return new NFCTest(train);
		default:
			StateActivator.getLogger().log(LogService.LOG_WARNING, "Could not find train state " + state);
			break;
		}
		return null;
	}
	
	
}
