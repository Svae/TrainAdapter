package no.ntnu.item.its.train.adapter.trainInfo;

import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class TrainInfo {
	
	private double speed = 0;
	private boolean inTurn = false;
	private double heading = Double.MAX_VALUE;
	private TrainStates state;
	private SpeedRestrictionLevel speedRestrictionLevel;
	
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
	
	
}
