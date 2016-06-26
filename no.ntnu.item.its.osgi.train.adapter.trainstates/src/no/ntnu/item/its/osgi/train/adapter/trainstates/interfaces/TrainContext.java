package no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapChecker;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public interface TrainContext {

	public void setTrainState(TrainStates state);
	public TrainStates getCurrentTrainState();
	public void stopTrain();
	public void sendSpeedRestriction(SpeedRestrictionLevel level);
	public SpeedRestrictionLevel getSpeedRestrictionLevel();
	public double getSpeed();
	public TrainRestrictionsChecker getTrainRestrictionChecker();
	public TrainStateController getTrainStateController();
	public MapChecker getMapRestrictions();
	public boolean isInTurn();
	public void setInturn(boolean b);
	public void increaseSpeedForTurn();
	public void decreaseSpeedForTurn();
	public double getHeading();
	public void setHeading(double heading);
	public String getCurrentLocationID();
	public void setCurrentLocationID(String locationID);
	public Status getSensorState(PublisherType type);
	public void setSensorState(PublisherType type, Status status);
	public void reconfigureSensor(SensorReconfiguration reconfiguration);
	public void setLastSleeperColor(SleeperColor color);
	public SleeperColor getLastSleeperColor();
	
}
