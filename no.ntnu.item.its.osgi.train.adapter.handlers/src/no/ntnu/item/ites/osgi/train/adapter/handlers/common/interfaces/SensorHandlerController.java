package no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces;

import no.ntnu.item.its.osgi.sensors.common.enums.PublisherType;

public interface SensorHandlerController {

	public SensorHandler getSensorHandler(PublisherType type, EventReceiver receiver);
}
