package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator;

import java.util.HashMap;

import org.osgi.framework.BundleContext;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.ColorConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.MagConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;

public class SensorConfiguratorController implements TrainSensorConfiguratorController {
	
	private ColorConfigurator color;
	private MagConfigurator mag;
	private BundleContext context;
	
	public SensorConfiguratorController(BundleContext context) {
		this.context = context;
		color = new ColorConfigurator(context);
		mag = new MagConfigurator(context);
	}
	
	public void configureSensor(HashMap<SensorConfigurationOption, Object> properties, PublisherType type){
		switch (type) {
		case SLEEPER:
			color.configure(properties);
			break;
		case MAG:
			mag.configure(properties);
			break;
		default:
			break;
		}
	}

	@Override
	public void configureSensor(SensorConfigurationOption property, Object value, PublisherType type) {
		switch (type) {
		case SLEEPER:
			color.configure(property,value);
			break;
		case MAG:
			mag.configure(property, value);
			break;
		default:
			break;
		}		
	}
}
