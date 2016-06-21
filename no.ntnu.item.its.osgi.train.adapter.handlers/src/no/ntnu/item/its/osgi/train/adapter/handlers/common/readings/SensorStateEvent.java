package no.ntnu.item.its.osgi.train.adapter.handlers.common.readings;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SensorEventType;

public class SensorStateEvent {

	private PublisherType type;
	private SensorEventType event;

	public SensorStateEvent(PublisherType type, SensorEventType event) {
		this.event = event;
		this.type = type;
	}

	public PublisherType getType() {
		return type;
	}

	public SensorEventType getEvent() {
		return event;
	}
}
