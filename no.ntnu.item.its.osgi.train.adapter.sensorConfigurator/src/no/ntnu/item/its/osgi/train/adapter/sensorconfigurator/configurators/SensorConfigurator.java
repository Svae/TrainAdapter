package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import java.util.HashMap;

import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;

public interface SensorConfigurator {
	
	public void configure(HashMap<SensorConfigurationOption, Object> properties);
	public void configure(SensorConfigurationOption property, Object value);
	public long getPublishRate();
	public long getDefaultPublishRate();

}
