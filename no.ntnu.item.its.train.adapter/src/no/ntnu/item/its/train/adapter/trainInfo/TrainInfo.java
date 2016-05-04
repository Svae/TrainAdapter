package no.ntnu.item.its.train.adapter.trainInfo;

public class TrainInfo {
	
	private double speed = 0;
	private boolean inTurn = false;
	private double heading = Double.MAX_VALUE;
	
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
	
	
}
