package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common;

import java.util.HashMap;

import no.ntnu.item.its.osgi.common.enums.PublisherType;

public class SensorReconfiguration {
	
	private PublisherType type;
	private HashMap<String, Object> properties;
	
	public SensorReconfiguration(PublisherType type, HashMap<String, Object> properties) {
		this.type = type;
		this.properties = properties;
	}

	public PublisherType getType() {
		return type;
	}

	public HashMap<String, Object> getProperties() {
		return properties;
	}
	
}
