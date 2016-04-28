package no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces;

import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.train.adapter.enums.SpeedLevel;
import no.ntnu.item.its.train.adapter.interfaces.MapRestrictions;
import no.ntnu.item.its.train.adapter.trainInfo.TrainAdapterProperties;

public interface TrainContext {

	public void setTrainState(TrainState state);
	public TrainAdapterProperties getTrainProperties();
	public void sendSpeedRestriction(SpeedLevel speed);
	public double getSpeed();
	public TrainRestrictionsChecker getTrainRestrictionChecker();
	public TrainStateController getTrainStateController();
	public MapRestrictions getMapRestrictions();
	
}
