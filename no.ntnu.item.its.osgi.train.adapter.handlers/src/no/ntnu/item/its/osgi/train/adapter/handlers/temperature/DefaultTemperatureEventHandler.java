package no.ntnu.item.its.osgi.train.adapter.handlers.temperature;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;

public class DefaultTemperatureEventHandler implements SensorHandler{

	private EventReceiver receiver;
	
	public DefaultTemperatureEventHandler(EventReceiver receiver) { this.receiver = receiver;}
	
	@Override
	public void handleEvent(Event arg0) {	
	}

}
