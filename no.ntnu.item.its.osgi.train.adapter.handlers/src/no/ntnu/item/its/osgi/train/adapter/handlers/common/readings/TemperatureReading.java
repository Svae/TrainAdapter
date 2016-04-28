package no.ntnu.item.its.osgi.train.adapter.handlers.common.readings;

public class TemperatureReading {

	private double temp;
	
	public TemperatureReading(double temp) {
		this.temp = temp;
	}
	
	public double getReading(){
		return temp;
	}
}
