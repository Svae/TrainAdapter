package no.ntnu.sensorInterface;

import no.ntnu.sensorEnum.Sensor;
import no.ntnu.sensorEnum.SensorType;

public interface ISensorService {

	public int getID();
	public SensorType getType();
	public Sensor getState();
	public String getName();
	public void start();
	public void stop();
}
