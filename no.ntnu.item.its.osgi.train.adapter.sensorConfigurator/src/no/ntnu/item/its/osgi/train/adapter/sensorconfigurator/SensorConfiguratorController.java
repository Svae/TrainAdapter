package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator;

import java.util.HashMap;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.ColorConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;

public class SensorConfiguratorController implements TrainSensorConfiguratorController {
	
	private ColorConfigurator color;
	
	public SensorConfiguratorController() {
		color = new ColorConfigurator();
	}
	
	public void configureSensor(HashMap<String, Object> properties, PublisherType type){
		switch (type) {
		case SLEEPER:
			color.configure(properties);
			break;
		default:
			break;
		}
	}
}
