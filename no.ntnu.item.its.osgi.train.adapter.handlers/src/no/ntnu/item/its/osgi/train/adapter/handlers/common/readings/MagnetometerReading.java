package no.ntnu.item.its.osgi.train.adapter.handlers.common.readings;

public class MagnetometerReading {

	private double x, y, z;
	private long timestamp;
	private double heading;
	
	public MagnetometerReading(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public MagnetometerReading(long timestamp, double x, double y, double z, double heading){
		this.x = x;
		this.y = y;
		this.z = z;
		this.heading = heading;
		this.timestamp = timestamp;
	}
	
	public MagnetometerReading(long timestamp, double heading) {
		this.timestamp = timestamp;
		this.heading = heading;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public double[] getReading(){
		return new double[]{x,y,z};
	}
	
	public double getHeading(){
		return heading;
	}
	
	public long getTimestamp(){
		return timestamp;
	}
	
}
