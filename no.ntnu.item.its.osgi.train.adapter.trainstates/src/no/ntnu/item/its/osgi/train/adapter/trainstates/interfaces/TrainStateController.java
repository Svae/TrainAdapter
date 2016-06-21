package no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces;

public interface TrainStateController {
	
	public enum TrainStates{
		RUNNING, STOPPED, FAILED, CITY, INNERCITY, RUNNINGNFC, CITYNFC, INNERCITYNFC,
		TEST, CNTEST, CTEST, DUMMY, MTEST, NTEST;
	}
	
	public TrainState getTrainState(TrainStates state, TrainContext train);

}
