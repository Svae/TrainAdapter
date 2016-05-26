package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator;

import java.util.HashMap;

import org.osgi.framework.BundleContext;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.ColorConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.MagConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.MifareConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.SensorConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;

public class SensorConfiguratorController implements TrainSensorConfiguratorController {
	
	private ColorConfigurator color;
	private MagConfigurator mag;
	private MifareConfigurator mifare;
	private BundleContext context;
	
	public SensorConfiguratorController(BundleContext context) {
		this.context = context;
		color = new ColorConfigurator(context);
		mag = new MagConfigurator(context);
		mifare = new MifareConfigurator(context);
	}
	
	public void configureSensor(HashMap<SensorConfigurationOption, Object> properties, PublisherType type){
		getConfigurator(type).configure(properties);
	}

	@Override
	public void configureSensor(SensorConfigurationOption property, Object value, PublisherType type) {
		getConfigurator(type).configure(property, value);
	}

	private SensorConfigurator getConfigurator(PublisherType type){
		switch (type) {
			case SLEEPER:
				return color; 
			case MAG:
				return mag;
			case BEACON:
				return mifare;
			default:
				return null;
			}
	}
	@Override
	public long getPublish(PublisherType type) {
		return getConfigurator(type).getPublishRate();
	}

	@Override
	public long getDefaultPublishRate(PublisherType type) {
		return getConfigurator(type).getDefaultPublishRate();
	}
}
