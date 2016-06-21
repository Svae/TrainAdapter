package no.ntnu.item.its.train.adapter.trainInfo;

import java.util.HashMap;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class TrainInfo {
	
	private double speed = 0;
	private boolean inTurn = false;
	private double heading = Double.MAX_VALUE;
	private TrainStates state;
	private SpeedRestrictionLevel speedRestrictionLevel;
	private String currentLocationID = "00000000";
	private HashMap<PublisherType, Status> sensorStatus = new HashMap<>();
	private SleeperColor sleeperColor;
	
	public void setSensorStatus(PublisherType type, Status status){
		sensorStatus.put(type, status);
	}
	
	public Status getSensorStaus(PublisherType type){
		return sensorStatus.get(type);
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public boolean isInTurn() {
		return inTurn;
	}
	public void setInTurn(boolean inTurn) {
		this.inTurn = inTurn;
	}
	public double getHeading() {
		return heading;
	}
	public void setHeading(double heading) {
		this.heading = heading;
	}
	
	public TrainStates getTrainState() {
		return state;
	}
	
	public void setTrainState(TrainStates state){
		this.state = state;
	}
	public SpeedRestrictionLevel getSpeedRestrictionLevel() {
		return speedRestrictionLevel;
	}
	public void setSpeedRestrictionLevel(SpeedRestrictionLevel speedRestrictionLevel) {
		this.speedRestrictionLevel = speedRestrictionLevel;
	}
	public String getCurrentLocationID() {
		return currentLocationID;
	}
	public void setCurrentLocationID(String currentLocationID) {
		this.currentLocationID = currentLocationID;
	}

	public SleeperColor getLastSleeperColor() {
		return sleeperColor;
	}

	public void setLastSleeperColor(SleeperColor sleeperColor) {
		this.sleeperColor = sleeperColor;
	}
	
	
}
