package no.ntnu.item.its.train.adapter.enums;

public enum SpeedLevel {
	
	LOW(15), NORMAL(30);
	
	int speed;
	
	private SpeedLevel(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed(){
		return speed;
	}

}
