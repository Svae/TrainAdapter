package no.ntnu.item.its.osgi.train.adapter.handlers.color;

import org.osgi.service.event.Event;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.common.enums.EColor;
import no.ntnu.item.its.osgi.common.interfaces.ColorControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;

public class DefaultColorEventHandler implements SensorHandler{

	private EventReceiver receiver;
	
	public DefaultColorEventHandler(EventReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void handleEvent(Event e) {
		if(e.getProperty(ColorControllerService.COLOR_KEY) == null || !(e.getProperty(ColorControllerService.COLOR_KEY) instanceof EColor)) return;
		receiver.sendColorEvent(new ColorReading((EColor) e.getProperty(ColorControllerService.COLOR_KEY)));
	}
	
	
}
