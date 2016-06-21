package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common;

import no.ntnu.item.its.osgi.common.enums.PublisherType;

public class SensorReconfiguration {
	
	private PublisherType type;
	private SensorConfigurationOption option;
	private Object value;
	
	public SensorReconfiguration(PublisherType type, SensorConfigurationOption option, Object value) {
		this.type = type;
		this.option = option;
		this.value = value;
	}

	public PublisherType getType() {
		return type;
	}

	public SensorConfigurationOption getOption() {
		return option;
	}

	public Object getValue() {
		return value;
	}

}
