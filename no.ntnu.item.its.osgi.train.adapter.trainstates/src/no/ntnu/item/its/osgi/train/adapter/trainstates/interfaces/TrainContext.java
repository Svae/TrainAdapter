package no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionChecker;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public interface TrainContext {

	public void setTrainState(TrainStates state);
	public void sendSpeedRestriction(SpeedRestrictionLevel level);
	public double getSpeed();
	public TrainRestrictionsChecker getTrainRestrictionChecker();
	public TrainStateController getTrainStateController();
	public MapRestrictionChecker getMapRestrictions();
	public TrainSensorConfiguratorController getSensorConfigurator();
	public boolean isInTurn();
	public void setInturn(boolean b);
	public void increaseSpeedForTurn();
	public void decreaseSpeedForTurn();
	
}
