package no.ntnu.item.its.osgi.train.adapter.handlers.common.readings;

public class AccelerometerReading {

	private long timestamp;
	private double x;
	private double y;
	private double z;
	
	public AccelerometerReading(long timestamp, double x, double y, double z) {
		this.timestamp = timestamp;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public AccelerometerReading(long timestamp, double x) {
		this.timestamp = timestamp;
		this.x = x;
	}
	public double getReading(){
		return x;
	}
	
}

