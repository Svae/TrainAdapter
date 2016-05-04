package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces;

import java.util.HashMap;

import no.ntnu.item.its.osgi.common.enums.PublisherType;

public interface TrainSensorConfiguratorController {
	public void configureSensor(HashMap<String, Object> properties, PublisherType type);

}
