package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces;

import java.util.HashMap;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;

public interface TrainSensorConfiguratorController {
	public void configureSensor(HashMap<SensorConfigurationOption, Object> properties, PublisherType type);
	public void configureSensor(SensorConfigurationOption property, Object value, PublisherType type);
	public long getPublishRate(PublisherType type);
	public long getDefaultPublishRate(PublisherType type);
	public Status getPublisherStatus(PublisherType type);

}
