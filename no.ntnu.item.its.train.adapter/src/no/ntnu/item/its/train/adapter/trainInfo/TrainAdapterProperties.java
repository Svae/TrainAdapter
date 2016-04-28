package no.ntnu.item.its.train.adapter.trainInfo;

import java.util.LinkedList;

import no.ntnu.item.its.osgi.sensors.common.enums.EColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;

public class TrainAdapterProperties {

	private int trainID;
	private TrackPosition position;
	private int trainLength;
	
	private double speed;
	private TrainDirection direction;
	private TrainStatus status;
	private LinkedList<EColor> sleepers;
	private LinkedList<String> nfcReadings;
	
	public TrainAdapterProperties(int trainID) {
		this.trainID = trainID;
		sleepers = new LinkedList<EColor>();
	}

	public int getTrainID(){
		return trainID;
	}
	
	public TrackPosition getPosition() {
		return position;
	}

	public void setPosition(TrackPosition position) {
		this.position = position;
	}

	public int getTrainLength() {
		return trainLength;
	}

	public void setTrainLength(int trainLength) {
		this.trainLength = trainLength;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public TrainDirection getDirection() {
		return direction;
	}

	public void setDirection(TrainDirection direction) {
		this.direction = direction;
	}

	public TrainStatus getStatus() {
		return status;
	}

	public void setStatus(TrainStatus status) {
		this.status = status;
	}

	public EColor getLastSleeperColor() {
		return sleepers.getLast();
	}

	public void newSleeper(ColorReading sleeper) {
		sleepers.add(sleeper.getReading());
	}
	
	public void newNFCreading(NFCReading hex){
		nfcReadings.add(hex.getReading());
	}

}
