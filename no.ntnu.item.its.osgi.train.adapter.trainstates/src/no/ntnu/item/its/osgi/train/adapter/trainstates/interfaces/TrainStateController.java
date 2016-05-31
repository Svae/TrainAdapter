package no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces;

public interface TrainStateController {
	
	public enum TrainStates{
		RUNNING, STOPPED, FAILED, RUNNINGCITY, RUNNINGINNERCITY, TEST, CNTEST, CTEST, DUMMY, MTEST, NTEST;
	}
	
	public TrainState getTrainState(TrainStates state, TrainContext train);

}
