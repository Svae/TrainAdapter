package no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionChecker;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;

public interface TrainContext {

	public void setTrainState(TrainState state);
	public void sendSpeedRestriction();
	public double getSpeed();
	public TrainRestrictionsChecker getTrainRestrictionChecker();
	public TrainStateController getTrainStateController();
	public MapRestrictionChecker getMapRestrictions();
	
}
