package no.ntnu.dummySensorServiceImpl;

import no.ntnu.sensorEnum.Sensor;
import no.ntnu.sensorEnum.SensorType;
import no.ntnu.sensorInterface.ISensorService;

public class DummySensorService implements ISensorService {

	private Sensor state; 
	private SensorType type;
	private int id;
	private String name;
	
	public DummySensorService() {
		state = Sensor.STARTING;
		type = SensorType.DUMMY;
		id = 1;
		
	}
	
	@Override
	public int getID() {
		return id;
	}

	@Override
	public SensorType getType() {
		return type;
	}

	@Override
	public Sensor getState() {
		return state;
	}

	@Override
	public void start() {
		System.out.println("Dummy sensor has started");
		
	}

	@Override
	public void stop() {
		System.out.println("Dummy sensor has stopped");
		
	}
	
	public String getName(){
		return name;
	}
	
	
}
